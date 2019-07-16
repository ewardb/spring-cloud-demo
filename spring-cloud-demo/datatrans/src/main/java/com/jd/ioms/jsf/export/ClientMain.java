package com.jd.ioms.jsf.export;

import com.jd.ioms.jsf.export.domain.ExportResult;
import com.jd.ioms.jsf.export.domain.OrderDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 16:00 2019/1/8
 */
public class ClientMain {
    private final static Logger LOGGER = LoggerFactory.getLogger(ClientMain.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:spring-config-saf-consumer.xml");
        OrderMiddlewareJSFService service = (OrderMiddlewareJSFService) appContext.getBean("orderMiddlewareJSFService");
        LOGGER.info("得到调用端代理：{}", service);
        while (true) {
            try {
                Long orderNu = 82801650738L;
                ExportResult<List<OrderDetail>>  result = service.getOrderDetailListByOrderId(82801650738L);
                LOGGER.info("response msg from server :{}", result);
            } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }
    }
// JSFContext.destroy();
    }
}
