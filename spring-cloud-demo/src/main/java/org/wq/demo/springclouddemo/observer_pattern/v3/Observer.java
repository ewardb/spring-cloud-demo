package org.wq.demo.springclouddemo.observer_pattern.v3;

import java.util.List;
/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 21:10 2018/11/8
 */
public interface Observer {

    void listen(List<String> ob_args);

}
