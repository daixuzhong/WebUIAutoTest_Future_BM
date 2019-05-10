package cn.dxz.business;

import cn.dxz.actions.LoginAction;
import org.openqa.selenium.WebDriver;

/**
 * @author daixuzhong
 * @title: LoginBusiness
 * @description: TODO
 * @date 2019/5/10
 */
public class LoginBusiness {
    LoginAction la;

    public LoginBusiness(WebDriver driver) {
        la = new LoginAction(driver);
    }

    /**
     * 登录业务
     * @param name
     * @param password
     * @param rememberMe
     */
    public void login(String name, String password, boolean rememberMe) {
        la.sendKeyUserName(name);
        la.sendKeyPassword(password);
        if (rememberMe) {
            la.clickRemMe();
        }
        la.clickLogin();
    }
}
