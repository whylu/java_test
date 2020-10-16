package test.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TimeServer {
    static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {

        ServerSocket server=null;
        try {
            server=new ServerSocket(8080);
            System.out.println("TimeServer Started on 8080...");
            while (true){
                Socket client = server.accept();
                //每次接收到一个新的客户端连接，启动一个新的线程来处理
                executorService.submit(new TimeServerHandler(client));
//                new Thread(new TimeServerHandler(client)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
