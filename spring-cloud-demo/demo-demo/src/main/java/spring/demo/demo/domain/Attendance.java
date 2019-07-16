package spring.demo.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 21:20 2018/10/25
 */
@Data
@NoArgsConstructor
public class Attendance {

    private Long id;

    private Long userId;

    private Date openTime;

    private Date closeTime;

    private Integer yn;

    public Attendance(Long userId){
        this.userId = userId;
    }

}
