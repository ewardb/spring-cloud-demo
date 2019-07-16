package org.wq.demo.springclouddemo.node_event_driver.v3.event;

import lombok.Data;

import java.util.HashMap;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 15:16 2018/11/14
 */
@Data
public class CommonEvent implements Event {

    private String name;

    private HashMap<String, String> params;

    private Observer observer;

    public CommonEvent(String name, Observer observer, HashMap<String,String> params){
        this.name = name ;
        this.params = params;
        this.observer = observer;
    }


    @Override
    public void register(Event event) {
    }

    @Override
    public void send(HashMap<String, String> params) {
        HashMap<String, String> response = observer.response(params);
        observer.callback(response.get("code"), response.get("data"));
    }
}
