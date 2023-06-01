package pers.yuweiyi.YoE_logistics.enums;

/**
 * projectName: YoE-logistics-Server-Country <br/>
 * className: RecordTypeEnum <br/>
 * description: 记录类型枚举。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 1.0 <br/>
 * @since 1/30/2023 11:03 PM <br/>
 */
public enum RecordTypeEnum {
    EMPTY,      //占位记录：注册订单号“___”
    START,      //开始订单：物流订单已接收，起始地“___”。    //注意：新建order时一定要先插入两个record，否则查询报错！
    IN,         //货物入站：货物到达“___”。
    OUT,        //货物出站：货物离开“___”。
    ERROR,      //发生错误：“___”。
    DELIVER,    //正投递中：专员“___”正在派送。
    RECEIVE,    //成功交付：您已签收。
    AGENT,      //成功代收：“___”已代收。
    MISS,       //查无此人：查无此人。
    REJECTION,  //客户拒收：收件人拒收。
    BACK,       //原路退回：寄件人确认，货物退回。
    ABANDON     //丢弃货物：货物丢弃,货物已交由当地处理部门进行处理。
}
