package cn.dxz.testCase.allBudget;

import cn.dxz.base.CaseBase;
import cn.dxz.base.Constants;
import cn.dxz.business.HomeBusiness;
import cn.dxz.business.LoginBusiness;
import cn.dxz.business.allBudget.BudgetMakingBusiness;
import cn.dxz.business.entities.BudgetMaking;
import cn.dxz.business.tables.TableBusiness;
import cn.dxz.utils.ExcelUtils;
import cn.dxz.utils.ProUtil;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author daixuzhong
 * @title: BudgetMakingTest
 * @description: TODO
 * @date 2019/5/29
 */
public class BudgetMakingTest extends CaseBase {

    private static Logger logger = LoggerFactory.getLogger(BudgetMakingTest.class);



    //选择浏览器
    private WebDriver driver = initDriver("chrome");

    @BeforeTest
    public void login() {
        LoginBusiness lb = new LoginBusiness(driver);
        driver.get("http://47.100.40.166:8020/ZT/Account/Login?ReturnUrl=%2fZT%2f");

        //登录
        ProUtil proUtil = new ProUtil("parameter.properties");
        String userName = proUtil.readFile("admin");
        String password = proUtil.readFile( "password");

        lb.login(userName,password,false);
    }

    @Test
    public void editTable() {
        BudgetMakingBusiness bmb = new BudgetMakingBusiness(driver);
        HomeBusiness hb = new HomeBusiness(driver);
        TableBusiness tb = new TableBusiness(driver);
        BudgetMaking budgetMaking = new BudgetMaking();


        //读取数据（第一条用例）
        List<String> list = ExcelUtils.readExcel(Constants.Numbers.ONE.getCode());
        try {
            //点击全面预算
            hb.enterBudgetBM();

            budgetMaking.setNavi(list.get(Constants.Numbers.ONE.getCode()));
            budgetMaking.setDepartment(list.get(Constants.Numbers.TWO.getCode()));
            budgetMaking.setTableName(list.get(Constants.Numbers.THREE.getCode()));
            bmb.makePropertyFeeTable(budgetMaking);

            //编辑预算表
            budgetMaking.setBudgetItem(list.get(Constants.Numbers.FOUR.getCode()));
            budgetMaking.setRelaTable(list.get(Constants.Numbers.FIVE.getCode()));
            tb.editTable(budgetMaking);
            //
        } catch (InterruptedException e) {
            logger.error("编辑预算表失败~~~~");
            //
            driver.close();
        }






    }



}
