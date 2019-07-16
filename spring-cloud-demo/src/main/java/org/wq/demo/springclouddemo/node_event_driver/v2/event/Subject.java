package org.wq.demo.springclouddemo.node_event_driver.v2.event;

import java.util.HashMap;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 19:30 2018/11/12
 */
public interface Subject {

    HashMap<String, String> post(String type, String subject, HashMap<String, String> params) ;


//    void posth(String type, String subject, String response) ;

//    void poste(String type, String subject, String response) ;
}
