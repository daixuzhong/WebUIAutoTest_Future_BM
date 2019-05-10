package cn.dxz.actions.forms;

import cn.dxz.pages.forms.ExpenseBXPage;
import org.openqa.selenium.WebDriver;

/**
 * @author daixuzhong
 * @title: ExpenseBXAction
 * @description: TODO
 * @date 2019/5/10
 */
public class ExpenseBXAction {

    public WebDriver driver;
    ExpenseBXPage ebx;

    public ExpenseBXAction(WebDriver driver) {
        this.driver = driver;
        ebx = new ExpenseBXPage(driver);
    }

    /**
     * 输入标题
     * @param title
     */
    public void sendKeyTitle(String title) {
        ebx.sendKey(ebx.getExpenseTitle(), title);
    }

    /**
     * 输入事由
     * @param incident
     */
    public void sendKeyIncident(String incident) {
        ebx.sendKey(ebx.getIncident(), incident);
    }

    /**
     * 点击付款方式选择框
     */
    public void clickPayType() {
        ebx.click(ebx.getChoosePayType());
    }

    /**
     * 点击付款方式的第一个选项
     */
    public void clickFirstType() {
        ebx.click(ebx.getFirstType());
    }

    /**
     * 点击收款人
     */
    public void clickPayee() {
        ebx.click(ebx.getPayee());
    }

    /**
     * 选择第一个收款人
     */
    public void clickFirstPayee() {
        ebx.click(ebx.getSecPayee());
    }

    /**
     * 点击添加明细
     */
    public void clickAddDetail() {
        ebx.click(ebx.getAddDetail());
    }

    /**
     * 点击预算表选择框
     */
    public void clickBudgetSheet() {
        ebx.click(ebx.getBudgetSheet());
    }

    /**
     * 明细选择框下拉第一项
     */
    public void clickFirstChoice() {
        ebx.click(ebx.getFirstChoice());
    }

    /**
     * 点击预算项选择框
     */
    public void clickBudgetItem() {
        ebx.click(ebx.getBudgetItem());
    }

    /**
     * 点击成本中心选择框
     */
    public void clickCostCenter() {
        ebx.click(ebx.getCostCenter());
    }

    /**
     * 点击发票类型选择框
     */
    public void clickInvoiceType() {
        ebx.click(ebx.getInvoiceType());
    }

    /**
     * 点击发票类型选择框第一栏-专票
     */
    public void clickSpecialsInvoice() {
        ebx.click(ebx.getSpecialsInvoice());
    }

    /**
     * 输入应付金额
     * @param number
     */
    public void sendKeyPayableAmount(String number) {
        ebx.sendKey(ebx.getPayAmount(), number);
    }

    /**
     * 点击税率选择框
     */
    public void clickTaxRate() {
        ebx.click(ebx.getTaxRate());
    }

    /**
     * 选择税率第一项无税
     */
    public void clickNoTax() {
        ebx.click(ebx.getNoTax());
    }

    /**
     * 明细-点击确定
     */
    public void clickSaveDetailBtn() {
        ebx.click(ebx.getSaveDetailBtn());
    }

    /**
     * 点击保存
     */
    public void clickSubmitBtn() {
        ebx.click(ebx.getSubmitBtn());
    }

    /**
     * 确认提交该单据审批
     */
    public void clickLastSubBtn() {
        ebx.click(ebx.getLastSubBtn());
    }

}
