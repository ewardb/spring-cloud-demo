package org.wq.demo.springclouddemo.inner_class;

import java.util.HashMap;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 20:19 2019/6/10
 */
public class Test {


    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<String, String>() {
            @Override
            public String put(String key, String val) {
                return super.put("str", "value");
            };
        };
//        hashMap.put("1", "1v");
        System.out.println(hashMap.get("str"));
        System.out.println(hashMap.get("1"));

    }
}
