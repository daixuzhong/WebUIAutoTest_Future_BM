package cn.dxz.actions;

import cn.dxz.pages.FirstLoginPage;
import org.openqa.selenium.WebDriver;

/**
 * @author daixuzhong
 * @title: FirstLoginAction
 * @description: TODO
 * @date 2019/5/10
 */
public class FirstLoginAction {

    public WebDriver driver;
    FirstLoginPage flp;

    public FirstLoginAction(WebDriver driver) {
        this.driver = driver;
        flp = new FirstLoginPage(driver);
    }

    //获取名称的文本
    public String getNameText() {
        return flp.getText(flp.getName());
    }

    //获取代码的文本
    public String getCodeText() {
        return flp.getText(flp.getCode());
    }

    //获取电子信箱的文本
    public String getEmailText() {
        return flp.getText(flp.getEmail());
    }

    //获取部门的文本
    public String getDepartText() {
        return flp.getText(flp.getDepartmen());
    }

    //点击“确认”按钮
    public void clickConfirmBtn() {
        flp.click(flp.getConfirmBtn());
    }

}
