package cn.dxz.actions.flowCenter;

import cn.dxz.base.Constants;
import cn.dxz.pages.flowCenter.WorkflowTaskPage;
import cn.dxz.utils.ScrollBarUtil;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * @author daixuzhong
 * @title: WorkflowTaskAction
 * @description: TODO
 * @date 2019/6/3
 */
public class WorkflowTaskAction {

    private WorkflowTaskPage wft;

    public WorkflowTaskAction(WebDriver driver) {
        wft = new WorkflowTaskPage(driver);
    }

    /**
     * 搜索并回车
     * @param key
     */
    public void sendKeyQueryTask(String key) throws InterruptedException {
        wft.sendKey(wft.getQueryTaskInput(), key);
        Thread.sleep(1000);
        wft.keyEnter();
    }

    /**
     * 点击第一条的查看按钮
     */
    public void clickCheckBtn() {
        wft.click(wft.getCheckBtn().get(Constants.Numbers.ZERO.getCode()));
    }

    /**
     * 点击按钮(审批，打印，委托，征询，抄送，退回，流程图，关闭)
     */
    public void clickBtn(String buttonName) throws InterruptedException {
        List<WebElement> btnGroup = wft.getBtnGroup();
        for (WebElement e : btnGroup) {
            if (StringUtils.equals(e.getText(), buttonName)) {
                wft.click(e);
            }
        }
        Thread.sleep(500);
    }

    /**
     * 输入审批意见
     * @param text
     */
    public void sendKeyApproveComment(String text) {
        wft.sendKey(wft.getApproveCommentInput(), text);
    }

    /**
     * 点击批准按钮
     */
    public void clickApproveBtn() {
        wft.click(wft.getApproveBtn());
    }

    /**
     * 浏览器滚动条托到底部
     */
    public void scrolltoBottom() {
        wft.scrolltoBottom();
    }

    /**
     * 点击弹框按钮（批准，取消，×）
     * @param buttonName
     */
    public void clickPopBtn(String buttonName) {
        List<WebElement> btnGroup = wft.getPopBtnGroup();
        for (WebElement e : btnGroup) {
            if (StringUtils.equals(e.getText(), buttonName)) {
                wft.click(e);
            }
        }

    }



}
