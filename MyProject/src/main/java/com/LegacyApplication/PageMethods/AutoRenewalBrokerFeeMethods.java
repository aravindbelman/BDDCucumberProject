package com.LegacyApplication.PageMethods;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;

import org.testng.Assert;

import com.LegacyApplication.ExcelReader.ExcelReader;
import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageLocators.AdminSubmissionPageLocators;
import com.LegacyApplication.PageLocators.AutoRenewalBrokerFeeLocators;
import com.LegacyApplication.PageLocators.DefaultBrokerFeeLocators;
import com.LegacyApplication.PageLocators.GeneralLiabilityPageLocators;
import com.LegacyApplication.PageLocators.SubmissionPageLocators;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

public class AutoRenewalBrokerFeeMethods extends TestBase {

	public static final Logger log=Logger.getLogger(AutoRenewalBrokerFeeMethods.class.getName());
	public static JavascriptExecutor js;
	
	//GenericMethods.press_key_using_robot("end");
	/*
	 * Purpose: This method is used to select an agency
	 * @param integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void select_agency(int row_num) throws AWTException, IOException
	{
		try
		{
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "Agency_Info");

			String s1=ExcelReader.get_row_data_from_col("Direct_Bill", row_num);
			String s2=ExcelReader.get_row_data_from_col("Agency_Bill", row_num);
			String s3=ExcelReader.get_row_data_from_col("Premium_Finance", row_num);	

			if(s1.equalsIgnoreCase("true") && s2.equalsIgnoreCase("false") && s3.equalsIgnoreCase("false"))
			{
				HomePageMethods.login_as_agency(Locations.BrokerFeeDataFilePath, "Agency_Info","Agency_Username", "Agency_Password", 1);
			}
			if(s1.equalsIgnoreCase("true") && s2.equalsIgnoreCase("true") && s3.equalsIgnoreCase("false"))
			{
				HomePageMethods.login_as_agency(Locations.BrokerFeeDataFilePath, "Agency_Info","Agency_Username", "Agency_Password", 2);
			}
			if(s1.equalsIgnoreCase("true") && s2.equalsIgnoreCase("true") && s3.equalsIgnoreCase("true"))
			{
				HomePageMethods.login_as_agency(Locations.BrokerFeeDataFilePath, "Agency_Info","Agency_Username", "Agency_Password", 3);
			}
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
	 * Purpose: This method is used to select an agency
	 * @param String(brokerfee_type), String(same or different broker fee), int row_number from excel
	 * @return NA
	 */
	public static void setup_brokerfee(String brokerfee_type, String same_or_different, int row_num) throws IOException, InterruptedException, AWTException
	{
		try
		{
		ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "BrokerFee_Data");
		driver.navigate().to(OR.getProperty("brokerfeesetup_url"));	
		WaitMethods.wait_for_page_load(5);
		/*if(GenericMethods.is_element_present(AutoRenewalBrokerFeeLocators.existing_brokerFee_cancelButton).equalsIgnoreCase("true"))
		{	
			WaitMethods.wait_in_seconds(2);
			GenericMethods.click_Element_Using_JS(AutoRenewalBrokerFeeLocators.existing_brokerFee_cancelButton);
		}*/
		
		 if(brokerfee_type.equalsIgnoreCase("nodefault") && same_or_different.equalsIgnoreCase("same"))
		{	
			WaitMethods.wait_in_seconds(3);
			AutoRenewalBrokerFeeLocators.checkbox_noDefaultFee.isDisplayed();  
			AutoRenewalBrokerFeeLocators.checkbox_noDefaultFee.click();
			AutoRenewalBrokerFeeLocators.submit_noDefaultFee.click();
		}
		
		else if(brokerfee_type.equalsIgnoreCase("flat") && same_or_different.equalsIgnoreCase("same"))
		{		
			WaitMethods.wait_in_seconds(3);
			if(GenericMethods.is_element_present(AutoRenewalBrokerFeeLocators.existing_brokerFee_cancelButton).equalsIgnoreCase("true"))
			{	
				WaitMethods.wait_in_seconds(2);
				GenericMethods.click_Element_Using_JS(AutoRenewalBrokerFeeLocators.existing_brokerFee_cancelButton);
			}
			WaitMethods.wait_in_seconds(3);
			AutoRenewalBrokerFeeLocators.selectButton_flatFee.click();
			AutoRenewalBrokerFeeLocators.flatBrokerFee_newBusiness.clear();
			AutoRenewalBrokerFeeLocators.flatBrokerFee_newBusiness.sendKeys(ExcelReader.get_row_data_from_col("Flat Broker Fee for New Business", row_num));
			AutoRenewalBrokerFeeLocators.flatbrokerFee_submitButton.click();
			
		}
		else if(brokerfee_type.equalsIgnoreCase("flat") && same_or_different.equalsIgnoreCase("different"))
		{	
			WaitMethods.wait_in_seconds(3);
			if(GenericMethods.is_element_present(AutoRenewalBrokerFeeLocators.existing_brokerFee_cancelButton).equalsIgnoreCase("true"))
			{	
				WaitMethods.wait_in_seconds(2);
				GenericMethods.click_Element_Using_JS(AutoRenewalBrokerFeeLocators.existing_brokerFee_cancelButton);
			}
			WaitMethods.wait_in_seconds(3);
			AutoRenewalBrokerFeeLocators.selectButton_flatFee.click();
			AutoRenewalBrokerFeeLocators.flatBrokerFee_newBusiness.clear();
			AutoRenewalBrokerFeeLocators.flatBrokerFee_newBusiness.sendKeys(ExcelReader.get_row_data_from_col("Flat Broker Fee for New Business", row_num));
			AutoRenewalBrokerFeeLocators.flatFee_checkbox.click();
			AutoRenewalBrokerFeeLocators.flatBrokerFee_renewalBusiness.clear();
			AutoRenewalBrokerFeeLocators.flatBrokerFee_renewalBusiness.sendKeys(ExcelReader.get_row_data_from_col("Flat Broker Fee for Renewal Business", row_num));
			AutoRenewalBrokerFeeLocators.flatbrokerFee_submitButton.click();
		}
		else if(brokerfee_type.equalsIgnoreCase("percentage") && same_or_different.equalsIgnoreCase("same"))
		{	
			WaitMethods.wait_in_seconds(3);
			if(GenericMethods.is_element_present(AutoRenewalBrokerFeeLocators.existing_brokerFee_cancelButton).equalsIgnoreCase("true"))
			{	
				WaitMethods.wait_in_seconds(2);
				GenericMethods.click_Element_Using_JS(AutoRenewalBrokerFeeLocators.existing_brokerFee_cancelButton);
			}
			WaitMethods.wait_in_seconds(3);
			AutoRenewalBrokerFeeLocators.selectButton_percentageFee.click();
			AutoRenewalBrokerFeeLocators.percentageBrokerFee_newBusiness.clear();
			AutoRenewalBrokerFeeLocators.percentageBrokerFee_newBusiness.sendKeys(ExcelReader.get_row_data_from_col("Percentage Broker Fee for New Business", row_num));
			AutoRenewalBrokerFeeLocators.percentageBrokerFee_submitButton.click();
			
		}
		else if(brokerfee_type.equalsIgnoreCase("percentage") && same_or_different.equalsIgnoreCase("different"))
		{	
			WaitMethods.wait_in_seconds(3);
			if(GenericMethods.is_element_present(AutoRenewalBrokerFeeLocators.existing_brokerFee_cancelButton).equalsIgnoreCase("true"))
			{	
				WaitMethods.wait_in_seconds(2);
				GenericMethods.click_Element_Using_JS(AutoRenewalBrokerFeeLocators.existing_brokerFee_cancelButton);
			}
			WaitMethods.wait_in_seconds(3);
			AutoRenewalBrokerFeeLocators.selectButton_percentageFee.click();
			AutoRenewalBrokerFeeLocators.percentageBrokerFee_newBusiness.clear();
			AutoRenewalBrokerFeeLocators.percentageBrokerFee_newBusiness.sendKeys(ExcelReader.get_row_data_from_col("Percentage Broker Fee for New Business", row_num));
			AutoRenewalBrokerFeeLocators.percentageFee_checkbox.click();
			WaitMethods.wait_in_seconds(2);
			AutoRenewalBrokerFeeLocators.percentageBrokerFee_renewalBusiness.clear();
			AutoRenewalBrokerFeeLocators.percentageBrokerFee_renewalBusiness.sendKeys(ExcelReader.get_row_data_from_col("Percentage Broker Fee for Renewal Business", row_num));
			AutoRenewalBrokerFeeLocators.percentageBrokerFee_submitButton.click();
			
		}		
		else if(brokerfee_type.equalsIgnoreCase("tiered") && same_or_different.equalsIgnoreCase("same"))
		{	
			WaitMethods.wait_in_seconds(3);
			if(GenericMethods.is_element_present(AutoRenewalBrokerFeeLocators.existing_brokerFee_cancelButton).equalsIgnoreCase("true"))
			{	
				WaitMethods.wait_in_seconds(2);
				GenericMethods.click_Element_Using_JS(AutoRenewalBrokerFeeLocators.existing_brokerFee_cancelButton);
			}
			WaitMethods.wait_in_seconds(3);
			AutoRenewalBrokerFeeLocators.selectButton_tieredFee.click();
			WaitMethods.wait_in_seconds(1);
			AutoRenewalBrokerFeeLocators.tieredBrokerFee_tier1NewBusiness.clear();
			AutoRenewalBrokerFeeLocators.tieredBrokerFee_tier1NewBusiness.sendKeys(ExcelReader.get_row_data_from_col("Tier 1 New Business Value", row_num));
			AutoRenewalBrokerFeeLocators.tier1NewBusiness_brokerFee.clear();
			AutoRenewalBrokerFeeLocators.tier1NewBusiness_brokerFee.sendKeys(ExcelReader.get_row_data_from_col("Tier 1 Broker Fee For New Business", row_num));
			AutoRenewalBrokerFeeLocators.additional_tier_sign_newBusiness.click();
			AutoRenewalBrokerFeeLocators.tieredBrokerFee_tier2NewBusiness.clear();
			AutoRenewalBrokerFeeLocators.tieredBrokerFee_tier2NewBusiness.sendKeys(ExcelReader.get_row_data_from_col("Tier 2 New Business Value", row_num));
			AutoRenewalBrokerFeeLocators.tier2NewBusiness_brokerFee.clear();
			AutoRenewalBrokerFeeLocators.tier2NewBusiness_brokerFee.sendKeys(ExcelReader.get_row_data_from_col("Tier 2 Broker Fee For New Business", row_num));
			AutoRenewalBrokerFeeLocators.additional_tier_sign_newBusiness.click();
			AutoRenewalBrokerFeeLocators.tieredBrokerFee_tier3NewBusiness.clear();
			AutoRenewalBrokerFeeLocators.tieredBrokerFee_tier3NewBusiness.sendKeys(ExcelReader.get_row_data_from_col("Tier 3 New Business Value", row_num));
			AutoRenewalBrokerFeeLocators.tier3NewBusiness_brokerFee.clear();
			AutoRenewalBrokerFeeLocators.tier3NewBusiness_brokerFee.sendKeys(ExcelReader.get_row_data_from_col("Tier 3 Broker Fee For New Business", row_num));
			AutoRenewalBrokerFeeLocators.tier4NewBusiness_brokerFee.clear();
			AutoRenewalBrokerFeeLocators.tier4NewBusiness_brokerFee.sendKeys(ExcelReader.get_row_data_from_col("Tier 4 Broker Fee For New Business", row_num));
			AutoRenewalBrokerFeeLocators.tieredBrokerFee_submitButton.click();
			
		}
		else if(brokerfee_type.equalsIgnoreCase("tiered") && same_or_different.equalsIgnoreCase("different"))
		{	
			WaitMethods.wait_in_seconds(3);
			if(GenericMethods.is_element_present(AutoRenewalBrokerFeeLocators.existing_brokerFee_cancelButton).equalsIgnoreCase("true"))
			{	
				WaitMethods.wait_in_seconds(2);
				GenericMethods.click_Element_Using_JS(AutoRenewalBrokerFeeLocators.existing_brokerFee_cancelButton);
			}
			WaitMethods.wait_in_seconds(3);
			AutoRenewalBrokerFeeLocators.selectButton_tieredFee.click();
			WaitMethods.wait_in_seconds(1);
			AutoRenewalBrokerFeeLocators.tieredBrokerFee_tier1NewBusiness.clear();
			AutoRenewalBrokerFeeLocators.tieredBrokerFee_tier1NewBusiness.sendKeys(ExcelReader.get_row_data_from_col("Tier 1 New Business Value", row_num));
			AutoRenewalBrokerFeeLocators.tier1NewBusiness_brokerFee.clear();
			AutoRenewalBrokerFeeLocators.tier1NewBusiness_brokerFee.sendKeys(ExcelReader.get_row_data_from_col("Tier 1 Broker Fee For New Business", row_num));
			
			WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.additional_tier_sign_newBusiness);
			AutoRenewalBrokerFeeLocators.additional_tier_sign_newBusiness.click();
			
			AutoRenewalBrokerFeeLocators.tieredBrokerFee_tier2NewBusiness.clear();
			AutoRenewalBrokerFeeLocators.tieredBrokerFee_tier2NewBusiness.sendKeys(ExcelReader.get_row_data_from_col("Tier 2 New Business Value", row_num));
			AutoRenewalBrokerFeeLocators.tier2NewBusiness_brokerFee.clear();
			AutoRenewalBrokerFeeLocators.tier2NewBusiness_brokerFee.sendKeys(ExcelReader.get_row_data_from_col("Tier 2 Broker Fee For New Business", row_num));
			
			WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.additional_tier_sign_newBusiness);
			AutoRenewalBrokerFeeLocators.additional_tier_sign_newBusiness.click();
			
