package com.LegacyApplication.ExcelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.LegacyApplication.Locations.Locations;


public class ExcelReader {

	public static XSSFWorkbook wbName;
	public static XSSFSheet sheetName;
	public static XSSFRow row;
	public static XSSFCell cell;
	

	public static void set_excel_file(String FilePath, String SheetName) throws IOException {

		File file = new File(FilePath);
		FileInputStream fis = new FileInputStream(file);

		wbName = new XSSFWorkbook(fis);
		sheetName = wbName.getSheet(SheetName);

		fis.close();
	}

	public static String get_cell_data(int RowNum, int ColNum) {
		try {
			cell = sheetName.getRow(RowNum).getCell(ColNum);
			String CellData = cell.getStringCellValue().toString().trim();
			return CellData;
		} catch (NullPointerException e) {
			return " ";
		}
	}

	public static String get_numeric_cell_data(int RowNum, int ColNum) {

		cell = sheetName.getRow(RowNum).getCell(ColNum);
		int numdata = (int) cell.getNumericCellValue();

		String CellData = String.valueOf((numdata));
		return CellData;

	}

	public static String get_boolean_cell_data(int RowNum, int ColNum) {

		cell = sheetName.getRow(RowNum).getCell(ColNum);
		String celldata = cell.getStringCellValue().toString().trim();

		return celldata;

	}

	public static String set_and_get_excel_data(String SheetName, int RowNum, int ColNum) throws IOException {

		set_excel_file(Locations.testDataFilePath, SheetName);
		String data = get_cell_data(RowNum, ColNum).toString();
		return data;

	}


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
        System.out.println("Value of the Excel Cell is - "+ value);
        return value;
        }catch(IllegalStateException e) {
        	
        		int numdata = (int) cell.getNumericCellValue();
        		String value = String.valueOf((numdata));
             System.out.println("Value of the Excel Cell is - "+ value);
             return value;
        	
        }catch(NullPointerException e2) {
        	
       
            return " ";
        }
       
	}
	
	public static void get_all_row_data_from_col(String colname) {
		
	}
	
	
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
	 * ArrayList<HashMap<String, String>> data0=new ArrayList<HashMap<String,
	 * String>>(); sheetName=wbName.getSheet(SheetName); XSSFRow
	 * headrow=sheetName.getRow(0); for(int
	 * i=1;i<sheetName.getPhysicalNumberOfRows();i++) {
	 * 
	 * XSSFRow currentRow=sheetName.getRow(i); System.out.println(currentRow);
	 * return currentRow;
	 */
	/*
	 * HashMap<String, String> currentdata=new HashMap<String,String>(); for(int
	 * j=0;j<currentRow.getPhysicalNumberOfCells();j++) {
	 * 
	 * Cell currentcell=currentRow.getCell(j);
	 * 
	 * 
	 * 
	 * currentdata.put(headrow.getCell(j).getStringCellValue().toString(),
	 * currentcell.getStringCellValue().toString());
	 * 
	 */

	/*
	 * int rowcount= sheetName.getLastRowNum(); System.out.println(rowcount);
	 * 
	 * for(int i=1;i<rowcount;i++) {
	 * 
	 * String data0= sheetName.getRow(i).getCell(1).getStringCellValue().toString();
	 * 
	 * System.out.println(data0); }
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

}



