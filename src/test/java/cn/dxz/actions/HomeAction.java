package cn.dxz.actions;

import cn.dxz.pages.HomePage;
import org.openqa.selenium.WebDriver;

/**
 * @author daixuzhong
 * @title: HomeAction
 * @description: TODO
 * @date 2019/5/10
 */
public class HomeAction {
    public WebDriver driver;
    HomePage hp;

    public HomeAction(WebDriver driver) {
        this.driver = driver;
        hp = new HomePage(driver);
    }
    /**
     * 点击全面预算
     */
    public void clickAllBudget() {
        hp.click(hp.getAllBudget_User());
    }

    /**
     * 注销按钮是否存在
     */
    public boolean isLogOffExist() {
        return hp.assertElementExist(hp.getLogOff());
    }

    //点击系统管理


}
