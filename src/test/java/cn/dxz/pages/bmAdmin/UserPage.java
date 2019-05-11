package cn.dxz.pages.bmAdmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author daixuzhong
 * @date 2019/5/114:08 PM
 * @Description 创建用户弹框中的参数
 */
public class UserPage extends BMAdminPage {
    public UserPage(WebDriver driver) {
        super(driver);
    }

    //名称输入框
    @FindBy(name = "name")
    private WebElement name;

}
