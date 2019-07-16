package org.wq.demo.springclouddemo.node_event_driver.v1;


import lombok.Data;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 19:30 2018/11/12
 */
@Data
public class CommonSubject implements Subject {



    private String name;

    private Observer observer;


    public CommonSubject() {
    }

    public CommonSubject(String name, Observer observer) {
        this.name = name;
        this.observer = observer;
    }




    public void notifyObserver(String type, String data){
        if("success".equals(type)){
            observer.success(data);
        }else if ("error".equals(type)){
            observer.error(data);
        }else{

        }
    }


}
