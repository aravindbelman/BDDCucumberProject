package com.BtisNewUI.PageMethods;

import java.awt.AWTException;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;

import com.BtisNewUI.Locators.CBICLocators;
import com.BtisNewUI.Locators.WCnewUILocators;
import com.LegacyApplication.ExcelReader.ExcelReader;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageLocators.GeneralLiabilityPageLocators;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

public class CBIC_UI_Methods extends TestBase {

	public static final Logger log=Logger.getLogger(CBIC_UI_Methods.class.getName());
	public static JavascriptExecutor js;
	
	// Create object of SimpleDateFormat class and decide the format
		static SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		static java.util.Date date= new java.util.Date();
		static String finalDate=dateFormat.format(date);
	/*
	 * Purpose: This method go to Contact Info Page 1
	 * and enter same/Different business and mailing address
	 * & perform Operations
	 * @param String submission_type, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void cbic_Business_MailingAddress(int row_num, String diff_address) throws IOException, InterruptedException, Exception, AWTException
	{   
		WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.general_liablity_button);
		GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.general_liablity_button);
		GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.selectCBIC);
		WaitMethods.wait_in_seconds(2);
		GenericMethods.navigate_to_next_window();


		ExcelReader.set_excel_file(Locations.CBIC_UI_TestData,"contactInfo");
		WaitMethods.wait_in_seconds(2);
		String url=driver.getCurrentUrl();
		log.info("Driver Navigated to:" +url);

		GenericMethods.enter_text(CBICLocators.firstName_txtb,ExcelReader.get_row_data_from_col("FirstName", row_num), "First Name");
		GenericMethods.enter_text(CBICLocators.lastName_txtb,ExcelReader.get_row_data_from_col("LastName", row_num), "Last Name");

		CBICLocators.emailAdd_txtb.sendKeys(GenericMethods.generate_random_integer(900, 100)+ExcelReader.get_row_data_from_col("Email", row_num));
		WaitMethods.wait_in_seconds(1);
		CBICLocators.phone_txtb.sendKeys("9"+GenericMethods.generate_random_integer(900000000, 100000000));
		CBICLocators.cellNumber_txtb.sendKeys("9"+GenericMethods.generate_random_integer(900000000, 100000000));


		CBICLocators.businessAdd_txtb.sendKeys(GenericMethods.generate_random_integer(900, 100),ExcelReader.get_row_data_from_col("BusinessStreet", row_num));
		WaitMethods.wait_in_seconds(2);
		WaitMethods.wait_for_elements_present(CBICLocators.businessAdd_List);
		GenericMethods.bootstrap_dropdown(CBICLocators.businessAdd_List," ");

		if(diff_address.equalsIgnoreCase("same"))
		{	
			WaitMethods.wait_in_seconds(2);
			GenericMethods.is_element_present(CBICLocators.smailBusiness_Mailing_chkb);
			GenericMethods.click_Element_Using_JS(CBICLocators.smailBusiness_Mailing_chkb);
			WaitMethods.wait_in_seconds(2);
		}
		else if(diff_address.equalsIgnoreCase("different"))
		{	
			GenericMethods.enter_text(CBICLocators.mailAddress_txtb,ExcelReader.get_row_data_from_col("MailingStareet", row_num), "Mailing Street");
			GenericMethods.enter_text(CBICLocators.mailingAppt_Suite_txtb,ExcelReader.get_row_data_from_col("MailingApt", row_num), "Mailing Suite");
			GenericMethods.enter_text(CBICLocators.mailCity_txtb,ExcelReader.get_row_data_from_col("MailingCity", row_num), "Mailing City");			
			GenericMethods.select_from_dropdown(CBICLocators.mailState_drpd, "visibletext", ExcelReader.get_row_data_from_col("MailingState", row_num));
			GenericMethods.enter_text(CBICLocators.mailZip_txtb,ExcelReader.get_row_data_from_col("MailingZip", row_num), "Mailing ZipCode");
		}
	}


	/*
	 * Purpose: This method go to Business Info Page 2
	 * & perform Operations
	 * @param String submission_type, integer (Row_number of Excel sheet)
	 * @return NA
	 */

