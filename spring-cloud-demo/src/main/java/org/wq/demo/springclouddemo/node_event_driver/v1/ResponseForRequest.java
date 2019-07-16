package org.wq.demo.springclouddemo.node_event_driver.v1;

import java.util.HashMap;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 10:26 2018/11/13
 */
public class ResponseForRequest {


    public static HashMap<String, String> responseA(String sub, HashMap<String, String> params){
        System.out.println("responseA    sub" + sub);
        params.forEach((k, v) -> {
            System.out.println("k: "  + k +"  v:" + v + " + ");
        });
        HashMap<String, String> res = new HashMap<>();
        res.put("url", sub);
        res.put("code", "success");
        res.put("data", "responseA");
        return res;
    }


    public static HashMap<String, String> responseB(String sub, HashMap<String, String> params){
        System.out.println("responseB   sub" + sub);
        params.forEach((k, v) -> {
            System.out.println("k: "  + k +"  v:" + v + " + ");
        });
        HashMap<String, String> res = new HashMap<>();
        res.put("url", sub);
        res.put("code", "success");
        res.put("data", "responseB");
        return res;
    }

    public static HashMap<String, String> responseC(String sub, HashMap<String, String> params){
        System.out.println("responseC   sub" + sub);
        params.forEach((k, v) -> {
            System.out.println("k: "  + k +"  v:" + v + " + ");
        });
        HashMap<String, String> res = new HashMap<>();
        res.put("url", sub);
        res.put("code", "error");
        res.put("data", "responseC");
        return res;
    }

    public static HashMap<String, String> responseD(String sub, HashMap<String, String> params){
        System.out.println("responseD   sub" + sub);
        params.forEach((k, v) -> {
            System.out.println("k: "  + k +"  v:" + v + " + ");
        });
        HashMap<String, String> res = new HashMap<>();
        res.put("url", sub);
        res.put("code", "success");
        res.put("data", "responseD");
        return res;
    }

    public static HashMap<String, String> responseE(String sub, HashMap<String, String> params){
        System.out.println("responseE  sub" + sub);
        params.forEach((k, v) -> {
            System.out.println("k: "  + k +"  v:" + v + " + ");
        });
        HashMap<String, String> res = new HashMap<>();
        res.put("url", sub);
        res.put("code", "error");
        res.put("data", "responseE");
        return res;
    }



}
