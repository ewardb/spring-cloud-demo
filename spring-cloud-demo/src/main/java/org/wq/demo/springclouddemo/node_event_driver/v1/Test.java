package org.wq.demo.springclouddemo.node_event_driver.v1;

import java.util.HashMap;
import java.util.Random;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 10:26 2018/11/13
 */
public class Test {


    public static void main(String[] args) {

        //产生请求的队列
        Thread requestThread = new Thread(() -> {
            try{
                Random random = new Random();
                while(true){
                    int i = random.nextInt(10000);
                    System.out.println(System.currentTimeMillis());
                    Thread.sleep(i);
                    System.out.println(System.currentTimeMillis());
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
                    }
                }
            }catch (Exception e){

            }
        });


        //创建处理请求的线程
        HandleRequestThread handleRequestThread = new HandleRequestThread();
        Thread thread = new Thread(handleRequestThread);

        //启用线程
        requestThread.start();
        thread.start();

    }




}
