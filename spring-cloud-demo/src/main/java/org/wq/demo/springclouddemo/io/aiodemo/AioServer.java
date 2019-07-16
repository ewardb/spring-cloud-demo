package org.wq.demo.springclouddemo.io.aiodemo;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 17:18 2019/6/7
 */
public class AioServer {

    private  int port= 8080;

    public AioServer(int port){
        this.port = port;
    }


    public void listen(){
        try{
            AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open();
            server.bind(new InetSocketAddress(port));

            server.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
                @Override
                public void completed(AsynchronousSocketChannel client, Object attachment){
                     ByteBuffer buffer = ByteBuffer.allocate(1024);
                     client.read(buffer);
                     buffer.flip();
                    System.out.println(new String(buffer.array()));
                }
                @Override
                public void failed(Throwable exc, Object attachment){

                }
            });
            Thread.sleep(100000000);
        }catch (Exception e){

        }
    }

    public static void main(String[] args) {
        new AioServer(8080).listen();
    }




}
