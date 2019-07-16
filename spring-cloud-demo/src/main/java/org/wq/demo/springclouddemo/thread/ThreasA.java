package org.wq.demo.springclouddemo.thread;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 15:04 2018/11/15
 */
public class ThreasA extends Thread {

    boolean  isRunning = true;
    public boolean isRunning(){
        return isRunning;
    }
    public void setRunning(boolean isRunning){
        this.isRunning = isRunning;
    }
    @Override
    public void run(){
        System.out.println("into Run method");
        while(isRunning == true){
//            System.out.println("-------------");
            //此处进行循环
        }
        System.out.println("The thread have already shutdown");
    }


}

