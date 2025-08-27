package com.BtisNewUI.PageMethods;

import java.awt.AWTException;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;

import com.BtisNewUI.Locators.CBIC_NewLocators;
import com.LegacyApplication.ExcelReader.ExcelReader;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageLocators.GeneralLiabilityPageLocators;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

public class CBIC_New_UI_Methods extends TestBase{

	public static final Logger log=Logger.getLogger(CBIC_New_UI_Methods.class.getName());
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

		GenericMethods.enter_text(CBIC_NewLocators.firstName_txtb,ExcelReader.get_row_data_from_col("FirstName", row_num), "First Name");
		GenericMethods.enter_text(CBIC_NewLocators.lastName_txtb,ExcelReader.get_row_data_from_col("LastName", row_num), "Last Name");

		CBIC_NewLocators.businessAdd_txtb.sendKeys(GenericMethods.generate_random_integer(900, 100),ExcelReader.get_row_data_from_col("BusinessStreet", row_num));
		WaitMethods.wait_in_seconds(2);
		WaitMethods.wait_for_elements_present(CBIC_NewLocators.businessAdd_List);
		GenericMethods.bootstrap_dropdown(CBIC_NewLocators.businessAdd_List," ");

		if(diff_address.equalsIgnoreCase("same"))
		{	
			WaitMethods.wait_in_seconds(2);
			GenericMethods.is_element_present(CBIC_NewLocators.smailBusiness_Mailing_chkb);
			GenericMethods.click_Element_Using_JS(CBIC_NewLocators.smailBusiness_Mailing_chkb);
			WaitMethods.wait_in_seconds(2);
		}
		else if(diff_address.equalsIgnoreCase("different"))
		{	
			GenericMethods.enter_text(CBIC_NewLocators.mailAddress_txtb,ExcelReader.get_row_data_from_col("MailingStareet", row_num), "Mailing Street");
			GenericMethods.enter_text(CBIC_NewLocators.mailingAppt_Suite_txtb,ExcelReader.get_row_data_from_col("MailingApt", row_num), "Mailing Suite");
			GenericMethods.enter_text(CBIC_NewLocators.mailCity_txtb,ExcelReader.get_row_data_from_col("MailingCity", row_num), "Mailing City");			
			GenericMethods.select_from_dropdown(CBIC_NewLocators.mailState_drpd, "visibletext", ExcelReader.get_row_data_from_col("MailingState", row_num));
			GenericMethods.enter_text(CBIC_NewLocators.mailZip_txtb,ExcelReader.get_row_data_from_col("MailingZip", row_num), "Mailing ZipCode");
		}

