package org.wq.demo.springclouddemo.lock;

import org.apache.catalina.startup.Tomcat;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 18:22 2018/11/17
 */
public class AlterPrintService {


    private ReentrantLock reentrantLock = new ReentrantLock();

    private Condition condition =  reentrantLock.newCondition();

    private boolean flag = true;

    public void print(){

        try{
            reentrantLock.lock();
            while (flag){
                condition.await();
            }
            System.out.println("print going-------------------");
            flag = true;
            condition.signal();
        }catch (Exception e){

        }finally {
            reentrantLock.unlock();
        }
    }

    public void printElse(){
        try{
            reentrantLock.lock();
            while(!flag){
                condition.await();
            }
            System.out.println("printElse going-------------------");
            flag = false;
            condition.signal();
        }catch (Exception e){

        }finally {
            reentrantLock.unlock();
        }
    }

}
