package com.LegacyApplication.PageMethods;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.LegacyApplication.ExcelReader.ExcelReader;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageLocators.AdminSubmissionPageLocators;
import com.LegacyApplication.PageLocators.GeneralLiabilityPageLocators;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

public class AdminSubmissionPageMethods extends TestBase {
	
	public static final Logger log=Logger.getLogger(AdminSubmissionPageMethods.class.getName());


	public static void search_submissionid(String submissionId, int row_num) throws InterruptedException, IOException {
		
		ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
		WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.selectBy_drpDwn);
		GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.selectBy_drpDwn, "visibletext", OR.getProperty("selectby"));
		WaitMethods.wait_in_seconds(5);
		AdminSubmissionPageLocators.submission_id_searchfield.sendKeys(ExcelReader.get_row_data_from_col(submissionId, row_num));
		WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
		GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
		WaitMethods.wait_in_seconds(5);
	}
	
	public static void view_submission_details() throws AWTException, InterruptedException {

		WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_table_row);
		GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
		WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.rating_ws_link);
		GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.rating_ws_link);
		WaitMethods.wait_in_seconds(5);
		
	}
	
	public static void verify_QAArating_info(int row_num) throws AWTException, InterruptedException, IOException
	{
		view_submission_details();
		GenericMethods.navigate_to_next_window();
		AdminSubmissionPageLocators.cbFullWithoutSunset_chkbx.click();
		GenericMethods.scroll_down_to_element(AdminSubmissionPageLocators.lbl_withoutsunset_perprojagg);
		ExcelReader.set_excel_file(Locations.testDataFilePath, "QAA_Rating_Info");
		Assert.assertEquals(GenericMethods.get_text(AdminSubmissionPageLocators.verify_submission_id),
  	  			ExcelReader.get_row_data_from_col("Submission Id", row_num));
		Assert.assertEquals(GenericMethods.get_text(AdminSubmissionPageLocators.lbl_withoutsunset_totalgl),
  	  			ExcelReader.get_row_data_from_col("TotalGlPremium", row_num));
		Assert.assertEquals(GenericMethods.get_text(AdminSubmissionPageLocators.lbl_withoutsunset_empbenefits),
  	  			ExcelReader.get_row_data_from_col("Employee Benefits", row_num));
		Assert.assertEquals(GenericMethods.get_text(AdminSubmissionPageLocators.lbl_withoutsunset_perprojagg),
  	  			ExcelReader.get_row_data_from_col("PerProjAggregate", row_num));
		Assert.assertEquals(GenericMethods.get_text(AdminSubmissionPageLocators.lbl_withoutsunset_earthmovexclusion),
  	  			ExcelReader.get_row_data_from_col("Earth Movement Exclusion", row_num));
		Assert.assertEquals(GenericMethods.get_text(AdminSubmissionPageLocators.lbl_withoutsunset_stopgap),
  	  			ExcelReader.get_row_data_from_col("Stop Gap", row_num));
		Assert.assertEquals(GenericMethods.get_text(AdminSubmissionPageLocators.lbl_withoutsunset_additionalinsured),
  	  			ExcelReader.get_row_data_from_col("Additional Insured", row_num));
		Assert.assertEquals(GenericMethods.get_text(AdminSubmissionPageLocators.lbl_withoutsunset_workmanship),
  	  			ExcelReader.get_row_data_from_col("Workmanship Coverage", row_num));
		Assert.assertEquals(GenericMethods.get_text(AdminSubmissionPageLocators.lbl_withoutsunset_extendedreporting),
  	  			ExcelReader.get_row_data_from_col("Extended Reporting Form", row_num));
		Assert.assertEquals(GenericMethods.get_text(AdminSubmissionPageLocators.lbl_withoutsunset_total_all_glprem),
  	  			ExcelReader.get_row_data_from_col("Sub Total GlPremium", row_num));
		Assert.assertEquals(GenericMethods.get_text(AdminSubmissionPageLocators.lbl_withoutsunset_terrorismprem),
  	  			ExcelReader.get_row_data_from_col("Terrorism GL", row_num));
		Assert.assertEquals(GenericMethods.get_text(AdminSubmissionPageLocators.lbl_withoutsunset_glpolicyfee),
  	  			ExcelReader.get_row_data_from_col("Policy Fee", row_num));
		Assert.assertEquals(GenericMethods.get_text(AdminSubmissionPageLocators.lbl_withoutsunset_totalglpolpremium),
  	  			ExcelReader.get_row_data_from_col("Total Gl Policy Premium", row_num));
		Assert.assertEquals(GenericMethods.get_text(AdminSubmissionPageLocators.lbl_withoutsunset_grandtotal),
  	  			ExcelReader.get_row_data_from_col("Grand Total", row_num));
		
		log.info("<=====================Data Matched Successfully=====================> ");  
	}


}
