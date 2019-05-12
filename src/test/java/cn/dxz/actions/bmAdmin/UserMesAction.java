package cn.dxz.actions.bmAdmin;

import cn.dxz.pages.bmAdmin.UserPage;
import org.openqa.selenium.WebDriver;

/**
 * @author daixuzhong
 * @date 2019/5/1212:35 PM
 */
public class UserMesAction {
    public WebDriver driver;
    private UserPage up;

    public UserMesAction(WebDriver driver) {
        this.driver = driver;
        up = new UserPage(driver);
    }


    public void sendKeyName(String name) {
        up.sendKey(up.getName(), name);
    }

    public void sendKeyCode(String code) {
        up.sendKey(up.getCode(), code);
    }

    public void sendKeyEmail(String email) {
        up.sendKey(up.getEmail(), email);
    }

    public void sendKeyPassword(String password) {
        up.sendKey(up.getPassword(), password);
    }

    public void sendDepartment(String department) {
        up.click(up.getDepartment());
        up.sendKey(up.getSearchInput(),department);
        up.click(up.getFirstRes());
    }

    public void sendEnableDepartment(String enableDepartment) {
        up.click(up.getEnableDepartment());
        up.sendKey(up.getSearchInput1(),enableDepartment);
        up.click(up.getFirstRes());
    }

    public void sendCompany(String company) {
        up.click(up.getCompany());
        up.sendKey(up.getSearchInput(),company);
        up.click(up.getFirstRes());
    }

    public void sendKeyMobile(String mobile) {
        up.sendKey(up.getMobile(),mobile);
    }

    public void sendDirectManager(String directManager) {
        up.click(up.getDirectManager());
        up.sendKey(up.getSearchInput(),directManager);
        up.click(up.getFirstRes());
    }

    public void sendUserGroup(String userGroup) {
        up.click(up.getUserGroup());
        up.sendKey(up.getSearchInput(), userGroup);
        up.click(up.getFirstRes());
    }

    public void clickSaveBtn() {
        up.click(up.getSaveBtn());
    }

}
