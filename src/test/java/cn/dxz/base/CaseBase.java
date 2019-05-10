package cn.dxz.base;

import cn.dxz.utils.SelectDriverUtil;
import org.openqa.selenium.WebDriver;

/**
 * @author daixuzhong
 * @title: CaseBase
 * @description: 所有测试用例基类
 * @date 2019/5/10
 */
public class CaseBase {

    public WebDriver initDriver(String browserName) {
        WebDriver driver = SelectDriverUtil.driverName(browserName);
        driver.manage().window().maximize();
        return driver;
    }

    public void login(String name, String password, boolean rememberMe) {

    }

}
