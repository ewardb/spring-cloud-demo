package org.wq.demo.springclouddemo.inner_class;

import java.util.ArrayList;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 19:05 2019/6/10
 */
public class DeepUnderstandInnerClass {




    public void test(final int a) {
        new Thread(){
            @Override
            public void run() {
                System.out.println(a);
            };
        }.start();
    }

    /**
     * https://www.runoob.com/w3cnote/java-inner-class-intro.html
     */
    //https://blog.csdn.net/shenhaiyushitiaoyu/article/details/84142618
    // 解析  new A(){{}}  new Runable(){}   new HashMap(){} 内部原理

    // new A(){{}}   vs  new HashMap(){} 都是匿名子类， 前者在初始化时已经执行， 后者只有调用才执行
    public static void main(String[] args) {
        new DeepUnderstandInnerClass().test(444);

        new ArrayList<String>(){
            @Override
            public boolean add(String s) {
                return super.add(s);
            }
        };

        new ArrayList<String>(){{
            add("str");
        }};
    }


}
