package cn.dxz.business;

import cn.dxz.actions.AllBudgetAction;
import org.openqa.selenium.WebDriver;

/**
 * @author daixuzhong
 * @title: AllBudgetBusiness
 * @description: TODO
 * @date 2019/5/10
 */
public class AllBudgetBusiness {

    AllBudgetAction aba;

    public AllBudgetBusiness(WebDriver driver) {
        aba = new AllBudgetAction(driver);
    }

    /**
     * 新建一个费用报销流程前置步骤：预算执行-新建流程-费用报销
     */
    public void newExpenseBX() throws InterruptedException {
        aba.clickBudgetExecute();
        Thread.sleep(1000);
        aba.clickNewProcess();
        Thread.sleep(1000);
        aba.clickExpenseBX();

    }

}