	public static void cbic_BusinessInfo(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{ 	
		ExcelReader.set_excel_file(Locations.CBIC_UI_TestData,"BusinessInfo");
		WaitMethods.wait_in_seconds(2);

		GenericMethods.enter_text(CBICLocators.dba_txtb,ExcelReader.get_row_data_from_col("DBA", row_num), "DBA Name : ");
		CBICLocators.dba_txtb.sendKeys(" "+finalDate);
				
		CBICLocators.contractorLicense.sendKeys("XYZ"+GenericMethods.generate_random_integer(900,100));
		GenericMethods.select_from_dropdown(CBICLocators.stractureType_drpd, "visibletext", ExcelReader.get_row_data_from_col("StractureBusiness", row_num));
		GenericMethods.enter_text(CBICLocators.activeOwners_txt_arrow,ExcelReader.get_row_data_from_col("ActiveOwners", row_num), "Active Owners");
		GenericMethods.enter_text(CBICLocators.anualGross_txtb,ExcelReader.get_row_data_from_col("AnnualGross", row_num), "Annual Gross Value");

		GenericMethods.click_Element_Using_JS(CBICLocators.applicantEmployee_YES);
		GenericMethods.enter_text(CBICLocators.noOfEmployee_txtb,ExcelReader.get_row_data_from_col("applicantEmployee", row_num),"Applicant Employee Value");
		GenericMethods.enter_text(CBICLocators.annualPayroll_txtb,ExcelReader.get_row_data_from_col("annualEmpPayroll", row_num),"Annual Emp Value");

		GenericMethods.click_Element_Using_JS(CBICLocators.subContractors_YES);
		GenericMethods.enter_text(CBICLocators.annualSubcontractingCosts_txtb,ExcelReader.get_row_data_from_col("annualSubContractingCost", row_num), "Annual SubContracting Cost");
		GenericMethods.enter_text(CBICLocators.annualSubcontractingDwellingsPercentage_txtb,ExcelReader.get_row_data_from_col("annualSubcontractingDwellingsPercentage", row_num), "Annual SubContracting DwellingsPercentage");

		GenericMethods.enter_text(CBICLocators.descibeOperations_txtb,ExcelReader.get_row_data_from_col("Description", row_num),"Description");
		//GenericMethods.press_key_using_robot("tab");
		WaitMethods.wait_in_seconds(2);
	}

	/*
	 * Purpose: This method go to Insurance History Page 3
	 * & perform Operations
	 * @param String submission_type, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void cbic_InsuranceHistory(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{	
		ExcelReader.set_excel_file(Locations.CBIC_UI_TestData,"InsuranceHistory");
		WaitMethods.wait_in_seconds(2);
		//CBICLocators.effectiveDate.clear();
		//CBICLocators.effectiveDate.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, 5, 0, 0, 0));
		//GenericMethods.select_from_dropdown(CBICLocators.businessExp_drpd, "visibletext", ExcelReader.get_row_data_from_col("Experience", row_num));

		//GenericMethods.click_Element_Using_JS(CBICLocators.coveragePast_YES);
		//GenericMethods.enter_text(CBICLocators.carrier_txtb,ExcelReader.get_row_data_from_col("CarrierName", row_num),"Carrier Name");
		CBICLocators.expirationDate.clear();
		CBICLocators.expirationDate.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, 5, 0, 0, 0));
		WaitMethods.wait_in_seconds(2);
		
		GenericMethods.select_from_dropdown(CBICLocators.businessYears_drpd, "visibletext", "2 years in business");
		GenericMethods.select_from_dropdown(CBICLocators.industryExp_drpd, "visibletext", "3 years");
	}

	/*
	 * Purpose: This method go to Classification Page 4
	 * & perform Operations
	 * @param String submission_type, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void cbic_Classification(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{
		ExcelReader.set_excel_file(Locations.CBIC_UI_TestData,"Classification");
		WaitMethods.wait_in_seconds(2);

		//for(int i=1;i<4; i++)
		//{
		GenericMethods.click_Element_Using_JS(CBICLocators.addClassification_btn);
		GenericMethods.select_from_dropdown(CBICLocators.newClassification_drpd, "visibletext", ExcelReader.get_row_data_from_col("classList", row_num));	
		WaitMethods.wait_in_seconds(1);
		GenericMethods.click_Element_Using_JS(CBICLocators.addButton_btn);WaitMethods.wait_in_seconds(1);

		/*		GenericMethods.click_Element_Using_JS(CBICLocators.addClassification_btn);
			GenericMethods.select_from_dropdown(CBICLocators.newClassification_drpd, "visibletext", ExcelReader.get_row_data_from_col("classList1", row_num));	
			WaitMethods.wait_in_seconds(1);
			GenericMethods.click_Element_Using_JS(CBICLocators.addButton_btn);WaitMethods.wait_in_seconds(1);

			GenericMethods.click_Element_Using_JS(CBICLocators.addClassification_btn);
			GenericMethods.select_from_dropdown(CBICLocators.newClassification_drpd, "visibletext", ExcelReader.get_row_data_from_col("classList2", row_num));	
			WaitMethods.wait_in_seconds(1);
			GenericMethods.click_Element_Using_JS(CBICLocators.addButton_btn);WaitMethods.wait_in_seconds(1);
		//}

		GenericMethods.enter_text(CBICLocators.percent1_txtb,ExcelReader.get_row_data_from_col("Percentage1", row_num),"Percentage Value");
		GenericMethods.enter_text(CBICLocators.percent2_txtb,ExcelReader.get_row_data_from_col("Percentage2", row_num),"Percentage Value");
		GenericMethods.enter_text(CBICLocators.percent3_txtb,ExcelReader.get_row_data_from_col("Percentage3", row_num),"Percentage Value");
		GenericMethods.press_key_using_robot("tab");WaitMethods.wait_in_seconds(2);     */
	}

