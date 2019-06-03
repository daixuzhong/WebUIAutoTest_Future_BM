package cn.dxz.business;

import cn.dxz.actions.HomeAction;
import cn.dxz.base.Constants;
import org.openqa.selenium.WebDriver;

/**
 * @author daixuzhong
 * @title: HomeBusiness
 * @description: TODO
 * @date 2019/5/10
 */
public class HomeBusiness {
    HomeAction ha;

    public HomeBusiness(WebDriver driver) {
        ha = new HomeAction(driver);
    }

    /**
     * 判断是否登陆成功
     */
    public boolean isLogin() {
        return ha.isLogOffExist();
    }

    /**
     * 进入全面预算页
     */
    public void enterBudgetBM() throws InterruptedException {
        ha.clickTopbar(Constants.BUDGET_BM);
        Thread.sleep(2000);
    }

    /**
     * 进入门户管理
     */
    public void enterBMAdmin() {
        ha.clickTopbar(Constants.BM_ADMIN);
    }

    /**
     * 进入我的任务管理
     */
    public void enterMyTask() throws InterruptedException {
        ha.clickMyTask();
        Thread.sleep(1000);
        ha.clickSeeMoreTask();
        Thread.sleep(1000);
    }

    /**
     * 注销
     */
    public void logOff() {
        ha.clickLogOff();
    }
}
