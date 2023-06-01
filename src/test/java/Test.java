import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.yuweiyi.YoE_logistics.service.StationManagementService;
import pers.yuweiyi.YoE_logistics.service.impl.StationManagementServiceImpl;

import java.util.Arrays;

/**
 * projectName: YoE-logistics-Client-Administrator-Desktop <br/>
 * className: Main <br/>
 * description: 此处添加描述 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 此处添加版本 <br/>
 * @since 5/31/2023 7:53 PM <br/>
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("test");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));

//        StationManagementService stationManagementService = (StationManagementServiceImpl) context.getBean("stationManagementServiceImpl");
//        stationManagementService.changePathWeight("E2a站","K1a站", 14);
    }
}
