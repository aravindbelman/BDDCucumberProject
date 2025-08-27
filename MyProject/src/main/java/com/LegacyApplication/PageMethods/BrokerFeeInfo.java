package com.LegacyApplication.PageMethods;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.util.PDFTextStripper;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.LegacyApplication.ExcelReader.ExcelReader;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageLocators.AdminSubmissionPageLocators;
import com.LegacyApplication.PageLocators.DefaultBrokerFeeLocators;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;


public class BrokerFeeInfo extends TestBase {

	public static final Logger log=Logger.getLogger(BrokerFeeInfo.class.getName());

	public static void select_agency() throws InterruptedException
	{   
		WaitMethods.wait_in_seconds(10);
		WaitMethods.wait_for_element_present(DefaultBrokerFeeLocators.admintasks_tab);
		GenericMethods.mouse_hover_and_click_using_actions(DefaultBrokerFeeLocators.admintasks_tab, DefaultBrokerFeeLocators.agency_informationview);
		WaitMethods.wait_for_element_present(DefaultBrokerFeeLocators.agency_name_searchfield);
		DefaultBrokerFeeLocators.agency_name_searchfield.sendKeys(OR.getProperty("agencyname"));
		WaitMethods.wait_for_element_present(DefaultBrokerFeeLocators.search_button);
		DefaultBrokerFeeLocators.search_button.click();
		WaitMethods.wait_for_element_present(DefaultBrokerFeeLocators.select_agency);
		DefaultBrokerFeeLocators.select_agency.click();
		WaitMethods.wait_for_element_present(DefaultBrokerFeeLocators.view_link);
		DefaultBrokerFeeLocators.view_link.click();
	}

