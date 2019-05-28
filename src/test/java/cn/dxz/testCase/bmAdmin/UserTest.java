package cn.dxz.testCase.bmAdmin;

import cn.dxz.base.CaseBase;
import cn.dxz.business.LoginBusiness;
import cn.dxz.business.bmAdmin.BMAdminBusiness;
import cn.dxz.business.bmAdmin.UserListBusiness;
import cn.dxz.business.entities.User;
import cn.dxz.testCase.LoginTest;
import cn.dxz.utils.ProUtil;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author daixuzhong
 * @title: CreateUserTest
 * @description: TODO
 * @date 2019/5/9
 */
public class UserTest extends CaseBase {
    private static Logger logger = LoggerFactory.getLogger(UserTest.class);
    @Test
    public void createUser() {
        WebDriver driver = LoginTest.driver;
        //创建用户参数
        ProUtil proUtil = new ProUtil("bmAdmin/createUser.properties");
        String name = proUtil.readFile("name");
        String code = proUtil.readFile("code");
        String department = proUtil.readFile("department");
        String enableDepartment = proUtil.readFile( "enableDepartment");
        String company = proUtil.readFile("company");

        User user = new User();
        user.setName(name);
        user.setCode(code);
        user.setDepartment(department);
        user.setEnableDepartment(enableDepartment);
        user.setCompany(company);

        try {
            UserListBusiness ulb = new UserListBusiness(driver);
            ulb.createUser(user);
        } catch (InterruptedException e) {
            logger.error("创建用户失败",e);
            e.printStackTrace();
        }
    }

    @Test
    public void editUser() {

    }

    @Test
    public void deleteUser() {

    }


}
