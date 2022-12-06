package com.techgeeknext.util;

import com.techgeeknext.model.Users;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ExcelGeneratorUtility2 {

    public static void employeeDetailReport(HttpServletResponse response, List<Users> usr) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Employee Example");

            CellStyle cellStyle = workbook.createCellStyle();


            //set border to table
            cellStyle.setBorderTop(BorderStyle.MEDIUM);
            cellStyle.setBorderRight(BorderStyle.MEDIUM);
            cellStyle.setBorderBottom(BorderStyle.MEDIUM);
            cellStyle.setBorderLeft(BorderStyle.MEDIUM);
            cellStyle.setAlignment(HorizontalAlignment.LEFT);
            // 1st Row as Header
            Row row = sheet.createRow(0);
            Cell cell = row.createCell(0);
            cell.setCellValue("Monat");
            cell.setCellStyle(cellStyle);

            Cell cell2 = row.createCell(1);
            cell2.setCellValue("Nov-22");
            cell2.setCellStyle(cellStyle);

            // Employee Datas
            Row row1 = sheet.createRow(3);
//            Cell cell3 = row1.createCell(0);
//            cell3.setCellValue("PersonalNr");
//            cell3.setCellStyle(cellStyle);
//
//
//
//            Cell cell4 = row1.createCell(1);
//            cell4.setCellValue("004");
//            cell4.setCellStyle(cellStyle);
//
//            Cell cell5 = row1.createCell(2);
//            cell5.setCellValue("048");
//            cell5.setCellStyle(cellStyle);
//
//
//
//            Cell cell6 = row1.createCell(3);
//            cell6.setCellValue("014");
//            cell6.setCellStyle(cellStyle);

            List<String> titles = Arrays.asList("Pers. Nr", "Name", "Vorname", "IBAN", "BIC");

            //Set data
            int rowNum = 3;
            int cellNum = 0;
            Users users = new Users();
            for (int i = 0; i <= titles.size(); i++) {
                Row empDataRow = sheet.createRow(++rowNum);

                Cell empNameCell = empDataRow.createCell(cellNum);
                empNameCell.setCellStyle(cellStyle);
                empNameCell.setCellValue(titles.get(i));
                personalDetails(users.getPersonal_nr(), empDataRow, cellNum, cellStyle);
//                personalDetails(users, empDataRow, cellNum, cellStyle);


                i++;
            }


            //write output to response
            workbook.write(response.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private static void personalDetails(int personal_nr, Row empDataRow, int cellNum, CellStyle cellStyle) {
//    }

    public static  void <T extends Users> personalDetails(T[] user, Row empDataRow, int cellNum, CellStyle cellStyle) {
        Cell empIdCell = empDataRow.createCell(++cellNum);
        empIdCell.setCellStyle(cellStyle);
        empIdCell.setCellValue(user);
        cellNum = 0;
    }
}
