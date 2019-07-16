package org.wq.demo.springclouddemo.io.bio2;

import lombok.Data;
import org.wq.demo.springclouddemo.io.Calculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 20:10 2018/11/20
 */
@Data
public class ServerHandle extends Thread{


    private Socket socket;


    public ServerHandle(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        super.run();
        BufferedReader in = null;
        PrintWriter out = null;
        try{
            System.out.println("执行线程："+ Thread.currentThread());
//            System.out.println("有客户端链接："+socket.getInetAddress().getHostName());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            String expression;
            String result = "";
            while (true){
                System.out.println("ppppppppppppppppppppppppppp");
                if((expression = in.readLine()) != null){
                    try{
                        result = Calculator.Instance.cal(expression).toString();
                    }catch (Exception e){
                        result = e.getMessage();
                    }
                    out.println(result);
                }else{
//                    System.out.println("over!!!!!");
                    break;
                }

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            if(in != null){
                try{
                    //in.close();
                }catch (Exception e){

                }
            }
            if(out != null){
                //out.close();
            }
            if(socket != null){
                try{
                    //socket.close();
                }catch (Exception e){

                }
            }
        }
    }
}
