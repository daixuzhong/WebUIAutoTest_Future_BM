package cn.dxz.pages.flowCenter;

import cn.dxz.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * @author daixuzhong
 * @title: WorkflowTask
 * @description: 我的任务页面
 * @date 2019/6/3
 */
public class WorkflowTaskPage extends BasePage {

    public WorkflowTaskPage(WebDriver driver) {
        super(driver);
    }

    //我的任务-查询搜索框
    @FindBy(xpath = "//input[@placeholder=\"查询\"]")
    private WebElement queryTaskInput;

    //查看任务按钮(有几条数据就有几个)
    @FindBy(xpath = "//a[@title=\"查看\"]")
    private List<WebElement> checkBtn;

    //右上角按钮组(审批，打印，委托，征询，抄送，退回，流程图，关闭)，根据text区分
    @FindBy(xpath = "//*[contains(@class,\"btn-group-sm\")]/button/span")
    private List<WebElement> btnGroup;

    //审批意见输入框
    @FindBy(xpath = "//textarea[@name=\"comment\"]")
    private WebElement approveCommentInput;

    //常用意见按钮
    @FindBy(xpath = "//a[@popover-title=\"常用意见\"]")
    private WebElement commonComment;

    //保存为常用意见
    @FindBy(xpath = "//a[@title=\"保存为常用意见\"]")
    private WebElement saveComment;

    //批准按钮
    @FindBy(xpath = "//button[contains(text(), \"批准\")]")
    private WebElement approveBtn;

    //弹框-按钮（确认、取消、×）
    @FindBy(xpath = "//div[@class=\"modal-dialog modal-sm\"]/descendant::button/span")
    private List<WebElement> popBtnGroup;

    public WebElement getApproveBtn() {
        return approveBtn;
    }

    public WebElement getQueryTaskInput() {
        return queryTaskInput;
    }

    public List<WebElement> getCheckBtn() {
        return checkBtn;
    }

    public WebElement getApproveCommentInput() {
        return approveCommentInput;
    }

    public WebElement getCommonComment() {
        return commonComment;
    }

    public WebElement getSaveComment() {
        return saveComment;
    }

    public List<WebElement> getBtnGroup() {
        return btnGroup;
    }

    public List<WebElement> getPopBtnGroup() {
        return popBtnGroup;
    }
}
