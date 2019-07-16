package org.wq.demo.springclouddemo.observer_pattern.v1;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 21:38 2018/11/8
 */
public class Test {


    public static void main(String[] args) {
        //单播
//        Random random = new Random();
//        for(int i = 0 ; i<100 ; i++){
//            int randomInt = random.nextInt(100);
//            if(randomInt%4==0){
//                DoingSubject doingSubject = new DoingSubject();
//                doingSubject.notify(new RainObserver());
//            }else if(randomInt%4==1){
//                DoneSubject doingSubject = new DoneSubject();
//                doingSubject.notify(new RainObserver());
//            }else if(randomInt%4==2){
//                DoingSubject doingSubject = new DoingSubject();
//                doingSubject.notify(new SnowObserver());
//            }else if(randomInt%4==3){
//                DoneSubject doingSubject = new DoneSubject();
//                doingSubject.notify(new SnowObserver());
//            }
//        }

        //广播
        DoingSubject doingSubject = new DoingSubject();
        doingSubject.notify_All();

        DoneSubject doneSubject = new DoneSubject();
        doneSubject.notify_All();






    }

}
