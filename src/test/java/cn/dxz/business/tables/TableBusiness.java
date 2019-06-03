package cn.dxz.business.tables;

import cn.dxz.actions.tables.TableAction;
import cn.dxz.base.Constants;
import cn.dxz.business.entities.BudgetMaking;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author daixuzhong
 * @title: TableBusiness
 * @description: TODO
 * @date 2019/5/29
 */
public class TableBusiness {

    private TableAction ta;

    public TableBusiness(WebDriver driver) {
        ta = new TableAction(driver);
    }

    /**
     * 编制预算表
     * @param budgetMaking
     */
    public void editTable(BudgetMaking budgetMaking) throws InterruptedException {
        //点击关联表按钮
        ta.clickRowRelaBtn(budgetMaking.getBudgetItem());
        Thread.sleep(1000);
        //打开关系表
        ta.openRelaTable(budgetMaking.getRelaTable());
        Thread.sleep(3000);
        //点击编辑按钮
        ta.clickBtn(Constants.Buttons.EDIT.getText());
        Thread.sleep(1000);

        //填入数据


    }


}
