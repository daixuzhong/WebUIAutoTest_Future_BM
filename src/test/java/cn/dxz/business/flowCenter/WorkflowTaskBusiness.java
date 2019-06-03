package cn.dxz.business.flowCenter;

import cn.dxz.actions.flowCenter.WorkflowTaskAction;
import cn.dxz.base.Constants;
import cn.dxz.business.HomeBusiness;
import cn.dxz.business.LoginBusiness;
import cn.dxz.business.entities.Approveflow;
import org.openqa.selenium.WebDriver;

/**
 * @author daixuzhong
 * @title: WorkflowTaskBusiness
 * @description: 流程任务处理业务类
 * @date 2019/6/3
 */
public class WorkflowTaskBusiness {
    private LoginBusiness loginBusiness;
    private HomeBusiness homeBusiness;
    private WorkflowTaskAction wfta;

    public WorkflowTaskBusiness(WebDriver driver) {
        loginBusiness = new LoginBusiness(driver);
        homeBusiness = new HomeBusiness(driver);
        wfta = new WorkflowTaskAction(driver);
    }

    /**
     * 审批单据
     * @throws InterruptedException
     */
    public void approve(Approveflow param) throws InterruptedException {
        //注销当前用户
        homeBusiness.logOff();
        Thread.sleep(3000);
        //登录
        loginBusiness.login(param.getUserName(),param.getPassword(),false);
        //点击我的任务-更多
        homeBusiness.enterMyTask();
        //输入查询条件
        Thread.sleep(2000);
        wfta.sendKeyQueryTask(param.getTitle());
        Thread.sleep(1000);
        wfta.clickCheckBtn();

        Thread.sleep(3000);
        //滚动条到底部
        wfta.scrolltoBottom();
        Thread.sleep(2000);

        //点击审批
        wfta.clickBtn(Constants.Buttons.APPROVE.getText());
        Thread.sleep(1000);
        //输入审批意见
        wfta.sendKeyApproveComment(param.getApproveComment());
        Thread.sleep(1000);
        //点击批准
        wfta.clickApproveBtn();
        Thread.sleep(1000);
        //弹框确认
        wfta.clickPopBtn(Constants.Buttons.ENSURE.getText());
        Thread.sleep(2000);

    }
}
