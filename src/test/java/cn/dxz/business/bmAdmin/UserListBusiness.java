package cn.dxz.business.bmAdmin;

import cn.dxz.actions.bmAdmin.UserListAction;
import cn.dxz.actions.bmAdmin.UserMesAction;
import cn.dxz.business.entities.User;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

/**
 * @author daixuzhong
 * @date 2019/5/114:02 PM
 */
public class UserListBusiness {
    private UserListAction ula;
    private UserMesAction uma;

    public UserListBusiness(WebDriver driver) {
        ula = new UserListAction(driver);
        uma = new UserMesAction(driver);
    }

    /**
     * 进入新建用户界面
     */
    public void enterNewUser(){
        ula.clickNewBtn();
    }

    /**
     * 创建用户
     * @param user
     */
    public void createUser(User user) throws InterruptedException {
        ula.clickNewBtn();
        uma.sendKeyName(user.getName());
        uma.sendKeyCode(user.getCode());
//        uma.sendKeyMobile(user.getMobile());
        if (StringUtils.isNotBlank(user.getPassword())) {
            uma.sendKeyPassword(user.getPassword());
        }
        uma.sendDepartment(user.getDepartment());
        Thread.sleep(1000);
        uma.sendEnableDepartment(user.getEnableDepartment());
        Thread.sleep(1000);
        uma.sendCompany(user.getCompany());
        Thread.sleep(1000);
        if (StringUtils.isNotBlank(user.getUserGroup())) {
            uma.sendUserGroup(user.getUserGroup());
        }

        uma.clickSaveBtn();

        //断言
        ula.assertCreateUser(user.getName());
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
        //修改姓名
        uma.sendKeyName(text);
        uma.clickSaveBtn();

        //断言校验

    }

}
