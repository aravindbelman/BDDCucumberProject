package com.LegacyApplication.PageMethods;

import java.awt.AWTException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.LegacyApplication.ExcelReader.ExcelReader;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageLocators.SubmissionPageLocators;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

public class SubmissionPageMethods extends TestBase {
	
public static final Logger log=Logger.getLogger(SubmissionPageMethods.class.getName());


public static void search_by_option(String submissionId) throws InterruptedException {

	Select agySubmissionSearchBy = new Select(SubmissionPageLocators.ddl_SearchBy);
	List<WebElement> list = agySubmissionSearchBy.getOptions();
	list.get(1).click();
	SubmissionPageLocators.search.sendKeys(submissionId);
	GenericMethods.click_Element_Using_JS(SubmissionPageLocators.searchbutton);
	WaitMethods.wait_in_seconds(5);
}

public static void view_submission_details() throws AWTException, InterruptedException {

	WaitMethods.wait_for_element_present(SubmissionPageLocators.submissionTableRow);
	GenericMethods.click_Element_Using_JS(SubmissionPageLocators.submissionTableRow);
	WaitMethods.wait_in_seconds(2);
	GenericMethods.click_Element_Using_JS(SubmissionPageLocators.selectFrmCtextMenu);
	WaitMethods.wait_in_seconds(5);
	

	// driver.findElement(AgySubmissionpageLocators.btn_General_Liability).click();
}

public static void verify_submission_details_of_application_info() throws IOException, InterruptedException {

	ExcelReader.set_excel_file(Locations.testDataFilePath, "Applicant_Information");
	
	GenericMethods.click_Element_Using_JS(SubmissionPageLocators.btn_General_Liability);

	Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.txtbox_SubmissionType),
			ExcelReader.get_row_data_from_col("Submission_Type", 2));
	Assert.assertEquals(GenericMethods.getTextfmElem(SubmissionPageLocators.txtbox_ApplicantName),
			ExcelReader.get_row_data_from_col("ApplicantName", 2));
	Assert.assertEquals(GenericMethods.getTextfmElem(SubmissionPageLocators.txtbox_DBA),
			ExcelReader.get_row_data_from_col("DBAName", 2));
	// Assert.assertEquals(Common.getTextfmElem(AgySubmissionpageLocators.txtbox_ProposedEffectiveDate),
	// ExcelReader.getCellData(1, 4));
	Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.txtbox_State),
			ExcelReader.get_row_data_from_col("State", 2));
	Assert.assertEquals(GenericMethods.getTextfmElem(SubmissionPageLocators.txtbox_ZipCodeGL),
			ExcelReader.get_row_data_from_col("ZipCode", 2));
	Assert.assertEquals(GenericMethods.getTextfmElem(SubmissionPageLocators.lbl_terrByZIP),
			ExcelReader.get_row_data_from_col("Territory", 2));
	Assert.assertEquals(GenericMethods.getTextfmElem(SubmissionPageLocators.txt_LicenseNumber),
			ExcelReader.get_row_data_from_col("License Number", 2));
	Assert.assertEquals(GenericMethods.is_chekbox_selected(SubmissionPageLocators.chkbox_NoLicenseNeeded),
			ExcelReader.get_row_data_from_col("LicenseNeeded", 2));
	/// System.out.println("Data Matched Successfully !!!");
	log.debug("Data Matched Successfully");
	log.info("Matched successfully");

}

