package cn.dxz.pages;

import cn.dxz.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author daixuzhong
 * @title: AllBudgetPage
 * @description: 全面预算页面
 * @date 2019/5/10
 */
public class AllBudgetPage extends BasePage {

    //预算执行
    @FindBy(xpath = "/html/body/div/aside/div[1]/div/div/div/ul/li[4]/a")
    private WebElement budgetExecute;

    //新建流程
    @FindBy(xpath = "/html/body/div/aside/div[1]/div/div/div/ul/li[4]/ul/li/a")
    private WebElement newProcess;

    //费用报销
    @FindBy(xpath = "/html/body/div/div/ng-view/ng-include/div/div[2]/div/div[2]/div/a[1]")
    private WebElement expenseBX;



    public AllBudgetPage(WebDriver driver) {
        super(driver);
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
}
