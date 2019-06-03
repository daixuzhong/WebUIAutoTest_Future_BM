package cn.dxz.testCase.flowCenter;

import cn.dxz.base.CaseBase;
import cn.dxz.business.flowCenter.BudgetExecutionBusiness;
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

import java.util.Date;

/**
 * @author daixuzhong
 * @title: newExpenseBX
 * @description: 测试费用报销单据：创建、撤回、编辑后再次提交（总部人力资源部的用户）
 * @date 2019/5/10
 */
public class NewExpenseBXTest extends CaseBase {

    private static Logger logger = LoggerFactory.getLogger(NewExpenseBXTest.class);
    //选择浏览器
    public static WebDriver driver = initDriver("chrome");
    //流程参数
    public static ExpenseBX param;

    @BeforeTest
    public void login() {
        LoginBusiness lb = new LoginBusiness(driver);
        driver.get("http://47.100.40.166:8020/ZT/Account/Login?ReturnUrl=%2fZT%2f");

        //登录
        ProUtil proUtil = new ProUtil("flowCenter/flowInfo.properties");
        String[] userInfo = proUtil.formatUserInfo(proUtil.readFile("FYBX_Step1"));

        lb.login(userInfo[0],userInfo[1],false);
    }

    @Test
    public void A_newExpenseBX() throws Exception {
        HomeBusiness hb = new HomeBusiness(driver);
        Thread.sleep(3000);
        if (!hb.isLogin()) {
            logger.error("登陆失败！");
            throw new Exception();
        }
        hb.enterBudgetBM();
    }

    @Test(description = "填写费用报销数据")
    public void B_writeExpenseBX() {
        BudgetExecutionBusiness beb = new BudgetExecutionBusiness(driver);
        HomeBusiness hb = new HomeBusiness(driver);
        try {
            //新建一个费用报销流程：预算执行-新建流程-费用报销-填写数据-提交
            beb.newExpenseBX(param);
            beb.assertNewExpenseBX();

            /**
             * 开始校验填报单据的数据正确性
             */
            //点击全面预算
            hb.enterBudgetBM();
            //检查填写数据的正确性
            beb.checkExpenseBX(param);
            Thread.sleep(2000);
        } catch (Exception e) {
            logger.error("提交费用报销失败" );
            logger.error("******message error:",e);
            driver.quit();
        }


    }

    /**
     * 报销单参数封装
     */
    static {
        logger.info("----------开始封装expenseBX参数----------" + new Date().getTime());
        param = new ExpenseBX();
        //填写费用报销单
        ProUtil proUtil = new ProUtil("flowCenter/expenseBX.properties");
        String title = proUtil.readFile("title") + new Date().getTime();
        param.setTitle(title);
        param.setIncident(proUtil.readFile( "incident"));
        param.setAmount(proUtil.readFile("amount"));
        param.setPayType(proUtil.readFile( "payType"));
        param.setPayee(proUtil.readFile( "payee"));
        param.setBudgetSheet(proUtil.readFile("budgetSheet"));
        param.setBudgetItem(proUtil.readFile("budgetItem"));
        param.setCostCenter(proUtil.readFile("costCenter"));
        param.setInvoiceType(proUtil.readFile("invoiceType"));
        param.setTaxRate(proUtil.readFile("taxRate"));
    }



    @AfterTest
    public void afterTest() {
        driver.quit();
    }



}
