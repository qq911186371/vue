package com.dennis.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dennis.domain.PeUser;
import com.dennis.service.UserService;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

/**
 * @author 李恒
 * @date 2019-08-23 00:50
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/export")
    public void export(MultipartFile file, HttpSession session, HttpServletResponse response) throws IOException {
        //获取Excell路径
        String excelPath = ClassUtils.getDefaultClassLoader().getResource("static/user.xlsx").getPath();
        //获取workbook
        XSSFWorkbook wb = new XSSFWorkbook(excelPath);
        //获取第一个sheet
        XSSFSheet sheet = wb.getSheetAt(0);
        //设置表头
        XSSFRow row = null;
        XSSFCell cell = null;
        row = sheet.getRow(0);
        cell = row.getCell(1);
        Calendar calendar = Calendar.getInstance();
        cell.setCellValue(calendar.get(Calendar.YEAR) + "年" + calendar.get(Calendar.MONTH) + "月" + "用户信息表");
        //获取每个单元格风格
        CellStyle[] styles = new CellStyle[7];
        row = sheet.getRow(2);
        for (int i = 0; i < styles.length; i++) {
            styles[i] = row.getCell(i + 1).getCellStyle();
        }
        //查询数据
        List<PeUser> users = userService.findAll(Wrappers.emptyWrapper());
        //把查询到的集合插入到表格中
        int rowNum = 2;
        int cellNum = 1;
        for (PeUser user : users) {
            row = sheet.createRow(rowNum++);
            //id
            cell  = row.createCell(cellNum++);
            cell.setCellValue(user.getUserId());
            cell.setCellStyle(styles[0]);
            //姓名
            cell  = row.createCell(cellNum++);
            cell.setCellValue(user.getUserName());
            cell.setCellStyle(styles[1]);
            //密码
            cell  = row.createCell(cellNum++);
            cell.setCellValue(user.getPassword());
            cell.setCellStyle(styles[2]);
            //邮箱
            cell  = row.createCell(cellNum++);
            cell.setCellValue(user.getEmail());
            cell.setCellStyle(styles[3]);
            //薪资
            cell  = row.createCell(cellNum++);
            cell.setCellValue(user.getSalary());
            cell.setCellStyle(styles[4]);
            //性别
            cell  = row.createCell(cellNum++);
            cell.setCellValue(user.getGender());
            cell.setCellStyle(styles[5]);
            //级别
            cell  = row.createCell(cellNum++);
            cell.setCellValue(user.getDegree());
            cell.setCellStyle(styles[6]);
            //初始化cellNum
            cellNum = 1;
        }
        //4.设置下载的信息：两个头（响应消息头） 一个流（响应输出流）
        response.setHeader("Content-Type","application/octet-stream");
        //设置响应数据以下载的方式打开
        response.setHeader("Content-Disposition","attachment;filename=ok.xlsx");
        wb.write(response.getOutputStream());
        //释放资源
        wb.close();
    }
}
