package cn.dxz.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;

/**
 * @author daixuzhong
 * @title: ProUtil
 * @description: 读取配置文件的参数
 * @date 2019/5/10
 */
public class ProUtil {

    private static Logger logger = LogManager.getLogger(ProUtil.class);

    private static String PATHROOT = "src/main/resources/";

    private String path;

    public ProUtil(String filePath) {
        this.path = PATHROOT + filePath;
    }

    /**
     * 读取文件
     * @param key
     * @return
     */
    public String readFile(String key) {
        Properties prop = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            //部署到tomcat时使用
//            InputStream fileInputStream1 = this.getClass().getResourceAsStream(filePath);
            BufferedInputStream in = new BufferedInputStream(fileInputStream);
            prop.load(new InputStreamReader(in, "utf-8"));
            if (StringUtils.isNotBlank(key)) {
                return prop.getProperty(key);
            }
        } catch (FileNotFoundException e) {
            logger.error("读取文件失败");
            logger.error("filePath=" + path);
            e.printStackTrace();
        } catch (IOException e) {
            logger.error("读取文件失败");
            logger.error("filePath=" + path);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 按,分割用户名密码
     * exp：“admin,1”中逗号前是账号，逗号后是密码
     *
     * @param userInfo
     * @return
     */
    public String[] formatUserInfo(String userInfo) {
        return userInfo.split(",");
    }


    public static void main(String[] args) {

    }

}
