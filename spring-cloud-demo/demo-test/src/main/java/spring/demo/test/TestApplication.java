package spring.demo.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 14:48 2018/10/25
 */
@EnableFeignClients
@SpringBootApplication
@EnableEurekaClient
public class TestApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }





}
