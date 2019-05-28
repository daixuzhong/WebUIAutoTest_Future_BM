package cn.dxz.pages.bmAdmin;

import cn.dxz.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * @author daixuzhong
 * @date 2019/5/113:32 PM
 */
public class UserListPage extends BasePage {
    public UserListPage(WebDriver driver) {
        super(driver);
    }

    //查询输入框
    @FindBy(className = "/html/body/div/div/ng-view/div/div[2]/div/div/div[1]/input")
    private WebElement queryText;

    //新建用户按钮
    @FindBy(xpath = "/html/body/div/div/ng-view/div/div[2]/div/div/div[3]/button[1]")
    private WebElement newUserBtn;

    //删除用户按钮
    @FindBy(xpath = "/html/body/div/div/ng-view/div/div[2]/div/div/div[3]/button[2]")
    private WebElement delUserBtn;

    //用户列表第一条的编辑按钮
    @FindBy(xpath = "/html/body/div/div/ng-view/div/div[3]/div/table/tbody/tr[1]/td[2]/a")
    private WebElement editBtn1;

    //用户列表查询结果-所有的名称
    @FindBy(xpath = "/html/body/div/div/ng-view/div/div[3]/div/table/tbody/tr/td[6]")
    private List<WebElement> nameInList;

    public WebElement getQueryText() {
        return queryText;
    }

    public WebElement getNewUserBtn() {
        return newUserBtn;
    }

    public WebElement getDelUserBtn() {
        return delUserBtn;
    }

    public WebElement getEditBtn1() {
        return editBtn1;
    }

    public List<WebElement> getNameInList() {
        return nameInList;
    }
}
