package com.selenium.Mysel.java_selenium;

	import java.io.File;
import java.io.FileInputStream;
	import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DateUtil;
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class DataManager {

	    private static XSSFSheet ExcelWSheet;
	    //private static XSSFSheet ExcelWSheet2;
	    private static XSSFWorkbook ExcelWBook;
	    //private static XSSFWorkbook ExcelWBook2;
	    private static XSSFCell Cell;
	    private static XSSFCell HeaderCell;
	   // private static XSSFCell Cell2;
	    private static XSSFRow Row;
	    private static XSSFRow HeaderRow;
	    //private static XSSFRow Row2;

	    // This method is to set the File path and to open the Excel file, Pass
	    // Excel Path and Sheet name as Arguments to this method
	    public static Object[][] getExcelData(String FilePath, String SheetName) throws Exception {
	        String[][] tabArray = null;

	        try {
	            // Access the required test data sheet
	            FileInputStream ExcelFile = new FileInputStream(FilePath);
	            ExcelWBook = new XSSFWorkbook(ExcelFile);
	            ExcelWSheet = ExcelWBook.getSheet(SheetName);

	            int total=1;
	            int totalNoOfCols = 2;
	            int totalNoOfRows = ExcelWSheet.getLastRowNum();

	            tabArray = new String[total][totalNoOfRows];
	            
	            
	            for (int p = 2; p<=totalNoOfCols; p++) {
	            	

	            for (int i = 1; i <= totalNoOfRows; i++) {
	            	Row = ExcelWSheet.getRow(i);
	                for (int j = 2; j <= totalNoOfCols; j++) {
	                    Cell = Row.getCell(j);
	                    int cel_Type = Cell.getCellType();
	                    switch (cel_Type) {
	                    case XSSFCell.CELL_TYPE_NUMERIC: // 0
	                        if (DateUtil.isCellDateFormatted(Cell)) {
	                            DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
	                            tabArray[p-2][i-1] = df.format(Cell.getDateCellValue());
	                        } else {
	                            tabArray[p-2][i-1] = String.format("%d", (long) Cell.getNumericCellValue());
	                        }
	                        break;
	                    case XSSFCell.CELL_TYPE_STRING: // 1
	                        tabArray[p-2][i-1] = Cell.getStringCellValue();
	                        break;
	                    }
	                }
	            }
	        }
	        }
	        catch (FileNotFoundException e) {
	            System.out.println("Could not read the Excel sheet");
	            e.printStackTrace();
	        } catch (IOException e) {
	            System.out.println("Could not read the Excel sheet");
	            e.printStackTrace();
	        }
	        return tabArray;
	    }
	    
	    
	    public static Object[][] getShoppingData(String FilePath, String SheetName) throws Exception {
	        String[][] tabArray2 = null;

	        try {
	            // Access the required test data sheet
	            FileInputStream ExcelFile = new FileInputStream(FilePath);
	            ExcelWBook = new XSSFWorkbook(ExcelFile);
	            ExcelWSheet = ExcelWBook.getSheet(SheetName);

	            int total2=1;
	            int totalNoOfCols2 = 5;
	            int totalNoOfRows2 = ExcelWSheet.getLastRowNum();
	            int count = 0;
	            tabArray2 = new String[total2][15];
	            //for (int p = 15; p<=totalNoOfCols2; p++) {
	            	
	            for (int i = 1; i <= totalNoOfRows2; i++) {
	                for (int j = 1; j < totalNoOfCols2; j++) {
	                    Cell = ExcelWSheet.getRow(i).getCell(j-1);
	                    int cel_Type = Cell.getCellType();
	                    switch (cel_Type) {
	                    case XSSFCell.CELL_TYPE_NUMERIC: // 0
	                        if (DateUtil.isCellDateFormatted(Cell)) {
	                            DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
	                            tabArray2[0][count + (j-1)] = df.format(Cell.getDateCellValue());
	                        } else {
	                            tabArray2[0][count + (j-1)] = String.format("%d", (long) Cell.getNumericCellValue());
	                        }
	                        break;
	                    case XSSFCell.CELL_TYPE_STRING: // 1
	                        tabArray2[0][count + (j-1)] = Cell.getStringCellValue();
	                        break;
	                    }
	                }
	                count += 5;
	            }
	        }
	        
	        catch (FileNotFoundException e) {
	            System.out.println("Could not read the Excel sheet");
	            e.printStackTrace();
	        } catch (IOException e) {
	            System.out.println("Could not read the Excel sheet");
	            e.printStackTrace();
	        }
	        return tabArray2;
	    }
	    
	    
	     public static void writeShoppingData(ArrayList<ArrayList<String>> itemList) throws IOException {
	    	 
	    	 
	    	 String headers[] = {"Row number", "Product Name", "SKU", "Color", "Size", "Quantity", "Total Price"};
	    	
	    	 //FileInputStream ExcelFile = new FileInputStream(FilePath);
	    	 File file = new File(System.getProperty("user.dir") + "\\DataSheetOutput.xlsx");
	    	 FileInputStream ExcelFile = new FileInputStream(file);
	         ExcelWBook = new XSSFWorkbook(ExcelFile);
	    			
	    	if (ExcelWBook.getNumberOfSheets() == 0)
	    		ExcelWSheet = ExcelWBook.createSheet("Product");
	    	else
	    		ExcelWSheet = ExcelWBook.getSheet("Product");
	    	
	    	/* String[][] data = new String[3][2];
			data[0][0] = "Name";
			data[0][1] = "City";
			data[1][0] = "Shekhar";
			data[1][1] = "Bangalore";
			data[2][0] = "Manan";
			data[2][1] = "Delhi"; */
			//Row count array
			int dataRows = itemList.size();
			//Column count
			int dataColumn = itemList.get(0).size();
			
			//for loop for iterating over the data 
			
			HeaderRow = ExcelWSheet.createRow(0);
			for (int i = 0; i<dataColumn; i++) {
			HeaderCell = HeaderRow.createCell(i);
			HeaderCell.setCellValue(headers[i]);
			}
			
			for(int i=0;i<dataRows;i++){
				 Row =ExcelWSheet.createRow(i+1);
				for(int j=0;j<dataColumn;j++){
					String fillData = itemList.get(i).get(j);
					System.out.println(fillData+"--");
			    	 Cell = Row.createCell(j);
			    	 //Set value into cell
					Cell.setCellValue(fillData); 
				}
			}
			//File file = new File(System.getProperty("user.dir") + "\\DataSheetOutput.xlsx");
				
				
			FileOutputStream fileout = new FileOutputStream(file);
			ExcelWBook.write(fileout);
			fileout.close();
	    	
	    } 
	     
	     
	    public static void writeTotalData(ArrayList<String> itemTotal) throws IOException {
	    	
	    	String headers[] = {"Row number", "Total Products", "Total Shipping", "Total"};
	    	
	    	 //FileInputStream ExcelFile = new FileInputStream(FilePath);
	    	File file = new File(System.getProperty("user.dir") + "\\DataSheetOutput.xlsx");
	    	FileInputStream ExcelFile = new FileInputStream(file);
            ExcelWBook = new XSSFWorkbook(ExcelFile);
	         //ExcelWBook = new XSSFWorkbook();
	    			
	    	if (ExcelWBook.getSheet("Price") != null)
	    		ExcelWSheet = ExcelWBook.getSheet("Price");	
	    	else
	    		ExcelWSheet = ExcelWBook.createSheet("Price");
	    	
	    	int dataColumn = itemTotal.size();
	    	
	    	
	    	
	    	if(ExcelWSheet.getLastRowNum() == 0) {
	    		
		    	HeaderRow = ExcelWSheet.createRow(0);
		    	for (int i = 0; i<headers.length; i++) {
					HeaderCell = HeaderRow.createCell(i);
					HeaderCell.setCellValue(headers[i]);
					}
	    	}
	    	
	    	
	    	if(ExcelWSheet.getLastRowNum()>=1) {
	    		int rowcount = ExcelWSheet.getLastRowNum();
	    		
	    		Row = ExcelWSheet.createRow(rowcount);
	    		XSSFCell Rowno = Row.createCell(0);
	    		Rowno.setCellValue(rowcount);
	    		
	    		for(int j=0;j<dataColumn;j++){
					String fillData = itemTotal.get(j);
					System.out.println(fillData+"--");
			    	 Cell = Row.createCell(j+1);
			    	 //Set value into cell
					Cell.setCellValue(fillData); 
				}
	    		
	    		
	    	}
	    	
	    	
	    	
	    	
	    	
	    	FileOutputStream fileout = new FileOutputStream(file);
			ExcelWBook.write(fileout);
			fileout.close();
	    	
	    	
	    	
	    }
	    
	}

