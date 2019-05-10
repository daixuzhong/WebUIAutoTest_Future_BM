package cn.dxz.business.forms;

import cn.dxz.actions.forms.ExpenseBXAction;
import cn.dxz.business.entities.ExpenseBX;
import cn.dxz.utils.ProUtil;
import org.openqa.selenium.WebDriver;

/**
 * @author daixuzhong
 * @title: ExpenseBXBusiness
 * @description: TODO
 * @date 2019/5/10
 */
public class ExpenseBXBusiness {

    ExpenseBXAction ebxa;

    public ExpenseBXBusiness(WebDriver driver) {
        ebxa = new ExpenseBXAction(driver);
    }

    /**
     * 费用报销单据数据填写
     * @param param
     */
    public void wirteExpenseBX(ExpenseBX param) {
        //输入标题
        ebxa.sendKeyTitle(param.getTitle());
        //输入事由
        ebxa.sendKeyIncident(param.getIncident());
        ebxa.clickPayType();
        ebxa.clickFirstType();
        ebxa.clickPayee();
        ebxa.clickFirstPayee();
        ebxa.clickAddDetail();
        //进入明细
        ebxa.clickBudgetSheet();
        ebxa.clickFirstChoice();
        ebxa.clickBudgetItem();
        ebxa.clickFirstChoice();
        ebxa.clickCostCenter();
        ebxa.clickFirstChoice();
        ebxa.clickInvoiceType();
        ebxa.clickSpecialsInvoice();
        ebxa.sendKeyPayableAmount(param.getAmount());
        ebxa.clickTaxRate();
        ebxa.clickNoTax();
        ebxa.clickSaveDetailBtn();

        //
        ebxa.clickSubmitBtn();
        ebxa.clickLastSubBtn();

    }


}
