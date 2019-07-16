package org.wq.demo.springclouddemo.node_event_driver.v2.event;

import java.util.HashMap;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 15:42 2018/11/13
 */
public class Register {

    public static HashMap<String, HashMap<String, Observer>> events = new HashMap<>();

    static {
        register("response", "/a", new CommonObserver() {
            @Override
            public HashMap<String, String> handle(HashMap<String, String> params) {
                params.forEach((k, v) -> {
                    System.out.println("k: " + k + "  v:" + v + " + ");
                });
                HashMap<String, String> res = new HashMap<>();
                res.put("url", "/a");
                res.put("code", "error");
                res.put("data", "responseA");
                return res;
            }
        });
        register("callback", "/a", new CommonObserver() {
            @Override
            public void handle(String data) {
                System.out.println("收到成功消息success ====" + data);
            }

            @Override
            public void error(String data) {
                System.out.println("收到失败消息 error ====" + data);
            }
        });
        register("response", "/b", new CommonObserver() {
            @Override
            public HashMap<String, String> handle(HashMap<String, String> params) {
                params.forEach((k, v) -> {
                    System.out.println("k: " + k + "  v:" + v + " + ");
                });
                HashMap<String, String> res = new HashMap<>();
                res.put("url", "/b");
                res.put("code", "success");
                res.put("data", "responseB");
                return res;
            }
        });
        register("response", "/c", new CommonObserver() {
            @Override
            public HashMap<String, String> handle(HashMap<String, String> params) {
                params.forEach((k, v) -> {
                    System.out.println("k: " + k + "  v:" + v + " + ");
                });
                HashMap<String, String> res = new HashMap<>();
                res.put("url", "/c");
                res.put("code", "error");
                res.put("data", "responseC");
                return res;
            }
        });
        register("response", "/d", new CommonObserver() {
            @Override
            public HashMap<String, String> handle(HashMap<String, String> params) {
                params.forEach((k, v) -> {
                    System.out.println("k: " + k + "  v:" + v + " + ");
                });
                HashMap<String, String> res = new HashMap<>();
                res.put("url", "/d");
                res.put("code", "success");
                res.put("data", "responseD");
                return res;
            }
        });
        register("response", "/e", new CommonObserver() {
            @Override
            public HashMap<String, String> handle(HashMap<String, String> params) {
                params.forEach((k, v) -> {
                    System.out.println("k: " + k + "  v:" + v + " + ");
                });
                HashMap<String, String> res = new HashMap<>();
                res.put("url", "/e");
                res.put("code", "success");
                res.put("data", "responseE");
                return res;
            }
        });

        register("callback", "/b", new CommonObserver() {
            @Override
            public void handle(String data) {
                System.out.println("收到成功消息success ====" + data);
            }

            @Override
            public void error(String data) {
                System.out.println("收到失败消息 error ====" + data);
            }
        });
        register("callback", "/c", new CommonObserver() {
            @Override
            public void handle(String data) {
                System.out.println("收到成功消息success ====" + data);
            }

            @Override
            public void error(String data) {
                System.out.println("收到失败消息 error ====" + data);
            }
        });
        register("callback", "/d", new CommonObserver() {
            @Override
            public void handle(String data) {
                System.out.println("收到成功消息success ====" + data);
            }

            @Override
            public void error(String data) {
                System.out.println("收到失败消息 error ====" + data);
            }
        });
        register("callback", "/e", new CommonObserver() {
            @Override
            public void handle(String data) {
                System.out.println("收到成功消息success ====" + data);
            }

            @Override
            public void error(String data) {
                System.out.println("收到失败消息 error ====" + data);
            }
        });
    }


    public static void register(String type, String event, Observer observer) {
        if (events.get(type) != null) {
            events.get(type).put(event, observer);
        } else {
            HashMap<String, Observer> map = new HashMap<>();
            map.put(event, observer);
            events.put(type, map);
        }
    }


    public static void deregister(String event) {
        events.remove(event);
    }


}
