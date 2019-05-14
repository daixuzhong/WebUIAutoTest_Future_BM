package cn.dxz.business;

import cn.dxz.actions.AllBudgetAction;
import cn.dxz.actions.HomeAction;
import cn.dxz.actions.forms.ExpenseBXAction;
import cn.dxz.business.entities.ExpenseBX;
import org.openqa.selenium.WebDriver;

/**
 * @author daixuzhong
 * @title: AllBudgetBusiness
 * @description: TODO
 * @date 2019/5/10
 */
public class AllBudgetBusiness {

    AllBudgetAction aba;
    ExpenseBXAction ebxa;
    HomeAction ha;

    public AllBudgetBusiness(WebDriver driver) {
        aba = new AllBudgetAction(driver);
        ebxa = new ExpenseBXAction(driver);
        ha = new HomeAction(driver);
    }

    /**
     * 新建一个费用报销流程：预算执行-新建流程-费用报销-填写数据-提交
     * @param param
     */
    public void newExpenseBX(ExpenseBX param) throws InterruptedException {
        aba.clickBudgetExecute();
        Thread.sleep(1000);
        aba.clickNewProcess();
        Thread.sleep(1000);
        aba.clickExpenseBX();

        //填写费用报销
        //输入标题
        ebxa.sendKeyTitle(param.getTitle());
        //输入事由
        ebxa.sendKeyIncident(param.getIncident());
        //选择付款方式
        ebxa.choosePayType(param.getPayType());
        Thread.sleep(1000);
        //选择收款人
        ebxa.choosePayee(param.getPayee());

        ebxa.clickAddDetail();

        //进入明细
        ebxa.chooseBudgetSheet(param.getBudgetSheet());
        Thread.sleep(500);
        ebxa.chooseBudgetItem(param.getBudgetItem());
        Thread.sleep(500);
        ebxa.chooseCostCenter(param.getCostCenter());
        Thread.sleep(500);

        ebxa.clickInvoiceType();
        ebxa.clickSpecialsInvoice();
        ebxa.sendKeyPayableAmount(param.getAmount());
        ebxa.clickTaxRate();
        ebxa.chooseTaxRate(param.getTaxRate());
        ebxa.clickSaveDetailBtn();

        //提交
        ebxa.clickSubmitBtn();
//        ebxa.clickSaveBtn();
        ebxa.clickLastSubBtn();




    }

}
