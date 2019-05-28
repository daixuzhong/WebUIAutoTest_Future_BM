package cn.dxz.testCase.allBudget.expenseBXFlow;

import cn.dxz.base.CaseBase;
import cn.dxz.business.allBudget.AllBudgetBusiness;
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
 * @description: 测试费用报销单据：创建、撤回、编辑后再次提交（总部人力资源部的用户）
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

    @Test(dependsOnMethods = {"newExpenseBX"},description = "填写费用报销数据")
    public void writeExpenseBX() {
        //点击预算执行-新建流程
        AllBudgetBusiness abb = new AllBudgetBusiness(driver);
        try {
            ExpenseBX param = getExpenseBX();

            abb.newExpenseBX(param);

            Thread.sleep(5000);
        } catch (Exception e) {
            logger.error("提交费用报销失败" + e);
            e.printStackTrace();
        }


    }

    /**
     * 报销单参数封装
     * @return
     */
    private ExpenseBX getExpenseBX() {
        //填写费用报销单
        ExpenseBX param = new ExpenseBX();
        ProUtil proUtil = new ProUtil("allBudget/expenseBX.properties");

        param.setTitle(proUtil.readFile("title"));
        param.setIncident(proUtil.readFile( "incident"));
        param.setAmount(proUtil.readFile("amount"));
        param.setPayType(proUtil.readFile( "payType"));
        param.setPayee(proUtil.readFile( "payee"));
        param.setBudgetSheet(proUtil.readFile("budgetSheet"));
        param.setBudgetItem(proUtil.readFile("budgetItem"));
        param.setCostCenter(proUtil.readFile("costCenter"));
        param.setTaxRate(proUtil.readFile("taxRate"));
        return param;
    }

    @Test(dependsOnMethods = "writeExpenseBX", description = "检查费用报销单是否填写正确")
//    @Test
    public void checkBX() {
        //点击查询统计
        HomeBusiness hb = new HomeBusiness(driver);
        AllBudgetBusiness abb = new AllBudgetBusiness(driver);
        try {
            hb.enterAllBudget();
            Thread.sleep(2000);
            abb.checkExpenseBX(getExpenseBX());
        } catch (InterruptedException e) {
            logger.error("~~~~~~checkBX error~~~~~");
            e.printStackTrace();
        }

    }

    @Test(dependsOnMethods = "checkBX", description = "撤回费用报销单")
    public void recall() {
        AllBudgetBusiness abb = new AllBudgetBusiness(driver);
        try {
            abb.recall();
        } catch (InterruptedException e) {
            logger.error("~~~~~~recall error~~~~~~");
            e.printStackTrace();
        }
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }



}
