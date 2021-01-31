package work;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private  Server(){
        try{
            System.out.println("正在启动服务端...");
            serverSocket = new ServerSocket(8088);
            System.out.println("启动服务端完毕！");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  void start() {
        try {
            System.out.println("等待客户端连接...");
            Socket socket = serverSocket.accept();
            System.out.println("一个客户端连接了！");
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream(), "UTF-8"
                    )
            );
            String line = br.readLine();
            System.out.println("客户端说：" + line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
    }

