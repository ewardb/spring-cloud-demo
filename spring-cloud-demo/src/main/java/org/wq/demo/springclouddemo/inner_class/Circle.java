package org.wq.demo.springclouddemo.inner_class;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 18:32 2019/6/10
 */
public class Circle {


    private double radius = 0;
    public static int count =1;

    public Circle(double radius) {
        this.radius = radius;
        getDraw().drawSahpe();//必须先创建成员内部类的对象，再进行访问
    }

    private Draw getDraw(){
        return new Draw();
    }

    class Draw {    //成员内部类

        private String pri;
        public String pub;


        public void drawSahpe() {
            //成员内部类可以无条件访问外部类的所有成员属性和成员方法（包括private成员和静态成员）
            System.out.println(radius);  //外部类的private成员
            System.out.println(count);   //外部类的静态成员
    }
    }

    public static void main(String[] args) {
        Circle circle = new Circle(3.5d);
        /**
         * 成员内部类是依附外部类而存在的，也就是说，如果要创建成员内部类的对象，前提是必须存在一个外部类的对象。
         */
        //方式一：
        Draw draw = circle.new Draw();

        //方式二：
        Draw draw1 = circle.getDraw();


        draw1.drawSahpe();
    }


}
