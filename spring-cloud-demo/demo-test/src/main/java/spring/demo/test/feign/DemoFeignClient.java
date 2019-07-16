package spring.demo.test.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 15:14 2018/10/25
 */
@FeignClient("demo-demo")
public interface DemoFeignClient {


    @RequestMapping(value = "/test", method = RequestMethod.POST)
    String test(
            @RequestParam("userId") Long userId, @RequestParam("threadId") String threadId) ;


}
