package cn.dxz.actions.forms;

import cn.dxz.pages.forms.ExpenseBXPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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
     * 点击付款方式选择框输入付款方式并选择
     * @param key
     */
    public void choosePayType(String key) {
        //点击搜索框
        ebx.click(ebx.getChoosePayType());
        ebx.sendKey(ebx.getSearchInput(), key);
        ebx.click(ebx.getFirstType());
    }


    /**
     * 点击收款人
     */
    public void clickPayee() {
        ebx.click(ebx.getPayee());
    }

    /**
     * 选择收款人
     * @param payee
     */
    public void choosePayee(String payee) {
        clickPayee();
        ebx.sendKey(ebx.getSearchInput(), payee);
        ebx.click(ebx.getFirstPayee());
    }


    /**
     * 点击添加明细
     */
    public void clickAddDetail() {
        ebx.click(ebx.getAddDetail());
    }

    /**
     * 选择预算表
     * @param budgetSheet
     */
    public void chooseBudgetSheet(String budgetSheet) {
        ebx.click(ebx.getBudgetSheet());
        ebx.sendKey(ebx.getDetailInput(), budgetSheet);
        ebx.click(ebx.getFirstRes());
    }

    /**
     * 选择预算项
     * @param budgetItem
     */
    public void chooseBudgetItem(String budgetItem) {
        ebx.click(ebx.getBudgetItem());
        ebx.sendKey(ebx.getDetailInput(), budgetItem);
        ebx.click(ebx.getFirstRes());
    }

    /**
     * 选择成本中心
     * @param costCenter
     */
    public void chooseCostCenter(String costCenter) {
        ebx.click(ebx.getCostCenter());
        ebx.sendKey(ebx.getDetailInput(), costCenter);
        ebx.click(ebx.getFirstRes());
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
     * 选择税率
     * @param taxRate
     */
    public void chooseTaxRate(String taxRate) {
        List<WebElement> taxList = ebx.getTaxList();
        for (WebElement webElement : taxList) {
            if (StringUtils.equals(webElement.getText(), taxRate)) {
                ebx.click(webElement);
                return;
            }
        }
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
