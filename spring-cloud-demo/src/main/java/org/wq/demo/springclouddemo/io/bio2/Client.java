package org.wq.demo.springclouddemo.io.bio2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @desc 阻塞式I/O创建的客户端
 * @Date 20:26 2018/11/20
 */
public class Client {

    //port
    private static int port = 8888;


    //address
    private static String serverAddress = "127.0.0.1";


    public static void send(String express){
        PrintWriter out = null;
        BufferedReader in = null;
        Socket socket = null;
        try{
            socket = new Socket(serverAddress, port);
            System.out.println("表达式为："+express);

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
//            Thread.sleep(1000);
            out.println(express);

            System.out.println("结果为:"+in.readLine()+ "   结束时间为："+ System.currentTimeMillis());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            if(in != null){
                try{
//                    in.close();
                }catch (Exception e){

                }
            }
            if(out != null){
//                out.close();
            }
            if(socket != null){
                try{
//                    socket.close();
                }catch (Exception e){

                }
            }
        }




    }



















}
