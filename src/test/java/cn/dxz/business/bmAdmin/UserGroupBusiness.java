package cn.dxz.business.bmAdmin;

import cn.dxz.actions.bmAdmin.UserGroupAction;
import cn.dxz.business.entities.UserGroup;
import org.openqa.selenium.WebDriver;

/**
 * @author daixuzhong
 * @title: UserGroupBusiness
 * @description: TODO
 * @date 2019/5/14
 */
public class UserGroupBusiness {

    private UserGroupAction uga;

    public UserGroupBusiness(WebDriver driver) {
        uga = new UserGroupAction(driver);
    }

    /**
     * 新建用户组
     * @param userGroup
     */
    public void createUserGroup(UserGroup userGroup) throws InterruptedException {
        uga.clickNewBtn();
        uga.sendKeyNameInput(userGroup.getGroupName());
        uga.sendKeyCodeInput(userGroup.getCode());
        uga.clickSaveBtn();
        Thread.sleep(3000);
        //校验
        uga.assertCreateUserGroup(userGroup.getGroupName());
    }

    /**
     * 往指定用户组内添加指定用户
     * @param userName
     */
    public void addUserInGroup(String userGroup, String userName) throws InterruptedException {
        uga.chooseUserGroup(userGroup);
        Thread.sleep(1000);
        uga.clickNewBtn();
        Thread.sleep(1000);
        uga.sendKeySearchUser(userName);
        Thread.sleep(1000);
        uga.clickTheUser();
        Thread.sleep(1000);
        uga.clickAddAndQuit();
        Thread.sleep(1000);

        //校验
        uga.assertAddUserInGroup(userName);
    }

    public void deleteUserGroup(String groupName) throws InterruptedException {
        uga.clickUserGroup();
        Thread.sleep(1000);
        uga.sendKeySearchInput(groupName);
        uga.clickCheckboxOut();
        uga.clickDelGroup();
        uga.clickConfirmDel();
    }

}
