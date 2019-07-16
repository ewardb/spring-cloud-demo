package org.wq.demo.springclouddemo.io.nio;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 16:35 2018/11/21
 */
public class NioServer {

    private static int PORT = 8888;

    private static NioServerHandle nioServerHandle;

    public static void main(){
        start(PORT);
    }

    synchronized public static void start(int port){
        if(nioServerHandle == null){
            NioServerHandle nioServerHandle = new NioServerHandle(port);
            new Thread(nioServerHandle, "nioServer").start();
        }
    }









}
