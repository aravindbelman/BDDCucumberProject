package com.LegacyApplication.ExcelReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.Utilities.WaitMethods;


public class ExcelReader {

	public static XSSFWorkbook wbName;
	public static XSSFSheet sheetName;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static String xlFilePath;

	/*
	 * Purpose: This method is used to set excel file path
	 * @param String(File Path), String (Sheet Name)
	 * @return NA
	 */
	public static void set_excel_file(String xlFilePath, String SheetName) throws IOException {

		ExcelReader.xlFilePath = xlFilePath;
		FileInputStream  fis = new FileInputStream(xlFilePath);
		wbName = new XSSFWorkbook(fis);
		sheetName = wbName.getSheet(SheetName);

		/*File file = new File(FilePath);
		FileInputStream fis = new FileInputStream(file);

		wbName = new XSSFWorkbook(fis);
		sheetName = wbName.getSheet(SheetName);*/

		fis.close();
	}

	/*
	 * Purpose: This method is used to get row count in an excel sheet
	 * @param NA
	 * @return int
	 */
	public static int get_row_count() throws IOException
	{
		int rowCount = sheetName.getLastRowNum()+1;
		return rowCount;
	}

	/*
	 * Purpose: This method is used to get column count in an excel sheet
	 * @param NA
	 * @return int
	 */
	public static int get_column_count()
	{

		row = sheetName.getRow(0);
		int colCount = row.getLastCellNum();
		return colCount;
	}

	/*
	 * Purpose: This method is used to get String Cell Data from rown and column
	 * @param int(row number), int (column number)
	 * @return String
	 */
	public static String get_string_cell_data(int RowNum, int ColNum) {
		try {
			cell = sheetName.getRow(RowNum).getCell(ColNum);
			String CellData = cell.getStringCellValue().toString().trim();
			return CellData;
		} catch (NullPointerException e) {
			return " ";
		}
	}

	/*
	 * Purpose: This method is used to get Numeric Cell Data from rown and column
	 * @param int(row number), int (column number)
	 * @return String
	 */
	public static String get_numeric_cell_data(int RowNum, int ColNum) {

		cell = sheetName.getRow(RowNum).getCell(ColNum);
		int numdata = (int) cell.getNumericCellValue();

		String CellData = String.valueOf((numdata));
		return CellData;

	}

	/*
	 * Purpose: This method is used to get Boolean Cell Data from rown and column
	 * @param int(row number), int (column number)
	 * @return NA
	 */
	public static String get_boolean_cell_data(int RowNum, int ColNum) {

		cell = sheetName.getRow(RowNum).getCell(ColNum);
		String celldata = cell.getStringCellValue().toString().trim();

		return celldata;

	}

	/*
	 * Purpose: This method is used to set and get the excel data
	 * @param String (Sheet Name), int(row number), int (column number)
	 * @return String
	 */
	public static String set_and_get_excel_data(String SheetName, int RowNum, int ColNum) throws IOException {

		set_excel_file(Locations.testDataFilePath, SheetName);
		String data = get_string_cell_data(RowNum, ColNum).toString();
		return data;
	}

	/*
	 * Purpose: This method is used to set data in an excel cell
	 * @param String(Result), int (Row Num), int (Col Num)
	 * @return NA
	 */
	public static void set_data_in_cell(String Result, int RowNum, int ColNum) throws IOException {

		row = sheetName.getRow(RowNum);
		cell = row.getCell(ColNum, MissingCellPolicy.RETURN_BLANK_AS_NULL);

		if (cell == null) {

			cell = row.createCell(ColNum);
			cell.setCellValue(Result);
		} else {
			cell.setCellValue(Result);
		}
		String filepath = Locations.testDataFilePath;
		FileOutputStream fout = new FileOutputStream(filepath);
		wbName.write(fout);
		fout.flush();
	}

	/*
	 * Purpose: This method is used to set value in an excel cell based on row and column number
	 * @param String(sheet name), int (Row Num), int (Col Num), String value
	 * @return NA
	 */
	public static boolean setCellData(String xlFilePath, String sheetName, int colNumber, int rowNum, String value)
	{
		try
		{
			FileInputStream fis = new FileInputStream(xlFilePath);
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			fis.close();
			XSSFSheet  sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNum);
			if(row==null)
				row = sheet.createRow(rowNum);

			cell = row.getCell(colNumber);
			if(cell == null)
				cell = row.createCell(colNumber);

			cell.setCellValue(value);

			FileOutputStream fos = new FileOutputStream(xlFilePath);
			workbook.write(fos);
			fos.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return  false;
		}
		return true;
	}

	/*
	 * Purpose: This method is used to get row data on the basis of column name
	 * @param String(Column Name), int (Row Number)
	 * @return NA
	 */
	public static String get_row_data_from_col(String colname, int rownumber) {
		XSSFRow row = sheetName.getRow(0);

		int col_num = -1;

		for(int i=0; i < row.getLastCellNum(); i++)
		{
			if(row.getCell(i).getStringCellValue().trim().equals(colname))
				col_num = i;
		}

		row = sheetName.getRow(rownumber);
		XSSFCell cell = row.getCell(col_num);
		try {
			String value = cell.getStringCellValue();
			System.out.println("The Value taken from the column "+colname+" is - "+ value);
			return value;
		}catch(IllegalStateException e) {

			int numdata = (int) cell.getNumericCellValue();
			String value = String.valueOf((numdata));
			System.out.println("The Value taken from the column "+colname+" is - "+ value);
			return value;

		}catch(NullPointerException e2) {


			return " ";
		}

	}

	/*
	 * Purpose: This method is used to set cell data on the basis of column name, Row Number
	 * @param String(Column Name), int (Row Number), String (Value)
	 * @return NA
	 */
	public static boolean set_cell_data(String colName, int rowNum, String value)
	{
		XSSFRow row = sheetName.getRow(0);
		try
		{
			int col_Num = -1;
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName))
				{
					col_Num = i;
				}
			}

			sheetName.autoSizeColumn(col_Num);
			row = sheetName.getRow(rowNum);
			if(row==null)
				row = sheetName.createRow(rowNum);

			cell = row.getCell(col_Num);
			if(cell == null)
				cell = row.createCell(col_Num);

			cell.setCellValue(value);
			System.out.println("The Value entered in the column "+colName+" of the excel cell is - "+ value);

			FileOutputStream fos = new FileOutputStream(xlFilePath);
			wbName.write(fos);
			fos.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return  false;
		}
		return true;
	}

	/*
	 * Purpose: This method is used get all data from excel sheet
	 * @param NA
	 * @return NA
	 */
	@SuppressWarnings("deprecation")
	public static void getRowsData() {

		Iterator<Row> rowIterator = sheetName.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_BOOLEAN:
					System.out.print(cell.getBooleanCellValue() + "\t\t");
					break;
				case Cell.CELL_TYPE_NUMERIC:
					System.out.print(cell.getNumericCellValue() + "\t\t");
					break;
				case Cell.CELL_TYPE_STRING:
					System.out.print(cell.getStringCellValue() + "\t\t");
					break;
				}
			}
		}
	}
		
	/*
	 * Purpose: This method is used to get row data Randomly  on the basis of column name
	 * @param String(Column Name), int (Row Number)
	 * @return NA
	 */
	public static String get_row_data_Randomly_from_col(String colname) {
		
		
		
		Random rand = new Random();
		int row2 = rand.nextInt(sheetName.getLastRowNum());
		row.getRowNum();
		return colname;
		
		
	}

}





