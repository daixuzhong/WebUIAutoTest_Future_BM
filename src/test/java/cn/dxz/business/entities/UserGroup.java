package cn.dxz.business.entities;

/**
 * @author daixuzhong
 * @title: UserGroup
 * @description: TODO
 * @date 2019/5/14
 */
public class UserGroup {

    public UserGroup(String groupName) {
        this.groupName = groupName;
    }

    //名称
    private String groupName;

    //代码
    private String code;

    //别名
    private String name1;

    //描述
    private String description;

    //备注
    private String notes;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
