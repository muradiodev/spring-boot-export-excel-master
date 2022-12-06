package com.techgeeknext.util;

import com.techgeeknext.model.Users;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            List<String> titles = Arrays.asList("Pers. Nr", "Name", "Vorname", "IBAN", "BIC");

            //Set data
            int rowNum = 3;
            int cellNum = 0;
            Map<String, String> usersMap = getUsersMap(usr, titles.size());

            for (int i = 0; i < titles.size(); i++) {
                Row empDataRow = sheet.createRow(++rowNum);

                Cell empNameCell = empDataRow.createCell(cellNum);
                empNameCell.setCellStyle(cellStyle);
                empNameCell.setCellValue(titles.get(i));
                for (int j = 0; j < usr.size(); j++) {
                    Cell empIdCell = empDataRow.createCell(++cellNum);
                    empIdCell.setCellStyle(cellStyle);
                    empIdCell.setCellValue(usersMap.get(String.format("%d_%d",j, i)));
                }
//                for (Users users : usr) {
//                    Cell empIdCell = empDataRow.createCell(++cellNum);
//                    empIdCell.setCellStyle(cellStyle);
//                    empIdCell.setCellValue(users.getPersonal_nr());
//                }
                cellNum = 0;

            }
            workbook.write(response.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, String> getUsersMap(List<Users> users, int rowCount) {
        Map<String, String> map = new HashMap<>();
        int count = 0;
        for (Users user : users) {
            map.put(String.format("%d_0",count),user.getPersonal_nr()+"");
            map.put(String.format("%d_1",count),user.getFirstName());
            map.put(String.format("%d_2",count),user.getLastName());
            count++;
        }
        return map;
    }
}