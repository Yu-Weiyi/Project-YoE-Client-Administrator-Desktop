package pers.yuweiyi.YoE_logistics.service;

import pers.yuweiyi.YoE_logistics.enums.RecordTypeEnum;

/**
 * projectName: YoE-logistics-Client-Administrator-Desktop <br/>
 * className: OrderManagementService <br/>
 * description: 订单管理服务接口。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 0.1 <br/>
 * @since 5/31/2023 1:36 PM <br/>
 */
public interface OrderManagementService {
    public void searchOrderInfo(String orderId);

    public void updateOrder(String orderId, RecordTypeEnum recordType, String stationName, String message);
}
