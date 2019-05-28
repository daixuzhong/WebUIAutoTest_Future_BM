package cn.dxz.actions.allBudge;

import cn.dxz.pages.allBudget.AllBudgetPage;
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

    /**
     * 点击查询统计
     */
    public void clickQueryqueryStatistics() {
        aba.click(aba.getQueryStatistics());
    }

    /**
     * 点击我提交的单据
     */
    public void clickMyWritedBill() {
        aba.click(aba.getMyWritedBill());
    }

    /**
     * 点击搜索条件选择按钮，再点击下拉框中的已提交
     */
    public void clickCommited() throws InterruptedException {
        aba.click(aba.getQueryCondition());
        Thread.sleep(1000);
        aba.click(aba.getCommitted());
    }

    public void chooseQueryCondition(String condition) throws InterruptedException {
        switch (condition) {
        }
        aba.click(aba.getQueryCondition());
        Thread.sleep(1000);
        aba.click(aba.getCommitted());
    }

    /**
     * 点击我提交的单据列表中第一条的编辑按钮
     */
    public void clickEditBtn1() {
        aba.click(aba.getEditBtn1());
    }


}
