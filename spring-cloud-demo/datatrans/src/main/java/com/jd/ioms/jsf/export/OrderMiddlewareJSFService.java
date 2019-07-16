package com.jd.ioms.jsf.export;


import com.jd.ioms.jsf.export.domain.ExportResult;
import com.jd.ioms.jsf.export.domain.OrderDetail;

import java.util.List;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 15:57 2019/1/8
 */
public interface OrderMiddlewareJSFService {


    String echoStr(String str);

    /**
     * 根据订单号查询订单详情信息
     * @param orderId
     * @return
     */
    public ExportResult<List<OrderDetail>> getOrderDetailListByOrderId(Long orderId);



}
