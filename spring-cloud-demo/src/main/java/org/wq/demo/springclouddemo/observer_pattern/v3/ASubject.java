package org.wq.demo.springclouddemo.observer_pattern.v3;


import java.util.ArrayList;
import java.util.List;
/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 10:49 2018/11/9
 */
public class ASubject implements Subject {


    private List<Observer> obs=new ArrayList<>();


    @Override
    public void addObserver(Observer observer) {
        obs.add(observer);
    }

    @Override
    public void remoteObserver(Observer observer) {
        obs.remove(observer);
    }

    @Override
    public void notifying(List<String> args) {
        obs.forEach(ob -> ob.listen(args));
    }


}
