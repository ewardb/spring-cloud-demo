package org.wq.demo.springclouddemo.node_event_driver.v1;

import java.util.LinkedList;
/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 19:42 2018/11/12
 */
public class RequestQueue {


    public  static LinkedList<Request> requests = new LinkedList<>();

    public static void addRequest(Request request){
        requests.push(request);
    }

    public static Request removeRequest(){
        return requests.removeFirst();
    }



}
