package org.wq.demo.springclouddemo.observer_pattern.v3;

import lombok.Data;
import java.util.List;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 10:44 2018/11/9
 */
@Data
public class AObserver implements Observer {


    @Override
    public void listen(List<String> ob_args) {

        ob_args.forEach(ob -> System.out.println("A ob hello" + ob));

    }
}
