package cn.dxz.business;

import cn.dxz.actions.HomeAction;
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
     * 进入全面预算页（用户）
     */
    public void enterAllBudget() {
        ha.clickAllBudget();
    }

    /**
     * 进入门户管理（后台）
     */
    public void enterBMAdmin() {
        ha.clickBMAdmin();
    }
}
