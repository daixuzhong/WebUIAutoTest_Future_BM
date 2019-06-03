package cn.dxz.business.flowCenter;

import cn.dxz.actions.flowCenter.BudgetExecutionAction;
import cn.dxz.actions.HomeAction;
import cn.dxz.actions.forms.ExpenseBXAction;
import cn.dxz.actions.forms.ExpenseBXDetailAction;
import cn.dxz.base.Constants;
import cn.dxz.business.HomeBusiness;
import cn.dxz.business.LoginBusiness;
import cn.dxz.business.entities.ExpenseBX;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.Date;

/**
 * @author daixuzhong
 * @title: AllBudgetBusiness
 * @description: TODO
 * @date 2019/5/10
 */
public class BudgetExecutionBusiness {

    private static Logger logger = LoggerFactory.getLogger(BudgetExecutionBusiness.class);

    BudgetExecutionAction bea;
    ExpenseBXAction ebxa;
    HomeAction ha;
    ExpenseBXDetailAction ebxda;
    LoginBusiness loginBusiness;
    HomeBusiness homeBusiness;

    public BudgetExecutionBusiness(WebDriver driver) {
        bea = new BudgetExecutionAction(driver);
        ebxa = new ExpenseBXAction(driver);
        ha = new HomeAction(driver);
        ebxda = new ExpenseBXDetailAction(driver);
        loginBusiness = new LoginBusiness(driver);
        homeBusiness = new HomeBusiness(driver);
    }

    /**
     * 新建一个费用报销流程：预算执行-新建流程-费用报销-填写数据-提交
     * @param param
     */
    public void newExpenseBX(ExpenseBX param) throws Exception {
        bea.clickBudgetExecute();
        Thread.sleep(1000);
        bea.clickNewProcess();
        Thread.sleep(1000);
        bea.clickExpenseBX();

        //填写费用报销
        //输入标题
        ebxa.sendKeyTitle(param.getTitle());
        logger.debug(param.getTitle());
        //输入事由
        ebxa.sendKeyIncident(param.getIncident());
        //选择付款方式
        ebxa.choosePayType(param.getPayType());
        Thread.sleep(1000);
        //选择收款人
        ebxa.choosePayee(param.getPayee());

        Thread.sleep(1000);
        //点击添加明细（1添加、2删除、3取消删除）
        ebxa.clickAddDetail(Constants.Numbers.ONE.getCode());
        Thread.sleep(1000);
        //选择预算表
        ebxa.chooseBudgetSheet(param.getBudgetSheet());
        Thread.sleep(1000);
        //选择预算项
        ebxa.chooseBudgetItem(param.getBudgetItem());
        Thread.sleep(1000);
        //选择成本中心
        ebxa.chooseCostCenter(param.getCostCenter());
        Thread.sleep(1000);

        //选择发票类型
        ebxa.clickInvoiceType(param.getInvoiceType());
        //应付金额
        ebxa.sendKeyPayableAmount(param.getAmount());
        //选择税率
        ebxa.clickTaxRate(param.getTaxRate());
        //确定付款明细
        ebxa.clickSaveDetailBtn();
        Thread.sleep(1000);
        //提交按钮（1提交、2保存、3流程图、4关闭）
        ebxa.clickSubmitBtn(Constants.Numbers.ONE.getCode());
        Thread.sleep(1000);
        //确认提交
        ebxa.clickConfirmSubmit();
        Thread.sleep(5000);
    }

    /**
     * 断言是否出现提交成功的弹框
     */
    public void assertNewExpenseBX() {
        //判断是否出现提交成功的弹框
        Assert.assertTrue(ebxa.isSuccess(), "*******提交费用报销单失败！");
    }

    /**
     * 点击查询统计-我提交的单据-检查报销单填写是否正确
     * @param param
     */
    public void checkExpenseBX(ExpenseBX param) throws InterruptedException {
        //点击查询统计
        bea.clickQueryStatistics();
        Thread.sleep(1000);
        //点击我填报的单据
        bea.clickQueryStatisticsList(Constants.MY_TICKET);
        Thread.sleep(1000);
        //选择搜索条件为已提交
        bea.chooseBillStatus(Constants.Status.SUBMITTED.getText());
        Thread.sleep(1000);
        //点击编辑第一条
        bea.clickEditBtn1();

        //校验数据
        ebxda.checkTitle(param.getTitle());
        ebxda.checkIncident(param.getIncident());
        ebxda.checkPayType(param.getPayType());
        ebxda.checkRefItem1(param.getPayee());

        //校验付款明细
        ebxda.checkPaymentDetail(param);
    }



    /**
     * 撤回提交的费用报销单
     */
    public void recall() throws InterruptedException {
        ebxda.clickRecall();
        Thread.sleep(1000);
        ebxda.clickConfirmInBox();
        Thread.sleep(5000);
    }

    /**
     * 编辑费用报销单重新提交
     * @param param
     */
    public void reEditAndSubmit(ExpenseBX param) throws InterruptedException {
        //选择未提交
        bea.chooseBillStatus(Constants.Status.UN_SUBMITTED.getText());
        Thread.sleep(2000);
        //输入查询条件并搜索
        bea.sendKeyQueryBillInput(param.getTitle());
        Thread.sleep(1000);
        bea.clickEditBtn1();
        //点击提交
        ebxa.clickSubmitBtn(Constants.Numbers.ONE.getCode());
        //确认提交
        ebxa.clickConfirmSubmit();
        Thread.sleep(5000);

    }


    /**
     * 校验审批历史
     * @param step
     */
    public void checkApprovalHistroy(int step) {
        //1表示第一条审批历史
        ebxda.checkStep("经办人", 1);
        ebxda.checkOperator("测试123456", 1);
        ebxda.checkStatus(Constants.Status.FINISHED.getText(), 1);
        //2表示第二条审批历史
        ebxda.checkStep("总部财务会计", 2);
        ebxda.checkOperator("黄晓燕", 2);
        ebxda.checkStatus(Constants.Status.UN_FINISHED.getText(), 2);
    }

}
