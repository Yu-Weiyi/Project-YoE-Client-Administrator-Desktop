package pers.yuweiyi.YoE_logistics.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import lombok.extern.slf4j.Slf4j;
import pers.yuweiyi.YoE_logistics.util.WindowRefreshUtil;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * projectName: YoE-logistics-Client-Administrator-Desktop <br/>
 * className: MainWindowController <br/>
 * description: 主窗口控制器。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 0.1 <br/>
 * @since 5/31/2023 12:47 AM <br/>
 */
@Slf4j
public class MainStageController implements Initializable {
    private WindowRefreshUtil windowRefreshUtil;

    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    public void setWindowRefreshUtil(WindowRefreshUtil windowRefreshUtil) {
        this.windowRefreshUtil = windowRefreshUtil;
    }

    @FXML
    public void mainTreeViewClick(MouseEvent mouseEvent) {
    }
}
