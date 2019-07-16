package org.wq.demo.springclouddemo.threadlocal;

import java.util.Date;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 16:55 2018/11/16
 */
public class ThreadLocalTest {


    /**
     * https://www.jianshu.com/p/1ff73d2d7520
     *
     * ThreadLocal的作用即是：
     * 在每个线程中存储一个变量的副本，这样在每个线程对该变量进行使用的使用，使用的即是该线程的局部变量，从而保证了线程的安全性以及高效性。
     * 在并发编程中时常有这样一种需求：每条线程都需要存取一个同名变量，但每条线程中该变量的值均不相同。
     *
     *
     * 简单说  ( sync 是线程间数据共享， 而threadLocal 用于线程间数据的隔离)
     * 实现原理，
     *
     */
    public static ThreadLocal<Date> threadLocal = new ThreadLocal<>();


    public static InheritableThreadLocal<Date> inheritableThreadLocal = new InheritableThreadLocal<>();






}
