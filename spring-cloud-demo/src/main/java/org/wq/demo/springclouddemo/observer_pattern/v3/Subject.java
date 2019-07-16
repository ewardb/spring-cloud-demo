package org.wq.demo.springclouddemo.observer_pattern.v3;


import java.util.List;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 21:14 2018/11/8
 */
public interface Subject {


    void addObserver(Observer observer);

    void remoteObserver(Observer observer);

    void notifying(List<String> obs);


}
