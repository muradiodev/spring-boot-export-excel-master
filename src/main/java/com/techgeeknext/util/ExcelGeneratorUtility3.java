//package com.techgeeknext.util;
//
//import com.techgeeknext.model.Users;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFFont;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//public class ExcelGeneratorUtility3 {
//
////    private List<Users> listRecords;
////    private XSSFWorkbook workbook;
////    private XSSFSheet sheet;
////
////    public ExcelGeneratorUtility3(List<Users> listRecords) {
////        this.listRecords = listRecords;
////        workbook = new XSSFWorkbook();
////    }
////
////    private void writeHeader() {
////        sheet = workbook.createSheet("Records");
////
////        Row row = sheet.createRow(0);
////
////        CellStyle style = workbook.createCellStyle();
////        XSSFFont font = workbook.createFont();
////        font.setBold(true);
////        font.setFontHeight(16);
////        style.setFont(font);
////
////        createCell(row, 0, "ID", style);
////        createCell(row, 1, "Name", style);
////        createCell(row, 2, "Surname", style);
////        createCell(row, 3, "Chief", style);
////
////    }
////
////    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
////        sheet.autoSizeColumn(columnCount);
////        Cell cell = row.createCell(columnCount);
////        if (value instanceof Integer) {
////            cell.setCellValue((Integer) value);
////        } else if (value instanceof Long) {
////            cell.setCellValue((Long) value);
////        } else if (value instanceof Boolean) {
////            cell.setCellValue((Boolean) value);
////        } else {
////            cell.setCellValue((String) value);
////        }
////        cell.setCellStyle(style);
////    }
////
////    private void write() {
////        int rowCount = 1;
////
////        CellStyle style = workbook.createCellStyle();
////        XSSFFont font = workbook.createFont();
////        font.setFontHeight(14);
////        style.setFont(font);
////
////        for (Users record : listRecords) {
////            Row row = sheet.createRow(rowCount++);
////            int columnCount = 0;
////
////            createCell(row, columnCount++, record.getPersonal_nr(), style);
////            createCell(row, columnCount++, record.getFirstName(), style);
////            createCell(row, columnCount++, record.getLastName(), style);
////            createCell(row, columnCount++, record.getChief(), style);
////
////        }
////    }
////
////    public void generate(HttpServletResponse response) throws IOException {
////        writeHeader();
////        write();
////        ServletOutputStream outputStream = response.getOutputStream();
////        workbook.write(outputStream);
////        workbook.close();
////
////        outputStream.close();
////
////    }
//}