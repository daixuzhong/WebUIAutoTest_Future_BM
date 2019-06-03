package cn.dxz.utils;

import org.apache.log4j.LogManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author daixuzhong
 * @title: ExcelUtils
 * @description: TODO
 * @date 2019/5/29
 */
public class ExcelUtils {

    private static Logger logger = LoggerFactory.getLogger(ExcelUtils.class);

    public static List<String> readExcel(int rowNum) {
        List<String> dataList = new ArrayList<>();
        try{
            // 指定excel的路径
            File src = new File(".\\testCase\\BudgetMakingTestData.xlsx");
            // 加载文件
            FileInputStream fis = new FileInputStream(src);
            // 加载workbook
            @SuppressWarnings("resource")
            XSSFWorkbook wb=new XSSFWorkbook(fis);
            //加载sheet，这里我们只有一个sheet,默认是sheet1
            XSSFSheet sh1= wb.getSheetAt(0);

            // 读数据
            Row r = sh1.getRow(rowNum);
            for (Cell cell : r) {
                dataList.add(cell.toString());
            }
            System.out.println(dataList);
        } catch (Exception e){
            logger.error("读取excel失败，rowNum=" + rowNum);
        }

        return dataList;
    }

//    public static void main(String[] args) {
//        try{
//            // 指定excel的路径
//            File src = new File(".\\testCase\\BudgetMakingTestData.xlsx");
//            // 加载文件
//            FileInputStream fis = new FileInputStream(src);
//            // 加载workbook
//            @SuppressWarnings("resource")
//            XSSFWorkbook wb=new XSSFWorkbook(fis);
//            //加载sheet，这里我们只有一个sheet,默认是sheet1
//            XSSFSheet sh1= wb.getSheetAt(0);
//
//            List<String> dataList = new ArrayList<>();
//            // 读数据
//            Row r = sh1.getRow(1);
//            for (Cell cell : r) {
//                System.out.println(cell.toString());
//                dataList.add(cell.toString());
//            }
//            System.out.println(dataList);
//        } catch (Exception e){
//        }
//
//    }
}