			AutoRenewalBrokerFeeLocators.tieredBrokerFee_tier3NewBusiness.clear();
			AutoRenewalBrokerFeeLocators.tieredBrokerFee_tier3NewBusiness.sendKeys(ExcelReader.get_row_data_from_col("Tier 3 New Business Value", row_num));
			AutoRenewalBrokerFeeLocators.tier3NewBusiness_brokerFee.clear();
			AutoRenewalBrokerFeeLocators.tier3NewBusiness_brokerFee.sendKeys(ExcelReader.get_row_data_from_col("Tier 3 Broker Fee For New Business", row_num));
			
			AutoRenewalBrokerFeeLocators.tier4NewBusiness_brokerFee.clear();
			AutoRenewalBrokerFeeLocators.tier4NewBusiness_brokerFee.sendKeys(ExcelReader.get_row_data_from_col("Tier 4 Broker Fee For New Business", row_num));
			
			GenericMethods.click_Element_Using_JS(AutoRenewalBrokerFeeLocators.tieredBrokerFee_checkBox);
			WaitMethods.wait_in_seconds(1);
			
			AutoRenewalBrokerFeeLocators.tieredBrokerFee_tier1RenewalBusiness.clear();
			AutoRenewalBrokerFeeLocators.tieredBrokerFee_tier1RenewalBusiness.sendKeys(ExcelReader.get_row_data_from_col("Tier 1 Renewal Business Value", row_num));
			AutoRenewalBrokerFeeLocators.tier1RenewalBusiness_brokerFee.clear();
			AutoRenewalBrokerFeeLocators.tier1RenewalBusiness_brokerFee.sendKeys(ExcelReader.get_row_data_from_col("Tier 1 Broker Fee For Renewal Business", row_num));
			
			WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.additional_tier_sign_renewalBusiness);
			AutoRenewalBrokerFeeLocators.additional_tier_sign_renewalBusiness.click();
			WaitMethods.wait_in_seconds(1);
			
			WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.tieredBrokerFee_tier2RenewalBusiness);
			AutoRenewalBrokerFeeLocators.tieredBrokerFee_tier2RenewalBusiness.clear();
			AutoRenewalBrokerFeeLocators.tieredBrokerFee_tier2RenewalBusiness.sendKeys(ExcelReader.get_row_data_from_col("Tier 2 Renewal Business Value", row_num));
			AutoRenewalBrokerFeeLocators.tier2RenewalBusiness_brokerFee.clear();
			AutoRenewalBrokerFeeLocators.tier2RenewalBusiness_brokerFee.sendKeys(ExcelReader.get_row_data_from_col("Tier 2 Broker Fee For Renewal Business", row_num));
			
			WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.additional_tier_sign_renewalBusiness);
			AutoRenewalBrokerFeeLocators.additional_tier_sign_renewalBusiness.click();
			
			AutoRenewalBrokerFeeLocators.tieredBrokerFee_tier3RenewalBusiness.clear();
			AutoRenewalBrokerFeeLocators.tieredBrokerFee_tier3RenewalBusiness.sendKeys(ExcelReader.get_row_data_from_col("Tier 3 Renewal Business Value", row_num));
			AutoRenewalBrokerFeeLocators.tier3RenewalBusiness_brokerFee.clear();
			AutoRenewalBrokerFeeLocators.tier3RenewalBusiness_brokerFee.sendKeys(ExcelReader.get_row_data_from_col("Tier 3 Broker Fee For Renewal Business", row_num));
			
			AutoRenewalBrokerFeeLocators.tier4RenewalBusiness_brokerFee.clear();
			AutoRenewalBrokerFeeLocators.tier4RenewalBusiness_brokerFee.sendKeys(ExcelReader.get_row_data_from_col("Tier 4 Broker Fee For Renewal Business", row_num));
			
			AutoRenewalBrokerFeeLocators.tieredBrokerFee_submitButton.click();
		}
		
		WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.alert_continueButton);
		AutoRenewalBrokerFeeLocators.alert_continueButton.click();
		WaitMethods.wait_in_seconds(5);
		//GenericMethods.press_key_using_robot(Key.PAGE_UP);
		WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.close_button);
		GenericMethods.click_Element_Using_JS(AutoRenewalBrokerFeeLocators.close_button);
		
		}
		catch(UnhandledAlertException | ElementNotVisibleException | NoSuchElementException exe)
		{
			log.debug("The exception was found "+exe.getClass().getCanonicalName());
		}
		catch(WebDriverException exe)
		{
			log.info("unable to find the element in the web page");
		}
		/*WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.gotoSubmissions_button);
		AutoRenewalBrokerFeeLocators.gotoSubmissions_button.click();*/
	}
	
	/*
	 * Purpose: This method is used to fill the comparative rater info for a submission
	 * @param int row_number from excel
	 * @return NA
	 */
	public static void fill_comparative_rater_info(int row_num) throws IOException, InterruptedException, AWTException
	{
		GeneralLiabilityMethods.fill_GL_comparativeRater_info(row_num);
	}


	/*
	 * Purpose: This method is to fill the price indicator and eligibility info while creating a submission
	 * @param (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void fill_price_indicatorandeligibility_info(int row_num) throws IOException, InterruptedException
	{
		GeneralLiabilityMethods.fill_GL_price_indicatorandeligibility_info(row_num);
	}

	/*
	 * Purpose: This method is to fill the application info while creating a submission
	 * @param (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void fill_application_info(int row_num) throws IOException, InterruptedException
	{
		GeneralLiabilityMethods.fill_GL_application_info(row_num);
	}



	/*
	 * Purpose: This method is to save the rating work sheet of a submission
	 * @param (String Submission type, String Submission id, Row_number of Excel sheet)
	 * @return NA
	 */
	public static void save_ratingWorkSheet(String submission_type,String submission_id,int row_num) throws AWTException, IOException, InterruptedException
	{	
		GeneralLiabilityMethods.save_GL_ratingWorkSheet(submission_type, submission_id, row_num);
	}

	/*
	 * Purpose: This method is to change the status of a submission
	 * @param (String submission id, string status to be changed, int Row_number of Excel sheet)
	 * @return NA
	 */
	public static void change_status(String submission_id,String status_tobe_changed, int row_num) throws InterruptedException, IOException
	{
		GeneralLiabilityMethods.GL_change_status(submission_id, status_tobe_changed, row_num);
	}
	public static void change_status_okToBind() throws IOException, InterruptedException
	{
		try
		{
			load_data();
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
			GenericMethods.navigate_to_next_window();

			/*init_admin();
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_admin();
		AdminSubmissionPageLocators.submission_id_searchfield.clear();
		AdminSubmissionPageLocators.submission_id_searchfield.sendKeys(submission_id);
		WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
		GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);*/
			BrokerFeeInfo.change_status();
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
	 * Purpose: This method is to click on binding doc link after changing the status of a submission
	 * @param String submission id, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void click_bindingDoc_link(String submission_id,int row_num) throws InterruptedException, AWTException, IOException
	{
		try
		{
			WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.selectBy_drpDwn);
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
			GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.selectBy_drpDwn, "visibletext", OR.getProperty("selectby"));
			AdminSubmissionPageLocators.submission_id_searchfield.clear();
			AdminSubmissionPageLocators.submission_id_searchfield.sendKeys(ExcelReader.get_row_data_from_col(submission_id, row_num));
			
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
			WaitMethods.wait_in_seconds(3);
			log.info("//===========================> Clicking on Binding Documents<=============================");
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_table_row);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
			WaitMethods.wait_in_seconds(3);
			WaitMethods.wait_for_element_present(DefaultBrokerFeeLocators.bindingDocuments_link);
			GenericMethods.click_Element_Using_JS(DefaultBrokerFeeLocators.bindingDocuments_link);
			log.info("//===========================> Clicked on Binding Document Link<=============================");
			WaitMethods.wait_in_seconds(5);
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
	 * Purpose: This method is to verify the payment option in a binding doc
	 * @param integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void verify_payment_option(int row_num) throws IOException
	{
		try
		{
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "Agency_Info");
			GenericMethods.navigate_to_next_window();
			String s1=ExcelReader.get_row_data_from_col("Direct_Bill", row_num);
			String s2=ExcelReader.get_row_data_from_col("Agency_Bill", row_num);
			String s3=ExcelReader.get_row_data_from_col("Premium_Finance", row_num);	
			try
			{

				if(s1.equalsIgnoreCase("true") && s2.equalsIgnoreCase("false") && s3.equalsIgnoreCase("false"))
				{
					WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.bd_directbill_radiobtn);
					Assert.assertEquals(GenericMethods.is_element_present(AutoRenewalBrokerFeeLocators.bd_directbill_radiobtn), s1);
					Assert.assertEquals(GenericMethods.is_element_present(AutoRenewalBrokerFeeLocators.bd_agcyFinanceOption_radiobtn), s2);
					Assert.assertEquals(GenericMethods.is_element_present(AutoRenewalBrokerFeeLocators.bd_premiumFinanceOption_radiobtn), s3);
					log.info("//===========================> Payment Option available in Binding Document is: Direct Bill<=============================");
				}
			}
			catch (AssertionError e)
			{
				System.out.println("The Payment Option Does's match as per the Agency criteria");
			}
			try
			{
				if(s1.equalsIgnoreCase("true") && s2.equalsIgnoreCase("true") && s3.equalsIgnoreCase("false"))
				{
					WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.bd_directbill_radiobtn);
					Assert.assertEquals(GenericMethods.is_element_present(AutoRenewalBrokerFeeLocators.bd_directbill_radiobtn), s1);
					WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.bd_agcyFinanceOption_radiobtn);
					Assert.assertEquals(GenericMethods.is_element_present(AutoRenewalBrokerFeeLocators.bd_agcyFinanceOption_radiobtn), s2);
					Assert.assertEquals(GenericMethods.is_element_present(AutoRenewalBrokerFeeLocators.bd_premiumFinanceOption_radiobtn), s3);
					log.info("//===========================> Payment Options available in Binding Document are: Direct Bill, Agency Bill<=============================");
				}
			}
			catch (AssertionError e)
			{
				System.out.println("The Payment Option Does's match as per the Agency criteria");
			}

			try
			{
				if(s1.equalsIgnoreCase("true") && s2.equalsIgnoreCase("true") && s3.equalsIgnoreCase("true"))
				{
					WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.bd_directbill_radiobtn);
					Assert.assertEquals(GenericMethods.is_element_present(AutoRenewalBrokerFeeLocators.bd_directbill_radiobtn), s1);
					WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.bd_agcyFinanceOption_radiobtn);
					Assert.assertEquals(GenericMethods.is_element_present(AutoRenewalBrokerFeeLocators.bd_agcyFinanceOption_radiobtn), s2);
					WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.bd_premiumFinanceOption_radiobtn);
					Assert.assertEquals(GenericMethods.is_element_present(AutoRenewalBrokerFeeLocators.bd_premiumFinanceOption_radiobtn), s3);

					log.info("//===========================> Payment Options available in Binding Document are: Direct Bill, Agency Bill, Premium Finanace<=============================");
				}

			}
			catch (AssertionError e)
			{
				System.out.println("The Payment Option Doesn't match as per the Agency criteria");
			}				
			log.info("//===========================> Payment Option Matched<=============================");
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
	 * Purpose: This method is to validate the no default broker fee info in the binding document of a submission
	 * @param String broker fee type, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void validate_nodefault_brokerFee(String broker_fee_type, int row_num) throws IOException
	{
		try
		{
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "BrokerFee_Data");
			WaitMethods.wait_for_page_load(10);
			GenericMethods.navigate_to_next_window();
			try {
				Assert.assertEquals(GenericMethods.convert_decimal_stringto_integer(GenericMethods.getTextfmElem(AutoRenewalBrokerFeeLocators.agency_broker_fee_field)), GenericMethods.convert_stingto_integer(ExcelReader.get_row_data_from_col(broker_fee_type, row_num)));	
				log.info("//===========================> Broker Fee Details in Binding Doc/Renewal Info Page Matched<=============================");
			} 
			catch (AssertionError err) {

				log.info("//===========================> Broker Fee Details Not Matched<=============================");
			}
			catch(NoSuchElementException exe)
			{
				log.info("unable to find the element in the web page");
			}
			try {
				Assert.assertEquals(GenericMethods.convert_decimal_stringto_integer(GenericMethods.get_text(AutoRenewalBrokerFeeLocators.renewalLetter_brokerfee)), GenericMethods.convert_stingto_integer(ExcelReader.get_row_data_from_col(broker_fee_type, row_num)));
				log.info("//===========================> Broker Fee Details in Renewal Letter Matched<=============================");
			}
			catch (AssertionError err) {

				log.info("//===========================> Broker Fee Details Not Matched<=============================");
			}
			catch(NoSuchElementException exe)
			{
				log.info("unable to find the element in the web page");
			}
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
	 * Purpose: This method is to validate the flat broker fee info in the binding document of a submission
	 * @param String broker fee type, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void validate_flat_brokerFee(String broker_fee_type, int row_num) throws IOException
	{
		try
		{
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "BrokerFee_Data");
			WaitMethods.wait_for_page_load(10);
			GenericMethods.navigate_to_next_window();
			try {
				Assert.assertEquals(GenericMethods.convert_decimal_stringto_integer(GenericMethods.getTextfmElem(AutoRenewalBrokerFeeLocators.agency_broker_fee_field)), GenericMethods.convert_stingto_integer(ExcelReader.get_row_data_from_col(broker_fee_type, row_num)));
				log.info("//===========================> Broker Fee Details Matched<=============================");
			} catch (AssertionError err) {

				log.info("//===========================> Broker Fee Details Not Matched<=============================");
			}
			catch(NoSuchElementException exe)
			{
				log.info("unable to find the element in the web page");
			}
			try {
				Assert.assertEquals(GenericMethods.convert_decimal_stringto_integer(GenericMethods.get_text(AutoRenewalBrokerFeeLocators.renewLetter_BrokerFee)), GenericMethods.convert_stingto_integer(ExcelReader.get_row_data_from_col(broker_fee_type, row_num)));
				log.info("//===========================> Broker Fee Details in Renewal Letter Matched<=============================");
			}
			catch (AssertionError err) {

				log.info("//===========================> Broker Fee Details Not Matched<=============================");
			}
			catch(NoSuchElementException exe)
			{
				log.info("unable to find the element in the web page");
			}
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
	 * Purpose: This method is to update the broker fee value in the binding document of a submission
	 * @param String broker fee type(no default, flat, percentage, tiered), String business type(new, renewal), integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void update_brokerFee_value(String brokerFee_type, String business_type, int row_num) throws IOException
	{
		try
		{
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "BrokerFee_Data");

			log.info("//===========================> updating Broker Fee Value<=============================");
			AutoRenewalBrokerFeeLocators.agency_broker_fee_field.clear();

			if(brokerFee_type.equalsIgnoreCase("nodefault") && business_type.equalsIgnoreCase("new"))
			{
				AutoRenewalBrokerFeeLocators.agency_broker_fee_field.sendKeys(ExcelReader.get_row_data_from_col("Updated No Default BrokerFee for New Business", row_num));	
			}
			else if(brokerFee_type.equalsIgnoreCase("nodefault") && business_type.equalsIgnoreCase("renewal"))
			{
				AutoRenewalBrokerFeeLocators.agency_broker_fee_field.sendKeys(ExcelReader.get_row_data_from_col("Updated No Default BrokerFee Renewal Business", row_num));	
			}

			if(brokerFee_type.equalsIgnoreCase("Flat") && business_type.equalsIgnoreCase("new"))
			{
				AutoRenewalBrokerFeeLocators.agency_broker_fee_field.sendKeys(ExcelReader.get_row_data_from_col("Updated Flat Broker Fee for New Business", row_num));	
			}
			else if(brokerFee_type.equalsIgnoreCase("Flat") && business_type.equalsIgnoreCase("renewal"))
			{
				AutoRenewalBrokerFeeLocators.agency_broker_fee_field.sendKeys(ExcelReader.get_row_data_from_col("Updated Flat Broker Fee for Renewal Business", row_num));	
			}
			else if(brokerFee_type.equalsIgnoreCase("Percentage") && business_type.equalsIgnoreCase("new"))
			{
				AutoRenewalBrokerFeeLocators.agency_broker_fee_field.sendKeys(ExcelReader.get_row_data_from_col("Updated Percentage Broker Fee for New Business", row_num));	
			}
			else if(brokerFee_type.equalsIgnoreCase("Percentage") && business_type.equalsIgnoreCase("renewal"))
			{
				AutoRenewalBrokerFeeLocators.agency_broker_fee_field.sendKeys(ExcelReader.get_row_data_from_col("Updated Percentage Broker Fee for Renewal Business", row_num));	
			}
			else if(brokerFee_type.equalsIgnoreCase("tiered") && business_type.equalsIgnoreCase("new"))
			{
				AutoRenewalBrokerFeeLocators.agency_broker_fee_field.sendKeys(ExcelReader.get_row_data_from_col("Updated Tiered Broker Fee For New Business", row_num));	
			}
			else if(brokerFee_type.equalsIgnoreCase("tiered") && business_type.equalsIgnoreCase("renewal"))
			{
				AutoRenewalBrokerFeeLocators.agency_broker_fee_field.sendKeys(ExcelReader.get_row_data_from_col("Updated Tiered Broker Fee for Renewal Business", row_num));	
			}
		}
		catch(UnhandledAlertException | ElementNotVisibleException | NoSuchElementException exe)
		{
			log.debug("The exception was found "+exe.getClass().getCanonicalName());
		}
		catch(WebDriverException exe)
		{
			log.info("unable to find the element in the web page");
		}

		log.info("//===========================> Broker Fee Value Updated<=============================");

	}

	/*
	 * Purpose: This method is to fill the payment info in the binding document of a submission
	 * @param String payment_type(DirectBill, Agency Finance, Premium Finance) type, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void fill_bindingDoc_info(String payment_type,int row_num) throws IOException, InterruptedException
	{
		try
		{
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "BindingDoc_Info");

			log.info("//===========================> Started Filling Binding Doc Info <=============================");
			if(payment_type.equalsIgnoreCase("directbill"))
			{
				AutoRenewalBrokerFeeLocators.bd_directbill_radiobtn.click();
				/*AutoRenewalBrokerFeeLocators.insureds_email_address.clear();
				AutoRenewalBrokerFeeLocators.insureds_email_address.sendKeys(ExcelReader.get_row_data_from_col("Insureds Email Address", row_num));*/
				WaitMethods.wait_in_seconds(3);
				GenericMethods.scroll_down();
				WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.onePay_payNow_radiobtn);
				GenericMethods.click_Element_Using_JS(AutoRenewalBrokerFeeLocators.onePay_payNow_radiobtn);
				WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.paymentMthd_creditCard_radioBtn);
				String checked=GenericMethods.is_chekbox_selected(AutoRenewalBrokerFeeLocators.paymentMthd_creditCard_radioBtn);
				if(checked=="false")
				{
					GenericMethods.click_Element_Using_JS(AutoRenewalBrokerFeeLocators.paymentMthd_creditCard_radioBtn);
				}
				//AutoRenewalBrokerFeeLocators.paymentMthd_creditCard_radioBtn.click();
				WaitMethods.wait_in_seconds(5);
				GenericMethods.select_from_dropdown(AutoRenewalBrokerFeeLocators.bd_cardType_dropDown, "visibletext", ExcelReader.get_row_data_from_col("Card Type", row_num));
				WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.bd_cardNum_textField);
				AutoRenewalBrokerFeeLocators.bd_cardNum_textField.sendKeys(ExcelReader.get_row_data_from_col("Card Number", row_num));
				AutoRenewalBrokerFeeLocators.bd_card_expirationMnth.sendKeys(ExcelReader.get_row_data_from_col("Expiration Month", row_num));
				AutoRenewalBrokerFeeLocators.bd_card_expirationYear.sendKeys(ExcelReader.get_row_data_from_col("Expiration Year", row_num));
				AutoRenewalBrokerFeeLocators.bd_card_securityCode.sendKeys(ExcelReader.get_row_data_from_col("Security Code", row_num));
				AutoRenewalBrokerFeeLocators.bd_nameOnCard.sendKeys(ExcelReader.get_row_data_from_col("Name On Card", row_num));
				AutoRenewalBrokerFeeLocators.bd_address_txtField.sendKeys(ExcelReader.get_row_data_from_col("Address", row_num));
				AutoRenewalBrokerFeeLocators.bd_city_txtField.sendKeys(ExcelReader.get_row_data_from_col("City", row_num));
				GenericMethods.select_from_dropdown(AutoRenewalBrokerFeeLocators.bd_selectState_drpDown, "visibletext", ExcelReader.get_row_data_from_col("State", row_num));
				AutoRenewalBrokerFeeLocators.bd_zipCode_txtField.sendKeys(ExcelReader.get_row_data_from_col("Zip Code", row_num));
				AutoRenewalBrokerFeeLocators.bd_TermsAndConditions_chkBox.click();
			}
			else if(payment_type.equalsIgnoreCase("AgencyFinance"))
			{
				WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.bd_agcyFinanceOption_radiobtn);
				GenericMethods.click_Element_Using_JS(AutoRenewalBrokerFeeLocators.bd_agcyFinanceOption_radiobtn);
			}	
			else if(payment_type.equalsIgnoreCase("PremiumFinance"))
			{
				WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.bd_premiumFinanceOption_radiobtn);
				GenericMethods.click_Element_Using_JS(AutoRenewalBrokerFeeLocators.bd_premiumFinanceOption_radiobtn);
				WaitMethods.wait_in_seconds(3);
				                
				WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.bd_Paperless_premiumFinance_radio);
				GenericMethods.click_Element_Using_JS(AutoRenewalBrokerFeeLocators.bd_Paperless_premiumFinance_radio);
				
				verify_finance_agreement_link();
                GenericMethods.navigate_to_next_window();
                
				if(GenericMethods.is_chekbox_selected(AutoRenewalBrokerFeeLocators.verify_bdPremium_finance).equalsIgnoreCase("false"))
				{
					GenericMethods.click_Element_Using_JS(AutoRenewalBrokerFeeLocators.verify_bdPremium_finance);
				}
				WaitMethods.wait_in_seconds(5);
			}

			log.info("//===========================> Completed Filling Binding Doc Info <=============================");
			WaitMethods.wait_in_seconds(5);
			try
			{
				WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.bindingDoc_save_button);
				GenericMethods.click_Element_Using_JS(AutoRenewalBrokerFeeLocators.bindingDoc_save_button);
				WaitMethods.wait_in_seconds(3);
				log.info("//===========================> Clicked on Save Button <=============================");
			}
			catch(ElementNotVisibleException e)
			{
				log.info("===============There is no Save button available==================");
			}
		}
		catch(UnhandledAlertException | ElementNotVisibleException | NoSuchElementException exe)
		{
			log.debug("The exception was found "+exe.getClass().getCanonicalName());
		}
		catch(WebDriverException exe)
		{
			log.info("There is a webdriver exception");
		}
		WaitMethods.wait_in_seconds(3);
		driver.close();
	}
	
	/*
	 * Purpose: This method is to click on Review your premium finance agreement link
	 * @param String payment_type(DirectBill, Agency Finance, Premium Finance) type, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void verify_finance_agreement_link() throws IOException, InterruptedException
	{
		WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.premiumFinance_agreementLink);
		GenericMethods.click_Element_Using_JS(AutoRenewalBrokerFeeLocators.premiumFinance_agreementLink);
		GenericMethods.navigate_to_next_window();
		GenericMethods.validate_text_in_pdf("PREMIUM FINANCE AGREEMENT");
		GenericMethods.close_browser_window();
	}

	/*
	 * Purpose: This method is to validate the updated broker fee in the binding document of a submission
	 * @param String submission_id( from excel), String updated_brokerfee(from excel), integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void verify_updated_brokerfee(String submission_id, String updated_brokerFee, int row_num) throws IOException, InterruptedException
	{
		try
		{
			load_data();
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
			GenericMethods.navigate_to_next_window();
			WaitMethods.wait_in_seconds(5);
			AdminSubmissionPageLocators.submission_id_searchfield.clear();
			AdminSubmissionPageLocators.submission_id_searchfield.sendKeys(ExcelReader.get_row_data_from_col(submission_id, row_num));
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
			WaitMethods.wait_in_seconds(3);
			//GenericMethods.scroll_down_to_element(AdminSubmissionPageLocators.submission_table_row);
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_table_row);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
			WaitMethods.wait_in_seconds(3);
			WaitMethods.wait_for_element_present(DefaultBrokerFeeLocators.bindingDocuments_link);
			GenericMethods.click_Element_Using_JS(DefaultBrokerFeeLocators.bindingDocuments_link);
			GenericMethods.navigate_to_next_window();
			log.info("//===========================> Clicked on Binding Document<=============================");
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "BrokerFee_Data");
			try
			{
				Assert.assertEquals(GenericMethods.getTextfmElem(AutoRenewalBrokerFeeLocators.agency_broker_fee_field), ExcelReader.get_row_data_from_col(updated_brokerFee, row_num));
				log.info("//===========================> Broker Fee Value matched with the Updated Value<=============================");
			}catch (AssertionError err) {
				log.info("//===========================> Broker Fee Value Doesn't Match with the Updated value<=============================");
			}
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
	
	//Just To Display - Ploicy No.
	public static void toDisplay_policyNo(String submission_id, int row_num) throws IOException, InterruptedException
	{
		ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
		WaitMethods.wait_in_seconds(5);
		AdminSubmissionPageLocators.submission_id_searchfield.clear();
		AdminSubmissionPageLocators.submission_id_searchfield.sendKeys(ExcelReader.get_row_data_from_col(submission_id, row_num));
		WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
		GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
		WaitMethods.wait_in_seconds(5);			
		WaitMethods.wait_for_elements_present(GeneralLiabilityPageLocators.submission_id);
		String policy_num= AutoRenewalBrokerFeeLocators.policy_number.getText();
		ExcelReader.set_cell_data("Policy_Number", row_num, policy_num);
		log.info("=====================QCS submission with SOLD ploicy number is : ================= "+policy_num+ " ============================================");
	}
	/*
	 * Purpose: This method is to change the submission to renewal for a submission
	 * @param String submission_id(from excel), integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void change_submission_renewal(String submission_id, int row_num) throws IOException, InterruptedException
	{
		try
		{
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
			WaitMethods.wait_in_seconds(5);
			AdminSubmissionPageLocators.submission_id_searchfield.clear();
			AdminSubmissionPageLocators.submission_id_searchfield.sendKeys(ExcelReader.get_row_data_from_col(submission_id, row_num));
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
			WaitMethods.wait_in_seconds(5);			
			WaitMethods.wait_for_elements_present(GeneralLiabilityPageLocators.submission_id);
			String policy_num= AutoRenewalBrokerFeeLocators.policy_number.getText();
			ExcelReader.set_cell_data("Policy_Number", row_num, policy_num);
			GenericMethods.click_from_webElementList(GeneralLiabilityPageLocators.submission_id, ExcelReader.get_row_data_from_col(submission_id, row_num));
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.renewal_link);
			WaitMethods.wait_in_seconds(5);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.renewal_link);
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
	 * Purpose: This method is to validate the percentage broker fee in the binding doc for a submission
	 * @param String submission_type(new or renewal), integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void validate_percentage_brokerFee(String submission_type, int row_num) throws IOException
	{
		try
		{
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "BrokerFee_Data");
			WaitMethods.wait_for_page_load(10);
			GenericMethods.navigate_to_next_window();
			float subtotal=Float.parseFloat(ExcelReader.get_row_data_from_col("Subtotal GL Premium", row_num));
			float inland_marine_value=Float.parseFloat(ExcelReader.get_row_data_from_col("Inland Marine Value", row_num));
			if(submission_type.equalsIgnoreCase("new"))
			{
				String Per_bfee_newbusiness=GenericMethods.get_integer_from_string(ExcelReader.get_row_data_from_col("Percentage Broker Fee for New Business", row_num));
				System.out.println("The Percentage Value of New Business= " +Per_bfee_newbusiness);
				float bfee_new=GenericMethods.convert_stingto_float(Per_bfee_newbusiness);
				float result_new=(subtotal+inland_marine_value)*bfee_new;
				result_new=result_new/100;
				int broker_fee_new= GenericMethods.round_up(result_new);
				//String new_broker_fee_value=GenericMethods.convert_integerto_string(broker_fee_new);
				try {
					Assert.assertEquals(GenericMethods.convert_decimal_stringto_integer(GenericMethods.getTextfmElem(AutoRenewalBrokerFeeLocators.agency_broker_fee_field)), broker_fee_new);
					log.info("//===========================> Broker Fee Details Matched<=============================");
				} catch (AssertionError err) {

					log.info("//===========================> Broker Fee Details Not Matched<=============================");
				}
				catch(NoSuchElementException exe)
				{
					log.info("unable to find the element in the web page");
				}
				try {
					Assert.assertEquals(GenericMethods.convert_decimal_stringto_integer(GenericMethods.get_text(AutoRenewalBrokerFeeLocators.renewalLetter_brokerfee)), broker_fee_new);
					log.info("//===========================> Broker Fee Details Matched<=============================");
				} catch (AssertionError err) {

					log.info("//===========================> Broker Fee Details Not Matched<=============================");
				}
				catch(NoSuchElementException exe)
				{
					log.info("unable to find the element in the web page");
				}
			}
			else if(submission_type.equalsIgnoreCase("renewal"))
			{
				String Per_bfee_renewalbusiness=GenericMethods.get_integer_from_string(ExcelReader.get_row_data_from_col("Percentage Broker Fee for Renewal Business", row_num));
				System.out.println("The Percentage Value of New Business= " +Per_bfee_renewalbusiness);
				float bfee_renewal=GenericMethods.convert_stingto_float(Per_bfee_renewalbusiness);
				float result_renewal=(subtotal+inland_marine_value)*bfee_renewal;
				result_renewal=result_renewal/100;
				int broker_fee_renewal= GenericMethods.round_up(result_renewal);
				//String renewal_broker_fee_value=GenericMethods.convert_integerto_string(broker_fee_renewal);
				try {
					Assert.assertEquals(GenericMethods.convert_decimal_stringto_integer(GenericMethods.getTextfmElem(AutoRenewalBrokerFeeLocators.agency_broker_fee_field)), broker_fee_renewal);
					log.info("//===========================> Broker Fee Details Matched<=============================");
				} catch (AssertionError err) {

					log.info("//===========================> Broker Fee Details Not Matched<=============================");
				}	
				catch(NoSuchElementException exe)
				{
					log.info("unable to find the element in the web page");
				}
				try {
					Assert.assertEquals(GenericMethods.convert_decimal_stringto_integer(GenericMethods.get_text(AutoRenewalBrokerFeeLocators.renewalLetter_brokerfee)), broker_fee_renewal);
					log.info("//===========================> Broker Fee Details Matched<=============================");
				} catch (AssertionError err) {

					log.info("//===========================> Broker Fee Details Not Matched<=============================");
				}
				catch(NoSuchElementException exe)
				{
					log.info("unable to find the element in the web page");
				}
			}
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
	 * Purpose: This method is to validate the tiered broker fee in the binding doc for a submission
	 * @param String submission_type(new or renewal), integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void validate_tiered_brokerfee(String submission_type,int row_num) throws IOException
	{
		try
		{
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "BrokerFee_Data");
			WaitMethods.wait_for_page_load(10);
			GenericMethods.navigate_to_next_window();
			driver.manage().window().maximize();
			int sub_total_gl=GenericMethods.convert_stingto_integer(ExcelReader.get_row_data_from_col("Subtotal GL Premium", row_num));
			int inland_marine=GenericMethods.convert_stingto_integer(ExcelReader.get_row_data_from_col("Inland Marine Value", row_num));
			int subtoatal_and_marine=sub_total_gl+inland_marine;
			int tier1_newbusiness_starting_value=GenericMethods.convert_stingto_integer(ExcelReader.get_row_data_from_col("Tier 1 New Business Starting Value", row_num));
			int tier1_newbusiness_value=GenericMethods.convert_stingto_integer(ExcelReader.get_row_data_from_col("Tier 1 New Business Value", row_num));
			int tier2_newbusiness_value=GenericMethods.convert_stingto_integer(ExcelReader.get_row_data_from_col("Tier 2 New Business Value", row_num));
			int tier3_newbusiness_value=GenericMethods.convert_stingto_integer(ExcelReader.get_row_data_from_col("Tier 3 New Business Value", row_num));
			int tier1_brokerfee_newbusiness=GenericMethods.convert_stingto_integer(ExcelReader.get_row_data_from_col("Tier 1 Broker Fee For New Business", row_num));
			int tier2_brokerfee_newbusiness=GenericMethods.convert_stingto_integer(ExcelReader.get_row_data_from_col("Tier 2 Broker Fee For New Business", row_num));
			int tier3_brokerfee_newbusiness=GenericMethods.convert_stingto_integer(ExcelReader.get_row_data_from_col("Tier 3 Broker Fee For New Business", row_num));
			int tier4_brokerfee_newbusiness=GenericMethods.convert_stingto_integer(ExcelReader.get_row_data_from_col("Tier 4 Broker Fee For New Business", row_num));
			int tier1_renewalbusiness_starting_value=GenericMethods.convert_stingto_integer(ExcelReader.get_row_data_from_col("Tier 1 Renewal Business Starting Value", row_num));
			int tier1_renewalbusiness_value=GenericMethods.convert_stingto_integer(ExcelReader.get_row_data_from_col("Tier 1 Renewal Business Value", row_num));
			int tier2_renewalbusiness_value=GenericMethods.convert_stingto_integer(ExcelReader.get_row_data_from_col("Tier 2 Renewal Business Value", row_num));
			int tier3_renewalbusiness_value=GenericMethods.convert_stingto_integer(ExcelReader.get_row_data_from_col("Tier 3 Renewal Business Value", row_num));
			int tier1_brokerfee_renewalbusiness=GenericMethods.convert_stingto_integer(ExcelReader.get_row_data_from_col("Tier 1 Broker Fee For Renewal Business", row_num));
			int tier2_brokerfee_renewalbusiness=GenericMethods.convert_stingto_integer(ExcelReader.get_row_data_from_col("Tier 2 Broker Fee For Renewal Business", row_num));
			int tier3_brokerfee_renewalbusiness=GenericMethods.convert_stingto_integer(ExcelReader.get_row_data_from_col("Tier 3 Broker Fee For Renewal Business", row_num));
			int tier4_brokerfee_renewalbusiness=GenericMethods.convert_stingto_integer(ExcelReader.get_row_data_from_col("Tier 1 Broker Fee For Renewal Business", row_num));
			if(submission_type.equalsIgnoreCase("new"))
			{
				if(subtoatal_and_marine>=tier1_newbusiness_starting_value && subtoatal_and_marine<=tier1_newbusiness_value)
				{
					try {			
						int actual_brokerfee_value=GenericMethods.convert_stingto_integer(GenericMethods.getTextfmElem(AutoRenewalBrokerFeeLocators.agency_broker_fee_field));
						Assert.assertEquals(actual_brokerfee_value, tier1_brokerfee_newbusiness);
						System.out.println("The actual Broker Fee Value is= "+actual_brokerfee_value);
						System.out.println("The expected Broker Fee Value is= "+tier1_brokerfee_newbusiness);
						log.info("//===========================> Broker Fee Details Matched<=============================");
					} catch (AssertionError err) {

						log.info("//===========================> Broker Fee Details Not Matched<=============================");
					}
					catch(NoSuchElementException exe)
					{
						log.info("unable to find the element in the web page");
					}
					try {
						int renewal_letter_bfee_value=GenericMethods.convert_decimal_stringto_integer((GenericMethods.get_text(AutoRenewalBrokerFeeLocators.renewalLetter_brokerfee)));
						Assert.assertEquals(renewal_letter_bfee_value, tier1_brokerfee_newbusiness);
						System.out.println("The Renewal Letter Broker Fee Value is= "+renewal_letter_bfee_value);
						log.info("//===========================> Broker Fee Details Matched<=============================");
					} catch (AssertionError err) {

						log.info("//===========================> Broker Fee Details Not Matched<=============================");
					}
					catch(NoSuchElementException exe)
					{
						log.info("unable to find the element in the web page");
					}
				}
				else if((subtoatal_and_marine>tier1_newbusiness_value && subtoatal_and_marine<=tier2_newbusiness_value))
				{	
					try {
						int actual_brokerfee_value=GenericMethods.convert_stingto_integer(GenericMethods.getTextfmElem(AutoRenewalBrokerFeeLocators.agency_broker_fee_field));
						Assert.assertEquals(actual_brokerfee_value, tier2_brokerfee_newbusiness);
						System.out.println("The actual Broker Fee Value is= "+actual_brokerfee_value);
						System.out.println("The expected Broker Fee Value is= "+tier2_brokerfee_newbusiness);
						log.info("//===========================> Broker Fee Details Matched<=============================");
					} catch (AssertionError err) {

						log.info("//===========================> Broker Fee Details Not Matched<=============================");
					}
					catch(NoSuchElementException exe)
					{
						log.info("unable to find the element in the web page");
					}
					try {
						int renewal_letter_bfee_value=GenericMethods.convert_decimal_stringto_integer((GenericMethods.get_text(AutoRenewalBrokerFeeLocators.renewalLetter_brokerfee)));
						Assert.assertEquals(renewal_letter_bfee_value, tier2_brokerfee_newbusiness);
						System.out.println("The Renewal Letter Broker Fee Value is= "+renewal_letter_bfee_value);
						log.info("//===========================> Broker Fee Details Matched<=============================");
					} catch (AssertionError err) {

						log.info("//===========================> Broker Fee Details Not Matched<=============================");
					}
					catch(NoSuchElementException exe)
					{
						log.info("unable to find the element in the web page");
					}

				}
				else if((subtoatal_and_marine>tier2_newbusiness_value && subtoatal_and_marine<=tier3_newbusiness_value))
				{
					try {
						int actual_brokerfee_value=GenericMethods.convert_stingto_integer(GenericMethods.getTextfmElem(AutoRenewalBrokerFeeLocators.agency_broker_fee_field));
						Assert.assertEquals(actual_brokerfee_value, tier3_brokerfee_newbusiness);
						System.out.println("The actual Broker Fee Value is= "+actual_brokerfee_value);
						System.out.println("The expected Broker Fee Value is= "+tier3_brokerfee_newbusiness);
						log.info("//===========================> Broker Fee Details Matched<=============================");
					} catch (AssertionError err) {

						log.info("//===========================> Broker Fee Details Not Matched<=============================");
					}
					catch(NoSuchElementException exe)
					{
						log.info("unable to find the element in the web page");
					}

					try {
						int renewal_letter_bfee_value=GenericMethods.convert_decimal_stringto_integer((GenericMethods.get_text(AutoRenewalBrokerFeeLocators.renewalLetter_brokerfee)));
						Assert.assertEquals(renewal_letter_bfee_value, tier3_brokerfee_newbusiness);
						System.out.println("The Renewal Letter Broker Fee Value is= "+renewal_letter_bfee_value);
						log.info("//===========================> Broker Fee Details Matched<=============================");
					} catch (AssertionError err) {

						log.info("//===========================> Broker Fee Details Not Matched<=============================");
					}
					catch(NoSuchElementException exe)
					{
						log.info("unable to find the element in the web page");
					}

				}
				else if((subtoatal_and_marine>tier3_newbusiness_value))
				{	
					try {
						int actual_brokerfee_value=GenericMethods.convert_stingto_integer(GenericMethods.getTextfmElem(AutoRenewalBrokerFeeLocators.agency_broker_fee_field));
						Assert.assertEquals(actual_brokerfee_value, tier4_brokerfee_newbusiness);
						System.out.println("The actual Broker Fee Value is= "+actual_brokerfee_value);
						System.out.println("The expected Broker Fee Value is= "+tier4_brokerfee_newbusiness);
						log.info("//===========================> Broker Fee Details Matched<=============================");
					} catch (AssertionError err) {

						log.info("//===========================> Broker Fee Details Not Matched<=============================");
					}
					catch(NoSuchElementException exe)
					{
						log.info("unable to find the element in the web page");
					}
					try {
						int renewal_letter_bfee_value=GenericMethods.convert_decimal_stringto_integer((GenericMethods.get_text(AutoRenewalBrokerFeeLocators.renewalLetter_brokerfee)));
						Assert.assertEquals(renewal_letter_bfee_value, tier4_brokerfee_newbusiness);
						System.out.println("The Renewal Letter Broker Fee Value is= "+renewal_letter_bfee_value);
						log.info("//===========================> Broker Fee Details Matched<=============================");
					} catch (AssertionError err) {

						log.info("//===========================> Broker Fee Details Not Matched<=============================");
					}
					catch(NoSuchElementException exe)
					{
						log.info("unable to find the element in the web page");
					}

				}

			}
			if(submission_type.equalsIgnoreCase("renewal"))
			{
				if(subtoatal_and_marine>=tier1_renewalbusiness_starting_value && subtoatal_and_marine<=tier1_renewalbusiness_value)
				{
					try {
						int actual_brokerfee_value=GenericMethods.convert_stingto_integer(GenericMethods.getTextfmElem(AutoRenewalBrokerFeeLocators.agency_broker_fee_field));
						Assert.assertEquals(actual_brokerfee_value, tier1_brokerfee_renewalbusiness);
						System.out.println("The actual Broker Fee Value is= "+actual_brokerfee_value);
						System.out.println("The expected Broker Fee Value is= "+tier1_brokerfee_renewalbusiness);
						log.info("//===========================> Broker Fee Details Matched<=============================");
					} catch (AssertionError err) {
						log.info("//===========================> Broker Fee Details Not Matched<=============================");
					}
					catch(NoSuchElementException exe)
					{
						log.info("unable to find the element in the web page");
					}
					try {
						int renewal_letter_bfee_value=GenericMethods.convert_decimal_stringto_integer((GenericMethods.get_text(AutoRenewalBrokerFeeLocators.renewalLetter_brokerfee)));
						Assert.assertEquals(renewal_letter_bfee_value, tier1_brokerfee_renewalbusiness);
						System.out.println("The Renewal Letter Broker Fee Value is= "+renewal_letter_bfee_value);
						log.info("//===========================> Broker Fee Details Matched<=============================");
					} catch (AssertionError err) {

						log.info("//===========================> Broker Fee Details Not Matched<=============================");
					}
					catch(NoSuchElementException exe)
					{
						log.info("unable to find the element in the web page");
					}
				}
				else if((subtoatal_and_marine>tier1_renewalbusiness_value && subtoatal_and_marine<=tier2_renewalbusiness_value))
				{
					try {
						int actual_brokerfee_value=GenericMethods.convert_stingto_integer(GenericMethods.getTextfmElem(AutoRenewalBrokerFeeLocators.agency_broker_fee_field));
						Assert.assertEquals(actual_brokerfee_value, tier2_brokerfee_renewalbusiness);
						System.out.println("The actual Broker Fee Value is= "+actual_brokerfee_value);
						System.out.println("The expected Broker Fee Value is= "+tier2_brokerfee_renewalbusiness);
						log.info("//===========================> Broker Fee Details Matched<=============================");
					} catch (AssertionError err) {

						log.info("//===========================> Broker Fee Details Not Matched<=============================");
					}
					catch(NoSuchElementException exe)
					{
						log.info("unable to find the element in the web page");
					}
					try {
						int renewal_letter_bfee_value=GenericMethods.convert_decimal_stringto_integer((GenericMethods.get_text(AutoRenewalBrokerFeeLocators.renewalLetter_brokerfee)));
						Assert.assertEquals(renewal_letter_bfee_value, tier2_brokerfee_renewalbusiness);
						System.out.println("The Renewal Letter Broker Fee Value is= "+renewal_letter_bfee_value);
						log.info("//===========================> Broker Fee Details Matched<=============================");
					} catch (AssertionError err) {

						log.info("//===========================> Broker Fee Details Not Matched<=============================");
					}
					catch(NoSuchElementException exe)
					{
						log.info("unable to find the element in the web page");
					}

				}
				else if((subtoatal_and_marine>tier2_renewalbusiness_value && subtoatal_and_marine<=tier3_renewalbusiness_value))
				{
					try {
						int actual_brokerfee_value=GenericMethods.convert_stingto_integer(GenericMethods.getTextfmElem(AutoRenewalBrokerFeeLocators.agency_broker_fee_field));
						Assert.assertEquals(actual_brokerfee_value, tier3_brokerfee_renewalbusiness);
						System.out.println("The actual Broker Fee Value is= "+actual_brokerfee_value);
						System.out.println("The expected Broker Fee Value is= "+tier3_brokerfee_renewalbusiness);
						log.info("//===========================> Broker Fee Details Matched<=============================");
					} catch (AssertionError err) {

						log.info("//===========================> Broker Fee Details Not Matched<=============================");
					}
					catch(NoSuchElementException exe)
					{
						log.info("unable to find the element in the web page");
					}
					try {
						int renewal_letter_bfee_value=GenericMethods.convert_decimal_stringto_integer((GenericMethods.get_text(AutoRenewalBrokerFeeLocators.renewalLetter_brokerfee)));
						Assert.assertEquals(renewal_letter_bfee_value, tier3_brokerfee_renewalbusiness);
						System.out.println("The Renewal Letter Broker Fee Value is= "+renewal_letter_bfee_value);
						log.info("//===========================> Broker Fee Details Matched<=============================");
					} catch (AssertionError err) {

						log.info("//===========================> Broker Fee Details Not Matched<=============================");
					}
					catch(NoSuchElementException exe)
					{
						log.info("unable to find the element in the web page");
					}

				}
				else if((subtoatal_and_marine>tier3_renewalbusiness_value))
				{
					try {
						int actual_brokerfee_value=GenericMethods.convert_stingto_integer(GenericMethods.getTextfmElem(AutoRenewalBrokerFeeLocators.agency_broker_fee_field));
						Assert.assertEquals(actual_brokerfee_value, tier4_brokerfee_renewalbusiness);
						System.out.println("The actual Broker Fee Value is= "+actual_brokerfee_value);
						System.out.println("The expected Broker Fee Value is= "+tier4_brokerfee_renewalbusiness);
						log.info("//===========================> Broker Fee Details Matched<=============================");
					} catch (AssertionError err) {

						log.info("//===========================> Broker Fee Details Not Matched<=============================");
					}
					catch(NoSuchElementException exe)
					{
						log.info("unable to find the element in the web page");
					}
					try {
						int renewal_letter_bfee_value=GenericMethods.convert_decimal_stringto_integer((GenericMethods.get_text(AutoRenewalBrokerFeeLocators.renewalLetter_brokerfee)));
						Assert.assertEquals(renewal_letter_bfee_value, tier4_brokerfee_renewalbusiness);
						System.out.println("The Renewal Letter Broker Fee Value is= "+renewal_letter_bfee_value);
						log.info("//===========================> Broker Fee Details Matched<=============================");
					} catch (AssertionError err) {

						log.info("//===========================> Broker Fee Details Not Matched<=============================");
					}
					catch(NoSuchElementException exe)
					{
						log.info("unable to find the element in the web page");
					}

				}
			}
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
	 * Purpose: This method is to verify the payment information in renewal letter
	 * @param String submission id, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void verify_renewalLetter_paymentInfo(String payment_type, int row_num) throws IOException, TimeoutException
	{	
		
		try
		{
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "Renewal_Letter_Info");
			WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.renewalletter_paymentinfo);
			String renewal_letter_payment=GenericMethods.get_text(AutoRenewalBrokerFeeLocators.renewalletter_paymentinfo);
			
			if(payment_type.equalsIgnoreCase("direct bill"))
			{
				try {
					Assert.assertEquals(renewal_letter_payment, ExcelReader.get_row_data_from_col("Direct Bill", row_num));
					log.info("//===========================> Renewal Letter Payment Details Matched and payment type is: <===" +renewal_letter_payment);
				} catch (AssertionError err) {

					log.info("//===========================> Renewal Letter Payment Details Not Matched<=============================");
				}
				catch(NoSuchElementException exe)
				{
					log.info("unable to find the element in the web page");
				}
			}
			if(payment_type.equalsIgnoreCase("agency finance"))
			{
				try {
					Assert.assertEquals(renewal_letter_payment, ExcelReader.get_row_data_from_col("Agency Finance", row_num));
					log.info("//===========================> Renewal Letter Payment Details Matched and payment type is: <===" +renewal_letter_payment);
				} catch (AssertionError err) {

					log.info("//===========================> Renewal Letter Payment Details Not Matched<=============================");
				}
				catch(NoSuchElementException exe)
				{
					log.info("unable to find the element in the web page");
				}
			}
			if(payment_type.equalsIgnoreCase("premium finance"))
			{
				try {
					Assert.assertEquals(renewal_letter_payment, ExcelReader.get_row_data_from_col("Premium Finance", row_num));
					log.info("//===========================> Renewal Letter Payment Details Matched and payment type is: <===" +renewal_letter_payment);
				} catch (AssertionError err) {

					log.info("//===========================> Renewal Letter Payment Details Not Matched<=============================");
				}
				catch(NoSuchElementException exe)
				{
					log.info("unable to find the element in the web page");
				}
			}
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
	 * Purpose: This method is to click on Renewal Information link after changing the submission to renewal
	 * @param String submission id, integer (Row_number of Excel sheet)
	 * @return NA
	*/
	 
	public static void click_renewalInfo_link(String submission_id,int row_num) throws InterruptedException, AWTException, IOException
	{
		try
		{
			//WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.selectBy_drpDwn);
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
			GenericMethods.navigate_to_next_window();
			//GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.selectBy_drpDwn, "visibletext", OR.getProperty("selectby"));
			AdminSubmissionPageLocators.submission_id_searchfield.clear();
			AdminSubmissionPageLocators.submission_id_searchfield.sendKeys(ExcelReader.get_row_data_from_col(submission_id, row_num));
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
			WaitMethods.wait_in_seconds(3);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
			log.info("//===========================> Clicking on Renewal Info<=============================");
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_table_row);
			WaitMethods.wait_in_seconds(3);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
			WaitMethods.wait_for_element_present(DefaultBrokerFeeLocators.renewalInformation_link);
			GenericMethods.click_Element_Using_JS(DefaultBrokerFeeLocators.renewalInformation_link);
			log.info("//===========================> Clicked on Renewal Info Link<=============================");
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
	 * Purpose: This method is to click on Renewal Letter link after changing the submission to renewal
	 * @param String submission id, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void click_renewalLetter_link(String submission_id,int row_num) throws InterruptedException, AWTException, IOException
	{
		try
		{

			//WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.selectBy_drpDwn);
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
			GenericMethods.navigate_to_next_window();
			//GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.selectBy_drpDwn, "visibletext", OR.getProperty("selectby"));
			AdminSubmissionPageLocators.submission_id_searchfield.clear();
			AdminSubmissionPageLocators.submission_id_searchfield.sendKeys(ExcelReader.get_row_data_from_col(submission_id, row_num));
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
			WaitMethods.wait_in_seconds(3);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
			log.info("//===========================> Clicking on Renewal Letter<=============================");
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_table_row);
			WaitMethods.wait_in_seconds(3);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
			WaitMethods.wait_for_element_present(DefaultBrokerFeeLocators.renewalLetter_link);
			GenericMethods.click_Element_Using_JS(DefaultBrokerFeeLocators.renewalLetter_link);
			GenericMethods.navigate_to_next_window();


			GenericMethods.maximize_window();
			

			GenericMethods.maximize_window();
			

			WaitMethods.wait_in_seconds(3);
			log.info("//===========================> Clicked on Renewal Letter Link<=============================");
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
	 * Purpose: This method is to click on Add additional insured link after changing the submission to sold
	 * @param String submission id, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void additional_insured_request(String submission_id,int row_num) throws InterruptedException, AWTException, IOException
	{
		try
		{
			//WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.selectBy_drpDwn);
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
			GenericMethods.navigate_to_next_window();
			//GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.selectBy_drpDwn, "visibletext", OR.getProperty("selectby"));
			AdminSubmissionPageLocators.submission_id_searchfield.clear();
			GenericMethods.enter_text(AdminSubmissionPageLocators.submission_id_searchfield, ExcelReader.get_row_data_from_col(submission_id, row_num), "Submission Id Search Field");
			WaitMethods.wait_in_seconds(3);
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
			WaitMethods.wait_in_seconds(3);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
			log.info("//===========================> Clicking on Additional Insured Link<=============================");
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_table_row);
			WaitMethods.wait_in_seconds(3);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
			WaitMethods.wait_for_element_present(DefaultBrokerFeeLocators.additionalInsured_link);
			GenericMethods.click_Element_Using_JS(DefaultBrokerFeeLocators.additionalInsured_link);
			log.info("//===========================> Clicked on Additional Insured Link<=============================");
			if(GenericMethods.get_text(AutoRenewalBrokerFeeLocators.additional_insured_verify).equalsIgnoreCase("Additional Insured Request"))
			{
				
				log.info("//======================================>The Page has been successfully re-directed to Add Additional Insured Page<========================");
			}
			else {

				log.info("//===========================> The Page is not redirected to Add Additional Insured Page<=============================");
			}

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
	 * Purpose: This method is to click on Make a Payment link after changing the submission to sold
	 * @param String submission id, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void verify_make_a_payment(String submission_id,int row_num) throws InterruptedException, AWTException, IOException
	{
		try
		{
			//WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.selectBy_drpDwn);
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
			GenericMethods.navigate_to_next_window();
			//GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.selectBy_drpDwn, "visibletext", OR.getProperty("selectby"));
			AdminSubmissionPageLocators.submission_id_searchfield.clear();
			AdminSubmissionPageLocators.submission_id_searchfield.sendKeys(ExcelReader.get_row_data_from_col(submission_id, row_num));
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
			WaitMethods.wait_in_seconds(3);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
			log.info("//===========================> Clicking on Make a Payment Link<=============================");
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_table_row);
			WaitMethods.wait_in_seconds(3);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
			WaitMethods.wait_for_element_present(DefaultBrokerFeeLocators.makePayment_link);
			GenericMethods.click_Element_Using_JS(DefaultBrokerFeeLocators.makePayment_link);
			WaitMethods.wait_in_seconds(5);
			log.info("//===========================> Clicked on Make a Payment Link<=============================");
			if(GenericMethods.get_text(AutoRenewalBrokerFeeLocators.makePaymentPage_verify).equalsIgnoreCase("Make A Payment"))
			{
				
				log.info("//======================================>The Page has been successfully re-directed to Make A Payment Page<========================");
			}
			else {

				log.info("//===========================> The Page is not redirected to Make A Payment Page<=============================");
			}
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
	 * Purpose: This method is to fill the payment information after clicking make a payment link
	 * @param String Payment_type, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void fill_payment_info(String payment_type,int row_num) throws InterruptedException, AWTException, IOException
	{
		try
		{
			GenericMethods.swith_to_frame_using_index(0);
			if(payment_type.equalsIgnoreCase("eCheck"))
			{
				ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "BrokerFee_Data");
				WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.paymentinfo_amount);
				AutoRenewalBrokerFeeLocators.paymentinfo_amount.clear();
				AutoRenewalBrokerFeeLocators.paymentinfo_amount.sendKeys(ExcelReader.get_row_data_from_col("Grandtotal GL Premium", row_num));
				ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "eCheck_Details");
				if(GenericMethods.is_radio_button_selected(AutoRenewalBrokerFeeLocators.payment_method_eCheck).equalsIgnoreCase("false"))
				{
					WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.payment_method_eCheck);
					AutoRenewalBrokerFeeLocators.payment_method_eCheck.click();
				}	
				WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.paymentinfo_comments);
				AutoRenewalBrokerFeeLocators.paymentinfo_comments.sendKeys(ExcelReader.get_row_data_from_col("Comments", row_num));
				WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.eCheck_bankName);
				AutoRenewalBrokerFeeLocators.eCheck_bankName.sendKeys(ExcelReader.get_row_data_from_col("Bank_Name", row_num));
				WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.eCheck_accountType);
				GenericMethods.select_from_dropdown(AutoRenewalBrokerFeeLocators.eCheck_accountType, "visibletext", ExcelReader.get_row_data_from_col("Account_Type", row_num));
				WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.eCheck_checkNumber);
				AutoRenewalBrokerFeeLocators.eCheck_checkNumber.sendKeys(ExcelReader.get_row_data_from_col("Check_Number", row_num));
				WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.eCheck_nameOnAccount);
				AutoRenewalBrokerFeeLocators.eCheck_nameOnAccount.sendKeys(ExcelReader.get_row_data_from_col("Name_on_Account", row_num));
				WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.eCheck_routingNumber);
				AutoRenewalBrokerFeeLocators.eCheck_routingNumber.sendKeys(ExcelReader.get_row_data_from_col("Routing_Number", row_num));
				WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.eCheck_accountNumber);
				AutoRenewalBrokerFeeLocators.eCheck_accountNumber.sendKeys(ExcelReader.get_row_data_from_col("Account_Number", row_num));
				WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.eCheck_confirmAccountNumber);
				AutoRenewalBrokerFeeLocators.eCheck_confirmAccountNumber.sendKeys(ExcelReader.get_row_data_from_col("Account_Number", row_num));
			}	
			WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.eCheck_agreement_chkbox);
			AutoRenewalBrokerFeeLocators.eCheck_agreement_chkbox.click();
			WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.paymentInfo_submitPayment_btn);
			AutoRenewalBrokerFeeLocators.paymentInfo_submitPayment_btn.click();
		}
		catch(UnhandledAlertException | ElementNotVisibleException | NoSuchElementException exe)
		{
			log.debug("The exception was found "+exe.getClass().getCanonicalName());
		}
		catch(WebDriverException exe)
		{
			log.info("WebDriver Exception Handled");
		}
	}

	/*
	 * Purpose: This method is to verify QCR for non-beta agency
	 * @param String submission id, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void verify_nonbeta_QCR(int row_num) throws InterruptedException, AWTException, IOException
	{
		try
		{
			WaitMethods.wait_in_seconds(5);
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_table_row);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
			WaitMethods.wait_in_seconds(5);
			WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.edit_finish_submission);
			GenericMethods.click_Element_Using_JS(AutoRenewalBrokerFeeLocators.edit_finish_submission);		
			WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_existingAmturstPolicy);
			GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.gl_existingAmturstPolicy, "visibletext", ExcelReader.get_row_data_from_col("Available Policy Credits", row_num));
			WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_rateitnow_button);
			GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.gl_rateitnow_button);
			WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.send_renewalLetter_button);
			GenericMethods.click_Element_Using_JS(AutoRenewalBrokerFeeLocators.send_renewalLetter_button);
			GenericMethods.navigate_to_next_window();
			WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.send_email_button);
			GenericMethods.click_Element_Using_JS(AutoRenewalBrokerFeeLocators.send_email_button);
			WaitMethods.wait_in_seconds(3);
			GenericMethods.accept_alert();
			GenericMethods.navigate_to_next_window();
			GenericMethods.close_browser_window();
		}
		catch(UnhandledAlertException | ElementNotVisibleException | NoSuchElementException exe)
		{
			log.debug("The exception was found "+exe.getClass().getCanonicalName());
		}
		catch(WebDriverException exe)
		{
			log.info("WebDriver Exception handled");
		}
	}

	/*
	 * Purpose: This method is to create the submissions till changing the status to renewal
	 * @param integer number of submissions
	 * @return NA
	 */
	public static void create_submissions_and_renewal(int numOfSubmissions) throws IOException, InterruptedException, AWTException, ClassNotFoundException, SQLException, ParseException
	{
		ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
		int Data_in_rows=ExcelReader.get_row_count()-1;
		if(numOfSubmissions>Data_in_rows)
		{
			System.out.println("No: os Submissions should be less than or equal to "+Data_in_rows+" as the data is present only in "+Data_in_rows+" rows in the excel sheet");
		}
		else
		{
			try
			{
				for(int i=1;i<=numOfSubmissions; i++)
				{
					initialize_chrome("Agency_Url");
					InitializeElements.initialize_elements();
					AutoRenewalBrokerFeeMethods.select_agency(1);
					HomePageMethods.select_agency_contact(Locations.BrokerFeeDataFilePath, "Agency_Info", "Agency_Contact", 1);
					//AutoRenewalBrokerFeeMethods.setup_brokerfee("flat","different", 1);
					fill_comparative_rater_info(i);
					fill_price_indicatorandeligibility_info(i);
					fill_application_info(1);
					WaitMethods.wait_in_seconds(5);
					GenericMethods.navigate_to_url(OR.getProperty("Admin_Url"));
					WaitMethods.wait_for_page_load(5);
					InitializeElements.initialize_elements();
					HomePageMethods.login_as_admin();
					AutoRenewalBrokerFeeMethods.save_ratingWorkSheet("new","Submission Id",i);
					GenericMethods.close_browser_window();
					AutoRenewalBrokerFeeMethods.change_status("Submission Id","Status_OkToBind",i);
					WaitMethods.wait_in_seconds(5);
					/*GenericMethods.navigate_to_url(OR.getProperty("Agency_Url"));
					WaitMethods.wait_in_seconds(5);
					InitializeElements.initialize_elements();
					AutoRenewalBrokerFeeMethods.select_agency(2);
					HomePageMethods.select_agency_contact("Agency_Contact", 2);
					WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.gotoSubmissions_button);
					AutoRenewalBrokerFeeLocators.gotoSubmissions_button.click();
					AutoRenewalBrokerFeeMethods.click_bindingDoc_link("Submission Id",i);
					GenericMethods.navigate_to_next_window();
					AutoRenewalBrokerFeeMethods.fill_bindingDoc_info("agencyfinance",1);
					GenericMethods.navigate_to_next_window();
					WaitMethods.wait_in_seconds(5);
					GenericMethods.navigate_to_url(OR.getProperty("Admin_Url"));*/
					WaitMethods.wait_for_page_load(5);
					AutoRenewalBrokerFeeMethods.change_status("Submission Id","Status _Sold",i);
					/*DatabaseConnectionandSqlQueries.connect_to_database();
					DatabaseConnectionandSqlQueries.update_effdate_newsubmission("Submission Id", i);*/
					AutoRenewalBrokerFeeMethods.change_submission_renewal("Submission Id", i);
					/*WaitMethods.wait_in_seconds(5);
					GenericMethods.navigate_browser("back");
					WaitMethods.wait_in_seconds(5);
					AutoRenewalBrokerFeeMethods.save_ratingWorkSheet("renewal", "Renewal Submission Id", i)*/		
					if(i<numOfSubmissions)
					{
						closeBrowser();
					}
					/*DatabaseConnectionandSqlQueries.connect_to_database();
				DatabaseConnectionandSqlQueries.update_effdate_newsubmission("Submission Id", i);*/
					//DatabaseConnectionandSqlQueries.update_effdate_renewalsubmission("Renewal Submission Id", i);
				}
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
	}

	/*
	 * Purpose: This method is to save broker fee value from binding doc 
	 * @param integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void save_bindingDoc_brokerFeeValue(int row_num)
	{
		WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.agency_broker_fee_field);
		ExcelReader.set_cell_data("Binding_Doc_BrokerFee_Value", row_num, GenericMethods.get_attribute_value(AutoRenewalBrokerFeeLocators.agency_broker_fee_field, "Value"));
	}

	/*
	 * Purpose: This method is to save binding doc info
	 * @param integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void verify_renewal_letter_info(int row_num) throws IOException
	{
		load_data();
		ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
		try
		{
			Assert.assertEquals(ExcelReader.get_row_data_from_col("Applicant Name", row_num), AutoRenewalBrokerFeeLocators.renewLetter_name.getText());
			log.info("The Application Name was successfully matched in Renewal letter");
		}
		catch(AssertionError err)
		{
			log.info("The Applicant Name is not matching in Renewal letter");
		}


		try
		{
			Assert.assertEquals(ExcelReader.get_row_data_from_col("DBA", row_num), AutoRenewalBrokerFeeLocators.renewLetter_dba.getText());
			log.info("The DBA was successfully matched in Renewal letter");
		}
		catch(AssertionError err)
		{
			log.info("The DBA is not matching in Renewal letter");
		}



		try
		{
			if(ExcelReader.get_row_data_from_col("Policy_Number", row_num).contains(AutoRenewalBrokerFeeLocators.renewLetter_PrePolicyNo.getText()))
			{
				log.info("The Policy Number is successfully matching");
			}
			else
			{
				log.info("The policy number is not matching in the Renewal Letter"); 
			}				 
		}
		catch(Exception err)
		{
			log.info(err.getMessage());
		}

		try
		{
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QAA_Status");
			if(ExcelReader.get_row_data_from_col("Expiration_Date", row_num).equals(AutoRenewalBrokerFeeLocators.renewLetter_RenEffectDate.getText()))
			{
				log.info("The expiration date is correctly matching in the Renewal Letter");
			}
			else
			{
				log.info("The expiration date is not matching");
			}				
		}
		catch(Exception err)
		{
			log.info(err.getMessage());
		}

		/*try
		{
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "BrokerFee_Data");
			if(ExcelReader.get_row_data_from_col("No Default BrokerFee Renewal Business", 1).equals(GenericMethods.get_integer_from_string(AutoRenewalBrokerFeeLocators.renewLetter_BrokerFee.getText())))
			{
				log.info("The Broker Fee data is matching in the Renewal Letter");
			}
			else
			{
				log.info("The Broker Fee Data is not matching");
			}				
		}
		catch(Exception err)
		{
			log.info(err.getMessage());
		}*/	
	}

	/*
	 * Purpose: This method is to verify important policy info
	 * @param integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void 	verify_important_renewalInfo(int row_num) throws IOException
	{
		ExcelReader.set_excel_file(Locations.GL_AR_TestData,"AR_Agency_Info");
		/*try
		{		
			if(GenericMethods.is_element_enabled(AutoRenewalBrokerFeeLocators.renewLetter_updatePolicyInfo_link).equalsIgnoreCase("true"))
			{
			if(ExcelReader.get_row_data_from_col("PolicyInfoLink1", row_num).contains(AutoRenewalBrokerFeeLocators.renewLetter_updatePolicyInfo_link.getText()))
			{
				log.info("The Update Policy Information Link is displaying correctly");
			}
			else
			{
				log.info("Incorrect policy information link is displaying");
			}	
			}
		}
		catch(Exception err)
		{
		log.info(err.getMessage());
		}	

		try
		{
			if(GenericMethods.is_element_enabled(AutoRenewalBrokerFeeLocators.renewLetter_PayInfoForRenewalTerm_link).equalsIgnoreCase("true"))
			{
			if(ExcelReader.get_row_data_from_col("RenewalInfoLink2", row_num).contains(AutoRenewalBrokerFeeLocators.renewLetter_PayInfoForRenewalTerm_link.getText()))
			{
				log.info("The Renewal Info Link is displaying correctly");
			}
			else
			{
				log.info("The Renewal information link is not displaying");
			}	
			}
		}
		catch(Exception err)
		{
		log.info(err.getMessage());
		}	*/

		try
		{
			if(GenericMethods.is_element_present(AutoRenewalBrokerFeeLocators.renewLetter_1st_txtLine_DirectBill).equalsIgnoreCase("true"))
			{
				String src= AutoRenewalBrokerFeeLocators.renewLetter_1st_txtLine_DirectBill.getText();
				if(ExcelReader.get_row_data_from_col("Important_Renewal_InformationFirstLine", row_num).contentEquals(src))
				{
					log.info("The important renewal information is displaying correctly");
				}
				else
				{
					log.info("The important renewal information is not displaying");
				}	
			}
		}
		catch(Exception err)
		{
			log.info(err.getMessage());
		}	

		//Assert.assertEquals(AutoRenewalBrokerFeeLocators.renewLetter_1st_txtLine_DirectBill.getText(), ExcelReader.get_row_data_from_col("Important_Renewal_InformationFirstLine", row_num));

	}


	/*New Auto Renewal Program Methods


	/*
	 * Purpose: This method is to verify the status of a renewal submission
	 * @param String submission id, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void verify_renewal_status(String submission_id,int row_num) throws InterruptedException, AWTException, IOException
	{

		try
		{
			//WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.selectBy_drpDwn);
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
			//GenericMethods.navigate_browser("back");
			//GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.selectBy_drpDwn, "visibletext", OR.getProperty("selectby"));
			WaitMethods.wait_in_seconds(5);
			AdminSubmissionPageLocators.submission_id_searchfield.clear();
			AdminSubmissionPageLocators.submission_id_searchfield.sendKeys(ExcelReader.get_row_data_from_col(submission_id, 1));
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
			WaitMethods.wait_in_seconds(3);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
			WaitMethods.wait_in_seconds(3);
			ExcelReader.set_excel_file(Locations.GL_AR_TestData, "AR_Agency_Info");
			Assert.assertEquals(AutoRenewalBrokerFeeLocators.RenewalSubmission_Status.getText(), ExcelReader.get_row_data_from_col("Verify_Renewal_Status", row_num));
			log.info("The status of the submission has been changed and is showing as " +AutoRenewalBrokerFeeLocators.RenewalSubmission_Status.getText());
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
	 * Purpose: This method is to verify the status of a Sold submission
	 * @param String submission id, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void verify_sold_status(String submission_id,int row_num) throws InterruptedException, AWTException, IOException
	{

		try
		{
			//WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.selectBy_drpDwn);
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
			//GenericMethods.navigate_browser("back");
			//GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.selectBy_drpDwn, "visibletext", OR.getProperty("selectby"));
			WaitMethods.wait_in_seconds(5);
			AdminSubmissionPageLocators.submission_id_searchfield.clear();
			AdminSubmissionPageLocators.submission_id_searchfield.sendKeys(ExcelReader.get_row_data_from_col(submission_id, 1));
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
			WaitMethods.wait_in_seconds(3);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
			WaitMethods.wait_in_seconds(3);
			ExcelReader.set_excel_file(Locations.GL_AR_TestData, "AR_Agency_Info");
			Assert.assertEquals(AutoRenewalBrokerFeeLocators.RenewalSubmission_Status.getText(), ExcelReader.get_row_data_from_col("Verify_Sold_Status", row_num));
			log.info("The status of the submission has been changed to "+AutoRenewalBrokerFeeLocators.RenewalSubmission_Status.getText()+" successfully...");
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
	 * Purpose: This method is to Verify Context option present for DIrectBill/Renewal Created Normal Agency
	 * @param String submission id, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void Verify_ContextOption(String submission_id, int row_num) throws IOException, InterruptedException
	{
		try
		{

			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
			WaitMethods.wait_in_seconds(5);
			AdminSubmissionPageLocators.submission_id_searchfield.clear();
			AdminSubmissionPageLocators.submission_id_searchfield.sendKeys(ExcelReader.get_row_data_from_col(submission_id, 1));
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
			WaitMethods.wait_in_seconds(3);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
			WaitMethods.wait_in_seconds(3);

			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_table_row);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
			WaitMethods.wait_in_seconds(3);


			WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.RenewalCreated_DirectBill_contextOpt_All);
			String contextOptions=(AutoRenewalBrokerFeeLocators.RenewalCreated_DirectBill_contextOpt_All).getTagName();WaitMethods.wait_in_seconds(3);
			String RenewalInformation=(AutoRenewalBrokerFeeLocators.RenewalCreated_DirectBill_contextOpt_RenewalInfo).getTagName();
			String bd= "Binding Documents";
			if(contextOptions.contains(RenewalInformation) && !contextOptions.contains(bd))
			{
				log.info("Binding Document Option Not available-pass");
			}
			GenericMethods.click_Element_Using_JS(AutoRenewalBrokerFeeLocators.RenewalCreated_DirectBill_contextOpt_RenewalInfo);
			WaitMethods.wait_in_seconds(3);

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
	 * Purpose: This method is to verify the important Renewal information other than CA state
	 * @param String submission id, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	/*public static void verify_ImportantInfoOtherthanCA_State() throws Exception
	{
		Screen src=new Screen();
		WaitMethods.wait_in_seconds(2);

		try {
			if (src.compare(Locations.impInfo_RenewalCreated) != null) {
				log.info("Imortant Info present for Other then CA state");
			} 
		}catch(UnhandledAlertException | ElementNotVisibleException | NoSuchElementException exe)
		{
			log.debug("The exception was found "+exe.getClass().getCanonicalName());
		}
		catch(WebDriverException exe)
		{
			log.info("unable to find the element in the web page");
		}

	}*/

	/*
	 * Purpose: This method is to verify the non-existence of Directbill Payment option in binding doc for a submission with Renewal Pending status
	 * @param NA
	 * @return NA
	 */
	public static void verify_PaymentOptionRenewalPendingDirectBill() throws Exception
	{	

		try {

			if (GenericMethods.is_element_present(AutoRenewalBrokerFeeLocators.paymentOption_BindingDoc_PremiumFin).equalsIgnoreCase("true")) 
			{
				if (GenericMethods.is_element_present(AutoRenewalBrokerFeeLocators.paymentOption_BindingDoc_AgencyFinance).equalsIgnoreCase("true")) 
				{
					if (GenericMethods.is_element_present(AutoRenewalBrokerFeeLocators.paymentOption_BindingDoc_DirectBill).equalsIgnoreCase("false"))
					{
						log.info("DirectBill as Payment Option Not Available-pass");
					}
				}
			} 
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
	 * Purpose: This method is to click the bind now button in binding doc
	 * @param NA
	 * @return NA
	 */
	public static void click_bindingDoc_bindNow_btn()
	{
		WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.bindingDoc_bindNow_btn);
		GenericMethods.click_Element_Using_JS(AutoRenewalBrokerFeeLocators.bindingDoc_bindNow_btn);
	}

	/*
	 * Purpose: This method is to verify the status of a Renewal Submission
	 * @param String submission id, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void verify_renewal_status(String submission_type,String submission_id,int row_num) throws IOException, InterruptedException, AWTException
	{
		try
		{
			load_data();
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
			WaitMethods.wait_in_seconds(5);
			AdminSubmissionPageLocators.submission_id_searchfield.clear();
			AdminSubmissionPageLocators.submission_id_searchfield.sendKeys(ExcelReader.get_row_data_from_col(submission_id, row_num));
			WaitMethods.wait_in_seconds(3);
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
			WaitMethods.wait_in_seconds(5);	
			AdminSubmissionPageMethods.view_submission_details();
			GenericMethods.navigate_to_next_window();
			if(submission_type.equalsIgnoreCase("new") || submission_type.equalsIgnoreCase("renewal") )
			{
				if(GenericMethods.is_element_displayed(AdminSubmissionPageLocators.cbFullWithoutSunset_chkbx).equalsIgnoreCase("true"))
				{
					if(GenericMethods.is_chekbox_selected(AdminSubmissionPageLocators.cbFullWithoutSunset_chkbx).equalsIgnoreCase("true"))
					{
						log.info("The Rating Option in the Rating Worksheet was selected");
					}
					else
					{
						log.info("The Rating Option in the Rating Worksheet was not selected");
					}
				}						
			}
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
	 * Purpose: This method is to verify the payment option of a submission with the Renewal Created Status and with Direct bill as Payment Option
	 * @param NA
	 * @return NA
	 */
	public static void verify_PaymentOptionRenewalCreatedDirectBillonly() throws Exception
	{	

		try {

			if (GenericMethods.is_element_present(AutoRenewalBrokerFeeLocators.paymentOption_BindingDoc_PremiumFin).equalsIgnoreCase("false")) 
			{
				if (GenericMethods.is_element_present(AutoRenewalBrokerFeeLocators.paymentOption_BindingDoc_AgencyFinance).equalsIgnoreCase("false")) 
				{
					if (GenericMethods.is_element_present(AutoRenewalBrokerFeeLocators.paymentOption_BindingDoc_DirectBill).equalsIgnoreCase("true"))
					{
						log.info("DirectBill as Payment ONLY Option Available-pass");
					}
				}
			} 
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
	 * Purpose: This method is to verify the payment option of a submission with the Bind Req Pending Status and with AgencyBill & Premium Finance as Payment Option
	 * @param NA
	 * @return NA
	 */
	public static void verify_PaymentOptions_BindReqPending_Agency_PremuiumFinance() throws Exception
	{	

		try {

			if (GenericMethods.is_element_present(AutoRenewalBrokerFeeLocators.paymentOption_BindingDoc_PremiumFin).equalsIgnoreCase("true")) 
			{
				if (GenericMethods.is_element_present(AutoRenewalBrokerFeeLocators.paymentOption_BindingDoc_AgencyFinance).equalsIgnoreCase("true")) 
				{
					if (GenericMethods.is_element_present(AutoRenewalBrokerFeeLocators.paymentOption_BindingDoc_DirectBill).equalsIgnoreCase("true"))
					{
						log.info("All Three Payment Options Available-pass");
					}
				}
			} 
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

}












