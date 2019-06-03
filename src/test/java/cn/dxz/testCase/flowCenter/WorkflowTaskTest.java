package cn.dxz.testCase.flowCenter;

import cn.dxz.base.CaseBase;
import cn.dxz.business.entities.Approveflow;
import cn.dxz.business.entities.ExpenseBX;
import cn.dxz.business.flowCenter.BudgetExecutionBusiness;
import cn.dxz.business.flowCenter.WorkflowTaskBusiness;
import cn.dxz.utils.ProUtil;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * @author daixuzhong
 * @title: WorkflowTaskTest
 * @description: 任务处理测试
 * @date 2019/6/3
 */
public class WorkflowTaskTest extends CaseBase {

    private static Logger logger = LoggerFactory.getLogger(WorkflowTaskTest.class);

    //一个流程多条用例使用一个driver，保证只打开一次浏览器
    private WebDriver driver = NewExpenseBXTest.driver;
    //参数
    private static ExpenseBX param;

    private static ProUtil proUtil = new ProUtil("flowCenter/flowInfo.properties");
    private BudgetExecutionBusiness beb = new BudgetExecutionBusiness(driver);
    private WorkflowTaskBusiness wtb = new WorkflowTaskBusiness(driver);

    @Test(description = "撤回费用报销单")
    public void A_recall() {
        try {
            //撤回
            beb.recall();
        } catch (Exception e) {
            logger.error("~~~~~~recall error~~~~~~");
            logger.error("******message error:",e);
        }
    }

    @Test(description = "再次编辑-提交")
    public void B_reEditAndSubmit() {
        try {
            //再次编辑-提交
            param = NewExpenseBXTest.param;
            logger.info(param.getTitle());
            beb.reEditAndSubmit(param);
        } catch (Exception e) {
            logger.error("******B_reEditAndSubmit message error:",e);
        }
    }

    @Test(description = "审批单据")
    public void C_approve() {
        try {
            //审批单据
            String[] userInfo = proUtil.formatUserInfo(proUtil.readFile("FYBX_Step2"));
            Approveflow approveflow = new Approveflow();
            approveflow.setTitle(param.getTitle());
            approveflow.setUserName(userInfo[0]);
            approveflow.setPassword(userInfo[1]);
            approveflow.setApproveComment(proUtil.readFile("approveComment"));
            wtb.approve(approveflow);
        } catch (Exception e) {
            logger.error("******C_approve message error:",e);
        }
    }

    @Test(description = "委托")
    public void D_entrust() {
        try {

        } catch (Exception e) {
            logger.error("******D_entrust message error:",e);
        }
    }




}
