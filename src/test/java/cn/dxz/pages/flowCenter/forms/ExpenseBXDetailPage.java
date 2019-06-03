package cn.dxz.pages.flowCenter.forms;

import cn.dxz.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.XMLFormatter;

/**
 * @author daixuzhong
 * @title: ExpenseBXDetailPage
 * @description: 费用报销单详情页
 * @date 2019/5/21
 */
public class ExpenseBXDetailPage extends BasePage {


    public ExpenseBXDetailPage(WebDriver driver) {
        super(driver);
    }

    /**
     * 右上角按钮组
     */
    //撤回
    @FindBy(xpath = "//span[text()='撤回']")
    private WebElement recall;

    //关闭
    @FindBy(xpath = "//span[text()='关闭']")
    private WebElement close;


    //==================================================================================================================

    //单据编号内容
    @FindBy(xpath = "//div[@field='TicketCode']/div/span")
    private WebElement ticketCode;

    //标题内容
    @FindBy(xpath = "//div[@field='Title']/div/span")
    private WebElement title;

    //事由内容
    @FindBy(xpath = "//div[@field='Subject']/div/span")
    private WebElement incident;

    //付款方式
    @FindBy(xpath = "//div[@field='PayType']/div/span")
    private WebElement payType;

    //收款人
    @FindBy(xpath = "//div[@field='RefItem1']/div/span")
    private WebElement refItem1;

    //金额
    @FindBy(xpath = "/html/body/div[1]/div/div//span[@field-name='amountPayable']")
    private WebElement amount;

    /**
     * 明细table的各项内容（1预算表、2预算项、3成本中心、4发票类型、应付金额、实付金额、7税率、税额、不含税金额）
     * ！！！金额部分不要使用该元素！！！使用下面的detailNumberList
     */
    @FindBy(xpath = "//div[@field='TicketDetails']/descendant::tbody/descendant::td")
    private List<WebElement> detailList;

    //明细detail数字金额的内容（0应付金额、1实付金额、2税额、3不含税金额）
    @FindBy(xpath = "//div[@field='TicketDetails']/descendant::tbody/descendant::td/span")
    private List<WebElement> detailNumberList;

    //弹框-确定
    @FindBy(xpath = "//span[text()='确定']")
    private WebElement confirmBtn;

    //提交或撤回后上方的提示（失败或成功）
    @FindBy(xpath = "//div[@role='alert' and @type='info']/div/span[3]")
    private WebElement hint;

    /**
     * 审批历史
     */
    //第1条审批环节
    @FindBy(xpath = "//div[text()='审批历史']/../descendant::tbody/tr[1]/td[1]")
    private WebElement step1;

    //第1条操作人
    @FindBy(xpath = "//div[text()='审批历史']/../descendant::tbody/tr[1]/td[2]")
    private WebElement operator1;

    //第1条审批状态
    @FindBy(xpath = "//div[text()='审批历史']/../descendant::tbody/tr[1]/td[3]")
    private WebElement status1;

    //第2条审批环节
    @FindBy(xpath = "//div[text()='审批历史']/../descendant::tbody/tr[2]/td[1]")
    private WebElement step2;

    //第2条操作人
    @FindBy(xpath = "//div[text()='审批历史']/../descendant::tbody/tr[2]/td[2]")
    private WebElement operator2;

    //第2条审批状态
    @FindBy(xpath = "//div[text()='审批历史']/../descendant::tbody/tr[2]/td[3]")
    private WebElement status2;

    public WebElement getStep1() {
        return step1;
    }

    public WebElement getOperator1() {
        return operator1;
    }

    public WebElement getStatus1() {
        return status1;
    }

    public WebElement getStep2() {
        return step2;
    }

    public WebElement getOperator2() {
        return operator2;
    }

    public WebElement getStatus2() {
        return status2;
    }

    public WebElement getIncident() {
        return incident;
    }

    public WebElement getPayType() {
        return payType;
    }

    public WebElement getRefItem1() {
        return refItem1;
    }

    public WebElement getAmount() {
        return amount;
    }

       public WebElement getTitle() {
        return title;
    }

    public WebElement getRecall() {
        return recall;
    }

    public WebElement getConfirmBtn() {
        return confirmBtn;
    }

    public WebElement getHint() {
        return hint;
    }

    public WebElement getTicketCode() {
        return ticketCode;
    }

    public List<WebElement> getDetailList() {
        return detailList;
    }

    public List<WebElement> getDetailNumberList() {
        return detailNumberList;
    }

    public WebElement getClose() {
        return close;
    }
}
