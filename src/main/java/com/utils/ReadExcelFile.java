package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelFile {

    public static final String TEST_DATA_SHEET_PATH = "./src/test/resources/ExcelFile/Login.xlsx";
    public static Workbook book;
    public static Sheet sheet;

    public static Object[][] getTestData(String sheetName) throws Exception {
        Object[][] data = null;
        FileInputStream ip = null;

        try {
            ip = new FileInputStream(TEST_DATA_SHEET_PATH);
            book = WorkbookFactory.create(ip);
            sheet = book.getSheet(sheetName);
            
            int rows = sheet.getLastRowNum() + 1;
            
            System.out.println("Rows"+rows);
            
            int cols = sheet.getRow(0).getLastCellNum();
            System.out.println("COLS"+cols);
            
            data = new Object[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    data[i][j] = sheet.getRow(i).getCell(j).toString();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ip != null) {
                try {
                    ip.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (book != null) {
                try {
                    book.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }

    
    
}
