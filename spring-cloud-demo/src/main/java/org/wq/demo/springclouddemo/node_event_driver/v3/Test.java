package org.wq.demo.springclouddemo.node_event_driver.v3;

import org.wq.demo.springclouddemo.node_event_driver.v3.product_consumer.HandleRequestThread;
import org.wq.demo.springclouddemo.node_event_driver.v3.product_consumer.Lock;
import org.wq.demo.springclouddemo.node_event_driver.v3.product_consumer.Request;
import org.wq.demo.springclouddemo.node_event_driver.v3.product_consumer.RequestQueue;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 10:26 2018/11/13
 */
public class Test {

    public static class T implements Runnable{
        @Override
        public void run() {
            try{
                Random random = new Random();
                while(true){
                    int i = random.nextInt(50);
                    Thread.sleep(i);
                    HashMap<String, String> params = new HashMap<>();
                    params.put(i+"", i+"");
                    params.put(i+"oo", i+"00");
                    Request request = new Request();

                    String[] inters = {"/a", "/b", "/c", "/d", "/e"};
                    int index = random.nextInt(5);
                    request.setSubject(inters[index]);
                    request.setParams(params);
                    synchronized (Lock.ob){
                        RequestQueue.addRequest(request);
//                        System.out.println("请求入队列："+request + "-----------------------------------");
                    }
                }
            }catch (Exception e){

            }
        }
    }



    public static void main(String[] args) {

        //产生请求队列
        ExecutorService requestThread = Executors.newFixedThreadPool(10);
        for(int i = 0  ; i<10 ; i++){
            requestThread.submit(new T());
        }
        requestThread.shutdown();
        //处理请求
        ExecutorService handleThreads = Executors.newFixedThreadPool(10);
        for(int i = 0  ; i<10 ; i++){
            handleThreads.submit(new HandleRequestThread());
        }
        handleThreads.shutdown();







//
//        Thread requestThread1 = new Thread(() -> {
//            try{
//                Random random = new Random();
//                while(true){
//                    int i = random.nextInt(1000);
////                    System.out.println(System.currentTimeMillis());
//                    Thread.sleep(i);
////                    System.out.println(System.currentTimeMillis());
//                    HashMap<String, String> params = new HashMap<>();
//                    params.put(i+"", i+"");
//                    params.put(i+"oo", i+"00");
//                    Request request = new Request();
//
//                    String[] inters = {"/a", "/b", "/c", "/d", "/e"};
//                    int index = random.nextInt(5);
//                    request.setSubject(inters[index]);
//                    request.setParams(params);
//                    synchronized (Lock.ob){
//                        RequestQueue.addRequest(request);
//                        System.out.println("请求入队列："+request + "-----------------------------------");
//                    }
//                }
//            }catch (Exception e){
//
//            }
//        });
//        HandleRequestThread handleThread1 = new HandleRequestThread();
//        Thread thread1 = new Thread(handleThread1);
//        HandleRequestThread handleThread2 = new HandleRequestThread();
//        Thread thread2 = new Thread(handleThread2);
//        //启用线程
//        requestThread1.start();
//        thread1.start();
//        thread2.start();

    }




}
