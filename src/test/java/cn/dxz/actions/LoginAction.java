package cn.dxz.actions;

import cn.dxz.pages.LoginPage;
import org.openqa.selenium.WebDriver;

/**
 * @author daixuzhong
 * @title: LoginAction
 * @description: 登录相关的单个具体的操作
 * @date 2019/5/10
 */
public class LoginAction {
    public WebDriver driver;
    public LoginPage lp;

    public LoginAction(WebDriver driver) {
        this.driver = driver;
        lp = new LoginPage(driver);

    }

    //输入用户名
    public void sendKeyUserName(String name) {
        lp.sendKey(lp.getNameIput(), name);
    }

    //输入密码
    public void sendKeyPassword(String password) {
        lp.sendKey(lp.getPasswordInput(), password);
    }

    //点击登录
    public void clickLogin() {
        lp.click(lp.getLoginBtn());
    }

    //点击“记住我按钮”
    public void clickRemMe() {
        lp.click(lp.getRememberMeBtn());
    }

}
