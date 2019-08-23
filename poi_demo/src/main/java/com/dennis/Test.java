package com.dennis;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sun.nio.ch.Net;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

/**
 * @author 李恒
 * @date 2019-08-23 00:17
 */
public class Test {
    /**
     * 出货表打印
     */
//    public void printExcelByTemplate(String inputDate) throws Exception {
//        //1.查询所有货物
//        List<ContractProduct> list = contractProductService.findContractProductByShipTime(inputDate);
//        //2 构建 excel 表格
//        String path = session.getServletContext().getRealPath("/") + "/make/xlsprint/tOUTPRODUCT.xlsx";
//        Workbook wb = new XSSFWorkbook(path);
//        //获得 sheet 对象
//        Sheet sheet = wb.getSheetAt(0);
//        int rownum = 0;
//        int cellnum = 1;
//        Row row = null;
//        Cell cell = null;
//        row = sheet.getRow(rownum++);
//        cell = row.getCell(cellnum);
//        cell.setCellValue(inputDate.replace("-0", "年").replace("-", "年") + "月份出货表");
//        rownum++;
//        CellStyle[] style = new CellStyle[8];
//        row = sheet.getRow(rownum);
//        for (int i = 0; i < style.length; i++) {
//            cell = row.getCell(cellnum++);
//            style[i] = cell.getCellStyle();
//        }
//        cellnum = 1;
//        for (ContractProduct product : list) {
//            row = sheet.createRow(rownum++);
//            row.setHeightInPoints(24f);
//            //客户
//            cell = row.createCell(cellnum++);
//            cell.setCellValue(product.getContract().getCustomName());
//            cell.setCellStyle(style[0]);
//            //订单号
//            cell = row.createCell(cellnum++);
//            cell.setCellValue(product.getContract().getContractNo());
//            cell.setCellStyle(style[1]);
//            //货号
//            cell = row.createCell(cellnum++);
//            cell.setCellValue(product.getProductNo());
//            cell.setCellStyle(style[2]);
//            //数量
//            cell = row.createCell(cellnum++);
//            cell.setCellValue(product.getCnumber());
//            cell.setCellStyle(style[3]);
//            //工厂
//            cell = row.createCell(cellnum++);
//            cell.setCellValue(product.getFactoryName());
//            cell.setCellStyle(style[4]);
//            //工厂交期
//            cell = row.createCell(cellnum++);
//            cell.setCellValue(product.getContract().getDeliveryPeriod());
//            cell.setCellStyle(style[5]);
//            //船期
//            cell = row.createCell(cellnum++);
//            cell.setCellValue(product.getContract().getShipTime());
//            cell.setCellStyle(style[6]);
//            //贸易条款
//            cell = row.createCell(cellnum++);
//            cell.setCellValue(product.getContract().getTradeTerms());
//            cell.setCellStyle(style[7]);
//            cellnum = 1;
//        }
//        //3.下载 response 响应一个字节流
//        DownloadUtil downloadUtil = new DownloadUtil();
//        ByteArrayOutputStream bo = new ByteArrayOutputStream();
//        wb.write(bo);
//        downloadUtil.download(bo, response, "出货表.xlsx");
//    }
}
