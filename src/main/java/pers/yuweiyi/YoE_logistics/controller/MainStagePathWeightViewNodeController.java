package pers.yuweiyi.YoE_logistics.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.yuweiyi.YoE_logistics.service.StationManagementService;
import pers.yuweiyi.YoE_logistics.service.impl.StationManagementServiceImpl;

/**
 * projectName: YoE-logistics-Client-Administrator-Desktop <br/>
 * className: MainStageUpdatePathWeightViewNodeController <br/>
 * description: 主窗口路径权重视图节点控制器。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 0.1 <br/>
 * @since 6/1/2023 1:32 AM <br/>
 */
@Slf4j
public class MainStagePathWeightViewNodeController {
    @FXML
    private JFXTextField pathSourceStationNameJFXTextField;
    @FXML
    private JFXTextField pathTargetStationNameJFXTextField;
    @FXML
    private JFXTextArea nowPathWeightJFXTextArea;
    @FXML
    private JFXTextField newPathWeightJFXTextField;
    @FXML
    private JFXButton searchNowPathWeightJFXButton;
    @FXML
    private JFXButton updateNewPathWeightJFXButton;

    @FXML
    public void onSearchNowPathWeightButtonClick(MouseEvent mouseEvent) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StationManagementService stationManagementService = (StationManagementServiceImpl) context.getBean("stationManagementServiceImpl");

        String sourceStationName = pathSourceStationNameJFXTextField.getText();
        String targetStationName = pathTargetStationNameJFXTextField.getText();

        if (sourceStationName.isEmpty() || targetStationName.isEmpty()) {
            return;
        }
        else {
            int pathWeight = stationManagementService.searchPathWeight(sourceStationName, targetStationName);
            nowPathWeightJFXTextArea.setText(String.valueOf(pathWeight));
        }
    }

    @FXML
    public void onUpdateNewPathWeightButtonClick(MouseEvent mouseEvent) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StationManagementService stationManagementService = (StationManagementServiceImpl) context.getBean("stationManagementServiceImpl");

        String sourceStationName = pathSourceStationNameJFXTextField.getText();
        String targetStationName = pathTargetStationNameJFXTextField.getText();
        String newPathWeight = newPathWeightJFXTextField.getText();

        if (sourceStationName.isEmpty() || targetStationName.isEmpty() || newPathWeight.isEmpty()) {
            return;
        }
        else {
            stationManagementService.changePathWeight(sourceStationName, targetStationName, Integer.parseInt(newPathWeight));
            onSearchNowPathWeightButtonClick(mouseEvent);
        }
        //TODO 反馈效果
    }
}
