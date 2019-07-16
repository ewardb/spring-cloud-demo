package org.wq.demo.springclouddemo.node_event_driver.v2;


import lombok.Data;
import org.wq.demo.springclouddemo.node_event_driver.v2.event.Observer;
import org.wq.demo.springclouddemo.node_event_driver.v2.event.Register;
import org.wq.demo.springclouddemo.node_event_driver.v2.event.Subject;

import java.util.HashMap;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 19:30 2018/11/12
 */
@Data
public class CommonSubject implements Subject {

    private Observer observer;



//    @Override
//    public void notifyObserver(String type, String data){
//        if("success".equals(type)){
//            Register.events.get(type).success(data);
//        }else if("error".equals(type)){
//            Register.events.get(type).error(data);
//        }
//    }


    @Override
    public HashMap<String, String> post(String type, String subject, HashMap<String, String> params) {
        if ("success".equals(params.get("code"))) {
            posth(type, subject, params.get("data"));
            return null;
        } else if ("error".equals(params.get("code"))) {
            poste(type, subject, params.get("data"));
            return null;
        } else {
            return Register.events.get(type).get(subject).handle(params);
        }
    }


    private void posth(String type, String subject, String response) {
        Register.events.get(type).get(subject).handle(response);
    }

    private void poste(String type, String subject, String response) {
        Register.events.get(type).get(subject).error(response);
    }


}