public static void verify_submission_detailsof_GL_RC() throws IOException, InterruptedException {

	ExcelReader.set_excel_file(Locations.testDataFilePath, "General_Liability_RC");

	// Limits of Insurance Deductible Owners - Active in Field Part Time Employees
	// Full Time Employees Total Employee Payroll - Exclude payroll of owners,
	// officers, partners and clerical Casual laborers, leased employees, and labor
	// pool personnel Total Payroll "
	// Classification " Payroll Assigned Subcontracting Costs Annual Gross Receipts
	// "Applicant’s Business Experience /Insurance History
	// "
	
	GenericMethods.click_Element_Using_JS(SubmissionPageLocators.btn_General_Liability);

	Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.ddl_SearchByLimitsofInsurance),
			ExcelReader.get_row_data_from_col("Limits of Insurance", 2));
	Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.ddl_Deductible),
			ExcelReader.get_row_data_from_col("Deductible", 2));
	Assert.assertEquals(GenericMethods.getTextfmElem(SubmissionPageLocators.txt_OwnersActiveinField),
			ExcelReader.get_row_data_from_col("Owners - Active in Field", 2));
	Assert.assertEquals(GenericMethods.getTextfmElem(SubmissionPageLocators.tex_part_timeEmp),
			ExcelReader.get_row_data_from_col("Part Time Employees", 2));

	Assert.assertEquals(GenericMethods.getTextfmElem(SubmissionPageLocators.tex_pull_timeEmp),
			ExcelReader.get_row_data_from_col("Full Time Employees", 2));
	
	Assert.assertEquals(GenericMethods.getTextfmElem(SubmissionPageLocators.tex_total_payrole),
			ExcelReader.get_row_data_from_col("Employees Payroll", 2));
	
	Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.ddl_SearchByLimitsofInsurance),
			ExcelReader.get_row_data_from_col("Limits of Insurance", 2));
	Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.ddl_SearchByLimitsofInsurance),
			ExcelReader.get_row_data_from_col("Limits of Insurance", 2));
	Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.ddl_SearchByLimitsofInsurance),
			ExcelReader.get_row_data_from_col("Limits of Insurance", 2));
	Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.ddl_SearchByLimitsofInsurance),
			ExcelReader.get_row_data_from_col("Limits of Insurance", 2));
	Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.ddl_SearchByLimitsofInsurance),
			ExcelReader.get_row_data_from_col("Limits of Insurance", 2));
	Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.ddl_SearchByLimitsofInsurance),
			ExcelReader.get_row_data_from_col("Limits of Insurance", 2));
	Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.ddl_SearchByLimitsofInsurance),
			ExcelReader.get_row_data_from_col("Limits of Insurance", 2));
	Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.ddl_SearchByLimitsofInsurance),
			ExcelReader.get_row_data_from_col("Limits of Insurance", 2));
	Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.ddl_SearchByLimitsofInsurance),
			ExcelReader.get_row_data_from_col("Limits of Insurance", 2));
	Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.ddl_SearchByLimitsofInsurance),
			ExcelReader.get_row_data_from_col("Limits of Insurance", 2));
	Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.ddl_SearchByLimitsofInsurance),
			ExcelReader.get_row_data_from_col("Limits of Insurance", 2));
	
	log.info("Matched successfully");

}

public static void printing_headertabs() throws AWTException

{
	/*List<WebElement> tabheader = driver.findElements(SubmissionPageLocators.tab_Headers);
	List<WebElement> error1 = driver.findElements(SubmissionPageLocators.tab_ErrorHeaders1);*/

	System.out.println(SubmissionPageLocators.tab_Headers.size());

	LinkedHashMap<String, String> Val = new LinkedHashMap<String, String>();
	for (int i = 0; i <= SubmissionPageLocators.tab_Headers.size() - 1; i++) {

		String data0 = SubmissionPageLocators.tab_Headers.get(i).getAttribute("value").toString();
		String data1 = SubmissionPageLocators.tab_Headers.get(i).getAttribute("status").toString();
		Val.put(data0, data1);

	}
	System.out.println(Val);
	if (SubmissionPageLocators.tab_ErrorHeaders1.size() > 0) {
		//int errorcount=error1.size()/2;
		System.out.println(SubmissionPageLocators.tab_ErrorHeaders1.size() / 2 + "  Error Exist");
		System.out.println(GenericMethods.getMapValue(Val, "2") + " info has some errors");

		
	}else {
		System.out.println("All Data filled successfully");
	}

}

   public static void print_err_msg() throws InterruptedException
   {
	   WaitMethods.wait_for_element_present(SubmissionPageLocators.price_inditcator_errormsg);
	   WaitMethods.wait_in_seconds(3);
	   log.info("The error Message for Price Indicator is "+SubmissionPageLocators.price_inditcator_errormsg.getClass().toGenericString());
	   
	   WaitMethods.wait_for_element_present(SubmissionPageLocators.eligibility_errormsg);
	   WaitMethods.wait_in_seconds(3);
	   log.info("The error Message for Eligibility is "+SubmissionPageLocators.eligibility_errormsg.getAttribute("innerHTML"));
	   
	   WaitMethods.wait_for_element_present(SubmissionPageLocators.application_errormsg);
	   WaitMethods.wait_in_seconds(3);
	   log.info("The error Message for Application is "+SubmissionPageLocators.application_errormsg.getText());
	   
   }

