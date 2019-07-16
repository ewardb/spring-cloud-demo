package org.wq.demo.springclouddemo.node_event_driver.v3.product_consumer;

import org.wq.demo.springclouddemo.node_event_driver.v3.CommonSubject;
import org.wq.demo.springclouddemo.node_event_driver.v3.factory.SubjectFactory;

import java.util.HashMap;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 10:30 2018/11/13
 */
public class HandleRequestThread implements Runnable  {

    //注册事件
    CommonSubject commonSubject = SubjectFactory.getSubject();

    @Override
    public void run() {
        Request request = null;
        HashMap<String, String> response =null;
        while(true){
            synchronized (Lock.ob){
                if(RequestQueue.requests.size() != 0)
                request = RequestQueue.get();
            }
            try{
                if(request != null){
                    System.out.print("thread:"+ Thread.currentThread().getId() +" name:"+Thread.currentThread().getName());
                    System.out.println("    弹出请求："  +request);
                    String subject = request.getSubject();
                    HashMap<String, String> params = request.getParams();
                    response = commonSubject.post("response", subject, params);
                    commonSubject.post("callback", subject, response);
                    Thread.sleep(10000);
                }
            }catch (Exception e){
                System.out.println(e);
            }
            request = null;
        }
    }
}
