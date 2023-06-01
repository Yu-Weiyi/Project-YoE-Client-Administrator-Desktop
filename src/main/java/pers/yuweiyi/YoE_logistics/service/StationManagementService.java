package pers.yuweiyi.YoE_logistics.service;

/**
 * projectName: YoE-logistics-Client-Administrator-Desktop <br/>
 * className: StationManagementService <br/>
 * description: 站点管理服务接口。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 0.1 <br/>
 * @since 5/31/2023 1:53 PM <br/>
 */
public interface StationManagementService {
    public void changePathWeight(String pathSourceStationName, String pathTargetStationName, int newWeight);

    public int searchPathWeight(String pathSourceStationName, String pathTargetStationName);
}
