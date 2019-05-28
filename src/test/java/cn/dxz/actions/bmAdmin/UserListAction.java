package cn.dxz.actions.bmAdmin;

import cn.dxz.pages.bmAdmin.UserListPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * @author daixuzhong
 * @date 2019/5/113:56 PM
 */
public class UserListAction {
    private UserListPage ulp;
    private WebDriver driver;

    public UserListAction(WebDriver driver) {
        this.driver = driver;
        ulp = new UserListPage(driver);
    }

    /**
     * 点击新建按钮
     */
    public void clickNewBtn() {
        ulp.click(ulp.getNewUserBtn());
    }

    /**
     * 点击搜索框并输入搜索内容
     */
    public void clickQueryTextAndSendKey(String text) {
        ulp.click(ulp.getQueryText());
        ulp.sendKey(ulp.getQueryText(), text);
        ulp.keyEnter();
    }

    /**
     * 点击列表中第一个编辑按钮
     */
    public void clickFirstEditBtn() {
        ulp.click(ulp.getEditBtn1());
    }

    /**
     * 创建用户断言
     * @param key
     */
    public void assertCreateUser(String key) {
        boolean flag = false;
        clickQueryTextAndSendKey(key);
        List<WebElement> nameInList = ulp.getNameInList();
        for (WebElement element : nameInList) {
            if (StringUtils.equals(element.getText(), key)) {
                flag = true;
            }
        }
        Assert.assertTrue(false, "添加用户失败");
    }
}
