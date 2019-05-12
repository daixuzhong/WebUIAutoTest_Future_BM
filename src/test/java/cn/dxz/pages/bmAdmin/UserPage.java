package cn.dxz.pages.bmAdmin;

import cn.dxz.base.BasePage;
import cn.dxz.base.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sun.text.normalizer.NormalizerBase;

import javax.naming.Name;
import java.util.List;
import java.util.logging.XMLFormatter;

/**
 * @author daixuzhong
 * @date 2019/5/114:08 PM
 * @Description 创建用户弹框中的参数
 */
public class UserPage extends BasePage {
    public UserPage(WebDriver driver) {
        super(driver);
    }

    //名称输入框
    @FindBy(name = "name")
    private WebElement name;

    //代码输入框
    @FindBy(name = "code")
    private WebElement code;

    //别名输入框
    @FindBy(name = "name1")
    private WebElement name1;

    //描述输入框
    @FindBy(name = "description")
    private WebElement description;

    //电子信箱输入框
    @FindBy(name = "email")
    private WebElement email;

    //密码输入框
    @FindBy(name = "password")
    private WebElement password;

    //所属部门搜索框
    @FindBy(name = "belongDept")
    private WebElement department;

    //搜索框输入
    @FindBy(xpath = Constants.SEARCHINPUT_PATH)
    private WebElement searchInput;

    //可用部门的那类搜索BOX框
    @FindBy(xpath = "/html/body/div[4]/div[1]/input")
    private WebElement searchInput1;

    //搜索框查询结果第一条
    @FindBy(className = "ui-select-choices-row-inner")
    private WebElement firstRes;

    //*[@id="ui-select-choices-row-1-0"]/a/div/span

    //可用部门
    @FindBy(name = "departmentList")
    private WebElement enableDepartment;

    //所属公司搜索框
    @FindBy(name = "corp")
    private WebElement company;

    //手机号码
    @FindBy(xpath = "mobile")
    private WebElement mobile;

    //直接上级
    @FindBy(name = "directManager")
    private WebElement directManager;

    //所属用户组
    @FindBy(name = "groups")
    private WebElement userGroup;

    //导航栏-使用/li[index]切换，index=1（属性）、2（角色）、3（可用单据）、4（主管部门）、5（查询部门）、6（可用账套）
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/ng-include/div/div/ul")
    private List<WebElement> naviBar;

    //角色列表-使用/label[index]/input来切换想要的角色
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/form/ng-include/div/div/div/div[2]/div/mp-field-control/div/div[2]")
    private List<WebElement> roleList;

    //保存按钮
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div[3]/div/button[1]")
    private WebElement saveBtn;

    public WebElement getSaveBtn() {
        return saveBtn;
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getCode() {
        return code;
    }

    public WebElement getName1() {
        return name1;
    }

    public WebElement getDescription() {
        return description;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getDepartment() {
        return department;
    }

    public WebElement getSearchInput() {
        return searchInput;
    }

    public WebElement getEnableDepartment() {
        return enableDepartment;
    }

    public WebElement getCompany() {
        return company;
    }

    public WebElement getMobile() {
        return mobile;
    }

    public WebElement getDirectManager() {
        return directManager;
    }

    public WebElement getUserGroup() {
        return userGroup;
    }

    public List<WebElement> getNaviBar() {
        return naviBar;
    }

    public List<WebElement> getRoleList() {
        return roleList;
    }

    public WebElement getFirstRes() {
        return firstRes;
    }

    public WebElement getSearchInput1() {
        return searchInput1;
    }
}