	public static void validate_agency_info(int row_num) throws IOException, InterruptedException
	{
		select_agency();
		ExcelReader.set_excel_file(Locations.testDataFilePath, "Agency_Info_View");
		Assert.assertEquals(GenericMethods.get_attribute_value(DefaultBrokerFeeLocators.agency_name, "value"), ExcelReader.get_row_data_from_col("Agency_Name", row_num));
		Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(DefaultBrokerFeeLocators.agencyinfo_status), ExcelReader.get_row_data_from_col("Status", row_num));
		Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(DefaultBrokerFeeLocators.agencyinfo_reason), ExcelReader.get_row_data_from_col("Reason", row_num));
		Assert.assertEquals(GenericMethods.get_attribute_value(DefaultBrokerFeeLocators.agencyinfo_agencycontact, "value"), ExcelReader.get_row_data_from_col("Agency Contact", row_num));
		Assert.assertEquals(GenericMethods.get_attribute_value(DefaultBrokerFeeLocators.agencyinfo_emailaddress, "value"), ExcelReader.get_row_data_from_col("Email Address", row_num));
		Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(DefaultBrokerFeeLocators.agencyinfo_businesstype), ExcelReader.get_row_data_from_col("Type of Business", row_num));
		Assert.assertEquals(GenericMethods.is_element_enabled(DefaultBrokerFeeLocators.agencyinfo_federaltax), ExcelReader.get_row_data_from_col("Federal Tax Id", row_num));
		Assert.assertEquals(GenericMethods.is_element_enabled(DefaultBrokerFeeLocators.agencyinfo_webaddress), ExcelReader.get_row_data_from_col("Website Url", row_num));
		Assert.assertEquals(GenericMethods.get_attribute_value(DefaultBrokerFeeLocators.agencyinfo_phoneno, "value"), ExcelReader.get_row_data_from_col("Phone Number", row_num));
		Assert.assertEquals(GenericMethods.is_element_enabled(DefaultBrokerFeeLocators.agencyinfo_tollfreenumber), ExcelReader.get_row_data_from_col("Toll Free Number", row_num));
		Assert.assertEquals(GenericMethods.is_element_enabled(DefaultBrokerFeeLocators.agencyinfo_licensenumber), ExcelReader.get_row_data_from_col("License Number", row_num));
		Assert.assertEquals(GenericMethods.is_element_enabled(DefaultBrokerFeeLocators.agencyinfo_licenseexpdate), ExcelReader.get_row_data_from_col("Expiration Date", row_num));
		Assert.assertEquals(GenericMethods.is_element_enabled(DefaultBrokerFeeLocators.agencyinfo_policynumber), ExcelReader.get_row_data_from_col("Policy Number", row_num));
		Assert.assertEquals(GenericMethods.is_element_enabled(DefaultBrokerFeeLocators.agencyinfo_policydate), ExcelReader.get_row_data_from_col("Policy Expiration Date", row_num));
		Assert.assertEquals(GenericMethods.is_element_enabled(DefaultBrokerFeeLocators.agencyinfo_principlename1), ExcelReader.get_row_data_from_col("Priniciple Name1", row_num));
		Assert.assertEquals(GenericMethods.is_element_enabled(DefaultBrokerFeeLocators.agencyinfo_princpleemail1), ExcelReader.get_row_data_from_col("Priniciple Email1", row_num));
		Assert.assertEquals(GenericMethods.is_element_enabled(DefaultBrokerFeeLocators.agencyinfo_principlename2), ExcelReader.get_row_data_from_col("Priniciple Name2", row_num));
		Assert.assertEquals(GenericMethods.is_element_enabled(DefaultBrokerFeeLocators.agencyinfo_princpleemail2), ExcelReader.get_row_data_from_col("Priniciple Email2", row_num));
		Assert.assertEquals(GenericMethods.is_element_enabled(DefaultBrokerFeeLocators.agencyinfo_principlename3), ExcelReader.get_row_data_from_col("Priniciple Name3", row_num));
		Assert.assertEquals(GenericMethods.is_element_enabled(DefaultBrokerFeeLocators.agencyinfo_princpleemail3), ExcelReader.get_row_data_from_col("Priniciple Email3", row_num));
		Assert.assertEquals(GenericMethods.is_element_enabled(DefaultBrokerFeeLocators.agencyinfo_principlename4), ExcelReader.get_row_data_from_col("Priniciple Name4", row_num));
		Assert.assertEquals(GenericMethods.is_element_enabled(DefaultBrokerFeeLocators.agencyinfo_princpleemail4), ExcelReader.get_row_data_from_col("Priniciple Email4", row_num));
		Assert.assertEquals(GenericMethods.get_attribute_value(DefaultBrokerFeeLocators.agencyinfo_mailingaddress, "value"), ExcelReader.get_row_data_from_col("Mailing Address", row_num));
		Assert.assertEquals(GenericMethods.get_attribute_value(DefaultBrokerFeeLocators.agencyinfo_mailingcity, "value"), ExcelReader.get_row_data_from_col("Mailing City", row_num));
		Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(DefaultBrokerFeeLocators.agencyinfo_mailingstate), ExcelReader.get_row_data_from_col("Mailing State", row_num));
		Assert.assertEquals(GenericMethods.get_attribute_value(DefaultBrokerFeeLocators.agencyinfo_mailingzip, "value"), ExcelReader.get_row_data_from_col("Mailing Zip", row_num));
		Assert.assertEquals(GenericMethods.is_element_enabled(DefaultBrokerFeeLocators.agencyinfo_agencyaddress), ExcelReader.get_row_data_from_col("Agency Address", row_num));
		Assert.assertEquals(GenericMethods.is_element_enabled(DefaultBrokerFeeLocators.agencyinfo_agencycity), ExcelReader.get_row_data_from_col("Agency City", row_num));
		Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(DefaultBrokerFeeLocators.agencyinfo_agencystate), ExcelReader.get_row_data_from_col("Agency State", row_num));
		Assert.assertEquals(GenericMethods.is_element_enabled(DefaultBrokerFeeLocators.agencyinfo_agencyzip), ExcelReader.get_row_data_from_col("Agency Zip", row_num));
		Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(DefaultBrokerFeeLocators.agencyinfo_agencyterritoryid), ExcelReader.get_row_data_from_col("Agency Territory", row_num));
		log.info("<===========Data Matched Successfully===========>");
	}

	public static void validate_more_info() throws IOException, InterruptedException
	{
		DefaultBrokerFeeLocators.moreinfo_tab.click();

		int j= DefaultBrokerFeeLocators.moreinfo_chekcboxes.size();

		for(int i=0;i<j;i++)
		{
			GenericMethods.is_element_enabled(DefaultBrokerFeeLocators.moreinfo_chekcboxes.get(i));

		}

	}

	public static void change_status() throws InterruptedException, IOException
	{
		WaitMethods.wait_in_seconds(3);
		WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_table_row);
		GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
		GenericMethods.click_Element_Using_JS(DefaultBrokerFeeLocators.changestatus_link);
		WaitMethods.wait_in_seconds(3);

		for(int i=0;i<DefaultBrokerFeeLocators.changestatus_labels.size();i++)
		{
			String s=GenericMethods.get_text(DefaultBrokerFeeLocators.changestatus_labels.get(i));
			int j=i+1;
			if(s.contains(OR.getProperty("statustobechanged")))
			{
				driver.findElement(By.xpath("(//input[@id='Status'])[position()='"+j+"']")).click();
				DefaultBrokerFeeLocators.changestatus_submitbutton.click();

			}
		
			else 
			{

				log.info("The submission id status is already " +"OK TO Bind");

			}

		}
		GenericMethods.click_Element_Using_JS(DefaultBrokerFeeLocators.changestatus_cancelbutton);
	}
	public static void view_application_info() throws InterruptedException, IOException
	{
		
		WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_table_row);
		GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
		WaitMethods.wait_for_element_present(DefaultBrokerFeeLocators.view_application_link);
		GenericMethods.click_Element_Using_JS(DefaultBrokerFeeLocators.view_application_link);
		WaitMethods.wait_in_seconds(10);
       	GenericMethods.navigate_to_next_window();
        GenericMethods.validate_text_in_pdf("Broker Fee: $");
	}

	}


