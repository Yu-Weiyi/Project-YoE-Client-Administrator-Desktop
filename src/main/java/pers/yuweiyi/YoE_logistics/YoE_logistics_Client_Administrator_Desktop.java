package pers.yuweiyi.YoE_logistics;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.yuweiyi.YoE_logistics.util.WindowInfoUtil;
import pers.yuweiyi.YoE_logistics.util.WindowRefreshUtil;

import java.io.InputStream;

/**
 * projectName: YoE-logistics-Client-Administrator-Desktop <br/>
 * className: YoE_logistics_Client_Administrator_Desktop <br/>
 * description: 程序主入口。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 0.1 <br/>
 * @since 5/23/2023 3:22 PM <br/>
 */
@Slf4j
public class YoE_logistics_Client_Administrator_Desktop extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //start
        log.info("YoE-logistics-Client-Administrator-Desktop: Program start");

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        WindowInfoUtil windowInfoUtil = (WindowInfoUtil) context.getBean("windowInfoUtil");
        WindowRefreshUtil windowRefreshUtil = (WindowRefreshUtil) context.getBean("windowRefreshUtil");

        windowInfoUtil.setTitleAndlogo(primaryStage);
        windowInfoUtil.getScreenInfo();

        windowRefreshUtil.setStage(primaryStage);
        windowRefreshUtil.toLoginStage();

        primaryStage.show();
    }
}
