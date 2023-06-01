package pers.yuweiyi.YoE_logistics.service.impl;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import pers.yuweiyi.YoE_logistics.pojo.dto.PathWeightSearchDTO;
import pers.yuweiyi.YoE_logistics.pojo.dto.PathWeightUpdateDTO;
import pers.yuweiyi.YoE_logistics.service.StationManagementService;
import pers.yuweiyi.YoE_logistics.util.HTTPUtil;

import java.io.IOException;

/**
 * projectName: YoE-logistics-Client-Administrator-Desktop <br/>
 * className: StationManagementServiceImpl <br/>
 * description: 站点管理服务实现。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 0.1 <br/>
 * @since 5/31/2023 1:55 PM <br/>
 */
@Service
@Slf4j
public class StationManagementServiceImpl implements StationManagementService {
    @Override
    public void changePathWeight(String pathSourceStationName, String pathTargetStationName, int newWeight) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HTTPUtil httpUtil = (HTTPUtil) context.getBean("HTTPUtil");

        String partURL = "/manage/update_path_weight";
        PathWeightUpdateDTO pathWeightUpdateDTO = new PathWeightUpdateDTO(pathSourceStationName, pathTargetStationName, newWeight);

        httpUtil.post(partURL, pathWeightUpdateDTO);
    }

    @Override
    public int searchPathWeight(String pathSourceStationName, String pathTargetStationName) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HTTPUtil httpUtil = (HTTPUtil) context.getBean("HTTPUtil");

        String partURL = "/manage/search_path_weight";
        PathWeightSearchDTO pathWeightSearchDTO = new PathWeightSearchDTO(pathSourceStationName, pathTargetStationName);

        Response response = httpUtil.post(partURL, pathWeightSearchDTO);
        String responseData = null;
        try {
            responseData = response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int pathWeight = Integer.parseInt(responseData);

        return pathWeight;
    }


}