	/*
	 * Purpose: This method go to Pricing Page 5
	 * & perform Operations to store Value
	 * @param String submission_type, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void cbic_pricing(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{
		ExcelReader.set_excel_file(Locations.CBIC_UI_TestData,"pricing");
		WaitMethods.wait_in_seconds(2);
		String pricingValues=GenericMethods.get_text(CBICLocators.pricingOptions_value);
		log.info("=============================="+ pricingValues +"=========================================");
		ExcelReader.set_cell_data("pricingValue", row_num, pricingValues);	WaitMethods.wait_in_seconds(2);
	}

	/*
	 * Purpose: This method go to Supplemental Page 6
	 * & perform Operations to store Value
	 * @param String submission_type, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void cbic_Supplemental(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{
		ExcelReader.set_excel_file(Locations.CBIC_UI_TestData,"supplementalPage");
		WaitMethods.wait_in_seconds(2);

		GenericMethods.select_from_dropdown(CBICLocators.businessExp_drpd, "visibletext","1");	
		GenericMethods.select_from_dropdown(CBICLocators.constructionExperience_drpd, "visibletext", ExcelReader.get_row_data_from_col("constructionExperience", row_num));
		GenericMethods.enter_text(CBICLocators.priorConstructionExperience_txt,ExcelReader.get_row_data_from_col("priorConstructionExperience", row_num),"priorConstructionExperience Text : ");

		GenericMethods.click_Element_Using_JS(CBICLocators.applicantWorkOutOfState_Yes);
		GenericMethods.enter_text(CBICLocators.workOutOfStateStates_txt,ExcelReader.get_row_data_from_col("workOutOfStateStates", row_num),"Work Out Of State States Text : ");

		GenericMethods.enter_text(CBICLocators.residentailWorkPercentage_txtb,ExcelReader.get_row_data_from_col("residentailWorkPercentage", row_num),"residentailWorkPercentage ");
		GenericMethods.enter_text(CBICLocators.commercialWorkPercentage_txtb,ExcelReader.get_row_data_from_col("commercialWorkPercentage", row_num),"commercialWorkPercentage ");
		GenericMethods.enter_text(CBICLocators.industrialWorkPercentage_txtb,ExcelReader.get_row_data_from_col("industrialWorkPercentage", row_num),"industrialWorkPercentage ");
		GenericMethods.enter_text(CBICLocators.manufacturingWorkPercentage_txtb,ExcelReader.get_row_data_from_col("manufacturingWorkPercentage", row_num),"manufacturingWorkPercentage ");
		GenericMethods.enter_text(CBICLocators.newConstructionTypePercentage_txtb,ExcelReader.get_row_data_from_col("newConstructionTypePercentage", row_num),"newConstructionTypePercentage ");
		GenericMethods.enter_text(CBICLocators.remodelTypePercentage_txt,ExcelReader.get_row_data_from_col("remodelTypePercentage", row_num),"remodelTypePercentage ");
		GenericMethods.enter_text(CBICLocators.serviceRepairTypePercentage_txtb,ExcelReader.get_row_data_from_col("serviceRepairTypePercentage", row_num),"serviceRepairTypePercentage ");

		//GenericMethods.click_Element_Using_JS(CBICLocators.planToUseSubcontaractorNxtYear_Yes_btn);
		//GenericMethods.enter_text(CBICLocators.useSubcontractorsNextYearTrades_txtb,ExcelReader.get_row_data_from_col("useSubcontractorsNextYearTrades", row_num),"useSubcontractorsNextYearTrades ");

		/*CBICLocators.carrierInfo1StartDate_txtb.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0,-100, 0, 0, 0));
		CBICLocators.carrierInfo1EndDate_txtb.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0,265, 0, 0, 0));
		GenericMethods.enter_text(CBICLocators.carrierInfo1Name_txtb,ExcelReader.get_row_data_from_col("Carrier1", row_num),"Carrier1 ");
		GenericMethods.enter_text(CBICLocators.carrierInfo1PolicyNumber_txtb,ExcelReader.get_row_data_from_col("Policy Number1", row_num),"Policy Number1");

		CBICLocators.carrierInfo2StartDate_txtb.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0,-200, 0, 0, 0));
		CBICLocators.carrierInfo2EndDate_txtb.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0,165, 0, 0, 0));
		GenericMethods.enter_text(CBICLocators.carrierInfo2Name_txtb,ExcelReader.get_row_data_from_col("Carrier2", row_num),"Carrier2 ");
		GenericMethods.enter_text(CBICLocators.carrierInfo2PolicyNumber_txtb,ExcelReader.get_row_data_from_col("Policy Number2", row_num),"Policy Number2");

		CBICLocators.carrierInfo3StartDate_txtb.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, 0, 0, 0, 0));
		CBICLocators.carrierInfo3EndDate_txtb.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0,300, 0, 0, 0));
		GenericMethods.enter_text(CBICLocators.carrierInfo3Name_txtb,ExcelReader.get_row_data_from_col("Carrier3", row_num),"Carrier3 ");
		GenericMethods.enter_text(CBICLocators.carrierInfo3PolicyNumber_txtb,ExcelReader.get_row_data_from_col("Policy Number3", row_num),"Policy Number3");
		 */

