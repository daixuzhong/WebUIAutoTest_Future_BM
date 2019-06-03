package cn.dxz.business.allBudget;

import cn.dxz.actions.allBudge.BudgetMakingAction;
import cn.dxz.business.entities.BudgetMaking;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author daixuzhong
 * @title: BudgetMakingBusiness
 * @description: TODO
 * @date 2019/5/29
 */
public class BudgetMakingBusiness {
    private static Logger logger = LoggerFactory.getLogger(BudgetMakingBusiness.class);

    private BudgetMakingAction bma;

    public BudgetMakingBusiness(WebDriver driver) {
        bma = new BudgetMakingAction(driver);
    }


    /**
     * 编辑预算表
     * @param budgetMaking
     */
    public void makePropertyFeeTable(BudgetMaking budgetMaking) throws InterruptedException {
        bma.clickBudgetMakingList(budgetMaking.getNavi());
        Thread.sleep(1000);
        bma.chooseDepartment(budgetMaking.getDepartment());
        Thread.sleep(1000);
        bma.chooseBudgetTable(budgetMaking.getTableName());
        Thread.sleep(1000);
    }
}
