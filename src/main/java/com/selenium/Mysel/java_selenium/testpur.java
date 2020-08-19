package com.selenium.Mysel.java_selenium;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class testpur {
	private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
    private static XSSFRow Row;

    // This method is to set the File path and to open the Excel file, Pass
    // Excel Path and Sheet name as Arguments to this method
    public static Object[][] getExcelData(String FilePath, String SheetName) throws Exception {
        String[][] tabArray = null;

        try {
            // Access the required test data sheet
            FileInputStream ExcelFile = new FileInputStream(FilePath);
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);

            int totalNoOfCols = 2;
            int totalNoOfRows = ExcelWSheet.getLastRowNum();

            tabArray = new String[totalNoOfRows][totalNoOfCols];

            for (int i = 1; i <= totalNoOfRows; i++) {
            	Row = ExcelWSheet.getRow(i);
                for (int j = 2; j <= totalNoOfCols; j++) {
                    Cell = Row.getCell(j);
                    int cel_Type = Cell.getCellType();
                    switch (cel_Type) {
                    case XSSFCell.CELL_TYPE_NUMERIC: // 0
                        if (DateUtil.isCellDateFormatted(Cell)) {
                            DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                            tabArray[i-1][j-2] = df.format(Cell.getDateCellValue());
                        } else {
                            tabArray[i-1][j-2] = String.format("%d", (long) Cell.getNumericCellValue());
                        }
                        break;
                    case XSSFCell.CELL_TYPE_STRING: // 1
                        tabArray[i-1][j-2] = Cell.getStringCellValue();
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }
        return tabArray;
	

}
    
    public static void main(String[] args) throws Exception {
    	final String xlsxFile = System.getProperty("user.dir") + "\\DataSheet.xlsx";
    	Object[][] arrayObject = DataManager.getExcelData(xlsxFile, "Registration");
    	System.out.println(arrayObject);
    }
}
