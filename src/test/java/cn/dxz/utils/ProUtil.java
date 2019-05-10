package cn.dxz.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * @author daixuzhong
 * @title: ProUtil
 * @description: 读取配置文件的参数
 * @date 2019/5/10
 */
public class ProUtil {

    private static Logger logger = LoggerFactory.getLogger(ProUtil.class);

    private static String PATHROOT = "src/main/resources/";

    public ProUtil() {

    }

    /**
     * 读取文件
     * @param filePath
     * @param key
     * @return
     */
    public String readFile(String filePath, String key) {
        Properties prop = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(PATHROOT + filePath);
            //部署到tomcat时使用
//            InputStream fileInputStream1 = this.getClass().getResourceAsStream(filePath);
            BufferedInputStream in = new BufferedInputStream(fileInputStream);
            prop.load(new InputStreamReader(in, "utf-8"));
            if (StringUtils.isNotBlank(key)) {
                return prop.getProperty(key);
            }
        } catch (FileNotFoundException e) {
            logger.error("读取文件失败");
            e.printStackTrace();
        } catch (IOException e) {
            logger.error("读取文件失败");
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String userName = new ProUtil().readFile("parameter.properties", "title");

        System.out.println(userName);
    }
}
