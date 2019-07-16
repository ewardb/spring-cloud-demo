package org.wq.demo.springclouddemo.observer_pattern.v2;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 21:10 2018/11/8
 */
public interface Observer<T extends  Subject> {

    void listen(T subject);

}
