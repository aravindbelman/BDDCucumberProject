package com.BtisNewUI.PageMethods;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.SystemClock;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import com.BtisNewUI.Locators.StarrUILocators;
import com.BtisNewUI.Locators.WCnewUILocators;
import com.LegacyApplication.ExcelReader.ExcelReader;
import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageLocators.GeneralLiabilityPageLocators;
import com.LegacyApplication.PageLocators.HomePageLocators;
import com.LegacyApplication.PageLocators.WorkersCompLocators;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

import jxl.write.DateFormat;
import net.bytebuddy.description.type.TypeDescription.Generic;

public class WCnewUIMethods extends TestBase {

	public static final Logger log=Logger.getLogger(WCnewUIMethods.class.getName());
	public static JavascriptExecutor js;

	// Create object of SimpleDateFormat class and decide the format
	static SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	static java.util.Date date= new java.util.Date();
	static String finalDate=dateFormat.format(date);
	//To select WC as Program
	public static void select_WC_Program() throws IOException, InterruptedException, Exception, AWTException
	{
		WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.workersCom_button);
		GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.workersCom_button);
		GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.select_wrokersCom);

		WaitMethods.wait_in_seconds(2);
		// To handle all new opened window.		
		GenericMethods.navigate_to_next_window();


		String url=driver.getCurrentUrl();
		log.info("Driver Navigated to ==== " +url); 

		WaitMethods.wait_for_element_present(WCnewUILocators.business_street_txtb);
	}

	/*
	 * Purpose: This method go to Business Info Page
	 * and enter same/Different business and mailing address
	 * & perform Operations
	 * @param String submission_type, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void Business_MailingAddress(int row_num, String diff_address) throws IOException, InterruptedException, Exception, AWTException
	{   

		ExcelReader.set_excel_file(Locations.WC_UI_TestData,"BusinessInfo");

		WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.workersCom_button);
		GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.workersCom_button);
		GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.select_wrokersCom);

		WaitMethods.wait_in_seconds(2);
		GenericMethods.navigate_to_next_window();

		String url=driver.getCurrentUrl();
		log.info("Driver Navigated to ==== " +url); 

		WaitMethods.wait_for_element_present(WCnewUILocators.business_street_txtb);


		//GenericMethods.enter_text(WCnewUILocators.business_street_txtb,ExcelReader.get_row_data_Randomly_from_col("BusinessStreet"), "Business Street");
		WCnewUILocators.business_street_txtb.sendKeys(GenericMethods.generate_random_integer(900, 100),ExcelReader.get_row_data_from_col("BusinessStreet", row_num));
		//GenericMethods.enter_text(WCnewUILocators.business_street_txtb,ExcelReader.get_row_data_from_col("BusinessStreet", row_num), "Business Street");


		WaitMethods.wait_in_seconds(2);

		WaitMethods.wait_for_elements_present(WCnewUILocators.businessAdd_List);
		GenericMethods.bootstrap_dropdown(WCnewUILocators.businessAdd_List, ExcelReader.get_row_data_from_col("BusinessStreet", row_num));


		//GenericMethods.press_key_using_robot("downArrow");
		//GenericMethods.press_key_using_robot("enter");
		//GenericMethods.click_enter_using_robot();

		if(diff_address.equalsIgnoreCase("same"))
		{	
			WaitMethods.wait_in_seconds(2);
			GenericMethods.is_element_present(WCnewUILocators.businessAndMailingAddressSame_chkBox);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.businessAndMailingAddressSame_chkBox);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.businessAndMailingAddressSame_chkBox);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.businessAndMailingAddressSame_chkBox);
			WaitMethods.wait_in_seconds(2);
		}
		else if(diff_address.equalsIgnoreCase("different"))
		{
			GenericMethods.enter_text(WCnewUILocators.mail_street_txtb,ExcelReader.get_row_data_from_col("mailing_Street", row_num), "Mailing Street");
			GenericMethods.enter_text(WCnewUILocators.mail_suite_txtb,ExcelReader.get_row_data_from_col("mailing_Suite", row_num), "Mailing Suite");
			GenericMethods.enter_text(WCnewUILocators.mail_city_txtb,ExcelReader.get_row_data_from_col("mailing_City", row_num), "Mailing City");			
			GenericMethods.select_from_dropdown(WCnewUILocators.mail_state_drpdwn, "visibletext", ExcelReader.get_row_data_from_col("mailing_State", row_num));
			GenericMethods.enter_text(WCnewUILocators.mail_zip_txtb,ExcelReader.get_row_data_from_col("mailing_Zip", row_num), "Mailing ZipCode");
		}


	}

	// Temporary Method
	public static void Business_MailingAddressxx(int row_num, String diff_address) throws IOException, InterruptedException, Exception, AWTException
	{   

		ExcelReader.set_excel_file(Locations.WC_UI_TestData,"BusinessInfo");


		WaitMethods.wait_for_element_present(WCnewUILocators.business_street_txtb);
		WCnewUILocators.business_street_txtb.clear();


		//GenericMethods.enter_text(WCnewUILocators.business_street_txtb,ExcelReader.get_row_data_Randomly_from_col("BusinessStreet"), "Business Street");
		WCnewUILocators.business_street_txtb.sendKeys(GenericMethods.generate_random_integer(9,1),ExcelReader.get_row_data_from_col("BusinessStreet", row_num));
		//GenericMethods.enter_text(WCnewUILocators.business_street_txtb,ExcelReader.get_row_data_from_col("BusinessStreet", row_num), "Business Street");


		WaitMethods.wait_in_seconds(2);

		WaitMethods.wait_for_elements_present(WCnewUILocators.businessAdd_List);
		GenericMethods.bootstrap_dropdown(WCnewUILocators.businessAdd_List, ExcelReader.get_row_data_from_col("BusinessStreet", row_num));

		//GenericMethods.press_key_using_robot("downArrow");
		//GenericMethods.press_key_using_robot("enter");
		//GenericMethods.click_enter_using_robot();

		if(diff_address.equalsIgnoreCase("same"))
		{	
			WaitMethods.wait_in_seconds(2);
			GenericMethods.is_element_present(WCnewUILocators.businessAndMailingAddressSame_chkBox);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.businessAndMailingAddressSame_chkBox);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.businessAndMailingAddressSame_chkBox);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.businessAndMailingAddressSame_chkBox);
			WaitMethods.wait_in_seconds(2);
		}
		else if(diff_address.equalsIgnoreCase("different"))
		{
			GenericMethods.enter_text(WCnewUILocators.mail_street_txtb,ExcelReader.get_row_data_from_col("mailing_Street", row_num), "Mailing Street");
			GenericMethods.enter_text(WCnewUILocators.mail_suite_txtb,ExcelReader.get_row_data_from_col("mailing_Suite", row_num), "Mailing Suite");
			GenericMethods.enter_text(WCnewUILocators.mail_city_txtb,ExcelReader.get_row_data_from_col("mailing_City", row_num), "Mailing City");			
			GenericMethods.select_from_dropdown(WCnewUILocators.mail_state_drpdwn, "visibletext", ExcelReader.get_row_data_from_col("mailing_State", row_num));
			GenericMethods.enter_text(WCnewUILocators.mail_zip_txtb,ExcelReader.get_row_data_from_col("mailing_Zip", row_num), "Mailing ZipCode");
		}

	}

	/*
	 * Happy  Flow States basis
	 * for States - (CA,TX,AZ,CO,GA,IL,OR,NJ,PA,MO,NV,TN,VA,OK,NC)
	 * for both Employer 
	 */
	public static void Business_MailingAddressMultiState_Employer() throws IOException, InterruptedException, Exception, AWTException
	{  	

		String[] state ={"Hoover Dam Access Rd", "3300 North Central Avenue,AZ","2334 Sunrise Blvd", "1100 Peachtree,GA", "Adler Planetarium, 1300 S. Lake Shore Drive,IL", "Pittock Lane, North Bend, OR,", "Sandy Hook Ave, Middletown, NJ,", "The Pagoda, Reading","600 Capitol Blvd,,Nashville,TN","1000 Bank Street Richmond Va", "2727 South Rockford Road, Tulsa", "2200 Hillsborough St, Raleigh, NC", "Mt Evans Rd"};

		for (String item : state) 

		{		
			WaitMethods.wait_for_element_present(WCnewUILocators.business_street_txtb);					
			GenericMethods.enter_text(WCnewUILocators.business_street_txtb,item, "Busniness Street : ");
			WaitMethods.wait_in_seconds(2);

			WaitMethods.wait_for_elements_present(WCnewUILocators.businessAdd_List);
			GenericMethods.bootstrap_dropdown(WCnewUILocators.businessAdd_List," ");

			//GenericMethods.press_key_using_robot("downArrow");
			//GenericMethods.click_enter_using_robot();

			//for Same Mailing address

			GenericMethods.is_element_present(WCnewUILocators.businessAndMailingAddressSame_chkBox);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.businessAndMailingAddressSame_chkBox);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.businessAndMailingAddressSame_chkBox);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.businessAndMailingAddressSame_chkBox);
			WaitMethods.wait_in_seconds(2);

			String StateName=GenericMethods.get_selected_optn_frm_ele(WCnewUILocators.business_state_drpdwn); 
			log.info("============================"+StateName+"==========================");
			WaitMethods.wait_in_seconds(2);

			GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
			WaitMethods.wait_in_seconds(2);


			WCnewUIMethods.businessInfoPage2(1,"otherThenCA","Ex.No");
			GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
			WaitMethods.wait_in_seconds(2); 
			WCnewUIMethods.coverageHistoryWithNOoption("empNo");
			WaitMethods.wait_in_seconds(2);

			WCnewUIMethods.classCode_fill(7,"single");	
			GenericMethods.click_Element(WCnewUILocators.next_btn);
			WaitMethods.wait_in_seconds(2);

			WCnewUIMethods.ownersAndOfficers(8);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
			WaitMethods.wait_in_seconds(2);

			WCnewUIMethods.credit_Opp_Verify_AvaibalityOf_All_11_Questions();
			GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);

			WCnewUIMethods.CarrierOption("Amtrust&Employer");
			WaitMethods.wait_in_seconds(15);

			WCnewUIMethods.selectCarrier("Employer");
			WaitMethods.wait_in_seconds(2);

			WCnewUIMethods.Sub_ClassCode("single");
			WaitMethods.wait_in_seconds(2);

			WCnewUIMethods.Carrier_specific_Question_Verify("employerQuetions");
			WaitMethods.wait_in_seconds(2);

			WCnewUIMethods.employerCarrierPaymentPlan("Happy");
			GenericMethods.click_Element(WCnewUILocators.next_btn);
			WaitMethods.wait_in_seconds(50);

			WaitMethods.wait_for_element_present(WCnewUILocators.brokerFee_txtb);
			GenericMethods.enter_text(WCnewUILocators.brokerFee_txtb, "100", "Broker Fee : ");
			GenericMethods.click_Element(WCnewUILocators.saveBrokerFee_btn);
			WaitMethods.wait_in_seconds(5);	
			String s=WCnewUILocators.btis_service_Fee.getText();
			log.info("====================="+s+"<====================================");

			log.info("=====================Test OK Pass for the state=== " +StateName+"=======================");
			//Going for Another Submission with Different State

			//GenericMethods.click_Element(HomePageLocators.homepageLogout);WaitMethods.wait_in_seconds(5);

			GenericMethods.driver.switchTo().defaultContent();
			GenericMethods.close_window_using_robot();

			initialize_agency_environment("environment","chrome_browser");
			InitializeElements.initialize_elements();
			HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
			HomePageMethods.select_agency_contact();	
			WCnewUIMethods.select_WC_Program();

		}
	}



	/*
	 * Happy  Flow States basis
	 * for States - (CA,TX,AZ,CO,GA,IL,OR,NJ,PA,MO,NV,TN,VA,OK,NC)
	 * for AMtrust
	 */
	public static void Business_MailingAddressMultiState_AMTrust() throws IOException, InterruptedException, Exception, AWTException
	{ 
		String[] state ={"Hoover Dam Access Rd", "3300 North Central Avenue,AZ","2334 Sunrise Blvd", "1100 Peachtree,GA", "Adler Planetarium, 1300 S. Lake Shore Drive,IL", "Pittock Lane, North Bend, OR,", "Sandy Hook Ave, Middletown, NJ,", "The Pagoda, Reading","600 Capitol Blvd,,Nashville,TN","1000 Bank Street Richmond Va", "2727 South Rockford Road, Tulsa", "2200 Hillsborough St, Raleigh, NC", "Mt Evans Rd"};

		for (String item : state) 

		{		
			WaitMethods.wait_for_element_present(WCnewUILocators.business_street_txtb);					
			GenericMethods.enter_text(WCnewUILocators.business_street_txtb,item, "Busniness Street : ");
			WaitMethods.wait_in_seconds(2);
			WaitMethods.wait_for_elements_present(WCnewUILocators.businessAdd_List);
			GenericMethods.bootstrap_dropdown(WCnewUILocators.businessAdd_List," ");

			//GenericMethods.press_key_using_robot("downArrow");
			//GenericMethods.click_enter_using_robot();

			//for Same Mailing address

			GenericMethods.is_element_present(WCnewUILocators.businessAndMailingAddressSame_chkBox);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.businessAndMailingAddressSame_chkBox);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.businessAndMailingAddressSame_chkBox);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.businessAndMailingAddressSame_chkBox);
			WaitMethods.wait_in_seconds(2);

			String StateName=GenericMethods.get_selected_optn_frm_ele(WCnewUILocators.business_state_drpdwn); 
			log.info("============================"+StateName+"==========================");
			WaitMethods.wait_in_seconds(2);

			GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
			WaitMethods.wait_in_seconds(2);


			WCnewUIMethods.businessInfoPage2(1,"otherThenCA","Ex.No");
			GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
			WaitMethods.wait_in_seconds(2); 
			WCnewUIMethods.coverageHistoryWithNOoption("empNo");
			WaitMethods.wait_in_seconds(2);

			WCnewUIMethods.classCode_fill(7,"single");	
			GenericMethods.click_Element(WCnewUILocators.next_btn);
			WaitMethods.wait_in_seconds(2);

			WCnewUIMethods.ownersAndOfficers(8);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
			WaitMethods.wait_in_seconds(2);

			WCnewUIMethods.credit_Opp_Verify_AvaibalityOf_All_11_Questions();
			GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);

			WCnewUIMethods.CarrierOption("Amtrust&Employer");
			WaitMethods.wait_in_seconds(15);

			WCnewUIMethods.selectCarrier("AMtrust");
			WaitMethods.wait_in_seconds(2);

			WCnewUIMethods.Sub_ClassCode("single");
			WaitMethods.wait_in_seconds(2);

			WCnewUIMethods.Carrier_specific_Question_Verify("AMTrutQuetions");
			WaitMethods.wait_in_seconds(2);

			WCnewUIMethods.amTrustCarrierPaymentPlan("Happy");
			GenericMethods.click_Element(WCnewUILocators.next_btn);
			WaitMethods.wait_in_seconds(50);

			WaitMethods.wait_for_element_present(WCnewUILocators.brokerFee_txtb);
			GenericMethods.enter_text(WCnewUILocators.brokerFee_txtb, "100", "Broker Fee : ");
			GenericMethods.click_Element(WCnewUILocators.saveBrokerFee_btn);
			WaitMethods.wait_in_seconds(5);	
			String s=WCnewUILocators.btis_service_Fee.getText();
			log.info("====================="+s+"<====================================");

			log.info("=====================Test OK Pass for the state=== " +StateName+"=======================");
			//Going for Another Submission with Different State

			//GenericMethods.click_Element(HomePageLocators.homepageLogout);WaitMethods.wait_in_seconds(5);

			GenericMethods.driver.switchTo().defaultContent();
			GenericMethods.close_window_using_robot();

			initialize_agency_environment("environment","chrome_browser");
			InitializeElements.initialize_elements();
			HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
			HomePageMethods.select_agency_contact();	
			WCnewUIMethods.select_WC_Program();

		}
	}

	/*
	 * Purpose: This method go to Business Info Page
	 * and enter business and mailing and all Additional Business Location address
	 * & perform Operations
	 * @param String submission_type, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void Business_Mailing_Additional_Address(int row_num, String diff_address) throws IOException, InterruptedException, Exception, AWTException
	{   

		ExcelReader.set_excel_file(Locations.WC_UI_TestData,"BusinessInfo");
		WaitMethods.wait_in_seconds(2);

		WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.workersCom_button);
		GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.workersCom_button);
		GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.select_wrokersCom);

		WaitMethods.wait_in_seconds(2);
		GenericMethods.navigate_to_next_window();
		String url=driver.getCurrentUrl();
		log.info("Driver Navigated to ==== " +url); 
		WaitMethods.wait_for_element_present(WCnewUILocators.business_street_txtb);

		//Business Address field
		GenericMethods.enter_text(WCnewUILocators.business_street_txtb,ExcelReader.get_row_data_from_col("BusinessStreet", row_num), "Business Street");
		//WCnewUILocators.business_street_txtb.sendKeys(GenericMethods.generate_random_integer(900, 100),ExcelReader.get_row_data_from_col("BusinessStreet", row_num));

		WaitMethods.wait_in_seconds(2);
		GenericMethods.press_key_using_robot("downArrow");
		GenericMethods.click_enter_using_robot();

		//Mailing Address Field
		GenericMethods.enter_text(WCnewUILocators.mail_street_txtb,ExcelReader.get_row_data_from_col("mailing_Street", row_num), "Mailing Street");
		GenericMethods.enter_text(WCnewUILocators.mail_suite_txtb,ExcelReader.get_row_data_from_col("mailing_Suite", row_num), "Mailing Suite");
		GenericMethods.enter_text(WCnewUILocators.mail_city_txtb,ExcelReader.get_row_data_from_col("mailing_City", row_num), "Mailing City");			
		GenericMethods.select_from_dropdown(WCnewUILocators.mail_state_drpdwn, "visibletext", ExcelReader.get_row_data_from_col("mailing_State", row_num));
		GenericMethods.enter_text(WCnewUILocators.mail_zip_txtb,ExcelReader.get_row_data_from_col("mailing_Zip", row_num), "Mailing ZipCode");


		//Additional Address 1
		GenericMethods.click_Element_Using_JS(WCnewUILocators.add_businessLocation_YES_radio);
		GenericMethods.enter_text(WCnewUILocators.add1_street_txtb,ExcelReader.get_row_data_from_col("BusinessStreetAddress1", row_num), "Business Street address 1");
		WaitMethods.wait_in_seconds(2);
		GenericMethods.press_key_using_robot("downArrow");
		GenericMethods.click_enter_using_robot();

		//Additional Address 2
		GenericMethods.click_Element_Using_JS(WCnewUILocators.add_address2_YES_radio);
		GenericMethods.enter_text(WCnewUILocators.add2_street_txtb,ExcelReader.get_row_data_from_col("BusinessStreetAddress2", row_num), "Business Street address 2");
		WaitMethods.wait_in_seconds(2);
		GenericMethods.press_key_using_robot("downArrow");
		GenericMethods.click_enter_using_robot();

		//Additional Address 3
		GenericMethods.click_Element_Using_JS(WCnewUILocators.add_address3_YES_radio);
		GenericMethods.enter_text(WCnewUILocators.add3_street_txtb,ExcelReader.get_row_data_from_col("BusinessStreetAddress3", row_num), "Business Street address 3");
		WaitMethods.wait_in_seconds(2);
		GenericMethods.press_key_using_robot("downArrow");
		GenericMethods.press_key_using_robot("enter");

	}
	/*
	 * Purpose: This method go Back to Business Info Page
	 * First Save all the Data we enter in all fields
	 * Verify theEntered Info for Business/Mailing/Additional address Save or Not 
	 * & perform Operations
	 * @param String submission_type, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void verifyInf_Businees_Mailing_Additional_Address(int row_num, String diff_address) throws IOException, InterruptedException, Exception, AWTException
	{   

		ExcelReader.set_excel_file(Locations.WC_UI_TestData,"BusinessInfo");
		WaitMethods.wait_in_seconds(2);

		//Business Address Fields

		GenericMethods.is_element_present(WCnewUILocators.business_street_txtb);
		String busStree=GenericMethods.getTextfmElem(WCnewUILocators.business_street_txtb);
		Assert.assertEquals(busStree, ExcelReader.get_row_data_from_col("BusinessStreet_Actual", row_num));
		log.info("====Business Street address match=====");

		GenericMethods.is_element_present(WCnewUILocators.business_City_txtb);
		String busCity=GenericMethods.getTextfmElem(WCnewUILocators.business_City_txtb);
		Assert.assertEquals(busCity, ExcelReader.get_row_data_from_col("BusCity_Actual", row_num));
		log.info("====Business City match=====");

		GenericMethods.is_element_present(WCnewUILocators.business_state_drpdwn);
		String busState=GenericMethods.get_selected_optn_frm_ele(WCnewUILocators.business_state_drpdwn);
		Assert.assertEquals(busState, ExcelReader.get_row_data_from_col("Bus_stateActaul", row_num));
		log.info("====Business State match=====");

		GenericMethods.is_element_present(WCnewUILocators.business_zip_txtb);
		String busZIP=GenericMethods.getTextfmElem(WCnewUILocators.business_zip_txtb);
		Assert.assertEquals(busZIP, ExcelReader.get_row_data_from_col("BusZIP_actual", row_num));
		log.info("====Business Zip match=====");

		//Mailing Address Fields

		GenericMethods.is_element_present(WCnewUILocators.mail_street_txtb);
		String mailStree=GenericMethods.getTextfmElem(WCnewUILocators.mail_street_txtb);
		Assert.assertEquals(mailStree, ExcelReader.get_row_data_from_col("mailing_Street", row_num));
		log.info("====Mailing Street address match=====");

		GenericMethods.is_element_present(WCnewUILocators.mail_suite_txtb);
		String mailSuite=GenericMethods.getTextfmElem(WCnewUILocators.mail_suite_txtb);
		Assert.assertEquals(mailSuite, ExcelReader.get_row_data_from_col("mailing_Suite", row_num));
		log.info("====Mailing Suite/Apt. match=====");

		GenericMethods.is_element_present(WCnewUILocators.mail_city_txtb);
		String mailCity=GenericMethods.getTextfmElem(WCnewUILocators.mail_city_txtb);
		Assert.assertEquals(mailCity, ExcelReader.get_row_data_from_col("mailing_City", row_num));
		log.info("====Mailing City match=====");

		GenericMethods.is_element_present(WCnewUILocators.mail_state_drpdwn);
		String mailState=GenericMethods.get_selected_optn_frm_ele(WCnewUILocators.mail_state_drpdwn);
		Assert.assertEquals(mailState, ExcelReader.get_row_data_from_col("mailing_State", row_num));
		log.info("====Mailing State match=====");

		GenericMethods.is_element_present(WCnewUILocators.mail_zip_txtb);
		String mailZIP=GenericMethods.getTextfmElem(WCnewUILocators.mail_zip_txtb);
		Assert.assertEquals(mailZIP, ExcelReader.get_row_data_from_col("mailing_Zip", row_num));
		log.info("====Mailing Zip match=====");

		//Additional Address 1 VERIFY

		GenericMethods.is_element_present(WCnewUILocators.add1_street_txtb);
		String add1Stree=GenericMethods.getTextfmElem(WCnewUILocators.add1_street_txtb);
		Assert.assertEquals(add1Stree, ExcelReader.get_row_data_from_col("ActualAdd1", row_num));
		log.info("====Business Street address 1 match=====");

		GenericMethods.is_element_present(WCnewUILocators.add1_city_txtb);
		String aad1City=GenericMethods.getTextfmElem(WCnewUILocators.add1_city_txtb);
		Assert.assertEquals(aad1City, ExcelReader.get_row_data_from_col("add1City", row_num));
		log.info("====Business City 1 match=====");

		GenericMethods.is_element_present(WCnewUILocators.add1_state_drpdwn);
		String add1State=GenericMethods.get_selected_optn_frm_ele(WCnewUILocators.add1_state_drpdwn);
		Assert.assertEquals(add1State, ExcelReader.get_row_data_from_col("add1state", row_num));
		log.info("====Business State 1 match=====");

		GenericMethods.is_element_present(WCnewUILocators.add1_zip_txtb);
		String add1ZIP=GenericMethods.getTextfmElem(WCnewUILocators.add1_zip_txtb);
		Assert.assertEquals(add1ZIP, ExcelReader.get_row_data_from_col("add1zip", row_num));
		log.info("====Business Zip 1 match=====");

		//Additional Address 2 VERIFY

		GenericMethods.is_element_present(WCnewUILocators.add2_street_txtb);
		String add2Stree=GenericMethods.getTextfmElem(WCnewUILocators.add2_street_txtb);
		Assert.assertEquals(add2Stree, ExcelReader.get_row_data_from_col("ActualAdd2", row_num));
		log.info("====Business Street address 2 match=====");

		GenericMethods.is_element_present(WCnewUILocators.add2_city_txtb);
		String add2City=GenericMethods.getTextfmElem(WCnewUILocators.add2_city_txtb);
		Assert.assertEquals(add2City, ExcelReader.get_row_data_from_col("add2City", row_num));
		log.info("====Business City 2 match=====");

		GenericMethods.is_element_present(WCnewUILocators.add2_state_drpdwn);
		String add2State=GenericMethods.get_selected_optn_frm_ele(WCnewUILocators.add2_state_drpdwn);
		Assert.assertEquals(add2State, ExcelReader.get_row_data_from_col("add2state", row_num));
		log.info("====Business State 2 match=====");

		GenericMethods.is_element_present(WCnewUILocators.add2_zip_txtb);
		String add2ZIP=GenericMethods.getTextfmElem(WCnewUILocators.add2_zip_txtb);
		Assert.assertEquals(add2ZIP, ExcelReader.get_row_data_from_col("add2zip", row_num));
		log.info("====Business Zip 2 match=====");

		//Additional Address 3 VERIFY

		GenericMethods.is_element_present(WCnewUILocators.add3_street_txtb);
		String add3Stree=GenericMethods.getTextfmElem(WCnewUILocators.add3_street_txtb);
		Assert.assertEquals(add3Stree, ExcelReader.get_row_data_from_col("ActualAdd3", row_num));
		log.info("====Business Street address 3 match=====");

		GenericMethods.is_element_present(WCnewUILocators.add3_city_txtb);
		String add3City=GenericMethods.getTextfmElem(WCnewUILocators.add3_city_txtb);
		Assert.assertEquals(add3City, ExcelReader.get_row_data_from_col("add3City", row_num));
		log.info("====Business City 3 match=====");

		GenericMethods.is_element_present(WCnewUILocators.add3_state_drpdwn);
		String add3State=GenericMethods.get_selected_optn_frm_ele(WCnewUILocators.add3_state_drpdwn);
		Assert.assertEquals(add3State, ExcelReader.get_row_data_from_col("add3state", row_num));
		log.info("====Business State 3 match=====");

		GenericMethods.is_element_present(WCnewUILocators.add3_zip_txtb);
		String add3ZIP=GenericMethods.getTextfmElem(WCnewUILocators.add3_zip_txtb);
		Assert.assertEquals(add3ZIP, ExcelReader.get_row_data_from_col("add3zip", row_num));
		log.info("====Business Zip 3 match=====");

	}

	/*
	 * These method is to Fill details in Business Info page 2 and Proceed to Next Page
	 * @param String submission_type, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void businessInfoPage2(int row_num,String diff_limit,String expMod) throws IOException, InterruptedException, Exception, AWTException
	{   	
		WaitMethods.wait_in_seconds(5);
		ExcelReader.set_excel_file(Locations.WC_UI_TestData,"BusinessInfo2");
		WCnewUILocators.effectivedate_calendar.clear();
		WCnewUILocators.effectivedate_calendar.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, 3, 0, 0, 0));
		//GenericMethods.press_key_using_robot("tab");
		GenericMethods.select_from_dropdown(WCnewUILocators.entity_drpd, "visibletext", ExcelReader.get_row_data_from_col("entityType", row_num));


		if(GenericMethods.get_selected_optn_frm_ele(WCnewUILocators.entity_drpd).equals("Individual"))
		{	
			GenericMethods.enter_text(WCnewUILocators.insured_lastName,ExcelReader.get_row_data_from_col("lastname", row_num), "Insured Last Name : ");
			GenericMethods.enter_text(WCnewUILocators.insured_firstName,ExcelReader.get_row_data_from_col("firstname", row_num), "Insured First Name");	
		}
		else 
		{
			GenericMethods.enter_text(WCnewUILocators.businessName_txtb,ExcelReader.get_row_data_from_col("businessName", row_num), "Business Name");				
			WCnewUILocators.businessName_txtb.sendKeys(" "+GenericMethods.generate_random_integer(900, 100));
		}
		GenericMethods.enter_text(WCnewUILocators.dba_txtb,ExcelReader.get_row_data_from_col("id_Dba", row_num), "DBA Name : ");

		WCnewUILocators.dba_txtb.sendKeys(" "+finalDate);
		//WCnewUILocators.dba_txtb.sendKeys(" "+GenericMethods.generate_random_integer(900, 100));
		GenericMethods.enter_text(WCnewUILocators.firstName_txtb,ExcelReader.get_row_data_from_col("firstname", row_num), "First Name");

		GenericMethods.enter_text(WCnewUILocators.lastName_txtb,ExcelReader.get_row_data_from_col("lastname", row_num), "Last Name : ");

		//GenericMethods.enter_text(WCnewUILocators.email_txtb,ExcelReader.get_row_data_from_col("emailAddress", row_num), "Email Add ");
		WCnewUILocators.email_txtb.sendKeys(GenericMethods.generate_random_integer(900, 100)+ExcelReader.get_row_data_from_col("emailAddress", row_num));
		WaitMethods.wait_in_seconds(1);
		WCnewUILocators.phoneNo_txtb.sendKeys("9"+GenericMethods.generate_random_integer(900000000, 100000000));
		//GenericMethods.enter_text(WCnewUILocators.phoneNo_txtb,ExcelReader.get_row_data_from_col("PhoneNumber", row_num), "Phone No ");
		GenericMethods.enter_text(WCnewUILocators.website_txtb,ExcelReader.get_row_data_from_col("website", row_num), "website ");		

		//GenericMethods.enter_text(WCnewUILocators.feinNo_txtb,ExcelReader.get_row_data_from_col("feinNumber", row_num), "FEIN No ");
		WCnewUILocators.feinNo_txtb.sendKeys(GenericMethods.generate_random_integer(900000000, 100000000));
		if(expMod.equalsIgnoreCase("Ex.Yes"))
		{
			GenericMethods.click_Element(WCnewUILocators.expMod_Yes);
			GenericMethods.enter_text(WCnewUILocators.expMod_txtb,ExcelReader.get_row_data_from_col("experienceModification", row_num), "website ");	
		}
		else if(expMod.equalsIgnoreCase("Ex.No"))
		{
			GenericMethods.click_Element(WCnewUILocators.expMod_No);
		}

		if(diff_limit.equalsIgnoreCase("forCA"))
		{
			GenericMethods.select_from_dropdown(WCnewUILocators.limits_drpd, "visibletext", ExcelReader.get_row_data_from_col("limitsofInsurance", row_num));
		}
		else if(diff_limit.equalsIgnoreCase("otherThenCA"))
		{
			GenericMethods.select_from_dropdown(WCnewUILocators.limits_drpd, "visibletext", ExcelReader.get_row_data_from_col("limitsofInsurance", row_num));
		}		
		GenericMethods.select_from_dropdown(WCnewUILocators.industryExp_drpd, "visibletext", ExcelReader.get_row_data_from_col("industryExperience", row_num));
		GenericMethods.enter_text(WCnewUILocators.businessEstablished_txtb,ExcelReader.get_row_data_from_col("businessEstablished", row_num), "Business Established Year");		

	}

	/*
	 * To test the Limits drop down values 
	 * Reflect as per chosen State 
	 */
	public static void testLimits(int no_of_scenarios)throws IOException, InterruptedException, Exception, AWTException
	{
		ExcelReader.set_excel_file(Locations.WC_UI_TestData,"LimitsTestPage2");
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

					GenericMethods.enter_text(WCnewUILocators.business_street_txtb,ExcelReader.get_row_data_from_col("BusinessStreet", i), "Business Street");
					WaitMethods.wait_in_seconds(2);
					GenericMethods.press_key_using_robot("downArrow");
					GenericMethods.press_key_using_robot("enter");
					WaitMethods.wait_in_seconds(3);
					//String statename=GenericMethods.getTextfmElem(WCnewUILocators.business_state_drpdwn);WaitMethods.wait_in_seconds(2);
					String statename=WCnewUILocators.business_state_drpdwn.getAttribute("value").toString().trim();
					GenericMethods.is_element_present(WCnewUILocators.businessAndMailingAddressSame_chkBox);
					GenericMethods.click_Element_Using_JS(WCnewUILocators.businessAndMailingAddressSame_chkBox);
					GenericMethods.click_Element_Using_JS(WCnewUILocators.businessAndMailingAddressSame_chkBox);
					GenericMethods.click_Element_Using_JS(WCnewUILocators.businessAndMailingAddressSame_chkBox);
					WaitMethods.wait_in_seconds(2);

					GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);

					//Limits DropDown
					GenericMethods.is_element_displayed(WCnewUILocators.limits_drpd);
					String values=WCnewUILocators.limits_drpd.getText();
					String values2=values.replaceAll("\\s+","");
					GenericMethods.click_Element(WCnewUILocators.limits_drpd);
					WaitMethods.wait_in_seconds(2);

					Assert.assertEquals(values2,ExcelReader.get_row_data_from_col("Limits_Value", i));
					log.info("Limits Values showing Correctly & matched successfully " +values2 +" for STATE Name = "+statename);
					WaitMethods.wait_in_seconds(2);

					GenericMethods.click_Element_Using_JS(WCnewUILocators.back_btn);

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
	 *
	 * page 1 with other then CA state
	 * Page 2 with 500000/500000/500000 limits as selected
	 * fill complete page 2 Save & Proceed to Next Page 3
	 * come back to Page 1 & change Business address state to CA 
	 * Reflect as per chosen State - check Limits Drop Down Values & Next Button Unable /Disable.
	 */
	public static void testSavedLimits_States_Change(int row_num)throws IOException, InterruptedException, Exception, AWTException
	{	
		ExcelReader.set_excel_file(Locations.WC_UI_TestData,"LimitsTestPage2");	
		//Limits DropDown

		GenericMethods.is_element_displayed(WCnewUILocators.limits_drpd);
		String values=WCnewUILocators.limits_drpd.getText();
		String values2=values.replaceAll("\\s+","");
		GenericMethods.click_Element(WCnewUILocators.limits_drpd);
		WaitMethods.wait_in_seconds(2);

		Assert.assertEquals(values2,ExcelReader.get_row_data_from_col("Limits_Value",row_num));	
		WaitMethods.wait_in_seconds(2);
		log.info("The actual Limits Values we get is :" +values2);
		log.info("Limits DD values get changed Successfully");

	}

	/*
	 *Business Info page 2 
	 *All fields Validations 
	 */

	public static void to_testPage2_Validations()throws IOException, InterruptedException, Exception, AWTException
	{
		ExcelReader.set_excel_file(Locations.WC_UI_TestData,"Page2TestDATA");
		int Data_in_rows=ExcelReader.get_row_count();

		try
		{
			//Effective Date validation test

			for(int i=1;i<8; i++)
			{
				GenericMethods.enter_text(WCnewUILocators.effectivedate_calendar,ExcelReader.get_row_data_from_col("DesiredEffectiveDate", i), "effective date");
				WaitMethods.wait_in_seconds(1);
				if(WCnewUILocators.Calendar_validation.isDisplayed() && (ExcelReader.get_row_data_from_col("DateResult",i )).contains("Rejected"))
				{	
					GenericMethods.press_key_using_robot("tab");
					log.info("Validation message exists for Invalid Criteria-PASS");
					WaitMethods.wait_in_seconds(1);
				}else if(!WCnewUILocators.Calendar_validation.isDisplayed()&& (ExcelReader.get_row_data_from_col("DateResult",i)).contains("Accepted"))
				{	
					log.info("For Valid criteria Validation Not there - PASS");
					GenericMethods.press_key_using_robot("tab");
				}else
				{
					log.info("=========FAIL========= FAIL============= Validations Missing for Effective Date Field.=======FAIL========FAIL=====");
				}			
			}

			//BusinessName field Validation Test.
			for(int i=1;i<12; i++)
			{
				GenericMethods.enter_text(WCnewUILocators.businessName_txtb,ExcelReader.get_row_data_from_col("businessName", i), "Business Name");
				WaitMethods.wait_in_seconds(1);
				if(WCnewUILocators.businessName_validation.isDisplayed() && (ExcelReader.get_row_data_from_col("BusinessNameResult",i )).contains("Rejected"))
				{
					log.info("Validation message exists for Invalid Criteria-PASS");
				}else if(!WCnewUILocators.businessName_validation.isDisplayed()&& (ExcelReader.get_row_data_from_col("BusinessNameResult",i)).contains("Accepted"))
				{
					log.info("For Valid criteria Validation Not there - PASS");
				}else
				{
					log.info("=========FAIL========= FAIL============= Validations Missing for Business Name Field.=========FAIL========= FAIL=============");
				}			
			}

			// DBA field Validation Test.
			for(int i=1;i<11; i++)
			{
				GenericMethods.enter_text(WCnewUILocators.dba_txtb,ExcelReader.get_row_data_from_col("id_Dba", i), "DBA ");
				WaitMethods.wait_in_seconds(1);
				if(WCnewUILocators.DBA_validation.isDisplayed() && (ExcelReader.get_row_data_from_col("DBAResult",i )).contains("Rejected"))
				{
					log.info("Validation message exists for Invalid Criteria-PASS");
				}else if(!WCnewUILocators.DBA_validation.isDisplayed()&& (ExcelReader.get_row_data_from_col("DBAResult",i)).contains("Accepted"))
				{
					log.info("For Valid criteria Validation Not there - PASS");
				}else
				{
					log.info("=========FAIL========= FAIL============= Validations Missing for DBA Field.=========FAIL========= FAIL=============");
				}			
			}

			// First Name field Validation Test.
			for(int i=1;i<11; i++)
			{
				GenericMethods.enter_text(WCnewUILocators.firstName_txtb,ExcelReader.get_row_data_from_col("firstname", i), "First Name");
				WaitMethods.wait_in_seconds(1);
				if(WCnewUILocators.firstName_validation.isDisplayed() && (ExcelReader.get_row_data_from_col("firstResult",i )).contains("Rejected"))
				{
					log.info("Validation message exists for Invalid Criteria-PASS");
				}else if(!WCnewUILocators.firstName_validation.isDisplayed()&& (ExcelReader.get_row_data_from_col("firstResult",i)).contains("Accepted"))
				{
					log.info("For Valid criteria Validation Not there - PASS");
				}else
				{
					log.info("=========FAIL========= FAIL============= Validations Missing for FirstName Field.=========FAIL========= FAIL=============");
				}			
			}

			// Last Name field Validation Test.
			for(int i=1;i<11; i++)
			{
				GenericMethods.enter_text(WCnewUILocators.lastName_txtb,ExcelReader.get_row_data_from_col("lastname", i), "Last Name");
				WaitMethods.wait_in_seconds(1);
				if(WCnewUILocators.lastName_validation.isDisplayed() && (ExcelReader.get_row_data_from_col("lastResult",i )).contains("Rejected"))
				{
					log.info("Validation message exists for Invalid Criteria-PASS");
				}else if(!WCnewUILocators.lastName_validation.isDisplayed()&& (ExcelReader.get_row_data_from_col("lastResult",i)).contains("Accepted"))
				{
					log.info("For Valid criteria Validation Not there - PASS");
				}else
				{
					log.info("=========FAIL========= FAIL============= Validations Missing for LastName Field.=========FAIL========= FAIL=============");
				}			
			}

			// Email Address field Validation Test.
			for(int i=1;i<13; i++)
			{
				GenericMethods.enter_text(WCnewUILocators.email_txtb,ExcelReader.get_row_data_from_col("emailAddress", i), "Email Address");
				WaitMethods.wait_in_seconds(1);
				if(WCnewUILocators.email_validation.isDisplayed() && (ExcelReader.get_row_data_from_col("emailResult",i)).contains("Rejected"))
				{
					log.info("Validation message exists for Invalid Criteria-PASS");
				}else if(!WCnewUILocators.email_validation.isDisplayed()&& (ExcelReader.get_row_data_from_col("emailResult",i)).contains("Accepted"))
				{
					log.info("For Valid criteria Validation Not there - PASS");
				}else
				{
					log.info("=========FAIL========= FAIL============= Validations Missing for Email Address Field.=========FAIL========= FAIL=============");
				}			
			}

			// Phone Number field Validation Test.
			for(int i=1;i<5; i++)
			{
				GenericMethods.enter_text(WCnewUILocators.phoneNo_txtb,ExcelReader.get_row_data_from_col("PhoneNumber", i), "Phone Number");
				WaitMethods.wait_in_seconds(1);
				if(WCnewUILocators.phoneNo_validation.isDisplayed() && (ExcelReader.get_row_data_from_col("PhoneResult",i )).contains("Rejected"))
				{
					log.info("Validation message exists for Invalid Criteria-PASS");
				}else if(!WCnewUILocators.phoneNo_validation.isDisplayed()&& (ExcelReader.get_row_data_from_col("PhoneResult",i)).contains("Accepted"))
				{
					log.info("For Valid criteria Validation Not there - PASS");
				}else
				{
					log.info("=========FAIL========= FAIL============= Validations Missing for Phone Number Field.=========FAIL========= FAIL=============");
				}			
			}

			// FEIN No. field Validation Test.
			for(int i=1;i<10; i++)
			{
				GenericMethods.enter_text(WCnewUILocators.feinNo_txtb,ExcelReader.get_row_data_from_col("feinNumber", i), "FEIN Number");
				WaitMethods.wait_in_seconds(1);
				if(WCnewUILocators.feinNo_validation.isDisplayed() && (ExcelReader.get_row_data_from_col("feinResult",i )).contains("Rejected"))
				{
					log.info("Validation message exists for Invalid Criteria-PASS");
				}else if(!WCnewUILocators.feinNo_validation.isDisplayed()&& (ExcelReader.get_row_data_from_col("feinResult",i)).contains("Accepted"))
				{
					log.info("For Valid criteria Validation Not there - PASS");
				}else
				{
					log.info("=========FAIL========= FAIL============= Validations Missing for FEIN Field.=========FAIL========= FAIL=============");
				}			
			}

			// Experience Mod. field Validation Test.
			for(int i=1;i<10; i++)
			{	
				GenericMethods.click_Element(WCnewUILocators.expMod_Yes);
				GenericMethods.enter_text(WCnewUILocators.expMod_txtb,ExcelReader.get_row_data_from_col("experienceModification", i), "Experience Modification");
				WaitMethods.wait_in_seconds(1);
				if(WCnewUILocators.expMod_validation.isDisplayed() && (ExcelReader.get_row_data_from_col("ExModResult",i )).contains("Rejected"))
				{
					log.info("Validation message exists for Invalid Criteria-PASS");
				}else if(!WCnewUILocators.expMod_validation.isDisplayed()&& (ExcelReader.get_row_data_from_col("ExModResult",i)).contains("Accepted"))
				{
					log.info("For Valid criteria Validation Not there - PASS");
				}else
				{
					log.info("=========FAIL========= FAIL============= Validations Missing for Experience Modification Field.=========FAIL========= FAIL=============");
				}	
			}

			// Year Established field Validation Test.
			for(int i=1;i<17; i++)
			{
				GenericMethods.enter_text(WCnewUILocators.businessEstablished_txtb,ExcelReader.get_row_data_from_col("businessEstablished", i), "Business Established");
				WaitMethods.wait_in_seconds(1);
				if(WCnewUILocators.businessEst_validation1.isDisplayed()==false && (ExcelReader.get_row_data_from_col("BusninessEstResult",i)).contains("Accepted"))
				{
					log.info("For Valid criteria Validation Not there - PASS");
				}else if((WCnewUILocators.businessEst_validation1.isDisplayed() || WCnewUILocators.businessEst_validation2.isDisplayed() )&& (ExcelReader.get_row_data_from_col("BusninessEstResult",i )).contains("Rejected"))
				{
					log.info("Validation message exists for Invalid Criteria-PASS");
				}else
				{
					log.info("=========FAIL========= FAIL============= Validations Missing for Business Established Field.=========FAIL========= FAIL=============");
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

	/*
	 *Business Info page 1 
	 *All fields Validations 
	 */

	public static void to_testPage1_Validations()throws IOException, InterruptedException, Exception, AWTException
	{
		ExcelReader.set_excel_file(Locations.WC_UI_TestData,"Page1TestData");
		int Data_in_rows=ExcelReader.get_row_count();

		try
		{
			//===================Business Address validations========================//
			//Business Street field validation test

			for(int i=1;i<3; i++)
			{
				GenericMethods.enter_text(WCnewUILocators.business_street_txtb,ExcelReader.get_row_data_from_col("businessStreet_validation", i), "Busines Street");
				WaitMethods.wait_in_seconds(1);
				if(WCnewUILocators.businessStreet_validation2.isDisplayed() && ExcelReader.get_row_data_from_col("Result_a",i ).contains("Rejected"))
				{
					log.info("Validation message exists for Invalid Criteria-PASS");
				}else if(!WCnewUILocators.businessStreet_validation2.isDisplayed() && ExcelReader.get_row_data_from_col("Result_a",i).contains("Accepted"))
				{
					log.info("For Valid criteria Validation Not there - PASS");
				}else
				{
					log.info("=========FAIL========= FAIL============= Validations Missing for Business Street Field.=========FAIL========= FAIL=============");
				}			
			}

			//Business City field validation test

			for(int i=1;i<6; i++)
			{
				GenericMethods.enter_text(WCnewUILocators.business_City_txtb,ExcelReader.get_row_data_from_col("BusinessCity_validation", i), "Busines City");
				WaitMethods.wait_in_seconds(1);
				if(WCnewUILocators.businessCity_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_c",i ).contains("Rejected"))
				{
					log.info("Validation message exists for Invalid Criteria-PASS");
				}else if(!WCnewUILocators.businessCity_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_c",i).contains("Accepted"))
				{
					log.info("For Valid criteria Validation Not there - PASS");
				}else
				{
					log.info("=========FAIL========= FAIL============= Validations Missing for Business City Field.=========FAIL========= FAIL=============");
				}			
			}

			// Business Zip field validation
			for(int i=1;i<6; i++)
			{
				GenericMethods.enter_text(WCnewUILocators.business_zip_txtb,ExcelReader.get_row_data_from_col("businesZip_validation", i), "Busines Zip");
				WaitMethods.wait_in_seconds(1);
				if(WCnewUILocators.businesZip_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_g",i ).contains("Rejected"))
				{
					log.info("Validation message exists for Invalid Criteria-PASS");
				}else if(!WCnewUILocators.businesZip_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_g",i).contains("Accepted"))
				{
					log.info("For Valid criteria Validation Not there - PASS");
				}else
				{
					log.info("=========FAIL========= FAIL============= Validations Missing for Business ZIP Field.=========FAIL========= FAIL=============");
				}			
			}

			//Business state field validation test

			for(int i=1;i<8; i++)
			{	
				GenericMethods.enter_text(WCnewUILocators.business_street_txtb,ExcelReader.get_row_data_from_col("businessState_validation", i), "Business Street");
				WaitMethods.wait_in_seconds(2);
				GenericMethods.press_key_using_robot("downArrow");
				GenericMethods.press_key_using_robot("enter");
				WaitMethods.wait_in_seconds(3);

				WaitMethods.wait_in_seconds(1);
				if(ExcelReader.get_row_data_from_col("Result_e",i ).contains("Accepted"))
				{
					log.info("For Valid criteria Validation Not there - PASS");
				}else if(WCnewUILocators.businessState_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_e",i).contains("Rejected"))
				{
					log.info("Validation message exists for Invalid Criteria-PASS");
				}else
				{
					log.info("=========FAIL========= FAIL============= Validations Missing for Business State Field.=========FAIL========= FAIL=============");
				}			
			}


			//===================Mailing Address validations========================//

			// Mailing street field validation
			for(int i=1;i<3; i++)
			{
				GenericMethods.enter_text(WCnewUILocators.mail_street_txtb,ExcelReader.get_row_data_from_col("mailinStreet_validation", i), "Mailing Street");
				WaitMethods.wait_in_seconds(1);
				if(WCnewUILocators.mailinStreet_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_i",i ).contains("Rejected"))
				{
					log.info("Validation message exists for Invalid Criteria-PASS");
				}else if(!WCnewUILocators.mailinStreet_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_i",i).contains("Accepted"))
				{
					log.info("For Valid criteria Validation Not there - PASS");
				}else
				{
					log.info("=========FAIL========= FAIL============= Validations Missing for Mailing Street Field.=========FAIL========= FAIL=============");
				}			
			}

			// Mailing City field validation
			for(int i=1;i<6; i++)
			{
				GenericMethods.enter_text(WCnewUILocators.mail_city_txtb,ExcelReader.get_row_data_from_col("mailCity_validation", i), "");
				WaitMethods.wait_in_seconds(1);
				if(WCnewUILocators.mailCity_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_k",i ).contains("Rejected"))
				{
					log.info("Validation message exists for Invalid Criteria-PASS");
				}else if(!WCnewUILocators.mailCity_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_k",i).contains("Accepted"))
				{
					log.info("For Valid criteria Validation Not there - PASS");
				}else
				{
					log.info("=========FAIL========= FAIL============= Validations Missing for Mailing City Field.=========FAIL========= FAIL=============");
				}			
			}

			// Mail zip field validation
			for(int i=1;i<8; i++)
			{
				GenericMethods.enter_text(WCnewUILocators.mail_zip_txtb,ExcelReader.get_row_data_from_col("mailingZip_validation", i), "Busines Zip");
				WaitMethods.wait_in_seconds(1);
				if(WCnewUILocators.mailZip_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_m",i ).contains("Rejected"))
				{
					log.info("Validation message exists for Invalid Criteria-PASS");
				}else if(!WCnewUILocators.mailZip_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_m",i).contains("Accepted"))
				{
					log.info("For Valid criteria Validation Not there - PASS");
				}
				else
				{
					log.info("=========FAIL========= FAIL============= Validations Missing for Mailing Zip Field.=========FAIL========= FAIL=============");
				}
			}

			//===================Additional Address 1 validations========================//

			GenericMethods.click_Element_Using_JS(WCnewUILocators.add_businessLocation_YES_radio);


			// Additional Address street 1  field validation
			for(int i=1;i<3; i++)
			{
				GenericMethods.enter_text(WCnewUILocators.add1_street_txtb,ExcelReader.get_row_data_from_col("add1street_validation", i), "add 1 Street");
				WaitMethods.wait_in_seconds(1);
				if(WCnewUILocators.add1street_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_o",i ).contains("Rejected"))
				{
					log.info("Validation message exists for Invalid Criteria-PASS");
				}else if(!WCnewUILocators.add1street_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_o",i).contains("Accepted"))
				{
					log.info("For Valid criteria Validation Not there - PASS");
				}else
				{
					log.info("=========FAIL========= FAIL============= Validations Missing for Additional Address street 1 Field.=========FAIL========= FAIL=============");
				}			
			}

			// Additional Address City 1  field validation
			for(int i=1;i<6; i++)
			{
				GenericMethods.enter_text(WCnewUILocators.add1_city_txtb,ExcelReader.get_row_data_from_col("add1City_validation", i), "Add 1 City");
				WaitMethods.wait_in_seconds(1);
				if(WCnewUILocators.add1City_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_q",i ).contains("Rejected"))
				{
					log.info("Validation message exists for Invalid Criteria-PASS");
				}else if(!WCnewUILocators.add1City_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_q",i).contains("Accepted"))
				{
					log.info("For Valid criteria Validation Not there - PASS");
				}else
				{
					log.info("=========FAIL========= FAIL============= Validations Missing for Additional Address City 1 Field.=========FAIL========= FAIL=============");
				}			
			}

			// Additional Address Zip 1  field validation
			for(int i=1;i<8; i++)
			{
				GenericMethods.enter_text(WCnewUILocators.add1_zip_txtb,ExcelReader.get_row_data_from_col("add1Zip_validation", i), "add 1 Zip ");
				WaitMethods.wait_in_seconds(1);
				if(WCnewUILocators.add1Zip_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_u",i ).contains("Rejected"))
				{
					log.info("Validation message exists for Invalid Criteria-PASS");
				}else if(!WCnewUILocators.add1Zip_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_u",i).contains("Accepted"))
				{
					log.info("For Valid criteria Validation Not there - PASS");
				}else
				{
					log.info("=========FAIL========= FAIL============= Validations Missing for Additional Address Zip 1 Field.=========FAIL========= FAIL=============");
				}			
			}

			// Additional Address State 1  field validation
			for(int i=1;i<8; i++)
			{
				GenericMethods.enter_text(WCnewUILocators.add1_street_txtb,ExcelReader.get_row_data_from_col("add1State_validation", i), "Business Street Add 1");
				WaitMethods.wait_in_seconds(2);
				GenericMethods.press_key_using_robot("downArrow");
				GenericMethods.press_key_using_robot("enter");
				WaitMethods.wait_in_seconds(3);

				WaitMethods.wait_in_seconds(1);
				if(ExcelReader.get_row_data_from_col("Result_s",i ).contains("Accepted"))
				{
					log.info("For Valid criteria Validation Not there - PASS");
				}else if(WCnewUILocators.add1State_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_s",i).contains("Rejected"))
				{
					log.info("Validation message exists for Invalid Criteria-PASS");
				}else
				{
					log.info("=========FAIL========= FAIL============= Validations Missing for Business State add 1 Field.=========FAIL========= FAIL=============");
				}		
			}

			//===================Additional Address 2 validations========================//

			GenericMethods.click_Element_Using_JS(WCnewUILocators.add_address2_YES_radio);

			// Additional Address street 2  field validation
			for(int i=1;i<3; i++)
			{
				GenericMethods.enter_text(WCnewUILocators.add2_street_txtb,ExcelReader.get_row_data_from_col("aad2Street_validation", i), "add 2 Street");
				WaitMethods.wait_in_seconds(1);
				if(WCnewUILocators.aad2Street_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_w",i ).contains("Rejected"))
				{
					log.info("Validation message exists for Invalid Criteria-PASS");
				}else if(!WCnewUILocators.aad2Street_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_w",i).contains("Accepted"))
				{
					log.info("For Valid criteria Validation Not there - PASS");
				}else
				{
					log.info("=========FAIL========= FAIL============= Validations Missing for Additional Address street 2 Field.=========FAIL========= FAIL=============");
				}			
			}

			// Additional Address City 2  field validation
			for(int i=1;i<6; i++)
			{
				GenericMethods.enter_text(WCnewUILocators.add2_city_txtb,ExcelReader.get_row_data_from_col("add2City_validation", i), "Add 2 City");
				WaitMethods.wait_in_seconds(1);
				if(WCnewUILocators.add2City_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_y",i ).contains("Rejected"))
				{
					log.info("Validation message exists for Invalid Criteria-PASS");
				}else if(!WCnewUILocators.add2City_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_y",i).contains("Accepted"))
				{
					log.info("For Valid criteria Validation Not there - PASS");
				}else
				{
					log.info("=========FAIL========= FAIL============= Validations Missing for Additional Address City 2 Field.=========FAIL========= FAIL=============");
				}			
			}

			// Additional Address Zip 2  field validation
			for(int i=1;i<8; i++)
			{
				GenericMethods.enter_text(WCnewUILocators.add2_zip_txtb,ExcelReader.get_row_data_from_col("add2Zip_validation", i), "add 2 Zip ");
				WaitMethods.wait_in_seconds(1);
				if(WCnewUILocators.add2Zip_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_ac",i ).contains("Rejected"))
				{
					log.info("Validation message exists for Invalid Criteria-PASS");
				}else if(!WCnewUILocators.add2Zip_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_ac",i).contains("Accepted"))
				{
					log.info("For Valid criteria Validation Not there - PASS");
				}else
				{
					log.info("=========FAIL========= FAIL============= Validations Missing for Additional Address Zip 2 Field.=========FAIL========= FAIL=============");
				}			
			}

			// Additional Address State 2  field validation
			for(int i=1;i<8; i++)
			{
				GenericMethods.enter_text(WCnewUILocators.add2_street_txtb,ExcelReader.get_row_data_from_col("add2State_validation", i), "Business Street Add 2");
				WaitMethods.wait_in_seconds(2);
				GenericMethods.press_key_using_robot("downArrow");
				GenericMethods.press_key_using_robot("enter");
				WaitMethods.wait_in_seconds(3);

				WaitMethods.wait_in_seconds(1);
				if(ExcelReader.get_row_data_from_col("Result_aa",i ).contains("Accepted"))
				{
					log.info("For Valid criteria Validation Not there - PASS");
				}else if(WCnewUILocators.add2State_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_aa",i).contains("Rejected"))
				{
					log.info("Validation message exists for Invalid Criteria-PASS");
				}else
				{
					log.info("=========FAIL========= FAIL============= Validations Missing for Business State add 2 Field.=========FAIL========= FAIL=============");
				}		
			}

			//===================Additional Address 3 validations========================//

			GenericMethods.click_Element_Using_JS(WCnewUILocators.add_address3_YES_radio);

			// Additional Address street 3  field validation
			for(int i=1;i<3; i++)
			{
				GenericMethods.enter_text(WCnewUILocators.add3_street_txtb,ExcelReader.get_row_data_from_col("add3Street_validation", i), "add 3 Street");
				WaitMethods.wait_in_seconds(1);
				if(WCnewUILocators.add3Street_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_ae",i ).contains("Rejected"))
				{
					log.info("Validation message exists for Invalid Criteria-PASS");
				}else if(!WCnewUILocators.add3Street_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_ae",i).contains("Accepted"))
				{
					log.info("For Valid criteria Validation Not there - PASS");
				}else
				{
					log.info("=========FAIL========= FAIL============= Validations Missing for Additional Address street 3 Field.=========FAIL========= FAIL=============");
				}			
			}

			// Additional Address City 3  field validation
			for(int i=1;i<6; i++)
			{
				GenericMethods.enter_text(WCnewUILocators.add3_city_txtb,ExcelReader.get_row_data_from_col("add3City_validation", i), "Add 3 City");
				WaitMethods.wait_in_seconds(1);
				if(WCnewUILocators.add3City_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_ag",i ).contains("Rejected"))
				{
					log.info("Validation message exists for Invalid Criteria-PASS");
				}else if(!WCnewUILocators.add3City_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_ag",i).contains("Accepted"))
				{
					log.info("For Valid criteria Validation Not there - PASS");
				}else
				{
					log.info("=========FAIL========= FAIL============= Validations Missing for Additional Address City 3 Field.=========FAIL========= FAIL=============");
				}			
			}

			// Additional Address Zip 3  field validation
			for(int i=1;i<8; i++)
			{
				GenericMethods.enter_text(WCnewUILocators.add3_zip_txtb,ExcelReader.get_row_data_from_col("add3Zip_validation", i), "add 3 Zip ");
				WaitMethods.wait_in_seconds(1);
				if(WCnewUILocators.add3Zip_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_ak",i ).contains("Rejected"))
				{
					log.info("Validation message exists for Invalid Criteria-PASS");
				}else if(!WCnewUILocators.add3Zip_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_ak",i).contains("Accepted"))
				{
					log.info("For Valid criteria Validation Not there - PASS");
				}else
				{
					log.info("=========FAIL========= FAIL============= Validations Missing for Additional Address Zip 3 Field.=========FAIL========= FAIL=============");
				}			
			}

			// Additional Address State 3  field validation
			for(int i=1;i<8; i++)
			{
				GenericMethods.enter_text(WCnewUILocators.add3_street_txtb,ExcelReader.get_row_data_from_col("add3State_validation", i), "Business Street Add 3");
				WaitMethods.wait_in_seconds(2);
				GenericMethods.press_key_using_robot("downArrow");
				GenericMethods.press_key_using_robot("enter");
				WaitMethods.wait_in_seconds(3);

				WaitMethods.wait_in_seconds(1);
				if(ExcelReader.get_row_data_from_col("Result_ai",i ).contains("Accepted"))
				{
					log.info("For Valid criteria Validation Not there - PASS");
				}
				else if(WCnewUILocators.add3State_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Result_ai",i).contains("Rejected"))
				{
					log.info("Validation message exists for Invalid Criteria-PASS");
				}
				else
				{
					log.info("=========FAIL========= FAIL============= Validations Missing for Business State add 3 Field.=========FAIL========= FAIL=============");
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


	// This test is to Verify Duplicate validation exists or Not for Business Address & additional address & Next Button Disable. 

	public static void duplicateAddress_validation(int row_num, String diff_address)throws IOException, InterruptedException, Exception, AWTException
	{	
		ExcelReader.set_excel_file(Locations.WC_UI_TestData,"BusinessInfo");

		GenericMethods.enter_text(WCnewUILocators.business_street_txtb,ExcelReader.get_row_data_from_col("BusinessStreet", row_num), "Business Street");

		WaitMethods.wait_in_seconds(2);

		GenericMethods.press_key_using_robot("downArrow");
		GenericMethods.press_key_using_robot("enter");
		GenericMethods.click_enter_using_robot();

		WaitMethods.wait_in_seconds(2);
		GenericMethods.is_element_present(WCnewUILocators.businessAndMailingAddressSame_chkBox);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.businessAndMailingAddressSame_chkBox);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.businessAndMailingAddressSame_chkBox);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.businessAndMailingAddressSame_chkBox);
		WaitMethods.wait_in_seconds(2);

		GenericMethods.click_Element_Using_JS(WCnewUILocators.add_businessLocation_YES_radio);
		GenericMethods.enter_text(WCnewUILocators.add1_street_txtb,ExcelReader.get_row_data_from_col("BusinessStreet", row_num), "Business Street address 1");
		WaitMethods.wait_in_seconds(2);
		GenericMethods.press_key_using_robot("downArrow");
		GenericMethods.press_key_using_robot("enter");
		WaitMethods.wait_in_seconds(2);

		GenericMethods.press_key_using_robot("tab");

		String duplicte = WCnewUILocators.DubplicateAdd_validationMsg.getText();
		Assert.assertEquals(duplicte,"Duplicate address found");
		log.info("===========================Duplicate Address validation message exists - Pass ===========================");

		Assert.assertTrue(WCnewUILocators.next_btn.isEnabled()== false);
		log.info("==================Next Button is Disable - Pass ====================");

	}





	/*
	 * The purpose of this method is to 
	 * click on YES radio btn in coverage History page
	 * & verify Current Carrier name & Years of Prior Coverage Question appear or Not.
	 */
	public static void coverageHistoryQuestions_verify()throws IOException, InterruptedException, Exception, AWTException
	{		
		String quoteNo=WCnewUILocators.quoteNo.getText();
		String finsihQuote=quoteNo.substring(8);
		log.info("=============================>>>>>     "+finsihQuote+"     <<<<<======================================");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.priorCoverage_Yes_radio);
		if(WCnewUILocators.currentCarrierName_txtb.isDisplayed() && WCnewUILocators.priorCoverageYear_drpd.isDisplayed())
		{
			log.info("========Current Carrier name & Years of Prior Coverage Question appear -Successfully=========");
		}
		else {
			log.info("============Current Carrier name & Years of Prior Coverage Question appear -Fail============");
		}
	}

	/*
	 * The purpose of this method is to 
	 * click on No radio btn in coverage History page
	 * & verify it Directly take you to Class Code page or Not
	 */		
	public static void takeitToClassCode()throws IOException, InterruptedException, Exception, AWTException
	{
		GenericMethods.click_Element_Using_JS(WCnewUILocators.priorCoverage_No_radio);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.employeesWorking_No_radio);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		if(WCnewUILocators.classCode_Heading.isDisplayed())
		{
			log.info("=============Class Code page appears -Successfully========");
		}
		else {
			log.info("==============Something went wrong Class Code page Not appear -Fail=================");
		}	
	}

	public static void coverageHistoryWithNOoption( String empWorking)throws IOException, InterruptedException, Exception, AWTException
	{		
		String quoteNo=WCnewUILocators.quoteNo.getText();
		String finsihQuote=quoteNo.substring(8);
		log.info("=============================>>>>>     "+finsihQuote+"     <<<<<======================================");
		if(empWorking.equalsIgnoreCase("empNo"))
		{
			GenericMethods.click_Element_Using_JS(WCnewUILocators.priorCoverage_No_radio);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.employeesWorking_No_radio);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
			WaitMethods.wait_in_seconds(2);
		}
		else if(empWorking.equalsIgnoreCase("empYes"))
		{
			GenericMethods.click_Element_Using_JS(WCnewUILocators.priorCoverage_No_radio);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.employeesWorking_Yes_radio);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
			WaitMethods.wait_in_seconds(2);
		}
	}
	//This Method is Not in use more.===========================================================================
	/*
	 * The purpose of this method is to 
	 * Fill all details in coverage History page with Single Entry to save Time
	 * & verify it take you to Business Info page or Not
	 */
	public static void fillDetailsCoveragePage_SingleEntry(int row_num)throws IOException, InterruptedException, Exception, AWTException
	{	
		String quoteNo=WCnewUILocators.quoteNo.getText();
		String finsihQuote=quoteNo.substring(8);
		log.info("=============================>>>>>     "+finsihQuote+"     <<<<<======================================");
		ExcelReader.set_excel_file(Locations.WC_UI_TestData,"CoveragePage");

		GenericMethods.click_Element_Using_JS(WCnewUILocators.priorCoverage_Yes_radio);

		WCnewUILocators.effectiveDate0.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, -365, 0, 0, 0));
		GenericMethods.press_key_using_robot("tab");
		WCnewUILocators.expirationDate0.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, 0, 0, 0, 0));
		GenericMethods.press_key_using_robot("tab");
		GenericMethods.enter_text(WCnewUILocators.policyNo0_txtb,ExcelReader.get_row_data_from_col("PolicyNo0", row_num), "PolicyNo0");		
		GenericMethods.enter_text(WCnewUILocators.carrierName0_txtb,ExcelReader.get_row_data_from_col("Carrier0", row_num), "Carrier0");		
		GenericMethods.enter_text(WCnewUILocators.annualPremium0_txtb,ExcelReader.get_row_data_from_col("Premium0", row_num), "Premium0");		
		WaitMethods.wait_in_seconds(2);
	}

	//This Method is Not in use more.===========================================================================
	/*
	 * The purpose of this method is to 
	 * Fill all details in coverage History page
	 * & verify it take you to Business Info page or Not
	 */
	public static void fillDetailsCoveragePage(int row_num)throws IOException, InterruptedException, Exception, AWTException
	{		
		String quoteNo=WCnewUILocators.quoteNo.getText();
		String finsihQuote=quoteNo.substring(8);
		log.info("=============================>>>>>     "+finsihQuote+"     <<<<<======================================");

		ExcelReader.set_excel_file(Locations.WC_UI_TestData,"CoveragePage");

		GenericMethods.click_Element_Using_JS(WCnewUILocators.priorCoverage_Yes_radio);

		WCnewUILocators.effectiveDate0.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, -365, 0, 0, 0));
		GenericMethods.press_key_using_robot("tab");
		WCnewUILocators.expirationDate0.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, -1, 0, 0, 0));
		GenericMethods.press_key_using_robot("tab");
		GenericMethods.enter_text(WCnewUILocators.policyNo0_txtb,ExcelReader.get_row_data_from_col("PolicyNo0", row_num), "PolicyNo0");		
		GenericMethods.enter_text(WCnewUILocators.carrierName0_txtb,ExcelReader.get_row_data_from_col("Carrier0", row_num), "Carrier0");		
		GenericMethods.enter_text(WCnewUILocators.annualPremium0_txtb,ExcelReader.get_row_data_from_col("Premium0", row_num), "Premium0");		
		WaitMethods.wait_in_seconds(2);

		WCnewUILocators.effectiveDate1.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, -730, 0, 0, 0));
		GenericMethods.press_key_using_robot("tab");
		WCnewUILocators.expirationDate1.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, -366, 0, 0, 0));
		GenericMethods.press_key_using_robot("tab");
		GenericMethods.enter_text(WCnewUILocators.policyNo1_txtb,ExcelReader.get_row_data_from_col("PolicyNo1", row_num), "PolicyNo1");		
		GenericMethods.enter_text(WCnewUILocators.carrierName1_txtb,ExcelReader.get_row_data_from_col("Carrier1", row_num), "Carrier1");		
		GenericMethods.enter_text(WCnewUILocators.annualPremium1_txtb,ExcelReader.get_row_data_from_col("Premium1", row_num), "Premium1");
		WaitMethods.wait_in_seconds(2);

		WCnewUILocators.effectiveDate2.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, -1095, 0, 0, 0));
		GenericMethods.press_key_using_robot("tab");
		WCnewUILocators.expirationDate2.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, -731, 0, 0, 0));
		GenericMethods.press_key_using_robot("tab");
		GenericMethods.enter_text(WCnewUILocators.policyNo2_txtb,ExcelReader.get_row_data_from_col("PolicyNo2", row_num), "PolicyNo2");		
		GenericMethods.enter_text(WCnewUILocators.carrierName2_txtb,ExcelReader.get_row_data_from_col("Carrier2", row_num), "Carrier2");		
		GenericMethods.enter_text(WCnewUILocators.annualPremium2_txtb,ExcelReader.get_row_data_from_col("Premium2", row_num), "Premium2");
		WaitMethods.wait_in_seconds(2);

		WCnewUILocators.effectiveDate3.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, -1826, 0, 0, 0));
		GenericMethods.press_key_using_robot("tab");
		WCnewUILocators.expirationDate3.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, -1600, 0, 0, 0));
		GenericMethods.press_key_using_robot("tab");
		GenericMethods.enter_text(WCnewUILocators.policyNo3_txtb,ExcelReader.get_row_data_from_col("PolicyNo3", row_num), "PolicyNo3");		
		GenericMethods.enter_text(WCnewUILocators.carrierName3_txtb,ExcelReader.get_row_data_from_col("Carrier3", row_num), "Carrier3");		
		GenericMethods.enter_text(WCnewUILocators.annualPremium3_txtb,ExcelReader.get_row_data_from_col("Premium3", row_num), "Premium3");
		WaitMethods.wait_in_seconds(2);

	}

	/*
	 * The purpose of this method is to 
	 * Fill all details in coverage History page
	 */
	public static void fillDetailsCoveragePage_New(int row_num)throws IOException, InterruptedException, Exception, AWTException
	{	
		String quoteNo=WCnewUILocators.quoteNo.getText();
		String finsihQuote=quoteNo.substring(8);
		log.info("=============================>>>>>     "+finsihQuote+"     <<<<<======================================");

		ExcelReader.set_excel_file(Locations.WC_UI_TestData,"CoveragePage");

		GenericMethods.click_Element_Using_JS(WCnewUILocators.priorCoverage_Yes_radio);
		GenericMethods.enter_text(WCnewUILocators.currentCarrierName_txtb,ExcelReader.get_row_data_from_col("CarrierName", row_num), "Carrier Name");		
		GenericMethods.enter_text(WCnewUILocators.annual_premium_txtb,"50000", "Carrier Name");		
		GenericMethods.select_from_dropdown(WCnewUILocators.priorCoverageYear_drpd, "visibletext", ExcelReader.get_row_data_from_col("Coverage Year", row_num));
	}


	//=====================Verify date range validations in Coverage History Page=========================
	public static void verifyDateRange_Validation()throws IOException, InterruptedException, Exception, AWTException
	{
		GenericMethods.click_Element_Using_JS(WCnewUILocators.priorCoverage_Yes_radio);

		WCnewUILocators.effectiveDate0.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, -365, 0, 0, 0));
		GenericMethods.press_key_using_robot("tab");
		WCnewUILocators.expirationDate0.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, +1, 0, 0, 0));
		GenericMethods.press_key_using_robot("tab");
		if(WCnewUILocators.expiration_greater_0.isDisplayed())
		{
			log.info("======================>Date range Validation Present<=======================");
		}
		WCnewUILocators.expirationDate0.clear();
		WCnewUILocators.expirationDate0.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, -1, 0, 0, 0));
		GenericMethods.press_key_using_robot("tab");
		GenericMethods.enter_text(WCnewUILocators.policyNo0_txtb,"XYZ1234", "PolicyNo0");		
		GenericMethods.enter_text(WCnewUILocators.carrierName0_txtb,"SmartData Carrier", "Carrier0");		
		GenericMethods.enter_text(WCnewUILocators.annualPremium0_txtb,"999", "Premium0");		
		WaitMethods.wait_in_seconds(2);

		WCnewUILocators.effectiveDate1.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, -230, 0, 0, 0));
		GenericMethods.press_key_using_robot("tab");
		WCnewUILocators.expirationDate1.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, +5, 0, 0, 0));
		GenericMethods.press_key_using_robot("tab");
		if(WCnewUILocators.dateOverlap_end1.isDisplayed() && WCnewUILocators.dateOverlap_start1.isDisplayed())
		{
			log.info("=======================>Date Overlap Validation Present<=====================");
		}
		GenericMethods.click_Element_Using_JS(WCnewUILocators.reset1);

		WCnewUILocators.effectiveDate1.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, -1, 0, 0, 0));
		GenericMethods.press_key_using_robot("tab");
		WCnewUILocators.expirationDate1.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, +300, 0, 0, 0));
		GenericMethods.press_key_using_robot("tab");
		GenericMethods.enter_text(WCnewUILocators.policyNo1_txtb,"ABCD007", "PolicyNo1");		
		GenericMethods.enter_text(WCnewUILocators.carrierName1_txtb,"TATA Carrier", "Carrier1");		
		GenericMethods.enter_text(WCnewUILocators.annualPremium1_txtb,"199", "Premium1");
		WaitMethods.wait_in_seconds(2);

	}


	// verify all fields validations in coverage page

	public static void verifyValidationss_coverageHistory()throws IOException, InterruptedException, Exception, AWTException
	{	
		String quoteNo=WCnewUILocators.quoteNo.getText();
		String finsihQuote=quoteNo.substring(8);
		log.info("=============================>>>>>     "+finsihQuote+"     <<<<<======================================");

		ExcelReader.set_excel_file(Locations.WC_UI_TestData,"CoveragePage");

		GenericMethods.click_Element_Using_JS(WCnewUILocators.priorCoverage_Yes_radio);

		// Current Carrier name
		for(int i=1;i<8; i++)
		{
			GenericMethods.enter_text(WCnewUILocators.currentCarrierName_txtb,ExcelReader.get_row_data_from_col("CarrierName", i), "CarrierName");
			GenericMethods.click_Element(WCnewUILocators.currentCarrierName_txtb);
			WaitMethods.wait_in_seconds(1);
			if(WCnewUILocators.currentCarrierName_validation2.isDisplayed() && ExcelReader.get_row_data_from_col("CarrierResults",i ).contains("Rejected"))
			{
				log.info("Validation message exists for Invalid Criteria-PASS");
			}else if(!WCnewUILocators.currentCarrierName_validation2.isDisplayed() && ExcelReader.get_row_data_from_col("CarrierResults",i).contains("Accepted"))
			{
				log.info("For Valid criteria Validation Not there - PASS");
			}else
			{
				log.info("=========Invalid Values Not allowed to Enter=============");
			}			
		}
		/*//prior coverage information 1

		for(int i=1;i<8; i++)
		{
			GenericMethods.enter_text(WCnewUILocators.annualPremium0_txtb,ExcelReader.get_row_data_from_col("Premium 0", i), "Premium 0");
			GenericMethods.click_Element(WCnewUILocators.carrierName0_txtb);
			WaitMethods.wait_in_seconds(1);
			if(WCnewUILocators.AnnualPremium0_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Premium 0 Result",i ).contains("Rejected"))
			{
				log.info("Validation message exists for Invalid Criteria-PASS");
			}else if(!WCnewUILocators.AnnualPremium0_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Premium 0 Result",i).contains("Accepted"))
			{
				log.info("For Valid criteria Validation Not there - PASS");
			}else
			{
				log.info("=========Invalid Values Not allowed to Enter=============");
			}			
		}

		//prior coverage information 2

		for(int i=1;i<8; i++)
		{
			GenericMethods.enter_text(WCnewUILocators.annualPremium1_txtb,ExcelReader.get_row_data_from_col("Premium 1", i), "Premium 1");
			GenericMethods.click_Element(WCnewUILocators.carrierName1_txtb);
			WaitMethods.wait_in_seconds(1);
			if(WCnewUILocators.AnnualPremium1_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Premium 1 Result",i ).contains("Rejected"))
			{
				log.info("Validation message exists for Invalid Criteria-PASS");
			}else if(!WCnewUILocators.AnnualPremium1_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Premium 1 Result",i).contains("Accepted"))
			{
				log.info("For Valid criteria Validation Not there - PASS");
			}else
			{
				log.info("=========Invalid Values Not allowed to Enter=============");
			}			
		}

		//prior coverage information 3

		for(int i=1;i<8; i++)
		{
			GenericMethods.enter_text(WCnewUILocators.annualPremium2_txtb,ExcelReader.get_row_data_from_col("Premium 2", i), "Premium 2");
			GenericMethods.click_Element(WCnewUILocators.carrierName2_txtb);
			WaitMethods.wait_in_seconds(1);
			if(WCnewUILocators.AnnualPremium2_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Premium 2 Result",i ).contains("Rejected"))
			{
				log.info("Validation message exists for Invalid Criteria-PASS");
			}else if(!WCnewUILocators.AnnualPremium2_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Premium 2 Result",i).contains("Accepted"))
			{
				log.info("For Valid criteria Validation Not there - PASS");
			}else
			{
				log.info("=========Invalid Values Not allowed to Enter=============");
			}			
		}

		//prior coverage information 4

		for(int i=1;i<8; i++)
		{
			GenericMethods.enter_text(WCnewUILocators.annualPremium3_txtb,ExcelReader.get_row_data_from_col("Premium 3", i), "Premium 3");
			GenericMethods.click_Element(WCnewUILocators.carrierName3_txtb);
			WaitMethods.wait_in_seconds(1);
			if(WCnewUILocators.AnnualPremium2_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Premium 3 Result",i ).contains("Rejected"))
			{
				log.info("Validation message exists for Invalid Criteria-PASS");
			}else if(!WCnewUILocators.AnnualPremium2_validation.isDisplayed() && ExcelReader.get_row_data_from_col("Premium 3 Result",i).contains("Accepted"))
			{
				log.info("For Valid criteria Validation Not there - PASS");
			}else
			{
				log.info("=========Invalid Values Not allowed to Enter=============");
			}			
		}*/
	}
	/*
	 * Page 4 LOSS iNFO PAGE
	 * with Zero claim count - & hit Next take you to 
	 * Class code page Directly Verify.
	 */
	public static void verifyLossinfo_to_classCode()throws IOException, InterruptedException, Exception, AWTException
	{	
		String drpdValue =GenericMethods.get_selected_optn_frm_ele(WCnewUILocators.value_Incrementer_drpd);
		drpdValue.equals("0");
		//WCnewUILocators.value_Incrementer_txt.getText().contains("0");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		Assert.assertEquals(WCnewUILocators.classCode_Heading.getText(),"Class Codes");
		log.info("==================Class Code page appears -Successfully==============");	

		GenericMethods.click_Element_Using_JS(WCnewUILocators.back_btn);
		GenericMethods.select_from_dropdown(WCnewUILocators.value_Incrementer_drpd, "visibletext","4 +");
		Assert.assertEquals(WCnewUILocators.lossInfo4year_msg.getText(),"Please email currently valued loss runs to comp@btisinc.com. Be sure to reference the quote number above.");
		log.info("===========Message appeared -Successfully================");	

		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		Assert.assertEquals(WCnewUILocators.classCode_Heading.getText(),"Class Codes");
		log.info("=============Class Code page appears -Successfully==================");
	}


	//This Method is Not more in Use
	/*
	 * Page 4 LOSS iNFO PAGE
	 * with Foure claim count - & hit Next take you to 
	 * Class code page Directly Verify.
	 */
	public static void verifyLossinfo_to_classCode_moreThen3Claim()throws IOException, InterruptedException, Exception, AWTException
	{	
		GenericMethods.click_Element_Using_JS(WCnewUILocators.plus_Incrementer_btn);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.plus_Incrementer_btn);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.plus_Incrementer_btn);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.plus_Incrementer_btn);
		WCnewUILocators.value_Incrementer_txt.getText().contains("4");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		if(WCnewUILocators.classCode_Heading.isDisplayed())
		{
			log.info("Class Code page appears -Successfully");
		}
		else {
			log.info("Something went wrong Class Code page Not appear -Fail");
		}
	}

	/*
	 * Page 4 Loss Info page
	 * with 3 claim count & hit next
	 */
	//==================================This method is Not in use more======================================
	public static void fill_with3claimCount(int row_num)throws IOException, InterruptedException, Exception, AWTException
	{	
		GenericMethods.click_Element_Using_JS(WCnewUILocators.plus_Incrementer_btn);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.plus_Incrementer_btn);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.plus_Incrementer_btn);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		ExcelReader.set_excel_file(Locations.WC_UI_TestData,"LossInfo3Loss");

		WCnewUILocators.DateOfLoss0.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, -50, 0, 0, 0));
		GenericMethods.click_Element(WCnewUILocators.DescriptionOfLoss0_txtb);
		GenericMethods.enter_text(WCnewUILocators.DescriptionOfLoss0_txtb,ExcelReader.get_row_data_from_col("Description of Loss0", row_num), "Description of Loss");		
		GenericMethods.enter_text(WCnewUILocators.ReserveAmt0_txtb,ExcelReader.get_row_data_from_col("Reserve Amount0", row_num), "Reserve Amount");		
		GenericMethods.enter_text(WCnewUILocators.PaidAmt0_txtb,ExcelReader.get_row_data_from_col("Paid Amount0", row_num), "Paid Amount");		
		WaitMethods.wait_in_seconds(2);

		WCnewUILocators.DateOfLoss1.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, -250, 0, 0, 0));
		GenericMethods.click_Element(WCnewUILocators.DescriptionOfLoss1_txtb);
		GenericMethods.enter_text(WCnewUILocators.DescriptionOfLoss1_txtb,ExcelReader.get_row_data_from_col("Description of Loss1", row_num), "Description of Loss");		
		GenericMethods.enter_text(WCnewUILocators.ReserveAmt1_txtb,ExcelReader.get_row_data_from_col("Reserve Amount1", row_num), "Reserve Amount");		
		GenericMethods.enter_text(WCnewUILocators.PaidAmt1_txtb,ExcelReader.get_row_data_from_col("Paid Amount1", row_num), "Paid Amount");		
		WaitMethods.wait_in_seconds(2);

		WCnewUILocators.DateOfLoss2.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, -550, 0, 0, 0));
		GenericMethods.click_Element(WCnewUILocators.DescriptionOfLoss2_txtb);
		GenericMethods.enter_text(WCnewUILocators.DescriptionOfLoss2_txtb,ExcelReader.get_row_data_from_col("Description of Loss2", row_num), "Description of Loss");		
		GenericMethods.enter_text(WCnewUILocators.ReserveAmt2_txtb,ExcelReader.get_row_data_from_col("Reserve Amount2", row_num), "Reserve Amount");		
		GenericMethods.enter_text(WCnewUILocators.PaidAmt2_txtb,ExcelReader.get_row_data_from_col("Paid Amount2", row_num), "Paid Amount");		
		WaitMethods.wait_in_seconds(2);

		GenericMethods.enter_text(WCnewUILocators.description_txtb,ExcelReader.get_row_data_from_col("Describe corrective actions", row_num), "Describe corrective actions");
	}

	/*
	 * Page 4 Loss Info page
	 * with 2 claim count & hit next
	 */
	public static void fill_with2claimCount_new(int row_num)throws IOException, InterruptedException, Exception, AWTException
	{	

		ExcelReader.set_excel_file(Locations.WC_UI_TestData,"LossInfo3Loss");

		GenericMethods.select_from_dropdown(WCnewUILocators.value_Incrementer_drpd, "visibletext","2");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUILocators.DateOfLoss0.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, -150, 0, 0, 0));
		GenericMethods.click_Element(WCnewUILocators.DescriptionOfLoss0_txtb);
		GenericMethods.enter_text(WCnewUILocators.DescriptionOfLoss0_txtb,ExcelReader.get_row_data_from_col("Description of Loss0", row_num), "Description of Loss");		
		GenericMethods.enter_text(WCnewUILocators.ReserveAmt0_txtb,ExcelReader.get_row_data_from_col("Reserve Amount0", row_num), "Reserve Amount");		
		GenericMethods.enter_text(WCnewUILocators.PaidAmt0_txtb,ExcelReader.get_row_data_from_col("Paid Amount0", row_num), "Paid Amount");		
		WaitMethods.wait_in_seconds(2);


		WCnewUILocators.DateOfLoss1.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, -350, 0, 0, 0));
		GenericMethods.click_Element(WCnewUILocators.DescriptionOfLoss1_txtb);
		GenericMethods.enter_text(WCnewUILocators.DescriptionOfLoss1_txtb,ExcelReader.get_row_data_from_col("Description of Loss1", row_num), "Description of Loss");		
		GenericMethods.enter_text(WCnewUILocators.ReserveAmt1_txtb,ExcelReader.get_row_data_from_col("Reserve Amount1", row_num), "Reserve Amount");		
		GenericMethods.enter_text(WCnewUILocators.PaidAmt1_txtb,ExcelReader.get_row_data_from_col("Paid Amount1", row_num), "Paid Amount");		
		GenericMethods.click_Element(WCnewUILocators.Indemnity1_radio);
		WaitMethods.wait_in_seconds(2);
		GenericMethods.enter_text(WCnewUILocators.description_txtb,ExcelReader.get_row_data_from_col("Describe corrective actions", row_num), "Describe corrective actions");
	}

	/*Loss Info page
    ======Verify Date range Test for Loass Info. between Effective 
    Max back  4 years from Effecitve date can be selected more then that give Validation message.
	2018-2019(Current date)
	 */

	//New One====================
	public static void dateRange_validation_lossClaim_New()throws IOException, InterruptedException, Exception, AWTException
	{
		GenericMethods.select_from_dropdown(WCnewUILocators.value_Incrementer_drpd, "visibletext","2");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		WCnewUILocators.DateOfLoss0.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, -1500, 0, 0, 0));
		//Assert.assertEquals(WCnewUILocators.rangeBetween_DateOfLoss0_new.getText(), "Date of Loss must be within last 4 years from Effective Date.");
		log.info("===================>Date range Validation Exists for Loss Info page<===================");
	}
	// This is Old one ======
	public static void dateRange_validation_lossClaim()throws IOException, InterruptedException, Exception, AWTException
	{
		GenericMethods.click_Element_Using_JS(WCnewUILocators.plus_Incrementer_btn);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		WCnewUILocators.DateOfLoss0.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, -400, 0, 0, 0));
		GenericMethods.press_key_using_robot("tab");
		if(WCnewUILocators.rangeBetween_DateOfLoss0.isDisplayed())
		{
			log.info("===================>Date range Validation Exists for Loss Info page<===================");
		}

	}
	/*
	 * Page 5 clasCode page
	 * 
	 */

	public static void classCode_fill(int row_num,String classCode)throws IOException, InterruptedException, Exception, AWTException
	{
		ExcelReader.set_excel_file(Locations.WC_UI_TestData,"classCode");

		//GenericMethods.select_from_dropdown(WCnewUILocators.location0_drpd,"visibletext", ExcelReader.get_row_data_from_col("Location0", row_num));
		GenericMethods.click_Element(WCnewUILocators.location0_drpd);

		WaitMethods.wait_for_elements_present(WCnewUILocators.location0_List);
		GenericMethods.bootstrap_dropdown(WCnewUILocators.location0_List," ");

		/*GenericMethods.press_key_using_robot("downArrow");
		GenericMethods.press_key_using_robot("enter");*/

		if(classCode.equalsIgnoreCase("double"))
		{
			WCnewUILocators.classCode0_txtSearch.sendKeys(ExcelReader.get_row_data_from_col("Class0", row_num));WaitMethods.wait_in_seconds(2);
			WaitMethods.wait_for_elements_present(WCnewUILocators.classCode0_List);
			GenericMethods.bootstrap_dropdown(WCnewUILocators.classCode0_List, ExcelReader.get_row_data_from_col("Class Code0", row_num));

			/*	GenericMethods.press_key_using_robot("downArrow");
			GenericMethods.press_key_using_robot("enter");*/
			GenericMethods.enter_text(WCnewUILocators.payRoll0_txtb,ExcelReader.get_row_data_from_col("Annual Payroll0", row_num), "Annual Payroll0");			
			GenericMethods.enter_text(WCnewUILocators.fullTimeEmployee0_txtb,ExcelReader.get_row_data_from_col("FT0", row_num), "FT0");	
			GenericMethods.enter_text(WCnewUILocators.partTimeEmployee0_txtb,ExcelReader.get_row_data_from_col("PT0", row_num), "PT0");	

			GenericMethods.click_Element_Using_JS(WCnewUILocators.addClasscode_btn);

			GenericMethods.click_Element(WCnewUILocators.location1_drpd);
			WaitMethods.wait_for_elements_present(WCnewUILocators.location1_List);
			GenericMethods.bootstrap_dropdown(WCnewUILocators.location1_List," ");


			/*GenericMethods.press_key_using_robot("downArrow");
			GenericMethods.press_key_using_robot("downArrow");
			GenericMethods.press_key_using_robot("enter");*/

			WCnewUILocators.classCode1_txtSearch.sendKeys(ExcelReader.get_row_data_from_col("Class1", row_num));WaitMethods.wait_in_seconds(2);
			WaitMethods.wait_for_elements_present(WCnewUILocators.classCode1_List);
			GenericMethods.bootstrap_dropdown(WCnewUILocators.classCode1_List, ExcelReader.get_row_data_from_col("Class Code1", row_num));
			//GenericMethods.press_key_using_robot("downArrow");
			//GenericMethods.press_key_using_robot("enter");

			GenericMethods.enter_text(WCnewUILocators.payRoll1_txtb,ExcelReader.get_row_data_from_col("Annual Payroll1", row_num), "Annual Payroll0");			
			GenericMethods.enter_text(WCnewUILocators.fullTimeEmployee1_txtb,ExcelReader.get_row_data_from_col("FT1", row_num), "FT0");		
			GenericMethods.enter_text(WCnewUILocators.partTimeEmployee1_txtb,ExcelReader.get_row_data_from_col("PT1", row_num), "PT0");	
			WaitMethods.wait_in_seconds(2);


		}
		else if(classCode.equalsIgnoreCase("single"))
		{	
			WCnewUILocators.classCode0_txtSearch.sendKeys(ExcelReader.get_row_data_from_col("Class0", row_num));WaitMethods.wait_in_seconds(2);
			WaitMethods.wait_for_elements_present(WCnewUILocators.classCode0_List);
			GenericMethods.bootstrap_dropdown(WCnewUILocators.classCode0_List, ExcelReader.get_row_data_from_col("Class Code0", row_num));
			//GenericMethods.press_key_using_robot("downArrow");
			//GenericMethods.press_key_using_robot("enter");


			GenericMethods.enter_text(WCnewUILocators.payRoll0_txtb,ExcelReader.get_row_data_from_col("Annual Payroll0", row_num), "Annual Payroll0");		
			GenericMethods.enter_text(WCnewUILocators.fullTimeEmployee0_txtb,ExcelReader.get_row_data_from_col("FT0", row_num), "FT0");		
			GenericMethods.enter_text(WCnewUILocators.partTimeEmployee0_txtb,ExcelReader.get_row_data_from_col("PT0", row_num), "PT0");		
			WaitMethods.wait_in_seconds(1);

		}
		//WaitMethods.wait_for_elements_present(WCnewUILocators.classCode0_List);WaitMethods.wait_in_seconds(2);	
		//GenericMethods.bootstrap_dropdown(WCnewUILocators.classCode0_List, ExcelReader.get_row_data_from_col("Class Code0", row_num));

	}

	/*
	 * class code page 5 
	 * get List of address in Locations 
	 * verify that 
	 * 
	 */
	public static void locationListVerify(int row_num)throws IOException, InterruptedException, Exception, AWTException
	{
		ExcelReader.set_excel_file(Locations.WC_UI_TestData,"classCode");
		GenericMethods.click_Element(WCnewUILocators.location0_drpd);
		String listAdd=WCnewUILocators.location0_drpd.getText();
		Assert.assertEquals(listAdd,ExcelReader.get_row_data_from_col("LocationsList",row_num));
		log.info("=======================Address Occurs correctly===================");

		GenericMethods.click_Element(WCnewUILocators.businessInfo_switch_btn);

		//Business Address field
		GenericMethods.enter_text(WCnewUILocators.business_street_txtb,ExcelReader.get_row_data_from_col("BusinessStreet", row_num), "Business Street");
		WaitMethods.wait_in_seconds(2);

		WaitMethods.wait_for_elements_present(WCnewUILocators.businessAdd_List);
		GenericMethods.bootstrap_dropdown(WCnewUILocators.businessAdd_List, ExcelReader.get_row_data_from_col("BusinessStreet", row_num));


		/*GenericMethods.press_key_using_robot("downArrow");
		GenericMethods.click_enter_using_robot();*/
		GenericMethods.click_Element_Using_JS(WCnewUILocators.businessAndMailingAddressSame_chkBox);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.businessAndMailingAddressSame_chkBox);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.businessAndMailingAddressSame_chkBox);

		GenericMethods.click_Element(WCnewUILocators.add1_delete_btn);
		GenericMethods.click_Element(WCnewUILocators.add1_delete_btn);

		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);


		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		//GenericMethods.click_Element(WCnewUILocators.coverageHistory_switch_btn);
		WCnewUIMethods.coverageHistoryWithNOoption("empNo");
		WaitMethods.wait_in_seconds(2);

		GenericMethods.click_Element(WCnewUILocators.location0_drpd);
		String updatelistAdd=WCnewUILocators.location0_drpd.getText();
		Assert.assertEquals(updatelistAdd,ExcelReader.get_row_data_from_col("UpdateLocationsList",row_num));
		log.info("===============================Address Update correctly=================================");

	}

	/*
	 * Page 6 Owners and Officers page
	 * 
	 */

	public static void ownersAndOfficers(int row_num)throws IOException, InterruptedException, Exception, AWTException
	{
		ExcelReader.set_excel_file(Locations.WC_UI_TestData,"OwnersNofficers");

		GenericMethods.enter_text(WCnewUILocators.owner_name0_txtb,ExcelReader.get_row_data_from_col("Name1", row_num), "Name");		
		GenericMethods.select_from_dropdown(WCnewUILocators.relationship0_drpd, "visibletext", ExcelReader.get_row_data_from_col("Title/Relationship1", row_num));

		//GenericMethods.enter_text(WCnewUILocators.ownership0_txtb,"100", "Ownership1 %");WaitMethods.wait_in_seconds(2);

		GenericMethods.enter_text(WCnewUILocators.ownership0_txtb,ExcelReader.get_row_data_from_col("Ownership1", row_num), "Ownership1 %");WaitMethods.wait_in_seconds(2);
		GenericMethods.select_from_dropdown(WCnewUILocators.exclude0_drpd, "visibletext", ExcelReader.get_row_data_from_col("Excl./Incl1", row_num));

		GenericMethods.click_Element(WCnewUILocators.addOwner_btn);

		GenericMethods.enter_text(WCnewUILocators.owner_name1_txtb,ExcelReader.get_row_data_from_col("Name2", row_num), "Name");		
		GenericMethods.select_from_dropdown(WCnewUILocators.relationship1_drpd, "visibletext", ExcelReader.get_row_data_from_col("Title/Relationship2", row_num));
		GenericMethods.enter_text(WCnewUILocators.ownership1_txtb,ExcelReader.get_row_data_from_col("Ownership2", row_num), "Ownership2 %");
		GenericMethods.select_from_dropdown(WCnewUILocators.exclude1_drpd, "visibletext", ExcelReader.get_row_data_from_col("Excl./Incl2", row_num));

		GenericMethods.enter_text(WCnewUILocators.DescriptionofOperation_txtarea,ExcelReader.get_row_data_from_col("Description of Operation", row_num), "Description of Operation");
		
	}
	/*
	 * Page 6 Owners and Officers page
	 * Titale realtion Drop Down Values comes on the selected Option 
	 * from Business Info page- Entity option 
	 * these method will verify DropDown values
	 */

	public static void titleRelation()throws IOException, InterruptedException, Exception, AWTException
	{	
		for(int i=1;i<14; i++)
		{

			ExcelReader.set_excel_file(Locations.WC_UI_TestData,"BusinessInfo2");

			GenericMethods.click_Element_Using_JS(WCnewUILocators.businessInfo_switch_btn);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
			WaitMethods.wait_in_seconds(2);
			GenericMethods.select_from_dropdown(WCnewUILocators.entity_drpd, "visibletext", ExcelReader.get_row_data_from_col("Entity", i));
			WaitMethods.wait_in_seconds(2);

			GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
			WaitMethods.wait_in_seconds(2);

			GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
			WaitMethods.wait_in_seconds(2);

			GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
			WaitMethods.wait_in_seconds(2);

			//GenericMethods.click_Element_Using_JS(WCnewUILocators.ownerOff_switch_btn);
			GenericMethods.click_Element(WCnewUILocators.relationship0_drpd);
			WaitMethods.wait_in_seconds(2);
			String relationType=WCnewUILocators.relationship0_drpd.getText();
			Assert.assertEquals(relationType,ExcelReader.get_row_data_from_col("TitleRelationValue",i));
			WaitMethods.wait_in_seconds(2);
			log.info("==============The actual Title&Relation Values we get is :===========" +relationType);
			log.info("==================Title&Relation DD values get changed Successfully==============");
		}
	}

	/*
	 * Page 7 Credit Opportunity page
	 */
	public static void credit_Opp_Verify_AvaibalityOf_All_11_Questions()throws IOException, InterruptedException, Exception, AWTException
	{
		assertEquals(WCnewUILocators.q1.getText(), "Is the owner directly involved in day-to-day operations?");
		assertEquals(WCnewUILocators.q2.getText(), "Is the employee turnover under 10%?");
		assertEquals(WCnewUILocators.q3.getText(), "Are benefits provided for employees?");
		assertEquals(WCnewUILocators.q4.getText(), "Are drug testing of employees pre-employment?");
		assertEquals(WCnewUILocators.q5.getText(), "Does the owner have a minimum of 10 years experience in the industry of business?");
		assertEquals(WCnewUILocators.q6.getText(), "Are there formal accident investigation procedures in place?");
		assertEquals(WCnewUILocators.q7.getText(), "Is the supervisor to employee ratios low (1 sup / 12 or fewer employees)?");
		assertEquals(WCnewUILocators.q8.getText(), "Is there a return to work program in place?");
		assertEquals(WCnewUILocators.q9.getText(), "Is there a written safety program/policy?");
		assertEquals(WCnewUILocators.q10.getText(),"Is there a safety committee or designated safety manager?");
		assertEquals(WCnewUILocators.q11.getText(),"Are regular safety meetings held with employees?");	
		log.info("====================All Questions appear successfully for Credit Opportunity page=====================");	

		GenericMethods.click_Element_Using_JS(WCnewUILocators.quest1_No);WaitMethods.wait_in_seconds(1);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.quest2_No);WaitMethods.wait_in_seconds(1);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.quest3_No);WaitMethods.wait_in_seconds(1);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.quest4_No);WaitMethods.wait_in_seconds(1);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.quest5_No);WaitMethods.wait_in_seconds(1);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.quest6_No);WaitMethods.wait_in_seconds(1);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.quest7_No);WaitMethods.wait_in_seconds(1);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.quest8_No);WaitMethods.wait_in_seconds(1);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.quest9_No);WaitMethods.wait_in_seconds(1);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.quest10_No);WaitMethods.wait_in_seconds(1);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.quest11_No);WaitMethods.wait_in_seconds(1);

	}

	/*
	 * Page 8 Additional Info page
	 */
	public static void Additional_Info_Verify_AvaibalityOf_All_23_Questions(String answerQues)throws IOException, InterruptedException, Exception, AWTException
	{		
		WaitMethods.wait_in_seconds(2);

		if(answerQues.equalsIgnoreCase("QuesYes"))
		{
			assertEquals(WCnewUILocators.accord_0.getText(), "Does the Applicant own, operate or lease aircraft/watercraft?");
			assertEquals(WCnewUILocators.accord_1.getText(), "Do / have past, present or discontinued operations involve(d) storing, treating, discharging, applying, disposing, or transporting of hazardous material? (E.g., landfills, asbestos, wastes, fuel tanks, etc.)");
			assertEquals(WCnewUILocators.accord_2.getText(), "Any work performed underground or above 15 feet?");
			assertEquals(WCnewUILocators.accord_3.getText(), "Any work performed on barges, vessels, docks, bridge over water?");
			assertEquals(WCnewUILocators.accord_4.getText(), "Is the Applicant engaged in any other type of business?");
			assertEquals(WCnewUILocators.accord_5.getText(), "Are subcontractors used?");
			assertEquals(WCnewUILocators.accord_6.getText(), "Any work sublet without certificates of insurance? (If \"Yes\", payroll for this work must be included)");
			assertEquals(WCnewUILocators.accord_7.getText(), "Is a written safety program in operation?");
			assertEquals(WCnewUILocators.accord_8.getText(), "Any group transportation provided?");
			assertEquals(WCnewUILocators.accord_9.getText(), "Any employees under 16 or over 60 years of age?");
			assertEquals(WCnewUILocators.accord_10.getText(), "Any seasonal employees?");
			assertEquals(WCnewUILocators.accord_11.getText(), "Is there any volunteer or donated labor?");
			assertEquals(WCnewUILocators.accord_12.getText(), "Any employees with physical handicaps?");
			assertEquals(WCnewUILocators.accord_13.getText(), "Do employees travel out of state?");
			assertEquals(WCnewUILocators.accord_14.getText(), "Are athletic teams sponsored?");
			assertEquals(WCnewUILocators.accord_15.getText(), "Are physicals required after offers of employment are made?");
			assertEquals(WCnewUILocators.accord_16.getText(), "Any other insurance with this insurer?");
			assertEquals(WCnewUILocators.accord_17.getText(), "Any prior coverage declined/cancelled/non-renewed (last 3 yrs.)? (Not applicable for Missouri risks)");
			assertEquals(WCnewUILocators.accord_18.getText(), "Are employee health plans provided?");
			assertEquals(WCnewUILocators.accord_19.getText(), "Do any employees perform work for other businesses or subsidiaries?");
			assertEquals(WCnewUILocators.accord_20.getText(), "Does the Applicant lease employees to or from other employers?");
			assertEquals(WCnewUILocators.accord_21.getText(), "Do any employees predominantly work at home?");
			assertEquals(WCnewUILocators.accord_22.getText(), "Any tax liens or bankruptcy within the last 5 years?");
			assertEquals(WCnewUILocators.accord_23.getText(), "Any undisputed and unpaid workers compensation premium due from you or any company managed or owned enterprises?");

			log.info("====================All Questions appear successfully for Additional Info page=====================");	

			GenericMethods.click_Element_Using_JS(WCnewUILocators.accord_0_Yes);WaitMethods.wait_in_seconds(1);
			GenericMethods.enter_text(WCnewUILocators.accord_0_textArea, "Replacing the actual content with placeholder text allows", "accord_0_textArea");

			GenericMethods.click_Element_Using_JS(WCnewUILocators.accord_1_Yes);WaitMethods.wait_in_seconds(1);
			GenericMethods.enter_text(WCnewUILocators.accord_1_textArea, "Replacing the actual content with placeholder text allows", "accord_1_textArea");

			GenericMethods.click_Element_Using_JS(WCnewUILocators.accord_5_Yes);WaitMethods.wait_in_seconds(1);
			GenericMethods.enter_text(WCnewUILocators.accord_5_textArea, "Replacing the actual content with placeholder text allows", "accord_5_textArea");

			GenericMethods.click_Element_Using_JS(WCnewUILocators.accord_8_Yes);WaitMethods.wait_in_seconds(1);
			GenericMethods.enter_text(WCnewUILocators.accord_8_textArea, "Replacing the actual content with placeholder text allows", "accord_8_textArea");

			GenericMethods.click_Element_Using_JS(WCnewUILocators.accord_10_Yes);WaitMethods.wait_in_seconds(1);
			GenericMethods.enter_text(WCnewUILocators.accord_10_textArea, "Replacing the actual content with placeholder text allows", "accord_10_textArea");

			GenericMethods.click_Element_Using_JS(WCnewUILocators.accord_16_Yes);WaitMethods.wait_in_seconds(1);
			GenericMethods.enter_text(WCnewUILocators.accord_16_textArea, "Replacing the actual content with placeholder text allows", "accord_16_textArea");

			GenericMethods.click_Element_Using_JS(WCnewUILocators.accord_0_No);WaitMethods.wait_in_seconds(1);

			WaitMethods.wait_in_seconds(2);
		}
		else if(answerQues.equalsIgnoreCase("QuesNo"))
		{
			assertEquals(WCnewUILocators.accord_0.getText(), "Does the Applicant own, operate or lease aircraft/watercraft?");
			assertEquals(WCnewUILocators.accord_1.getText(), "Do / have past, present or discontinued operations involve(d) storing, treating, discharging, applying, disposing, or transporting of hazardous material? (E.g., landfills, asbestos, wastes, fuel tanks, etc.)");
			assertEquals(WCnewUILocators.accord_2.getText(), "Any work performed underground or above 15 feet?");
			assertEquals(WCnewUILocators.accord_3.getText(), "Any work performed on barges, vessels, docks, bridge over water?");
			assertEquals(WCnewUILocators.accord_4.getText(), "Is the Applicant engaged in any other type of business?");
			assertEquals(WCnewUILocators.accord_5.getText(), "Are subcontractors used?");
			assertEquals(WCnewUILocators.accord_6.getText(), "Any work sublet without certificates of insurance? (If \"Yes\", payroll for this work must be included)");
			assertEquals(WCnewUILocators.accord_7.getText(), "Is a written safety program in operation?");
			assertEquals(WCnewUILocators.accord_8.getText(), "Any group transportation provided?");
			assertEquals(WCnewUILocators.accord_9.getText(), "Any employees under 16 or over 60 years of age?");
			assertEquals(WCnewUILocators.accord_10.getText(), "Any seasonal employees?");
			assertEquals(WCnewUILocators.accord_11.getText(), "Is there any volunteer or donated labor?");
			assertEquals(WCnewUILocators.accord_12.getText(), "Any employees with physical handicaps?");
			assertEquals(WCnewUILocators.accord_13.getText(), "Do employees travel out of state?");
			assertEquals(WCnewUILocators.accord_14.getText(), "Are athletic teams sponsored?");
			assertEquals(WCnewUILocators.accord_15.getText(), "Are physicals required after offers of employment are made?");
			assertEquals(WCnewUILocators.accord_16.getText(), "Any other insurance with this insurer?");
			assertEquals(WCnewUILocators.accord_17.getText(), "Any prior coverage declined/cancelled/non-renewed (last 3 yrs.)? (Not applicable for Missouri risks)");
			assertEquals(WCnewUILocators.accord_18.getText(), "Are employee health plans provided?");
			assertEquals(WCnewUILocators.accord_19.getText(), "Do any employees perform work for other businesses or subsidiaries?");
			assertEquals(WCnewUILocators.accord_20.getText(), "Does the Applicant lease employees to or from other employers?");
			assertEquals(WCnewUILocators.accord_21.getText(), "Do any employees predominantly work at home?");
			assertEquals(WCnewUILocators.accord_22.getText(), "Any tax liens or bankruptcy within the last 5 years?");
			assertEquals(WCnewUILocators.accord_23.getText(), "Any undisputed and unpaid workers compensation premium due from you or any company managed or owned enterprises?");

			log.info("====================All Questions appear successfully for Additional Info page=====================");

		}
	}

	/*
	 * Page 9 Additional Info page
	 */
	public static void carrierSelect_Submit_UW_verify()throws IOException, InterruptedException, Exception, AWTException
	{
		GenericMethods.click_Element_Using_JS(WCnewUILocators.EMPLOYERS_btn);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.submitUW);
		if(WCnewUILocators.carreierPage_text.isDisplayed())
		{
			log.info("=================== Submit to underwriting no carriers can be selected. - PASS ==============");
		}
		GenericMethods.click_Element_Using_JS(WCnewUILocators.EMPLOYERS_btn);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.submitUW);
	}

	//Method is to Select Carrier Option
	public static void CarrierOption(String CarrierOpt)throws IOException, InterruptedException, Exception, AWTException
	{
		if(CarrierOpt.equalsIgnoreCase("Amtrust&Employer"))
		{
			WaitMethods.wait_in_seconds(2);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.EMPLOYERS_btn);
			WaitMethods.wait_in_seconds(1);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.AMTRUSTWC_btn);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
			WaitMethods.wait_in_seconds(10);
		}
		else if(CarrierOpt.equalsIgnoreCase("Employer"))
		{
			WaitMethods.wait_in_seconds(2);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.EMPLOYERS_btn);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
			WaitMethods.wait_in_seconds(10);
		}
		else if(CarrierOpt.equalsIgnoreCase("Amtrust"))
		{
			WaitMethods.wait_in_seconds(2);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.AMTRUSTWC_btn);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
			WaitMethods.wait_in_seconds(10);
		}
		else if(CarrierOpt.equalsIgnoreCase("Pie"))
		{
			WaitMethods.wait_in_seconds(2);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.pie_btn);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
			WaitMethods.wait_in_seconds(10);
		}
		else if(CarrierOpt.equalsIgnoreCase("Other"))
		{
			WaitMethods.wait_in_seconds(2);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.other_btn);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
			WaitMethods.wait_in_seconds(10);
		}
		else if(CarrierOpt.equalsIgnoreCase("All3CarrierOption"))
		{
			WaitMethods.wait_in_seconds(5);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.EMPLOYERS_btn);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.AMTRUSTWC_btn);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.other_btn);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
			WaitMethods.wait_in_seconds(10);
		}
	}
	//Method is to verify  Thank you page	
	public static void verify_ThankuPage()throws IOException, InterruptedException, Exception, AWTException
	{	
		WaitMethods.wait_for_element_present(WCnewUILocators.thankYou_page_txt);
		assertEquals(WCnewUILocators.thankYou_page_txt.getText(),"Thank you for your business!");
		log.info("=================Reffered condition 'Thank You page' appear - PASS ==============");

		WaitMethods.wait_for_element_present(WCnewUILocators.close_btn1);
		GenericMethods.click_Element(WCnewUILocators.close_btn1);
	}

	//Method is to select Carrier.
	public static void selectCarrier(String carrierName)throws IOException, InterruptedException, Exception, AWTException
	{
		if(carrierName.equalsIgnoreCase("AMtrust"))
		{
			WaitMethods.wait_for_element_present(WCnewUILocators.priceIndiacationPage_Heading);
			String carrier1Value= WCnewUILocators.annualPremiumAMTRUSTWC.getText();
			log.info(carrier1Value);
			String Limit1Value= WCnewUILocators.annualLimitAMTRUSTWC.getText();
			log.info(Limit1Value);
			if(WCnewUILocators.annualPremiumAMTRUSTWC.getText().contains("$"))
			{	
				WaitMethods.wait_in_seconds(2);	
				GenericMethods.click_Element_Using_JS(WCnewUILocators.proceedWith_AMTRUSTWC);
			}
			else if(WCnewUILocators.annualPremiumAMTRUSTWC.getText().contains("Unavailable at this time"))
			{	
				WaitMethods.wait_in_seconds(2);	
				GenericMethods.click_Element_Using_JS(WCnewUILocators.submitUW);
			}
			WaitMethods.wait_in_seconds(2);		
		}
		else if(carrierName.equalsIgnoreCase("Employer"))
		{
			WaitMethods.wait_for_element_present(WCnewUILocators.priceIndiacationPage_Heading);
			String carrier1Value= WCnewUILocators.annualPremiumEMPLOYERS.getText();
			log.info(carrier1Value);
			String Limit1Value= WCnewUILocators.annualLimitEMPLOYERS.getText();
			log.info(Limit1Value);
			if(WCnewUILocators.annualPremiumEMPLOYERS.getText().contains("$"))
			{	
				WaitMethods.wait_in_seconds(2);	
				GenericMethods.click_Element_Using_JS(WCnewUILocators.proceedWith_EMPLOYERS);
			}
			else if(WCnewUILocators.annualPremiumEMPLOYERS.getText().contains("Unavailable at this time"))
			{	
				WaitMethods.wait_in_seconds(2);	
				GenericMethods.click_Element_Using_JS(WCnewUILocators.submitUW);
			}
			WaitMethods.wait_in_seconds(2);
		}
		
		else if(carrierName.equalsIgnoreCase("Pie"))
		{
			WaitMethods.wait_for_element_present(WCnewUILocators.priceIndiacationPage_Heading);
			String carrier1Value= WCnewUILocators.annualPremiumPIE.getText();
			log.info(carrier1Value);
			String Limit1Value= WCnewUILocators.annualLimitPIE.getText();
			log.info(Limit1Value);
			if(WCnewUILocators.annualPremiumPIE.getText().contains("$"))
			{	
				WaitMethods.wait_in_seconds(2);	
				GenericMethods.click_Element_Using_JS(WCnewUILocators.submitUW0);
			}
			else if(WCnewUILocators.annualPremiumPIE.getText().contains("Unavailable at this time"))
			{	
				WaitMethods.wait_in_seconds(2);	
				GenericMethods.click_Element_Using_JS(WCnewUILocators.submitUW);
			}
			WaitMethods.wait_in_seconds(2);
		}
		
		else if(carrierName.equalsIgnoreCase("Others"))
		{		
			WaitMethods.wait_for_element_present(WCnewUILocators.priceIndiacationPage_Heading);
			if(WCnewUILocators.annualPremiumOTHERS.getText().contains("-"))
			{	
				WaitMethods.wait_in_seconds(2);	
				GenericMethods.click_Element(WCnewUILocators.submitUW);
			}	
		}
		else if(carrierName.equalsIgnoreCase("AllCarrier"))
		{		
			WaitMethods.wait_in_seconds(2);	
			WaitMethods.wait_for_element_present(WCnewUILocators.priceIndiacationPage_Heading);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.carrierEMPLOYERS);
			GenericMethods.click_Element_Using_JS(WCnewUILocators.carrierAMTRUSTWC);
			WaitMethods.wait_in_seconds(1);
			GenericMethods.click_Element(WCnewUILocators.carrierOthers);
			GenericMethods.click_Element(WCnewUILocators.submitUW);
		}
		else if(carrierName.equalsIgnoreCase("AM_Emp_unavail_Other"))
		{	
			WaitMethods.wait_in_seconds(5);
			if(WCnewUILocators.annualPremiumAMTRUSTWC.getText().equals("Unavailable at this time") & WCnewUILocators.annualPremiumEMPLOYERS.getText().equals("Unavailable at this time"))
			{	
				if(WCnewUILocators.annualPremiumOTHERS.getText().equals("-"))
				{
					WaitMethods.wait_in_seconds(2);	
					GenericMethods.click_Element(WCnewUILocators.submitUW);
					log.info("================Both Carriers Unavailable so reffered - PASS================");
				}	
			}
			else if(WCnewUILocators.annualPremiumAMTRUSTWC.getText().contains("$") & WCnewUILocators.annualPremiumEMPLOYERS.getText().contains("$"))
			{	
				WaitMethods.wait_in_seconds(2);	
				GenericMethods.click_Element(WCnewUILocators.submitUW2);
			}
			else if(WCnewUILocators.annualPremiumAMTRUSTWC.getText().equals("Unavailable at this time")  & WCnewUILocators.annualPremiumEMPLOYERS.getText().contains("$"))
			{	
				WaitMethods.wait_in_seconds(2);	
				GenericMethods.click_Element(WCnewUILocators.submitUW2);
			}
			else if(WCnewUILocators.annualPremiumAMTRUSTWC.getText().contains("$") & WCnewUILocators.annualPremiumEMPLOYERS.getText().equals("Unavailable at this time"))
			{	
				WaitMethods.wait_in_seconds(2);	
				GenericMethods.click_Element(WCnewUILocators.submitUW2);
			}

		}

		else if(carrierName.equalsIgnoreCase("EmployersOnly"))
		{
			WaitMethods.wait_for_element_present(WCnewUILocators.priceIndiacationPage_Heading);
			String carrier1Value= WCnewUILocators.annualPremiumEMPLOYERS1.getText();
			log.info(carrier1Value);
			String Limit1Value= WCnewUILocators.annualLimitEMPLOYERS1.getText();
			log.info(Limit1Value);
			if(WCnewUILocators.annualPremiumEMPLOYERS1.getText().contains("$"))
			{	
				WaitMethods.wait_in_seconds(2);	
				GenericMethods.click_Element_Using_JS(WCnewUILocators.proceedWith_EMPLOYERS);
			}
			else if(WCnewUILocators.annualPremiumEMPLOYERS1.getText().contains("Unavailable at this time"))
			{	
				WaitMethods.wait_in_seconds(2);	
				GenericMethods.click_Element_Using_JS(WCnewUILocators.submitUW);
			}
			WaitMethods.wait_in_seconds(2);
		}

	}

	//Select Sub class code & Proceed 
	public static void  Sub_ClassCode(String subClassCount)throws IOException, InterruptedException, Exception, AWTException
	{	
		if(subClassCount.equalsIgnoreCase("Single"))
		{
			GenericMethods.click_Element(WCnewUILocators.subClasscode1);

			WaitMethods.wait_for_elements_present(WCnewUILocators.subClasscode1_List);
			GenericMethods.bootstrap_dropdown(WCnewUILocators.subClasscode1_List," ");

			/*GenericMethods.press_key_using_robot("downArrow");
			GenericMethods.press_key_using_robot("enter");*/
			WaitMethods.wait_in_seconds(1);
			GenericMethods.click_Element(WCnewUILocators.next_btn);
		}
		else if(subClassCount.equalsIgnoreCase("Double"))
		{	
			GenericMethods.click_Element(WCnewUILocators.subClasscode1);
			WaitMethods.wait_for_elements_present(WCnewUILocators.subClasscode1_List);
			GenericMethods.bootstrap_dropdown(WCnewUILocators.subClasscode1_List," ");


			/*GenericMethods.press_key_using_robot("downArrow");
			GenericMethods.press_key_using_robot("enter");*/
			WaitMethods.wait_in_seconds(1);

			GenericMethods.click_Element(WCnewUILocators.subClasscode2);
			WaitMethods.wait_for_elements_present(WCnewUILocators.subClasscode2_List);
			GenericMethods.bootstrap_dropdown(WCnewUILocators.subClasscode2_List," ");


			/*GenericMethods.press_key_using_robot("downArrow");
			GenericMethods.press_key_using_robot("enter");*/
			WaitMethods.wait_in_seconds(1);
			GenericMethods.click_Element(WCnewUILocators.next_btn);
		}
	}

	//This method is to verify there Caerrier Specfic Questions.

	public static void Carrier_specific_Question_Verify(String CarrierQuestions)throws IOException, InterruptedException, Exception, AWTException
	{
		if(CarrierQuestions.equalsIgnoreCase("employerQuetions"))
		{
			WaitMethods.wait_in_seconds(2);
			assertEquals(WCnewUILocators.carrierQ1.getText(),"Does the Applicant engage sub-contractors or independent contractors?");
			assertEquals(WCnewUILocators.carrierQ2.getText(),"Does the Applicant use motor vehicles for business purposes?"); 
			assertEquals(WCnewUILocators.carrierQ3.getText(),"Does the Applicant provide group transportation, where five or more employees are in a vehicle at one time?"); 
			assertEquals(WCnewUILocators.carrierQ4.getText(),"Any prior coverage declined/cancelled/non-renewed in the last three (3) years?");
			assertEquals(WCnewUILocators.carrierQ5.getText(),"Are employee health plans provided?"); 
			assertEquals(WCnewUILocators.carrierQ6.getText(),"Do you lease employees to or from other employers?"); 
			assertEquals(WCnewUILocators.carrierQ7.getText(),"Does Applicant own, operate or lease aircraft/watercraft?"); 


			/*assertEquals(WCnewUILocators.carrierQ8.getText(),"Applicant provides emergency roadside assistance, mobile auto repair, or city, county, or municipality towing-for-hire services."); 
			assertEquals(WCnewUILocators.carrierQ9.getText(),"Applicant performs repair on motorcycle, bus, recreational vehicle, commercial truck, industrial truck, and trailers or performs testing on watercraft or jet skiing.");
			assertEquals(WCnewUILocators.carrierQ10.getText(),"Applicant has cover charges, bouncers, crowd control, or armed security guards.");
			assertEquals(WCnewUILocators.carrierQ11.getText(),"Two or more employees are on duty at all times.");
			assertEquals(WCnewUILocators.carrierQ12.getText(),"Business is open after 2:00 a.m.");
			assertEquals(WCnewUILocators.carrierQ13.getText(),"Applicant delivers to customers, provides off-premises catering or operates mobile catering services."); 
			assertEquals(WCnewUILocators.carrierQ14.getText(),"Applicant has a minimum of eight gasoline nozzles at each location.");
			assertEquals(WCnewUILocators.carrierQ15.getText(),"Applicant provides photography work for television, newspapers, magazines, or media outlets (including paparazzi); conducts photography for underwater, aerial, extreme sports, or adult entertainment; or works with animals or at heights over 8 feet."); */

			log.info("====================All Questions appear successfully for Employeer Carrier=====================");	
			GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		}
		else if(CarrierQuestions.equalsIgnoreCase("AMTrutQuetions"))
		{
			WaitMethods.wait_in_seconds(2);
			assertEquals(WCnewUILocators.carrierAMQ1.getText(),"Does business have more than 50 people working at one location at a time?");
			assertEquals(WCnewUILocators.carrierAMQ2.getText(),"Does business currently have workers compensation coverage in effect?");
			assertEquals(WCnewUILocators.carrierAMQ3.getText(),"In the past 2 years has business had 2 or more Workers Compensation claims, a single Workers Compensation claim over 20K, or any employee who suffered a work related injury requiring more than 2 days off of work?");
			assertEquals(WCnewUILocators.carrierAMQ4.getText(),"Does the business employ or contract any type of armed/non- armed security guards?");
			log.info("====================All Questions appear successfully for AM Trust Carrier=====================");
			GenericMethods.click_Element(WCnewUILocators.next_btn);

		}

	}
	//Employers Payment plan page Options Verify that.
	/*
	 * In Payment plan page for Employers only.
	 * 1    100% Down   :    0
	 * 2    30% Down + 3 Equal Installments : 1000
	 * 3    10% Down + 9 Equal Installments : 2500
	 * 4    0% Down + Pay-As-You-Go : 2500
	 */
	/*
	 * 0-1000  ==> 100% Down 
	 * 1001-2500 ==>100% Down & 30% Down + 3 Equal Installments
	 * 2501 < ====>100% Down & 30% Down  3 Equal Installments & 10% Down + 9 Equal Installments & 0% Down + Pay-As-You-Go
	 */
	public static void employerCarrierPaymentPlan(String condition)throws IOException, InterruptedException, Exception, AWTException
	{		
		if(condition.equalsIgnoreCase("Happy"))
		{
			GenericMethods.click_Element(WCnewUILocators.paymentPlan);
			GenericMethods.select_from_dropdown(WCnewUILocators.paymentPlan, "visibletext", "100% Down");
			WaitMethods.wait_in_seconds(5);
		}
		else if(condition.equalsIgnoreCase("condition"))
		{
			GenericMethods.click_Element(WCnewUILocators.paymentPlan);
			String Options =WCnewUILocators.paymentPlan.getText();
			String Optionssss=Options.replaceAll("\\s+","");
			Assert.assertEquals(Optionssss, "SelectaPaymentPlan100%Down30%Down+3EqualInstallments10%Down+9EqualInstallments0%Down+Pay-As-You-Go");
			log.info("==============2501 < ====> All 4 Options Appear=================================");

			GenericMethods.click_Element(WCnewUILocators.classCodes_switch_btn);
			WaitMethods.wait_in_seconds(2);

			WCnewUILocators.payRoll0_txtb.clear();
			GenericMethods.enter_text(WCnewUILocators.payRoll0_txtb,"99999", "Annual Payroll0");			

			GenericMethods.click_Element(WCnewUILocators.next_btn);WaitMethods.wait_in_seconds(2);
			GenericMethods.click_Element(WCnewUILocators.next_btn);WaitMethods.wait_in_seconds(2);
			GenericMethods.click_Element(WCnewUILocators.next_btn);WaitMethods.wait_in_seconds(2);
			GenericMethods.click_Element(WCnewUILocators.next_btn);WaitMethods.wait_in_seconds(2);
			GenericMethods.click_Element(WCnewUILocators.next_btn);WaitMethods.wait_in_seconds(2);
			WaitMethods.wait_in_seconds(20);

			WCnewUIMethods.selectCarrier("Employer");
			WaitMethods.wait_in_seconds(2);

			GenericMethods.click_Element(WCnewUILocators.next_btn);WaitMethods.wait_in_seconds(2);
			GenericMethods.click_Element(WCnewUILocators.next_btn);WaitMethods.wait_in_seconds(2);

			GenericMethods.click_Element(WCnewUILocators.paymentPlan);WaitMethods.wait_in_seconds(2);
			String Options2 =WCnewUILocators.paymentPlan.getText();
			String Optionssss2=Options2.replaceAll("\\s+","");
			Assert.assertEquals(Optionssss2, "SelectaPaymentPlan100%Down");
			log.info("===================0-1000  ==> 100% Down Appaer============================");
			GenericMethods.click_Element(WCnewUILocators.classCodes_switch_btn);
			WaitMethods.wait_in_seconds(2);

			WCnewUILocators.payRoll0_txtb.clear();
			GenericMethods.enter_text(WCnewUILocators.payRoll0_txtb,"458960", "Annual Payroll0");

			GenericMethods.click_Element(WCnewUILocators.next_btn);WaitMethods.wait_in_seconds(2);
			GenericMethods.click_Element(WCnewUILocators.next_btn);WaitMethods.wait_in_seconds(2);
			GenericMethods.click_Element(WCnewUILocators.next_btn);WaitMethods.wait_in_seconds(2);
			GenericMethods.click_Element(WCnewUILocators.next_btn);WaitMethods.wait_in_seconds(2);
			GenericMethods.click_Element(WCnewUILocators.next_btn);WaitMethods.wait_in_seconds(2);
			WaitMethods.wait_in_seconds(20);

			WCnewUIMethods.selectCarrier("Employer");
			WaitMethods.wait_in_seconds(2);

			GenericMethods.click_Element(WCnewUILocators.next_btn);WaitMethods.wait_in_seconds(2);
			GenericMethods.click_Element(WCnewUILocators.next_btn);WaitMethods.wait_in_seconds(2);

			GenericMethods.click_Element(WCnewUILocators.paymentPlan);WaitMethods.wait_in_seconds(2);
			String Options3 =WCnewUILocators.paymentPlan.getText();
			String Optionssss3=Options3.replaceAll("\\s+","");
			Assert.assertEquals(Optionssss3, "SelectaPaymentPlan100%Down30%Down+3EqualInstallments");
			log.info("===================1001-2500 ==> 2 Options Appear Successfully============================");
		}

	}

	//AMtrust Payment plan page Options Verify that.

	/* AVAILABLE PAYEMENT OPTIONS
	 * Standard Payment in Full 
	 * Standard Payment 50% Down + 1 installment 
	 * Standard Payment 25% Down + 3 Monthly installments 
	 * Standard Payment 10 Monthly installments 
	 * PAYO 
	 * Direct Debit Payment in Full 
	 * Direct Debit 50% Down + 1 installment 
	 * Direct Debit Payment 25% Down + 3 Monthly installments 
	 * Direct Debit Payment 10 Monthly installments 
	 * Direct Debit Payment 12 Monthly Installments  
	 */

	/*
	 * iF yOU SELECT ====Payo===========
	 * as option - another Dropdown will be appaer. 
	 * 
	 */

	public static void amTrustCarrierPaymentPlan(String condition)throws IOException, InterruptedException, Exception, AWTException
	{		
		if(condition.equalsIgnoreCase("Happy"))
		{
			GenericMethods.click_Element(WCnewUILocators.paymentPlan);
			GenericMethods.select_from_dropdown(WCnewUILocators.paymentPlan, "Visibletext", "Standard Payment in Full");
			WaitMethods.wait_in_seconds(2);
			WaitMethods.wait_in_seconds(10);
		}
		else if(condition.equalsIgnoreCase("condition"))
		{
			GenericMethods.click_Element(WCnewUILocators.paymentPlan);
			//GenericMethods.press_key_using_robot("tab");
			String Options =WCnewUILocators.paymentPlan.getText();
			String Optionssss=Options.replaceAll("\\s+","");
			Assert.assertEquals(Optionssss, "PleaseselectpaymentplanStandardPaymentinFullStandardPayment50%Down+1installmentStandardPayment25%Down+3MonthlyinstallmentsStandardPayment10MonthlyinstallmentsPAYODirectDebitPaymentinFullDirectDebit50%Down+1installmentDirectDebitPayment25%Down+3MonthlyinstallmentsDirectDebitPayment10MonthlyinstallmentsDirectDebitPayment12MonthlyInstallments");
			log.info("==================> All Payment Options Appear -PASS=================================");
			WaitMethods.wait_in_seconds(2);



			/*GenericMethods.click_Element(WCnewUILocators.classCodes_switch_btn);
			WaitMethods.wait_in_seconds(2);

			WCnewUILocators.payRoll0_txtb.clear();
			GenericMethods.enter_text(WCnewUILocators.payRoll0_txtb,"99999", "Annual Payroll0");			

			GenericMethods.click_Element(WCnewUILocators.next_btn);WaitMethods.wait_in_seconds(2);
			GenericMethods.click_Element(WCnewUILocators.next_btn);WaitMethods.wait_in_seconds(2);
			GenericMethods.click_Element(WCnewUILocators.next_btn);WaitMethods.wait_in_seconds(2);
			GenericMethods.click_Element(WCnewUILocators.next_btn);WaitMethods.wait_in_seconds(2);
			WaitMethods.wait_in_seconds(10);

			WCnewUIMethods.selectCarrier("AMtrust");
			WaitMethods.wait_in_seconds(2);

			GenericMethods.click_Element(WCnewUILocators.next_btn);WaitMethods.wait_in_seconds(2);
			GenericMethods.click_Element(WCnewUILocators.next_btn);WaitMethods.wait_in_seconds(2);


			GenericMethods.click_Element(WCnewUILocators.paymentPlan);WaitMethods.wait_in_seconds(2);
			String Options2 =WCnewUILocators.paymentPlan.getText();
			String Optionssss2=Options2.replaceAll("\\s+","");
			Assert.assertEquals(Optionssss2, "PleaseselectpaymentplanStandardPaymentinFullStandardPayment50%Down+1installmentStandardPayment25%Down+3MonthlyinstallmentsStandardPayment10MonthlyinstallmentsPAYODirectDebitPaymentinFullDirectDebit50%Down+1installmentDirectDebitPayment25%Down+3MonthlyinstallmentsDirectDebitPayment10MonthlyinstallmentsDirectDebitPayment12MonthlyInstallments");
			log.info("==================> All Payment Options Appear=================================");
			GenericMethods.click_Element(WCnewUILocators.classCodes_switch_btn);
			WaitMethods.wait_in_seconds(2);

			WCnewUILocators.payRoll0_txtb.clear();
			GenericMethods.enter_text(WCnewUILocators.payRoll0_txtb,"458960", "Annual Payroll0");

			GenericMethods.click_Element(WCnewUILocators.next_btn);WaitMethods.wait_in_seconds(2);
			GenericMethods.click_Element(WCnewUILocators.next_btn);WaitMethods.wait_in_seconds(2);
			GenericMethods.click_Element(WCnewUILocators.next_btn);WaitMethods.wait_in_seconds(2);
			GenericMethods.click_Element(WCnewUILocators.next_btn);WaitMethods.wait_in_seconds(2);
			WaitMethods.wait_in_seconds(10);

			WCnewUIMethods.selectCarrier("AMtrust");
			WaitMethods.wait_in_seconds(2);

			GenericMethods.click_Element(WCnewUILocators.next_btn);WaitMethods.wait_in_seconds(2);
			GenericMethods.click_Element(WCnewUILocators.next_btn);WaitMethods.wait_in_seconds(2);

			GenericMethods.click_Element(WCnewUILocators.paymentPlan);WaitMethods.wait_in_seconds(2);
			String Options3 =WCnewUILocators.paymentPlan.getText();
			String Optionssss3=Options3.replaceAll("\\s+","");
			Assert.assertEquals(Optionssss3, "PleaseselectpaymentplanStandardPaymentinFullStandardPayment50%Down+1installmentStandardPayment25%Down+3MonthlyinstallmentsStandardPayment10MonthlyinstallmentsPAYODirectDebitPaymentinFullDirectDebit50%Down+1installmentDirectDebitPayment25%Down+3MonthlyinstallmentsDirectDebitPayment10MonthlyinstallmentsDirectDebitPayment12MonthlyInstallments");
			log.info("==================> All Payment Options Appear=================================");*/

			//slect PAYO as payment option


			GenericMethods.select_from_dropdown(WCnewUILocators.paymentPlan, "visibletext", "PAYO ");
			//GenericMethods.press_key_using_robot("tab");
			GenericMethods.click_Element(WCnewUILocators.payrollCompany);
			//GenericMethods.press_key_using_robot("tab");
			String payrolLCmpOptions=WCnewUILocators.payrollCompany.getText();
			String OptionsCmp=payrolLCmpOptions.replaceAll("\\s+","");
			Assert.assertEquals(OptionsCmp, "PleaseselectpayrollcompanyReliablePremiumManagementPayrollOfficeofAmericaHeartlandPayrollSolutionsPaylocityTerm-UseHeartlandID#73PayrollDataProcessingSmartPaySolutionsLLCPayrollCentricfkaNetPayServicesIncApexPayrollSBSPayroll,Inc.PayrollLink,IncRapidDataIncPinkPayrollBusinessPayrollServices,IncPayrollPlusCABLIPayrollSolutions,Inc.L&GPayrollCenterAIUPayroll,IncTJHPayrollAmcheckPayrollNVHRXPayrollPinnaclePayrollSolutionsMeridianPayrollGroupMiseenPlaceRestaurantServices,Inc.APlusTaxReturnXccelerateHR,LLCPLSCPAAPC");
			log.info("==================> All Pay roll company Options Appear -PASS=================================");
			WaitMethods.wait_in_seconds(2);

			GenericMethods.select_from_dropdown(WCnewUILocators.payrollCompany, "visibletext", "SmartPay Solutions LLC");
			WaitMethods.wait_in_seconds(2);

			GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
			WaitMethods.wait_in_seconds(2);

		}
	}


	//Payment BreakDown Page OPERATIONS
	public static void paymentBreakDown_page(String BrokerFee)throws IOException, InterruptedException, Exception, AWTException
	{	
		WaitMethods.wait_for_element_present(WCnewUILocators.paymentBreakDown_pageHeading);
		//===============================================================
		if(BrokerFee.equalsIgnoreCase("BrokerFee_YES")) 
		{	
			//Assert.assertEquals(WCnewUILocators.wokerCom_premium_Fee.getText(),WCnewUILocators.annualPremiumEMPLOYERS.getText());
			WaitMethods.wait_for_element_present(WCnewUILocators.brokerFee_txtb);
			GenericMethods.enter_text(WCnewUILocators.brokerFee_txtb, "100", "Broker Fee : ");
			GenericMethods.click_Element(WCnewUILocators.saveBrokerFee_btn);
			WaitMethods.wait_in_seconds(5);	
			String s1=WCnewUILocators.btis_service_Fee.getText();
			log.info("======================>>>>>>>>>>>>>>>>"+s1+"<<<<<<<<<<<<<<<<<<<<<<<<<====================================");
			WaitMethods.wait_for_element_to_be_clickable(WCnewUILocators.bind_btn);

			WaitMethods.wait_in_seconds(4);	
			if(WCnewUILocators.btis_service_Fee.getText().equals("$0"))
			{		
				WaitMethods.wait_in_seconds(2);
				GenericMethods.click_Element_Using_JS(WCnewUILocators.bind_btn);
				WaitMethods.wait_in_seconds(2);
				GenericMethods.click_Element_Using_JS(WCnewUILocators.bind_YES_btn);WaitMethods.wait_in_seconds(10);

			}
			else if(WCnewUILocators.btis_service_Fee.getText().equals(s1))
			{		
				log.info("==========================Your in else if block====================");
				WaitMethods.wait_in_seconds(2);
				GenericMethods.click_Element_Using_JS(WCnewUILocators.bind_btn);WaitMethods.wait_in_seconds(5);
				GenericMethods.click_Element_Using_JS(WCnewUILocators.btnPayNowAndBind_btn);WaitMethods.wait_in_seconds(2);	
				GenericMethods.click_Element_Using_JS(WCnewUILocators.bind_YES_btn);WaitMethods.wait_in_seconds(10);

				WCnewUIMethods.paymentPopup();
				WaitMethods.wait_in_seconds(2);

				//To handle payment popup
				WCnewUIMethods.payEzee_WC(1);
				WaitMethods.wait_in_seconds(2);
			}
			/*else
			{	
				log.info("==========================Your in else block====================");
				WaitMethods.wait_in_seconds(2);
				GenericMethods.click_Element_Using_JS(WCnewUILocators.submitUW1);
				WCnewUIMethods.verify_ThankuPage();

			}*/
		}
		//=============================================================================================
		else if(BrokerFee.equalsIgnoreCase("BrokerFee_NO"))
		{
			//WaitMethods.wait_for_element_present(WCnewUILocators.paymentBreakDown_pageHeading);
			String s1=WCnewUILocators.btis_service_Fee.getText();
			log.info("======================>>>>>>>>>>>>>>>>"+s1+"<<<<<<<<<<<<<<<<<<<<<<<<<====================================");

			WaitMethods.wait_for_element_to_be_clickable(WCnewUILocators.bind_btn);
			if(WCnewUILocators.btis_service_Fee.getText().equals("$0"))
			{	
				WaitMethods.wait_in_seconds(2);
				GenericMethods.click_Element_Using_JS(WCnewUILocators.bind_btn);
				GenericMethods.click_Element(WCnewUILocators.bind_YES_btn);WaitMethods.wait_in_seconds(5);
			}
			else{
				WaitMethods.wait_in_seconds(2);
				GenericMethods.click_Element_Using_JS(WCnewUILocators.bind_btn);WaitMethods.wait_in_seconds(5);
				GenericMethods.click_Element(WCnewUILocators.btnPayNowAndBind_btn);
				GenericMethods.click_Element_Using_JS(WCnewUILocators.bind_YES_btn);WaitMethods.wait_in_seconds(2);

				WCnewUIMethods.paymentPopup();
				WaitMethods.wait_in_seconds(2);

				//To handle payment popup
				WCnewUIMethods.payEzee_WC(1);
				WaitMethods.wait_in_seconds(2);
			}
		}
		//=======================================================================
		else if(BrokerFee.equalsIgnoreCase("Bind_or_submitUW"))
		{	
			log.info("=====================your in Bind_or_submitUW method====================================");

			if(WCnewUILocators.submitUW1.isDisplayed())
			{	
				WaitMethods.wait_for_element_present(WCnewUILocators.submitUW1);
				GenericMethods.click_Element(WCnewUILocators.submitUW1);WaitMethods.wait_in_seconds(2);

				WCnewUIMethods.verify_ThankuPage();
				WaitMethods.wait_in_seconds(2);
			}
			else if(WCnewUILocators.bind_btn.isDisplayed())
			{		
				GenericMethods.enter_text(WCnewUILocators.brokerFee_txtb, "100", "Broker Fee : ");
				GenericMethods.click_Element(WCnewUILocators.saveBrokerFee_btn);
				WaitMethods.wait_in_seconds(5);	
				String s=WCnewUILocators.btis_service_Fee.getText();
				log.info("====================="+s+"<====================================");

				if(WCnewUILocators.btis_service_Fee.getText().equals("$0"))
				{		
					WaitMethods.wait_in_seconds(2);
					GenericMethods.click_Element_Using_JS(WCnewUILocators.bind_btn);
					WaitMethods.wait_in_seconds(2);
					GenericMethods.click_Element_Using_JS(WCnewUILocators.bind_YES_btn);WaitMethods.wait_in_seconds(5);

					WCnewUIMethods.ThankYou_page();
					WaitMethods.wait_in_seconds(5);
				}
				else
				{	
					WaitMethods.wait_in_seconds(2);
					GenericMethods.click_Element_Using_JS(WCnewUILocators.bind_btn);WaitMethods.wait_in_seconds(5);
					GenericMethods.click_Element_Using_JS(WCnewUILocators.btnPayNowAndBind_btn);WaitMethods.wait_in_seconds(2);	
					GenericMethods.click_Element_Using_JS(WCnewUILocators.bind_YES_btn);WaitMethods.wait_in_seconds(2);

					WCnewUIMethods.paymentPopup();
					WaitMethods.wait_in_seconds(2);

					//To handle payment popup
					WCnewUIMethods.payEzee_WC(1);
					WaitMethods.wait_in_seconds(2);

					WCnewUIMethods.ThankYou_page();
					WaitMethods.wait_in_seconds(5);

				}

			}			
		}

	}	

	// Thank you page
	public static void ThankYou_page()throws IOException, InterruptedException, Exception, AWTException
	{		
		WaitMethods.wait_for_element_present(WCnewUILocators.finalThankYou);
		String policyNo=WCnewUILocators.policyNo.getText();
		log.info("======="+"Policy Number"+"================"+policyNo+"=======================");

		String carrierName=WCnewUILocators.CarrierFinal_name.getText();
		log.info("==========="+"Thank you for binding with"+"============"+carrierName+"=======================");
		WaitMethods.wait_in_seconds(5);
		WaitMethods.wait_for_element_present(WCnewUILocators.close_btn);
		GenericMethods.click_Element(WCnewUILocators.close_btn);
	}

	// Thank you page
	public static void ThankYou_page_paymentRecPolicyPending()throws IOException, InterruptedException, Exception, AWTException
	{		
		WaitMethods.wait_for_element_present(WCnewUILocators.poaymentReceived_msg);

		String paymentReceived=WCnewUILocators.poaymentReceived_msg.getText();
		Assert.assertEquals("Thank you for choosing EMPLOYERS. We have received your payment. We are in process to get you a policy Please click the Close button below to be redirected back to our View Submissions page.", paymentReceived);
		log.info("==========="+"Thank you for choosing EMPLOYERS. We have received your payment. We are in process to get you a policy Please click the Close button below to be redirected back to our View Submissions page."+"============");
		WaitMethods.wait_in_seconds(5);
		WaitMethods.wait_for_element_present(WCnewUILocators.close_btn1);
		GenericMethods.click_Element(WCnewUILocators.close_btn1);
	}

	// Payment Popup page
	public static void paymentPopup()throws IOException, InterruptedException, Exception, AWTException
	{
		GenericMethods.click_Element(WCnewUILocators.CreditCard_btn);
		GenericMethods.click_Element(WCnewUILocators.payNow_btn);
		WaitMethods.wait_in_seconds(2);
		log.info("=========== Can't Proceed further Captcha Not able to Autonmate.=======================");
	}

	//===============PayEzee Payment gateway page==============================

	public static void payEzee_WC(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{
		GenericMethods.swith_to_frame_using_name("payment-form-iframe");

		WaitMethods.wait_in_seconds(5);
		ExcelReader.set_excel_file(Locations.WC_UI_TestData,"payGatewayPage");

		WaitMethods.wait_in_seconds(2);
		GenericMethods.enter_text(WCnewUILocators.x_card_num, ExcelReader.get_row_data_from_col("Crerdit CardNo", row_num), "Crerdit CardNo:");WaitMethods.wait_in_seconds(1);
		GenericMethods.enter_text(WCnewUILocators.x_card_code, ExcelReader.get_row_data_from_col("SecurityCode", row_num), "SecurityCode:");WaitMethods.wait_in_seconds(1);
		GenericMethods.enter_text(WCnewUILocators.x_exp_date, ExcelReader.get_row_data_from_col("ExpiryDate", row_num), "ExpiryDate:");WaitMethods.wait_in_seconds(1);

		GenericMethods.click_Element_Using_JS(WCnewUILocators.pay_now_btn);
		WaitMethods.wait_in_seconds(2);

		GenericMethods.swith_to_default_content();
		WaitMethods.wait_in_seconds(2);
	}


	//Multi Class code test for CA state with Employer.
	public static void multiClassCodes_CA_state_Employer(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{

		String[] code={"2589","2002","2003","2014","2095","2111","2116","2142","2222","2501","2571","2576","0400","2660","2683","2688","2731","2759","2790","2840"};

		try
		{	
			for (String item : code) 

			{		
				ExcelReader.set_excel_file(Locations.WC_UI_TestData,"BusinessInfo");
				WaitMethods.wait_for_element_present(WCnewUILocators.business_street_txtb);		

				WCnewUILocators.business_street_txtb.sendKeys(GenericMethods.generate_random_integer(900, 100),ExcelReader.get_row_data_from_col("BusinessStreet", row_num));
				WaitMethods.wait_in_seconds(2);

				WaitMethods.wait_for_elements_present(WCnewUILocators.businessAdd_List);
				GenericMethods.bootstrap_dropdown(WCnewUILocators.businessAdd_List, ExcelReader.get_row_data_from_col("BusinessStreet", row_num));

				//for Same Mailing address

				GenericMethods.is_element_present(WCnewUILocators.businessAndMailingAddressSame_chkBox);
				GenericMethods.click_Element_Using_JS(WCnewUILocators.businessAndMailingAddressSame_chkBox);
				GenericMethods.click_Element_Using_JS(WCnewUILocators.businessAndMailingAddressSame_chkBox);
				GenericMethods.click_Element_Using_JS(WCnewUILocators.businessAndMailingAddressSame_chkBox);
				WaitMethods.wait_in_seconds(2);

				GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
				WaitMethods.wait_in_seconds(2);


				WCnewUIMethods.businessInfoPage2(1,"otherThenCA","Ex.No");
				GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
				WaitMethods.wait_in_seconds(2); 
				WCnewUIMethods.coverageHistoryWithNOoption("empNo");
				WaitMethods.wait_in_seconds(2);


				// Class Code Fill Employers

				GenericMethods.click_Element(WCnewUILocators.location0_drpd);

				WaitMethods.wait_for_elements_present(WCnewUILocators.location0_List);
				GenericMethods.bootstrap_dropdown(WCnewUILocators.location0_List," ");

				/*GenericMethods.press_key_using_robot("downArrow");
				GenericMethods.press_key_using_robot("enter");*/

				log.info("============================"+item+"==========================");
				GenericMethods.enter_text(WCnewUILocators.classCode0_txtSearch,item, "Class Code : ");
				WaitMethods.wait_in_seconds(2);

				WaitMethods.wait_for_elements_present(WCnewUILocators.classCode0_List);
				GenericMethods.bootstrap_dropdown(WCnewUILocators.classCode0_List," ");

				/*GenericMethods.press_key_using_robot("downArrow");
				GenericMethods.press_key_using_robot("enter");*/

				GenericMethods.enter_text(WCnewUILocators.payRoll0_txtb,"25000", "Annual Payroll0");			
				GenericMethods.enter_text(WCnewUILocators.fullTimeEmployee0_txtb,"2", "FT0");	
				GenericMethods.enter_text(WCnewUILocators.partTimeEmployee0_txtb,"2", "PT0");

				GenericMethods.click_Element(WCnewUILocators.next_btn);
				WaitMethods.wait_in_seconds(2);

				//=============================================

				WCnewUIMethods.ownersAndOfficers(8);
				GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
				WaitMethods.wait_in_seconds(2);

				WCnewUIMethods.credit_Opp_Verify_AvaibalityOf_All_11_Questions();
				GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);

				WCnewUIMethods.CarrierOption("Employer");
				WaitMethods.wait_in_seconds(20);

				WaitMethods.wait_for_element_present(WCnewUILocators.annualPremiumEMPLOYERS1);
				String rate=WCnewUILocators.annualPremiumEMPLOYERS1.getText();
				log.info("========================================"+rate+"====================================");
				if(rate.contains("$"))
				{
					log.info("=========" +rate+ "=======Rate appear for Employers Successfully.For class code " +item+ " ========");
				}
				else
				{
					log.info("==========================Carrier Not Responding or - Unavailable at this time");
				}


				/*WCnewUIMethods.selectCarrier("EmployersOnly");
				WaitMethods.wait_in_seconds(2);

				WCnewUIMethods.Sub_ClassCode("single");
				WaitMethods.wait_in_seconds(2);

				WCnewUIMethods.Carrier_specific_Question_Verify("employerQuetions");
				WaitMethods.wait_in_seconds(2);

				WCnewUIMethods.employerCarrierPaymentPlan("Happy");
				GenericMethods.click_Element(WCnewUILocators.next_btn);
				WaitMethods.wait_in_seconds(40);

				WCnewUIMethods.paymentBreakDown_page("BrokerFee_YES");
				WaitMethods.wait_in_seconds(5);

				WCnewUIMethods.ThankYou_page();
				WaitMethods.wait_in_seconds(2);

				log.info("==================Success for Class code "+item+"============================");*/

				//Going for Another Submission with Different class Code

				//GenericMethods.click_Element(HomePageLocators.homepageLogout);WaitMethods.wait_in_seconds(5);

				GenericMethods.driver.switchTo().defaultContent();
				//GenericMethods.close_browser_window();
				GenericMethods.close_window_using_robot();

				initialize_agency_environment("environment","chrome_browser");
				InitializeElements.initialize_elements();
				HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
				HomePageMethods.select_agency_contact();	
				WCnewUIMethods.select_WC_Program();

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




	//Multi Class code test for CA state with AMtrust.
	public static void multiClassCodes_CA_state_AMTrust(int row_num) throws IOException, InterruptedException, Exception, AWTException

	{

		String[] code={"0251","0035","0040","0042","0079","0005","1803","1925","2002","2003","2063","2095","2102","2107","2108","2109","2111","2113","2116","2117"};

		try
		{	
			for (String item : code) 

			{	
				ExcelReader.set_excel_file(Locations.WC_UI_TestData,"BusinessInfo");
				WaitMethods.wait_for_element_present(WCnewUILocators.business_street_txtb);		

				WCnewUILocators.business_street_txtb.sendKeys(GenericMethods.generate_random_integer(900, 100),ExcelReader.get_row_data_from_col("BusinessStreet", row_num));
				WaitMethods.wait_in_seconds(2);

				WaitMethods.wait_for_elements_present(WCnewUILocators.businessAdd_List);
				GenericMethods.bootstrap_dropdown(WCnewUILocators.businessAdd_List, ExcelReader.get_row_data_from_col("BusinessStreet", row_num));

				//for Same Mailing address

				GenericMethods.is_element_present(WCnewUILocators.businessAndMailingAddressSame_chkBox);
				GenericMethods.click_Element_Using_JS(WCnewUILocators.businessAndMailingAddressSame_chkBox);
				GenericMethods.click_Element_Using_JS(WCnewUILocators.businessAndMailingAddressSame_chkBox);
				GenericMethods.click_Element_Using_JS(WCnewUILocators.businessAndMailingAddressSame_chkBox);
				WaitMethods.wait_in_seconds(2);

				GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
				WaitMethods.wait_in_seconds(2);


				WCnewUIMethods.businessInfoPage2(1,"otherThenCA","Ex.No");
				GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
				WaitMethods.wait_in_seconds(2); 
				WCnewUIMethods.coverageHistoryWithNOoption("empNo");
				WaitMethods.wait_in_seconds(2);


				// Class Code Fill Employers

				GenericMethods.click_Element(WCnewUILocators.location0_drpd);

				WaitMethods.wait_for_elements_present(WCnewUILocators.location0_List);
				GenericMethods.bootstrap_dropdown(WCnewUILocators.location0_List," ");

				//GenericMethods.press_key_using_robot("downArrow");87
				//GenericMethods.press_key_using_robot("enter");

				log.info("============================"+item+"==========================");
				GenericMethods.enter_text(WCnewUILocators.classCode0_txtSearch,item, "Class Code : ");
				WaitMethods.wait_in_seconds(2);



				WaitMethods.wait_for_elements_present(WCnewUILocators.classCode0_List);
				GenericMethods.bootstrap_dropdown(WCnewUILocators.classCode0_List," ");


				// /*GenericMethods.press_key_using_robot("downArrow");
				// GenericMethods.press_key_using_robot("enter");*/

				GenericMethods.enter_text(WCnewUILocators.payRoll0_txtb,"25000", "Annual Payroll0");			
				GenericMethods.enter_text(WCnewUILocators.fullTimeEmployee0_txtb,"2", "FT0");	
				GenericMethods.enter_text(WCnewUILocators.partTimeEmployee0_txtb,"2", "PT0");

				GenericMethods.click_Element(WCnewUILocators.next_btn);
				WaitMethods.wait_in_seconds(2);

				//=============================================

				WCnewUIMethods.ownersAndOfficers(8);
				GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
				WaitMethods.wait_in_seconds(2);

				WCnewUIMethods.credit_Opp_Verify_AvaibalityOf_All_11_Questions();
				GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);

				WCnewUIMethods.CarrierOption("Amtrust");
				WaitMethods.wait_in_seconds(15);

				WaitMethods.wait_for_element_present(WCnewUILocators.annualPremiumAMTRUSTWC);
				String rate=WCnewUILocators.annualPremiumAMTRUSTWC.getText();
				log.info("========================================"+rate+"====================================");
				if(rate.contains("$"))
				{
					log.info("=========" +rate+ "=======Rate appear for AMTrust Successfully.For class code " +item+ " ========");
				}
				else
				{
					log.info("==========================Carrier Not Responding or - Unavailable at this time");
				}


				/*WCnewUIMethods.selectCarrier("AMtrust");
				WaitMethods.wait_in_seconds(2);

				WCnewUIMethods.Sub_ClassCode("single");
				WaitMethods.wait_in_seconds(2);

				WCnewUIMethods.Carrier_specific_Question_Verify("AMTrutQuetions");
				WaitMethods.wait_in_seconds(2);

				WCnewUIMethods.amTrustCarrierPaymentPlan("Happy");
				GenericMethods.click_Element(WCnewUILocators.next_btn);
				WaitMethods.wait_in_seconds(40);

				WCnewUIMethods.paymentBreakDown_page("BrokerFee_YES");
				WaitMethods.wait_in_seconds(5);

				WCnewUIMethods.ThankYou_page();
				WaitMethods.wait_in_seconds(2);

				log.info("==================Success for Class code "+item+"============================");

				//Going for Another Submission with Different class Code

				//GenericMethods.click_Element(HomePageLocators.homepageLogout);WaitMethods.wait_in_seconds(5);
				 */				
				GenericMethods.driver.switchTo().defaultContent();
				GenericMethods.close_window_using_robot();
				//GenericMethods.close_browser_window();

				initialize_agency_environment("environment","chrome_browser");
				InitializeElements.initialize_elements();
				HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
				HomePageMethods.select_agency_contact();	
				WCnewUIMethods.select_WC_Program();

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









