package org.wq.demo.springclouddemo.lock;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 18:29 2018/11/17
 */
public class Test {


    public static void main(String[] args) {
        AlterPrintService alterPrintService = new AlterPrintService();


        new Thread(()->{
            alterPrintService.print();
        }).start();
        new Thread(()->{
            alterPrintService.printElse();
        }).start();
    }

}
