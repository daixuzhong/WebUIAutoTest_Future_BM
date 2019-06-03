package cn.dxz.pages.flowCenter;

import cn.dxz.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * @author daixuzhong
 * @title: AllBudgetPage
 * @description: 全面预算-预算执行页面
 * @date 2019/5/10
 */
public class BudgetExecutionPage extends BasePage {

    //预算执行
    @FindBy(partialLinkText = "预算执行")
    private WebElement budgetExecute;

    //新建流程
    @FindBy(xpath = "/html/body/div/aside/div[1]/div/div/div/ul/li[4]/ul/li/a")
    private WebElement newProcess;

    //费用报销
    @FindBy(xpath = "/html/body/div/div/ng-view/ng-include/div/div[2]/div/div[2]/div/a[1]")
    private WebElement expenseBX;

    //查询统计
    @FindBy(partialLinkText = "查询统计")
    private WebElement queryStatistics;

    //查询统计下拉菜单
    @FindBy(xpath = "//*[@id=\"nav_2284\"]/li/a")
    private List<WebElement> queryStatisticsList;

    //搜索查询输入框
    @FindBy(xpath = "//input[@title=\"输入关键字后按ENTER键\"]")
    private WebElement queryBillInput;

    //搜索条件选择按钮组，默认为未提交（未提交，已提交，已完成）
    @FindBy(xpath = "/html/body/div/div/ng-view/div/div[2]/div/div/ng-include/div/button")
    private WebElement queryCondition;

    //搜索条件下拉框选择---已提交
    @FindBy(partialLinkText = "已提交")
    private WebElement committed;

    //搜索条件下拉框选择---未提交
    @FindBy(partialLinkText = "未提交")
    private WebElement uncommitted;

    //搜索条件下拉框选择---已完成
    @FindBy(partialLinkText = "已完成")
    private WebElement finished;

    //我提交的单据列表第一条的编辑按钮
    @FindBy(xpath = "/html/body/div/div/ng-view/div/div[3]/div/table/tbody/tr[1]/td[2]/a")
    private WebElement editBtn1;

    public BudgetExecutionPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getEditBtn1() {
        return editBtn1;
    }

    public WebElement getCommitted() {
        return committed;
    }

    public WebElement getUncommitted() {
        return uncommitted;
    }

    public WebElement getQueryStatistics() {
        return queryStatistics;
    }

    public List<WebElement> getQueryStatisticsList() {
        return queryStatisticsList;
    }

    public WebElement getExpenseBX() {
        return expenseBX;
    }

    public WebElement getNewProcess() {
        return newProcess;
    }

    public WebElement getBudgetExecute() {
        return budgetExecute;
    }

    public WebElement getQueryCondition() {
        return queryCondition;
    }

    public WebElement getFinished() {
        return finished;
    }

    public WebElement getQueryBillInput() {
        return queryBillInput;
    }
}
