package cn.dxz.pages.bmAdmin;

import cn.dxz.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.util.List;

/**
 * @author daixuzhong
 * @title: UserGroupPage
 * @description: 用户组管理页
 * @date 2019/5/13
 */
public class UserGroupPage extends BasePage {

    public UserGroupPage(WebDriver driver) {
        super(driver);
    }

    //新建按钮
    @FindBy(xpath = "/html/body/div/div/ng-view/div/div[2]/div/div[2]/div/div/div[3]/button[1]")
    private WebElement createBtn;

    //删除按钮
    @FindBy(xpath = "/html/body/div/div/ng-view/div/div[2]/div/div[2]/div/div/div[3]/button[2]")
    private WebElement delBtn;

    //删除用户组弹框中的确认按钮
    @FindBy(xpath = "/html/body/div[1]/div/div/div[3]/button[1]")
    private WebElement confirmDel;

    //名称输入框
    @FindBy(name = "name")
    private WebElement nameInput;

    //姓名输入框
    @FindBy(name = "code")
    private WebElement codeInput;

    //保存
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[4]/div/button[1]")
    private WebElement saveUserGroupBtn;

    //用户组搜索框
    @FindBy(xpath = "/html/body/div/div/ng-view/div/div[2]/div/div[2]/div/div/div[1]/input")
    private WebElement searchInput;

    //列表页第1条的编辑按钮
    @FindBy(xpath = "/html/body/div/div/ng-view/div/div[2]/div/div[3]/div/table/tbody/tr[1]/td[2]/a")
    private WebElement firstEditBtn;

    //用户组列表中名称的元素列表
    @FindBy(xpath = "/html/body/div/div/ng-view/div/div[1]/ul/li/ul/li/span/span[3]")
    private List<WebElement> userGroupNameList;

    //用户组列表-用户组
    @FindBy(xpath = "/html/body/div[1]/div/ng-view/div/div[1]/ul/li/span/span[3]")
    private WebElement userGroup;

    //用户组里添加用户弹框-搜索框
    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div[2]/div/div/div/input")
    private WebElement searchUserInput;

    //搜索结果选择全部(用户组-添加用户部分)
    @FindBy(xpath = "html/body/div[2]/div[2]/div/div[3]/div/table/thead/tr/th[1]/input")
    private WebElement checkBox;

    @FindBy(name = "btSelectItem")
    private WebElement checkBoxOut;

    //添加并退出按钮
    @FindBy(xpath = "/html/body/div[2]/div[1]/div/button[2]")
    private WebElement addAndQuitBtn;
//    @FindBy(xpath = "//div[contains(@id, 'pageSlideContainer')]")


    //用户组列表中的用户组名称
    @FindBy(xpath = "/html/body/div/div/ng-view/div/div[2]/div/div[3]/div/table/tbody/tr[1]/td[4]")
    private WebElement userGroupNameForAssert;

    //用户组中用户列表第1条的用户名称
    @FindBy(xpath = "/html/body/div/div/ng-view/div/div[2]/div/div[3]/div/table/tbody/tr[1]/td[6]")
    private WebElement userNameForAssert;

    public WebElement getCreateBtn() {
        return createBtn;
    }

    public WebElement getDelBtn() {
        return delBtn;
    }

    public WebElement getSearchInput() {
        return searchInput;
    }

    public WebElement getFirstEditBtn() {
        return firstEditBtn;
    }

    public List<WebElement> getUserGroupNameList() {
        return userGroupNameList;
    }

    public WebElement getSearchUserInput() {
        return searchUserInput;
    }

    public WebElement getCheckBox() {
        return checkBox;
    }

    public WebElement getAddAndQuitBtn() {
        return addAndQuitBtn;
    }

    public WebElement getNameInput() {
        return nameInput;
    }

    public WebElement getCodeInput() {
        return codeInput;
    }

    public WebElement getSaveUserGroupBtn() {
        return saveUserGroupBtn;
    }

    public WebElement getUserGroupNameForAssert() {
        return userGroupNameForAssert;
    }

    public WebElement getUserNameForAssert() {
        return userNameForAssert;
    }

    public WebElement getUserGroup() {
        return userGroup;
    }

    public WebElement getCheckBoxOut() {
        return checkBoxOut;
    }

    public WebElement getConfirmDel() {
        return confirmDel;
    }
}
