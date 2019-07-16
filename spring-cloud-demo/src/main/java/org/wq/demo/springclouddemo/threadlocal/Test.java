package org.wq.demo.springclouddemo.threadlocal;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Date;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 16:58 2018/11/16
 */
public class Test {


    public static void main1(String[] args) {
        // 1 2 3
        // channel ---> buffer
        // buffer  ---> channel

        //Buffer
        try{
            RandomAccessFile rw = new RandomAccessFile("a.txt", "rw");
            FileChannel channel = rw.getChannel();

            //create buffer with capacity of 48 bytes
            ByteBuffer buffer = ByteBuffer.allocate(48);
            int read = channel.read(buffer);//read into buffer.

//          channel.write(buffer) 写进channel
            while (read != -1){
                buffer.flip();
                while (buffer.hasRemaining()){
                    System.out.println(buffer.get());
                }
                buffer.clear();
                read = channel.read(buffer);
            }
            channel.close();
        }catch (Exception e){

        }

//4
        //Scatter 分散 vs Gather 聚集
//        ByteBuffer header = ByteBuffer.allocate(128);
//        ByteBuffer body   = ByteBuffer.allocate(1024);
//        ByteBuffer[] bufferArray = { header, body };
//        channel.read(bufferArray);
        //将channel的数据读到 buffer中

//        ByteBuffer header = ByteBuffer.allocate(128);
//        ByteBuffer body   = ByteBuffer.allocate(1024);
//        //write data into buffers
//        ByteBuffer[] bufferArray = { header, body };
//        channel.write(bufferArray);
        //将header、body的数据  写进channel


        //5
        //通道之间的数据传输
        try{
            RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
            FileChannel fromChannel = fromFile.getChannel();

            RandomAccessFile writeFile = new RandomAccessFile("toFile.txt", "rw");
            FileChannel toChannel = writeFile.getChannel();

            long position = 0 ;
            long size = fromChannel.size();
            //将 fromChanner的数据 传入 toChannel
            toChannel.transferFrom(fromChannel, position, size);

            //fromChanner的数据 传入 toChannel
            fromChannel.transferTo(position, size, toChannel);

        }catch (Exception e){

        }

//Selector   是用selector 就需要selector注册channel
//             线程         selector         channel
//              1                1            n
//        try {
//            DatagramChannel networkChannel = new DatagramChannel() {
//                @Override
//                public DatagramChannel bind(SocketAddress local) throws IOException {
//                    return null;
//                }
//
//                @Override
//                public <T> DatagramChannel setOption(SocketOption<T> name, T value) throws IOException {
//                    return null;
//                }
//
//                @Override
//                public DatagramSocket socket() {
//                    return null;
//                }
//
//                @Override
//                public boolean isConnected() {
//                    return false;
//                }
//
//                @Override
//                public DatagramChannel connect(SocketAddress remote) throws IOException {
//                    return null;
//                }
//
//                @Override
//                public DatagramChannel disconnect() throws IOException {
//                    return null;
//                }
//
//                @Override
//                public SocketAddress getRemoteAddress() throws IOException {
//                    return null;
//                }
//
//                @Override
//                public SocketAddress receive(ByteBuffer dst) throws IOException {
//                    return null;
//                }
//
//                @Override
//                public int send(ByteBuffer src, SocketAddress target) throws IOException {
//                    return 0;
//                }
//
//                @Override
//                public int read(ByteBuffer dst) throws IOException {
//                    return 0;
//                }
//
//                @Override
//                public long read(ByteBuffer[] dsts, int offset, int length) throws IOException {
//                    return 0;
//                }
//
//                @Override
//                public int write(ByteBuffer src) throws IOException {
//                    return 0;
//                }
//
//                @Override
//                public long write(ByteBuffer[] srcs, int offset, int length) throws IOException {
//                    return 0;
//                }
//
//                @Override
//                public SocketAddress getLocalAddress() throws IOException {
//                    return null;
//                }
//
//                @Override
//                public MembershipKey join(InetAddress group, NetworkInterface interf) throws IOException {
//                    return null;
//                }
//
//                @Override
//                public MembershipKey join(InetAddress group, NetworkInterface interf, InetAddress source) throws IOException {
//                    return null;
//                }
//
//                @Override
//                public <T> T getOption(SocketOption<T> name) throws IOException {
//                    return null;
//                }
//
//                @Override
//                public Set<SocketOption<?>> supportedOptions() {
//                    return null;
//                }
//
//                @Override
//                protected void implCloseSelectableChannel() throws IOException {
//
//                }
//
//                @Override
//                protected void implConfigureBlocking(boolean block) throws IOException {
//
//                }
//            };
//            Selector selector = Selector.open();
//
//            //将channel注册到selector上
//            SelectionKey selectionKey = networkChannel.register(selector, SelectionKey.OP_ACCEPT);
//
//            //selectorKey 选择channel
//            SelectableChannel channel = selectionKey.channel();
//            //selectorKey  选择  selector
//            Selector selector1 = selectionKey.selector();
//            selectionKey.attach(new Object());//添加附加信息  用作标识
//
//            while (selector.select() == 0 ) {
//                continue;
//            }
//            //selector 选择
//            int select = selector.select();  //返回的 int值 表示 有多少 channel 已经就绪
//            //如果 select 大于 0   ， 可以用selector.selectedKeys() 取出那些 准备好的channel 然后去遍历
//            Set<SelectionKey> selectionKeys = selector.selectedKeys();
//            Iterator keyIterator = selectionKeys.iterator();
//            while(keyIterator.hasNext()){
//                SelectionKey next = (SelectionKey)keyIterator.next();
//                if(next.isAcceptable()){
//                    // a connection was accepted by a ServerSocketChannel.
//                }else if(next.isConnectable()){
//                    // a connection was established with a remote server.
//                }else if(next.isReadable()){
//                    // a channel is ready for reading
//                }else if(next.isWritable()){
//                    // a channel is ready for writing
//                }
//                keyIterator.remove();
//            }
//        }catch (Exception e){
//
//        }

        //FileChannel 文件通道， 可以通过文件通道读写文件   无法运行在非阻塞模式下 只能运行在阻塞模式下
        //SocketChannel
        //ServerSocketChannel
        //java nio DataGramChannel
        //Pipe


        //java io 与 nio 的区别
        //java   io                 nio
//              面向流             面向缓冲
        //      阻塞IO            非阻塞IO
        //      无                 选择器


//面向流与面向缓冲：
//        java nio 与 io之间 最大的区别 是   io是面向流的 nio是面向缓冲的。。javaio 面向流 意味着每次从流中读一个或多个字节   直至读取所有字节，他们没有被缓存在任何地方。
// 此外他不能以后移动流中的数据。如果需要前后移动从流中读取的数据，需要先将他缓存到一个缓冲区。javanio的缓冲导向方法略有不同。数据读取到一个他稍后处理的缓冲区，需要时可在缓冲区中前后移动。
// 这就增加了处理过程中的灵活性，但是，还是需要检查是否该缓冲区中包含所有您需要处理的数据。而且，徐确保当更更多的数据读入缓冲区时，不要覆盖缓冲区中尚未处理的数据


//阻塞与非阻塞
//        javaio的各种流是阻塞的。这意味着，当一个线程调用read write 时，该线程被阻塞了。直到有一些数据被读取或被写入。该线程在此期间不能在做别的事情了。。。javanio的非阻塞模式，
// 使一个线程从某通道发送请求读取数据 ，但是他仅能得到目前可用的数据，如果没有数据可用湿，就什么都不会获取。而不是保持线程阻塞。所以直至数据变的可以读取之前，该线程可以继续做其他事情。
// 非阻塞写也是如此，一个线程请求写入些数据到某通道，但不需要等待他完全写入，这个线程同时可以做别的事情。线程通常将非阻塞io的空闲时间用在其他通道上执行io操作。所以一个单独的线程可以管理多个输入和输出通道


        // 选择器

//        javanio的选择器允许一个单独的线程来件事多个输入通道。你可以注册多个通道使用一个选择器。然后使用一个单独的线程 来选择通道，这些通道里已经有可以处理的输入，或者选择已经准备好的通道
// 这种选择机制，使得一个单独的线程很容易来管理多个通道。







    }


