package cn.dxz.actions.bmAdmin;

import cn.dxz.pages.bmAdmin.BMAdminPage;
import org.openqa.selenium.WebDriver;

/**
 * @author daixuzhong
 * @date 2019/5/113:42 PM
 * @description: 门户管理相关操作
 */
public class BMAdminAction {
    private BMAdminPage bap;
    private WebDriver driver;

    public BMAdminAction(WebDriver driver) {
        this.driver = driver;
        bap = new BMAdminPage(driver);
    }

    /**
     * 点击用户管理
     */
    public void clickUserAdmin() {
        bap.click(bap.getUserAdmin());
    }

    /**
     * 点击用户列表
     */
    public void clickUserList() {
        bap.click(bap.getUserList());
    }

    /**
     * 点击用户组管理
     */
    public void clickUserGroup() {
        bap.click(bap.getUserGroup());
    }



}
