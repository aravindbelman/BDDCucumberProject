package com.BtisNewUI.PageMethods;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;

import com.BtisNewUI.Locators.RegistrationProcessLocators;
import com.LegacyApplication.ExcelReader.ExcelReader;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

public class RegistrationProcessMethods extends TestBase{

	public static final Logger log=Logger.getLogger(RegistrationProcessMethods.class.getName());
	public static JavascriptExecutor js;

	/*
	 * Purpose: This method go to agencyInfoPage
	 * & perform Operations
	 * integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void agencyInfoPage(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{ 
		ExcelReader.set_excel_file(Locations.registrationProcess_UI_TestData,"agencyInfo");
		GenericMethods.click_Element(RegistrationProcessLocators.register_btn);
		GenericMethods.click_Element(RegistrationProcessLocators.register_now_btn);
		GenericMethods.select_from_dropdown(RegistrationProcessLocators.agentType_drpd, "visibletext", ExcelReader.get_row_data_from_col("agentType", row_num));
		GenericMethods.enter_text(RegistrationProcessLocators.LicenseNo_txtb, ExcelReader.get_row_data_from_col("LicenseNo", row_num), "License Number");
		GenericMethods.enter_text(RegistrationProcessLocators.AgencyName_txtb, ExcelReader.get_row_data_from_col("AgencyName", row_num), "AgencyName");
		GenericMethods.enter_text(RegistrationProcessLocators.fein_tin_txtb, ExcelReader.get_row_data_from_col("FederalTaxId", row_num), "FederalTaxId");
		GenericMethods.enter_text(RegistrationProcessLocators.TaxIDName_txtb, ExcelReader.get_row_data_from_col("TaxIDName", row_num), "TaxID Name");
		GenericMethods.select_from_dropdown(RegistrationProcessLocators.BusinessType_drpd, "visibletext", ExcelReader.get_row_data_from_col("BusinessType", row_num));
		GenericMethods.enter_text(RegistrationProcessLocators.PrincipalName_txtb, ExcelReader.get_row_data_from_col("PrincipalName", row_num), "Principal Name");
		GenericMethods.enter_text(RegistrationProcessLocators.PrincipalEmail_txtb, ExcelReader.get_row_data_from_col("PrincipalEmail", row_num), "Principal Email");
		GenericMethods.click_Element(RegistrationProcessLocators.save_continue_Cmn_btn);
	}

	/*
	 * Purpose: This method go to ContactInfo
	 * & perform Operations
	 * integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void contactInfoPage(int row_num,String diff_add) throws IOException, InterruptedException, Exception, AWTException
	{ 
		ExcelReader.set_excel_file(Locations.registrationProcess_UI_TestData,"contactInfo");

		if(diff_add.equalsIgnoreCase("same"))
		{
			GenericMethods.enter_text(RegistrationProcessLocators.streetAddress_txtb, ExcelReader.get_row_data_from_col("address1", row_num), "Add1");
			GenericMethods.enter_text(RegistrationProcessLocators.address2_txtb, ExcelReader.get_row_data_from_col("address2", row_num), "Add2");
			GenericMethods.enter_text(RegistrationProcessLocators.City_txtb, ExcelReader.get_row_data_from_col("City", row_num), "City");
			GenericMethods.select_from_dropdown(RegistrationProcessLocators.State_drpd, "visibletext", ExcelReader.get_row_data_from_col("State", row_num));
			GenericMethods.enter_text(RegistrationProcessLocators.Zip_txtb, ExcelReader.get_row_data_from_col("Zip", row_num), "Zip");
		}

		if(diff_add.equalsIgnoreCase("different"))
		{	
			GenericMethods.enter_text(RegistrationProcessLocators.streetAddress_txtb, ExcelReader.get_row_data_from_col("address1", row_num), "Add1");
			GenericMethods.enter_text(RegistrationProcessLocators.address2_txtb, ExcelReader.get_row_data_from_col("address2", row_num), "Add2");
			GenericMethods.enter_text(RegistrationProcessLocators.City_txtb, ExcelReader.get_row_data_from_col("City", row_num), "City");
			GenericMethods.select_from_dropdown(RegistrationProcessLocators.State_drpd, "visibletext", ExcelReader.get_row_data_from_col("State", row_num));
			GenericMethods.enter_text(RegistrationProcessLocators.Zip_txtb, ExcelReader.get_row_data_from_col("Zip", row_num), "Zip");
	
			GenericMethods.click_Element(RegistrationProcessLocators.mailingAddress_Yes_btn);
			GenericMethods.enter_text(RegistrationProcessLocators.Mail_streetAddress_txtb, ExcelReader.get_row_data_from_col("mailingAddress1", row_num), "mail add 1");
			GenericMethods.enter_text(RegistrationProcessLocators.Mail_address2_txtb, ExcelReader.get_row_data_from_col("mailingAddress2", row_num), " mail add2");
			GenericMethods.enter_text(RegistrationProcessLocators.Mail_City_txtb, ExcelReader.get_row_data_from_col("MailingCity", row_num), "mail city");
			GenericMethods.select_from_dropdown(RegistrationProcessLocators.Mail_State_drpd, "visibletext", ExcelReader.get_row_data_from_col("MailingStateID", row_num));
			GenericMethods.enter_text(RegistrationProcessLocators.Mail_Zip_txtb, ExcelReader.get_row_data_from_col("MailingZip", row_num), " Mail zip");
		}
		
		GenericMethods.enter_text(RegistrationProcessLocators.PhoneNumber_txtb, ExcelReader.get_row_data_from_col("PhoneNumber", row_num), "Phone Number");
		GenericMethods.enter_text(RegistrationProcessLocators.MobileNumber_txtb, ExcelReader.get_row_data_from_col("MobileNumber", row_num), "Mobile No");
		GenericMethods.enter_text(RegistrationProcessLocators.ContactName_txtb, ExcelReader.get_row_data_from_col("ContactName", row_num), "contact name");
		GenericMethods.enter_text(RegistrationProcessLocators.ContactEmail_txtb, ExcelReader.get_row_data_from_col("ContactEmail", row_num), "Contact Email");
		GenericMethods.click_Element(RegistrationProcessLocators.save_continue_Cmn_btn);
	}
	
	/*
	 * Purpose: This method go to Errors_and_Omissions
	 * & perform Operations
	 * integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void Errors_and_Omissions(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{ 
		ExcelReader.set_excel_file(Locations.registrationProcess_UI_TestData,"errorPage");
		
		GenericMethods.enter_text(RegistrationProcessLocators.EOPNumber_txtb, ExcelReader.get_row_data_from_col("EOPNumber", row_num), "EOP Number");
		GenericMethods.enter_text(RegistrationProcessLocators.EOPCarrierName_txtb, ExcelReader.get_row_data_from_col("EOPCarrierName", row_num), "EOPCarrier Name");
		RegistrationProcessLocators.exp_date.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, 10, 0, 0, 0));
		GenericMethods.press_key_using_robot("tab");
		
		GenericMethods.select_from_dropdown(RegistrationProcessLocators.EOPLimit_drpd, "visibletext", ExcelReader.get_row_data_from_col("EOPLimit", row_num));
		GenericMethods.click_Element(RegistrationProcessLocators.save_continue_Cmn_btn);
	}
	
	/*
	 * Purpose: This method go to Errors_and_Omissions
	 * & perform Operations
	 * integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void agencyEligibility(int row_num) throws IOException, InterruptedException, Exception, AWTException
	{ 
		ExcelReader.set_excel_file(Locations.registrationProcess_UI_TestData,"agencyEligibility");
		
		GenericMethods.click_Element(RegistrationProcessLocators.ViolationExplanation_yes);
		GenericMethods.enter_text(RegistrationProcessLocators.ViolationExplanation_txtb, ExcelReader.get_row_data_from_col("ViolationExplanation_txtb", row_num), "Violation Explanation");
	
		GenericMethods.click_Element(RegistrationProcessLocators.EAndOClaimsInPastFiveExplanation_yes);
		GenericMethods.enter_text(RegistrationProcessLocators.EAndOClaimsInPastFiveExplanation_txtb, ExcelReader.get_row_data_from_col("EAndOClaimsInPastFiveExplanation_txtb", row_num), "EAndOClaimsInPastFive Explanation");
	
		GenericMethods.click_Element(RegistrationProcessLocators.BankruptcyInPastFiveExplanation_yes);
		GenericMethods.enter_text(RegistrationProcessLocators.BankruptcyInPastFiveExplanation_txtb, ExcelReader.get_row_data_from_col("BankruptcyInPastFiveExplanation_txtb", row_num), "EAndOClaimsInPastFive Explanation");
	
		GenericMethods.click_Element(RegistrationProcessLocators.OpenLiensExplanation_yes);
		GenericMethods.enter_text(RegistrationProcessLocators.OpenLiensExplanation_txtb, ExcelReader.get_row_data_from_col("OpenLiensExplanation_txtb", row_num), "OpenLiens Explanation");
	
		GenericMethods.enter_text(RegistrationProcessLocators.HowDidYouHearAboutUs_txtb, ExcelReader.get_row_data_from_col("HowDidYouHearAboutUs_txtb", row_num), "HowDidYouHearAboutUs");
		GenericMethods.click_Element(RegistrationProcessLocators.save_continue_Cmn_btn);
	}
	
	/*
	 * Purpose: This method go to Upload PAGE
	 * & perform Operations
	 * @return NA
	 */
	public static void uploadDoc() throws IOException, InterruptedException, Exception, AWTException
	{ 	
		GenericMethods.click_Element_Using_JS(RegistrationProcessLocators.agencyLicenseFile);
		GenericMethods.file_upload(Locations.adoptSignPop_up);
		GenericMethods.press_key_using_robot("escape");
		GenericMethods.click_Element_Using_JS(RegistrationProcessLocators.proofOfInsuranceFile);
		GenericMethods.file_upload(Locations.agree_btn);
		GenericMethods.press_key_using_robot("escape");
		GenericMethods.click_Element_Using_JS(RegistrationProcessLocators.w9File);
		GenericMethods.file_upload(Locations.continue_page1);
		GenericMethods.press_key_using_robot("escape");
		GenericMethods.click_Element(RegistrationProcessLocators.save_continue_Cmn_btn);
		WaitMethods.wait_in_seconds(5);
	}
}
