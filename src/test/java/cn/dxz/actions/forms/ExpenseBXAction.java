package cn.dxz.actions.forms;

import cn.dxz.pages.flowCenter.forms.ExpenseBXPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author daixuzhong
 * @title: ExpenseBXAction
 * @description: 费用报销单填报操作
 * @date 2019/5/10
 */
public class ExpenseBXAction {

    private static Logger logger = LoggerFactory.getLogger(ExpenseBXAction.class);

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
     * 点击付款方式并选择
     * @param payType
     */
    public void choosePayType(String payType) throws Exception {
        //点击搜索框
        ebx.click(ebx.getQueryPayType());
        Thread.sleep(1000);
        ebx.sendKey(ebx.getQueryPayTypeText(), payType);
        Thread.sleep(1000);
        ebx.click(ebx.getPayTypeRes());
    }



    /**
     * 点击收款人并选择
     * @param payee
     */
    public void choosePayee(String payee) throws InterruptedException {
        ebx.click(ebx.getQueryPayee());
        Thread.sleep(1000);
        ebx.sendKey(ebx.getQueryPayeeText(), payee);
        Thread.sleep(1000);
        ebx.click(ebx.getPayeeRes());
    }


    /**
     * 点击添加明细按钮(1添加、2删除、3取消删除)
     */
    public void clickAddDetail(int index) {
        //list下标从0开始
        List<WebElement> payDetailBtn = ebx.getPayDetailBtn();
        ebx.click(ebx.getPayDetailBtn().get(index - 1));
    }

    /**
     * 选择预算表
     * @param budgetSheet
     */
    public void chooseBudgetSheet(String budgetSheet) throws InterruptedException {
        ebx.click(ebx.getQueryBudgetSheet());
        Thread.sleep(1000);
        ebx.sendKey(ebx.getQueryBudgetSheetText(), budgetSheet);
        Thread.sleep(1000);
        ebx.click(ebx.getBudgetSheetRes());

    }

    /**
     * 选择预算项
     * @param budgetItem
     */
    public void chooseBudgetItem(String budgetItem) throws InterruptedException {
        ebx.click(ebx.getQueryBudgetItem());
        Thread.sleep(1000);
        ebx.sendKey(ebx.getQueryBudgetItemText(), budgetItem);
        Thread.sleep(1000);
        ebx.click(ebx.getBudgetItemRes());

    }

    /**
     * 选择成本中心
     * @param costCenter
     */
    public void chooseCostCenter(String costCenter) throws InterruptedException {
        ebx.click(ebx.getQueryCostCenter());
        Thread.sleep(1000);
        ebx.sendKey(ebx.getQueryCostCenterText(), costCenter);
        Thread.sleep(1000);
        ebx.click(ebx.getCostCenterRes());


    }


    /**
     * 点击发票类型选择框
     * @param invoiceType
     */
    public void clickInvoiceType(String invoiceType) {
        Select select = new Select(ebx.getInvoiceType());
        select.selectByVisibleText(invoiceType);
    }


    /**
     * 输入应付金额
     * @param number
     */
    public void sendKeyPayableAmount(String number) {
        ebx.sendKey(ebx.getPayAmount(), number);
    }

    /**
     * 选择税率
     * @param taxRate
     */
    public void clickTaxRate(String taxRate) {
        Select select = new Select(ebx.getTaxRate());
        select.selectByVisibleText(taxRate);

    }

    /**
     * 明细-点击确定
     */
    public void clickSaveDetailBtn() {
        ebx.click(ebx.getSaveDetailBtn());
    }

    /**
     * 点击按钮组中的按钮（1提交、2保存、3流程图、4关闭）
     */
    public void clickSubmitBtn(int index) {
        List<WebElement> btnList = ebx.getBtnList();
        ebx.click(btnList.get(index - 1));
    }

    /**
     * 确认提交该单据审批
     */
    public void clickConfirmSubmit() {
        ebx.click(ebx.getConfirmSubmit());
    }

    /**
     * 提交成功的弹框是否出现
     * @return
     */
    public boolean isSuccess() {
        return ebx.assertElementExist(ebx.getSuccessFlag());
    }




}
