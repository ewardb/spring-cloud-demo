package org.wq.demo.springclouddemo.observer_pattern.v2;

import lombok.Data;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 10:44 2018/11/9
 */
@Data
public class AObserver implements  Observer {



    @Override
    public void listen(Subject subject){
        subject.exec();
    }
}