		//GenericMethods.enter_text(CBICLocators.useSubcontractorsNextYearTrades_txtb,ExcelReader.get_row_data_from_col("useSubcontractorsNextYearTrades", row_num),"useSubcontractorsNextYearTrades");

		GenericMethods.click_Element_Using_JS(CBICLocators.Concrete_chkb);
		GenericMethods.click_Element_Using_JS(CBICLocators.Drywall_chkb);
		GenericMethods.click_Element_Using_JS(CBICLocators.Electrical_chkb);


		GenericMethods.click_Element_Using_JS(CBICLocators.subcontractorCompliance1_chkb);
		GenericMethods.click_Element_Using_JS(CBICLocators.subcontractorCompliance2_chkb);
		GenericMethods.click_Element_Using_JS(CBICLocators.subcontractorCompliance3_chkb);

		GenericMethods.click_Element_Using_JS(CBICLocators.applicantHadAnyPrioeClaim_No_btn);

		GenericMethods.enter_text(CBICLocators.largestJob1Year_txtb,ExcelReader.get_row_data_from_col("largestJob1Year", row_num),"largestJob1Year  ");
		GenericMethods.enter_text(CBICLocators.largestJob1Description_txtb,ExcelReader.get_row_data_from_col("largestJob1Description", row_num),"largestJob1Description  ");
		GenericMethods.enter_text(CBICLocators.largestJob1Receipts_txtb,ExcelReader.get_row_data_from_col("largestJob1Receipts", row_num),"largestJob1Receipts  ");

		GenericMethods.enter_text(CBICLocators.largestJob2Year_txtb,ExcelReader.get_row_data_from_col("largestJob2Year", row_num),"largestJob2Year  ");
		GenericMethods.enter_text(CBICLocators.largestJob2Description_txtb,ExcelReader.get_row_data_from_col("largestJob2Description", row_num),"largestJob2Description  ");
		GenericMethods.enter_text(CBICLocators.largestJob2Receipts_txtb,ExcelReader.get_row_data_from_col("largestJob2Receipts", row_num),"largestJob2Receipts  ");

