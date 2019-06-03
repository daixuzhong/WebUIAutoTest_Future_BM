package cn.dxz.pages.allBudget;

import cn.dxz.base.BasePage;
import okhttp3.WebSocketListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.temporal.WeekFields;
import java.util.List;

/**
 * @author daixuzhong
 * @title: BudgetMakingPage
 * @description: TODO
 * @date 2019/5/29
 */
public class BudgetMakingPage extends BasePage {
    public BudgetMakingPage(WebDriver driver) {
        super(driver);
    }

    //预算编制
    @FindBy(partialLinkText = "预算编制")
    private WebElement budgetMaking;

    //预算编制下拉菜单
    @FindBy(xpath = "//*[@id=\"nav_2259\"]/li/a")
    private List<WebElement> budgetMakingList;

    //组织机构名称列表
    @FindBy(xpath = "//*[@class=\"fancytree-title\"]")
    private List<WebElement> departmentList;

    //预算表名
    @FindBy(xpath = "//*[@ng-if=\"!table.groupName\"]/td[1]")
    private List<WebElement> tableNameList;

    //打开预算编的✔按钮
    private WebElement openTableBtn;

    public WebElement getOpenTableBtn(WebElement element) {
        return nodeElement(element, By.xpath("parent::tr/descendant::i[3]"));
    }

    public WebElement getBudgetMaking() {
        return budgetMaking;
    }

    public List<WebElement> getBudgetMakingList() {
        return budgetMakingList;
    }

    public List<WebElement> getDepartmentList() {
        return departmentList;
    }

    public List<WebElement> getTableNameList() {
        return tableNameList;
    }
}
