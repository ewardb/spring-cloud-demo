package org.wq.demo.springclouddemo.observer_pattern.v1;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 21:11 2018/11/8
 */
public class RainObserver implements Observer {
    @Override
    public void doing() {
        System.out.println("我只管下雨----------huahuahuahuahua----");
        return ;
    }

    @Override
    public void done() {
        System.out.println("我要下雨了-------huahuahuahuahua-------下完了-------------->");
    }
}
