package pers.yuweiyi.YoE_logistics.util;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

/**
 * projectName: YoE-logistics-Client-Administrator-Desktop <br/>
 * className: WindowInfoUtil <br/>
 * description: 窗口信息工具。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 0.1 <br/>
 * @since 5/31/2023 3:16 AM <br/>
 */
@Component
public class WindowInfoUtil {
    private static double minX;//0
    private static double minY;//0
    private static double width;//1280
    private static double height;//720

    public void setTitleAndlogo(Stage stage) {
        stage.setTitle("邮易YoE仓储物流   管理客户端");
        stage.getIcons().add(new Image("/image/pure_logo_YoE.png"));
    }

    public void getScreenInfo() {
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        minX = primaryScreenBounds.getMinX();
        minY = primaryScreenBounds.getMinY();
        width = primaryScreenBounds.getWidth();
        height = primaryScreenBounds.getHeight();
    }

    public double getMinX() {
        return minX;
    }

    public double getMinY() {
        return minY;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