		GenericMethods.enter_text(CBICLocators.largestJob3Year_txtb,ExcelReader.get_row_data_from_col("largestJob3Year", row_num),"largestJob3Year  ");
		GenericMethods.enter_text(CBICLocators.largestJob3Description_txtb,ExcelReader.get_row_data_from_col("largestJob3Description", row_num),"largestJob3Description  ");
		GenericMethods.enter_text(CBICLocators.largestJob3Receipts_txtb,ExcelReader.get_row_data_from_col("largestJob3Receipts", row_num),"largestJob3Receipts  ");

		GenericMethods.click_Element_Using_JS(CBICLocators.constructionConsultant_chkb);
		GenericMethods.click_Element_Using_JS(CBICLocators.developer_chkb);
		GenericMethods.click_Element_Using_JS(CBICLocators.developerOfLandOnly_chkb);
		GenericMethods.click_Element_Using_JS(CBICLocators.hiredby_chkb);
		GenericMethods.click_Element_Using_JS(CBICLocators.propertyOwner_chkb);
		GenericMethods.click_Element_Using_JS(CBICLocators.subcontractors_chkb);
		GenericMethods.click_Element_Using_JS(CBICLocators.speculative_builder_chkb);
		GenericMethods.click_Element_Using_JS(CBICLocators.performing_one_two_chkb);

		GenericMethods.enter_text(CBICLocators.Totaljobscompletedannually_txtb,ExcelReader.get_row_data_from_col("Total jobs completed annually", row_num),"Total jobs completed annually  ");
		GenericMethods.enter_text(CBICLocators.Newhomesbuilt_txtb,ExcelReader.get_row_data_from_col("New homes built in any one tract", row_num),"New homes built in any one tract  ");
		GenericMethods.enter_text(CBICLocators.Hospitals_txtb,ExcelReader.get_row_data_from_col("Hospitals, clinics and assisted living facilities", row_num),"Hospitals, clinics and assisted living facilities  ");
		GenericMethods.enter_text(CBICLocators.Exteriorjobsover_txtb,ExcelReader.get_row_data_from_col("Exterior jobs over 3 stories", row_num),"Exterior jobs over 3 stories ");
		GenericMethods.enter_text(CBICLocators.Jobsrunningatonetime_txtb,ExcelReader.get_row_data_from_col("Jobs running at one time", row_num),"Jobs running at one time ");
		GenericMethods.enter_text(CBICLocators.Totalnewhomesbuilt_txtb,ExcelReader.get_row_data_from_col("Total new homes built", row_num),"Total new homes built  ");
		GenericMethods.enter_text(CBICLocators.townhomes_txtb,ExcelReader.get_row_data_from_col("Townhomes", row_num),"Townhomes ");
		GenericMethods.enter_text(CBICLocators.jobsonhomesvaluedovermillion_txtb,ExcelReader.get_row_data_from_col("Jobs on homes valued over", row_num),"Jobs on homes valued over  ");
		GenericMethods.enter_text(CBICLocators.airportsoraerospacefacilities_txtb,ExcelReader.get_row_data_from_col("Airports or aerospace facilities", row_num),"Airports or aerospace facilities  ");
		GenericMethods.press_key_using_robot("tab");WaitMethods.wait_in_seconds(2);
	}
	/*
	 * Purpose: This method go to SuccessPage No 7
	 * & perform Operations to store Value
	 * @param String submission_type, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void cbic_successPage(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{	

		ExcelReader.set_excel_file(Locations.CBIC_UI_TestData,"QuoteNoValue");
		WaitMethods.wait_in_seconds(2);

		if(CBICLocators.SuccesMsg_confirm_msg.getText().equalsIgnoreCase("Thank You. Your CBIC application has been submitted successfully."))
		{
			log.info("CBIC application submitted -Successfully");
		}else {
			log.info("Something went wrong - Fail");
		}

		String quote=CBICLocators.quote_msg.getText();
		String[] quoteNo=quote.split(" "); 
		WaitMethods.wait_in_seconds(2);
		log.info("===================================="+ quoteNo[3] +"===========================================");
		ExcelReader.set_cell_data("QuoteValue", row_num, quoteNo[3]);

	}
}
