package cn.dxz.pages.tables;

import cn.dxz.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.XMLFormatter;

/**
 * @author daixuzhong
 * @title: TablePage
 * @description: TODO
 * @date 2019/5/29
 */
public class TablePage extends BasePage {

    public TablePage(WebDriver driver) {
        super(driver);
    }

    //表格-所有预算项名称(第1列数据)
    @FindBy(xpath = "//*[@class=\"ht_master handsontable\"]/descendant::tbody/tr/td[1]")
    private List<WebElement> rowNameList;

    //表格-所有行
    @FindBy(xpath = "//*[@class=\"ht_master handsontable\"]/descendant::tbody/tr")
    private List<WebElement> allRowList;

    public List<WebElement> getAllRowList() {
        return allRowList;
    }

    /**
     * 预算项-关系表按钮
     * @param element
     * @return
     */
    public WebElement getRelaBtn(WebElement element) {
        return nodeElement(element, By.xpath("../descendant::a[3]"));
    }

    //所有的关系预算表-表名称
    @FindBy(xpath = "//*[@class=\"table table-bordered\"]/tbody/tr/td[1]")
    private List<WebElement> relaTableNameList;

    //按钮组名称（编辑，提交，计算，导出，导入，引入，附件，快照，设计）
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[1]/div[2]/button/span")
    private List<WebElement> btnGroup;



    public List<WebElement> getBtnGroup() {
        return btnGroup;
    }

    public List<WebElement> getRelaTableNameList() {
        return relaTableNameList;
    }

    public List<WebElement> getRowNameList() {
        return rowNameList;
    }
}
