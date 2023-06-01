package pers.yuweiyi.YoE_logistics.service.impl;

import org.springframework.stereotype.Service;
import pers.yuweiyi.YoE_logistics.service.AdministratorAccountService;

/**
 * projectName: YoE-logistics-Client-Administrator-Desktop <br/>
 * className: AdministratorAccountServiceImpl <br/>
 * description: 管理账号服务实现。 <br/>
 *
 * @author yu_weiyi 于魏祎 <a href="mailto:yu_weiyi@outlook.com" >yu_weiyi@outlook.com</a> <br/>
 * @version0.1 <br/>
 * @since 5/30/2023 10:33 PM <br/>
 */
@Service
public class AdministratorAccountServiceImpl implements AdministratorAccountService {
    private static String accountId = null;
    private static String password = null;

    private void setAccountId(String newAccountId) {
        this.accountId = newAccountId;
    }

    public String getAccountId() {
        return accountId;
    }

    private void setPassword(String newPassword) {
        this.password = newPassword;
    }

    @Override
    public boolean loginCheck(String accountId, String password) {
        //TODO check account when login
        boolean checked = true;//temp

        if (checked) {
            setAccountId(accountId);
            setPassword(password);
            return true;
        }
        else {
            return false;
        }
    }
}
