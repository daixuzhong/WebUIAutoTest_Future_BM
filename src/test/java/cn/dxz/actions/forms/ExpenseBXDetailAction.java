package cn.dxz.actions.forms;

import cn.dxz.base.Constants;
import cn.dxz.pages.forms.ExpenseBXDetailPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.List;
import java.util.SplittableRandom;

/**
 * @author daixuzhong
 * @title: ExpenseBXDetailAction
 * @description: TODO
 * @date 2019/5/21
 */
public class ExpenseBXDetailAction {

    private static Logger logger = LoggerFactory.getLogger(ExpenseBXDetailAction.class);

    private WebDriver driver;

    private ExpenseBXDetailPage ebxdp;

    public ExpenseBXDetailAction(WebDriver driver) {
        this.driver = driver;
        ebxdp = new ExpenseBXDetailPage(driver);
    }

    /**
     * 获取单据编号的值
     * @return
     */
    public String getTicketCode() {
        return ebxdp.getTicketCode().getText();
    }

    /**
     * 校验标题内容
     * @param title
     */
    public void checkTitle(String title) {
        Assert.assertEquals(ebxdp.getTitle().getText(), title);
    }

    /**
     * 校验事由内容
     * @param incident
     */
    public void checkIncident(String incident) {
        Assert.assertEquals(ebxdp.getIncident().getText(), incident);
    }

    /**
     * 校验付款方式
     * @param payType
     */
    public void checkPayType(String payType) {
        Assert.assertEquals(ebxdp.getPayType().getText(), payType);
    }

    /**
     * 校验收款人
     * @param refItem1
     */
    public void checkRefItem1(String refItem1) {
        Assert.assertEquals(ebxdp.getRefItem1().getText(), refItem1);
    }

    /**
     * 校验金额
     * @param amount
     */
    public void checkAmount(String amount) {
        logger.debug(ebxdp.getAmount().getText());
        logger.debug(amount);
        Assert.assertEquals(ebxdp.getAmount().getText(), amount);
    }


    /**
     * 校验预算表
     * @param budgetSheet
     */
    public void checkBudgetSheet(String budgetSheet) {
        Assert.assertEquals(ebxdp.getBudgetSheet().getText(), budgetSheet);
    }

    /**
     * 校验预算项
     * @param budgetItem
     */
    public void checkBudgetItem(String budgetItem) {
        Assert.assertEquals(ebxdp.getBudgetItem().getText(), budgetItem);
    }

    /**
     * 成本中心
     * @param costCenter
     */
    public void checkCostCenter(String costCenter) {
        Assert.assertEquals(ebxdp.getCostCenter().getText(), costCenter);
    }

    /**
     * 校验发票类型
     * @param invoiceType
     */
    public void checkInvoiceType(String invoiceType) {
        Assert.assertEquals(ebxdp.getInvoiceType().getText(), invoiceType);
    }

    /**
     * 校验税率
     * @param taxRate
     */
    public void checkTaxRate(String taxRate) {
        Assert.assertEquals(ebxdp.getTaxRate().getText(), taxRate);
    }

    /**
     * 校验审批环节
     * @param step
     * @param num
     */
    public void checkStep(String step, int num) {
        switch (num) {
            case 1:
                Assert.assertEquals(ebxdp.getStep1().getText(), step);
                break;
            case 2:
                Assert.assertEquals(ebxdp.getStep2().getText(), step);
                break;
            default:
                Assert.fail();
        }

    }

    /**
     * 校验审批人
     * @param operator
     * @param num
     */
    public void checkOperator(String operator, int num) {
        switch (num) {
            case 1:
                Assert.assertEquals(ebxdp.getOperator1().getText(), operator);
                break;
            case 2:
                Assert.assertEquals(ebxdp.getOperator2().getText(), operator);
                break;
            default:
                Assert.fail();
        }

    }

    /**
     * 校验审批状态
     * @param status
     * @param num
     */
    public void checkStatus(String status, int num) {
        switch (num) {
            case 1:
                Assert.assertEquals(ebxdp.getStatus1().getText(), status);
                break;
            case 2:
                Assert.assertEquals(ebxdp.getStatus2().getText(), status);
                break;
            default:
                Assert.fail();
        }
    }

    /**
     * 点击撤回
     */
    public void clickRecall() {
        ebxdp.click(ebxdp.getRecall());
    }

    /**
     * 弹框-确定
     */
    public void clickConfirmInBox() {
        ebxdp.click(ebxdp.getConfirmBtn());
    }

    /**
     * 判断结果
     */
    public void assertRes() {
        String msg = ebxdp.getHint().getText();
        Assert.assertTrue(msg.contains(Constants.Status.SUCCESS.getText()), "~~~~~error~~~~~");
    }

}
