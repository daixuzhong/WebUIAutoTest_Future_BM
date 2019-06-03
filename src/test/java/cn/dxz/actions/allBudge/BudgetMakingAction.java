package cn.dxz.actions.allBudge;

import cn.dxz.pages.allBudget.BudgetMakingPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.List;

/**
 * @author daixuzhong
 * @title: BudgetMakingAction
 * @description: TODO
 * @date 2019/5/29
 */
public class BudgetMakingAction {

    private static Logger logger = LoggerFactory.getLogger(BudgetMakingAction.class);

    private BudgetMakingPage bmp;

    public BudgetMakingAction(WebDriver driver) {
        bmp = new BudgetMakingPage(driver);
    }

    /**
     * 点击预算编制
     */
    public void clickBudgetMaking() {
        bmp.click(bmp.getBudgetMaking());
    }

    /**
     * 点击预算编制下的指定菜单
     * @param text
     */
    public void clickBudgetMakingList(String text) {
        List<WebElement> budgetMakingList = bmp.getBudgetMakingList();
        for (WebElement webElement : budgetMakingList) {
            if (StringUtils.equals(webElement.getText(), text)) {
                bmp.click(webElement);
                return;
            }
        }
        Assert.fail("预算编制下没有该菜单~~~~~~~");
    }

    /**
     * 选择需要预算编制的组织机构
     * @param department
     */
    public void chooseDepartment(String department) {
        List<WebElement> departmentList = bmp.getDepartmentList();
        for (WebElement webElement : departmentList) {
            if (StringUtils.equals(webElement.getText(), department)) {
                bmp.click(webElement);
                return;
            }
        }
        Assert.fail("没有找到该组织机构~~~~~");
    }

    /**
     * 选择预算表并点击进入编制状态
     * @param tableName
     */
    public void chooseBudgetTable(String tableName) {
        List<WebElement> tableNameList = bmp.getTableNameList();
        for (WebElement e : tableNameList) {
            if (StringUtils.equals(e.getText().trim(), tableName)) {
                bmp.click(bmp.getOpenTableBtn(e));
            }
        }
    }
}
