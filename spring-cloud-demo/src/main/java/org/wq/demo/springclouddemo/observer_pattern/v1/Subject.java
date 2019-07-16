package org.wq.demo.springclouddemo.observer_pattern.v1;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 21:14 2018/11/8
 */
public interface Subject<T extends Observer> {

    void notify(T t);

    void notify_All();

}
