package cn.dxz.business.entities;

/**
 * @author daixuzhong
 * @title: Approveflow
 * @description: 单据审批流程
 * @date 2019/6/3
 */
public class Approveflow {

    //单据唯一title
    private String title;


    //用户名
    private String userName;

    //密码
    private String password;

    //审批意见
    private String approveComment;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApproveComment() {
        return approveComment;
    }

    public void setApproveComment(String approveComment) {
        this.approveComment = approveComment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
