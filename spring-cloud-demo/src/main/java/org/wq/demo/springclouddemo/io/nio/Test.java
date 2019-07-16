package org.wq.demo.springclouddemo.io.nio;

import java.nio.IntBuffer;
import java.util.Scanner;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 16:34 2018/11/21
 */
public class Test {


    public static void main(String[] args) {
        try{

            //运行服务器
            NioServer.main();
            //避免客户端先于服务器启动前执行代码
            Thread.sleep(100);
            //运行客户端
            NioClient.start();
            while(NioClient.sendMsg(new Scanner(System.in).nextLine())){};
        }catch (Exception e){

        }
//        IntBuffer.allocate(8).flip()

        //


    }


    /**
     *  buffer 其实是一个数据， 但
     */
    public void buffer(){
        IntBuffer.allocate(8);
    }


    /**
     * Reactor 反应堆
     */

    /**
     * selector
     * 选择器
     */
}
