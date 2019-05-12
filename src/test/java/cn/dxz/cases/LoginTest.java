package cn.dxz.cases;

import cn.dxz.base.CaseBase;
import cn.dxz.base.Constants;
import cn.dxz.business.LoginBusiness;
import cn.dxz.utils.ProUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

;

/**
 * @author daixuzhong
 * @title: LoginTest
 * @description: TODO
 * @date 2019/5/9
 */
public class LoginTest extends CaseBase {

    //选择浏览器
    private WebDriver driver = initDriver("chrome");

    @Test
    public void getUrl() {
        driver.get("http://47.100.40.166:8020/ZT/Account/Login?ReturnUrl=%2fZT%2f");
    }


    @Test(dependsOnMethods = {"getUrl"})
    @Parameters({"userName","password"})
    public void loginAdmin(String userName, String password) {
        LoginBusiness page = new LoginBusiness(driver);
        //登录
        page.login(userName,password,false);
    }

//    @Test(dependsOnMethods = {"getUrl"})
//    public void loginAdmin() {
//        LoginBusiness page = new LoginBusiness(driver);
//        //获取登录参数
//        ProUtil proUtil = new ProUtil();
//        String userName = proUtil.readFile("parameter.properties", "userName");
//        String password = proUtil.readFile("parameter.properties", "password");
//        //登录
//        page.login(userName,password,false);
//    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

}
