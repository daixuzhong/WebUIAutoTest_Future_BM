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

    //付款方式
    private String payType;

    //收款人
    private String payee;

    //明细-预算表
    private String budgetSheet;

    //明细-预算项
    private String budgetItem;

    //明细-成本中心
    private String costCenter;

    //税率
    private String taxRate;

    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public String getBudgetSheet() {
        return budgetSheet;
    }

    public void setBudgetSheet(String budgetSheet) {
        this.budgetSheet = budgetSheet;
    }

    public String getBudgetItem() {
        return budgetItem;
    }

    public void setBudgetItem(String budgetItem) {
        this.budgetItem = budgetItem;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

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

    //发票类型
    private String invoiceType;

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }
}
