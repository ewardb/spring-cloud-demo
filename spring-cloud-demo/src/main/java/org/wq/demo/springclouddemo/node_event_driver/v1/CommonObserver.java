package org.wq.demo.springclouddemo.node_event_driver.v1;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 19:29 2018/11/12
 */
public class CommonObserver implements Observer {


    @Override
    public void success(String data) {
        System.out.println("收到成功消息success ===="+ data);
    }

    @Override
    public void error(String data) {
        System.out.println("收到失败消息 error ===="+ data);
    }
}
