//package com.techgeeknext.util;
//
//import com.techgeeknext.model.Users;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//public class ExcelGeneratorUtility {
//
//    public static void employeeDetailReport(HttpServletResponse response, List<Users> usr) {
//        try(Workbook workbook = new XSSFWorkbook()){
//            Sheet sheet = workbook.createSheet("Employee TechGeekNext Example");
//
//            CellStyle cellStyle = workbook.createCellStyle();
//
//
//            //set border to table
//            cellStyle.setBorderTop(BorderStyle.MEDIUM);
//            cellStyle.setBorderRight(BorderStyle.MEDIUM);
//            cellStyle.setBorderBottom(BorderStyle.MEDIUM);
//            cellStyle.setBorderLeft(BorderStyle.MEDIUM);
//            cellStyle.setAlignment(HorizontalAlignment.LEFT);
//
//
//            // Header
//            Row row = sheet.createRow(0);
//            Cell cell = row.createCell(0);
//            cell.setCellValue("Id");
//            cell.setCellStyle(cellStyle);
//
//
//            Cell cell1 = row.createCell(1);
//            cell1.setCellValue("Name");
//            cell1.setCellStyle(cellStyle);
//
//
//            Cell cell2 = row.createCell(2);
//            cell2.setCellValue("Role");
//            cell2.setCellStyle(cellStyle);
//
//
//            //Set data
//            int rowNum = 1;
//            for (Users emp : usr) {
//                Row empDataRow = sheet.createRow(rowNum++);
//                Cell empIdCell = empDataRow.createCell(0);
//                empIdCell.setCellStyle(cellStyle);
//                empIdCell.setCellValue(emp.getPersonal_nr());
//
//                Cell empNameCell = empDataRow.createCell(1);
//                empNameCell.setCellStyle(cellStyle);
//                empNameCell.setCellValue(emp.getFirstName());
//
//                Cell empRoleCell = empDataRow.createCell(2);
//                empRoleCell.setCellStyle(cellStyle);
//                empRoleCell.setCellValue(emp.getRoles());
//            }
//
//            //write output to response
//            workbook.write(response.getOutputStream());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
