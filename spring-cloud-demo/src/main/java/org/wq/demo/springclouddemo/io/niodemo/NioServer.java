package org.wq.demo.springclouddemo.io.niodemo;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 15:32 2019/6/7
 */
public class NioServer {




    private int port = 8080;

    private InetSocketAddress addres = null;


    private Selector selector;

    public NioServer(int port){
        try{
            this.port = port ;
            addres = new InetSocketAddress(this.port);

            ServerSocketChannel server = ServerSocketChannel.open();

            server.bind(addres);
            //default 阻塞  手动设置非阻塞
            server.configureBlocking(false);
            Selector selector = Selector.open();

            //op  option的简称
            server.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("服务器 准备就绪" + this.port);


        }catch (Exception e){

        }

    }


    public void listen(){
        try{
            while (true){
                //有多少人在排队
                int wait = this.selector.select();
                if(wait == 0 ) continue;;

                Set<SelectionKey> keys = this.selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    process(key);
                    iterator.remove();
                }

            }
        } catch (Exception e){

        }
    }



    public void process(SelectionKey key){
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try{
            if(key.isAcceptable()){
                ServerSocketChannel server = (ServerSocketChannel)key.channel();
                SocketChannel socketChannel = server.accept();
                socketChannel.configureBlocking(false);
                socketChannel.register(selector, SelectionKey.OP_READ);
            }else if(key.isReadable()){
                SocketChannel socketChannel = (SocketChannel)key.channel();

                int len = socketChannel.read(buffer);
                if(len >0){
                    buffer.flip();
                    String content = new String(buffer.array(), 0 ,len);
                    System.out.println("收到的string" + content);
                    socketChannel.register(selector, SelectionKey.OP_WRITE);
                }

                buffer.clear();

            }else  if(key.isWritable()){
                SocketChannel socketChannel = (SocketChannel)key.channel();
                socketChannel.write(ByteBuffer.wrap("repley".getBytes()));
                socketChannel.close();  // 有问题  ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
            }
        }catch (Exception e){

        }

    }



    public static void main(String[] args) {
        new NioServer(8080).listen();
    }

}
