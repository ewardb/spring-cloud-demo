package spring.demo.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 20:54 2018/10/24
 */
@EnableEurekaServer
@SpringBootApplication
public class SCApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SCApplication.class, args);
        System.out.println("aaaa");
        System.out.println("fdfdfafasfadsfdasfadsf");
    }

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(SCApplication.class);
//    }




}
