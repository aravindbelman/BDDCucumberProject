package com.TestingPurpose;

import java.io.IOException;

import org.testng.annotations.Test;

import com.LegacyApplication.ExcelReader.ExcelReader;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.TestBase.TestBase;


public class TestExcel extends TestBase
{
	
	@Test
	public void TestingExcel() throws IOException {
		
	    ExcelReader.set_excel_file(Locations.testDataFilePath, "Applicant_Information");
		String Data=ExcelReader.get_cell_data(1, 3);
		System.out.println(Data);
		
		
	}

}
