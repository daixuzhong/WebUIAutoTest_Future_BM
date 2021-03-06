package cn.dxz.cases.allBudget;

import cn.dxz.base.CaseBase;
import cn.dxz.business.AllBudgetBusiness;
import cn.dxz.business.HomeBusiness;
import cn.dxz.business.LoginBusiness;
import cn.dxz.business.entities.ExpenseBX;
import cn.dxz.utils.ProUtil;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author daixuzhong
 * @title: newExpenseBX
 * @description: TODO
 * @date 2019/5/10
 */
public class newExpenseBXTest extends CaseBase {

    private static Logger logger = LoggerFactory.getLogger(newExpenseBXTest.class);
    //选择浏览器
    private WebDriver driver = initDriver("chrome");

    @BeforeTest
    public void login() {
        LoginBusiness lb = new LoginBusiness(driver);
        driver.get("http://47.100.40.166:8020/ZT/Account/Login?ReturnUrl=%2fZT%2f");

        //登录
        ProUtil proUtil = new ProUtil("parameter.properties");
        String userName = proUtil.readFile("ceshi123456");
        String password = proUtil.readFile( "password");

        lb.login(userName,password,false);
    }

    @Test
    public void newExpenseBX() throws Exception {
        HomeBusiness hb = new HomeBusiness(driver);
        Thread.sleep(3000);
        if (!hb.isLogin()) {
            logger.error("登陆失败！");
            throw new Exception();
        }
        hb.enterAllBudget();
    }

    @Test(dependsOnMethods = {"newExpenseBX"})
    public void writeExpenseBX() {
        //点击预算执行-新建流程
        AllBudgetBusiness abb = new AllBudgetBusiness(driver);
        try {
            //填写费用报销单
            ExpenseBX param = new ExpenseBX();
            ProUtil proUtil = new ProUtil("allBudget/expenseBX.properties");
            String title = proUtil.readFile("title");
            String incident = proUtil.readFile( "incident");
            String amount = proUtil.readFile("amount");
            String payType = proUtil.readFile( "payType");
            String payee = proUtil.readFile( "payee");
            String budgetSheet = proUtil.readFile("budgetSheet");
            String budgetItem = proUtil.readFile("budgetItem");
            String costCenter = proUtil.readFile("costCenter");

            param.setTitle(title);
            param.setIncident(incident);
            param.setAmount(amount);
            param.setPayType(payType);
            param.setPayee(payee);
            param.setBudgetSheet(budgetSheet);
            param.setBudgetItem(budgetItem);
            param.setCostCenter(costCenter);

            abb.newExpenseBX(param);

            Thread.sleep(5000);
        } catch (InterruptedException e) {
            logger.error("");
            e.printStackTrace();
        }


    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }



}
