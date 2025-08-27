package com.LegacyApplication.PageMethods;

import java.awt.AWTException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.LegacyApplication.ExcelReader.ExcelReader;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageLocators.SubmissionPageLocators;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

public class SubmissionPageMethods extends TestBase {

	public static final Logger log=Logger.getLogger(SubmissionPageMethods.class.getName());


	public static void search_by_option(String submissionId, int row_num) throws InterruptedException, IOException {

		ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
		Select agySubmissionSearchBy = new Select(SubmissionPageLocators.ddl_SearchBy);
		List<WebElement> list = agySubmissionSearchBy.getOptions();
		list.get(1).click();
		SubmissionPageLocators.search.sendKeys(ExcelReader.get_row_data_from_col(submissionId, row_num));
		GenericMethods.click_Element_Using_JS(SubmissionPageLocators.searchbutton);
		WaitMethods.wait_in_seconds(5);
	}

	public static void view_submission_details() throws AWTException, InterruptedException {

		WaitMethods.wait_for_element_present(SubmissionPageLocators.submissionTableRow);
		GenericMethods.click_Element_Using_JS(SubmissionPageLocators.submissionTableRow);
		WaitMethods.wait_in_seconds(2);
		GenericMethods.click_Element_Using_JS(SubmissionPageLocators.edit_or_finish_submission);
		WaitMethods.wait_in_seconds(5);


		// driver.findElement(AgySubmissionpageLocators.btn_General_Liability).click();
	}

