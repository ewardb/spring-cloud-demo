package org.wq.demo.springclouddemo.node_event_driver.v3.event;

import java.util.HashMap;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 19:37 2018/11/13
 */
public class CommonObserver implements Observer {

    @Override
    public void handle(String data) {
        return ;
    }

    @Override
    public HashMap<String, String> handle(HashMap<String, String> params) {
        return null;
    }

    @Override
    public void error(String data) {
        return ;
    }

    @Override
    public HashMap<String, String> response(HashMap<String, String> params) {
        return null;
    }

    @Override
    public String callback(String code, String data) {
        return null;
    }
}
