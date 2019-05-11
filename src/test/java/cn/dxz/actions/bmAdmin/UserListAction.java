package cn.dxz.actions.bmAdmin;

import cn.dxz.pages.bmAdmin.UserListPage;
import org.openqa.selenium.WebDriver;

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
    }

    /**
     * 点击列表中第一个编辑按钮
     */
    public void clickFirstEditBtn() {
        ulp.click(ulp.getEditBtn1());
    }
}
