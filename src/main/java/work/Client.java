package work;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public Socket socket;
    public Client(){

        try {
            System.out.println("正在连接服务端...");
            socket = new Socket("localhost",8088);
            System.out.println("与服务器建立连接!...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start(){
       try(
               PrintWriter pw = new PrintWriter(
                       new BufferedWriter(
                               new OutputStreamWriter(
                                       socket.getOutputStream(),"UTF-8"
                               )
                       ),true
               );
               ){
           pw.println("你好服务端！");
           socket.getOutputStream();
       } catch(Exception e){
           e.printStackTrace();
       }
        }

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }
        }
