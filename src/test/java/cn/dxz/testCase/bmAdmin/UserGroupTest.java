package cn.dxz.testCase.bmAdmin;

import cn.dxz.base.CaseBase;
import cn.dxz.business.HomeBusiness;
import cn.dxz.business.LoginBusiness;
import cn.dxz.business.bmAdmin.BMAdminBusiness;
import cn.dxz.business.bmAdmin.UserGroupBusiness;
import cn.dxz.business.entities.UserGroup;
import cn.dxz.testCase.LoginTest;
import cn.dxz.utils.ProUtil;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * @author daixuzhong
 * @title: CreateUserGroupTest
 * @description: 创建用户组，往用户组中添加用户
 * @date 2019/5/14
 */
public class UserGroupTest extends CaseBase {

    private static Logger logger = LoggerFactory.getLogger(UserGroupTest.class);

    @Test(description = "创建用户组，并添加一个用户")
    public void A_createUserGroup() {
        try {
            WebDriver driver = LoginTest.driver;
            //进入用户组管理
            BMAdminBusiness bmab = new BMAdminBusiness(driver);
            bmab.enterUserGroup();

            UserGroupBusiness ugb = new UserGroupBusiness(driver);
            ProUtil proUtil = new ProUtil("bmAdmin/userGroup.properties");
            String groupName = proUtil.readFile("groupName");
            String code = proUtil.readFile("code");
            UserGroup userGroup = new UserGroup(groupName);
            userGroup.setCode(code);

            ugb.createUserGroup(userGroup);
        } catch (InterruptedException e) {
            logger.error("执行失败");
            e.printStackTrace();
        }
    }

    @Test(description = "往指定用户组添加指定用户")
    public void B_addUserToUserGroup() {
        UserGroupBusiness ugb = new UserGroupBusiness(LoginTest.driver);
        ProUtil proUtil = new ProUtil("bmAdmin/userGroup.properties");
        String groupName = proUtil.readFile("groupName");
        String userName = proUtil.readFile("userName");
        try {
            //刷新一下
            WebDriver driver = LoginTest.driver;
            driver.navigate().refresh();
            Thread.sleep(2000);
            ugb.addUserInGroup(groupName, userName);
        } catch (InterruptedException e) {
            logger.error("添加失败，groupName=" + groupName + ", userName=" + userName);
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = "A_createUserGroup", description = "删除用户组")
    public void C_deleteUserGroup() {
        UserGroupBusiness ugp = new UserGroupBusiness(LoginTest.driver);
        ProUtil proUtil = new ProUtil("bmAdmin/userGroup.properties");
        String groupName = proUtil.readFile("groupName");
        try {
            ugp.deleteUserGroup(groupName);
        } catch (InterruptedException e) {
            logger.error("删除失败，groupName=" + groupName);
            e.printStackTrace();
        }

    }



}
