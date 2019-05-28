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

}
