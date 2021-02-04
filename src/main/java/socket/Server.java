package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * 聊天室服务端
 */
public class Server {
    /*
        java.net.ServerSocket
        ServerSocket是运行在服务端的。它主要有两个作用
        1:向系统申请并打开服务端口，客户端可以通过这个端口与服务端
          建立连接。
        2:监听服务端口，一旦一个客户端通过该端口与服务端建立连接则
          会创建一个Socket，通过它与客户端进行交互。

        如果我们把Socket比喻为电话，那么ServerSocket就相当于总机。
     */
    private ServerSocket serverSocket;
    //用来保存所有客户端输出的数组，用于让ClientHandler之间共享输出流广播消息使用
    //  private PrintWriter[] allOut = {};
    private Collection<PrintWriter> allOut = new ArrayList<>();

    public Server() {
        try {
            /*
                实例化ServerSocket是要指定服务端口，如果该端口
                已经被系统其他程序使用时，会抛出异常:
                java.net.BindException:address already in use
                此时需要更换一个端口再尝试启动，或者将占用该端口的
                程序关闭后再尝试启动当前程序.
             */
            System.out.println("正在启动服务端...");
            serverSocket = new ServerSocket(8088);
            System.out.println("启动服务端完毕!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            /*
                ServerSocket提供的方法:
                Socket accept()
                该方法是一个阻塞方法，调用后程序就"卡住"了，此时开始
                等待客户端的连接，一旦一个客户端建立连接，此时accept
                方法会立即返回一个Socket实例，通过这个Socket就可以与
                连接的客户端进行交互了。
             */
            while (true) {
                System.out.println("等待客户端连接...");
                Socket socket = serverSocket.accept();
                System.out.println("一个客户端连接了!");
                //启动一个线程处理与客户的交互
                Runnable handler = new ClientHandler(socket);
                Thread t = new Thread(handler);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    private class ClientHandler implements Runnable {
        private Socket socket;
        private String host;//当前客户端的IP地址信息

        public ClientHandler(Socket socket) {
            this.socket = socket;
            //通过socket获取远端计算机地址信息
            host = socket.getInetAddress().getHostAddress();
        }

        public void run() {
            PrintWriter pw = null;

            try {
                 /*
                    Socket提供的方法:
                    InputStream getInputStream()
                    通过socket获取的输入流可以读取远端计算机发送过来的数据
                 */
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(
                        in, "UTF-8");
                BufferedReader br = new BufferedReader(isr);

                //通过socket获取输出流用于给客户端发消息
                pw = new PrintWriter(
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        socket.getOutputStream(), "UTF-8")
                        ), true
                );

                //将当前对应客户的输出流存入到共享数组allOut中，以便广播消息

                //synchronized (this){
                // 不行，每个线程都运行自己的ClientHandler,this就是这些ClientHandler
                //synchronized (allOut){
                //不行，因为同步块中有扩容数组操作，allOut对象指向的数组对象在变化

                // synchronized (serverSocket){  //可以
                synchronized (Server.class) {  //可以

                    //1先对allOut数组扩容
            //        allOut = Arrays.copyOf(allOut, allOut.length + 1);
                    //2将当前pw放到数组最后一个位置
                   // allOut[allOut.length - 1] = pw;
            //       allOut[allOut.length - 1] = pw;
                    allOut.add(pw);
                }

                       allOut.add(pw);
                System.out.println(host + "上线了！当前人数：" + allOut.size());

                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(host + "说:" + line);
                    synchronized (Server.class) {
                        //将消息发送给所有客户端
                        for (PrintWriter o : allOut) {
                            o.println(host + "说：" + line);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                //处理该客户断开连接后的操作
                //将对应当前客户的输出流从共享数组allOut中删除
                synchronized (Server.class) {
//                        for (int i = 0; i < allOut.length; i++)
//                            if (pw == allOut[i]) {
//                                allOut[i] = allOut[allOut.length - 1];
//                                allOut = Arrays.copyOf(allOut, allOut.length - 1);
//                                break;
//                            }
//                    }
                    allOut.remove(pw);
                }
                    //System.out.println(host + "下线了！当前在线人数：" + allOut.length);
                    System.out.println(host + "下线了！当前在线人数：" + allOut.size());
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
