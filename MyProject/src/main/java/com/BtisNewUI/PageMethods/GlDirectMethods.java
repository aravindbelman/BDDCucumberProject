package com.BtisNewUI.PageMethods;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
//import org.apache.poi.ss.formula.PlainCellCache.Loc;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.server.handler.mobile.GetNetworkConnection;

import com.BtisNewUI.Locators.GlDirectLocators;
import com.LegacyApplication.ExcelReader.ExcelReader;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

public class GlDirectMethods extends TestBase {
	
	public static final Logger log=Logger.getLogger(GlDirectMethods.class.getName());
	public static JavascriptExecutor js;
	
	/*
	 * Purpose: This method is used to get the price
	 * @param integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void get_your_price(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{   
		ExcelReader.set_excel_file(Locations.GlDirect_dataFilePath,"Get_Your_Price");
		//ExcelReader.set_cell_data("Get_Your_Price",row_num,qaa_submission_id);
		
		GenericMethods.click_Element_Using_JS(GlDirectLocators.GLdirect_quoteNowBtn);
		GenericMethods.enter_text(GlDirectLocators.GLdirect_zipCode,ExcelReader.get_row_data_from_col("Zip_Code", row_num), "Zip Code");
		WaitMethods.wait_in_seconds(2);
		GenericMethods.select_from_dropdown(GlDirectLocators.Gldirect_classificationDrpDwn, "visibletext", ExcelReader.get_row_data_from_col("Contractor_Type", row_num));
		GenericMethods.select_from_dropdown(GlDirectLocators.GLdirect_businessExperiencedrpDwn, "visibletext", ExcelReader.get_row_data_from_col("Business_Experience", row_num));
		GenericMethods.enter_text(GlDirectLocators.GLdirect_activeOwners_textField,ExcelReader.get_row_data_from_col("Owners-Active", row_num), "Owners Active in Field");
		//GenericMethods.enter_text(GlDirectLocators.GLdirect_annualEmployeePayrl_textField, ExcelReader.get_row_data_from_col("Annual_Employee_Payroll", row_num),"Annual Employee Payroll");
		GenericMethods.enter_text(GlDirectLocators.GLdirect_annualGrossReceipts_textField, ExcelReader.get_row_data_from_col("Annual_Gross_Receipts", row_num),"Annual Gross Receipts");
		//GenericMethods.enter_text(GlDirectLocators.GLdirect_annualSubcontractingCosts_textField, ExcelReader.get_row_data_from_col("Annual_Subcontracting_Costs",row_num),"Annual Subcontracting Costs");
		//GenericMethods.click_Element_Using_JS(GlDirectLocators.haveEmployees_No_Btn);
		//GenericMethods.click_Element_Using_JS(GlDirectLocators.subcontractors_No_Btn);
		WaitMethods.wait_in_seconds(2);
		GenericMethods.is_element_present(GlDirectLocators.GLdirect_getYourPrice_btn);
		GenericMethods.click_Element_Using_JS(GlDirectLocators.GLdirect_getYourPrice_btn);
		WaitMethods.wait_in_seconds(5);
						
	}
	
	public static void pre_qualifyRate(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{ 
		ExcelReader.set_excel_file(Locations.GlDirect_dataFilePath,"Get_Your_Price");
		String Pre_Qualify_Rate=GenericMethods.get_text(GlDirectLocators.preQualifyRate);	
		ExcelReader.set_cell_data("PreQualify_Rate",row_num,Pre_Qualify_Rate);
		
		ExcelReader.set_excel_file(Locations.GlDirect_dataFilePath,"Coverage_Options");
		String Pre_Qualify_Rate2=GenericMethods.get_text(GlDirectLocators.preQualifyRate);	
		ExcelReader.set_cell_data("PreQualify_Rate",row_num,Pre_Qualify_Rate2);
		
		GenericMethods.click_Element_Using_JS(GlDirectLocators.GLdirect_buyNow_btn);
		WaitMethods.wait_in_seconds(5);
	}
	
	public static void about_you(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{   
		ExcelReader.set_excel_file(Locations.GlDirect_dataFilePath,"About_You");
		WaitMethods.wait_in_seconds(2);
		GenericMethods.enter_text(GlDirectLocators.GLdirect_firstName_textField,ExcelReader.get_row_data_from_col("First_Name", row_num), "First Name");
		GenericMethods.enter_text(GlDirectLocators.GLdirect_lastName_textField,ExcelReader.get_row_data_from_col("Last_Name", row_num), "Last Name");
		GenericMethods.enter_text(GlDirectLocators.GLdirect_emailAddress_textField,ExcelReader.get_row_data_from_col("Email_Address", row_num), "Email Address");
		GenericMethods.enter_text(GlDirectLocators.GLdirect_phoneNumber_textField,ExcelReader.get_row_data_from_col("Phone_Number", row_num), "Phone Number");
		GenericMethods.enter_text(GlDirectLocators.GLdirect_physicalAddress_textField,ExcelReader.get_row_data_from_col("Street_Address", row_num), "Street Address");
		GenericMethods.enter_text(GlDirectLocators.GLdirect_physicalAddress2_textField,ExcelReader.get_row_data_from_col("Apt_Building", row_num), "Apt Building");
		GenericMethods.enter_text(GlDirectLocators.GLdirect_physicalCity_textField,ExcelReader.get_row_data_from_col("City", row_num), "City");
		GenericMethods.click_Element_Using_JS(GlDirectLocators.GLdirect_sameAsPhysicalAddress_chkBox);
		GenericMethods.click_Element_Using_JS(GlDirectLocators.GLdirect_saveAndContinue_btn);
		
	}
	
	public static void business_info(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{   
		ExcelReader.set_excel_file(Locations.GlDirect_dataFilePath,"Business_Info");WaitMethods.wait_in_seconds(2);
		GenericMethods.select_from_dropdown(GlDirectLocators.GLdirect_relationtoBusiness_drpdwn, "value", ExcelReader.get_row_data_from_col("Business_realtion", row_num));
		GenericMethods.enter_text(GlDirectLocators.GLdirect_businessName_textField,ExcelReader.get_row_data_from_col("Business_Name", row_num), "Business Name");
		GenericMethods.select_from_dropdown(GlDirectLocators.GLdirect_businessType_drpDwn, "visibletext", ExcelReader.get_row_data_from_col("Business_Type", row_num));
		//GenericMethods.select_from_dropdown(GlDirectLocators.GLdirect_newResidentialStructure_drpDwn, "visibletext", ExcelReader.get_row_data_from_col("work_on_ NewResidentialStructures", row_num));
		//GenericMethods.click_Element_Using_JS(GlDirectLocators.PerformResidentialWork_No_Btn);
		GenericMethods.enter_text(GlDirectLocators.GLdirect_descOfOperations_textArea,ExcelReader.get_row_data_from_col("Describe_your_operations", row_num), "Describe operations");
		GenericMethods.click_Element_Using_JS(GlDirectLocators.GLdirect_businessInfo_saveAndContinue_btn);WaitMethods.wait_in_seconds(2);
	}
	
	public static void insurance_history(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{   
		//GenericMethods.click_Element_Using_JS(GlDirectLocators.InsuranceHistory_No_Btn);
		//ExcelReader.set_excel_file(Locations.GlDirect_dataFilePath,"Insurance_History");
		//WaitMethods.wait_in_seconds(2);
		//GenericMethods.click_Element_Using_JS(GlDirectLocators.no_prior_genral_chkbox);
		//GenericMethods.enter_text(GlDirectLocators.enter_carrierName_txtb,ExcelReader.get_row_data_from_col("Entere_CarrierName", row_num), "Entere CarrierName");
		WaitMethods.wait_in_seconds(2);
		GenericMethods.is_element_present(GlDirectLocators.insuHistory_saveandContinue_btn);
		WaitMethods.wait_in_seconds(2);
		GenericMethods.click_Element_Using_JS(GlDirectLocators.insuHistory_saveandContinue_btn);
	}
	
	public static void classifaction(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{ 
		ExcelReader.set_excel_file(Locations.GlDirect_dataFilePath,"Classifications");
		GenericMethods.enter_text(GlDirectLocators.class1_percentofWork_txtb,ExcelReader.get_row_data_from_col("Percent_OfWork1", row_num), "Percent Of Work1");
		GenericMethods.click_Element_Using_JS(GlDirectLocators.class_saveandContinue_btn);
	}
	
	public static void multi_classifaction(int row_num) throws  IOException, InterruptedException, Exception, AWTException
	{ 
		ExcelReader.set_excel_file(Locations.GlDirect_dataFilePath,"Classifications");
		
		GenericMethods.enter_text(GlDirectLocators.class1_percentofWork_txtb,ExcelReader.get_row_data_from_col("Percent_OfWork1", row_num), "Percent Of Work1");
		
		GenericMethods.click_Element_Using_JS(GlDirectLocators.addAnotherClass_link);
		GenericMethods.select_from_dropdown(GlDirectLocators.addClassifiaction_drpdwn, "visibletext", ExcelReader.get_row_data_from_col("Add_Classifiaction2", row_num));
		GenericMethods.click_Element_Using_JS(GlDirectLocators.add_btn);
		GenericMethods.enter_text(GlDirectLocators.class2_percentofWork_txtb,ExcelReader.get_row_data_from_col("Percent_OfWork2", row_num), "Percent Of Work2");
		
		
		GenericMethods.click_Element_Using_JS(GlDirectLocators.addAnotherClass_link);
		GenericMethods.select_from_dropdown(GlDirectLocators.addClassifiaction_drpdwn, "visibletext", ExcelReader.get_row_data_from_col("Add_Classifiaction3", row_num));
		GenericMethods.click_Element_Using_JS(GlDirectLocators.add_btn);
		GenericMethods.enter_text(GlDirectLocators.class3_percentofWork_txtb,ExcelReader.get_row_data_from_col("Percent_OfWork3", row_num), "Percent Of Work3");
		
		GenericMethods.click_Element_Using_JS(GlDirectLocators.addAnotherClass_link);
		GenericMethods.select_from_dropdown(GlDirectLocators.addClassifiaction_drpdwn, "visibletext", ExcelReader.get_row_data_from_col("Add_Classifiaction4", row_num));
		GenericMethods.click_Element_Using_JS(GlDirectLocators.add_btn);
		GenericMethods.enter_text(GlDirectLocators.class4_percentofWork_txtb,ExcelReader.get_row_data_from_col("Percent_OfWork4", row_num), "Percent Of Work4");
		GenericMethods.click_element_JS(GlDirectLocators.class3_percentofWork_txtb);
		//GenericMethods.press_key_using_robot("enter");
		GenericMethods.click_Element_Using_JS(GlDirectLocators.class_saveandContinue_btn);
	}
	
	public static void eligibilityPage() throws IOException, InterruptedException, Exception, AWTException
	{	
		GenericMethods.press_key_using_robot("end");
		//GenericMethods.click_Element_Using_JS(GlDirectLocators.yes_chkbox);
		//GenericMethods.click_Element_Using_JS(GlDirectLocators.no_chkbox);
		//WaitMethods.wait_in_seconds(3);
		GenericMethods.is_element_present(GlDirectLocators.eligibility_Yes_Btn);
		GenericMethods.click_Element_Using_JS(GlDirectLocators.eligibility_Yes_Btn);
		GenericMethods.is_element_present(GlDirectLocators.eleigibilty_saveandContinue_btn);
		GenericMethods.click_Element_Using_JS(GlDirectLocators.eleigibilty_saveandContinue_btn);
		WaitMethods.wait_in_seconds(5);
	}
	
	public static void contratLicense(int row_num) throws Exception
	{
		ExcelReader.set_excel_file(Locations.GlDirect_dataFilePath,"Cont_License");
		GenericMethods.enter_text(GlDirectLocators.contaracorsLicense_txtb,ExcelReader.get_row_data_from_col("ContLiscense", row_num), "ContLiscense");
		GenericMethods.click_Element_Using_JS(GlDirectLocators.contaracorsLicense_saveandContinue_btn);
	}
	
	public static void getquoteno(int row_num) throws Exception
	{
		ExcelReader.set_excel_file(Locations.GlDirect_dataFilePath,"Buy_your_policy");
		String QAAquoteNo=GenericMethods.get_text(GlDirectLocators.qaaquoteNo);	
		ExcelReader.set_cell_data("QAAquote",row_num,QAAquoteNo);
		WaitMethods.wait_in_seconds(5);
		
	}
	
	public static void coverage_options(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{	
				
		ExcelReader.set_excel_file(Locations.GlDirect_dataFilePath,"Coverage_Options");
		
		String SilverquoteNo=GenericMethods.get_text(GlDirectLocators.silver_Quote_btn);	
		ExcelReader.set_cell_data("Silver_QoteValue",row_num,SilverquoteNo);
		
		String GoldquoteNo=GenericMethods.get_text(GlDirectLocators.gold_Quote_btn);	
		ExcelReader.set_cell_data("Gold_QoteValue",row_num,GoldquoteNo);
		
		String PlatinumquoteNo=GenericMethods.get_text(GlDirectLocators.platinum_Quote_btn);	
		ExcelReader.set_cell_data("Platinum_QoteValue",row_num,PlatinumquoteNo);
				
		String Monthly_premiumAmount=GenericMethods.get_text(GlDirectLocators.monthlyPayment_value);	
		ExcelReader.set_cell_data("Monthly_premiumAmount",row_num,Monthly_premiumAmount);
				
		String Annual_premiumAmount=GenericMethods.get_text(GlDirectLocators.annualPayment_value);	
		ExcelReader.set_cell_data("Annual_premiumAmount",row_num,Annual_premiumAmount);
		
	}
	
	public static void select_CoverageOption() throws IOException, InterruptedException, Exception, AWTException
	{
		GenericMethods.click_Element_Using_JS(GlDirectLocators.silver_btn);
		//GenericMethods.click_Element_Using_JS(GlDirectLocators.gold_btn);
		//GenericMethods.click_Element_Using_JS(GlDirectLocators.platinum_btn);
		WaitMethods.wait_in_seconds(2);
		GenericMethods.press_key_using_robot("end");
		//GenericMethods.click_Element_Using_JS(GlDirectLocators.terrorism_chkbox);
		GenericMethods.click_Element_Using_JS(GlDirectLocators.monthlyPayment_btn);
		//GenericMethods.click_Element_Using_JS(GlDirectLocators.annualPayment_btn);
				
	}
	
	public static void reviewPage() throws IOException, InterruptedException, Exception, AWTException
	{	
		//GenericMethods.click_Element_Using_JS(GlDirectLocators.buyPolicy_btn);
		
		GenericMethods.is_element_present(GlDirectLocators.reviewApp_applyNow_btn);
		GenericMethods.click_Element_Using_JS(GlDirectLocators.reviewApp_applyNow_btn);
		WaitMethods.wait_in_seconds(2);
	}
		
	public static void buyYourPolicy(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{ 
		ExcelReader.set_excel_file(Locations.GlDirect_dataFilePath,"Buy_your_policy");
		GenericMethods.enter_text(GlDirectLocators.card_no_txtb,ExcelReader.get_row_data_from_col("Card_Number", row_num), "CardNumber");
		GenericMethods.enter_text(GlDirectLocators.expiration_txtb,ExcelReader.get_row_data_from_col("Expiry", row_num), "Expiry");
		GenericMethods.enter_text(GlDirectLocators.cvv_txtb,ExcelReader.get_row_data_from_col("CVV", row_num), "CVV");
		GenericMethods.enter_text(GlDirectLocators.nameonCard_txtb,ExcelReader.get_row_data_from_col("Name_on_card", row_num), "NameOnCard");
		GenericMethods.click_element_JS(GlDirectLocators.city_txtb);
		GenericMethods.press_key_using_robot("end");
		WaitMethods.wait_in_seconds(5);
		GenericMethods.is_element_present(GlDirectLocators.completePayment_btn);
		GenericMethods.click_Element_Using_JS(GlDirectLocators.completePayment_btn);
		WaitMethods.wait_in_seconds(3);
		
	}
	
	public static void compair_PreQualifyValue_with_CoverageOption() throws Exception
	{	
		ExcelReader.set_excel_file(Locations.GlDirect_dataFilePath,"Get_Your_Price");
		String preRate =ExcelReader.get_row_data_from_col("PreQualify_Rate", 1);
		WaitMethods.wait_in_seconds(3);
		ExcelReader.set_excel_file(Locations.GlDirect_dataFilePath,"Coverage_Options");
		String CoverageRate =ExcelReader.get_row_data_from_col("Silver_QoteValue", 1);
		if(preRate.equals(CoverageRate))
		{
		 log.info("PreQualify rate is Same as Monthly Coverage rate");
		}
		else {
			log.info("PreQualify rate is Not Equal to Monthly Coverage rate");
		}
				
	}
	
	public static void compair_allFileds_valuesfrom_CoverageOptions(int row_num) throws Exception
	{
		ExcelReader.set_excel_file(Locations.GlDirect_dataFilePath,"Coverage_Options");
		if(GlDirectLocators.silver_Quote_btn.getText().equals(ExcelReader.get_row_data_from_col("Silver_QoteValue", 1)) &&
		   GlDirectLocators.gold_Quote_btn.getText().equals(ExcelReader.get_row_data_from_col("Gold_QoteValue", 1)) &&
		   GlDirectLocators.platinum_Quote_btn.getText().equals(ExcelReader.get_row_data_from_col("Platinum_QoteValue", 1)) &&
		   GlDirectLocators.monthlyPayment_value.getText().equals(ExcelReader.get_row_data_from_col("Monthly_premiumAmount", 1)) &&
		   GlDirectLocators.annualPayment_value.getText().equals(ExcelReader.get_row_data_from_col("Annual_premiumAmount", 1)))
		{
			log.info("values are Same");
		}
		else {
			log.info("Fail values are Not Same");
			}
	}
	
	/*public static void docuSign() throws Exception
	{	
		WaitMethods.wait_in_seconds(2);
		Screen src = new Screen();
		WaitMethods.wait_in_seconds(2);
		src.exists(Locations.iAgreeChkb);
		WaitMethods.wait_in_seconds(2);
		src.click(Locations.agree_btn);
				
		WaitMethods.wait_in_seconds(2);
		src.click(Locations.continue_page1);
		src.click(Locations.continue_page1);
		WaitMethods.wait_in_seconds(8);
	
		src.click(Locations.ok_page2);
		src.click(Locations.ok_page2);
		WaitMethods.wait_in_seconds(2);
		src.click(Locations.start_p2);
		WaitMethods.wait_in_seconds(2);
		src.click(Locations.sign_required_p2);
		WaitMethods.wait_in_seconds(2);
		GenericMethods.press_key_using_robot("end");
		
		src.click(Locations.adoptSignPop_up);
		src.click(Locations.adoptSignPop_up);
		WaitMethods.wait_in_seconds(3);
		src.click(Locations.finish_last);
		src.click(Locations.finish_last);
		WaitMethods.wait_in_seconds(2);
				
	}*/
	
