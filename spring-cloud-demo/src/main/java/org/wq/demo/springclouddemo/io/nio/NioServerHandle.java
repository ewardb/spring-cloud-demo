package org.wq.demo.springclouddemo.io.nio;

import org.wq.demo.springclouddemo.io.Calculator;

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
 * @Date 16:35 2018/11/21
 */
public class NioServerHandle implements Runnable{


    private Selector selector;

    private ServerSocketChannel serverChannel;

    private volatile boolean started;

    public NioServerHandle(int port){
        try{
            //创建selector 选择器
            selector = Selector.open();
            //打开监听通道
            serverChannel = ServerSocketChannel.open();
            //如果为 true，则此通道将被置于阻塞模式；如果为 false，则此通道将被置于非阻塞模式
            serverChannel.configureBlocking(false);//开启非阻塞模式
            serverChannel.socket().bind(new InetSocketAddress(port),1024); //socket 绑定端口
            serverChannel.register(selector, SelectionKey.OP_ACCEPT); //将channel注册到selector上  并设置感兴趣的事件
            started = true;
            System.out.println("服务端端口" + port);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }


    public void stop(){
        started = false;
    }

    @Override
    public void run() {

        while (started){
            try{
                int select = selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while(iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    try{
                        handle(key);
                    }catch (Exception e){
                        e.printStackTrace();
                        e.getMessage();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
                e.getMessage();
            }
        }
        if(selector != null){
            try{
                selector.close();
            }catch (Exception e){
                e.printStackTrace();
                e.getMessage();
            }
        }
    }

    public void handle(SelectionKey selectionKey){
        if(selectionKey.isValid()){
            System.out.println("isValid---------------------------------------------------------------->");
            try{
                if(selectionKey.isAcceptable()) {
                    System.out.println("isAcceptable---------------------------------------------------------------->");
                    ServerSocketChannel ssc = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel accept = ssc.accept();
                    accept.configureBlocking(false);
                    accept.register(selector, SelectionKey.OP_READ);
                }
                if(selectionKey.isReadable()){
                    System.out.println("isReadable---------------------------------------------------------------->");
                    SocketChannel ssc = (SocketChannel)  selectionKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);

                    int read = ssc.read(buffer);
                    if(read > 0){
                        buffer.flip();
                        byte [] bytes = new byte[buffer.remaining()];
                        buffer.get(bytes);
                        String exp = new String(bytes, "UTF-8");
                        System.out.println("接收到 的exp ---->："+ exp);
                        String result = null;
                        try{
                            result = Calculator.Instance.cal(exp).toString();
                        }catch (Exception e){
                            e.printStackTrace();
                            e.getMessage();
                        }
                        dowrite(ssc, result);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }


    public void dowrite(SocketChannel ssc , String out){
        try {
            byte[] bytes = out.getBytes();
            ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
            byteBuffer.put(bytes); // 将bytes的数据存入 buffer中
            byteBuffer.flip(); //  flip 作用 1 为写入channel做准备   2 为get做准备
            //flip ()  固定缓冲区中的某些值，告诉缓冲区，我要开始操作了。 如果你在网缓冲区写数据， 不要在覆盖我固定以前的数据。
            //保证了 既可以读 也可以写！
            ssc.write(byteBuffer); //将bytebuffer 中的数据写进channel中   享立盈  品系生活  挺会赚呗
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }




}
