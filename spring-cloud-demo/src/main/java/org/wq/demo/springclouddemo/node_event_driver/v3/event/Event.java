package org.wq.demo.springclouddemo.node_event_driver.v3.event;

import java.util.HashMap;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 14:53 2018/11/14
 */
public interface Event {

    void register(Event event);

    void send(HashMap<String, String> params);

}