	public static void verify_submission_details_of_application_info(int row_num) throws IOException, InterruptedException {
        try
        {
		ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");

		GenericMethods.click_Element_Using_JS(SubmissionPageLocators.btn_General_Liability);

		/*Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.txtbox_SubmissionType),
			ExcelReader.get_row_data_from_col("Submission_Type", row_num));*/
		Assert.assertEquals(GenericMethods.getTextfmElem(SubmissionPageLocators.txtbox_ApplicantName),
				ExcelReader.get_row_data_from_col("Applicant Name", row_num));
		Assert.assertEquals(GenericMethods.getTextfmElem(SubmissionPageLocators.txtbox_DBA),
				ExcelReader.get_row_data_from_col("DBA", row_num));
		// Assert.assertEquals(Common.getTextfmElem(AgySubmissionpageLocators.txtbox_ProposedEffectiveDate),
		// ExcelReader.getCellData(1, 4));
		Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.txtbox_State),
				ExcelReader.get_row_data_from_col("State", row_num));
		Assert.assertEquals(GenericMethods.getTextfmElem(SubmissionPageLocators.txtbox_ZipCodeGL),
				ExcelReader.get_row_data_from_col("Zip Code", row_num));
		/*Assert.assertEquals(GenericMethods.getTextfmElem(SubmissionPageLocators.lbl_terrByZIP),
			ExcelReader.get_row_data_from_col("Territory", row_num));*/
		/*Assert.assertEquals(GenericMethods.getTextfmElem(SubmissionPageLocators.txt_LicenseNumber),
			ExcelReader.get_row_data_from_col("License Number", row_num));*/
		/*Assert.assertEquals(GenericMethods.is_chekbox_selected(SubmissionPageLocators.chkbox_NoLicenseNeeded),
				ExcelReader.get_row_data_from_col("LicenseNeeded", row_num));*/
		/// System.out.println("Data Matched Successfully !!!");
		log.debug("Data Matched Successfully");
		log.info("Matched successfully");
	}
	catch(AssertionError exe)
	{
		log.info("Assertion failed");
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

	public static void verify_submission_detailsof_GL_RC(int row_num) throws IOException, InterruptedException {
		try
		{
		ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");

		// Limits of Insurance Deductible Owners - Active in Field Part Time Employees
		// Full Time Employees Total Employee Payroll - Exclude payroll of owners,
		// officers, partners and clerical Casual laborers, leased employees, and labor
		// pool personnel Total Payroll "
		// Classification " Payroll Assigned Subcontracting Costs Annual Gross Receipts
		// "Applicantâ€™s Business Experience /Insurance History
		// "

		//GenericMethods.click_Element_Using_JS(SubmissionPageLocators.btn_General_Liability);

		Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.ddl_SearchByLimitsofInsurance),ExcelReader.get_row_data_from_col("Limits", row_num));
		Assert.assertEquals(GenericMethods.getOnlyDigits(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.ddl_Deductible)),ExcelReader.get_row_data_from_col("Deductible", row_num));
		Assert.assertEquals(GenericMethods.getTextfmElem(SubmissionPageLocators.txt_OwnersActiveinField),ExcelReader.get_row_data_from_col("Owners Active In Field", row_num));
		Assert.assertEquals(GenericMethods.getTextfmElem(SubmissionPageLocators.tex_part_timeEmp),ExcelReader.get_row_data_from_col("Part Time Employees", row_num));

		Assert.assertEquals(GenericMethods.getTextfmElem(SubmissionPageLocators.tex_full_timeEmp),ExcelReader.get_row_data_from_col("Full Time Employees", row_num));

		/*Assert.assertEquals(GenericMethods.getTextfmElem(SubmissionPageLocators.tex_total_payrole),
				ExcelReader.get_row_data_from_col("Employees Payroll", row_num));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.lbl_total_payrole),
				ExcelReader.get_row_data_from_col("Total Payroll", row_num));*/

		Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.classification),ExcelReader.get_row_data_from_col("Classification-1", row_num));

		Assert.assertEquals(GenericMethods.getTextfmElem(SubmissionPageLocators.subcontracting_costs),ExcelReader.get_row_data_from_col("Subcontracting Costs", row_num));

		Assert.assertEquals(GenericMethods.getTextfmElem(SubmissionPageLocators.gl_annual_gross_receipts),ExcelReader.get_row_data_from_col("Receipts", row_num));

		Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.business_experience),ExcelReader.get_row_data_from_col("Business Experience", row_num));


		log.info("Matched successfully");
		}
		catch(AssertionError exe)
		{
			log.info("Assertion failed");
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

	public static void printing_headertabs() throws AWTException

	{
		/*List<WebElement> tabheader = driver.findElements(SubmissionPageLocators.tab_Headers);
	List<WebElement> error1 = driver.findElements(SubmissionPageLocators.tab_ErrorHeaders1);*/

		System.out.println(SubmissionPageLocators.tab_Headers.size());

		LinkedHashMap<String, String> Val = new LinkedHashMap<String, String>();
		for (int i = 0; i <= SubmissionPageLocators.tab_Headers.size() - 1; i++) {

			String data0 = SubmissionPageLocators.tab_Headers.get(i).getAttribute("value").toString();
			String data1 = SubmissionPageLocators.tab_Headers.get(i).getAttribute("status").toString();
			Val.put(data0, data1);

		}
		System.out.println(Val);
		if (SubmissionPageLocators.tab_ErrorHeaders1.size() > 0) {
			//int errorcount=error1.size()/2;
			System.out.println(SubmissionPageLocators.tab_ErrorHeaders1.size() / 2 + "  Error Exist");
			System.out.println(GenericMethods.getMapValue(Val, "2") + " info has some errors");


		}else {
			System.out.println("All Data filled successfully");
		}

	}

	public static void print_err_msg() throws InterruptedException
	{
		WaitMethods.wait_for_element_present(SubmissionPageLocators.price_inditcator_errormsg);
		WaitMethods.wait_in_seconds(3);
		log.info("The error Message for Price Indicator is "+SubmissionPageLocators.price_inditcator_errormsg.getClass().toGenericString());

		WaitMethods.wait_for_element_present(SubmissionPageLocators.eligibility_errormsg);
		WaitMethods.wait_in_seconds(3);
		log.info("The error Message for Eligibility is "+SubmissionPageLocators.eligibility_errormsg.getAttribute("innerHTML"));

		WaitMethods.wait_for_element_present(SubmissionPageLocators.application_errormsg);
		WaitMethods.wait_in_seconds(3);
		log.info("The error Message for Application is "+SubmissionPageLocators.application_errormsg.getText());

	}

	public static void verify_optional_coverage(int row_num) throws IOException
	{
		ExcelReader.set_excel_file(Locations.testDataFilePath, "Optional_Coverages");

		GenericMethods.click_Element_Using_JS(SubmissionPageLocators.btn_General_Liability);

		Assert.assertEquals(GenericMethods.is_chekbox_selected(SubmissionPageLocators.asr_endorsement),
				ExcelReader.get_row_data_from_col("ASR Endorsement", row_num));

		Assert.assertEquals(GenericMethods.is_chekbox_selected(SubmissionPageLocators.per_project_aggregate),
				ExcelReader.get_row_data_from_col("per-project-aggregate", row_num));

		Assert.assertEquals(GenericMethods.is_chekbox_selected(SubmissionPageLocators.employee_benefits),
				ExcelReader.get_row_data_from_col("employee-bebefits", row_num));

		Assert.assertEquals(GenericMethods.is_chekbox_selected(SubmissionPageLocators.action_over),
				ExcelReader.get_row_data_from_col("action-over", row_num));

		Assert.assertEquals(GenericMethods.is_chekbox_selected(SubmissionPageLocators.classification_limitation),
				ExcelReader.get_row_data_from_col("classification-limitation", row_num));

		/* Assert.assertEquals(GenericMethods.is_chekbox_selected(SubmissionPageLocators.prior_completed),
			ExcelReader.get_row_data_from_col("prior-completed", row_num));*/

		Assert.assertEquals(GenericMethods.is_chekbox_selected(SubmissionPageLocators.subsidence_exclusion),
				ExcelReader.get_row_data_from_col("subsidence-exclusion", row_num));

		Assert.assertEquals(GenericMethods.is_chekbox_selected(SubmissionPageLocators.insured_endorsement),
				ExcelReader.get_row_data_from_col("insured-endorsement", row_num));

		Assert.assertEquals(GenericMethods.is_chekbox_selected(SubmissionPageLocators.workmanship_coverage),
				ExcelReader.get_row_data_from_col("workmanship-coverage", row_num));

		Assert.assertEquals(GenericMethods.is_chekbox_selected(SubmissionPageLocators.small_equipment_coverage),
				ExcelReader.get_row_data_from_col("small-equipment-coverage", row_num));

		Assert.assertEquals(GenericMethods.is_chekbox_selected(SubmissionPageLocators.available_policy_credits),
				ExcelReader.get_row_data_from_col("available-policy-credits", row_num));

		log.info("<=====================Data Matched Successfully=====================> ");	
	}



	//======================>Price Indicator Methods<===========================================

	public static void verify_price_indicator_elements(int row_num) throws IOException
	{
		ExcelReader.set_excel_file(Locations.testDataFilePath, "Price_Indication");

		//GenericMethods.click_Element_Using_JS(SubmissionPageLocators.btn_General_Liability);
		SubmissionPageLocators.price_indicator_tab.click();

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.manifest_without_sunset_yes),
				ExcelReader.get_row_data_from_col("Manifest Without Sunset Yes", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.manifest_without_sunset_no),
				ExcelReader.get_row_data_from_col("Manifest Without Sunset No", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.occurence_form_with_sunset_yes),
				ExcelReader.get_row_data_from_col("Occurrence Form With Sunset Yes", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.occurence_form_with_sunset_no),
				ExcelReader.get_row_data_from_col("Occurrence Form With Sunset No", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.occurence_form_without_sunset_yes),
				ExcelReader.get_row_data_from_col("Occurrence Form Without Sunset Yes", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.occurence_form_without_sunset_no),
				ExcelReader.get_row_data_from_col("Occurrence Form Without Sunset No", row_num));

		WaitMethods.wait_for_element_present(SubmissionPageLocators.pi_select_limit);

		Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.pi_select_limit),
				ExcelReader.get_row_data_from_col("PI Select Limit", row_num));

		WaitMethods.wait_for_element_present(SubmissionPageLocators.pi_deductible);

		Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.pi_deductible),
				ExcelReader.get_row_data_from_col("PI Deductible", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.terrorism_accept_radio),
				ExcelReader.get_row_data_from_col("Terrorism Accept Radio", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.terrorism_decline_radio),
				ExcelReader.get_row_data_from_col("Terrorism Decline Radio", row_num));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.manifestprovision_glpremium),
				ExcelReader.get_row_data_from_col("ManifestPro_Glpremium", row_num));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.manifestprovision_workmanshipcoverage),
				ExcelReader.get_row_data_from_col("ManifestPro_WorkmanshipCoverage", row_num));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.manifestprovision_totalglpremium),
				ExcelReader.get_row_data_from_col("ManifestPro_TotalGlPremium", row_num));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.manifestprovision_terrorismpremium),
				ExcelReader.get_row_data_from_col("ManifestPro_TerrorismPremium", row_num));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.manifestprovision_policyfee),
				ExcelReader.get_row_data_from_col("ManifestPro_Policyfee", row_num));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.manifestprovision_total_glpolicy),
				ExcelReader.get_row_data_from_col("ManifestPro_TotalGlPolicy", row_num));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.occurenceform_glpremium_withsunset),
				ExcelReader.get_row_data_from_col("OccurenceForm_GlPremium_withsunset", row_num));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.occurenceform_glpremium_withoutsunset),
				ExcelReader.get_row_data_from_col("OccurenceForm_GlPremium_withoutsunset", row_num));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.occurenceform_faultyworkmanship_withsunset),
				ExcelReader.get_row_data_from_col("OccurenceForm_Workmanship_withsunset", row_num));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.occurenceform_faultyworkmanship_withoutsunset),
				ExcelReader.get_row_data_from_col("OccurenceForm_Workmanship_withoutsunset", row_num));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.occurenceform_total_glpremium_withsunset),
				ExcelReader.get_row_data_from_col("OccurenceForm_TotalGlPremium_withsunset", row_num));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.occurenceform_total_glpremium_withoutsunset),
				ExcelReader.get_row_data_from_col("OccurenceForm_TotalGlPremium_withoutsunset", row_num));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.occurenceform_terrorismpremium_withsunset),
				ExcelReader.get_row_data_from_col("OccurenceForm_TerrorismPremium_withsunset", row_num));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.occurenceform_terrorismpremium_withoutsunset),
				ExcelReader.get_row_data_from_col("OccurenceForm_TerrorismPremium_withoutsunset", row_num));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.occurenceform_policyfee_withsunset),
				ExcelReader.get_row_data_from_col("OccurenceForm_PolicyFee_withsunset", row_num));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.occurenceform_policyfee_withoutsunset),
				ExcelReader.get_row_data_from_col("OccurenceForm_PolicyFee_withoutsunset", row_num));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.occurenceform_totalglplicy_withsunset),
				ExcelReader.get_row_data_from_col("OccurenceForm_TotalGlPolicy_withsunset", row_num));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.occurenceform_totalglplicy_withoutsunset),
				ExcelReader.get_row_data_from_col("OccurenceForm_TotalGlPolicy_withoutsunset", row_num));

		log.info("<=====================Data Matched Successfully=====================> ");	
	}

	//======================>Eligibility Page Methods (Common Eligibility Questions)<===========================================

	public static void verify_common_eligibility_elements(int row_num) throws IOException
	{

		ExcelReader.set_excel_file(Locations.testDataFilePath, "Common_Eligibility");

		SubmissionPageLocators.eligibility_page.click();

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn1),
				ExcelReader.get_row_data_from_col("Radio_Btn_1", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn2),
				ExcelReader.get_row_data_from_col("Radio_Btn_2", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn3),
				ExcelReader.get_row_data_from_col("Radio_Btn_3", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn4),
				ExcelReader.get_row_data_from_col("Radio_Btn_4", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn5),
				ExcelReader.get_row_data_from_col("Radio_Btn_5", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn6),
				ExcelReader.get_row_data_from_col("Radio_Btn_6", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn7),
				ExcelReader.get_row_data_from_col("Radio_Btn_7", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn8),
				ExcelReader.get_row_data_from_col("Radio_Btn_8", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn9),
				ExcelReader.get_row_data_from_col("Radio_Btn_9", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn10),
				ExcelReader.get_row_data_from_col("Radio_Btn_10", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn11),
				ExcelReader.get_row_data_from_col("Radio_Btn_11", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn12),
				ExcelReader.get_row_data_from_col("Radio_Btn_12", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn13),
				ExcelReader.get_row_data_from_col("Radio_Btn_13", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn14),
				ExcelReader.get_row_data_from_col("Radio_Btn_14", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn15),
				ExcelReader.get_row_data_from_col("Radio_Btn_15", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn16),
				ExcelReader.get_row_data_from_col("Radio_Btn_16", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn17),
				ExcelReader.get_row_data_from_col("Radio_Btn_17", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn18),
				ExcelReader.get_row_data_from_col("Radio_Btn_18", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn19),
				ExcelReader.get_row_data_from_col("Radio_Btn_19", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn20),
				ExcelReader.get_row_data_from_col("Radio_Btn_20", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn21),
				ExcelReader.get_row_data_from_col("Radio_Btn_21", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn22),
				ExcelReader.get_row_data_from_col("Radio_Btn_22", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn23),
				ExcelReader.get_row_data_from_col("Radio_Btn_23", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn24),
				ExcelReader.get_row_data_from_col("Radio_Btn_24", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn25),
				ExcelReader.get_row_data_from_col("Radio_Btn_25", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn26),
				ExcelReader.get_row_data_from_col("Radio_Btn_26", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn27),
				ExcelReader.get_row_data_from_col("Radio_Btn_27", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn28),
				ExcelReader.get_row_data_from_col("Radio_Btn_28", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn29),
				ExcelReader.get_row_data_from_col("Radio_Btn_29", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn30),
				ExcelReader.get_row_data_from_col("Radio_Btn_30", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn31),
				ExcelReader.get_row_data_from_col("Radio_Btn_31", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn32),
				ExcelReader.get_row_data_from_col("Radio_Btn_32", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn33),
				ExcelReader.get_row_data_from_col("Radio_Btn_33", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn34),
				ExcelReader.get_row_data_from_col("Radio_Btn_34", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn35),
				ExcelReader.get_row_data_from_col("Radio_Btn_35", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn36),
				ExcelReader.get_row_data_from_col("Radio_Btn_36", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn37),
				ExcelReader.get_row_data_from_col("Radio_Btn_37", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn38),
				ExcelReader.get_row_data_from_col("Radio_Btn_38", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn39),
				ExcelReader.get_row_data_from_col("Radio_Btn_39", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn40),
				ExcelReader.get_row_data_from_col("Radio_Btn_40", row_num));

		log.info("<=====================Data Matched Successfully=====================> ");

	}

	//======================>Eligibility Page Methods (Common Eligibility Questions)<===========================================

	public static void verify_specific_eligibility_elements(int row_num) throws IOException
	{

		ExcelReader.set_excel_file(Locations.testDataFilePath, "Specific_Eligibility");

		SubmissionPageLocators.eligibility_page.click();

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn41),
				ExcelReader.get_row_data_from_col("Radio_Btn_41", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn42),
				ExcelReader.get_row_data_from_col("Radio_Btn_42", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn43),
				ExcelReader.get_row_data_from_col("Radio_Btn_43", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn44),
				ExcelReader.get_row_data_from_col("Radio_Btn_44", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn45),
				ExcelReader.get_row_data_from_col("Radio_Btn_45", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn46),
				ExcelReader.get_row_data_from_col("Radio_Btn_46", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn47),
				ExcelReader.get_row_data_from_col("Radio_Btn_47", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn48),
				ExcelReader.get_row_data_from_col("Radio_Btn_48", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn49),
				ExcelReader.get_row_data_from_col("Radio_Btn_49", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn50),
				ExcelReader.get_row_data_from_col("Radio_Btn_50", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn51),
				ExcelReader.get_row_data_from_col("Radio_Btn_51", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn52),
				ExcelReader.get_row_data_from_col("Radio_Btn_52", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn53),
				ExcelReader.get_row_data_from_col("Radio_Btn_53", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn54),
				ExcelReader.get_row_data_from_col("Radio_Btn_54", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn55),
				ExcelReader.get_row_data_from_col("Radio_Btn_55", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn56),
				ExcelReader.get_row_data_from_col("Radio_Btn_56", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn57),
				ExcelReader.get_row_data_from_col("Radio_Btn_57", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn58),
				ExcelReader.get_row_data_from_col("Radio_Btn_58", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn59),
				ExcelReader.get_row_data_from_col("Radio_Btn_59", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn60),
				ExcelReader.get_row_data_from_col("Radio_Btn_60", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn61),
				ExcelReader.get_row_data_from_col("Radio_Btn_61", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn62),
				ExcelReader.get_row_data_from_col("Radio_Btn_62", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn63),
				ExcelReader.get_row_data_from_col("Radio_Btn_63", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn64),
				ExcelReader.get_row_data_from_col("Radio_Btn_64", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn65),
				ExcelReader.get_row_data_from_col("Radio_Btn_65", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn66),
				ExcelReader.get_row_data_from_col("Radio_Btn_66", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn67),
				ExcelReader.get_row_data_from_col("Radio_Btn_67", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn68),
				ExcelReader.get_row_data_from_col("Radio_Btn_68", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn69),
				ExcelReader.get_row_data_from_col("Radio_Btn_69", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn70),
				ExcelReader.get_row_data_from_col("Radio_Btn_70", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn71),
				ExcelReader.get_row_data_from_col("Radio_Btn_71", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn72),
				ExcelReader.get_row_data_from_col("Radio_Btn_72", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn73),
				ExcelReader.get_row_data_from_col("Radio_Btn_73", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn74),
				ExcelReader.get_row_data_from_col("Radio_Btn_74", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn75),
				ExcelReader.get_row_data_from_col("Radio_Btn_75", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn76),
				ExcelReader.get_row_data_from_col("Radio_Btn_76", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn77),
				ExcelReader.get_row_data_from_col("Radio_Btn_77", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn78),
				ExcelReader.get_row_data_from_col("Radio_Btn_78", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn79),
				ExcelReader.get_row_data_from_col("Radio_Btn_79", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn80),
				ExcelReader.get_row_data_from_col("Radio_Btn_80", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn81),
				ExcelReader.get_row_data_from_col("Radio_Btn_81", row_num));

		Assert.assertEquals(GenericMethods.is_radio_button_selected(SubmissionPageLocators.radio_btn82),
				ExcelReader.get_row_data_from_col("Radio_Btn_82", row_num));

		log.info("<=====================Data Matched Successfully=====================> ");
	}

	//======================> Application Page Methods<===========================================

	public static void verify_application_page_info(int row_num) throws IOException

	{

		ExcelReader.set_excel_file(Locations.testDataFilePath, "Application_Data");

		SubmissionPageLocators.application_tab.click();

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.applicant_name),
				ExcelReader.get_row_data_from_col("Applicant Name", row_num));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.dba),
				ExcelReader.get_row_data_from_col("DBA", row_num));

		Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.pri_street_address),
				ExcelReader.get_row_data_from_col("Street Address", row_num));

		Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.primary_city),
				ExcelReader.get_row_data_from_col("City", row_num));

		Assert.assertEquals(GenericMethods.getTextfmElem(SubmissionPageLocators.pri_state_name),
				ExcelReader.get_row_data_from_col("State Name", row_num));

		Assert.assertEquals(GenericMethods.getTextfmElem(SubmissionPageLocators.pri_zip_code),
				ExcelReader.get_row_data_from_col("Pri Zip Code", row_num));

		Assert.assertEquals(GenericMethods.is_chekbox_selected(SubmissionPageLocators.same_as_primary_checkbox),
				ExcelReader.get_row_data_from_col("Primary Premise Chkbox", row_num));

		Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.mailing_street_address),
				ExcelReader.get_row_data_from_col("Street Address", row_num));

		Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.mailing_city),
				ExcelReader.get_row_data_from_col("City", row_num));

		Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.mailing_state),
				ExcelReader.get_row_data_from_col("State", row_num));

		Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.mailing_zip_code),
				ExcelReader.get_row_data_from_col("Zip Code", row_num));

		Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.contact_name),
				ExcelReader.get_row_data_from_col("Contact Name", row_num));

		Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.signing_party),
				ExcelReader.get_row_data_from_col("Application Sign", row_num));

		Assert.assertEquals(GenericMethods.is_chekbox_selected(SubmissionPageLocators.spanish_speaking),
				ExcelReader.get_row_data_from_col("Spanish Check Box", row_num));

		Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.office_phno1),
				ExcelReader.get_row_data_from_col("Office_Ph_No_Box1", row_num));

		Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.office_phno2),
				ExcelReader.get_row_data_from_col("Office_Ph_No_Box2", row_num));

		Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.office_phno3),
				ExcelReader.get_row_data_from_col("Office_Ph_No_Box3", row_num));

		Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.cell_phno1),
				ExcelReader.get_row_data_from_col("Cell_Ph_No_Box1", row_num));

		Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.cell_phno2),
				ExcelReader.get_row_data_from_col("Cell_Ph_No_Box2", row_num));

		Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.cell_phno3),
				ExcelReader.get_row_data_from_col("Cell_Ph_No_Box3", row_num));

		Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.email_address),
				ExcelReader.get_row_data_from_col("Email Address", row_num));

		Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.business_type),
				ExcelReader.get_row_data_from_col("Type of Business", row_num));

		Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.theft_protection),
				ExcelReader.get_row_data_from_col("Theft Protection", row_num));

		Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.years_in_business),
				ExcelReader.get_row_data_from_col("Years in business", row_num));

		Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.construction_experience),
				ExcelReader.get_row_data_from_col("Construction Experience", row_num));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.annual_gross_receipts),
				ExcelReader.get_row_data_from_col("Gross Receipts", row_num));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.total_payroll),
				ExcelReader.get_row_data_from_col("Total Payroll", row_num));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.sub_contractor_costs),
				ExcelReader.get_row_data_from_col("Sub Contractor Costs", row_num));

		/*Assert.assertEquals(get_text(SubmissionPageLocators.requested_eff_date),
    			ExcelReader.get_row_data_from_col("Effective Date", 1));*/ 

		Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.current_gl_policy_expiration),
				ExcelReader.get_row_data_from_col("Gl Ploicy", row_num));

		Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.carrier_name),
				ExcelReader.get_row_data_from_col("Carrier Name", row_num));

		Assert.assertEquals(GenericMethods.is_chekbox_selected(SubmissionPageLocators.no_insurancecoverage_chkbx),
				ExcelReader.get_row_data_from_col("No Insurance Coverage", row_num));

		Assert.assertEquals(GenericMethods.get_selected_optn_frm_ele(SubmissionPageLocators.gl_noof_losses),
				ExcelReader.get_row_data_from_col("Number of Losses", row_num));

		Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.amount_of_losses),
				ExcelReader.get_row_data_from_col("Amount of Losses", row_num));

		Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.resedential_strct_type),
				ExcelReader.get_row_data_from_col("Residential", row_num));

		Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.industrial_strct_type),
				ExcelReader.get_row_data_from_col("Industrial", row_num));

		Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.commercial_strct_type),
				ExcelReader.get_row_data_from_col("Commercial", row_num));

		Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.new_construction_type),
				ExcelReader.get_row_data_from_col("New Construction", row_num));

		Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.service_and_repair_type),
				ExcelReader.get_row_data_from_col("Service and Repair", row_num));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.next_12months_val),
				ExcelReader.get_row_data_from_col("Next 12 Months", row_num));

		Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.last_12months_txtfield),
				ExcelReader.get_row_data_from_col("Last 12 Months", row_num));

		Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.second_year_prior),
				ExcelReader.get_row_data_from_col("2nd year prior", row_num));

		Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.third_year_prior),
				ExcelReader.get_row_data_from_col("3rd year prior", row_num));

		Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.description_of_operations),
				ExcelReader.get_row_data_from_col("Desc of Operations", row_num));

		Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.submit_button),
				ExcelReader.get_row_data_from_col("Submit Button", row_num));

		Assert.assertEquals(GenericMethods.is_element_enabled(SubmissionPageLocators.previous_button),
				ExcelReader.get_row_data_from_col("Prev Button", row_num));


		log.info("====================> Data Matched Successfully<========================");

	}

	//  ====================================> Verify Submission details Information <==================================== 

	public static void verify_unsold_submission_details_info(int row_num) throws IOException
	{
		ExcelReader.set_excel_file(Locations.testDataFilePath, "Submission_Data");

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.submission_applicant_name),
				ExcelReader.get_row_data_from_col("Applicant_Name", row_num));  

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.dba_info),
				ExcelReader.get_row_data_from_col("DBA", row_num)); 

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.program_name),
				ExcelReader.get_row_data_from_col("Program", row_num)); 

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.submission_id),
				ExcelReader.get_row_data_from_col("Submission_Id", row_num)); 

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.application_status),
				ExcelReader.get_row_data_from_col("Status", row_num));

		Assert.assertEquals(GenericMethods.is_attribtue_present(SubmissionPageLocators.policy_no, "innerHTML"),
				ExcelReader.get_row_data_from_col("Policy_No", row_num));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.submission_contact_name),
				ExcelReader.get_row_data_from_col("Contact_Name", row_num));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.underwriter),
				ExcelReader.get_row_data_from_col("Underwriter", row_num));



		log.info("<=====================Data Matched Successfully=====================> ");  

	}

	public static void verify_sold_submission_details_info(int row_num) throws IOException
	{
		ExcelReader.set_excel_file(Locations.testDataFilePath, "Submission_Data");

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.submission_applicant_name),
				ExcelReader.get_row_data_from_col("Applicant_Name", row_num));  

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.dba_info),
				ExcelReader.get_row_data_from_col("DBA", row_num)); 

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.program_name),
				ExcelReader.get_row_data_from_col("Program", row_num)); 

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.submission_id),
				ExcelReader.get_row_data_from_col("Submission_Id", row_num)); 

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.application_status),
				ExcelReader.get_row_data_from_col("Status", row_num));

		Assert.assertEquals(GenericMethods.is_attribtue_present(SubmissionPageLocators.policy_no, "innerHTML"),
				ExcelReader.get_row_data_from_col("Policy_No", row_num));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.submission_contact_name),
				ExcelReader.get_row_data_from_col("Contact_Name", row_num));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.underwriter),
				ExcelReader.get_row_data_from_col("Underwriter", row_num));



		log.info("<=====================Data Matched Successfully=====================> ");  

	}

	//======================>Method to review submission information<===========================================

	public static void verify_submisson_info(int row_num1, int row_num2) throws IOException, InterruptedException
	{
		WaitMethods.wait_for_element_present(SubmissionPageLocators.submissionTableRow);
		GenericMethods.click_Element_Using_JS(SubmissionPageLocators.submissionTableRow);
		WaitMethods.wait_in_seconds(2);
		GenericMethods.click_Element_Using_JS(SubmissionPageLocators.select_review_submission);
		WaitMethods.wait_in_seconds(5);
		GenericMethods.navigate_to_next_window();
		ExcelReader.set_excel_file(Locations.testDataFilePath, "Submission_Data");

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_submission_id),
				ExcelReader.get_row_data_from_col("Submission_Id", row_num1));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_contact),
				ExcelReader.get_row_data_from_col("Contact_Name", row_num1));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_agencyname),
				ExcelReader.get_row_data_from_col("Agency", row_num1));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_phone),
				ExcelReader.get_row_data_from_col("Phone", row_num1));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_email),
				ExcelReader.get_row_data_from_col("Email", row_num1));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_subproducercode),
				ExcelReader.get_row_data_from_col("Sub Producer Code", row_num1));

		//======================>Verifying application Information information on review Page<===========================================
		ExcelReader.set_excel_file(Locations.testDataFilePath, "Applicant_Information");

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_submission_type),
				ExcelReader.get_row_data_from_col("Submission_Type", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_appname),
				ExcelReader.get_row_data_from_col("ApplicantName", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_dbaname),
				ExcelReader.get_row_data_from_col("DBAName", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_state),
				ExcelReader.get_row_data_from_col("State", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_zipcode),
				ExcelReader.get_row_data_from_col("ZipCode", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_territory),
				ExcelReader.get_row_data_from_col("Territory", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_licence_needed),
				ExcelReader.get_row_data_from_col("ReviewLicenseNeeded", 2));

		//======================>Verifying General Liability Rating Criteria on review Page<=========================================== 
		ExcelReader.set_excel_file(Locations.testDataFilePath, "General_Liability_RC");

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_limitsof_insurance),
				ExcelReader.get_row_data_from_col("Limits of Insurance", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_deductible),
				ExcelReader.get_row_data_from_col("Deductible", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_owners_active),
				ExcelReader.get_row_data_from_col("Owners - Active in Field", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_parttime_emp),
				ExcelReader.get_row_data_from_col("Part Time Employees", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_fulltime_emp),
				ExcelReader.get_row_data_from_col("Full Time Employees", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_fulltime_emp),
				ExcelReader.get_row_data_from_col("Full Time Employees", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_totalemp_payroll),
				ExcelReader.get_row_data_from_col("Employees Payroll", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_leased_emp_payroll),
				ExcelReader.get_row_data_from_col("Casual laborers, leased employees, and labor pool personnel", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_payroll_assigned),
				ExcelReader.get_row_data_from_col("Payroll Assigned", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_subcontracting_cost),
				ExcelReader.get_row_data_from_col("Subcontracting Costs", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_annualgross_receipt),
				ExcelReader.get_row_data_from_col("Annual Gross Receipts", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_experience_history),
				ExcelReader.get_row_data_from_col("Applicant’s Business Experience /Insurance History", row_num2));

		//======================>Verifying Optional Coverage Data on review Page<=========================================== 
		ExcelReader.set_excel_file(Locations.testDataFilePath, "Optional_Coverages");

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_asrendorsement),
				ExcelReader.get_row_data_from_col("ASR Endorsement", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_stopgap_liability),
				ExcelReader.get_row_data_from_col("Stop Gap Employers Liability", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_perproject_aggregate),
				ExcelReader.get_row_data_from_col("per-project-aggregate", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_empbenefirs_liability),
				ExcelReader.get_row_data_from_col("employee-bebefits", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_tr_actionover),
				ExcelReader.get_row_data_from_col("action-over", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_tr_classlimitation),
				ExcelReader.get_row_data_from_col("classification-limitation", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_abandoned_work),
				ExcelReader.get_row_data_from_col("prior-completed", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_subsident_exclusion),
				ExcelReader.get_row_data_from_col("subsidence-exclusion", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_insured_endoresement),
				ExcelReader.get_row_data_from_col("insured-endorsement", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_errorsandomissions),
				ExcelReader.get_row_data_from_col("workmanship-coverage", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_inland_marine),
				ExcelReader.get_row_data_from_col("small-equipment-coverage", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_available_policycredits),
				ExcelReader.get_row_data_from_col("available-policy-credits", row_num2));

		//======================>Reviewing the Common Eligibility Questions<===========================================
		ExcelReader.set_excel_file(Locations.testDataFilePath, "Common_Eligibility");

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_ceq_question1),
				ExcelReader.get_row_data_from_col("Radio_Btn_1", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_ceq_question2),
				ExcelReader.get_row_data_from_col("Radio_Btn_3", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_ceq_question3),
				ExcelReader.get_row_data_from_col("Radio_Btn_5", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_ceq_question4),
				ExcelReader.get_row_data_from_col("Radio_Btn_7", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_ceq_question5),
				ExcelReader.get_row_data_from_col("Radio_Btn_9", row_num2)); 

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_ceq_question6),
				ExcelReader.get_row_data_from_col("Radio_Btn_11", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_ceq_question7),
				ExcelReader.get_row_data_from_col("Radio_Btn_13", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_ceq_question8),
				ExcelReader.get_row_data_from_col("Radio_Btn_15", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_ceq_question9),
				ExcelReader.get_row_data_from_col("Radio_Btn_17", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_ceq_question10),
				ExcelReader.get_row_data_from_col("Radio_Btn_19", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_ceq_question11),
				ExcelReader.get_row_data_from_col("Radio_Btn_21", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_ceq_question12),
				ExcelReader.get_row_data_from_col("Radio_Btn_23", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_ceq_question13),
				ExcelReader.get_row_data_from_col("Radio_Btn_25", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_ceq_question14),
				ExcelReader.get_row_data_from_col("Radio_Btn_27", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_ceq_question15),
				ExcelReader.get_row_data_from_col("Radio_Btn_29", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_ceq_question16),
				ExcelReader.get_row_data_from_col("Radio_Btn_31", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_ceq_question17),
				ExcelReader.get_row_data_from_col("Radio_Btn_33", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_ceq_question18),
				ExcelReader.get_row_data_from_col("Radio_Btn_35", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_ceq_question19),
				ExcelReader.get_row_data_from_col("Radio_Btn_37", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_ceq_question20),
				ExcelReader.get_row_data_from_col("Radio_Btn_39", row_num2));

		//======================>Reviewing the Specific Eligibility Questions<===========================================
		ExcelReader.set_excel_file(Locations.testDataFilePath, "Specific_Eligibility");

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_seq_question1),
				ExcelReader.get_row_data_from_col("Radio_Btn_41", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_seq_question2),
				ExcelReader.get_row_data_from_col("Radio_Btn_43", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_seq_question3),
				ExcelReader.get_row_data_from_col("Radio_Btn_45", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_seq_question4),
				ExcelReader.get_row_data_from_col("Radio_Btn_47", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_seq_question5),
				ExcelReader.get_row_data_from_col("Radio_Btn_49", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_seq_question6),
				ExcelReader.get_row_data_from_col("Radio_Btn_51", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_seq_question7),
				ExcelReader.get_row_data_from_col("Radio_Btn_53", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_seq_question8),
				ExcelReader.get_row_data_from_col("Radio_Btn_55", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_seq_question9),
				ExcelReader.get_row_data_from_col("Radio_Btn_57", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_seq_question10),
				ExcelReader.get_row_data_from_col("Radio_Btn_59", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_seq_question11),
				ExcelReader.get_row_data_from_col("Radio_Btn_61", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_seq_question12),
				ExcelReader.get_row_data_from_col("Radio_Btn_63", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_seq_question13),
				ExcelReader.get_row_data_from_col("Radio_Btn_65", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_seq_question14),
				ExcelReader.get_row_data_from_col("Radio_Btn_67", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_seq_question15),
				ExcelReader.get_row_data_from_col("Radio_Btn_69", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_seq_question16),
				ExcelReader.get_row_data_from_col("Radio_Btn_71", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_seq_question17),
				ExcelReader.get_row_data_from_col("Radio_Btn_73", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_seq_question18),
				ExcelReader.get_row_data_from_col("Radio_Btn_75", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_seq_question19),
				ExcelReader.get_row_data_from_col("Radio_Btn_77", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_seq_question20),
				ExcelReader.get_row_data_from_col("Radio_Btn_79", row_num2));

		Assert.assertEquals(GenericMethods.get_text(SubmissionPageLocators.review_seq_question21),
				ExcelReader.get_row_data_from_col("Radio_Btn_81", row_num2));	      

		log.info("<=====================Data Matched Successfully=====================> ");  

	}
	
	public static void verify_theft_protection_field()
	{
		Assert.assertEquals(GenericMethods.boolean_is_element_present(SubmissionPageLocators.theft_protection), false);
		log.info("<=====================verifyed_theft_protection_field=====================> ");  
	}

}



















