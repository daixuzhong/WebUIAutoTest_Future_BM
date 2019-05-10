package cn.dxz.business;

import cn.dxz.actions.FirstLoginAction;
import org.openqa.selenium.WebDriver;

/**
 * @author daixuzhong
 * @title: FirstLoginBusiness
 * @description: 首次登录业务逻辑
 * @date 2019/5/10
 */
public class FirstLoginBusiness {
    FirstLoginAction fla;

    public FirstLoginBusiness(WebDriver driver) {
        fla = new FirstLoginAction(driver);
    }

    public void confirmMes() {

    }


}
