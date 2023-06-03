package pers.yuweiyi.YoE_logistics.controller;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTreeView;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.yuweiyi.YoE_logistics.service.impl.AdministratorAccountServiceImpl;
import pers.yuweiyi.YoE_logistics.util.WindowRefreshUtil;

import java.io.IOException;
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

    @FXML
    private JFXTextArea nowAccountIdJFXTextArea;
    @FXML
    private JFXTreeView mainJFXTreeView;
//    @FXML
//    private JFXScrollPane mainScrollPane;
    @FXML
    private AnchorPane mainScrollPaneAnchorPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdministratorAccountServiceImpl administratorAccountServiceImpl = (AdministratorAccountServiceImpl) context.getBean("administratorAccountServiceImpl");

        nowAccountIdJFXTextArea.setText("当前账号：" + administratorAccountServiceImpl.getAccountId());

        initTreeView();
    }

    public void setWindowRefreshUtil(WindowRefreshUtil windowRefreshUtil) {
        this.windowRefreshUtil = windowRefreshUtil;
    }

    private void initTreeView() {
        TreeItem<String> treeItemRoot;
        TreeItem<String> treeItemOfWelcomeViewNode;
        TreeItem<String> treeItemOfStationManagementViewNode;
        TreeItem<String> treeItemOfPathWeightViewNode;
        TreeItem<String> treeItemOfOrderManagementViewNode;
        TreeItem<String> treeItemOfRecordUpdateViewNode;

        treeItemRoot = new TreeItem<String>("功能一览");
        treeItemRoot.setExpanded(true);
        treeItemRoot.getChildren().addAll(
                treeItemOfWelcomeViewNode = new TreeItem<String>("欢迎"),
                treeItemOfStationManagementViewNode = new TreeItem<String>("站点管理"),
                treeItemOfOrderManagementViewNode = new TreeItem<String>("订单管理")
                //TODO more
        );

        treeItemOfStationManagementViewNode.setExpanded(true);
        treeItemOfStationManagementViewNode.getChildren().addAll(
                treeItemOfPathWeightViewNode = new TreeItem<String>("路径权重")
        );

        treeItemOfOrderManagementViewNode.setExpanded(true);
        treeItemOfOrderManagementViewNode.getChildren().addAll(
                treeItemOfRecordUpdateViewNode = new TreeItem<String>("记录更新")
        );

        mainJFXTreeView.setRoot(treeItemRoot);
    }

    private void changeViewNode(String viewNodePath) throws IOException {
        ObservableList<Node> mainJFXScrollPaneAnchorPaneChildren = mainScrollPaneAnchorPane.getChildren();
        mainJFXScrollPaneAnchorPaneChildren.clear();
        mainJFXScrollPaneAnchorPaneChildren.add(FXMLLoader.load(getClass().getResource(viewNodePath)));
    }

    @FXML
    public void onMainJFXTreeViewClick(MouseEvent mouseEvent) throws IOException {
        TreeItem<String> selectedTreeItem = (TreeItem<String>) mainJFXTreeView.getSelectionModel().getSelectedItem();
        String viewNodePath = "";
        switch (selectedTreeItem.getValue()) {
            case "欢迎":
                viewNodePath = "/fxml/mainStageWelcomeViewNode.fxml";
                changeViewNode(viewNodePath);
                break;
            case "路径权重":
                viewNodePath = "/fxml/mainStagePathWeightViewNode.fxml";
                changeViewNode(viewNodePath);
                break;
            case "记录更新":
                viewNodePath = "/fxml/mainStageRecordUpdateViewNode.fxml";
                changeViewNode(viewNodePath);
                break;
            default:
                break;
        }
    }
}
