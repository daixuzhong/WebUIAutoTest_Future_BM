package cn.dxz.business.bmAdmin;

import cn.dxz.actions.HomeAction;
import cn.dxz.actions.bmAdmin.BMAdminAction;
import org.openqa.selenium.WebDriver;

/**
 * @author daixuzhong
 * @date 2019/5/113:48 PM
 */
public class BMAdminBusiness {
    private BMAdminAction bma;
    private HomeAction ha;

    public BMAdminBusiness(WebDriver driver) {
        bma = new BMAdminAction(driver);
        ha = new HomeAction(driver);
    }

    /**
     * 进入用户列表
     */
    public void enterUserList() {
        ha.clickBMAdmin();
        bma.clickUserAdmin();
        bma.clickUserList();
    }
}
