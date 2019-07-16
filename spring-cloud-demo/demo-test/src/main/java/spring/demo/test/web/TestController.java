package spring.demo.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.demo.test.feign.DemoFeignClient;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 15:27 2018/10/25
 */
@RestController
public class TestController {


    @Autowired
    private DemoFeignClient demoFeignClient;

    @RequestMapping(value = "/multitest", method = RequestMethod.POST)
    public String multitest(
            @RequestParam String userId, @RequestParam String threadId, @RequestParam Integer count) {
        long start = System.currentTimeMillis();
        ExecutorService executors = Executors.newFixedThreadPool(count);
        for (int i = 0; i < count; i++) {
            executors.submit(new T());
        }
        executors.shutdown();
//        ArrayList<Thread> threads = new ArrayList<>();
//        for (int i = 0; i < count; i++) {
//            Thread thread = new Thread(() -> {
//                demoFeignClient.test(Thread.currentThread().getId(), Thread.currentThread().getName());
//            });
//            threads.add(thread);
//        }
//        for (Thread thread : threads) {
//            thread.start();
//        }
        long stop = System.currentTimeMillis();
        return "success" + (stop -start);
    }

    class T implements Runnable {
        @Override
        public void run() {
            demoFeignClient.test(Thread.currentThread().getId(), Thread.currentThread().getName());
        }
    }

}
