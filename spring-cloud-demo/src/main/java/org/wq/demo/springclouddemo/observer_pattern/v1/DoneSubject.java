package org.wq.demo.springclouddemo.observer_pattern.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 21:32 2018/11/8
 */
public class DoneSubject implements Subject {

    public static List<Observer> list=new ArrayList<>();

    static {
        Random random = new Random();
        for(int i = 0; i< 10 ; i++){
            int ran = random.nextInt(100);
            if(ran%2==0){
                RainObserver rainObserver = new RainObserver();
                list.add(rainObserver);
            }else{
                SnowObserver snowObserver = new SnowObserver();
                list.add(snowObserver);
            }
        }
    }


    @Override
    public void notify(Observer observer) {
        observer.done();
    }

    @Override
    public void notify_All() {
        if(list != null){
            list.forEach(li -> li.done());
        }
    }

}
