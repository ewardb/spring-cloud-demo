package org.wq.demo.springclouddemo.node_event_driver.v2.factory;

import org.wq.demo.springclouddemo.node_event_driver.v2.CommonSubject;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 15:57 2018/11/13
 */
public class SubjectFactory {


    public static CommonSubject getSubject(){
        return new CommonSubject();
    }



}
