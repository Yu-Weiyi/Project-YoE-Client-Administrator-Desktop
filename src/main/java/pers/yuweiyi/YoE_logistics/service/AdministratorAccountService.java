package pers.yuweiyi.YoE_logistics.service;

/**
 * projectName: YoE-logistics-Client-Administrator-Desktop <br/>
 * className: AdministratorAccountService <br/>
 * description: 管理账号服务接口。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version 0.1 <br/>
 * @since 5/30/2023 10:31 PM <br/>
 */
public interface AdministratorAccountService {
    boolean loginCheck(String accountId, String password);
}
