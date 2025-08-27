package com.TestingPurpose;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.LegacyApplication.ExcelReader.ExcelReader;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.TestBase.TestBase;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TestExcel extends TestBase
{
	
	@Test
	public void TestingExcel() throws IOException {
		
		ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
		int Data=ExcelReader.get_row_count();
		System.out.println("No: of rows the data "+Data);
		
		
	}

}
