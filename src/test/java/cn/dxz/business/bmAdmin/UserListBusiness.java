package cn.dxz.business.bmAdmin;

import cn.dxz.actions.bmAdmin.UserListAction;
import org.openqa.selenium.WebDriver;

/**
 * @author daixuzhong
 * @date 2019/5/114:02 PM
 */
public class UserListBusiness {
    private UserListAction ula;

    public UserListBusiness(WebDriver driver) {
        ula = new UserListAction(driver);
    }

    /**
     * 进入新建用户界面
     */
    public void enterNewUser(){
        ula.clickNewBtn();
    }

    /**
     * 搜索用户并对其进行编辑
     * @param text
     */
    public void editUser(String text) {
        //点击查询并输入查询条件
        ula.clickQueryTextAndSendKey(text);
        //点击编辑
        ula.clickFirstEditBtn();
    }
}
