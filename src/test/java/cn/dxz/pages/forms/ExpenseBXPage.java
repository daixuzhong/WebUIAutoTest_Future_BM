package cn.dxz.pages.forms;

import cn.dxz.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.XMLFormatter;

/**
 * @author daixuzhong
 * @title: ExpenseBX
 * @description: TODO
 * @date 2019/5/10
 */
public class ExpenseBXPage extends BasePage {

    public ExpenseBXPage(WebDriver driver) {
        super(driver);
    }

    //费用报销单-标题
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/div/div/div[2]/div[6]/div/input")
    private WebElement expenseTitle;

    //费用报销单-事由
    @FindBy(name = "subject")
    private WebElement incident;

    //付款方式查询按钮
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/div/div/div[2]/div[8]/div/div/span/button")
    private WebElement queryPayType;

    //付款方式查询输入框
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/div[2]/div/div/div/input")
    private WebElement payTypeText;

    //选择付款方式选择框
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/div/div/div[2]/div[8]/div/div/div/div[1]/span")
    private WebElement choosePayType;

    //付款方式选择框第一个方式-银行转账
    @FindBy(xpath = "/html/body/div[4]/ul/li/div[3]/a/div")
    private WebElement firstType;

    //收款人选择框
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/div/div/div[2]/div[9]/div/div/div/div[1]/span")
    private WebElement payee;

    //收款人选择框第二个
    @FindBy(xpath = "/html/body/div[4]/ul/li/div[4]/a/div")
    private WebElement secPayee;

    //添加明细按钮
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/div/div/div[2]/div[14]/div/mp-child-table/div/div[2]/a[1]")
    private WebElement addDetail;

    //预算表选择框
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/mp-form-body/div[1]/div/div/div/div[1]/span")
    private WebElement budgetSheet;

    //预算表选择框第一个
    @FindBy(xpath = "/html/body/div[5]/ul/li/div[3]/a/div")
    private WebElement firstSheet;

    //预算项选择框
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/mp-form-body/div[2]/div/div/div/div[1]/span")
    private WebElement budgetItem;

    //明细选择框下拉第一个选项
    @FindBy(xpath = "/html/body/div[5]/ul/li/div[3]/a/div")
    private WebElement firstChoice;

    //成本中心
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/mp-form-body/div[3]/div/div/div/div[1]/span")
    private WebElement costCenter;

    //发票类型选择框
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/mp-form-body/div[4]/div/select")
    private WebElement invoiceType;

    //发票类型-专票
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/mp-form-body/div[4]/div/select/option[1]")
    private WebElement specialsInvoice;

    //应付金额
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/mp-form-body/div[5]/div/input")
    private WebElement payAmount;

    //税率
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/mp-form-body/div[7]/div/select")
    private WebElement taxRate;

    //税率-无税
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/mp-form-body/div[7]/div/select/option[1]")
    private WebElement noTax;

    //明细-确定
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[3]/div/button[1]")
    private WebElement saveDetailBtn;

    //提交单据
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[2]/button[1]")
    private WebElement submitBtn;

    //确定提交此单据审批
    @FindBy(xpath = "/html/body/div[1]/div/div/div[3]/button[1]")
    private WebElement lastSubBtn;

    public WebElement getLastSubBtn() {
        return lastSubBtn;
    }

    public WebElement getExpenseTitle() {
        return expenseTitle;
    }

    public WebElement getIncident() {
        return incident;
    }

    public WebElement getQueryPayType() {
        return queryPayType;
    }

    public WebElement getPayTypeText() {
        return payTypeText;
    }

    public WebElement getChoosePayType() {
        return choosePayType;
    }

    public WebElement getFirstType() {
        return firstType;
    }

    public WebElement getAddDetail() {
        return addDetail;
    }

    public WebElement getBudgetSheet() {
        return budgetSheet;
    }

    public WebElement getFirstSheet() {
        return firstSheet;
    }

    public WebElement getBudgetItem() {
        return budgetItem;
    }

    public WebElement getFirstChoice() {
        return firstChoice;
    }

    public WebElement getInvoiceType() {
        return invoiceType;
    }

    public WebElement getSpecialsInvoice() {
        return specialsInvoice;
    }

    public WebElement getPayAmount() {
        return payAmount;
    }

    public WebElement getTaxRate() {
        return taxRate;
    }

    public WebElement getSaveDetailBtn() {
        return saveDetailBtn;
    }

    public WebElement getSubmitBtn() {
        return submitBtn;
    }

    public WebElement getCostCenter() {
        return costCenter;
    }

    public WebElement getNoTax() {
        return noTax;
    }

    public WebElement getPayee() {
        return payee;
    }

    public WebElement getSecPayee() {
        return secPayee;
    }
}
