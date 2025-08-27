package com.TestingPurpose;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.LegacyApplication.ExcelReader.ExcelReader;
import com.LegacyApplication.TestBase.TestBase;

public class AddTestResults extends TestBase{
	
	
	public void test_result() throws Exception {
		String excel_path="//TestData//Test_Results.xlsx";
		
		File file = new File(excel_path);
		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos= null;
		XSSFWorkbook wbName = new XSSFWorkbook(fis);
		XSSFSheet sheetName = wbName.getSheet("Test_Results");
		
		XSSFRow row=null;
		XSSFCell cell=null;

		int colNum=-1;

		row=sheetName.getRow(0);
		for(int i=0;i<row.getLastCellNum();i++)
		{
			if(row.getCell(i).getStringCellValue().trim().equals("LoginAttempt"))
			{
				colNum=i;
			}	
		}
		
		row=sheetName.getRow(1);
		if(row==null)
		{
			row=sheetName.createRow(1);
		}
		cell=row.getCell(colNum);
		if(cell==null)
		{
			cell=row.createCell(colNum);
			cell.setCellValue("Success");
			fos= new FileOutputStream(file);
			wbName.write(fos);
			fos.close();
		}
	}

}
