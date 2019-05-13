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

    //用户组搜索框
    @FindBy(xpath = "/html/body/div/div/ng-view/div/div[2]/div/div[2]/div/div/div[1]/input")
    private WebElement searchInput;

    //列表页第1条的checkbox
    @FindBy(xpath = "/html/body/div/div/ng-view/div/div[2]/div/div[3]/div/table/tbody/tr[1]/td[1]/input")
    private WebElement firstCheckBox;

    //列表页第1条的编辑按钮
    @FindBy(xpath = "/html/body/div/div/ng-view/div/div[2]/div/div[3]/div/table/tbody/tr[1]/td[2]/a")
    private WebElement firstEditBtn;

    //用户组列表中名称的元素列表
    @FindBy(xpath = "/html/body/div/div/ng-view/div/div[1]/ul/li/ul/li/span/span[3]")
    private List<WebElement> userGroupNameList;

    //用户组里添加用户弹框-搜索框
    @FindBy(xpath = "//*[@id=\"pageSlideContainer_1\"]/div[2]/div/div[2]/div/div/div/input")
    private WebElement searchUserInput;

    //搜索结果第1行的勾选框
    @FindBy(name = "btSelectItem")
    private WebElement checkBox;

    //添加并退出按钮
    @FindBy(xpath = "//*[@id=\"pageSlideContainer_1\"]/div[1]/div/button[2]")
    private WebElement addAndQuitBtn;







}
