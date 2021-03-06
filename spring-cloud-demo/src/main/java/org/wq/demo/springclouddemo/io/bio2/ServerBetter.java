package org.wq.demo.springclouddemo.io.bio2;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 21:07 2018/11/20
 */
public class ServerBetter {




    private static int PORT = 8888;

    private static ServerSocket serverSocket;

   private static ExecutorService executorsService = Executors.newFixedThreadPool(2);




    public static void start() throws Exception{
        start(PORT);
    }

    synchronized public static void start(int port) throws Exception{

        if(serverSocket != null){
            return ;
        }

        try{
            //创建serverSocket  监听端口为port
            //如果端口合法空闲，服务端就监听成功
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("server 开启成功：端口为："+ port);

            Socket socket;
            //通过无限循环，监听客户端请求
            while(true){
                socket = serverSocket.accept();
                System.out.println("接收到请求：时间为："+ System.currentTimeMillis());
                executorsService.execute(new ServerHandle(socket));
            }
        }catch (Exception e){

        }finally {
            if(serverSocket != null){
                System.out.println("server stop");
                serverSocket.close();
                serverSocket = null;
            }
        }
    }





}