public static void verify_optional_coverage() throws IOException
{
	ExcelReader.set_excel_file(Locations.testDataFilePath, "Optional_Coverages");
	
	GenericMethods.click_Element_Using_JS(SubmissionPageLocators.btn_General_Liability);
	
	Assert.assertEquals(GenericMethods.is_chekbox_selected(SubmissionPageLocators.asr_endorsement),
			ExcelReader.get_row_data_from_col("ASR Endorsement", 1));
	
    Assert.assertEquals(GenericMethods.is_chekbox_selected(SubmissionPageLocators.per_project_aggregate),
			ExcelReader.get_row_data_from_col("per-project-aggregate", 1));
	
    Assert.assertEquals(GenericMethods.is_chekbox_selected(SubmissionPageLocators.employee_benefits),
			ExcelReader.get_row_data_from_col("employee-bebefits", 1));
    
    Assert.assertEquals(GenericMethods.is_chekbox_selected(SubmissionPageLocators.action_over),
			ExcelReader.get_row_data_from_col("action-over", 1));
    
    Assert.assertEquals(GenericMethods.is_chekbox_selected(SubmissionPageLocators.classification_limitation),
			ExcelReader.get_row_data_from_col("classification-limitation", 1));
    
    Assert.assertEquals(GenericMethods.is_chekbox_selected(SubmissionPageLocators.prior_completed),
			ExcelReader.get_row_data_from_col("prior-completed", 1));
    
    Assert.assertEquals(GenericMethods.is_chekbox_selected(SubmissionPageLocators.subsidence_exclusion),
			ExcelReader.get_row_data_from_col("subsidence-exclusion", 1));
    
    Assert.assertEquals(GenericMethods.is_chekbox_selected(SubmissionPageLocators.insured_endorsement),
			ExcelReader.get_row_data_from_col("insured-endorsement", 1));
	
    Assert.assertEquals(GenericMethods.is_chekbox_selected(SubmissionPageLocators.workmanship_coverage),
			ExcelReader.get_row_data_from_col("workmanship-coverage", 1));
    
    Assert.assertEquals(GenericMethods.is_chekbox_selected(SubmissionPageLocators.small_equipment_coverage),
			ExcelReader.get_row_data_from_col("small-equipment-coverage", 1));
    
    Assert.assertEquals(GenericMethods.is_chekbox_selected(SubmissionPageLocators.available_policy_credits),
			ExcelReader.get_row_data_from_col("available-policy-credits", 1));
    
    log.info("<=====================Data Matched Successfully=====================> ");	
}



//======================>Price Indicator Methods<===========================================

public static void verify_price_indicator_elements() throws IOException
{
	ExcelReader.set_excel_file(Locations.testDataFilePath, "Price_Indication");
	
	GenericMethods.click_Element_Using_JS(SubmissionPageLocators.btn_General_Liability);
	SubmissionPageLocators.price_indicator_tab.click();
	
	Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.manifest_without_sunset_yes),
			ExcelReader.get_row_data_from_col("Manifest Without Sunset Yes", 1));
	
	Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.manifest_without_sunset_no),
			ExcelReader.get_row_data_from_col("Manifest Without Sunset No", 1));
	
	Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.occurence_form_with_sunset_yes),
			ExcelReader.get_row_data_from_col("Occurrence Form With Sunset Yes", 1));
	
	Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.occurence_form_with_sunset_no),
			ExcelReader.get_row_data_from_col("Occurrence Form With Sunset No", 1));
	
	Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.occurence_form_without_sunset_yes),
			ExcelReader.get_row_data_from_col("Occurrence Form Without Sunset Yes", 1));
	
	Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.occurence_form_without_sunset_no),
			ExcelReader.get_row_data_from_col("Occurrence Form Without Sunset No", 1));
	
	Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.pi_select_limit),
			ExcelReader.get_row_data_from_col("PI Select Limit", 1));
	
	Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.pi_deductible),
			ExcelReader.get_row_data_from_col("PI Deductible", 1));
	
	Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.terrorism_accept_radio),
			ExcelReader.get_row_data_from_col("Terrorism Accept Radio", 1));
	
	Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.terrorism_decline_radio),
			ExcelReader.get_row_data_from_col("Terrorism Decline Radio", 1));

	log.info("<=====================Data Matched Successfully=====================> ");	
}

