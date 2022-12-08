package com.techgeeknext.util;

import com.techgeeknext.model.Users;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelGeneratorUtility2 {
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;

    public static void employeeDetailReport(HttpServletResponse response, List<Users> usr) throws IOException {
        workbook = new XSSFWorkbook();

        sheet = workbook.createSheet("Employee Example");


        XSSFColor color = new XSSFColor(new java.awt.Color(217, 225, 242), null);
        XSSFCellStyle catStyle = workbook.createCellStyle();
        CellStyle cellStyle = workbook.createCellStyle();
        XSSFFont fontCat = workbook.createFont();
        XSSFFont fontCell = workbook.createFont();

        fontCat.setBold(true);
        fontCat.setFontHeight(12);
        fontCell.setBold(false);
        fontCell.setFontHeight(11);


        //set border to table
        cellStyle.setBorderTop(BorderStyle.MEDIUM);
        cellStyle.setBorderRight(BorderStyle.MEDIUM);
        cellStyle.setBorderBottom(BorderStyle.MEDIUM);
        cellStyle.setBorderLeft(BorderStyle.MEDIUM);
        cellStyle.setAlignment(HorizontalAlignment.LEFT);
        cellStyle.setFont(fontCell);

        catStyle.setFillForegroundColor(color);
        catStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        catStyle.setBorderTop(BorderStyle.MEDIUM);
        catStyle.setFont(fontCat);
        catStyle.setBorderRight(BorderStyle.MEDIUM);
        catStyle.setBorderBottom(BorderStyle.MEDIUM);
        catStyle.setBorderLeft(BorderStyle.MEDIUM);
        catStyle.setAlignment(HorizontalAlignment.LEFT);


        // 1st Row as Header
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Monat");
        cell.setCellStyle(catStyle);

        Cell cell2 = row.createCell(1);
        cell2.setCellValue("Nov-22");
        cell2.setCellStyle(catStyle);

        Row prsndt = sheet.createRow(3);
        Cell cell3 = prsndt.createCell(0);
        cell3.setCellValue("Personal Daten");
        cell3.setCellStyle(catStyle);


        // Employee Datas
        List<String> titles = Arrays.asList("Pers. Nr", "Name", "Vorname", "Bank-Institut", "IBAN", "BIC", "Familienstand");

        //Set data
        int rowNum = 3;
        int cellNum = 0;
        Map<String, String> usersMap = getUsersMap(usr, titles.size());


        for (int i = 0; i < titles.size(); i++) {
            Row empDataRow = sheet.createRow(++rowNum);

            Cell empNameCell = empDataRow.createCell(cellNum);
            empNameCell.setCellStyle(catStyle);
            empNameCell.setCellValue(titles.get(i));
            for (int j = 0; j < usr.size(); j++) {
                Cell empIdCell = empDataRow.createCell(++cellNum);
                empIdCell.setCellStyle(cellStyle);

                empIdCell.setCellValue(usersMap.get(String.format("%d_%d", j, i)));
            }
//                for (Users users : usr) {
//                    Cell empIdCell = empDataRow.createCell(++cellNum);
//                    empIdCell.setCellStyle(cellStyle);
//                    empIdCell.setCellValue(users.getPersonal_nr());
//                }
            cellNum = 0;

        }
        workbook.write(response.getOutputStream());


    }

    private static Map<String, String> getUsersMap(List<Users> users, int rowCount) {
        Map<String, String> map = new HashMap<>();
        int count = 0;
        for (Users user : users) {
            map.put(String.format("%d_0", count), user.getPersonal_nr() + "");
            map.put(String.format("%d_1", count), user.getFirstName());
            map.put(String.format("%d_2", count), user.getLastName());
            map.put(String.format("%d_3", count), user.getBankName());
            map.put(String.format("%d_4", count), user.getIban());
            map.put(String.format("%d_5", count), user.getBic());
            map.put(String.format("%d_6", count), user.getMaritalStatus()+"");
            count++;
        }
        return map;
    }
}