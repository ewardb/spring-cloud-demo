package org.wq.demo.springclouddemo.io.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 16:02 2018/11/20
 */
public final class ServerNormal implements Runnable{

    //默认端口
    private static int PORT = 8888;

    //单例的ServerSocket
    private static ServerSocket serverSocket;


    public static void start() throws IOException {
        start(PORT);
    }

    synchronized public static void start(int port) throws IOException{
        if(serverSocket != null) {
            return ;
        }

        try{
            ServerSocket serverSocket = new ServerSocket(port);

            Socket socket = serverSocket.accept();
            System.out.println(socket.getInetAddress().getCanonicalHostName() +"链接成功");
            InputStream inputStream = socket.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            String line = null;
            while((line = bufferedReader.readLine()) != null){
                System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa");
                if(line.equals("over")){
                    break;
                }
//                System.out.println(line);
                printWriter.println(line);
            }
            printWriter.close();
            bufferedReader.close();
            socket.close();
            System.out.println(socket.getInetAddress().getHostAddress() + "断开连接");
        }catch (Exception e){

        }finally {

        }
    }


    @Override
    public void run() {
        try{

            ServerNormal.start();
        }catch (Exception e){

        }
    }
}
