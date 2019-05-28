package cn.dxz.business.allBudget;

import cn.dxz.actions.allBudge.AllBudgetAction;
import cn.dxz.actions.HomeAction;
import cn.dxz.actions.forms.ExpenseBXAction;
import cn.dxz.actions.forms.ExpenseBXDetailAction;
import cn.dxz.base.Constants;
import cn.dxz.business.entities.ExpenseBX;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

/**
 * @author daixuzhong
 * @title: AllBudgetBusiness
 * @description: TODO
 * @date 2019/5/10
 */
public class AllBudgetBusiness {

    private static Logger logger = LoggerFactory.getLogger(AllBudgetBusiness.class);

    private static String ticketCode;
    AllBudgetAction aba;
    ExpenseBXAction ebxa;
    HomeAction ha;
    ExpenseBXDetailAction ebxda;

    public AllBudgetBusiness(WebDriver driver) {
        aba = new AllBudgetAction(driver);
        ebxa = new ExpenseBXAction(driver);
        ha = new HomeAction(driver);
        ebxda = new ExpenseBXDetailAction(driver);
    }

    /**
     * 新建一个费用报销流程：预算执行-新建流程-费用报销-填写数据-提交
     * @param param
     */
    public void newExpenseBX(ExpenseBX param) throws Exception {
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

        Thread.sleep(1000);
        //进入明细
        ebxa.chooseBudgetSheet(param.getBudgetSheet());
        Thread.sleep(1000);
        ebxa.chooseBudgetItem(param.getBudgetItem());
        Thread.sleep(1000);
        ebxa.chooseCostCenter(param.getCostCenter());
        Thread.sleep(1000);

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

        //判断是否出现提交成功的弹框
        if (!ebxa.isSuccess()) {
            logger.error("提交费用报销不成功!");
            throw new Exception();
        }

    }

    /**
     * 点击查询统计-我提交的单据-检查报销单填写是否正确
     */
    public void checkExpenseBX(ExpenseBX param) throws InterruptedException {
        aba.clickBudgetExecute();
        aba.clickQueryqueryStatistics();
        Thread.sleep(1000);
        aba.clickMyWritedBill();
        Thread.sleep(1000);
        aba.clickCommited();
        Thread.sleep(1000);
        aba.clickEditBtn1();

        //校验数据
        ebxda.checkTitle(param.getTitle());
        ebxda.checkIncident(param.getIncident());
        ebxda.checkPayType(param.getPayType());
        ebxda.checkRefItem1(param.getPayee());
        ebxda.checkAmount("10,000.00");
        ebxda.checkBudgetSheet(param.getBudgetSheet());
        ebxda.checkBudgetItem(param.getBudgetItem());
        ebxda.checkCostCenter(param.getCostCenter());
        ebxda.checkInvoiceType("专票");
        ebxda.checkTaxRate(param.getTaxRate());
        ebxda.checkStep("经办人", 1);
        ebxda.checkOperator("测试123456", 1);
        ebxda.checkStatus(Constants.Status.FINISHED.getText(), 1);
        ebxda.checkStep("总部财务会计", 2);
        ebxda.checkOperator("黄晓燕", 2);
        ebxda.checkStatus(Constants.Status.UN_FINISHED.getText(), 2);

    }

    /**
     * 撤回提交的费用报销单
     */
    public void recall() throws InterruptedException {
        //获取单据编号
        ticketCode = ebxda.getTicketCode();
        ebxda.clickRecall();
        Thread.sleep(1000);
        ebxda.clickConfirmInBox();
        Thread.sleep(5000);
        ebxda.assertRes();
    }

    /**
     * 编辑费用报销单重新提交
     */
    public void reNewExpenseBX(ExpenseBX param) {

    }

}
