package cn.dxz.pages.bmAdmin;

import cn.dxz.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

/**
 * @author daixuzhong
 * @date 2019/5/113:18 PM
 */
public class BMAdminPage extends BasePage {

    public BMAdminPage(WebDriver driver) {
        super(driver);
    }

    //用户管理
    @FindBy(xpath = "//*[@id=\"mCSB_2_container\"]/ul/li[2]/a")
    private WebElement userAdmin;

    //用户管理-用户列表
    @FindBys({
            @FindBy(id = "collapse2"),
            @FindBy(linkText = "用户列表")
    })
    private WebElement userList;

    //用户管理-用户组管理
    @FindBys({
        @FindBy(id = "collapse2"),
        @FindBy(linkText = "用户组管理")
    })
    private WebElement userGroup;

    public WebElement getUserGroup() {
        return userGroup;
    }

    public WebElement getUserAdmin() {
        return userAdmin;
    }

    public WebElement getUserList() {
        return userList;
    }
}
