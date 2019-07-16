package spring.demo.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 20:59 2018/10/24
 */
@EnableEurekaClient
@SpringBootApplication
@MapperScan(basePackages="spring.demo.demo.dao")
public class DemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }



}
