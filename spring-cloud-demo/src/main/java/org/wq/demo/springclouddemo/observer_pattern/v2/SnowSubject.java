package org.wq.demo.springclouddemo.observer_pattern.v2;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 10:50 2018/11/9
 */
public class SnowSubject implements  Subject {


    @Override
    public void exec() {
        System.out.println("snow--------------->");
    }


}
