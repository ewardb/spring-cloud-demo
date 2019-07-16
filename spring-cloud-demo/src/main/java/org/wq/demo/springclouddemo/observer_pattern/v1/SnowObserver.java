package org.wq.demo.springclouddemo.observer_pattern.v1;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 21:13 2018/11/8
 */
public class SnowObserver implements Observer {




    @Override
    public void doing() {
        System.out.println("我只管下雪--------------ssaasasasasasasaa");
        return ;
    }

    @Override
    public void done() {
        System.out.println("我要 下雪了-----------saasasasasasasaa--下完了-------------->-");
        return ;
    }
}
