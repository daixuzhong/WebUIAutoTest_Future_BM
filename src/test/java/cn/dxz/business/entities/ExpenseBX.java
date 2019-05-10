package cn.dxz.business.entities;

/**
 * @author daixuzhong
 * @title: ExpenseBX
 * @description: 费用报销单参数实体封装
 * @date 2019/5/10
 */
public class ExpenseBX {

    //标题
    private String title;

    //事由
    private String incident;

    //应付金额
    private String amount;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIncident() {
        return incident;
    }

    public void setIncident(String incident) {
        this.incident = incident;
    }
}
