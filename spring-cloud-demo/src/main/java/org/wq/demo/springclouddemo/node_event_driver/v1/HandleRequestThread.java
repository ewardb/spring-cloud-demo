package org.wq.demo.springclouddemo.node_event_driver.v1;

import java.util.HashMap;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 10:30 2018/11/13
 */
public class HandleRequestThread implements Runnable  {



    @Override
    public void run() {
        Request request = null;
        while(true){
            synchronized (Lock.ob){
                if(RequestQueue.requests.size() != 0)
                request = RequestQueue.removeRequest();
            }

            if(request != null){
                System.out.println("弹出请求："  +request);
                String subject = request.getSubject();
                HashMap<String, String> params = request.getParams();
                //注册事件
                CommonSubject commonSubject = new CommonSubject();

                HashMap<String, String> response =null;
                switch (subject){
                    case "/a":
                        System.out.println("/a-------------------------------------------------------------------------"+subject);
                        commonSubject.setName(subject);
                        commonSubject.setObserver(new CommonObserver());
                        response =ResponseForRequest.responseA(subject, params);
                        commonSubject.notifyObserver(response.get("code"), response.get("data"));
                        break;
                    case "/b":
                        System.out.println("/b-------------------------------------------------------------------------"+subject);
                        commonSubject.setName(subject);
                        commonSubject.setObserver(new CommonObserver());
                        response = ResponseForRequest.responseB(subject, params);
                        commonSubject.notifyObserver(response.get("code"), response.get("data"));
                        break;
                    case "/c":
                        System.out.println("/c-------------------------------------------------------------------------"+subject);
                        commonSubject.setName(subject);
                        commonSubject.setObserver(new CommonObserver());
                        response = ResponseForRequest.responseC(subject, params);
                        commonSubject.notifyObserver(response.get("code"), response.get("data"));
                        break;
                    case "/d":
                        System.out.println("/d-------------------------------------------------------------------------"+subject);
                        commonSubject.setName(subject);
                        commonSubject.setObserver(new CommonObserver());
                        response = ResponseForRequest.responseD(subject, params);
                        commonSubject.notifyObserver(response.get("code"), response.get("data"));
                        break;
                    case "/e":
                        System.out.println("/e-------------------------------------------------------------------------"+subject);
                        commonSubject.setName(subject);
                        commonSubject.setObserver(new CommonObserver());
                        response = ResponseForRequest.responseE(subject, params);
                        commonSubject.notifyObserver(response.get("code"), response.get("data"));
                        break;
                    default:
                        System.out.println("/default-------------------------------------------------------------------------"+subject);
                        break;
                }
            }
            request = null;
        }
    }
}
