package cn.dxz.actions;

import cn.dxz.pages.AllBudgetPage;
import org.openqa.selenium.WebDriver;

/**
 * @author daixuzhong
 * @title: AllBudgetAction
 * @description: TODO
 * @date 2019/5/10
 */
public class AllBudgetAction {

    public WebDriver driver;
    AllBudgetPage aba;

    public AllBudgetAction(WebDriver driver) {
        this.driver = driver;
        aba = new AllBudgetPage(driver);
    }

    /**
     * 点击预算执行
     */
    public void clickBudgetExecute() {
        aba.click(aba.getBudgetExecute());
    }

    /**
     * 点击新建流程
     */
    public void clickNewProcess() {
        aba.click(aba.getNewProcess());
    }

    /**
     * 点击费用报销
     */
    public void clickExpenseBX() {
        aba.click(aba.getExpenseBX());
    }
}
