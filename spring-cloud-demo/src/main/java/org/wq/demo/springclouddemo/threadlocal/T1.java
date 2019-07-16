package org.wq.demo.springclouddemo.threadlocal;

import java.util.Date;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 16:57 2018/11/16
 */
public class T1 implements Runnable {
    @Override
    public void run() {
        try {
            if(ThreadLocalTest.threadLocal.get() ==null){
                ThreadLocalTest.threadLocal.set(new Date());
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() +"       "+ThreadLocalTest.threadLocal.get());
            }else{
                System.out.println("buweinull");
            }
            if(ThreadLocalTest.inheritableThreadLocal.get()==null){
                System.out.println("----------------");
            }else{
                System.out.println(Thread.currentThread().getName() +"       "+"我是从父线程继承下来的哈哈哈哈----"+ ThreadLocalTest.inheritableThreadLocal.get());
            }
        }catch (Exception e){

        }
    }
}