	public static void YourPolicyInformation()
	{	
		GenericMethods.swith_to_default_content();
		String quote=GlDirectLocators.yourPolicy_QAAno.getText();
		log.info(quote+"no.");
		String policyquote=GlDirectLocators.yourPolicy_QAAno.getText();
		log.info(policyquote +"nooooooooo.");
		GenericMethods.driver.close();
		
	}
			
	public static void docuSign1()throws IOException, InterruptedException, Exception, AWTException
	{	

		GenericMethods.swith_to_default_content();
		GenericMethods.swith_to_frame_using_index(0);WaitMethods.wait_in_seconds(2);
		GenericMethods.click_Element_Using_JS(GlDirectLocators.doc_IAgree_chkb);
		WaitMethods.wait_in_seconds(2);
		GenericMethods.click_Element_Using_JS(GlDirectLocators.doc_continue_btn);
		WaitMethods.wait_in_seconds(2);
	}
	
	public static void docuSign2()throws IOException, InterruptedException, Exception, AWTException
	{
		GenericMethods.click_Element_Using_JS(GlDirectLocators.doc2_okAlert_btn);
		WaitMethods.wait_in_seconds(2);
		GenericMethods.click_Element_Using_JS(GlDirectLocators.doc2_start_btn);
		GenericMethods.click_Element_Using_JS(GlDirectLocators.doc3_requiredSign_btn);
		WaitMethods.wait_in_seconds(2);
		GenericMethods.click_element_JS(GlDirectLocators.adoptSign_btn);
		WaitMethods.wait_in_seconds(2);
		GenericMethods.click_Element_Using_JS(GlDirectLocators.doc3_finish_btn);
		WaitMethods.wait_in_seconds(2);
		GenericMethods.swith_to_default_content();
		WaitMethods.wait_in_seconds(10);
	}
	
}
