package spring.demo.demo.feign;

import feign.Feign;
import feign.jackson.JacksonDecoder;

/**
 * @author zhangjianbin
 */
public class FeignClientUtils {


    public static <T> T getDefaultClient(Class<T> client, String url) {
        return Feign.builder()
                .decoder(new JacksonDecoder())
                .target(client, url);
    }

    /**
     * 获取feign 客户端
     *
     * @param client
     * @param url
     * @param <T>
     * @return
     */
//    public static <T> T getClient(Class<T> client, String url) {
//        return Feign.builder()
//                .logger(new Slf4jLogger(client))
//                .logLevel(feign.Logger.Level.FULL)
//                .encoder(new JacksonEncoder())
//                .decoder(new JacksonDecoder())
//                .target(client, url);
//    }
//
//    public static <T> T getDefaultClient(Class<T> client, String url) {
//        return Feign.builder()
//                .logger(new Slf4jLogger(client))
//                .logLevel(feign.Logger.Level.FULL)
//                .encoder(new JacksonEncoder())
//                .target(client, url);
//    }
}
