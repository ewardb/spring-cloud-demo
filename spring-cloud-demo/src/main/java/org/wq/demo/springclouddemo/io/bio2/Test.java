package org.wq.demo.springclouddemo.io.bio2;

import java.util.Random;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 20:43 2018/11/20
 */
public class Test {

    public static void main(String[] args) {


        //运行服务端
        new Thread(()->{
            try{
//                ServerNormal.start();
                ServerBetter.start();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }).start();
        try {
            Thread.sleep(1000);
        }catch (Exception e){

        }
        //运行客户端
        char operators[] = {'+','-','*','/'};
        Random random = new Random(System.currentTimeMillis());
        new Thread(new Runnable() {
            @SuppressWarnings("static-access")
            @Override
            public void run() {
                while(true){
                    //随机产生算术表达式
                    String expression = random.nextInt(10)+""+operators[random.nextInt(4)]+(random.nextInt(10)+1);
                    Client.send(expression);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }


        }).start();
    }












}
