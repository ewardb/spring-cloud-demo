package org.wq.demo.springclouddemo.produce_comcumer;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 15:28 2018/11/16
 */
public class ProducerThread extends Thread {

    private Object ob;

    public void setOb(Object ob) {
        this.ob = ob;
    }

    @Override
    public void run(){
        System.out.println("生产---------");
        synchronized (ob){

        }
    }


}