    public static void main(String[] args) {
        ThreadLocal<String> threadLocalOld = new ThreadLocal<String>(){
            @Override
            protected String initialValue() {
                return new String("dsadsa");
            }
        };
        ThreadLocal<Date> stringThreadLocal = new ThreadLocal<>();

        new Thread(() -> {
            System.out.println("Hi Idoit      " + stringThreadLocal.get());}).start();


        Thread thread = new Thread(()->{
            String s = threadLocalOld.get();//每个线程调度get函数获取本线程的副本。
            // do sth
            System.out.println(Thread.currentThread().getName() + "    " +s);
            threadLocalOld.set("dsad");// set函数set的值，只会设置本线程的值，不会对其他线程有任何影响。
            System.out.println(Thread.currentThread().getName() + "    " +threadLocalOld.get());
        });
        Thread thread1 = new Thread(()->{
            String s = new String("dsadsa");//ThreadLocal效果定义local variable类似。
            // do sth
            System.out.println(Thread.currentThread().getName() + "    " +threadLocalOld.get());
        });
        thread.start();
        thread1.start();
        try {
            Thread.sleep(100);
        }catch (Exception e){}





//        try{
//            ThreadLocalTest.inheritableThreadLocal.set(new Date());
//            Thread.sleep(1000);
//
//            Thread thread = new Thread(new T1());
//            thread.start();
//            Thread.sleep(10000);
//
//            Thread thread1 = new Thread(new T2());
//            thread1.start();
//        }catch (Exception e){
//
//        }
    }



}