//======================>Eligibility Page Methods (Common Eligibility Questions)<===========================================

      public static void verify_common_eligibility_elements() throws IOException
      {
    	  
      ExcelReader.set_excel_file(Locations.testDataFilePath, "Common_Eligibility");
      
      SubmissionPageLocators.eligibility_page.click();
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn1),
  			ExcelReader.get_row_data_from_col("Radio_Btn_1", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn2),
    			ExcelReader.get_row_data_from_col("Radio_Btn_2", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn3),
  			ExcelReader.get_row_data_from_col("Radio_Btn_3", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn4),
    			ExcelReader.get_row_data_from_col("Radio_Btn_4", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn5),
  			ExcelReader.get_row_data_from_col("Radio_Btn_5", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn6),
  			ExcelReader.get_row_data_from_col("Radio_Btn_6", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn7),
    			ExcelReader.get_row_data_from_col("Radio_Btn_7", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn8),
    			ExcelReader.get_row_data_from_col("Radio_Btn_8", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn9),
    			ExcelReader.get_row_data_from_col("Radio_Btn_9", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn10),
    			ExcelReader.get_row_data_from_col("Radio_Btn_10", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn11),
    			ExcelReader.get_row_data_from_col("Radio_Btn_11", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn12),
    			ExcelReader.get_row_data_from_col("Radio_Btn_12", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn13),
    			ExcelReader.get_row_data_from_col("Radio_Btn_13", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn14),
    			ExcelReader.get_row_data_from_col("Radio_Btn_14", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn15),
    			ExcelReader.get_row_data_from_col("Radio_Btn_15", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn16),
    			ExcelReader.get_row_data_from_col("Radio_Btn_16", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn17),
    			ExcelReader.get_row_data_from_col("Radio_Btn_17", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn18),
    			ExcelReader.get_row_data_from_col("Radio_Btn_18", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn19),
    			ExcelReader.get_row_data_from_col("Radio_Btn_19", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn20),
    			ExcelReader.get_row_data_from_col("Radio_Btn_20", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn21),
    			ExcelReader.get_row_data_from_col("Radio_Btn_21", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn22),
    			ExcelReader.get_row_data_from_col("Radio_Btn_22", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn23),
    			ExcelReader.get_row_data_from_col("Radio_Btn_23", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn24),
    			ExcelReader.get_row_data_from_col("Radio_Btn_24", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn25),
  			ExcelReader.get_row_data_from_col("Radio_Btn_25", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn26),
  			ExcelReader.get_row_data_from_col("Radio_Btn_26", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn27),
  			ExcelReader.get_row_data_from_col("Radio_Btn_27", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn28),
  			ExcelReader.get_row_data_from_col("Radio_Btn_28", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn29),
  			ExcelReader.get_row_data_from_col("Radio_Btn_29", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn30),
  			ExcelReader.get_row_data_from_col("Radio_Btn_30", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn31),
  			ExcelReader.get_row_data_from_col("Radio_Btn_31", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn32),
  			ExcelReader.get_row_data_from_col("Radio_Btn_32", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn33),
  			ExcelReader.get_row_data_from_col("Radio_Btn_33", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn34),
  			ExcelReader.get_row_data_from_col("Radio_Btn_34", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn35),
  			ExcelReader.get_row_data_from_col("Radio_Btn_35", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn36),
    			ExcelReader.get_row_data_from_col("Radio_Btn_36", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn37),
    			ExcelReader.get_row_data_from_col("Radio_Btn_37", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn38),
    			ExcelReader.get_row_data_from_col("Radio_Btn_38", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn39),
    			ExcelReader.get_row_data_from_col("Radio_Btn_39", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn40),
    			ExcelReader.get_row_data_from_col("Radio_Btn_40", 1));
      
      log.info("<=====================Data Matched Successfully=====================> ");
      
      }
      
    //======================>Eligibility Page Methods (Common Eligibility Questions)<===========================================

      public static void verify_specific_eligibility_elements() throws IOException
      {
    	  
      ExcelReader.set_excel_file(Locations.testDataFilePath, "Specific_Eligibility");
      
      SubmissionPageLocators.eligibility_page.click();
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn41),
  			ExcelReader.get_row_data_from_col("Radio_Btn_41", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn42),
    			ExcelReader.get_row_data_from_col("Radio_Btn_42", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn43),
    			ExcelReader.get_row_data_from_col("Radio_Btn_43", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn44),
    			ExcelReader.get_row_data_from_col("Radio_Btn_44", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn45),
    			ExcelReader.get_row_data_from_col("Radio_Btn_45", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn46),
    			ExcelReader.get_row_data_from_col("Radio_Btn_46", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn47),
    			ExcelReader.get_row_data_from_col("Radio_Btn_47", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn48),
    			ExcelReader.get_row_data_from_col("Radio_Btn_48", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn49),
    			ExcelReader.get_row_data_from_col("Radio_Btn_49", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn50),
    			ExcelReader.get_row_data_from_col("Radio_Btn_50", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn51),
  			ExcelReader.get_row_data_from_col("Radio_Btn_51", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn52),
  			ExcelReader.get_row_data_from_col("Radio_Btn_52", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn53),
  			ExcelReader.get_row_data_from_col("Radio_Btn_53", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn54),
  			ExcelReader.get_row_data_from_col("Radio_Btn_54", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn55),
  			ExcelReader.get_row_data_from_col("Radio_Btn_55", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn56),
  			ExcelReader.get_row_data_from_col("Radio_Btn_56", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn57),
  			ExcelReader.get_row_data_from_col("Radio_Btn_57", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn58),
  			ExcelReader.get_row_data_from_col("Radio_Btn_58", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn59),
  			ExcelReader.get_row_data_from_col("Radio_Btn_59", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn60),
  			ExcelReader.get_row_data_from_col("Radio_Btn_60", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn61),
    			ExcelReader.get_row_data_from_col("Radio_Btn_61", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn62),
    			ExcelReader.get_row_data_from_col("Radio_Btn_62", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn63),
    			ExcelReader.get_row_data_from_col("Radio_Btn_63", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn64),
    			ExcelReader.get_row_data_from_col("Radio_Btn_64", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn65),
    			ExcelReader.get_row_data_from_col("Radio_Btn_65", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn66),
    			ExcelReader.get_row_data_from_col("Radio_Btn_66", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn67),
    			ExcelReader.get_row_data_from_col("Radio_Btn_67", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn68),
    			ExcelReader.get_row_data_from_col("Radio_Btn_68", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn69),
    			ExcelReader.get_row_data_from_col("Radio_Btn_69", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn70),
    			ExcelReader.get_row_data_from_col("Radio_Btn_70", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn71),
  			ExcelReader.get_row_data_from_col("Radio_Btn_71", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn72),
  			ExcelReader.get_row_data_from_col("Radio_Btn_72", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn73),
  			ExcelReader.get_row_data_from_col("Radio_Btn_73", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn74),
  			ExcelReader.get_row_data_from_col("Radio_Btn_74", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn75),
  			ExcelReader.get_row_data_from_col("Radio_Btn_75", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn76),
  			ExcelReader.get_row_data_from_col("Radio_Btn_76", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn77),
  			ExcelReader.get_row_data_from_col("Radio_Btn_77", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn78),
  			ExcelReader.get_row_data_from_col("Radio_Btn_78", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn79),
  			ExcelReader.get_row_data_from_col("Radio_Btn_79", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn80),
  			ExcelReader.get_row_data_from_col("Radio_Btn_80", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn81),
  			ExcelReader.get_row_data_from_col("Radio_Btn_81", 1));
      
      Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn82),
  			ExcelReader.get_row_data_from_col("Radio_Btn_82", 1));
      
      log.info("<=====================Data Matched Successfully=====================> ");
      }
      
      //======================> Application Page Methods<===========================================
      
      public static void verify_application_page_info() throws IOException
      
      {
    	  
      ExcelReader.set_excel_file(Locations.testDataFilePath, "Application_Data");
      
      SubmissionPageLocators.application_tab.click();
      
      Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.applicant_name),
  			ExcelReader.get_row_data_from_col("Applicant Name", 1));
      
      Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.dba),
    			ExcelReader.get_row_data_from_col("DBA", 1));
      
      Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.pri_street_address),
  			ExcelReader.get_row_data_from_col("Street Address", 1));
      
      Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.primary_city),
    			ExcelReader.get_row_data_from_col("City", 1));
      
      Assert.assertEquals(GenericMethods.getTextfmElem(SubmissionPageLocators.pri_state_name),
  			ExcelReader.get_row_data_from_col("State Name", 1));
      
      Assert.assertEquals(GenericMethods.getTextfmElem(SubmissionPageLocators.pri_zip_code),
    			ExcelReader.get_row_data_from_col("Pri Zip Code", 1));
      
      Assert.assertEquals(GenericMethods.is_chekbox_selected(SubmissionPageLocators.same_as_primary_checkbox),
    			ExcelReader.get_row_data_from_col("Primary Premise Chkbox", 1));
      
      Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.mailing_street_address),
  			ExcelReader.get_row_data_from_col("Street Address", 1));
      
      Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.mailing_city),
    			ExcelReader.get_row_data_from_col("City", 1));
      
      Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.mailing_state),
  			ExcelReader.get_row_data_from_col("State", 1));
      
      Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.mailing_zip_code),
  			ExcelReader.get_row_data_from_col("Zip Code", 1));
      
      Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.contact_name),
    			ExcelReader.get_row_data_from_col("Contact Name", 1));
      
      Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.signing_party),
  			ExcelReader.get_row_data_from_col("Application Sign", 1));
      
      Assert.assertEquals(GenericMethods.is_chekbox_selected(SubmissionPageLocators.spanish_speaking),
  			ExcelReader.get_row_data_from_col("Spanish Check Box", 1));
      
      Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.office_phno1),
    			ExcelReader.get_row_data_from_col("Office_Ph_No_Box1", 1));
      
      Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.office_phno2),
  			ExcelReader.get_row_data_from_col("Office_Ph_No_Box2", 1));
      
      Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.office_phno3),
    			ExcelReader.get_row_data_from_col("Office_Ph_No_Box3", 1));
      
      Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.cell_phno1),
  			ExcelReader.get_row_data_from_col("Cell_Ph_No_Box1", 1));
      
      Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.cell_phno2),
    			ExcelReader.get_row_data_from_col("Cell_Ph_No_Box2", 1));
      
      Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.cell_phno3),
  			ExcelReader.get_row_data_from_col("Cell_Ph_No_Box3", 1));
      
      Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.email_address),
    			ExcelReader.get_row_data_from_col("Email Address", 1));
      
      Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.business_type),
  			ExcelReader.get_row_data_from_col("Type of Business", 1));
      
      Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.theft_protection),
  			ExcelReader.get_row_data_from_col("Theft Protection", 1));
      
      Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.years_in_business),
    			ExcelReader.get_row_data_from_col("Years in business", 1));
      
      Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.construction_experience),
  			ExcelReader.get_row_data_from_col("Construction Experience", 1));
      
      Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.annual_gross_receipts),
  			ExcelReader.get_row_data_from_col("Gross Receipts", 1));
      
      Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.total_payroll),
    			ExcelReader.get_row_data_from_col("Total Payroll", 1));
      
      Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.sub_contractor_costs),
  			ExcelReader.get_row_data_from_col("Sub Contractor Costs", 1));
      
      /*Assert.assertEquals(get_text(SubmissionPageLocators.requested_eff_date),
    			ExcelReader.get_row_data_from_col("Effective Date", 1));*/ 
      
      Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.current_gl_policy),
  			ExcelReader.get_row_data_from_col("Gl Ploicy", 1));
      
      Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.carrier_name),
    			ExcelReader.get_row_data_from_col("Carrier Name", 1));
      
      Assert.assertEquals(GenericMethods.is_chekbox_selected(SubmissionPageLocators.no_insurancecoverage_chkbx),
  			ExcelReader.get_row_data_from_col("No Insurance Coverage", 1));
      
      Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.gl_noof_losses),
    			ExcelReader.get_row_data_from_col("Number of Losses", 1));
      
      Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.amount_of_losses),
  			ExcelReader.get_row_data_from_col("Amount of Losses", 1));
      
      Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.resedential_strct_type),
    			ExcelReader.get_row_data_from_col("Residential", 1));
      
      Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.industrial_strct_type),
  			ExcelReader.get_row_data_from_col("Industrial", 1));
      
      Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.commercial_strct_type),
    			ExcelReader.get_row_data_from_col("Commercial", 1));
      
      Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.new_construction_type),
  			ExcelReader.get_row_data_from_col("New Construction", 1));
      
      Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.service_and_repair_type),
    			ExcelReader.get_row_data_from_col("Service and Repair", 1));
      
      Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.next_12months_val),
  			ExcelReader.get_row_data_from_col("Next 12 Months", 1));
      
      Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.last_12months_txtfield),
  			ExcelReader.get_row_data_from_col("Last 12 Months", 1));
      
      Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.second_year_prior),
    			ExcelReader.get_row_data_from_col("2nd year prior", 1));
      
      Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.third_year_prior),
  			ExcelReader.get_row_data_from_col("3rd year prior", 1));
      
      Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.description_of_operations),
    			ExcelReader.get_row_data_from_col("Desc of Operations", 1));
      
      Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.submit_button),
  			ExcelReader.get_row_data_from_col("Submit Button", 1));
      
      Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.previous_button),
    			ExcelReader.get_row_data_from_col("Prev Button", 1));
        
      
      log.info("====================> Data Matched Successfully<========================");
      
      }
      
    //  ====================================> Verify Submission details Information <==================================== 
      
      public static void verify_unsold_submission_details_info() throws IOException
      {
    	  ExcelReader.set_excel_file(Locations.testDataFilePath, "Submission_Data");
    	  
    	  Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.submission_applicant_name),
    	  			ExcelReader.get_row_data_from_col("Applicant_Name", 1));  
    	  
    	  Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.dba_info),
  	  			ExcelReader.get_row_data_from_col("DBA", 1)); 
    	  
    	  Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.program_name),
    	  			ExcelReader.get_row_data_from_col("Program", 1)); 
    	  
    	  Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.submission_id),
  	  			ExcelReader.get_row_data_from_col("Submission_Id", 1)); 
    	  
    	  Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.application_status),
    	  			ExcelReader.get_row_data_from_col("Status", 1));
    	  
    	  Assert.assertEquals(GenericMethods.is_attribtue_present(SubmissionPageLocators.policy_no, "innerHTML"),
  	  			ExcelReader.get_row_data_from_col("Policy_No", 1));
    	  
    	  Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.submission_contact_name),
    	  			ExcelReader.get_row_data_from_col("Contact_Name", 1));
    	  
    	  Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.underwriter),
  	  			ExcelReader.get_row_data_from_col("Underwriter", 1));
    	  
    	  
    	  
    	  log.info("<=====================Data Matched Successfully=====================> ");  
    	  
      }
      
      public static void verify_sold_submission_details_info() throws IOException
      {
    	  ExcelReader.set_excel_file(Locations.testDataFilePath, "Submission_Data");
    	    
    	  Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.submission_applicant_name),
    	  			ExcelReader.get_row_data_from_col("Applicant_Name", 2));  
    	  
    	  Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.dba_info),
  	  			ExcelReader.get_row_data_from_col("DBA", 2)); 
    	  
    	  Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.program_name),
    	  			ExcelReader.get_row_data_from_col("Program", 2)); 
    	  
    	  Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.submission_id),
  	  			ExcelReader.get_row_data_from_col("Submission_Id", 2)); 
    	  
    	  Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.application_status),
    	  			ExcelReader.get_row_data_from_col("Status", 2));
    	  
    	  Assert.assertEquals(GenericMethods.is_attribtue_present(SubmissionPageLocators.policy_no, "innerHTML"),
  	  			ExcelReader.get_row_data_from_col("Policy_No", 2));
    	  
    	  Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.submission_contact_name),
    	  			ExcelReader.get_row_data_from_col("Contact_Name", 2));
    	  
    	  Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.underwriter),
  	  			ExcelReader.get_row_data_from_col("Underwriter", 2));
    	  
    	  
    	  
    	  log.info("<=====================Data Matched Successfully=====================> ");  
    	  
      }
      
//======================>Method to review submission information<===========================================
     
  public static void verify_submisson_info() throws IOException, InterruptedException
  {
	    WaitMethods.wait_for_element_present(SubmissionPageLocators.submissionTableRow);
		GenericMethods.click_Element_Using_JS(SubmissionPageLocators.submissionTableRow);
		WaitMethods.wait_in_seconds(2);
		GenericMethods.click_Element_Using_JS(SubmissionPageLocators.select_review_submission);
		WaitMethods.wait_in_seconds(5);
	    ExcelReader.set_excel_file(Locations.testDataFilePath, "Submission_Data");
	  
  }
  
}
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
   

