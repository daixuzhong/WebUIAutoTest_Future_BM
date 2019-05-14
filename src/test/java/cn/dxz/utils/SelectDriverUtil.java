package cn.dxz.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


/**
 * @author daixuzhong
 * @title: SelectDriver
 * @description: TODO
 * @date 2019/5/10
 */
public class SelectDriverUtil {

    public static WebDriver driverName(String browserName) {
        switch (browserName) {
            case "ie":
                return ie();
            case "chrome":
                return chrome();
            case "firefox":
                return fireFox();
        }
        return null;
    }


    /**
     * 启动ie浏览器
     *
     */
    private static WebDriver ie() {
        System.setProperty("webdriver.ie.driver", "D:\\BMAutoTest\\drivers\\iedriver.exe");
//        // 关闭IE保护模式
//        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
//        ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        WebDriver driver = new InternetExplorerDriver();
        driver.manage().window().maximize();
        return driver;
    }

    /**
     * 启动chrome浏览器
     *
     */
    private static WebDriver chrome() {
        System.setProperty("webdriver.chrome.driver", "D:\\BMAutoTest\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    /**
     * 启动fireFox浏览器
     *
     */
    private static WebDriver fireFox() {
        System.setProperty("webdriver.firefox.bin", "");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
