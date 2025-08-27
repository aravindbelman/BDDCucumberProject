package com.BtisNewUI.PageMethods;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;

import com.BtisNewUI.Locators.NEXT_UI_locators;
import com.BtisNewUI.Locators.StarrUILocators;
import com.LegacyApplication.ExcelReader.ExcelReader;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageLocators.AdminSubmissionPageLocators;
import com.LegacyApplication.PageLocators.DefaultBrokerFeeLocators;
import com.LegacyApplication.PageLocators.GeneralLiabilityPageLocators;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

public class NextUImethods extends TestBase {
	
	public static final Logger log=Logger.getLogger(NextUImethods.class.getName());
	public static JavascriptExecutor js;
	
	public static void nextLet_geta_quote(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{   
		WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.general_liablity_button);
		GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.general_liablity_button);
		GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.selectNEXT);
		WaitMethods.wait_in_seconds(2);		
		GenericMethods.swith_to_frame_using_id("next-sdk");
		
		ExcelReader.set_excel_file(Locations.NEXT_UI_TestData,"Let's get a quote");
		WaitMethods.wait_in_seconds(2);
		
		GenericMethods.click_Element(NEXT_UI_locators.business_search);
		GenericMethods.enter_text(NEXT_UI_locators.business_searchInput,ExcelReader.get_row_data_from_col("Business", row_num), "Business");
		GenericMethods.click_Element(NEXT_UI_locators.businessName);WaitMethods.wait_in_seconds(2);
		
		GenericMethods.click_Element(NEXT_UI_locators.coverage_txtb);
		GenericMethods.enter_text(NEXT_UI_locators.coverageSearchInput,ExcelReader.get_row_data_from_col("Coverage", row_num), "Coverage");
		GenericMethods.click_Element(NEXT_UI_locators.coverageName_gl);WaitMethods.wait_in_seconds(2);
		
		GenericMethods.click_Element(NEXT_UI_locators.state_txtb);
		GenericMethods.enter_text(NEXT_UI_locators.stateSearchInput,ExcelReader.get_row_data_from_col("State", row_num), "State");
		GenericMethods.click_Element(NEXT_UI_locators.stateName);WaitMethods.wait_in_seconds(2);
		
		//GenericMethods.enter_text(NEXT_UI_locators.Insure_email_txtxb,ExcelReader.get_row_data_from_col("Insured Email Address", row_num), "Insured Email Address");
		NEXT_UI_locators.Insure_email_txtxb.sendKeys("btisinc123+nexttest"+GenericMethods.generate_random_integer(9000,1000)+"@gmail.com");
		
		GenericMethods.click_Element(NEXT_UI_locators.quote_btn);WaitMethods.wait_in_seconds(8);
	}
	
	public static void alertPop()throws IOException, InterruptedException, Exception, AWTException
	{
		
		if(NEXT_UI_locators.help_PopUp_No.isDisplayed())
		{	
			GenericMethods.click_Element(NEXT_UI_locators.help_PopUp_No);WaitMethods.wait_in_seconds(2);
		}else
		{
			
		}
	}
	public static void nexAbout_your_customer(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{ 	
		ExcelReader.set_excel_file(Locations.NEXT_UI_TestData,"About your customer");
		WaitMethods.wait_in_seconds(2);
		
		//GenericMethods.enter_text(NEXT_UI_locators.firstName_txtb,ExcelReader.get_row_data_from_col("First name", row_num), "First name");
		NEXT_UI_locators.firstName_txtb.sendKeys("Rajesh"+GenericMethods.generate_random_integer(9000000, 1000000));WaitMethods.wait_in_seconds(1);
		String firstName=GenericMethods.getTextfmElem(NEXT_UI_locators.firstName_txtb);
		ExcelReader.set_cell_data("First name", row_num, firstName);
		
		GenericMethods.enter_text(NEXT_UI_locators.lastName_txtb,ExcelReader.get_row_data_from_col("Last name", row_num), "Last name");
		GenericMethods.enter_text(NEXT_UI_locators.telephone_txtb,ExcelReader.get_row_data_from_col("Telephone number", row_num), "Telephone number");
		GenericMethods.enter_text(NEXT_UI_locators.businessName_txtb,ExcelReader.get_row_data_from_col("Your business name", row_num), "Your business name");
		GenericMethods.enter_text(NEXT_UI_locators.primaryMailing_txtb_old,ExcelReader.get_row_data_from_col("Primary Mailing Address", row_num), "Primary Mailing Address");
		/*WaitMethods.wait_in_seconds(2);
		GenericMethods.press_key_using_robot("downArrow");
		GenericMethods.press_key_using_robot("enter");
		*/
		GenericMethods.enter_text(NEXT_UI_locators.city_txtb,ExcelReader.get_row_data_from_col("City", row_num), "City");
		GenericMethods.enter_text(NEXT_UI_locators.zip_txtb,ExcelReader.get_row_data_from_col("Zip code", row_num), "Zip code");
	}
	
	public static void nexAbout_the_company(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.corporation_btn);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.startBusiness_btn);WaitMethods.wait_in_seconds(2);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.startYear_btn);WaitMethods.wait_in_seconds(2);		
	}
	
	public static void nxtAbout_the_business(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{	
		ExcelReader.set_excel_file(Locations.NEXT_UI_TestData,"About the business");
		WaitMethods.wait_in_seconds(2);
				
		GenericMethods.enter_text(NEXT_UI_locators.revenuein12_txtb,ExcelReader.get_row_data_from_col("revenue_in_12_months", row_num), "revenue_in_12_months");
		GenericMethods.enter_text(NEXT_UI_locators.noofEmployee_txtb,ExcelReader.get_row_data_from_col("num_of_employees", row_num), "num_of_employees");
		GenericMethods.enter_text(NEXT_UI_locators.payrollin12_txtb,ExcelReader.get_row_data_from_col("payroll_in_12_months", row_num), "payroll_in_12_months");
		GenericMethods.enter_text(NEXT_UI_locators.subcontractor_txtb,ExcelReader.get_row_data_from_col("subcontractor_cost_in_12_months", row_num), "subcontractor_cost_in_12_months");
		
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.sub_yes);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.requirement_Iaccept_btn);		
		
		GenericMethods.enter_text(NEXT_UI_locators.residential_txtb,ExcelReader.get_row_data_from_col("residential_work_percent", row_num), "residential_work_percent");
		GenericMethods.enter_text(NEXT_UI_locators.commercial_txtb,ExcelReader.get_row_data_from_col("commercial_work_percent", row_num), "commercial_work_percent");
		GenericMethods.enter_text(NEXT_UI_locators.industrial_txtb,ExcelReader.get_row_data_from_col("industrial_work_percent", row_num), "industrial_work_percent");
		WaitMethods.wait_in_seconds(2);
	}
	
	public static void nxtAbout_the_services(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{	
		ExcelReader.set_excel_file(Locations.NEXT_UI_TestData,"About the services");
		WaitMethods.wait_in_seconds(2);
		
		GenericMethods.enter_text(NEXT_UI_locators.residential_txtb,ExcelReader.get_row_data_from_col("residential_work_percent", row_num), "residential_work_percent");
		GenericMethods.enter_text(NEXT_UI_locators.commercial_txtb,ExcelReader.get_row_data_from_col("commercial_work_percent", row_num), "commercial_work_percent");
		GenericMethods.enter_text(NEXT_UI_locators.industrial_txtb,ExcelReader.get_row_data_from_col("industrial_work_percent", row_num), "industrial_work_percent");
		WaitMethods.wait_in_seconds(2);			
	}
	
	public static void nxtAbout_the_services2(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.Carpentry_chkb);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.concrete_cons_chkb);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.Drywall_chkb);
	}
	
	public static void nxtAbout_the_business_GC(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{	
		ExcelReader.set_excel_file(Locations.NEXT_UI_TestData,"About the business for GC");
		WaitMethods.wait_in_seconds(2);
		
		GenericMethods.enter_text(NEXT_UI_locators.years_of_experience_txtb,ExcelReader.get_row_data_from_col("Years of experience", row_num), "Years of experience");
		GenericMethods.enter_text(NEXT_UI_locators.revenuein12_txtb,ExcelReader.get_row_data_from_col("revenue_in_12_months", row_num), "revenue_in_12_months");
		GenericMethods.enter_text(NEXT_UI_locators.noofEmployee_txtb,ExcelReader.get_row_data_from_col("num_of_employees", row_num), "num_of_employees");
		GenericMethods.enter_text(NEXT_UI_locators.payrollin12_txtb,ExcelReader.get_row_data_from_col("payroll_in_12_months", row_num), "payroll_in_12_months");
		
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.sub_gc_no);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.I_understand_btn);
	}
	
	public static void nxtAbout_the_subcontracting_GC(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{	
		ExcelReader.set_excel_file(Locations.NEXT_UI_TestData,"About the subcontracting");
		WaitMethods.wait_in_seconds(2);
		GenericMethods.enter_text(NEXT_UI_locators.subcontractor_txtb,ExcelReader.get_row_data_from_col("subcontractor_cost_in_12_months", row_num), "subcontractor_cost_in_12_months");
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.requirement_Iaccept_btn);			
	}
	
	public static void nxtAbout_the_work_GC(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.about_the_work_YES);
		WaitMethods.wait_in_seconds(2);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.Blasting_chkb);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.Foundation_work_chkb);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.Environmental_clean_up_chkb);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.submit_btn);
		WaitMethods.wait_in_seconds(2);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.about_the_work_NO);
	}
	
	public static void nxtAbout_the_GC(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.activities_of_your_subcontractors_YES);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.Blasting_operations_chkb);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.Man_hole_work_chkb);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.visit_eachjobsite_click);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.OneTwo_in_month);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.activities_of_your_subcontractors_No);
	}
	
	public static void nxtInsurance_Details_GC(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.claims_last_3_years_12299_yes);
		GenericMethods.enter_text(NEXT_UI_locators.claims_count_txtb,"2","claims_count_txtb");
		GenericMethods.enter_text(NEXT_UI_locators.claims_total_amount_txtb,"12586","claims_total_amount_txtb");
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.fraud_bribery_legal_12302_yes);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.excludefromYouPolicy_I_Understand);
	}
	
	public static void nxtAbout_the_insuranceGC() throws IOException, InterruptedException, Exception, AWTException
	{
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.gc_add_roofing_12027_yes);
	}
	
	public static void nxtAbout_the_quote_GC() throws IOException, InterruptedException, Exception, AWTException
	{
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.auto_vehicle_for_work_activity_1137_yes);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.No_policy);WaitMethods.wait_in_seconds(2);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.nxt_Btn);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.continue_without_auto_btn);
		WaitMethods.wait_in_seconds(2);
	}
	
	public static void nxtthe_quote_values_GC(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{	
		ExcelReader.set_excel_file(Locations.NEXT_UI_TestData,"QuoteValuesRates");
		WaitMethods.wait_in_seconds(2);
		
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.basic_tab);
		String basicValue=GenericMethods.get_text(NEXT_UI_locators.basic_value);
		ExcelReader.set_cell_data("BASIC", row_num, basicValue);
		WaitMethods.wait_in_seconds(2);
		
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.pro_tab);
		String proValue=GenericMethods.get_text(NEXT_UI_locators.pro_value);
		ExcelReader.set_cell_data("PRO", row_num, proValue);
		WaitMethods.wait_in_seconds(2);
		
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.proPlus_tab);
		String proPlusValue=GenericMethods.get_text(NEXT_UI_locators.proPlus_value);
		ExcelReader.set_cell_data("PROPLUS", row_num, proPlusValue);
		WaitMethods.wait_in_seconds(2);

		GenericMethods.is_element_present(NEXT_UI_locators.proPlus_select_btn);
		GenericMethods.click_Element(NEXT_UI_locators.proPlus_select_btn);
		
	}
	
	public static void about_SummaryPAGE()throws IOException, InterruptedException, Exception, AWTException
	{
		GenericMethods.scroll_down_to_element(NEXT_UI_locators.continueToPayment_btn);WaitMethods.wait_in_seconds(2);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.continueToPayment_btn);
	}
	public static void nxt_paymentPage_GC(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{	
				
		ExcelReader.set_excel_file(Locations.NEXT_UI_TestData,"QuoteValuesRates");
		WaitMethods.wait_in_seconds(2);
		
		String FirstAndLast=GenericMethods.get_text(NEXT_UI_locators.FirstAndLast_Value);
		ExcelReader.set_cell_data("firstlast month", row_num, FirstAndLast);
		
		//GenericMethods.swith_to_frame_using_id("payment-iframe");
		//GenericMethods.swith_to_frame_using_id("next-sdk");
		//__privateStripeFrame5
		
		GenericMethods.enter_text(NEXT_UI_locators.name_txtb,ExcelReader.get_row_data_from_col("userName", row_num), "userName");
		
		GenericMethods.swith_to_frame_using_name("__privateStripeFrame5");
		GenericMethods.is_element_present(NEXT_UI_locators.cardNumber_txtb);
		GenericMethods.enter_text(NEXT_UI_locators.cardNumber_txtb,ExcelReader.get_row_data_from_col("cardNumber", row_num), "cardNumber");
		WaitMethods.wait_in_seconds(2);
		
		GenericMethods.swith_to_default_content();		
		GenericMethods.swith_to_frame_using_name("__privateStripeFrame6");
		GenericMethods.is_element_present(NEXT_UI_locators.expdate);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.expdate);
		GenericMethods.is_element_present(NEXT_UI_locators.expiryDate_txtb);
		GenericMethods.enter_text(NEXT_UI_locators.expiryDate_txtb,ExcelReader.get_row_data_from_col("expiryDate", row_num), "expiryDate");
		WaitMethods.wait_in_seconds(2);
		
		
		GenericMethods.swith_to_frame_using_name("__privateStripeFrame7");
		GenericMethods.is_element_present(NEXT_UI_locators.securityCode_txtb);
		GenericMethods.enter_text(NEXT_UI_locators.securityCode_txtb,ExcelReader.get_row_data_from_col("securityCode", row_num), "securityCode");

		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.Pay_btn);
		WaitMethods.wait_in_seconds(5);
		
	}
	
	/*
	 * Purpose: This method is to search and click on QNXT submission
	 * @param String firstName_ID, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void verify_Context_link_qnext(int row_num) throws InterruptedException, AWTException, IOException
	{
		try
		{
			WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.selectBy_drpDwn);
			ExcelReader.set_excel_file(Locations.NEXT_UI_TestData,"About your customer");
			WaitMethods.wait_in_seconds(2);
			AdminSubmissionPageLocators.submission_id_searchfield.clear();
			AdminSubmissionPageLocators.submission_id_searchfield.sendKeys(ExcelReader.get_row_data_from_col("First name", row_num));

			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
			WaitMethods.wait_in_seconds(1);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
			WaitMethods.wait_in_seconds(3);
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_table_row);
			String statusPaid=AdminSubmissionPageLocators.submissionID.getText();
			ExcelReader.set_cell_data("SubmissionID_QNXT", row_num, statusPaid);
			log.info("//===========================>clicking on Proposal Document<=============================");
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_table_row);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
			WaitMethods.wait_in_seconds(3);
			WaitMethods.wait_for_element_present(NEXT_UI_locators.context_propsalDocument);
			GenericMethods.click_Element_Using_JS(NEXT_UI_locators.context_propsalDocument);
			log.info("//===========================> Clicked on Proposal Document<=============================");
			WaitMethods.wait_in_seconds(5);
			GenericMethods.navigate_to_next_window();
			log.info("//===========================>Proposal Document Open Successfully.<=============================");
			
			GenericMethods.close_browser_window();
			GenericMethods.navigate_to_next_window();
			
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
			WaitMethods.wait_in_seconds(3);	
			
			WaitMethods.wait_for_element_present(NEXT_UI_locators.context_RetriveNPay);
			GenericMethods.click_Element_Using_JS(NEXT_UI_locators.context_RetriveNPay);
			GenericMethods.navigate_to_next_window();
			WaitMethods.wait_in_seconds(2);
			
			GenericMethods.is_element_present(NEXT_UI_locators.pro_select_btn2);
			GenericMethods.click_Element(NEXT_UI_locators.pro_select_btn2);	
			
		}
		catch(UnhandledAlertException | NoSuchElementException exe)
		{
			log.debug("The exception was found "+exe.getClass().getCanonicalName());
		}
		catch(WebDriverException exe)
		{
			log.info("unable to find the element in the web page");
		}
	}
	
	public static void verify_quote_with_Paid_status(int row_num) throws InterruptedException, AWTException, IOException
	{	
		GenericMethods.press_key_using_robot("f5");
		ExcelReader.set_excel_file(Locations.NEXT_UI_TestData,"About your customer");
		WaitMethods.wait_in_seconds(2);
		
		WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.selectBy_drpDwn);
		GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.selectBy_drpDwn, "visibletext", "Submission Number");

		AdminSubmissionPageLocators.submission_id_searchfield.sendKeys(ExcelReader.get_row_data_from_col("SubmissionID_QNXT", row_num));
		
		WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
		GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
		WaitMethods.wait_in_seconds(1);
		GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
		WaitMethods.wait_in_seconds(3);
		
		log.info("//===========================>Looking for submission with PAID status.<=============================");
		//String statusPaid= GenericMethods.getTextfmElem(AdminSubmissionPageLocators.Paid_status);
		String statusPaid=AdminSubmissionPageLocators.Paid_status.getText();
		log.info(statusPaid);
		Assert.assertEquals(statusPaid,"Paid");
		log.info("=====================>Status of the Submission changed to Paid successfully.<=========================");	
	}	
}
