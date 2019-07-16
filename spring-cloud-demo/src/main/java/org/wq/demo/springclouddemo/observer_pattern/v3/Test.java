package org.wq.demo.springclouddemo.observer_pattern.v3;

import java.util.ArrayList;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 21:38 2018/11/8
 */
public class Test {


    public static void main(String[] args){
        ASubject aSubject = new ASubject();
        aSubject.addObserver(new AObserver());
        aSubject.addObserver(new BObserver());


        ArrayList<String> strings = new ArrayList<>();
//        strings.add("a");
//        strings.add("b");
//        strings.add("c");
        aSubject.notifying(strings);


    }

}
