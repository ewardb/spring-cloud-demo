package org.wq.demo.springclouddemo.observer_pattern.v2;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 10:49 2018/11/9
 */
public class RainSubject implements Subject {
    @Override
    public void exec() {
        System.out.println("rain------------------");
    }
}
