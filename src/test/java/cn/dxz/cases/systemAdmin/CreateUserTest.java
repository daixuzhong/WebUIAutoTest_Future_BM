package cn.dxz.cases.systemAdmin;

import cn.dxz.base.CaseBase;
import cn.dxz.business.HomeBusiness;
import cn.dxz.business.LoginBusiness;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

/**
 * @author daixuzhong
 * @title: CreateUserTest
 * @description: TODO
 * @date 2019/5/9
 */
public class CreateUserTest extends CaseBase {

    //选择浏览器
    private WebDriver driver = initDriver("chrome");

    @Test
    public void loginAdmin() {

        LoginBusiness lb = new LoginBusiness(driver);
        driver.get("http://47.100.40.166:8020/ZT/Account/Login?ReturnUrl=%2fZT%2f");
        //登录
        lb.login("admin","1",false);
    }

    @Test(dependsOnMethods = {"loginAdmin"})
    public void sysAdmin() {
        HomeBusiness hb = new HomeBusiness(driver);
        hb.createUser();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }


}
