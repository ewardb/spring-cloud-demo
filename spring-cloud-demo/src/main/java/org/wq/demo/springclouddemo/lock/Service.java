package org.wq.demo.springclouddemo.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 16:49 2018/11/17
 */
public class Service {



    private ReentrantLock reentrantLock = new ReentrantLock();

    private Condition condition = reentrantLock.newCondition();

    public void await(){
        try {
            reentrantLock.lock();
            condition.await();
        }catch (InterruptedException e){

        }
    }
}
