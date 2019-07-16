package org.wq.demo.springclouddemo.thread;


/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 15:12 2018/11/15
 */
public class Test {


    public static void main(String[] args) throws Exception{
        try {
            ThreasA threasA = new ThreasA();
            threasA.start();
            Thread.sleep(1000);
            threasA.setRunning(false);
            System.out.println("isRuning have already set as false");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}
