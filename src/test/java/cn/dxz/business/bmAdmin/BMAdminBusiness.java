package cn.dxz.business.bmAdmin;

import cn.dxz.actions.bmAdmin.BMAdminAction;
import org.openqa.selenium.WebDriver;

/**
 * @author daixuzhong
 * @date 2019/5/113:48 PM
 */
public class BMAdminBusiness {
    private BMAdminAction bma;

    public BMAdminBusiness(WebDriver driver) {
        bma = new BMAdminAction(driver);
    }

    /**
     * 进入用户列表
     */
    public void enterUserList() {
        bma.clickUserAdmin();
        bma.clickUserList();
    }
}
