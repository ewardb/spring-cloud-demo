package org.wq.demo.springclouddemo.observer_pattern.v2;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 21:38 2018/11/8
 */
public class Test {


    public static void main(String[] args) {
        new AObserver().listen(new RainSubject());
    }

}
