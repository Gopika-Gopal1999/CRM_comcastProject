	package com.comcast.crm.generic.FileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
 public String getDataFromExcelFile(String sheet,int row,int cell) throws EncryptedDocumentException, IOException
 {
	 FileInputStream fis=new FileInputStream("./testdata/TestData.xlsx");
	 Workbook wb = WorkbookFactory.create(fis);
	 String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
	 wb.close();
	 return data;
 }
 public int getRowcount(String sheet) throws EncryptedDocumentException, IOException
 {
	 FileInputStream fis=new FileInputStream("./testdata/TestData.xlsx");
	 Workbook wb = WorkbookFactory.create(fis);
	 int rowCount = wb.getSheet(sheet).getLastRowNum();
	 wb.close();
	 return rowCount;
 }
 public void SeDataIntoExcel(String sheet,int row,int cell,String cellvalue) throws EncryptedDocumentException, IOException
 {
     String filepath="C:\\Users\\LENOVO\\TekPyramid\\ComCastCRMGUIFramework\\testdata\\TestData.xlsx";
	 
	 try (FileInputStream fis =new FileInputStream(filepath);
			 Workbook wb=WorkbookFactory.create(fis);
			 FileOutputStream fos=new FileOutputStream(filepath))
	 {
		 org.apache.poi.ss.usermodel.Sheet sheet1 = wb.getSheet(sheet);
		 if(sheet1==null){
			 sheet1=wb.createSheet(sheet);
			 
			 }
		 Row row1 = sheet1.getRow(row);
		 if(row1==null)
		 {
			 row1=sheet1.createRow(row);
		 }
		 
		Cell cell1 = row1.createCell(cell);
		cell1.setCellValue(cellvalue);
		wb.write(fos);
			 	
	} catch (Exception e) {
		
	}
 }
	
 public void setOfExcelData(String sheet,int row,int cell,String value) throws EncryptedDocumentException, IOException
 {
	 FileInputStream fis=new FileInputStream("./testdata/TestData.xlsx");
	 Workbook wb = WorkbookFactory.create(fis);
	 wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(value);
	 FileOutputStream fos=new FileOutputStream("./testdata/TestData.xlsx");
	 wb.write(fos);
	 wb.close();
	 
 }
 
 public Object[][] getMultipledata(String sheet) throws EncryptedDocumentException, IOException
 {
	 FileInputStream fis=new FileInputStream("./testdata/TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	int lastRow = wb.getSheet(sheet).getLastRowNum();
	int lcell = wb.getSheet(sheet).getRow(lastRow).getLastCellNum();
	
	Object [][]ary=new Object [lastRow][lcell];
	for(int i=0;i<=lastRow;i++)
	{
		
	    for(int j=0 ;j<=lcell;j++)
	    {
	    	ary[i][j]=wb.getSheet(sheet).getRow(i).getCell(j).getStringCellValue(); 
	  
	    	
	    }
	    
	    
	}
	return ary;
	
 }

 }

