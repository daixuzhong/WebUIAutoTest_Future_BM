package cn.dxz.actions.tables;

import cn.dxz.pages.tables.TablePage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * @author daixuzhong
 * @title: TableAction
 * @description: 表格操作
 * @date 2019/5/29
 */
public class TableAction {

    private TablePage tp;

    public TableAction(WebDriver driver) {
        tp = new TablePage(driver);
    }


    /**
     * 点击某一行预算项的关系表按钮
     *
     * @param budgetItem
     */
    public void clickRowRelaBtn(String budgetItem) {
        List<WebElement> rowNameList = tp.getRowNameList();
        for (WebElement e : rowNameList) {
            if (StringUtils.contains(e.getText(), budgetItem)) {
                //点击关系表按钮
                tp.click(tp.getRelaBtn(e));
            }
        }

    }

    /**
     * 进入相应的关系预算表
     *
     * @param relaTable
     */
    public void openRelaTable(String relaTable) {
        List<WebElement> relaTableNameList = tp.getRelaTableNameList();
        for (WebElement e : relaTableNameList) {
            if (StringUtils.contains(e.getText(), relaTable)) {
                tp.click(e);
            }
        }
    }

    /**
     * 点击按钮（编辑，提交，计算，导出，导入，引入，附件，快照，设计）
     *
     * @param button
     */
    public void clickBtn(String button) throws InterruptedException {
        List<WebElement> btnGroup = tp.getBtnGroup();
        for (WebElement e : btnGroup) {
            if (StringUtils.equals(e.getText(), button)) {
                tp.click(e);
            }
        }
    }

    /**
     * 输入表格数据
     */
    public void a(String budgetItem, String value) {
        List<WebElement> rowNameList = tp.getRowNameList();
        for (WebElement e : rowNameList) {
            if (StringUtils.equals(e.getText(), "")) {

            }
        }
    }


}
