package cn.dxz.business.entities;

/**
 * @author daixuzhong
 * @title: BudgetMaking
 * @description: TODO
 * @date 2019/5/29
 */
public class BudgetMaking {

    //预算编制-下属导航菜单
    private String navi;

    //预算表名称
    private String tableName;

    //组织机构名称
    private String department;

    //预算项名称
    private String budgetItem;

    //关系预算表
    private String relaTable;

    public String getRelaTable() {
        return relaTable;
    }

    public void setRelaTable(String relaTable) {
        this.relaTable = relaTable;
    }

    public String getBudgetItem() {
        return budgetItem;
    }

    public void setBudgetItem(String budgetItem) {
        this.budgetItem = budgetItem;
    }

    public String getNavi() {
        return navi;
    }

    public void setNavi(String navi) {
        this.navi = navi;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
