package com.dennis;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.junit.Test;
import sun.nio.ch.Net;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 李恒
 * @date 2019-08-22 20:56
 */
public class TestPoi {
    @Test
    public void test() throws IOException {
        //创建XssfWorkBook
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建sheet
        XSSFSheet sheet = workbook.createSheet("liheng");
        //创建输入流
        FileOutputStream fos = new FileOutputStream("D:/liheng.xlsx");
        //输出文件
        workbook.write(fos);
        //关闭流
        fos.close();
        workbook.close();
    }

    @Test
    public void test01() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("hello");
        XSSFRow row = sheet.createRow(2);
        XSSFCell cell = row.createCell(2);
        cell.setCellValue(888);
        XSSFCellStyle style = workbook.createCellStyle();
        style.setBorderBottom(BorderStyle.DOUBLE);


        Font font = workbook.createFont();
        font.setColor(Font.COLOR_RED);
        style.setFont(font);

        cell.setCellStyle(style);
        FileOutputStream fos = new FileOutputStream("D:/liheng.xlsx");
        workbook.write(fos);
        fos.close();
        workbook.close();
    }

    @Test
    public void testRead() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook("E:\\javaData\\day56maven高级\\预习资料\\资料\\saasexport_day09\\03-资料\\poi资料\\demo.xlsx");
        XSSFSheet sheet = workbook.getSheetAt(0);
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 2; j < row.getLastCellNum(); j++) {
                XSSFCell cell = row.getCell(j);
                sb.append(getValue(cell)).append("---");
            }
            System.out.println(sb.toString());
        }
        workbook.close();
    }

    public Object getValue(Cell cell) {
        Object obj = null;
        switch (cell.getCellType()) {
            case STRING:
                obj = cell.getStringCellValue();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    obj = cell.getDateCellValue();
                    break;
                }
                obj = cell.getNumericCellValue();
                break;
        }
        return obj;
    }
}
