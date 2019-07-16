package org.wq.demo.springclouddemo.node_event_driver.v1;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 19:28 2018/11/12
 */
public interface Observer {

    void success(String data);

    void error(String data);

}
