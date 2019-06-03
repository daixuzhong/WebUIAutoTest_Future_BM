package cn.dxz.actions.flowCenter;

import cn.dxz.base.Constants;
import cn.dxz.pages.flowCenter.BudgetExecutionPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * @author daixuzhong
 * @title: AllBudgetAction
 * @description: TODO
 * @date 2019/5/10
 */
public class BudgetExecutionAction {

    BudgetExecutionPage bep;

    public BudgetExecutionAction(WebDriver driver) {
        bep = new BudgetExecutionPage(driver);
    }

    /**
     * 点击预算执行
     */
    public void clickBudgetExecute() {
        bep.click(bep.getBudgetExecute());
    }

    /**
     * 点击新建流程
     */
    public void clickNewProcess() {
        bep.click(bep.getNewProcess());
    }

    /**
     * 点击费用报销
     */
    public void clickExpenseBX() {
        bep.click(bep.getExpenseBX());
    }

    /**
     * 点击查询统计
     */
    public void clickQueryStatistics() {
        bep.click(bep.getQueryStatistics());
    }

    /**
     * 点击查询统计的下拉菜单（我填报的单据、我审核的单据、所有单据、预算变更查询）
     */
    public void clickQueryStatisticsList(String name) {
        List<WebElement> queryStatisticsList = bep.getQueryStatisticsList();
        for (WebElement e : queryStatisticsList) {
            if (StringUtils.equals(e.getText(), name)) {
                bep.click(e);
            }
        }
    }

    /**
     * 点击搜索条件选择按钮，再点击下拉框中的单据状态（已提交，未提交，已完成）
     */
    public void chooseBillStatus(String status) throws InterruptedException {
        bep.click(bep.getQueryCondition());
        Thread.sleep(1000);
        if (StringUtils.equals(Constants.Status.SUBMITTED.getText(), status)) {
            //已提交
            bep.click(bep.getCommitted());
        } else if (StringUtils.equals(Constants.Status.UN_SUBMITTED.getText(), status)) {
            //未提交
            bep.click(bep.getUncommitted());
        } else if (StringUtils.equals(Constants.Status.FINISHED.getText(), status)) {
            //已完成
        }
    }

    /**
     * 搜索框输入值
     * @param key
     */
    public void sendKeyQueryBillInput(String key) throws InterruptedException {
        bep.sendKey(bep.getQueryBillInput(), key);
        Thread.sleep(1000);
        bep.keyEnter();
    }



    /**
     * 点击我提交的单据列表中第一条的编辑按钮
     */
    public void clickEditBtn1() {
        bep.click(bep.getEditBtn1());
    }


}
