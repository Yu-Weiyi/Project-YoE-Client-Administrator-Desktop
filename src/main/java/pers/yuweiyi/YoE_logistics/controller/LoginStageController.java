package pers.yuweiyi.YoE_logistics.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Window;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.yuweiyi.YoE_logistics.service.AdministratorAccountService;
import pers.yuweiyi.YoE_logistics.service.impl.AdministratorAccountServiceImpl;
import pers.yuweiyi.YoE_logistics.util.WindowRefreshUtil;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * projectName: YoE-logistics-Client-Administrator-Desktop <br/>
 * className: LoginController <br/>
 * description: 登录窗口控制器。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 0.1 <br/>
 * @since 5/30/2023 8:00 PM <br/>
 */
@Slf4j
public class LoginStageController implements Initializable {
    private WindowRefreshUtil windowRefreshUtil;

    @FXML
    private JFXTextField accountIdField;
    @FXML
    private JFXPasswordField passwordField;
    @FXML
    private Label errorMessage;
    @FXML
    private Button submitButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    public void setWindowRefreshUtil(WindowRefreshUtil windowRefreshUtil) {
        this.windowRefreshUtil = windowRefreshUtil;
    }

    @FXML
    public void onSubmitButtonClick(ActionEvent actionEvent) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        WindowRefreshUtil windowRefreshUtil = (WindowRefreshUtil) context.getBean("windowRefreshUtil");
        AdministratorAccountService administratorAccountService = (AdministratorAccountServiceImpl) context.getBean("administratorAccountServiceImpl");

        Window window = submitButton.getScene().getWindow();

        String accountId = accountIdField.getText();
        String password = passwordField.getText();

        if (accountId.isEmpty()) {
            errorMessage.setText("请输入账号！");
            return;
        }
        if (password.isEmpty()) {
            errorMessage.setText("请输入密码！");
            return;
        }
        if (administratorAccountService.loginCheck(accountId, password)) {
            log.info("Login succeed, account_ID[" + accountId + "].");
            windowRefreshUtil.toMainStage();
        }
        else {
            errorMessage.setText("登录验证失败！");
        }

    }
}
