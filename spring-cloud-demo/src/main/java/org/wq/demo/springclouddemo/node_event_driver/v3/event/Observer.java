package org.wq.demo.springclouddemo.node_event_driver.v3.event;

import java.util.HashMap;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 19:28 2018/11/12
 */
public interface Observer {

    void handle(String data);

    HashMap<String, String> handle(HashMap<String, String> params);

    void error(String data);


    HashMap<String, String> response(HashMap<String, String> params);

    String callback(String code, String data);

}
