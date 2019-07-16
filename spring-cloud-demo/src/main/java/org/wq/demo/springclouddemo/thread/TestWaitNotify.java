package org.wq.demo.springclouddemo.thread;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 14:13 2018/11/16
 */
public class TestWaitNotify {


    public static void main(String[] args) {
        Object o = new Object();
        WaitThread waitThread = new WaitThread();
        waitThread.setOb(o);
        WaitThread waitThread1 = new WaitThread();
        waitThread1.setOb(o);
        NotifyThread notifyThread = new NotifyThread();
        notifyThread.setOb(o);
        new Thread(waitThread).start();
        new Thread(waitThread1).start();
        new Thread(notifyThread).start();


    }


}
