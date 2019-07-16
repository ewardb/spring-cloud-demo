package org.wq.demo.springclouddemo.thread;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 14:11 2018/11/16
 */
public class WaitThread implements Runnable {

    private Object ob;

    public void setOb(Object ob) {
        this.ob = ob;
    }


    @Override
    public void run() {
        try{

            synchronized (ob){
                if(true){
                    ob.wait();
                    System.out.println("收到通知");
                }
            }
        }catch (Exception e){}
    }
}
