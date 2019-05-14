package cn.dxz.base;

import cn.dxz.utils.SelectDriverUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

/**
 * @author daixuzhong
 * @title: BasePage
 * @description:  所有页面公共类
 * @date 2019/5/9
 */
public class BasePage {
    private WebDriver driver;
    //最大超时时间，单位：秒
    private final int timeOut = 5;

    public BasePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeOut) , this);
    }

    BasePage(WebDriver driver, final String title) {
        this.driver = driver;

        //如果不进行判断，
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try{
            boolean flag = wait.until(new ExpectedCondition<Boolean>(){
                @Override
                public Boolean apply(WebDriver arg0) {
                    String acttitle = arg0.getTitle();
                    return acttitle.equals(title);
                }});
        }catch(TimeoutException te) {
            throw new IllegalStateException("当前不是预期页面，当前页面title是：" + driver.getTitle());
        }

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeOut) , this);

    }

    /**
     * 点击方法
     * @param element
     */
    public void click(WebElement element) {
        // 显式等待
        new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    /**
     * 输入
     * @param element
     * @param s
     */
    public void sendKey(WebElement element, String s) {
        new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOf(element));
        element.clear();// 先清空输入框
        element.sendKeys(s);// 输入数据
    }

    /**
     * 获取文本
     * @param element
     * @return
     */
    public String getText(WebElement element) {
        new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }


    /**
     * 判断元素是否存在
     * @param element
     * @return
     */
    public boolean assertElementExist(WebElement element) {
        boolean flag = false;
        if (element != null) {
            flag = true;
        }
        return flag;
    }

    /**
     * 切换窗口
     * @param title
     */
    public void switchWindow(String title) {
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (handle.equals(driver.getWindowHandle())) {
                continue;
            } else {
                driver.switchTo().window(handle);
                if (title.contains(driver.getTitle())) {
                    break;
                } else {
                    continue;
                }
            }
        }
    }

    /**
     * 模拟键盘-回车
     */
    public void keyEnter() {
        Actions action = new Actions(driver);
        action .sendKeys(Keys.ENTER).perform();
    }

    /**
     * 模拟键盘-F5刷新
     */
    public void keyF5Refresh() {
        Actions action = new Actions(driver);
        action .sendKeys(Keys.F5).perform();
    }

}
