package cn.dxz.testCase;

import cn.dxz.base.CaseBase;
import cn.dxz.business.LoginBusiness;
import cn.dxz.utils.ProUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
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
    public static WebDriver driver;

//    @Test
//    @Parameters({"userName","password"})
//    public void loginAdmin(String userName, String password) {
//        driver.get("http://47.100.40.166:8020/ZT/Account/Login?ReturnUrl=%2fZT%2f");
//        LoginBusiness page = new LoginBusiness(driver);
//        //登录
//        page.login(userName,password,false);
//
//    }

    @Test
    public void loginAdmin() {
        driver = initDriver("chrome");
        driver.get("http://47.100.40.166:8020/ZT/Account/Login?ReturnUrl=%2fZT%2f");
        LoginBusiness lb = new LoginBusiness(driver);
        //获取登录参数
        ProUtil proUtil = new ProUtil("parameter.properties");
        String userName = proUtil.readFile( "admin");
        String password = proUtil.readFile("password");
        //登录
        lb.login(userName,password,false);
    }

    @AfterSuite
    public void afterTest() {
        driver.quit();
    }

}
