package cn.dxz.pages;

import cn.dxz.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author daixuzhong
 * @title: FirstLoginPage
 * @description: 新用户首次登录的确认用户信息页
 * @date 2019/5/10
 */
public class FirstLoginPage extends BasePage {

    public FirstLoginPage(WebDriver driver) {
        super(driver);
    }

    //名称
    @FindBy(xpath = "/html/body/div/div[2]/div/div/div[1]/ng-include/div/div/div[1]/div")
    private WebElement name;

    //代码
    @FindBy(xpath = "/html/body/div/div[2]/div/div/div[1]/ng-include/div/div/div[2]/div/span")
    private WebElement code;

    //电子信箱
    @FindBy(xpath = "/html/body/div/div[2]/div/div/div[1]/ng-include/div/div/div[3]/div/span")
    private WebElement email;

    //所属部门
    @FindBy(xpath = "/html/body/div/div[2]/div/div/div[1]/ng-include/div/div/div[4]/div/span")
    private WebElement departmen;

    //确认按钮
    @FindBy(className = "btn btn-primary")
    private WebElement confirmBtn;

    public WebElement getConfirmBtn() {
        return confirmBtn;
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getCode() {
        return code;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getDepartmen() {
        return departmen;
    }
}
