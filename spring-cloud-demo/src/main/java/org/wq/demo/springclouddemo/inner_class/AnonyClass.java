package org.wq.demo.springclouddemo.inner_class;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 18:59 2019/6/10
 */
public class AnonyClass {


    /**
     * 匿名内部类应该是平时我们编写代码时用得最多的，在编写事件监听的代码时使用匿名内部类不但方便，而且使代码更加容易维护
     *
     *
     *
     *
     *
     */

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });  //这就是匿名内部类的一个实例
    }
}
