package com.crypterium.cryptApi.utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelWriter {

    private static ExcelWriter instance;

    public static ExcelWriter getInstance() {
        if (instance == null) {
            instance = new ExcelWriter();
        }
        return instance;
    }

    public synchronized void writeToCell(Integer rowNumber, Integer cellNumber, String value) {

    }

    public synchronized void addToReport(int startFrom, String... args) {

        try (InputStream myExcel = new FileInputStream("reports/users.xlsx")) {
            Workbook book = new XSSFWorkbook(myExcel);
            Sheet sheet = book.getSheetAt(0);
            int lastRow = sheet.getLastRowNum();
            lastRow += 1;
            System.out.println(lastRow);
//            sheet.autoSizeColumn(1);
            int index = startFrom;
            Row row = sheet.createRow(lastRow);
            for (String arg : args) {
                row.createCell(index++).setCellValue(arg);
            }
            OutputStream output = new FileOutputStream("reports/users.xlsx");
            book.write(output);
            output.flush();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new ExcelWriter().addToReport(1, "123", "456");
    }
}
