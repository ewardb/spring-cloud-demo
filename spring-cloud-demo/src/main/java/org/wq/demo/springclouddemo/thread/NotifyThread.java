package org.wq.demo.springclouddemo.thread;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 14:12 2018/11/16
 */
public class NotifyThread implements Runnable{

    private Object ob;

    public void setOb(Object ob) {
        this.ob = ob;
    }

    @Override
    public void run() {

        try{
            for(int i = 0 ; i< 100 ; i++){
                synchronized (ob){
                    if(i==5){
                        System.out.println("notify before");
                        ob.notifyAll();
                        System.out.println("notify post");
                    }
                    System.out.println(i);
                    Thread.sleep(100);
                }
            }
        }catch (InterruptedException e){}
    }
}
