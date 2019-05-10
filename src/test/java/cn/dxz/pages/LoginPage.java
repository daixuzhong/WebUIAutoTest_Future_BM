package cn.dxz.pages;

import cn.dxz.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author daixuzhong
 * @title: LoginPage
 * @description: 登录页面元素以及常用操作
 * @date 2019/5/9
 */
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //登录名输入框
    @FindBy(id= "LoginName")
    private WebElement nameIput;

    //密码输入框
    @FindBy(id= "Password")
    private WebElement passwordInput;

    //记住我按钮
    @FindBy(id= "RememberMe")
    private WebElement rememberMeBtn;

    //登录按钮
    @FindBy(id= "btnLogin")
    private WebElement loginBtn;

    //错误提示
    @FindBy(xpath= "/html/body/form/div/div/div/div/div/div/div[2]/div/div")
    private WebElement errorMes;

    public WebElement getNameIput() {
        return nameIput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getRememberMeBtn() {
        return rememberMeBtn;
    }

    public WebElement getLoginBtn() {
        return loginBtn;
    }

    public WebElement getErrorMes() {
        return errorMes;
    }


}
