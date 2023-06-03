package pers.yuweiyi.YoE_logistics.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.yuweiyi.YoE_logistics.enums.RecordTypeEnum;
import pers.yuweiyi.YoE_logistics.service.OrderManagementService;
import pers.yuweiyi.YoE_logistics.service.impl.OrderManagementServiceImpl;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * projectName: YoE-logistics-Client-Administrator-Desktop <br/>
 * className: MainStageRecordUpdateViewNodeController <br/>
 * description: 主窗口记录更新视图节点控制器。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 0.1 <br/>
 * @since 6/1/2023 5:50 PM <br/>
 */
@Slf4j
public class MainStageRecordUpdateViewNodeController implements Initializable {
    @FXML
    private JFXTextArea orderIdJFXTextArea;
    @FXML
    private ChoiceBox<RecordTypeEnum> recordTypeChoiceBox;
    @FXML
    private JFXTextArea stationNameJFXTextArea;
    @FXML
    private JFXTextArea messageJFXTextArea;
    @FXML
    private JFXButton submitJFXButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        recordTypeChoiceBox.getItems().addAll(
                RecordTypeEnum.IN,
                RecordTypeEnum.OUT,
                RecordTypeEnum.ERROR,
                RecordTypeEnum.DELIVER,
                RecordTypeEnum.RECEIVE,
                RecordTypeEnum.AGENT,
                RecordTypeEnum.MISS,
                RecordTypeEnum.REJECTION,
                RecordTypeEnum.BACK,
                RecordTypeEnum.ABANDON
        );
        recordTypeChoiceBox.setConverter(new StringConverter<RecordTypeEnum>() {
            @Override
            public String toString(RecordTypeEnum object) {
                String value;

                switch (object) {
                    case IN:
                        value = "货物入站";
                        break;
                    case OUT:
                        value = "货物出站";
                        break;
                    case ERROR:
                        value = "发生错误";
                        break;
                    case DELIVER:
                        value = "正投递中";
                        break;
                    case RECEIVE:
                        value = "成功交付";
                        break;
                    case AGENT:
                        value = "成功代收";
                        break;
                    case MISS:
                        value = "查无此人";
                        break;
                    case REJECTION:
                        value = "客户拒收";
                        break;
                    case BACK:
                        value = "原路退回";
                        break;
                    case ABANDON:
                        value = "丢弃货物";
                        break;
                    default:
                        value = null;
                        break;
                }

                return value;
            }

            @Override
            public RecordTypeEnum fromString(String string) {
                return null;
            }
        });
    }

    @FXML
    public void onSubmitJFXButtonClick(MouseEvent mouseEvent) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        String orderId = orderIdJFXTextArea.getText();
        RecordTypeEnum recordType = recordTypeChoiceBox.getValue();
        String stationName = stationNameJFXTextArea.getText();
        String message = messageJFXTextArea.getText();

        if (orderId.isEmpty() || recordType == null || stationName.isEmpty() || message.isEmpty()) {
            return;
        }
        else {
            OrderManagementService orderManagementService = (OrderManagementServiceImpl) context.getBean("orderManagementServiceImpl");
            orderManagementService.updateOrder(orderId, recordType, stationName, message);
            return;
        }
    }
}
