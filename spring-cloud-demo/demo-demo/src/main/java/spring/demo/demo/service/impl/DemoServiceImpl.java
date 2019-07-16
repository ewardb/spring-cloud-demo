package spring.demo.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.demo.demo.dao.AttendanceMapper;
import spring.demo.demo.domain.Attendance;
import spring.demo.demo.service.DemoService;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 14:54 2018/10/25
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private AttendanceMapper attendanceMapper;

    @Override
    @Transactional
    public Integer sign(Long userId) {
        Integer result = 0;
        try {
            Attendance attendance = new Attendance(userId);
            result = attendanceMapper.insert(attendance);
            System.out.println("start" + "userIdc:"+userId+"ing");
            Thread.sleep(30000);
            System.out.println("stop" + "userIdc:"+userId+"存储成功");
//            Random random = new Random();
//            int i = random.nextInt(10000);
//            Thread.sleep(i);
//            if(i>5000){
//                System.out.println("sleep:"+i + "userIdc:"+userId+"存储失败");
//                System.out.println("sleep:"+i + "userIdc:"+userId+"存储成功");
////                throw new RuntimeException("时间太长了啊。。。。。。");
//            } else{
//                System.out.println("sleep:"+i +"userIdc:"+userId+"存储成功") ;
//            }
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {

        }
        return result;
    }
}
