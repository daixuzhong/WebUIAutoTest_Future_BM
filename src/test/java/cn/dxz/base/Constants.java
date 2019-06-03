package cn.dxz.base;

/**
 * @author daixuzhong
 * @title: Constants
 * @description: 常用常量
 * @date 2019/5/9
 */
public class Constants {

    public enum browser {
        IE("ie"), CHROME("chrome"), FIRFOX("fireFox")

        ;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        private String text;

        private browser(String text) {
            this.text=text;
        }

    }

    public enum Numbers {
        ZERO(0),ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),
        EIGHT(8),NINE(9),TEN(10)
        ;

               public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        private int code;

        private Numbers(int code) {
            this.code = code;
        }
    }


    //搜索框输入值
    public static final String SEARCHINPUT_PATH = "/html/body/div[4]/input[1]";

    public enum Status {

        SUCCESS("成功"), FAIL("失败"),
        FINISHED("已完成"),UN_FINISHED("未处理"),
        SUBMITTED("已提交"),UN_SUBMITTED("未提交")
        ;
        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        private String text;

        private Status(String text) {
            this.text=text;
        }
    }

    public enum Buttons {

        EDIT("编辑"),SUBMIT("提交"),SAVE("保存"),
        APPROVE("审批"),ENTRUST("委托"),CONSULT("征询"),RETURN_BACK("退回"),CLOSE("关闭"),
        CONFIRM("确认"),CANCEL("取消"), XCLOSE("×"), ENSURE("确定")
        ;
        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        private String text;

        private Buttons(String text) {
            this.text=text;
        }
    }


    public static final String BUDGET_BM = "全面预算";
    public static final String SYSTEM_ADMIN = "系统管理";
    public static final String BM_ADMIN = "门户管理";

    public static final String MY_TICKET = "我填报的单据";
    public static final String MY_APPROVED_TICKET = "我审核的单据";
    public static final String TICKET_QUERY = "所有单据";
    public static final String BUDGET_ADD_TICKET_QUERY = "预算变更查询";

}
