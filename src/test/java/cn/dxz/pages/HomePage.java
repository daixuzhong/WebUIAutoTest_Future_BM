package cn.dxz.pages;

import cn.dxz.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author daixuzhong
 * @title: HomePage
 * @description: 首页元素及常用操作
 * @date 2019/5/9
 */
public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //注销按钮
    @FindBy(xpath = "/html/body/header/ul/li[6]/a")
    private WebElement logOff;

    //上方导航栏-系统管理
    @FindBy(xpath = "/html/body/header/div[2]/ul/li[2]/a")
    private WebElement systemAdmin;

    //上方导航栏-全面预算(用户界面)
    @FindBy(xpath = "//*[@id=\"dorpdownnav\"]/li/a")
    private WebElement allBudget_User;

    //上方导航栏-门户管理
    @FindBy(linkText = "门户管理")
    private WebElement bmAdmin;

    public WebElement getLogOff() {
        return logOff;
    }

    public WebElement getSystemAdmin() {
        return systemAdmin;
    }

    public WebElement getAllBudget_User() {
        return allBudget_User;
    }

    public WebElement getBmAdmin() {
        return bmAdmin;
    }
}
