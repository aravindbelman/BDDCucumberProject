package com.BtisNewUI.PageMethods;

import java.awt.AWTException;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;

import com.BtisNewUI.Locators.ClearSpringLocators;
import com.BtisNewUI.Locators.WCnewUILocators;
import com.LegacyApplication.ExcelReader.ExcelReader;
import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageLocators.AdminSubmissionPageLocators;
import com.LegacyApplication.PageLocators.AutoRenewalBrokerFeeLocators;
import com.LegacyApplication.PageLocators.DefaultBrokerFeeLocators;
import com.LegacyApplication.PageLocators.GeneralLiabilityPageLocators;
import com.LegacyApplication.PageMethods.AdminSubmissionPageMethods;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

public class ClearSpring_UI_Methods extends TestBase{

	public static final Logger log=Logger.getLogger(ClearSpring_UI_Methods.class.getName());
	public static JavascriptExecutor js;

	// Create object of SimpleDateFormat class and decide the format
	static SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	static java.util.Date date= new java.util.Date();
	static String finalDate=dateFormat.format(date);

	//To select WC as Program
	public static void select_CS_Program() throws IOException, InterruptedException, Exception, AWTException
	{
		WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.general_liablity_button);
		GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.general_liablity_button);
		GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.clearSpring_button);

		WaitMethods.wait_in_seconds(2);
		// To handle all new opened window.		
		GenericMethods.navigate_to_next_window();


		String url=driver.getCurrentUrl();
		log.info("Driver Navigated to ==== " +url); 

		WaitMethods.wait_for_element_present(ClearSpringLocators.firstName_txtb);

	}

	/*
	 * Puerpose: This methid is used to fill ClearSpring market Palce -Selection. 
	 */
	public static void clearSpring_MarketPalce()throws IOException, InterruptedException, AWTException
	{	
				
		WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.general_liablity_button);
		GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.general_liablity_button);
		GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.victory_general_liability);

		WaitMethods.wait_in_seconds(2);

		if(driver.getCurrentUrl().contains("General-Liability-Marketplace"))
		{				
			GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.state_select, "visibletext","Arizona");
			WaitMethods.wait_in_seconds(2);
			GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.classCode_select, "visibletext","Air Conditioning");
			WaitMethods.wait_in_seconds(2);
			GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.clearSpring_prg);
			WaitMethods.wait_in_seconds(2);

			// To handle all new opened window.		
			GenericMethods.navigate_to_next_window();


			String url=driver.getCurrentUrl();
			log.info("Driver Navigated to ==== " +url); 

			WaitMethods.wait_for_element_present(ClearSpringLocators.firstName_txtb);
		}
	}
	//Fill details in Page 1 Applicant's Contact Information

	public static void applicantsInfo_page1_FillDetails(int row_num, String diff_address)throws IOException, InterruptedException, Exception, AWTException
	{	
		ExcelReader.set_excel_file(Locations.ClearSpringGL_UI_TestData,"Sheet1");


		GenericMethods.enter_text(ClearSpringLocators.firstName_txtb, ExcelReader.get_row_data_from_col("FirstName", row_num), "FirstName : ");
		GenericMethods.enter_text(ClearSpringLocators.lastName_txtb, ExcelReader.get_row_data_from_col("LastName", row_num), "LastName : ");

		//GenericMethods.enter_text(ClearSpringLocators.business_streetAdd_txtb,ExcelReader.get_row_data_from_col("BusinessStreetAdd1", row_num),"BusinessStreetAdd1 : ");

		ClearSpringLocators.business_streetAdd_txtb.sendKeys(GenericMethods.generate_random_integer(9,1),ExcelReader.get_row_data_from_col("BusinessStreetAdd1", row_num));
		WaitMethods.wait_in_seconds(2);

		WaitMethods.wait_for_elements_present(ClearSpringLocators.businessAdd_List_cs);
		GenericMethods.bootstrap_dropdown(ClearSpringLocators.businessAdd_List_cs,"");
		
		WaitMethods.wait_in_seconds(2);
		String stateName=ClearSpringLocators.businessAddressState_drpd.getAttribute("value");
		//String stateName=GenericMethods.get_selected_optn_frm_ele(ClearSpringLocators.businessAddressState_drpd);
		log.info("=============================== " +stateName+ " =====================================" );
		ExcelReader.set_cell_data("state name", 1, stateName);
		
		
		if(diff_address.equalsIgnoreCase("same"))
		{	
			WaitMethods.wait_in_seconds(2);
			GenericMethods.is_element_present(ClearSpringLocators.sameAddress_chkb);
			GenericMethods.click_Element_Using_JS(ClearSpringLocators.sameAddress_chkb);
			WaitMethods.wait_in_seconds(2);
		}
		else if(diff_address.equalsIgnoreCase("different"))
		{
			ClearSpringLocators.mailing_streetAdd_txtb.sendKeys(GenericMethods.generate_random_integer(9,1),ExcelReader.get_row_data_from_col("MailingStreetAdd1", row_num));
			WaitMethods.wait_in_seconds(2);

			WaitMethods.wait_for_elements_present(ClearSpringLocators.businessAdd_List_cs);
			GenericMethods.bootstrap_dropdown(ClearSpringLocators.businessAdd_List_cs,"");
		}			

		ClearSpringLocators.emailAddress_txtb.sendKeys(GenericMethods.generate_random_integer(900, 100)+ExcelReader.get_row_data_from_col("Email", row_num));
		WaitMethods.wait_in_seconds(1);
		ClearSpringLocators.phoneNumber_txtb.sendKeys("9"+GenericMethods.generate_random_integer(900000000, 100000000));
		ClearSpringLocators.cellNumber_txtb.sendKeys("9"+GenericMethods.generate_random_integer(900000000, 100000000));
		WaitMethods.wait_in_seconds(2);	

		GenericMethods.click_Element(ClearSpringLocators.save_continue_btn_page1);
	}



	public static void applicantsInfo_page1_FillDetails_multiStates(String diff_address)throws IOException, InterruptedException, Exception, AWTException
	{
		ExcelReader.set_excel_file(Locations.ClearSpringGL_UI_TestData,"Sheet1");
		int Data_in_rows=ExcelReader.get_row_count();
		WaitMethods.wait_in_seconds(2);

		try
		{
			//===================Business Address ========================//

			for(int i=2;i<7; i++)
			{
				GenericMethods.enter_text(ClearSpringLocators.firstName_txtb, ExcelReader.get_row_data_from_col("FirstName", i), "FirstName : ");
				GenericMethods.enter_text(ClearSpringLocators.lastName_txtb, ExcelReader.get_row_data_from_col("LastName", i), "LastName : ");

				ClearSpringLocators.business_streetAdd_txtb.sendKeys(GenericMethods.generate_random_integer(9,1),ExcelReader.get_row_data_from_col("BusinessStreetAdd1", i));
				WaitMethods.wait_in_seconds(2);

				WaitMethods.wait_for_elements_present(ClearSpringLocators.businessAdd_List_cs);
				GenericMethods.bootstrap_dropdown(ClearSpringLocators.businessAdd_List_cs,"");
				
				WaitMethods.wait_in_seconds(2);
				String stateName=ClearSpringLocators.businessAddressState_drpd.getAttribute("value");
				WaitMethods.wait_in_seconds(2);
				//String stateName=GenericMethods.get_selected_optn_frm_ele(ClearSpringLocators.businessAddressState_drpd);
				log.info("=============================== " +stateName+ " =====================================" );
				ExcelReader.set_cell_data("state name", i, stateName);
				
				if(diff_address.equalsIgnoreCase("same"))
				{	
					WaitMethods.wait_in_seconds(2);
					GenericMethods.is_element_present(ClearSpringLocators.sameAddress_chkb);
					GenericMethods.click_Element_Using_JS(ClearSpringLocators.sameAddress_chkb);
					WaitMethods.wait_in_seconds(2);
				}
				else if(diff_address.equalsIgnoreCase("different"))
				{
					ClearSpringLocators.mailing_streetAdd_txtb.sendKeys(GenericMethods.generate_random_integer(9,1),ExcelReader.get_row_data_from_col("MailingStreetAdd1", i));
					WaitMethods.wait_in_seconds(2);

					WaitMethods.wait_for_elements_present(ClearSpringLocators.businessAdd_List_cs);
					GenericMethods.bootstrap_dropdown(ClearSpringLocators.businessAdd_List_cs,"");
				}			

				ClearSpringLocators.emailAddress_txtb.sendKeys(GenericMethods.generate_random_integer(900, 100)+ExcelReader.get_row_data_from_col("Email", i));
				WaitMethods.wait_in_seconds(1);
				ClearSpringLocators.phoneNumber_txtb.sendKeys("9"+GenericMethods.generate_random_integer(900000000, 100000000));
				ClearSpringLocators.cellNumber_txtb.sendKeys("9"+GenericMethods.generate_random_integer(900000000, 100000000));
				WaitMethods.wait_in_seconds(2);	

				GenericMethods.click_Element(ClearSpringLocators.save_continue_btn_page1);

				//==============================

				//Employee_Yes,Subcontractor_Yes,ResedentialWork_Yes   OR
				//Employee_No,Subcontractor_No,ResedentialWork_No
				ClearSpring_UI_Methods.businessInfo_page2_FillDetails(1,"Employee_Yes","Subcontractor_Yes","ResedentialWork_Yes");
				//BusinessHistory_NO,BusinessHistory_YES
				ClearSpring_UI_Methods.insuranceInfo_page3_FillDetails(1,"BusinessHistory_NO");
				ClearSpring_UI_Methods.classifications_page4_FillDetails(1);
				ClearSpring_UI_Methods.pricingOptions_page5_FillDetails("compairNo",1);	
				//UW or coverage
				ClearSpring_UI_Methods.eligibility_submit_page6("coverage");
				ClearSpring_UI_Methods.brokerFee_Enhancement_page7_FillDetails(1,"no","assertValues_no");
				WaitMethods.wait_in_seconds(5);
				ClearSpring_UI_Methods.verify_ThankYou1(1);

				//===============================
				GenericMethods.close_browser_window();
				GenericMethods.navigate_to_next_window();
				WaitMethods.wait_in_seconds(2);
				
				GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.clearSpring_prg);
				GenericMethods.navigate_to_next_window();
			}
		}
		catch(UnhandledAlertException exe)
		{
			log.info("Unhandled alert occured");
		}
		catch(ElementNotVisibleException exe)
		{
			log.info("Element not visible");
		}
		catch(NoSuchElementException exe)
		{
			log.info("unable to find the element in the web page");
		}
		catch(WebDriverException exe)
		{
			log.info("unable to find the element in the web page");
		}
	}


	//Fill details in Page 2 Applicant's Business Information

	public static void businessInfo_page2_FillDetails(int row_num, String employees,String subcontractors,String residentialWork)throws IOException, InterruptedException, Exception, AWTException
	{		
		ExcelReader.set_excel_file(Locations.ClearSpringGL_UI_TestData,"businessInfo");
		WaitMethods.wait_in_seconds(2);
		//GenericMethods.select_from_dropdown(ClearSpringLocators.relationToBusiness_drpd, "visibletext", ExcelReader.get_row_data_from_col("relationToBusiness_drpd", row_num));

		String sumTemp=ClearSpringLocators.submissionID_Temp.getText();
		log.info("========================="+sumTemp+"=============================");

		GenericMethods.enter_text(ClearSpringLocators.businessName_txtb, ExcelReader.get_row_data_from_col("dba", row_num), "Business Name : ");
		ClearSpringLocators.businessName_txtb.sendKeys(finalDate);

		GenericMethods.select_from_dropdown(ClearSpringLocators.stractureOfBusiness_drpd, "visibletext", ExcelReader.get_row_data_from_col("stractureOfBusiness_drpd", row_num));
		GenericMethods.select_from_dropdown(ClearSpringLocators.constructionExperienceId_drpd, "visibletext", ExcelReader.get_row_data_from_col("constructionExperienceId_drpd", row_num));
		GenericMethods.enter_text(ClearSpringLocators.numberOfOwners_txtb, ExcelReader.get_row_data_from_col("numberOfOwners_txtb", row_num), "numberOfOwners : ");
		//GenericMethods.enter_text(ClearSpringLocators.ownerPayroll_txtb, ExcelReader.get_row_data_from_col("ownerPayroll_txtb", row_num), "ownerPayroll : ");
		GenericMethods.enter_text(ClearSpringLocators.grossReceipts_txtb, ExcelReader.get_row_data_from_col("grossReceipts_txtb", row_num), "grossReceipts : ");

		if(employees.equalsIgnoreCase("Employee_Yes"))
		{
			GenericMethods.click_Element(ClearSpringLocators.employees_YES);
			GenericMethods.enter_text(ClearSpringLocators.numberOfFullTimeEmployees_txtb, ExcelReader.get_row_data_from_col("numberOfFullTimeEmployees_txtb", row_num), "numberOfFullTimeEmployees : ");
			GenericMethods.enter_text(ClearSpringLocators.employeePayroll_txtb, ExcelReader.get_row_data_from_col("employeePayroll_txtb", row_num), "employeePayroll : ");
		}
		else if(employees.equalsIgnoreCase("Employee_No")){
			GenericMethods.click_Element(ClearSpringLocators.employees_NO);
			WaitMethods.wait_in_seconds(2);
		}

		if(subcontractors.equalsIgnoreCase("Subcontractor_Yes"))
		{
			GenericMethods.click_Element(ClearSpringLocators.subcontractors_YES);
			GenericMethods.enter_text(ClearSpringLocators.subcontractorCosts_txtb, ExcelReader.get_row_data_from_col("subcontractorCosts_txtb", row_num), "subcontractorCosts : ");
			GenericMethods.enter_text(ClearSpringLocators.percentageSubcontractorDwelling_txtb, ExcelReader.get_row_data_from_col("percentageSubcontractorDwelling_txtb", row_num), "percentageSubcontractorDwelling : ");
		}
		else if(subcontractors.equalsIgnoreCase("Subcontractor_No")) {
			GenericMethods.click_Element(ClearSpringLocators.subcontractors_NO);
			WaitMethods.wait_in_seconds(2);
		}

		if(residentialWork.equalsIgnoreCase("ResedentialWork_Yes"))
		{
			GenericMethods.click_Element(ClearSpringLocators.residential_work_YES);
			GenericMethods.enter_text(ClearSpringLocators.residential_NEW_txtb, ExcelReader.get_row_data_from_col("residential_NEW_txtb", row_num), "residential_NEW : ");
			GenericMethods.enter_text(ClearSpringLocators.residential_REMODELING_txtb, ExcelReader.get_row_data_from_col("residential_REMODELING_txtb", row_num), "residential_REMODELING : ");
		}
		else if(residentialWork.equalsIgnoreCase("ResedentialWork_No")) {
			GenericMethods.click_Element(ClearSpringLocators.residential_work_NO);
			WaitMethods.wait_in_seconds(2);
		}

		GenericMethods.enter_text(ClearSpringLocators.textarea_txtb, ExcelReader.get_row_data_from_col("textarea_txtb", row_num), "textarea : ");

		GenericMethods.click_Element(ClearSpringLocators.save_continue_btn_page2);

	}

	//Fill details in Page 3 Applicant's Insurance Information

	public static void insuranceInfo_page3_FillDetails(int row_num, String businessHistory)throws IOException, InterruptedException, Exception, AWTException
	{	
		ExcelReader.set_excel_file(Locations.ClearSpringGL_UI_TestData,"InsuranceInfo");

		//ClearSpringLocators.proposedEffectiveDate_txtb.clear();
		//ClearSpringLocators.proposedEffectiveDate_txtb.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, 3, 0, 0, 0));

		GenericMethods.click_Element(ClearSpringLocators.proposedEffectiveDate_txtb);
		WaitMethods.wait_in_seconds(2);
		GenericMethods.click_Element(ClearSpringLocators.nextMonthArrow);WaitMethods.wait_in_seconds(2);
		ClearSpringLocators.days_List.get(1).click();WaitMethods.wait_in_seconds(2);

		if(businessHistory.equalsIgnoreCase("BusinessHistory_YES"))
		{
			GenericMethods.select_from_dropdown(ClearSpringLocators.businessHistory_drpd, "visibletext", "New in business");
			GenericMethods.click_Element(ClearSpringLocators.save_continue_btn_page3);
		}
		else if(businessHistory.equalsIgnoreCase("BusinessHistory_NO")) {

			GenericMethods.select_from_dropdown(ClearSpringLocators.businessHistory_drpd, "visibletext", ExcelReader.get_row_data_from_col("businessHistory_drpd", row_num));
			//GenericMethods.click_Element(ClearSpringLocators.pastClaim_NO);
			//GenericMethods.click_Element(ClearSpringLocators.lapsCoverage_NO);
			GenericMethods.click_Element(ClearSpringLocators.save_continue_btn_page3);
		}
	}

	//Fill details in Page 4 Applicant's Classifications

	public static void classifications_page4_FillDetails(int row_num)throws IOException, InterruptedException, Exception, AWTException
	{	
		ExcelReader.set_excel_file(Locations.ClearSpringGL_UI_TestData,"classCodes");

		GenericMethods.click_Element(ClearSpringLocators.addClassifaction_btn);
		WaitMethods.wait_for_elements_present(ClearSpringLocators.classCode_list);
		GenericMethods.bootstrap_dropdown(ClearSpringLocators.classCode_list,"");


		/*GenericMethods.click_Element(ClearSpringLocators.addAnotherClassifaction_btn);
		GenericMethods.bootstrap_dropdown(ClearSpringLocators.classCode_list,"Carpentry Residential");	

		ClearSpringLocators.classCodePercentage1.clear();
		WaitMethods.wait_in_seconds(2);
		GenericMethods.enter_text(ClearSpringLocators.classCodePercentage1,"visibletext", "50");

		GenericMethods.enter_text(ClearSpringLocators.classCodePercentage2,"visibletext", "50");*/


		GenericMethods.click_Element(ClearSpringLocators.save_continue_btn_page4);
		WaitMethods.wait_in_seconds(10);	
	}

	//Fill details in Page 5 Pricing Options

	public static void pricingOptions_page5_FillDetails(String compair,int row_num)throws IOException, InterruptedException, Exception, AWTException
	{	

		WaitMethods.wait_in_seconds(2);
		WaitMethods.wait_for_element_present(ClearSpringLocators.carrierLogo);

		ExcelReader.set_excel_file(Locations.ClearSpringGL_UI_TestData,"pricingOptions");
		if(compair.equalsIgnoreCase("compairYes"))
		{
			//Limit drpd Assert Limits
			GenericMethods.click_Element(ClearSpringLocators.limits_drpd);
			WaitMethods.wait_in_seconds(2);
			String limitsValue=ClearSpringLocators.limits_drpd.getText();
			Assert.assertEquals(limitsValue,ExcelReader.get_row_data_from_col("limitsValue",row_num));
			WaitMethods.wait_in_seconds(2);

			//Save selected Limit in Excel
			String selctedLimit= GenericMethods.get_selected_optn_frm_ele(ClearSpringLocators.limits_drpd);
			ExcelReader.set_cell_data("selctedLimit", row_num, selctedLimit);

			//Deductible drpd Assert limits
			GenericMethods.click_Element(ClearSpringLocators.deductible_drpd);
			WaitMethods.wait_in_seconds(2);
			String deductibleValue=ClearSpringLocators.deductible_drpd.getText();
			Assert.assertEquals(deductibleValue,ExcelReader.get_row_data_from_col("Deductible",row_num));
			WaitMethods.wait_in_seconds(2);

			//Save selected Deductible in Excel
			String selctedDeductible= GenericMethods.get_selected_optn_frm_ele(ClearSpringLocators.deductible_drpd);
			ExcelReader.set_cell_data("selctedDeductible", row_num, selctedDeductible);

			//Save displayed value Amount
			String amountValue=ClearSpringLocators.amount_Value.getText();
			log.info("Amount value we get ===================== : "+amountValue+ "===============================");
			ExcelReader.set_cell_data("Amount", row_num, amountValue);

			GenericMethods.click_Element(ClearSpringLocators.customize_btn);	
			WaitMethods.wait_in_seconds(5);	
		}
		else if(compair.equalsIgnoreCase("compairNo")) {

			//Limit drpd Assert Limits
			GenericMethods.click_Element(ClearSpringLocators.limits_drpd);
			WaitMethods.wait_in_seconds(2);
			
			//Save selected Limit in Excel
			String selctedLimit= GenericMethods.get_selected_optn_frm_ele(ClearSpringLocators.limits_drpd);
			ExcelReader.set_cell_data("selctedLimit", row_num, selctedLimit);

			//Deductible drpd Assert limits
			GenericMethods.click_Element(ClearSpringLocators.deductible_drpd);
			WaitMethods.wait_in_seconds(2);
			
			//Save selected Deductible in Excel
			String selctedDeductible= GenericMethods.get_selected_optn_frm_ele(ClearSpringLocators.deductible_drpd);
			ExcelReader.set_cell_data("selctedDeductible", row_num, selctedDeductible);

			//Save displayed value Amount
			String amountValue=ClearSpringLocators.amount_Value.getText();
			log.info("Amount value we get ===================== : "+amountValue+ "===============================");
			
			GenericMethods.click_Element(ClearSpringLocators.customize_btn);	
			WaitMethods.wait_in_seconds(5);	

		}
	}

	//Fill details in Page 7 Brpker fee and Enhancements

	public static void brokerFee_Enhancement_page7_FillDetails(int row_num,String checkBoxes,String assertValues)throws IOException, InterruptedException, Exception, AWTException
	{	
		WaitMethods.wait_in_seconds(5);
		ExcelReader.set_excel_file(Locations.ClearSpringGL_UI_TestData,"pricingOptions");
		
		if(assertValues.equalsIgnoreCase("assertValues_yes"))
		{
		//Assert Amount
		String amountValueDisplayed=ClearSpringLocators.AmountPrice_txt.getText();
		Assert.assertEquals(amountValueDisplayed,ExcelReader.get_row_data_from_col("Amount",row_num));
		log.info("========================== Amount Values matched Successfully ==========================");

		//Assert Deductible
		String shownDeductible=GenericMethods.get_selected_optn_frm_ele(ClearSpringLocators.deductible_drpd_page6);
		Assert.assertEquals(shownDeductible,ExcelReader.get_row_data_from_col("selctedDeductible",row_num));
		log.info("==========================  selcted Deductible Values matched Successfully ==========================");

		//Assert Limits
		String shownLimits=GenericMethods.get_selected_optn_frm_ele(ClearSpringLocators.limits_drpd_page6);
		Assert.assertEquals(shownLimits,ExcelReader.get_row_data_from_col("selctedLimit",row_num));
		log.info("==========================  selcted Limits Values matched Successfully ==========================");		
		}
		else if(assertValues.equalsIgnoreCase("assertValues_no"))
		{
			String amountValueDisplayed=ClearSpringLocators.AmountPrice_txt.getText();
			log.info("========================== Amount Values" +amountValueDisplayed+ "==========================");

		}
		GenericMethods.enter_text(ClearSpringLocators.brokerFee_txtb,"50", "Broker Fee : ");
		WaitMethods.wait_in_seconds(2);	

		GenericMethods.click_Element(ClearSpringLocators.deductible_drpd_page6);
		GenericMethods.click_Element(ClearSpringLocators.limits_drpd_page6);

		//Check Boxes check
		if(checkBoxes.equalsIgnoreCase("yes"))
		{
			GenericMethods.click_Element(ClearSpringLocators.preProject_chkb);
			GenericMethods.click_Element(ClearSpringLocators.employeeBenefits_chkb);
			GenericMethods.click_Element(ClearSpringLocators.removeForm49_chkb);
			GenericMethods.click_Element(ClearSpringLocators.terrorCoverage_chkb);
			GenericMethods.click_Element(ClearSpringLocators.scheduledAdditional_chkb);
			GenericMethods.click_Element(ClearSpringLocators.removePrior_chkb);
			WaitMethods.wait_in_seconds(2);	
			GenericMethods.click_Element(ClearSpringLocators.carrierSovent_Yes);
			GenericMethods.click_Element(ClearSpringLocators.removeEarth_chkb);
			WaitMethods.wait_in_seconds(2);	
			GenericMethods.click_Element(ClearSpringLocators.recalculate_btn);
			WaitMethods.wait_in_seconds(10);	
		}
		else if(checkBoxes.equalsIgnoreCase("no")){
			GenericMethods.click_Element(ClearSpringLocators.recalculate_btn);
			WaitMethods.wait_in_seconds(10);	
		}
		
		WaitMethods.wait_in_seconds(2);	
		String amountValueFinal=ClearSpringLocators.AmountPrice_txt.getText();
		log.info("Amount Final value we get ===================== : "+amountValueFinal+ "===============================");
		ExcelReader.set_cell_data("AmountFinal", row_num, amountValueFinal);
		
		WaitMethods.wait_in_seconds(2);
		WaitMethods.wait_for_element_present(ClearSpringLocators.save_continue_btn_page6);
		GenericMethods.scroll_down_to_element(ClearSpringLocators.save_continue_btn_page6);
		GenericMethods.click_Element(ClearSpringLocators.save_continue_btn_page6);
		WaitMethods.wait_in_seconds(5);	

	}

	//==============Eligibility Submit Page 6===========================

	public static void eligibility_submit_page6(String submitTo)throws IOException, InterruptedException, Exception, AWTException
	{	
		WaitMethods.wait_in_seconds(5);
		String subID=ClearSpringLocators.submissionID_onCustomizeTab.getText();
		log.info("================="+subID+"====================");

		if(submitTo.equalsIgnoreCase("UW"))
		{
			GenericMethods.click_Element(ClearSpringLocators.submitNO_radio_btn);
			GenericMethods.scroll_down_to_element(ClearSpringLocators.submitUW_btn);
			GenericMethods.click_Element(ClearSpringLocators.submitUW_btn);
			WaitMethods.wait_in_seconds(2);	
		}
		else if(submitTo.equalsIgnoreCase("coverage"))
		{
			GenericMethods.click_Element(ClearSpringLocators.submitYES_radio_btn);
			GenericMethods.scroll_down_to_element(ClearSpringLocators.submitCustomizeCoverage_btn);
			GenericMethods.click_Element(ClearSpringLocators.submitCustomizeCoverage_btn);
			WaitMethods.wait_in_seconds(2);	
		}

	}

	//=====Verify Thank you page====================
	public static void verify_ThankYou(int row_num)throws IOException, InterruptedException, Exception, AWTException
	{	
		WaitMethods.wait_in_seconds(5);

		ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");

		WaitMethods.wait_in_seconds(2);

		String Final_subID=ClearSpringLocators.submissionId.getText();
		log.info("================="+Final_subID+"====================");

		ExcelReader.set_cell_data("Submission Id", row_num, Final_subID);

		String thaku=ClearSpringLocators.thankU_msg.getText();
		Assert.assertEquals(thaku,"Thank You.");

		log.info("=========================="+Final_subID+"  Sumbmission submited to UW Successfully ==========================");	
		log.info("============ Your clearspring application has been submitted successfully. =================");
		WaitMethods.wait_in_seconds(5);
	}

	//=====Verify Thank you page====================
	public static void verify_ThankYou1(int row_num)throws IOException, InterruptedException, Exception, AWTException
	{	
		WaitMethods.wait_in_seconds(5);

		ExcelReader.set_excel_file(Locations.ClearSpringGL_UI_TestData,"Sheet1");
		WaitMethods.wait_in_seconds(2);
		
		//submissionID_onCustomizeTab
		WaitMethods.wait_for_element_present(ClearSpringLocators.submissionId);
		String Final_subID=ClearSpringLocators.submissionId.getText();
		log.info("================="+Final_subID+"====================");

		ExcelReader.set_cell_data("submissionID", row_num, Final_subID);

		String thaku=ClearSpringLocators.thankU_msg.getText();
		Assert.assertEquals(thaku,"Thank You.");
		
		log.info("=========================="+Final_subID+"  Sumbmission submited to UW Successfully ==========================");	
		log.info("============ Your clearspring application has been submitted successfully. =================");
		WaitMethods.wait_in_seconds(5);
	}

}
