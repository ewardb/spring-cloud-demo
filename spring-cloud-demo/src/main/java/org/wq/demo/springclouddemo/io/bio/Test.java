package org.wq.demo.springclouddemo.io.bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @desc 最最最简陋的通信
 * @Date 16:00 2018/11/20
 */
public class Test {


    public static void main(String[] args) {

        try{
            new Thread(new ServerNormal()).start();
            Thread.sleep(1000);
            while (true){
                Socket socket = new Socket("0.0.0.0", 8888);

                InputStreamReader input = new InputStreamReader(System.in);
                BufferedReader inputReader = new BufferedReader(input);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                while (true){
                    String line = inputReader.readLine();
                    printWriter.println(line);
                    if(line.equals("over")){
                        break;
                    }
                    System.out.println(bufferedReader.readLine());
                }
                bufferedReader.close();
                inputReader.close();
                printWriter.close();
                socket.close();
            }
        }catch (Exception e){

        }
    }



}
