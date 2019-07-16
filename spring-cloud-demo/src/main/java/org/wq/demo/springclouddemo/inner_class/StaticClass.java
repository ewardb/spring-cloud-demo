package org.wq.demo.springclouddemo.inner_class;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 19:00 2019/6/10
 */
public class StaticClass {

    /**
     * 静态内部类也是定义在另一个类里面的类，只不过在类的前面多了一个关键字static。
     * 静态内部类是不需要依赖于外部类的，这点和类的静态成员属性有点类似，并且它不能使用外部类的非static成员变量或者方法，
     */

    private String out;

    static String saticPro;


    static class inner{
        void getOut(){
            System.out.println("这里面是获取不到out 的这个属性的");
            System.out.println(saticPro   +" 能访问到  staticPro ");
        }
    }

    public static void main(String[] args) {
        inner inner = new StaticClass.inner();
    }
}
