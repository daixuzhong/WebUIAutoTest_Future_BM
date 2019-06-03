package cn.dxz.utils;

import java.text.DecimalFormat;
import java.text.ParseException;

/**
 * @author daixuzhong
 * @title: NumberFormatUtil
 * @description: TODO
 * @date 2019/5/31
 */
public class NumberFormatUtil {

    /**
     * 去除数字字符串中的千分位分隔符“,”
     * @param num
     * @return
     */
    public static String format(String num) {
        return num.replace(",", "");
    }

    /**
     * double保留两位小数转，并换成字符串类型
     * @param num
     * @return
     */
    public static String format(Double num) {
        DecimalFormat df = new DecimalFormat("#####0.00 ");
        return df.format(num).trim();
    }
}
