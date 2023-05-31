package pers.yuweiyi.YoE_logistics.util;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pers.yuweiyi.YoE_logistics.controller.LoginStageController;
import pers.yuweiyi.YoE_logistics.controller.MainStageController;

import java.io.IOException;
import java.io.InputStream;

/**
 * projectName: YoE-logistics-Client-Administrator-Desktop <br/>
 * className: WindowRefreshUtil <br/>
 * description: 窗口刷新工具。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 0.1 <br/>
 * @since 5/31/2023 12:59 AM <br/>
 */
@Component
@Slf4j
public class WindowRefreshUtil{
    private static Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private Initializable replaceSceneContent(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        InputStream inputStream = WindowRefreshUtil.class.getResourceAsStream(fxml);
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
        fxmlLoader.setLocation(WindowRefreshUtil.class.getResource(fxml));
        try {
            Pane pane = (Pane) fxmlLoader.load(inputStream);
            Scene scene = new Scene(pane);
            stage.setScene(scene);
            stage.sizeToScene();
        } catch (IOException e) {
            log.error("Exception when refreshing window!");
            throw new RuntimeException(e);
        } finally {
            inputStream.close();
        }
        return (Initializable) fxmlLoader.getController();
    }
    public void toLoginStage() throws IOException {
        LoginStageController loginStageController = (LoginStageController) replaceSceneContent("/fxml/loginStage.fxml");
        loginStageController.setWindowRefreshUtil(this);
    }

    public void toMainStage() throws IOException {
        MainStageController mainStageController = (MainStageController) replaceSceneContent("/fxml/mainStage.fxml");
        mainStageController.setWindowRefreshUtil(this);
        stage.setMaximized(true);
    }
}
