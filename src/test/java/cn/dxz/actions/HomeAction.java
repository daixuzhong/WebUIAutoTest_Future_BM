package cn.dxz.actions;

import cn.dxz.pages.HomePage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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
     * 点击上方导航栏按钮（全面预算、系统管理、门户管理）
     */
    public void clickTopbar(String barName) {
        List<WebElement> topbar = hp.getTopbar();
        for (WebElement e : topbar) {
            if (StringUtils.equals(e.getText(), barName)) {
                hp.click(e);
                break;
            }
        }
    }

    /**
     * 注销按钮是否存在
     */
    public boolean isLogOffExist() {
        return hp.assertElementExist(hp.getLogOff());
    }

    /**
     * 点击注销按钮
     */
    public void clickLogOff() {
        hp.click(hp.getLogOff());
    }

    /**
     * 点击我的任务
     */
    public void clickMyTask() {
        hp.click(hp.getMyTask());
    }

    /**
     * 查看更多任务
     */
    public void clickSeeMoreTask() {
        hp.click(hp.getSeeMoreTask());
    }

}
