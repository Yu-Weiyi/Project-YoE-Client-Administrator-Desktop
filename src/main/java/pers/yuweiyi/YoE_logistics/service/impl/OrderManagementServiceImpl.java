package pers.yuweiyi.YoE_logistics.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import pers.yuweiyi.YoE_logistics.enums.RecordTypeEnum;
import pers.yuweiyi.YoE_logistics.pojo.dto.OrderUpdateDTO;
import pers.yuweiyi.YoE_logistics.pojo.dto.PathWeightUpdateDTO;
import pers.yuweiyi.YoE_logistics.service.OrderManagementService;
import pers.yuweiyi.YoE_logistics.util.HTTPUtil;

/**
 * projectName: YoE-logistics-Client-Administrator-Desktop <br/>
 * className: OrderManagementServiceImpl <br/>
 * description: 订单管理服务实现。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 0.1 <br/>
 * @since 5/31/2023 1:37 PM <br/>
 */
@Service
@Slf4j
public class OrderManagementServiceImpl implements OrderManagementService {
    @Override
    public void searchOrderInfo(String orderId) {
        //TODO
    }

    @Override
    public void updateOrder(String orderId, RecordTypeEnum recordType, String stationName, String message) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HTTPUtil httpUtil = (HTTPUtil) context.getBean("HTTPUtil");

        String partURL = "/order/update_order";
        OrderUpdateDTO orderUpdateDTO = new OrderUpdateDTO(orderId, recordType, stationName, message);

        httpUtil.post(partURL, orderUpdateDTO);
    }
}