		CBIC_NewLocators.emailAdd_txtb.sendKeys(GenericMethods.generate_random_integer(900, 100)+ExcelReader.get_row_data_from_col("Email", row_num));
		WaitMethods.wait_in_seconds(1);
		CBIC_NewLocators.phone_txtb.sendKeys("9"+GenericMethods.generate_random_integer(900000000, 100000000));
		CBIC_NewLocators.cellNumber_txtb.sendKeys("9"+GenericMethods.generate_random_integer(900000000, 100000000));
	}

	/*
	 * Purpose: This method go to Classification Page 2
	 * & perform Operations
	 * @param String submission_type, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void cbic_Classification(int row_num,String classCode) throws IOException, InterruptedException, Exception, AWTException
	{
		ExcelReader.set_excel_file(Locations.CBIC_UI_TestData,"Classification");
		WaitMethods.wait_in_seconds(2);

		if(classCode.equalsIgnoreCase("double"))
		{
			GenericMethods.click_Element_Using_JS(CBIC_NewLocators.addClassification_btn);
			WaitMethods.wait_for_elements_present(CBIC_NewLocators.classCode_list);
			GenericMethods.bootstrap_dropdown(CBIC_NewLocators.classCode_list,"");

			GenericMethods.click_Element_Using_JS(CBIC_NewLocators.addClassification_btn);
			WaitMethods.wait_for_elements_present(CBIC_NewLocators.classCode_list);
			GenericMethods.bootstrap_dropdown(CBIC_NewLocators.classCode_list,"Drywall");

			CBIC_NewLocators.percentage_1_txtb.clear();
			CBIC_NewLocators.percentage_1_txtb.sendKeys("50");
			CBIC_NewLocators.percentage_2_txtb.clear();
			CBIC_NewLocators.percentage_2_txtb.sendKeys("50");
			WaitMethods.wait_in_seconds(2);

			GenericMethods.click_Element(CBIC_NewLocators.addClassification_btn);
			GenericMethods.click_Element(CBIC_NewLocators.addClassification_btn);
		}
		else if(classCode.equalsIgnoreCase("single"))
		{
			GenericMethods.click_Element_Using_JS(CBIC_NewLocators.addClassification_btn);
			WaitMethods.wait_for_elements_present(CBIC_NewLocators.classCode_list);
			GenericMethods.bootstrap_dropdown(CBIC_NewLocators.classCode_list,"");

			CBIC_NewLocators.percentage_1_txtb.clear();
			CBIC_NewLocators.percentage_1_txtb.sendKeys("100");WaitMethods.wait_in_seconds(2);

			GenericMethods.click_Element(CBIC_NewLocators.addClassification_btn);
			GenericMethods.click_Element(CBIC_NewLocators.addClassification_btn);
		}
	}

	/*
	 * Purpose: This method go to Business Info Page 3
	 * & perform Operations
	 * @param String submission_type, integer (Row_number of Excel sheet)
	 * @return NA
	 */

	public static void cbic_BusinessInfo(int row_num,String flow) throws IOException, InterruptedException, Exception, AWTException
	{ 	
		ExcelReader.set_excel_file(Locations.CBIC_UI_TestData,"BusinessInfo");
		WaitMethods.wait_in_seconds(2);

		GenericMethods.enter_text(CBIC_NewLocators.dba_name,ExcelReader.get_row_data_from_col("DBA", row_num), "DBA Name : ");
		CBIC_NewLocators.dba_name.sendKeys(" "+finalDate);
		CBIC_NewLocators.contractorLicense_txtb.sendKeys("XYZ"+GenericMethods.generate_random_integer(900,100));
		GenericMethods.select_from_dropdown(CBIC_NewLocators.business_stracture_drpd, "visibletext", ExcelReader.get_row_data_from_col("StractureBusiness", row_num));
		GenericMethods.enter_text(CBIC_NewLocators.activeOwners_txtb,ExcelReader.get_row_data_from_col("ActiveOwners", row_num), "Active Owners");
		GenericMethods.enter_text(CBIC_NewLocators.annualGrossReceipts_txtb,ExcelReader.get_row_data_from_col("AnnualGross", row_num), "Annual Gross Value");

		if(flow.equalsIgnoreCase("complete"))
		{
			GenericMethods.click_Element_Using_JS(CBIC_NewLocators.haveEmployees_YES);
			GenericMethods.enter_text(CBIC_NewLocators.numberOfEmployees_txtb,ExcelReader.get_row_data_from_col("applicantEmployee", row_num),"Applicant Employee Value");
			GenericMethods.enter_text(CBIC_NewLocators.annualEmployeePayroll_txtb,ExcelReader.get_row_data_from_col("annualEmpPayroll", row_num),"Annual Emp Value");

			GenericMethods.click_Element_Using_JS(CBIC_NewLocators.hireSubcontractor_Yes);
			GenericMethods.enter_text(CBIC_NewLocators.annualSubcontractingCosts_txtb,ExcelReader.get_row_data_from_col("annualSubContractingCost", row_num), "Annual SubContracting Cost");
			GenericMethods.enter_text(CBIC_NewLocators.annualSubcontractingDwellingsPercentage_txtb,ExcelReader.get_row_data_from_col("annualSubcontractingDwellingsPercentage", row_num), "Annual SubContracting DwellingsPercentage");

			GenericMethods.click_Element_Using_JS(CBIC_NewLocators.performResidential_Yes);
			CBIC_NewLocators.constructionZoneNewPercentage_txtb.sendKeys("50");
			CBIC_NewLocators.constructionZoneRemodelingPercentage_txtb.sendKeys("50");
		}
		else if(flow.equalsIgnoreCase("normal"))
		{
			GenericMethods.click_Element_Using_JS(CBIC_NewLocators.haveEmployees_NO);
			GenericMethods.click_Element_Using_JS(CBIC_NewLocators.hireSubcontractor_NO);
			GenericMethods.click_Element_Using_JS(CBIC_NewLocators.performResidential_NO);
		}

		GenericMethods.enter_text(CBIC_NewLocators.descriptionOfOperations_txtb,ExcelReader.get_row_data_from_col("Description", row_num),"Description");
		WaitMethods.wait_in_seconds(2);
	}

	/*
	 * Purpose: This method go to Insurance History Page 4
	 * & perform Operations
	 * @param String submission_type, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void cbic_InsuranceHistory(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{	
		ExcelReader.set_excel_file(Locations.CBIC_UI_TestData,"InsuranceHistory");
		WaitMethods.wait_in_seconds(2);
		CBIC_NewLocators.expirationDate.clear();
		CBIC_NewLocators.expirationDate.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, 5, 0, 0, 0));
		WaitMethods.wait_in_seconds(2);

		GenericMethods.select_from_dropdown(CBIC_NewLocators.businessYears_drpd, "visibletext", "5+ years in business");
		GenericMethods.select_from_dropdown(CBIC_NewLocators.industryExp_drpd, "visibletext", "5+ years");
	}

	/*
	 * Purpose: This method go to Pricing Page 5
	 * & perform Operations to store Value
	 * @param String submission_type, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void cbic_pricing(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{
		GenericMethods.is_element_present(CBIC_NewLocators.pricingOptions_value);
		ExcelReader.set_excel_file(Locations.CBIC_UI_TestData,"pricing");
		WaitMethods.wait_in_seconds(2);
		String pricingValues=GenericMethods.get_text(CBIC_NewLocators.pricingOptions_value);
		log.info("=============================="+ pricingValues +"=========================================");
		ExcelReader.set_cell_data("pricingValue", row_num, pricingValues);	WaitMethods.wait_in_seconds(2);
	}

	/*
	 * Purpose: This method go to Supplemental Page 6
	 * & perform Operations to store Value
	 * @param String submission_type, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void cbic_Supplemental(String subcontractor) throws IOException, InterruptedException, Exception, AWTException
	{		
		String price=CBIC_NewLocators.priceShown.getText();
		log.info("==================================Displayed: "+ price +"=====================================");

		GenericMethods.enter_text(CBIC_NewLocators.residentailWorkPercentage_txtb, "50", "ResidentailWorkPercentage");
		GenericMethods.enter_text(CBIC_NewLocators.commercialWorkPercentage_txtb, "50", "CommercialWorkPercentage");
		//GenericMethods.enter_text(CBIC_NewLocators.industrialWorkPercentage_txtb, "25", "IndustrialWorkPercentage");
		//GenericMethods.enter_text(CBIC_NewLocators.manufacturingWorkPercentage_txtb, "25", "ManufacturingWorkPercentage");

		GenericMethods.enter_text(CBIC_NewLocators.newConstructionTypePercentage_txtb, "50", "NewConstructionTypePercentage");
		GenericMethods.enter_text(CBIC_NewLocators.remodelTypePercentage_txtb, "50", "ConstructionZoneRemodelingPercentage");

		if(subcontractor.equalsIgnoreCase("sub_Yes"))
		{
			GenericMethods.click_Element(CBIC_NewLocators.Concrete_chkb);
			GenericMethods.click_Element(CBIC_NewLocators.Drywall_chkb);

			GenericMethods.click_Element(CBIC_NewLocators.subcontractorCompliance1_chkb);
			GenericMethods.click_Element(CBIC_NewLocators.subcontractorCompliance2_chkb);
			GenericMethods.click_Element(CBIC_NewLocators.subcontractorCompliance3_chkb);

			GenericMethods.click_Element(CBIC_NewLocators.priorClaims_No);

			GenericMethods.click_Element(CBIC_NewLocators.aadInsEndorse_Yes);
			GenericMethods.click_Element(CBIC_NewLocators.inlandMarine_Yes);

			GenericMethods.click_Element(CBIC_NewLocators.recalculate_btn);WaitMethods.wait_in_seconds(2);

		}
		else if(subcontractor.equalsIgnoreCase("sub_No"))
		{
			GenericMethods.click_Element(CBIC_NewLocators.priorClaims_No);

			GenericMethods.click_Element(CBIC_NewLocators.aadInsEndorse_Yes);
			GenericMethods.click_Element(CBIC_NewLocators.inlandMarine_No);

			GenericMethods.click_Element(CBIC_NewLocators.recalculate_btn);WaitMethods.wait_in_seconds(2);
		}
		String priceUpdate=CBIC_NewLocators.priceShown.getText();WaitMethods.wait_in_seconds(2);
		log.info("==================================Updated Price : "+ priceUpdate +"=====================================");

		GenericMethods.scroll_down_to_element(CBIC_NewLocators.bi_save_contiunue_btn);
		WaitMethods.wait_in_seconds(2);
	}

	/*
	 * Purpose: This method go to general Question page 7
	 * @return NA
	 */
	public static void cbic_generalQuestions() throws IOException, InterruptedException, Exception, AWTException
	{
		GenericMethods.click_Element(CBIC_NewLocators.workOutOfState_No);
		GenericMethods.click_Element(CBIC_NewLocators.affiliatedAnotherCompany_No);
		GenericMethods.click_Element(CBIC_NewLocators.checkIfNone_chkb);
	}

	/*
	 * Purpose: This method go to Class Code Questions page 8 for Class code 911
	 * Air Conditioner
	 * @return NA
	 */
	public static void cbic_classCodeQuestionsfor_9111(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{	
		ExcelReader.set_excel_file(Locations.CBIC_UI_TestData,"classCodePage");
		WaitMethods.wait_in_seconds(2);

		GenericMethods.enter_text(CBIC_NewLocators.coller_txtb,ExcelReader.get_row_data_from_col("coller_txtb", row_num), "coller");
		GenericMethods.enter_text(CBIC_NewLocators.exterior_txtb, ExcelReader.get_row_data_from_col("exterior_txtb", row_num), "exterior");
		GenericMethods.enter_text(CBIC_NewLocators.installation_txtb,ExcelReader.get_row_data_from_col("installation_txtb", row_num), "installation");
		GenericMethods.enter_text(CBIC_NewLocators.lpg_txtb, ExcelReader.get_row_data_from_col("lpg_txtb", row_num), "lpg");
		GenericMethods.enter_text(CBIC_NewLocators.roof_txtb, ExcelReader.get_row_data_from_col("roof_txtb", row_num), "roof");
		GenericMethods.enter_text(CBIC_NewLocators.servicesPer_txtb, ExcelReader.get_row_data_from_col("servicesPer_txtb", row_num), "servicesPer");
		GenericMethods.enter_text(CBIC_NewLocators.solarHeating_txtb, ExcelReader.get_row_data_from_col("solarHeating_txtb", row_num), "solarHeating");
		GenericMethods.enter_text(CBIC_NewLocators.woodstove_txtb,ExcelReader.get_row_data_from_col("woodstove_txtb", row_num), "woodstove");

		GenericMethods.click_Element(CBIC_NewLocators.listOfOtherServices_chkb_9111);
		GenericMethods.click_Element(CBIC_NewLocators.doesTheInsuredSell_No);

	}

	/*
	 * Purpose: This method go to Class Code Questions page 8 for Class code 92338
	 * DryWall
	 * @return NA
	 */
	public static void cbic_classCodeQuestionsfor_92338() throws IOException, InterruptedException, Exception, AWTException
	{	
		GenericMethods.enter_text(CBIC_NewLocators.exterior_plastering_txtb, "2", "Exterior plastering");
		GenericMethods.click_Element(CBIC_NewLocators.listOfOtherServices_chkb_92338);
		GenericMethods.click_Element(CBIC_NewLocators.noExteriorDrywall_chkb);
	}


	/*
	 * Purpose: This method go to Display Thank you page and Submission ID.
	 * @return NA
	 */
	public static void cbic_ID_status_QCGL(String pdf) throws IOException, InterruptedException, Exception, AWTException
	{	
		
		if(pdf.equalsIgnoreCase("pdfYes"))
		{
			WaitMethods.wait_for_element_present(CBIC_NewLocators.qcgl_ID);
			String id=CBIC_NewLocators.qcgl_ID.getText();
			log.info("============================= "+id+ " =================================");

			String status=CBIC_NewLocators.qcgl_STATUS.getText();
			log.info("========================== The Status of your " +id+ " is "  +status+ " =================================");

			WaitMethods.wait_in_seconds(2);
			
			CBIC_NewLocators.qcgl_application_link.click();
			WaitMethods.wait_in_seconds(2);
			GenericMethods.navigate_to_next_window();WaitMethods.wait_in_seconds(2);
		}
		else if(pdf.equalsIgnoreCase("pdfNo"))
		{
			WaitMethods.wait_for_element_present(CBIC_NewLocators.qcgl_ID);
			String id=CBIC_NewLocators.qcgl_ID.getText();
			log.info("============================= "+id+ " =================================");

			String status=CBIC_NewLocators.qcgl_STATUS.getText();
			log.info("========================== The Status of your " +id+ " is "  +status+ " =================================");

			WaitMethods.wait_in_seconds(2);
		}
	}

	/*
	 * Purpose: This method go to UW url with help of Submission ID.
	 * as per On going environment.
	 * @return NA
	 */
	public static void navigate_UW_URL() throws IOException, InterruptedException, Exception, AWTException
	{	
		WaitMethods.wait_for_element_present(CBIC_NewLocators.qcgl_ID);
		String id=CBIC_NewLocators.qcgl_ID.getText();

		if(driver.getCurrentUrl().contains("test"))
		{
			GenericMethods.navigate_to_url("https://cbic-test.btisinc.com/?userKey=WHDYsALb0lL_BrmVpOecEMXIu0WmpU0MVgWsdpiBqncG3j_4ieZ-J8BHiAWxvptTw0TO-Z0YyMmd2Xxp6y4DoOpuW0eZFuAGKbk--LtrTIsYJEOOKfCl9D2O6d2xj0CVHT_FKZvhjTtlmG7ez5ymgNK5a98NhdgEwyJFlHw12TRl77NLDZd-FHC3BBqubqjDJ1nPUv9Gi1aLMPQh9qpnkMRvRLs6bWsD2SkyQsjQAo6sM3dUtTRMJs6xW0knwljVgvoeqp2J_VhuqUVCu6ZhLk0kuw-0KQrg2iD_ZzLV5aoGWV1Y3NFR7PQO5DpFjzXzBDTVKGBW2xk8fuBEcvNgVA&submissionId=**"+id+"&role=UW");
		}
		else if(driver.getCurrentUrl().contains("sandbox"))
		{
			GenericMethods.navigate_to_url("https://cbic-sandbox.btisinc.com/?userKey=Se0rLsYasSaGIVIyhRiHsvlyeQsx-CYDuV6aEvN52wLgjujjm4HhTsqLtN8bNlCM7ddOGDIEFs7bXt6knASZM7ARgnd5kjVu7RiExBxrMQrVDLSTUr0AckxVRtghkyDk2iizpKgT975cs4TyzRTvkSgCDw4VzOI84-CpDbTjahTwqXPAHQWEBsFR3ytxoKpgZ1XuW5MA-KDM7LzI7VNI7bz9DvGOqSknG0iR6yNgE2PNjQ80D0LNYrBjYcrfsWLcg48XRfZysNZMNNFfWksCy2S8UNkPdQeCNMxApl4TUMedB9_B0lB3gDQJzztnSlOgC3PpAGhgzNkui7KraPRvfA&submissionId=**"+id+"&role=UW");
		}
		else if(driver.getCurrentUrl().contains("dev"))
		{
			GenericMethods.navigate_to_url("https://cbic-dev.btisinc.com/?userKey="+id+"&role=UW");
		}			
	}

	/*
	 * Purpose: This method to update_CBIC_submission by access UW url
	 * as per On going environment.
	 * WITH PARAMETER AS -- normal_flow or update_flow
	 * @return NA
	 */
	public static void update_CBIC_submission(String flow) throws IOException, InterruptedException, Exception, AWTException
	{	
		WaitMethods.wait_in_seconds(2);

		GenericMethods.enter_text(CBIC_NewLocators.uwEmailId_txt, "vpandey@btisinc.com", "UW's Email Address");
		GenericMethods.is_element_present(CBIC_NewLocators.save_contiunue_btn_uw);
		GenericMethods.click_Element(CBIC_NewLocators.save_contiunue_btn_uw);

		if(flow.equalsIgnoreCase("normal_flow"))
		{

			WaitMethods.wait_in_seconds(2);

			GenericMethods.click_Element(CBIC_NewLocators.save_contiunue_btn);WaitMethods.wait_in_seconds(2);
			GenericMethods.click_Element(CBIC_NewLocators.bi_save_contiunue_btn);WaitMethods.wait_in_seconds(2);
			GenericMethods.click_Element(CBIC_NewLocators.bi_save_contiunue_btn);WaitMethods.wait_in_seconds(2);
			GenericMethods.click_Element(CBIC_NewLocators.bi_save_contiunue_btn);WaitMethods.wait_in_seconds(5);

			GenericMethods.click_Element(CBIC_NewLocators.submitQuote_btn1);WaitMethods.wait_in_seconds(2);

			GenericMethods.click_Element(CBIC_NewLocators.bi_save_contiunue_btn);WaitMethods.wait_in_seconds(2);
			GenericMethods.click_Element(CBIC_NewLocators.save_contiunue_btn);WaitMethods.wait_in_seconds(2);

			GenericMethods.click_Element(CBIC_NewLocators.submit_CBIC_btn);WaitMethods.wait_in_seconds(5);
		}
		else if(flow.equalsIgnoreCase("update_flow"))
		{

		}

	}

}
