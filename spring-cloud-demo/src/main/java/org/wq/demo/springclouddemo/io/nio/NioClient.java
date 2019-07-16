package org.wq.demo.springclouddemo.io.nio;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 16:35 2018/11/21
 */
public class NioClient {


    private static String HOST = "127.0.0.1";

    private static int PORT = 8888;

    private static NioClientHandle nioClientHandle;

    public static synchronized void start(){
        start(HOST, PORT);
    }

    public static synchronized void start(String ip,int port){
        if(nioClientHandle!=null)
            nioClientHandle.stop();
        nioClientHandle = new NioClientHandle(ip,port);
        new Thread(nioClientHandle,"Server").start();
    }


    public static boolean sendMsg(String msg){
        if(msg.equals("q")){
            return false;
        }
        nioClientHandle.sendMsg(msg);
        return true;
    }



}
