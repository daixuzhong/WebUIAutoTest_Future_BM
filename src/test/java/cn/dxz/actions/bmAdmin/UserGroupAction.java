package cn.dxz.actions.bmAdmin;

import cn.dxz.pages.bmAdmin.UserGroupPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * @author daixuzhong
 * @title: UserGroupAction
 * @description: TODO
 * @date 2019/5/14
 */
public class UserGroupAction {

    private UserGroupPage ugp;
    private WebDriver driver;

    public UserGroupAction(WebDriver driver) {
        this.driver = driver;
        ugp = new UserGroupPage(driver);
    }

    /**
     * 搜索用户组
     * @param key
     */
    public void sendKeySearchInput(String key) {
        ugp.sendKey(ugp.getSearchInput(), key);
        ugp.keyEnter();
    }

    /**
     * 点击新建按钮
     */
    public void clickNewBtn() {
        ugp.click(ugp.getCreateBtn());
    }

    /**
     * 输入用户组名称
     * @param name
     */
    public void sendKeyNameInput(String name) {
        ugp.sendKey(ugp.getNameInput(), name);
    }

    /**
     * 输入代码
     * @param code
     */
    public void sendKeyCodeInput(String code) {
        ugp.sendKey(ugp.getCodeInput(), code);
    }

    /**
     * 点击保存
     */
    public void clickSaveBtn() {
        ugp.click(ugp.getSaveUserGroupBtn());
    }

    /**
     * 在左侧列表结构中选中指定用户组
     * @param name
     */
    public void chooseUserGroup(String name) {
        List<WebElement> userGroupNameList = ugp.getUserGroupNameList();
        for (WebElement webElement : userGroupNameList) {
            if (StringUtils.equals(webElement.getText(), name)) {
                webElement.click();
                return;
            }
        }
    }

    /**
     * 用户组里添加用户-搜索用户
     * @param userName
     */
    public void sendKeySearchUser(String userName) {
        ugp.sendKey(ugp.getSearchUserInput(), userName);
        ugp.keyEnter();
    }

    /**
     * 勾选用户
     */
    public void clickTheUser() {
        ugp.click(ugp.getCheckBox());
    }

    /**
     * 点击添加并关闭
     */
    public void clickAddAndQuit() {
        ugp.click(ugp.getAddAndQuitBtn());
    }

    /**
     * 校验添加用户组的功能是否成功
     * @param groupName
     */
    public void assertCreateUserGroup(String groupName) {
        boolean flag = false;
        ugp.sendKey(ugp.getSearchInput(), groupName);
        ugp.keyEnter();
        if (StringUtils.equals(groupName, ugp.getText(ugp.getUserGroupNameForAssert()))) {
            flag = true;
        }
        Assert.assertTrue(flag,"添加用户组失败");

    }


    /**
     * 校验在用户组内添加用户的功能是否成功
     * @param userName
     */
    public void assertAddUserInGroup(String userName) {
        boolean flag = false;
        ugp.sendKey(ugp.getSearchInput(), userName);
        ugp.keyEnter();
        if (StringUtils.equals(userName, ugp.getText(ugp.getUserNameForAssert()))) {
            flag = true;
        }
        Assert.assertTrue(flag,"用户组内添加用户失败");
    }

    /**
     * 点击左侧列表结构中的用户组层级
     */
    public void clickUserGroup() {
        ugp.click(ugp.getUserGroup());
    }

    /**
     * 点击用户组搜索结果列表的左侧的勾选按钮
     */
    public void clickCheckboxOut() {
        ugp.click(ugp.getCheckBoxOut());
    }

    /**
     * 点击删除用户组按钮
     */
    public void clickDelGroup() {
        ugp.click(ugp.getDelBtn());
    }

    /**
     * 点击删除弹框中的确认按钮
     */
    public void clickConfirmDel() {
        ugp.click(ugp.getConfirmDel());
    }


}
