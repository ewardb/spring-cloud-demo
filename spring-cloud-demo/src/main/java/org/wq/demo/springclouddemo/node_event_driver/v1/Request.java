package org.wq.demo.springclouddemo.node_event_driver.v1;

import lombok.Data;

import java.util.HashMap;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 19:43 2018/11/12
 */
@Data
public class Request {

    private String subject;

    private HashMap<String, String> params;



}
