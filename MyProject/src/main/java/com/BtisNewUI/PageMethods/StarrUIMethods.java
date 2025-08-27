package com.BtisNewUI.PageMethods;

import java.awt.AWTException;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.BtisNewUI.Locators.StarrUILocators;
import com.BtisNewUI.Locators.WCnewUILocators;
import com.LegacyApplication.ExcelReader.ExcelReader;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageLocators.AdminPageLocators;
import com.LegacyApplication.PageLocators.AdminSubmissionPageLocators;
import com.LegacyApplication.PageLocators.AutoRenewalBrokerFeeLocators;
import com.LegacyApplication.PageLocators.DefaultBrokerFeeLocators;
import com.LegacyApplication.PageLocators.GeneralLiabilityPageLocators;
import com.LegacyApplication.PageLocators.WorkersCompLocators;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

public class StarrUIMethods extends TestBase{

	public static final Logger log=Logger.getLogger(StarrUIMethods.class.getName());
	public static JavascriptExecutor js;

	/*
	 * Purpose: This method go to LetsGetStarted page 
	 * & perform Operations
	 * @param String submission_type, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void LetsGetStarted(int row_num, String submission_type) throws IOException, InterruptedException, Exception, AWTException
	{   

		ExcelReader.set_excel_file(Locations.StarUI_TestData,"LetsGetStarted");
		WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.general_liablity_button);
		GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.general_liablity_button);
		GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.starr_marine);

		WaitMethods.wait_in_seconds(2);
		GenericMethods.navigate_to_next_window();
		String url=driver.getCurrentUrl();
		log.info("Driver Navigated to " +url); 

		if(submission_type.equalsIgnoreCase("Marine"))
		{
			GenericMethods.click_Element_Using_JS(StarrUILocators.get_Marine_Quote_btn);
		}
		else if(submission_type.equalsIgnoreCase("SmallMarine"))
		{
			GenericMethods.click_Element_Using_JS(StarrUILocators.get_SmallMarine_Quote_btn);	
		}	

		GenericMethods.is_element_present(StarrUILocators.select_a_class_drpDwn);
		String selectedSubmission=GenericMethods.get_selected_optn_frm_ele(StarrUILocators.select_a_class_drpDwn);
		ExcelReader.set_cell_data("SubmissionType", row_num, selectedSubmission);

		WaitMethods.wait_in_seconds(3);

		GenericMethods.is_element_present(StarrUILocators.requestedEffDate_field);
		String effDate=GenericMethods.getTextfmElem(StarrUILocators.requestedEffDate_field);
		ExcelReader.set_cell_data("Requested_Effective_date", row_num, effDate);

		//GenericMethods.click_Element(StarrUILocators.requestedEffDate_field);

		/*
		GenericMethods.select_date_from_datePicker(AdminPageLocators.licenseExpiration_year, AdminPageLocators.LicenseExpiration_month, AdminPageLocators.EoPolicyExpiration_day, ExcelReader.get_row_data_from_col("License_Expiration_Year", row_num), ExcelReader.get_row_data_from_col("License_Expiration_Month", row_num), ExcelReader.get_row_data_from_col("License_Expiration_Day", row_num));

		WaitMethods.wait_in_seconds(5);

		GenericMethods.click_Element_Using_JS(AdminPageLocators.EoPloicydate_datePicker);
		GenericMethods.click_Element_Using_JS(AdminPageLocators.EoPolicyExpiration_daySwitch);
		GenericMethods.click_Element_Using_JS(AdminPageLocators.EoPolicyExpiration_monthSwitch);
		GenericMethods.click_Element_Using_JS(AdminPageLocators.EoPolicyExpiration_yearSwitch);
		 */			
		GenericMethods.click_Element_Using_JS(StarrUILocators.next_button);
		WaitMethods.wait_in_seconds(2);		
	}

	/*
	 * Purpose: This method go to Personal_and_BusinessInfo page 
	 * & perform Operations
	 * @param integer (Row_number of Excel sheet)
	 * @return NA
	 */

	public static void Personal_and_BusinessInfo(int row_num,String diff_address) throws IOException, InterruptedException, Exception, AWTException
	{	
		ExcelReader.set_excel_file(Locations.StarUI_TestData,"Personal_Business_Info");
		GenericMethods.enter_text(StarrUILocators.firstName_txtField,ExcelReader.get_row_data_from_col("FirstName", row_num), "FirstName");
		GenericMethods.enter_text(StarrUILocators.lastName_txtField,ExcelReader.get_row_data_from_col("LastName", row_num), "LastName");
		
		
		GenericMethods.enter_text(StarrUILocators.business_Address_txtauto,ExcelReader.get_row_data_from_col("Business_Address", row_num), "Business Address");
		WaitMethods.wait_in_seconds(2);
		WaitMethods.wait_for_elements_present(StarrUILocators.businessAdd_List);
		GenericMethods.bootstrap_dropdown(StarrUILocators.businessAdd_List, "");

		
		if(diff_address.equalsIgnoreCase("same"))
		{
		WaitMethods.wait_in_seconds(2);
		GenericMethods.is_element_present(StarrUILocators.same_mail_businessadd_chkb);
		GenericMethods.click_Element_Using_JS(StarrUILocators.same_mail_businessadd_chkb);
		}
		else if(diff_address.equalsIgnoreCase("different"))
		{
			GenericMethods.enter_text(StarrUILocators.mailing_Address_txtauto,ExcelReader.get_row_data_from_col("mailing_Address", row_num), "Mailing Address");
			WaitMethods.wait_in_seconds(2);
			WaitMethods.wait_for_elements_present(StarrUILocators.businessAdd_List);
			GenericMethods.bootstrap_dropdown(StarrUILocators.businessAdd_List,"");
		}
		
		GenericMethods.enter_text(StarrUILocators.email_txtField,ExcelReader.get_row_data_from_col("Email", row_num), "Email");
		GenericMethods.enter_text(StarrUILocators.phnNumber_txtField,ExcelReader.get_row_data_from_col("Phone_Number", row_num),"Phone_Number");
		GenericMethods.enter_text(StarrUILocators.businessName_txtFiled,ExcelReader.get_row_data_from_col("Business_Name", row_num), "Business_Name");
		GenericMethods.enter_text(StarrUILocators.estimatedGrossReceips_txtField,ExcelReader.get_row_data_from_col("Gross_Receipts", row_num), "Gross_Receipts");
		WaitMethods.wait_in_seconds(5);
		GenericMethods.is_element_present(StarrUILocators.businessEntityType_drpDwn);
		GenericMethods.select_from_dropdown(StarrUILocators.businessEntityType_drpDwn, "visibletext", ExcelReader.get_row_data_from_col("Business_entity_type", row_num));
		GenericMethods.click_Element_Using_JS(StarrUILocators.next_button);
		WaitMethods.wait_in_seconds(2);
	}

	/*
	 * Purpose: This method go to marineArtisan page 
	 * & perform Operations select Operation
	 * @return NA
	 */
	public static void your_Operations_marineArtisan() throws IOException, InterruptedException, Exception, AWTException
	{	
		GenericMethods.is_element_displayed(StarrUILocators.ma_HullWork);
		GenericMethods.click_Element_Using_JS(StarrUILocators.ma_HullWork);
		GenericMethods.click_Element_Using_JS(StarrUILocators.next_button);
		WaitMethods.wait_in_seconds(2);
	}
	/*
	 * Purpose: This method go to SmallmarineContractor page 
	 * & perform Operations select Operation
	 * @return NA
	 */
	public static void your_Operations_SmallmarineContractor() throws IOException, InterruptedException, Exception, AWTException
	{	
		GenericMethods.is_element_displayed(StarrUILocators.smc_Dredging);
		GenericMethods.click_Element_Using_JS(StarrUILocators.smc_Dredging);	
		GenericMethods.click_Element_Using_JS(StarrUILocators.next_button);
		WaitMethods.wait_in_seconds(2);
	}
	/*
	 * Purpose: This method go to additional Detail page 
	 * & perform Operations
	 * @return NA
	 */

	public static void additionalDetail() throws IOException, InterruptedException, Exception, AWTException
	{	
		GenericMethods.click_Element_Using_JS(StarrUILocators.next_button);
		WaitMethods.wait_in_seconds(5);
	}

	/*
	 * Purpose: This method go to priceIndication page 
	 * & perform Operations & Save Values and Quote No.
	 * @param integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void priceIndication(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{	
		WaitMethods.wait_in_seconds(5);	

		ExcelReader.set_excel_file(Locations.StarUI_TestData, "Quote_PremiumAmount");

		GenericMethods.is_element_present(StarrUILocators.quote_number);
		String quoteNumber = GenericMethods.get_text(StarrUILocators.quote_number);		
		String quote= GenericMethods.retrive_substring("#",quoteNumber);
		ExcelReader.set_cell_data("Quote_Number", row_num, quote);
		log.info("Quote Number we get: "+quote);

		GenericMethods.is_element_present(StarrUILocators.amount_txt);
		String priceValue = GenericMethods.get_text(StarrUILocators.amount_txt);
		ExcelReader.set_cell_data("Quote_Value", row_num, priceValue);
		log.info("Value we get: "+priceValue);	
		WaitMethods.wait_in_seconds(5);	

		GenericMethods.is_element_present(StarrUILocators.tria_chkb);
		GenericMethods.click_Element_Using_JS(StarrUILocators.tria_chkb);WaitMethods.wait_in_seconds(2);
		WaitMethods.wait_in_seconds(5);
		String priceValueAfterTerror = GenericMethods.get_text(StarrUILocators.amount_txt);
		ExcelReader.set_cell_data("Quote_Terror_Value", row_num, priceValueAfterTerror);

		GenericMethods.is_element_present(StarrUILocators.price_select_btn);
		GenericMethods.click_Element_Using_JS(StarrUILocators.price_select_btn);
		WaitMethods.wait_in_seconds(5);
	}

	/*
	 * Purpose: This method go to Checkout page 
	 * & perform Operations & Save Values
	 * @param integer (Row_number of Excel sheet)
	 * @return NA
	 * Now with New phase it comes Under PREMIUM Breakdown
	 */
	
	//Add Broker Fee Method
	public static void addBrokerFee() throws IOException, InterruptedException, Exception, AWTException
	{	
		WaitMethods.wait_in_seconds(2);
		GenericMethods.enter_text(StarrUILocators.brokerfee_txtb, "99", "Broker Fee Value");WaitMethods.wait_in_seconds(2);
		GenericMethods.click_Element(StarrUILocators.brokerFee_save);
	}
	
	public static void checkOutPage(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{
		WaitMethods.wait_in_seconds(5);
		ExcelReader.set_excel_file(Locations.StarUI_TestData,"Quote_PremiumAmount");

		GenericMethods.is_element_present(StarrUILocators.marine_GL_Value);
		String marineGLvalue = GenericMethods.get_text(StarrUILocators.marine_GL_Value);
		ExcelReader.set_cell_data("MarineGL", row_num, marineGLvalue);

		GenericMethods.is_element_present(StarrUILocators.terrorism_Value);
		String terrorismValue = GenericMethods.get_text(StarrUILocators.terrorism_Value);
		ExcelReader.set_cell_data("Terrorism", row_num, terrorismValue);

		/*GenericMethods.is_element_present(StarrUILocators.commisionRate_percent);
		String commissionRatePercent = GenericMethods.get_text(StarrUILocators.commisionRate_percent);
		ExcelReader.set_cell_data("CommissionRate", row_num, commissionRatePercent);*/

		/*GenericMethods.is_element_present(StarrUILocators.commisionAmount_Value);
		String commAmount = GenericMethods.get_text(StarrUILocators.commisionAmount_Value);
		ExcelReader.set_cell_data("CommissionAmount", row_num, commAmount);*/

		GenericMethods.is_element_present(StarrUILocators.btisServiceFee_Value);
		String serviceFee = GenericMethods.get_text(StarrUILocators.btisServiceFee_Value);
		ExcelReader.set_cell_data("ServiceFee", row_num, serviceFee);
		
		GenericMethods.is_element_present(StarrUILocators.brokerFee_value);
		String brokerFee = GenericMethods.get_text(StarrUILocators.brokerFee_value);
		ExcelReader.set_cell_data("BrokerFee", row_num, brokerFee);
		
		GenericMethods.is_element_present(StarrUILocators.totalPremium_Value);
		String totalPremium = GenericMethods.get_text(StarrUILocators.totalPremium_Value);
		ExcelReader.set_cell_data("Total_Premium", row_num, totalPremium);

		GenericMethods.is_element_present(StarrUILocators.grossTotal_Value);
		String grossTotal = GenericMethods.get_text(StarrUILocators.grossTotal_Value);
		ExcelReader.set_cell_data("Gross_Total", row_num, grossTotal);
		
		GenericMethods.is_element_present(StarrUILocators.netDown_Value);
		String netDownValue = GenericMethods.get_text(StarrUILocators.netDown_Value);
		ExcelReader.set_cell_data("netDownValue", row_num, netDownValue);
		
		GenericMethods.click_Element_Using_JS(StarrUILocators.payandBind_btn);
		WaitMethods.wait_in_seconds(2);
		/*GenericMethods.click_Element_Using_JS(StarrUILocators.bind_YES_btn);
		WaitMethods.wait_in_seconds(5);*/
	}

	/*
	 * Purpose: This method go to Finish page 
	 * & perform Operations
	 * @param integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void finishPage(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{	
		ExcelReader.set_excel_file(Locations.StarUI_TestData, "Quote_PremiumAmount");

		GenericMethods.is_element_present(StarrUILocators.policyNo_getTxt);
		String policyNo = GenericMethods.get_text(StarrUILocators.policyNo_getTxt);
		ExcelReader.set_cell_data("PolicyNo", row_num, policyNo);
		/*		
		GenericMethods.click_Element_Using_JS(StarrUILocators.policyDocument_DocLink);
		WaitMethods.wait_in_seconds(5);*/

		GenericMethods.click_Element_Using_JS(StarrUILocators.finish_btn);
		WaitMethods.wait_in_seconds(2);
		
	}


	/*
	 * Purpose: This method is to click on Policy Document link after changing the status of a sold
	 * and for Submit with Edit and Finish option to up to SOLD
	 * @param String QuoteNo, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void click_policy_and_Review_Document_EditFinish(String Quote_Number,int row_num,String submission_type) throws InterruptedException, AWTException, IOException
	{
		try
		{	
			WaitMethods.wait_for_page_load(10);
			WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.gotoSubmissions_button);
			AutoRenewalBrokerFeeLocators.gotoSubmissions_button.click();
			WaitMethods.wait_in_seconds(3);

			WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.selectBy_drpDwn);
			ExcelReader.set_excel_file(Locations.StarUI_TestData, "Quote_PremiumAmount");
			GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.selectBy_drpDwn, "visibletext",  ExcelReader.get_row_data_from_col("searchBy", row_num));
			AdminSubmissionPageLocators.submission_id_searchfield.clear();
			AdminSubmissionPageLocators.submission_id_searchfield.sendKeys(ExcelReader.get_row_data_from_col(Quote_Number, row_num));

			WaitMethods.wait_in_seconds(3);
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
			WaitMethods.wait_in_seconds(3);

			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_table_row);

			if(GenericMethods.is_element_present(AdminSubmissionPageLocators.sold_status).equalsIgnoreCase("true"))
			{

				log.info("//===========================> Clicking on Policy Document<=============================");
				GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
				WaitMethods.wait_in_seconds(3);
				WaitMethods.wait_for_element_present(StarrUILocators.policyDoc_option);
				GenericMethods.click_Element_Using_JS(StarrUILocators.policyDoc_option);
				log.info("//===========================> Clicked on Policy Document Link<=============================");
				WaitMethods.wait_in_seconds(15);

				log.info("//===========================> Clicking on Review Submission Document<=============================");
				WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_table_row);
				GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
				WaitMethods.wait_in_seconds(3);
				WaitMethods.wait_for_element_present(StarrUILocators.ReviewSubmission_option);
				GenericMethods.click_Element_Using_JS(StarrUILocators.ReviewSubmission_option);
				log.info("//===========================> Clicked on Review Submission Document Link<=============================");
				WaitMethods.wait_in_seconds(15);
			}
			else if(GenericMethods.is_element_present(AdminSubmissionPageLocators.submitted_status).equalsIgnoreCase("true"))
			{
				log.info("//===========================> Clicking on Edit and Finish Document<=============================");
				GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
				WaitMethods.wait_in_seconds(3);
				WaitMethods.wait_for_element_present(StarrUILocators.Edit_Finish_option);
				GenericMethods.click_Element(StarrUILocators.Edit_Finish_option);
				log.info("//===========================> Clicked on Edit and Finish Link<=============================");
				WaitMethods.wait_in_seconds(5);
				GenericMethods.navigate_to_next_window();
				ExcelReader.set_excel_file(Locations.StarUI_TestData, "LetsGetStarted");
				GenericMethods.is_element_present(StarrUILocators.select_a_class_drpDwn);
				String submissionType=GenericMethods.get_selected_optn_frm_ele(StarrUILocators.select_a_class_drpDwn);
				Assert.assertEquals(submissionType, ExcelReader.get_row_data_from_col("SubmissionType", row_num));
				log.info("====SubmissionType get matched in Edit & Finish mode=====");

				WaitMethods.wait_in_seconds(2);

				GenericMethods.is_element_present(StarrUILocators.requestedEffDate_field);
				String RefEffDate=GenericMethods.getTextfmElem(StarrUILocators.requestedEffDate_field);
				Assert.assertEquals(RefEffDate, ExcelReader.get_row_data_from_col("Requested_Effective_date", row_num));
				log.info("====Request Effective Date get matched in Edit & Finish mode=====");

				GenericMethods.click_Element_Using_JS(StarrUILocators.next_button);
				WaitMethods.wait_in_seconds(5);

				ExcelReader.set_excel_file(Locations.StarUI_TestData,"Personal_Business_Info");

				GenericMethods.is_element_present(StarrUILocators.firstName_txtField);
				String firstname=GenericMethods.getTextfmElem(StarrUILocators.firstName_txtField);
				Assert.assertEquals(firstname, ExcelReader.get_row_data_from_col("FirstName", row_num));

				GenericMethods.is_element_present(StarrUILocators.lastName_txtField);
				String lastname=GenericMethods.getTextfmElem(StarrUILocators.lastName_txtField);
				Assert.assertEquals(lastname, ExcelReader.get_row_data_from_col("LastName", row_num));

				GenericMethods.is_element_present(StarrUILocators.email_txtField);
				String email=GenericMethods.getTextfmElem(StarrUILocators.email_txtField);
				Assert.assertEquals(email, ExcelReader.get_row_data_from_col("Email", row_num));

				GenericMethods.is_element_present(StarrUILocators.businessName_txtFiled);
				String businessname=GenericMethods.getTextfmElem(StarrUILocators.businessName_txtFiled);
				Assert.assertEquals(businessname, ExcelReader.get_row_data_from_col("Business_Name", row_num));

				GenericMethods.is_element_present(StarrUILocators.estimatedGrossReceips_txtField);
				String gross=GenericMethods.getTextfmElem(StarrUILocators.estimatedGrossReceips_txtField);
				Assert.assertEquals(gross, ExcelReader.get_row_data_from_col("Gross_Receipts", row_num));

				GenericMethods.is_element_present(StarrUILocators.businessEntityType_drpDwn);
				String entityType=GenericMethods.get_selected_optn_frm_ele(StarrUILocators.businessEntityType_drpDwn);
				Assert.assertEquals(entityType, ExcelReader.get_row_data_from_col("Business_entity_type", row_num));

				GenericMethods.click_Element_Using_JS(StarrUILocators.next_button);
				WaitMethods.wait_in_seconds(5);


				if(submission_type.equalsIgnoreCase("Marine"))
				{
					GenericMethods.is_element_present(StarrUILocators.ma_HullWork);
					GenericMethods.is_chekbox_selected(StarrUILocators.chkbox_verification);
					log.info("====Hull work chkbox is auto selected Edit & Finish mode=====");
					GenericMethods.click_Element_Using_JS(StarrUILocators.next_button);
					WaitMethods.wait_in_seconds(5);

					GenericMethods.is_radio_button_selected(StarrUILocators.mcNsmac_radio_Notagree);
					GenericMethods.is_radio_button_selected(StarrUILocators.mcNsmac_radio_Notagree_last3Years);
					GenericMethods.click_Element_Using_JS(StarrUILocators.next_button);
					WaitMethods.wait_in_seconds(5);

				}
				else if(submission_type.equalsIgnoreCase("SmallMarine"))
				{
					GenericMethods.is_element_present(StarrUILocators.smc_Dredging);
					GenericMethods.is_chekbox_selected(StarrUILocators.smc_Dredging);
					log.info("====Dredging chkbox is auto selected Edit & Finish mode=====");	
					GenericMethods.click_Element_Using_JS(StarrUILocators.next_button);
					WaitMethods.wait_in_seconds(5);

					GenericMethods.is_radio_button_selected(StarrUILocators.mcNsmac_radio_Notagree);
					GenericMethods.is_radio_button_selected(StarrUILocators.mcNsmac_radio_Notagree_last3Years);
					GenericMethods.is_radio_button_selected(StarrUILocators.smc_radio_Notagree_Vessels);
					GenericMethods.click_Element_Using_JS(StarrUILocators.next_button);
					WaitMethods.wait_in_seconds(5);
				}

				GenericMethods.is_element_present(StarrUILocators.price_select_btn);
				GenericMethods.click_Element_Using_JS(StarrUILocators.price_select_btn);WaitMethods.wait_in_seconds(2);
				WaitMethods.wait_in_seconds(5);

				GenericMethods.click_Element_Using_JS(StarrUILocators.payandBind_btn);
				WaitMethods.wait_in_seconds(2);
				/*GenericMethods.click_Element_Using_JS(StarrUILocators.bind_YES_btn);
				WaitMethods.wait_in_seconds(5);	
				GenericMethods.click_Element_Using_JS(StarrUILocators.finish_btn);*/

			}

			//GenericMethods.validate_text_in_pdf("Starr Marine General Liability Summary Review");

		}
		catch(UnhandledAlertException | ElementNotVisibleException | NoSuchElementException exe)
		{
			log.debug("The exception was found "+exe.getClass().getCanonicalName());
		}
		catch(WebDriverException exe)
		{
			log.info("unable to find the element in the web page");
		}
	}


	/*
	 * Purpose: This method is to Verify Submission Sold or Not
	 * @param String QuoteNo, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void verify_Submission_SOLD(String Quote_Number,int row_num) throws InterruptedException, AWTException, IOException
	{
		WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.gotoSubmissions_button);
		AutoRenewalBrokerFeeLocators.gotoSubmissions_button.click();
		WaitMethods.wait_in_seconds(3);

		WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.selectBy_drpDwn);
		ExcelReader.set_excel_file(Locations.StarUI_TestData, "Quote_PremiumAmount");
		GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.selectBy_drpDwn, "visibletext",  ExcelReader.get_row_data_from_col("searchBy", row_num));
		AdminSubmissionPageLocators.submission_id_searchfield.clear();
		AdminSubmissionPageLocators.submission_id_searchfield.sendKeys(ExcelReader.get_row_data_from_col(Quote_Number, row_num));

		WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
		GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
		WaitMethods.wait_in_seconds(3);

		WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_table_row);
		if(GenericMethods.is_element_present(AdminSubmissionPageLocators.sold_status).equalsIgnoreCase("true"))
		{
			log.info("====>The Submssion status changed to SOLD using Edit and Finish option, Successfully<=====");
		}

	}

	/*
	 * Purpose: This method is to Verify Submission support listed States
	 * @param String QuoteNo, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void verify_statesSupport(int no_of_scenarios) throws IOException, InterruptedException, Exception, AWTException
	{	
		ExcelReader.set_excel_file(Locations.StarUI_TestData,"StatesWithInvalid");
		int Data_in_rows=ExcelReader.get_row_count()-1;
		if(no_of_scenarios>Data_in_rows)
		{
			System.out.println("No: os Scenarios should be less than or equal to "+Data_in_rows+" as the data is present only in "+Data_in_rows+" rows in the excel sheet");
		}
		else
		{
			try
			{
				for(int i=1; i<=no_of_scenarios; i++)
				{	
					WaitMethods.wait_in_seconds(3);
					StarrUILocators.firstName_txtField.clear();
					GenericMethods.enter_text(StarrUILocators.firstName_txtField,ExcelReader.get_row_data_from_col("FirstName", i), "FirstName");
					StarrUILocators.lastName_txtField.clear();
					GenericMethods.enter_text(StarrUILocators.lastName_txtField,ExcelReader.get_row_data_from_col("LastName", i), "LastName");
					WaitMethods.wait_for_element_present(StarrUILocators.business_Address_txtauto);
					StarrUILocators.business_Address_txtauto.clear();
					GenericMethods.enter_text(StarrUILocators.business_Address_txtauto,ExcelReader.get_row_data_from_col("FamousAddress", i), "Business Address");
					WaitMethods.wait_in_seconds(2);
					
					WaitMethods.wait_in_seconds(2);
					WaitMethods.wait_for_elements_present(StarrUILocators.businessAdd_List);
					GenericMethods.bootstrap_dropdown(StarrUILocators.businessAdd_List, "");
															
					WaitMethods.wait_in_seconds(2);

					if(StarrUILocators.state_validation_msg.isDisplayed())
					{	
						String msg=StarrUILocators.state_validation_msg.getText();
						log.info("====================>"+msg+"<==========================");
					}
					else
					{
						log.info("=========================> State support to create Submission <=========================>");
					}
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


	}

	/*
	 * Purpose: This method to test Deductible  Values from DropDown
	 * depends on Gross Receipt Amount
	 * & perform Operations
	 * @param integer (Row_number of Excel sheet)
	 * @return NA
	 */

	public static void deductible_dropdown_validate(int no_of_scenarios) throws IOException, InterruptedException, Exception, AWTException
	{	

		ExcelReader.set_excel_file(Locations.StarUI_TestData,"DeductibleTable");
		int Data_in_rows=ExcelReader.get_row_count()-1;
		if(no_of_scenarios>Data_in_rows)
		{
			System.out.println("No: os Scenarios should be less than or equal to "+Data_in_rows+" as the data is present only in "+Data_in_rows+" rows in the excel sheet");
		}
		else
		{
			try
			{
				for(int i=1; i<=no_of_scenarios; i++)
				{	

					//personal info and Business Info page
					StarrUILocators.firstName_txtField.clear();
					GenericMethods.enter_text(StarrUILocators.firstName_txtField,ExcelReader.get_row_data_from_col("FirstName", i), "FirstName");
					StarrUILocators.lastName_txtField.clear();
					GenericMethods.enter_text(StarrUILocators.lastName_txtField,ExcelReader.get_row_data_from_col("LastName", i), "LastName");
					StarrUILocators.business_Address_txtauto.clear();
					GenericMethods.enter_text(StarrUILocators.business_Address_txtauto,ExcelReader.get_row_data_from_col("Business_Address", i), "Business Address");
					WaitMethods.wait_in_seconds(2);
					WaitMethods.wait_for_elements_present(StarrUILocators.businessAdd_List);
					GenericMethods.bootstrap_dropdown(StarrUILocators.businessAdd_List, "");
					
					WaitMethods.wait_in_seconds(2);
					GenericMethods.is_element_present(StarrUILocators.same_mail_businessadd_chkb);
					GenericMethods.click_Element_Using_JS(StarrUILocators.same_mail_businessadd_chkb);
					GenericMethods.click_Element_Using_JS(StarrUILocators.same_mail_businessadd_chkb);

					StarrUILocators.email_txtField.clear();
					GenericMethods.enter_text(StarrUILocators.email_txtField,ExcelReader.get_row_data_from_col("Email", i), "Email");
					StarrUILocators.phnNumber_txtField.clear();
					GenericMethods.enter_text(StarrUILocators.phnNumber_txtField,ExcelReader.get_row_data_from_col("Phone_Number", i),"Phone_Number");
					StarrUILocators.businessName_txtFiled.clear();
					GenericMethods.enter_text(StarrUILocators.businessName_txtFiled,ExcelReader.get_row_data_from_col("Business_Name", i), "Business_Name");

					StarrUILocators.estimatedGrossReceips_txtField.clear();
					GenericMethods.enter_text(StarrUILocators.estimatedGrossReceips_txtField,ExcelReader.get_row_data_from_col("GrossValue", i), "Gross_Receipts_value");
					String GrossValueEntered=GenericMethods.getTextfmElem(StarrUILocators.estimatedGrossReceips_txtField);

					GenericMethods.is_element_present(StarrUILocators.businessEntityType_drpDwn);
					GenericMethods.select_from_dropdown(StarrUILocators.businessEntityType_drpDwn, "visibletext", ExcelReader.get_row_data_from_col("Business_entity_type", i));
					WaitMethods.wait_in_seconds(5);

					GenericMethods.click_Element_Using_JS(StarrUILocators.next_button);
					WaitMethods.wait_in_seconds(2);

					//Operation selection Button
					GenericMethods.is_element_displayed(StarrUILocators.ma_HullWork);
					WaitMethods.wait_in_seconds(2);
					if(GenericMethods.is_chekbox_selected(StarrUILocators.chkbox_verification).equalsIgnoreCase("false") ) 
					{	
						GenericMethods.click_Element_Using_JS(StarrUILocators.ma_HullWork);
						GenericMethods.click_Element_Using_JS(StarrUILocators.next_button);
						WaitMethods.wait_in_seconds(2);
					}
					else 
					{	
						GenericMethods.click_Element_Using_JS(StarrUILocators.next_button);
						WaitMethods.wait_in_seconds(2);
					}
					

					//additional Detail Page
					GenericMethods.click_Element_Using_JS(StarrUILocators.next_button);
					WaitMethods.wait_in_seconds(5);

					//Price Indication
					GenericMethods.is_element_displayed(StarrUILocators.deductible_drpdwn);
					String values=StarrUILocators.deductible_drpdwn.getText();
					String values2=values.replaceAll("\\s+","");
					GenericMethods.click_Element(StarrUILocators.deductible_drpdwn);
					WaitMethods.wait_in_seconds(2);
					
					Assert.assertEquals(values2,ExcelReader.get_row_data_from_col("DeductibleOptions_Value", i));
					log.info("Deductible Values showing Correctly & matched successfully " +values2 +" for Gross Value = "+GrossValueEntered);
					WaitMethods.wait_in_seconds(2);
					
					//Price Indication Back Button
					GenericMethods.click_Element_Using_JS(StarrUILocators.back_button);
					WaitMethods.wait_in_seconds(2);

					//additional Detail Page Back Button
					GenericMethods.click_Element_Using_JS(StarrUILocators.back_button);
					WaitMethods.wait_in_seconds(2);

					//Operation Page Back Button
					GenericMethods.click_Element_Using_JS(StarrUILocators.back_button);
					WaitMethods.wait_in_seconds(2);
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
	}
	
	
	/*
	 * Purpose: This method to test Service taken for CA & WA state only 250$
	 * depends on Gross Receipt Amount
	 * & perform Operations
	 * @param integer (Row_number of Excel sheet)
	 * @return NA
	 */

	public static void serviceFee_StateWise(int no_of_scenarios) throws IOException, InterruptedException, Exception, AWTException
	{	

		ExcelReader.set_excel_file(Locations.StarUI_TestData,"ServiceFeeTest");
		int Data_in_rows=ExcelReader.get_row_count()-1;
		if(no_of_scenarios>Data_in_rows)
		{
			System.out.println("No: os Scenarios should be less than or equal to "+Data_in_rows+" as the data is present only in "+Data_in_rows+" rows in the excel sheet");
		}
		else
		{
			try
			{
				for(int i=1; i<=no_of_scenarios; i++)
				{	

					//personal info and Business Info page
					StarrUILocators.firstName_txtField.clear();
					GenericMethods.enter_text(StarrUILocators.firstName_txtField,ExcelReader.get_row_data_from_col("FirstName", i), "FirstName");
					StarrUILocators.lastName_txtField.clear();
					GenericMethods.enter_text(StarrUILocators.lastName_txtField,ExcelReader.get_row_data_from_col("LastName", i), "LastName");
					StarrUILocators.business_Address_txtauto.clear();
							
					
					GenericMethods.enter_text(StarrUILocators.business_Address_txtauto,ExcelReader.get_row_data_from_col("Business_Address", i), "Business Address");
					WaitMethods.wait_in_seconds(2);
					WaitMethods.wait_for_elements_present(StarrUILocators.businessAdd_List);
					GenericMethods.bootstrap_dropdown(StarrUILocators.businessAdd_List, "");
							
					

					WaitMethods.wait_in_seconds(2);
					GenericMethods.is_element_present(StarrUILocators.same_mail_businessadd_chkb);
					GenericMethods.click_Element_Using_JS(StarrUILocators.same_mail_businessadd_chkb);
					GenericMethods.click_Element_Using_JS(StarrUILocators.same_mail_businessadd_chkb);

					StarrUILocators.email_txtField.clear();
					GenericMethods.enter_text(StarrUILocators.email_txtField,ExcelReader.get_row_data_from_col("Email", i), "Email");
					StarrUILocators.phnNumber_txtField.clear();
					GenericMethods.enter_text(StarrUILocators.phnNumber_txtField,ExcelReader.get_row_data_from_col("Phone_Number", i),"Phone_Number");
					StarrUILocators.businessName_txtFiled.clear();
					GenericMethods.enter_text(StarrUILocators.businessName_txtFiled,ExcelReader.get_row_data_from_col("Business_Name", i), "Business_Name");

					StarrUILocators.estimatedGrossReceips_txtField.clear();
					GenericMethods.enter_text(StarrUILocators.estimatedGrossReceips_txtField,ExcelReader.get_row_data_from_col("Gross_Receipts", i), "Gross_Receipts");
					WaitMethods.wait_in_seconds(5);
					
					GenericMethods.is_element_present(StarrUILocators.businessEntityType_drpDwn);
					GenericMethods.select_from_dropdown(StarrUILocators.businessEntityType_drpDwn, "visibletext", ExcelReader.get_row_data_from_col("Business_entity_type", i));
					WaitMethods.wait_in_seconds(5);

					GenericMethods.click_Element_Using_JS(StarrUILocators.next_button);
					WaitMethods.wait_in_seconds(2);

					//Operation selection Button
					GenericMethods.is_element_displayed(StarrUILocators.ma_HullWork);
					WaitMethods.wait_in_seconds(2);
					if(GenericMethods.is_chekbox_selected(StarrUILocators.chkbox_verification).equalsIgnoreCase("false") ) 
					{	
						GenericMethods.click_Element_Using_JS(StarrUILocators.ma_HullWork);
						GenericMethods.click_Element_Using_JS(StarrUILocators.next_button);
						WaitMethods.wait_in_seconds(2);
					}
					else 
					{	
						GenericMethods.click_Element_Using_JS(StarrUILocators.next_button);
						WaitMethods.wait_in_seconds(2);
					}
										
					//additional Detail Page
					GenericMethods.click_Element_Using_JS(StarrUILocators.next_button);
					WaitMethods.wait_in_seconds(5);

					//Price Indication
					
					GenericMethods.is_element_present(StarrUILocators.price_select_btn);
					GenericMethods.click_Element_Using_JS(StarrUILocators.price_select_btn);WaitMethods.wait_in_seconds(2);
					WaitMethods.wait_in_seconds(5);
					
					//Service Fee compare according to State
					
					
					GenericMethods.is_element_present(StarrUILocators.btisServiceFee_Value);
					String serviceFee = GenericMethods.get_text(StarrUILocators.btisServiceFee_Value);
					Assert.assertEquals(serviceFee, ExcelReader.get_row_data_from_col("ServiceFeeActual", i));
					log.info("Service Fee reflect Correctly for State : "+ExcelReader.get_row_data_from_col("State", i)+ " and Service Fee is : "+serviceFee);
				
					
					//Checkout page Back Button
					GenericMethods.click_Element_Using_JS(StarrUILocators.back_button);
					WaitMethods.wait_in_seconds(2);
					
					//Price Indication Back Button
					GenericMethods.click_Element_Using_JS(StarrUILocators.back_button);
					WaitMethods.wait_in_seconds(2);

					//additional Detail Page Back Button
					GenericMethods.click_Element_Using_JS(StarrUILocators.back_button);
					WaitMethods.wait_in_seconds(2);

					//Operation Page Back Button
					GenericMethods.click_Element_Using_JS(StarrUILocators.back_button);
					WaitMethods.wait_in_seconds(2);
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
		
	}
	
	//========================Pay and Bind page ============================================

	//==================Pay Now Payement method==============

	public static void payNow_paymentMode() throws IOException, InterruptedException, Exception, AWTException
	{
		GenericMethods.click_Element_Using_JS(StarrUILocators.payNow_pay_bind_btn);
		WaitMethods.wait_in_seconds(3);
	}
	
	//==================manualFinance Payement method==============
	
	public static void manualFinance_paymentMode() throws IOException, InterruptedException, Exception, AWTException
	{	
		GenericMethods.click_Element_Using_JS(StarrUILocators.manualFinance_btn);
		GenericMethods.click_Element_Using_JS(StarrUILocators.acknowledge_chkb);
		GenericMethods.click_Element_Using_JS(StarrUILocators.manualFinance_pay_bind_btn);
	}
	
	//==================paperlessFinance Payement method==============
	
	public static void paperlessFinance_paymentMode() throws IOException, InterruptedException, Exception, AWTException
	{	
		GenericMethods.click_Element_Using_JS(StarrUILocators.paperLessFinance_btn);
		GenericMethods.click_Element_Using_JS(StarrUILocators.understand_chkb);
		GenericMethods.click_Element_Using_JS(StarrUILocators.affirming_chkb);
		GenericMethods.click_Element_Using_JS(StarrUILocators.paperLessFinance_pay_bind_btn);
	}
	
	//====================How do you want to pay?
	
	public static void paymentMod_Select() throws IOException, InterruptedException, Exception, AWTException
	{
		GenericMethods.click_Element_Using_JS(StarrUILocators.creditCard_radio_btn);
		GenericMethods.click_Element_Using_JS(StarrUILocators.payNow_btn);
		WaitMethods.wait_in_seconds(2);
	}
	
	//===============PayEzee Payment gateway page==============================
	
	public static void payEzee(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{
		GenericMethods.swith_to_frame_using_name("payment-form-iframe");
		
		WaitMethods.wait_in_seconds(5);
		ExcelReader.set_excel_file(Locations.StarUI_TestData,"payGatewayPage");

		/*GenericMethods.is_element_present(StarrUILocators.totalAmountUSD);
		String totalamntvalue = GenericMethods.get_text(StarrUILocators.totalAmountUSD);
		ExcelReader.set_cell_data("TotalAmount", row_num, totalamntvalue);*/
		
		WaitMethods.wait_in_seconds(2);
		//GenericMethods.enter_text(StarrUILocators.exact_cardholder_name, ExcelReader.get_row_data_from_col("cardHolderName", row_num), "card Holder Name:");WaitMethods.wait_in_seconds(1);
		GenericMethods.enter_text(StarrUILocators.x_card_num, ExcelReader.get_row_data_from_col("Crerdit CardNo", row_num), "Crerdit CardNo:");WaitMethods.wait_in_seconds(1);
		GenericMethods.enter_text(StarrUILocators.x_exp_date, ExcelReader.get_row_data_from_col("ExpiryDate", row_num), "ExpiryDate:");WaitMethods.wait_in_seconds(1);
		GenericMethods.enter_text(StarrUILocators.x_card_code, ExcelReader.get_row_data_from_col("SecurityCode", row_num), "SecurityCode:");WaitMethods.wait_in_seconds(1);
		//GenericMethods.enter_text(StarrUILocators.cc_email, ExcelReader.get_row_data_from_col("Email", row_num), "Email:");WaitMethods.wait_in_seconds(1);
		
		GenericMethods.click_Element_Using_JS(StarrUILocators.pay_now_btn);
		WaitMethods.wait_in_seconds(2);
		
		GenericMethods.swith_to_default_content();
	}
}






