package cn.dxz.business.entities;

/**
 * @author daixuzhong
 * @date 2019/5/1212:50 PM
 */
public class User  {

    //名称
    private String name;

    //代码
    private String code;

    //别名
    private String name1;

    //描述
    private String description;

    //电子信箱
    private String email;

    //密码
    private String password;

    //所属部门
    private String department;

    //可用部门
    private String enableDepartment;

    //所属公司
    private String company;

    //手机号码
    private String mobile;

    //直接上级
    private String directManager;

    //所属用户组
    private String userGroup;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEnableDepartment() {
        return enableDepartment;
    }

    public void setEnableDepartment(String enableDepartment) {
        this.enableDepartment = enableDepartment;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDirectManager() {
        return directManager;
    }

    public void setDirectManager(String directManager) {
        this.directManager = directManager;
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }
}
