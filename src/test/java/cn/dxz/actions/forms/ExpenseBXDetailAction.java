package cn.dxz.actions.forms;

import cn.dxz.base.Constants;
import cn.dxz.business.entities.ExpenseBX;
import cn.dxz.pages.flowCenter.forms.ExpenseBXDetailPage;
import cn.dxz.utils.NumberFormatUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.List;

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
     * 校验付款明细里的各项内容
     * @param expenseBX
     */
    public void checkPaymentDetail(ExpenseBX expenseBX) {
        List<WebElement> detailList = ebxdp.getDetailList();
        List<WebElement> detailNumberList = ebxdp.getDetailNumberList();
        //校验预算表
        Assert.assertEquals(detailList.get(Constants.Numbers.ONE.getCode()).getText(), expenseBX.getBudgetSheet());
        //校验预算项
        Assert.assertEquals(detailList.get(Constants.Numbers.TWO.getCode()).getText(), expenseBX.getBudgetItem());
        //校验成本中心
        Assert.assertEquals(detailList.get(Constants.Numbers.THREE.getCode()).getText(), expenseBX.getCostCenter());
        //校验发票类型
        Assert.assertEquals(detailList.get(Constants.Numbers.FOUR.getCode()).getText(), expenseBX.getInvoiceType());
        //校验应付金额
        String amount = NumberFormatUtil.format(detailNumberList.get(Constants.Numbers.ZERO.getCode()).getText());
        Assert.assertEquals(amount, expenseBX.getAmount());
        //校验税率
        Assert.assertEquals(detailList.get(Constants.Numbers.SEVEN.getCode()).getText(), expenseBX.getTaxRate());
        /**
         * 校验税额+不含税金额是否等于应付金额
         */
        //税额
        String taxAmount = NumberFormatUtil.format(detailNumberList.get(Constants.Numbers.TWO.getCode()).getText());
        //不含税金额
        String unTaxAmount = NumberFormatUtil.format(detailNumberList.get(Constants.Numbers.THREE.getCode()).getText());
        double res = Double.valueOf(taxAmount) + Double.valueOf(unTaxAmount);
        Assert.assertEquals(NumberFormatUtil.format(res), amount);

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
     * 点击关闭
     */
    public void clickClose() {
        ebxdp.click(ebxdp.getClose());
    }

    /**
     * 弹框-确定
     */
    public void clickConfirmInBox() {
        ebxdp.click(ebxdp.getConfirmBtn());
    }


}
