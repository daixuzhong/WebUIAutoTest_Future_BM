package cn.dxz.pages;

import cn.dxz.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sun.awt.windows.WEmbeddedFrame;

import java.util.List;

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
    @FindBy(xpath = "//i[@class=\"ti-power-off\"]")
    private WebElement logOff;

    //上方导航栏按钮组（全面预算，系统管理，门户管理......）
    @FindBy(xpath = "//*[@id=\"dorpdownnav\"]/li/a")
    private List<WebElement> topbar;

    //右上角按钮-我的任务
    @FindBy(xpath = "//a[@title=\"我的任务\"]")
    private WebElement myTask;

    //我的任务-查看更多
    @FindBy(xpath = "//a[text()=\"查看更多\" and contains(@href, \"WorkflowTask\")]")
    private WebElement seeMoreTask;

    public WebElement getLogOff() {
        return logOff;
    }

    public List<WebElement> getTopbar() {
        return topbar;
    }

    public WebElement getMyTask() {
        return myTask;
    }

    public WebElement getSeeMoreTask() {
        return seeMoreTask;
    }
}
