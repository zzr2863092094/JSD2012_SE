package socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 聊天室客户端
 */
public class Client {
    private Socket socket;
    //构造方法，用来初始化客户端
    public Client(){
        try {
            /*
              java.net.Socket 套接字
              Socket封装了TCP协议的通讯细节，使用它可以和远端
              计算机建立连接，并通过它获取一个输入流和一个输出流，
              使用这两个流的读写数据完成与远端计算机的交互。

              实例化Socket时需要传入两个参数：
              1：服务端的地址信息(IP地址)
                 通过地址可以找到网络上服务端的计算
              2：服务端打开的服务端口
                 通过这个端口可以找到服务端计算机运行的服务端应用程序。
             */
            System.out.println("正在连接服务端...");
            //localhost表示本机IP
            //实例化的过程就是连接过程，若链接服务端失败会抛出异常
            socket = new Socket("localhost",8088);
            System.out.println("与服务器建立连接！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      //客户端开始的工作方法
    public void start(){
        try (
                PrintWriter pw = new PrintWriter(
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        socket.getOutputStream(),"UTF-8"
                                )
                        ),true
                );
                ){
            //通过输出流给服务端发送一句话
            pw.println("你好服务端！");
            /*
               Socket提供的方法
               OutputStream getOutStream()
               该方法会返回
             */

            socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }
}
