package cn.dxz.pages.flowCenter.forms;

import cn.dxz.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author daixuzhong
 * @title: ExpenseBX
 * @description: 费用报销单填报页面元素
 * @date 2019/5/10
 */
public class ExpenseBXPage extends BasePage {

    private static Logger logger = LoggerFactory.getLogger(ExpenseBXPage.class);

    public ExpenseBXPage(WebDriver driver) {
        super(driver);
    }

    //费用报销单-标题
    @FindBy(name = "title")
    private WebElement expenseTitle;

    //费用报销单-事由
    @FindBy(name = "subject")
    private WebElement incident;

    //付款方式查询搜索框
    @FindBy(name = "payType")
    private WebElement queryPayType;

    //付款方式查询输入框
    @FindBy(xpath = "//*[@name=\"payType\"]/descendant::input[1]")
    private WebElement queryPayTypeText;

    //付款方式名称搜索结果
    @FindBy(xpath = "//*[@name=\"payType\"]/ul/li/div[3]/a[1]")
    private WebElement payTypeRes;

    //收款人查询搜索框
    @FindBy(name = "refItem1")
    private WebElement queryPayee;

    //收款人查询输入框
    @FindBy(xpath = "//*[@name=\"refItem1\"]/descendant::input[1]")
    private WebElement queryPayeeText;

    //收款人名称搜索结果
    @FindBy(xpath = "//*[@name=\"refItem1\"]/ul/li/div[3]/a[1]")
    private WebElement payeeRes;

    //付款明细按钮组-（1添加，2删除，3取消删除）
    @FindBy(xpath = "//div[@class=\"view-child-toolbar\"]/a")
    private List<WebElement> payDetailBtn;

    //明细-预算表搜索框
    @FindBy(name = "budgetTable")
    private WebElement queryBudgetSheet;

    //明细-预算表搜索输入框
    @FindBy(xpath = "//*[@name=\"budgetTable\"]/descendant::input[1]")
    private WebElement queryBudgetSheetText;

    //明细-预算表名称搜索结果
    @FindBy(xpath = "//*[@name=\"budgetTable\"]/ul/li/div[3]/a[1]")
    private WebElement budgetSheetRes;


    //明细-预算项搜索框
    @FindBy(name = "budgetItem")
    private WebElement queryBudgetItem;

    //明细-预算项搜索输入框
    @FindBy(xpath = "//*[@name=\"budgetItem\"]/descendant::input[1]")
    private WebElement queryBudgetItemText;

    //明细-预算项搜索结果
    @FindBy(xpath = "//*[@name=\"budgetItem\"]/ul/li/div[3]/a[1]")
    private WebElement budgetItemRes;

    //明细-成本中心搜索框
    @FindBy(name = "executeDepartment")
    private WebElement queryCostCenter;

    //明细-成本中心搜索输入框
    @FindBy(xpath = "//*[@name=\"executeDepartment\"]/descendant::input[1]")
    private WebElement queryCostCenterText;

    //明细-成本中心名称搜索结果
    @FindBy(xpath = "//*[@name=\"executeDepartment\"]/ul/li/div[3]/a[1]")
    private WebElement costCenterRes;

    //发票类型
    @FindBy(xpath = "//*[@name=\"invoiceType\"]")
    private WebElement invoiceType;

    //应付金额
    @FindBy(name = "amountPayable")
    private WebElement payAmount;

    //税率
    @FindBy(xpath = "//*[@name=\"value03\"]")
    private WebElement taxRate;

    //明细-确定
    @FindBy(xpath = "//button[@class=\"btn btn-primary\" and @type=\"button\"]")
    private WebElement saveDetailBtn;

    //费用报销单据的按钮组（1提交、2保存、3流程图、4关闭）
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[3]/button")
    private List<WebElement> btnList;


    //确定提交此单据审批
    @FindBy(xpath = "/html/body/div[1]/div/div/div[3]/button[1]")
    private WebElement confirmSubmit;

    //提交成功弹框提示
    @FindBy(partialLinkText = "更新成功")
    private WebElement successFlag;

    public WebElement getSuccessFlag() {
        return successFlag;
    }

    public WebElement getConfirmSubmit() {
        return confirmSubmit;
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

    public WebElement getQueryPayTypeText() {
        return queryPayTypeText;
    }



    public List<WebElement> getPayDetailBtn() {
        return payDetailBtn;
    }

    public WebElement getInvoiceType() {
        return invoiceType;
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


    public WebElement getQueryPayee() {
        return queryPayee;
    }

     public List<WebElement> getBtnList() {
        return btnList;
    }

    public WebElement getQueryBudgetSheet() {
        return queryBudgetSheet;
    }

    public WebElement getQueryBudgetItem() {
        return queryBudgetItem;
    }

    public WebElement getQueryCostCenter() {
        return queryCostCenter;
    }

    public WebElement getPayTypeRes() {
        return payTypeRes;
    }

    public WebElement getQueryPayeeText() {
        return queryPayeeText;
    }

    public WebElement getPayeeRes() {
        return payeeRes;
    }

    public WebElement getQueryBudgetSheetText() {
        return queryBudgetSheetText;
    }

    public WebElement getBudgetSheetRes() {
        return budgetSheetRes;
    }

    public WebElement getQueryBudgetItemText() {
        return queryBudgetItemText;
    }

    public WebElement getBudgetItemRes() {
        return budgetItemRes;
    }

    public WebElement getQueryCostCenterText() {
        return queryCostCenterText;
    }

    public WebElement getCostCenterRes() {
        return costCenterRes;
    }
}
