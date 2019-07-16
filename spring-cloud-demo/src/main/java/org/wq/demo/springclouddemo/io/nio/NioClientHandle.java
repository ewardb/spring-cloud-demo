package org.wq.demo.springclouddemo.io.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 16:35 2018/11/21
 */
public class NioClientHandle implements Runnable{

    private String host;

    private int port;

    private Selector selector;

    private SocketChannel socketChannel;

    private volatile boolean started;


    public NioClientHandle(String ip, int port){
        this.host = ip;
        this.port = port;

        try{
            //创建监听器
            selector = Selector.open();
            //打开监听器
            socketChannel = SocketChannel.open();
            //如果为true 则 此通道备置于 阻塞模式，如果false  非阻塞模式
            socketChannel.configureBlocking(false); //  开启非阻塞模式
            started = true;
        }catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }
    }

    @Override
    public void run() {
        try{
            doConnect();
        }catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        //循环遍历 selector
        while(started){
            try{
                //无论是否有读写事件，selector每隔1s被唤醒一次
//                selector.select(1000);
                //阻塞 只有当至少有一个事件注册的时候，才会继续
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                SelectionKey key = null;
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while(iterator.hasNext()){
                    SelectionKey next = iterator.next();
                    iterator.remove();
                    handle(next);
                }
            }catch (Exception e){

            }
        }
    }

    private void handle(SelectionKey key) throws Exception {
        if(key.isValid()){
            SocketChannel channel = (SocketChannel)key.channel();
            if(key.isConnectable()){
                if(channel.finishConnect()){

                }else{
                    System.exit(0);
                }
            }
            //读消息
            if(key.isReadable()){
                //创建一个buffer 开闭一个1M的缓冲区
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                //读取请求码流，返回读取的字节数
                int readBytes = channel.read(buffer);
                if(readBytes>0){
                    //将缓冲区当前的limit设置为position=0， 用于后续对缓冲区读取操作
                    buffer.flip();
                    //根据缓冲区读字节数创建字节数组
                    byte[] bytes = new byte[buffer.remaining()];
                    //将缓冲区可读取字节数创建字节数组
                    buffer.get(bytes);
                    String result = new String(bytes, "UTF-8");
                    System.out.println("客户端接收消息："+ result);
                }else if(readBytes ==0 ){

                }else {
                    key.cancel();
                    socketChannel.close();
                }
            }
        }
    }


    public void stop(){
        started = false;
    }

    public void doConnect() throws Exception{
        if(socketChannel.connect(new InetSocketAddress(host, port))){

        }else{
             socketChannel.register(selector, SelectionKey.OP_CONNECT);
        }
    }


    public void sendMsg(String msg){
        try{
            socketChannel.register(selector, SelectionKey.OP_READ);
            dowrite(socketChannel, msg);
        }catch (Exception e){

        }
    }

    private void dowrite(SocketChannel socketChannel, String request) {
        try{
            //将消息编码为字节数组
            byte[] bytes = request.getBytes();
            //根据数据容量创建bytebuffer
            ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
            //将字节数组复制到 缓冲区
            buffer.put(bytes);
            buffer.flip();
            socketChannel.write(buffer);
        }catch (Exception e){

        }






    }


}
