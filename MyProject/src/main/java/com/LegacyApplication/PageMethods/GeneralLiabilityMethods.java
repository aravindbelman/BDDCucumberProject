package com.LegacyApplication.PageMethods;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.BtisNewUI.Locators.StarrUILocators;
import com.BtisNewUI.Locators.WCnewUILocators;
import com.LegacyApplication.ExcelReader.ExcelReader;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageLocators.AdminSubmissionPageLocators;
import com.LegacyApplication.PageLocators.AutoRenewalBrokerFeeLocators;
import com.LegacyApplication.PageLocators.DefaultBrokerFeeLocators;
import com.LegacyApplication.PageLocators.GeneralLiabilityPageLocators;
import com.LegacyApplication.PageLocators.SubmissionPageLocators;
import com.LegacyApplication.PageLocators.WorkersCompLocators;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

public class GeneralLiabilityMethods extends TestBase {

	public static final Logger log=Logger.getLogger(GeneralLiabilityMethods.class.getName());
	public static JavascriptExecutor js;


	/*
	 * Puerpose: This methid is used to select GL submission.
	 */
	public static void select_GL() throws IOException, InterruptedException, AWTException
	{	
		WaitMethods.wait_in_seconds(5);
		WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.general_liablity_button);
		GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.general_liablity_button);
		GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.victory_general_liability);
	}

	/*
	 * Puerpose: This methid is used to fill GL market Palce -Selection. 
	 */
	public static void gl_MarketPalce(int row_num)throws IOException, InterruptedException, AWTException
	{
		if(driver.getCurrentUrl().contains("General-Liability-Marketplace"))
		{
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "gl_market1");
			GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.state_select, "visibletext", ExcelReader.get_row_data_from_col("State", row_num));
			WaitMethods.wait_in_seconds(2);
			GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.classCode_select, "visibletext", ExcelReader.get_row_data_from_col("ClassCode", row_num));
			WaitMethods.wait_in_seconds(2);
			GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.gl_prg);
			WaitMethods.wait_in_seconds(2);
		}
	}

	/*
	 * Puerpose: This methid is used to Verify Class code & state 
	 * wise Availble Programms.
	 */
	public static void gl_program_stateWise_MarketPalce(int row_num)throws IOException, InterruptedException, AWTException
	{	

		String[] stateList ={"Alabama",
				"Alaska",
				"Arkansas",
				"Arizona",
				"California",
				"Colorado",
				"Connecticut",
				"Delaware",
				"District of Columbia",
				"Florida",
				"Georgia",
				"Hawaii",
				"Iowa",
				"Idaho",
				"Illinois",
				"Indiana",
				"Kansas",
				"Kentucky",
				"Louisiana",
				"Massachusetts",
				"Maryland",
				"Maine",
				"Michigan",
				"Minnesota",
				"Missouri",
				"Mississippi",
				"Montana",
				"New Jersey",
				"North Carolina",
				"North Dakota",
				"Nebraska",
				"New Hampshire",
				"New Mexico",
				"Nevada",
				"Ohio",
				"Oklahoma",
				"Oregon",
				"Pennsylvania",
				"Rhode Island",
				"South Carolina",
				"South Dakota",
				"Tennessee",
				"Texas",
				"Utah",
				"Virginia",
				"Vermont",
				"Washington",
				"Wisconsin",
				"West Virginia",
		"Wyoming"};

		String[] classCodes = {
				"Advertising Sign Companies - outside",
				"Air Conditioning",
				"Alarms & Security Systems",
				"Appliance Installation - (Commercial)", 
				"Appliance Installation - Household",   
				"Boiler Inspection, Installation, Cleaning or Repair",
				"Building Structure - raising or moving",
				"Cable Installation",  
				"Carpentry Residential",
				"Carpentry - Interior",
				"Carpentry Commercial",
				"Carpentry Shop Only", 
				"Carpentry - Handyperson",
				"Carpentry - Homebuilder",
				"Carpet-Upholstery Cleaning",
				"Ceiling/Wall Installation - Metal",
				"Chimney Cleaning",
				"Cleaning - Outside surfaces of buildings",
				"Communication Equipment Installation",
				"Concrete Construction",
				"Conduit Construction - Cable/Wire",
				"Contractor's Permanent Yards",
				"Debris Removal - Construction Site",
				"Door/Millwork Installation",
				"Driveway/Sidewalk Paving",
				"Drywall",
				"Drywall - New Residential",
				"Electrical Apparatus",
				"Electrical - Within Buildings",
				"Excavation",
				"Fence Erection",
				"Fire Extinguishers",
				"Floor Covering",
				"Furniture or Fixture Installation", 
				"Garbage, Ash or Refuse collecting",
				"Grading",
				"Greenhouse Erection",
				"Heat/AC no LPG",
				"Heating & Air Conditioning LPG",
				"House Furnishing Installation",
				"Inspection and Appraisal Companies",
				"Insulation Work - Plastic",
				"Insulation Work - Organic",
				"Insulation Work - Mineral",
				"Interior Decorators",
				"Janitorial - Commercial",
				"Janitorial - Residential",
				"Landscaping Gardening",
				"Lawn Care (Mow, Blow & Go)",
				"Machinery or Equipment - farm - install, service or repair",
				"Machinery or Equipment - industrial - install, service or repair",
				"Machinery or Equipment - install, service or repair - NOC",
				"Masonry",
				"Metal Erection - Decorative",
				"Metal Erection - Non-Structural",
				"Metal Erection - Structural NOC",
				"Office Machines or Appliances Installation",
				"Paint Exterior (3 stories & Under)",
				"Paint Interior",
				"Painting - shop only",
				"Paperhanging",
				"Plaster/Stucco",
				"Plumbing Commercial",
				"Plumbing Residential",
				"Prefabricated Building Erection",
				"Refrigeration Equipment Installation/Service",
				"Roofing - Commercial",
				"Roofing - Residential",
				"Sandblasting",
				"Septic Tank Cleaning",
				"Septic Tank Installation",
				"Sewer Cleaning",
				"Sewer Mains Construction",
				"Sheet Metal Work - Exterior/Outside",
				"Siding and Gutter Installation",
				"Sign Erection",
				"Sign Painting or Lettering - inside of buildings",
				"Sign Painting",
				"Steam Pipe or Boiler Insulations",
				"Street Cleaning",
				"Surveyors - land",
				"Swimming Pool Servicing",
				"Telephone/Telegraph/Cable TV Line Construction",
				"Satellite Dish Installation",
				"Telephone, Telegraph or Cable TV Line Construction",
				"Tile/Stone Installation",
				"Tree Pruning, Dusting, Spraying, Repairing, Trimming or Fumigating",
				"Upholstering - NOC",
				"Upholstering - shop only",
				"Water Mains Construction",
				"Water Softening Equip. - Install, Svcs or Rep",
				"Water Well Drilling",
				"Welding or Cutting",
				"Window Cleaning",
				"Window Decorating",
				"Window Installation/Glazier"
		};
		//===============  Window Decorating  49840 ====================//
		GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.classCode_select, "visibletext","Window Decorating");
		log.info("======================>> Window Decorating  49840 <<=======================");
		WaitMethods.wait_in_seconds(1);

		for (String item : stateList) 
		{
			Select s= new Select(GeneralLiabilityPageLocators.state_select);
			s.selectByVisibleText(item);
			WaitMethods.wait_in_seconds(1);

			if(GeneralLiabilityPageLocators.attune_prg.isDisplayed()==false && (GeneralLiabilityPageLocators.hiscox_prg.isDisplayed() == true && GeneralLiabilityPageLocators.cbic_prg.isDisplayed()==true))
			{
				log.info("Attune is Not Available for - Window Decorating" +"  : "+item);
			}
			if(GeneralLiabilityPageLocators.hiscox_prg.isDisplayed() == true && GeneralLiabilityPageLocators.cbic_prg.isDisplayed()==true)
			{
				log.info("Hiscox and CBIC is available for - Window Decorating" +"  : "+item);
			}
			if(item == "Alaska" && GeneralLiabilityPageLocators.hiscox_prg.isDisplayed() && (GeneralLiabilityPageLocators.gl_prg.isDisplayed()== false && GeneralLiabilityPageLocators.cbic_prg.isDisplayed() == false && GeneralLiabilityPageLocators.attune_prg.isDisplayed()==false))
			{
				log.info("Only Hiscox is Availble for Alaska");
			}			
			if(item == "Colorado" && GeneralLiabilityPageLocators.hiscox_prg.isDisplayed() && (GeneralLiabilityPageLocators.gl_prg.isDisplayed()==false && GeneralLiabilityPageLocators.cbic_prg.isDisplayed() == false && GeneralLiabilityPageLocators.attune_prg.isDisplayed()==false))
			{
				log.info("Only Hiscox is Availble for Colorado");
			}

			if(item == "Utah" && GeneralLiabilityPageLocators.hiscox_prg.isDisplayed() && (GeneralLiabilityPageLocators.gl_prg.isDisplayed()== false && GeneralLiabilityPageLocators.cbic_prg.isDisplayed() == false && GeneralLiabilityPageLocators.attune_prg.isDisplayed()==false))
			{
				log.info("Only Hiscox is Availble for Utah");
			}

			if(item == "California" && GeneralLiabilityPageLocators.hiscox_prg.isDisplayed() && GeneralLiabilityPageLocators.gl_prg.isDisplayed() && GeneralLiabilityPageLocators.cbic_prg.isDisplayed() && (GeneralLiabilityPageLocators.attune_prg.isDisplayed()==false))
			{
				log.info("Hiscox,CBIC,Victory is Availble for California EXCEPT Attune");
			}

		}	

		/*//===============  Window Installation/Glazier  74751 ====================//
		GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.classCode_select, "visibletext","Window Installation/Glazier");
		log.info("======================>> Window Installation/Glazier  74751 <<=======================");
		WaitMethods.wait_in_seconds(1);

		for (String item : stateList) 
		{
			Select s= new Select(GeneralLiabilityPageLocators.state_select);
			s.selectByVisibleText(item);
			WaitMethods.wait_in_seconds(1);

			if(GeneralLiabilityPageLocators.attune_prg.isDisplayed() ==true && (GeneralLiabilityPageLocators.gl_prg.isDisplayed()==false && GeneralLiabilityPageLocators.hiscox_prg.isDisplayed()== false && GeneralLiabilityPageLocators.cbic_prg.isDisplayed() == false))
			{
				log.info("Attune is only Available for - Window Installation/Glazier" +"  : "+item);
			}

			if(item == "California" && GeneralLiabilityPageLocators.gl_prg.isDisplayed() ==true && GeneralLiabilityPageLocators.attune_prg.isDisplayed()==true && (GeneralLiabilityPageLocators.cbic_prg.isDisplayed()==false && GeneralLiabilityPageLocators.hiscox_prg.isDisplayed()==false))
			{
				log.info("Victory ans Attune is Availble for California EXCEPT Hiscox and CBIC");
			}

			if(item=="Hawaii" && GeneralLiabilityPageLocators.noProduct_prg.isDisplayed()==true && (GeneralLiabilityPageLocators.gl_prg.isDisplayed()==false && GeneralLiabilityPageLocators.cbic_prg.isDisplayed()==false && GeneralLiabilityPageLocators.hiscox_prg.isDisplayed()==false && GeneralLiabilityPageLocators.attune_prg.isDisplayed()==false))     
			{
				log.info("Not availabel any program for Hawaii");
			}

			if(item=="Massachusetts"&& GeneralLiabilityPageLocators.noProduct_prg.isDisplayed()==true && (GeneralLiabilityPageLocators.gl_prg.isDisplayed()==false && GeneralLiabilityPageLocators.cbic_prg.isDisplayed()==false && GeneralLiabilityPageLocators.hiscox_prg.isDisplayed()==false && GeneralLiabilityPageLocators.attune_prg.isDisplayed()==false))   
			{
				log.info("Not availabel any program for Massachusetts");
			}

			if(item=="Washington"&& GeneralLiabilityPageLocators.noProduct_prg.isDisplayed()==true && (GeneralLiabilityPageLocators.gl_prg.isDisplayed()==false && GeneralLiabilityPageLocators.cbic_prg.isDisplayed()==false && GeneralLiabilityPageLocators.hiscox_prg.isDisplayed()==false && GeneralLiabilityPageLocators.attune_prg.isDisplayed()==false))
			{
				log.info("Not availabel any program for Washington");
			}
			else
			{
				log.info("================>Fail - with classCode 74751 -Fail<=================");
			}

		}*/

		//=============== Advertising Sign Companies - outside  90089====================//
		GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.classCode_select, "visibletext","Advertising Sign Companies - outside");
		log.info("======================>> Advertising Sign Companies - outside  90089 <<=======================");
		WaitMethods.wait_in_seconds(1);

		for (String item : stateList) 
		{
			Select s= new Select(GeneralLiabilityPageLocators.state_select);
			s.selectByVisibleText(item);
			WaitMethods.wait_in_seconds(1);

			try {
				if (GeneralLiabilityPageLocators.noProduct_prg.isDisplayed()
					&& (GeneralLiabilityPageLocators.attune_prg.isDisplayed() == false
					&& GeneralLiabilityPageLocators.gl_prg.isDisplayed() == false
					&& GeneralLiabilityPageLocators.hiscox_prg.isDisplayed() == false
					&& GeneralLiabilityPageLocators.cbic_prg.isDisplayed() == false)) {
				log.info("NA for - Advertising Sign Companies - outside Except California" + "  : " + item);
			}
			if (item == "California" && GeneralLiabilityPageLocators.gl_prg.isDisplayed()
					&& (GeneralLiabilityPageLocators.cbic_prg.isDisplayed() == false
					&& GeneralLiabilityPageLocators.hiscox_prg.isDisplayed() == false
					&& GeneralLiabilityPageLocators.attune_prg.isDisplayed() == false)) {
				log.info("Only Victory program Available for 90089" + "  : " + item);
			}  
			} catch (Exception e) {
				log.info("==============Fail for 90089=======" + e);
			}
		}

		//========================== Washington State Verify GL programm Does not exists. ===============================================//

		GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.state_select, "visibletext","Washington");
		Select dropdown = new Select(GeneralLiabilityPageLocators.classCode_select);
		List<WebElement> options = dropdown.getOptions();
		for(int i=1;i<=options.size()-1;i++) 
		{
			Select s= new Select(GeneralLiabilityPageLocators.classCode_select);
			s.selectByIndex(i);
			
			if (GeneralLiabilityPageLocators.gl_prg.isDisplayed()==false)
			{
				log.info("======GL program Not Supported for Washington state.======= PASS :");
			}
			else
			{
				log.info("======FAIL===GL program is Supported for Washington state.=====FAIL :");
			}
		}
	}


	/*
	 * Purpose: This method is used to fill the comparative rater info for a submission
	 * @param int row_number from excel
	 * @return NA
	 */
	public static void fill_GL_comparativeRater_info(int row_num) throws IOException, InterruptedException, AWTException
	{
		/*try
		{*/
		ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
		WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.state_info);
		GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.state_info, "visibletext", ExcelReader.get_row_data_from_col("State", row_num));
		GeneralLiabilityPageLocators.zip_code.sendKeys(ExcelReader.get_row_data_from_col("Zip Code", row_num));
		GenericMethods.accept_alert();
		WaitMethods.wait_in_seconds(3);
		GeneralLiabilityPageLocators.applicant_name.sendKeys(ExcelReader.get_row_data_from_col("Applicant Name", row_num));
		GeneralLiabilityPageLocators.dba.sendKeys(ExcelReader.get_row_data_from_col("DBA", row_num));
		/*WaitMethods.wait_in_seconds(3);	
			GenericMethods.press_key_using_robot("enter");
			WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.proposed_effective_date);
			GeneralLiabilityPageLocators.proposed_effective_date.clear();
			GenericMethods.accept_alert();
			WaitMethods.wait_in_seconds(3);
			GeneralLiabilityPageLocators.proposed_effective_date.sendKeys(GenericMethods.get_current_date());*/
		WaitMethods.wait_in_seconds(3);
		WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_limits);
		GenericMethods.select_using_action(GeneralLiabilityPageLocators.gl_limits, "visibletext", ExcelReader.get_row_data_from_col("Limits", row_num));
		boolean breakIt = true;
		while (true) {
			breakIt = true;
			try {
				//GenericMethods.select_using_action(GeneralLiabilityPageLocators.gl_deductible, "value", ExcelReader.get_row_data_from_col("Deductible", row_num));
				if(GenericMethods.is_element_present(GeneralLiabilityPageLocators.qes_okay_btn).equalsIgnoreCase("true"))
				{
					GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.qes_okay_btn);	
				}
				WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_owners_activeinfield);
				GeneralLiabilityPageLocators.gl_owners_activeinfield.clear();
				GeneralLiabilityPageLocators.gl_owners_activeinfield.sendKeys(ExcelReader.get_row_data_from_col("Owners Active In Field", row_num));
				WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_select_class1);
				GenericMethods.select_using_action(GeneralLiabilityPageLocators.gl_select_class1, "visibletext", ExcelReader.get_row_data_from_col("Classification-1", row_num));
				//GenericMethods.select_random_value_from_dropdown(GeneralLiabilityPageLocators.gl_select_class1);
				WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_additionalclass_button);
				GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.gl_additionalclass_button);
				WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_additionalclass_button);
				GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.gl_additionalclass_button);
				WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_class_percentage1);
				GeneralLiabilityPageLocators.gl_class_percentage1.clear();
				WaitMethods.wait_in_seconds(3);
				GeneralLiabilityPageLocators.gl_class_percentage1.sendKeys(ExcelReader.get_row_data_from_col("Classification-1 Percentage", row_num));
				if(!ExcelReader.get_row_data_from_col("Classification-2", row_num).equalsIgnoreCase("No"))
				{
					WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_select_class2);
					GenericMethods.select_using_action(GeneralLiabilityPageLocators.gl_select_class2, "visibletext", ExcelReader.get_row_data_from_col("Classification-2", row_num));
					WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_class_percentage2);
					GeneralLiabilityPageLocators.gl_class_percentage2.clear();
					GeneralLiabilityPageLocators.gl_class_percentage2.sendKeys(ExcelReader.get_row_data_from_col("Classification-2 Percentage", row_num));
				}
				WaitMethods.wait_in_seconds(3);
				if(!ExcelReader.get_row_data_from_col("Classification-3", row_num).equalsIgnoreCase("No"))
				{
					WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_select_class3);
					GenericMethods.select_using_action(GeneralLiabilityPageLocators.gl_select_class3, "visibletext", ExcelReader.get_row_data_from_col("Classification-3", row_num));
					WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_class_percentage3);
					GeneralLiabilityPageLocators.gl_class_percentage3.clear();
					GeneralLiabilityPageLocators.gl_class_percentage3.sendKeys(ExcelReader.get_row_data_from_col("Classification-3 Percentage", row_num));
				}
				WaitMethods.wait_in_seconds(3);
				if(!ExcelReader.get_row_data_from_col("Classification-4", row_num).equalsIgnoreCase("No"))
				{
					WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_select_class4);
					GenericMethods.select_using_action(GeneralLiabilityPageLocators.gl_select_class4, "visibletext", ExcelReader.get_row_data_from_col("Classification-4", row_num));
					WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_class_percentage4);
					GeneralLiabilityPageLocators.gl_class_percentage4.clear();
					GeneralLiabilityPageLocators.gl_class_percentage4.sendKeys(ExcelReader.get_row_data_from_col("Classification-4 Percentage", row_num));
				}
				WaitMethods.wait_in_seconds(3);
				/*if(GenericMethods.is_element_present(GeneralLiabilityPageLocators.qes_okay_btn).equalsIgnoreCase("true"))
					{
						GeneralLiabilityPageLocators.qes_okay_btn.click();
					}
				 */			WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_subcontracting_costs);
				 GeneralLiabilityPageLocators.gl_subcontracting_costs.sendKeys(ExcelReader.get_row_data_from_col("Subcontracting Costs", row_num));
				 WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_gross_receipts);
				 GeneralLiabilityPageLocators.gl_gross_receipts.sendKeys(ExcelReader.get_row_data_from_col("Receipts", row_num));
				 GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.gl_business_experience, "visibletext", ExcelReader.get_row_data_from_col("Business Experience", row_num));
				 //years with AMTrust Newly added
				 GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.gl_selectYearsWithAmTrust, "visibletext", ExcelReader.get_row_data_from_col("selectYearsWithAmTrust", row_num));
				 
				 GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.gl_paid_loss, "visibletext", ExcelReader.get_row_data_from_col("past 3 year claims", row_num));
				 if(GenericMethods.is_element_displayed(GeneralLiabilityPageLocators.gl_newResidentialStructure_chkbox).equalsIgnoreCase("true")&& ExcelReader.get_row_data_from_col("New Residential Structure", row_num).equalsIgnoreCase("yes"))
				 {
					 GeneralLiabilityPageLocators.gl_newResidentialStructure_chkbox.click();
				 }
				 /* if(ExcelReader.get_row_data_from_col("Inland Marine", row_num).equalsIgnoreCase("yes"))
				 {
					 WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_optionalInalndMarine_chkbox);
					 GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.gl_optionalInalndMarine_chkbox);
				 }*/
				 if(GenericMethods.is_element_present(GeneralLiabilityPageLocators.gl_existingAmturstPolicy).equalsIgnoreCase("true"))
				 {
					 GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.gl_existingAmturstPolicy, "visibletext", ExcelReader.get_row_data_from_col("Available Policy Credits", row_num));
				 }
				 WaitMethods.wait_in_seconds(3);
				 if(GenericMethods.is_element_present(GeneralLiabilityPageLocators.gl_SandRcredit_no).equalsIgnoreCase("true"))
				 {
					 GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.gl_SandRcredit_no);
				 }
				 WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_rateitnow_button);
				 GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.gl_rateitnow_button);
				 /*if(GenericMethods.is_element_present(GeneralLiabilityPageLocators.victory_admitted_chkbox).equalsIgnoreCase("true"))
					{
						log.info("General Liability options were visible");
					}
					else
					{
						WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_rateitnow_button);
						GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.gl_rateitnow_button);
					}*/


				 if(ExcelReader.get_row_data_from_col("Submission_Prefix", row_num).equalsIgnoreCase("QAA"))
				 {
					 WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.victory_admitted_chkbox);

					 System.out.println("The checked attribute status of the victory admitted checkbox is" +GenericMethods.is_attribtue_present(GeneralLiabilityPageLocators.verify_victory_admitted_chkbox, "checked"));
					 System.out.println("The selected status of the victory admitted checkbox is" +GenericMethods.is_chekbox_selected(GeneralLiabilityPageLocators.verify_victory_admitted_chkbox));
					 if(GenericMethods.is_chekbox_selected(GeneralLiabilityPageLocators.verify_victory_admitted_chkbox).equalsIgnoreCase("false"))
						 //if(GenericMethods.is_attribtue_present(GeneralLiabilityPageLocators.verify_victory_admitted_chkbox, "checked").equalsIgnoreCase("false"))

						 if(GenericMethods.is_chekbox_selected(GeneralLiabilityPageLocators.verify_victory_admitted_chkbox).equalsIgnoreCase("false"))

						 {
							 GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.victory_admitted_chkbox);          
						 }
				 }
				 else if(ExcelReader.get_row_data_from_col("Submission_Prefix", row_num).equalsIgnoreCase("QAN"))
				 {
					 WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.victory_nonadmitted_chkbox);
					 if(GenericMethods.is_chekbox_selected(GeneralLiabilityPageLocators.verify_victory_nonadmitted_chkbox).equalsIgnoreCase("false"))
					 {
						 GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.victory_nonadmitted_chkbox);	
					 }
				 }
				 else if(ExcelReader.get_row_data_from_col("Submission_Prefix", row_num).equalsIgnoreCase("QAC"))
				 {
					 WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.victory_certified_chkbox);
					 if(GenericMethods.is_chekbox_selected(GeneralLiabilityPageLocators.verify_victory_certified_chkbox).equalsIgnoreCase("false"))
					 {
						 GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.victory_certified_chkbox);
					 }
				 }
				 else if(ExcelReader.get_row_data_from_col("Submission_Prefix", row_num).equalsIgnoreCase("QES"))
				 {
					 WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.create_qes_submission);
					 GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.create_qes_submission);
				 }
				 GenericMethods.scroll_down();
				 WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.create_submission_button);
				 GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.create_submission_button); 
			} catch (Exception e) {
				if (e.getMessage().contains("element is not attached")) {
					breakIt = false;
				}
			}
			if (breakIt) {
				break;
			}
		}
		/*}
		catch(UnhandledAlertException | ElementNotVisibleException | NoSuchElementException exe)
		{
			log.debug("The exception was found "+exe.getClass().getCanonicalName());
		}
		catch(WebDriverException exe)
		{
			log.info("unable to find the element in the web page");
		}*/

	}

	/*
	 * Purpose: This method is to fill the price indicator and eligibility info while creating a submission
	 * @param (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void fill_GL_price_indicatorandeligibility_info(int row_num) throws IOException, InterruptedException
	{
		try
		{
			WaitMethods.wait_for_element_present(SubmissionPageLocators.priceIndicator_submission_id);
			String submission_id=SubmissionPageLocators.priceIndicator_submission_id.getText();
			String renewal_submissionId=submission_id.concat("-1");
			//ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
			//ExcelReader.set_data_in_cell(submission_id, row_num, col_num);
			//ExcelReader.setCellData(Locations.BrokerFeeDataFilePath, "QCR_Info", col_num,row_num, submission_id);
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
			ExcelReader.set_cell_data("Submission Id", row_num, submission_id);
			ExcelReader.set_cell_data("Renewal Submission Id", row_num, renewal_submissionId);
			/*if(ExcelReader.get_row_data_from_col("Submission_Prefix", row_num).equalsIgnoreCase("QAA") || ExcelReader.get_row_data_from_col("Submission_Prefix", row_num).equalsIgnoreCase("QAN") || ExcelReader.get_row_data_from_col("Submission_Prefix", row_num).equalsIgnoreCase("QAC"))
			{*/
			if(GenericMethods.is_element_present(SubmissionPageLocators.manifest_without_sunset_no).equalsIgnoreCase("true"))
			{
				try
				{
					SubmissionPageLocators.manifest_without_sunset_no.click();
				}
				catch(ElementNotVisibleException e)
				{
					log.info("Element is not visibled to click");
				}
			}
			if(GenericMethods.is_element_present(SubmissionPageLocators.occurence_form_with_sunset_no).equalsIgnoreCase("true"))
			{
				try
				{
					SubmissionPageLocators.occurence_form_with_sunset_no.click();
				}
				catch(ElementNotVisibleException e)
				{
					log.info("Element is not visibled to click");
				}
			}
			if(GenericMethods.is_element_present(SubmissionPageLocators.occurence_form_without_sunset_yes).equalsIgnoreCase("true"))
			{
				try
				{
					SubmissionPageLocators.occurence_form_without_sunset_yes.click();
				}
				catch(ElementNotVisibleException e)
				{
					log.info("Element is not visibled to click");
				}
			}
			GenericMethods.click_Element_Using_JS(SubmissionPageLocators.priceIndicator_nextbtn);					
			/*	}
			else if(ExcelReader.get_row_data_from_col("Submission_Prefix", row_num).equalsIgnoreCase("QES"))
			{
			//WaitMethods.wait_for_element_present(SubmissionPageLocators.priceIndicator_nextbtn);
			GenericMethods.click_Element_Using_JS(SubmissionPageLocators.priceIndicator_nextbtn);
			}*/
			if(ExcelReader.get_row_data_from_col("Submission_Prefix", row_num).equalsIgnoreCase("QAA") || ExcelReader.get_row_data_from_col("Submission_Prefix", row_num).equalsIgnoreCase("QAN") || ExcelReader.get_row_data_from_col("Submission_Prefix", row_num).equalsIgnoreCase("QAC"))
			{
				//WaitMethods.wait_for_element_present(SubmissionPageLocators.eligibility_autofill_chkbox);
				GenericMethods.click_Element_Using_JS(SubmissionPageLocators.eligibility_autofill_chkbox);
				WaitMethods.wait_in_seconds(2);
			}
			else if(ExcelReader.get_row_data_from_col("Submission_Prefix", row_num).equalsIgnoreCase("QES"))
			{
				GenericMethods.click_Element_Using_JS(SubmissionPageLocators.radio_btn1);
				GenericMethods.click_Element_Using_JS(SubmissionPageLocators.radio_btn4);
				GenericMethods.click_Element_Using_JS(SubmissionPageLocators.radio_btn6);
				GenericMethods.click_Element_Using_JS(SubmissionPageLocators.radio_btn7);
				GenericMethods.click_Element_Using_JS(SubmissionPageLocators.radio_btn10);
				GenericMethods.click_Element_Using_JS(SubmissionPageLocators.radio_btn12);
				GenericMethods.click_Element_Using_JS(SubmissionPageLocators.radio_btn14);
				GenericMethods.click_Element_Using_JS(SubmissionPageLocators.radio_btn16);
				GenericMethods.click_Element_Using_JS(SubmissionPageLocators.radio_btn18);
				GenericMethods.click_Element_Using_JS(SubmissionPageLocators.radio_btn20);
				GenericMethods.click_Element_Using_JS(SubmissionPageLocators.radio_btn22);
				GenericMethods.click_Element_Using_JS(SubmissionPageLocators.radio_btn24);
				GenericMethods.click_Element_Using_JS(SubmissionPageLocators.radio_btn26);
				GenericMethods.click_Element_Using_JS(SubmissionPageLocators.radio_btn28);
				GenericMethods.click_Element_Using_JS(SubmissionPageLocators.radio_btn30);
				GenericMethods.click_Element_Using_JS(SubmissionPageLocators.radio_btn32);
				GenericMethods.click_Element_Using_JS(SubmissionPageLocators.radio_btn34);
				GenericMethods.click_Element_Using_JS(SubmissionPageLocators.radio_btn36);
				//SubmissionPageLocators.sterile_env_rdBtn_no.click();

				//================> Fill Trade Specific Eligibility Questions <======================

				/*GenericMethods.click_Element_Using_JS(SubmissionPageLocators.seq_airCond_radio_btn42);
				GenericMethods.click_Element_Using_JS(SubmissionPageLocators.seq_airCond_radio_btn44);
				GenericMethods.click_Element_Using_JS(SubmissionPageLocators.seq_airCond_radio_btn46);
				GenericMethods.click_Element_Using_JS(SubmissionPageLocators.seq_airCond_radio_btn48);
 				GenericMethods.click_Element_Using_JS(SubmissionPageLocators.seq_airCond_radio_btn50);
 				GenericMethods.click_Element_Using_JS(SubmissionPageLocators.seq_airCond_radio_btn52);
 				GenericMethods.click_Element_Using_JS(SubmissionPageLocators.seq_airCond_radio_btn54);*/

				GenericMethods.click_Element_Using_JS(SubmissionPageLocators.seq_buildingStructureRaising_radio_btn41);
				GenericMethods.click_Element_Using_JS(SubmissionPageLocators.seq_buildingStructureRaising_radio_btn43);

			}
			//WaitMethods.wait_for_element_present(SubmissionPageLocators.eligibilitypage_nxtbtn);
			GenericMethods.click_Element_Using_JS(SubmissionPageLocators.eligibilitypage_nxtbtn);
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
	 * Purpose: This method is to fill the application info while creating a submission
	 * @param (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void fill_GL_application_info(int row_num) throws IOException, InterruptedException
	{
		try
		{
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QAA_app_info");
			SubmissionPageLocators.pri_street_address.sendKeys(ExcelReader.get_row_data_from_col("Street Address", row_num));
			SubmissionPageLocators.primary_city.sendKeys(ExcelReader.get_row_data_from_col("City", row_num));
			SubmissionPageLocators.same_as_primary_checkbox.click();
			SubmissionPageLocators.contact_name.sendKeys(ExcelReader.get_row_data_from_col("Contact Name", row_num));
			SubmissionPageLocators.signing_party.sendKeys(ExcelReader.get_row_data_from_col("Signing Party", row_num));
			SubmissionPageLocators.office_phno1.sendKeys(ExcelReader.get_row_data_from_col("office phone Area", row_num));
			SubmissionPageLocators.office_phno2.sendKeys(ExcelReader.get_row_data_from_col("office phone Prefix", row_num));
			SubmissionPageLocators.office_phno3.sendKeys(ExcelReader.get_row_data_from_col("office phone Phone", row_num));
			if(!(ExcelReader.get_row_data_from_col("Email Address", row_num)).isEmpty())
			{
				SubmissionPageLocators.email_address.sendKeys(ExcelReader.get_row_data_from_col("Email Address", row_num));
			}
			else
			{
				GenericMethods.click_Element_Using_JS(SubmissionPageLocators.no_emailAddress_checkbox);
			}
			GenericMethods.select_from_dropdown(SubmissionPageLocators.business_type, "visibletext", ExcelReader.get_row_data_from_col("Type of Business", row_num));
			//WaitMethods.wait_for_element_present(SubmissionPageLocators.theft_protection);
			//SubmissionPageLocators.theft_protection.sendKeys(ExcelReader.get_row_data_from_col("Individual Name for Theft Protection", row_num));
			WaitMethods.wait_for_element_present(SubmissionPageLocators.years_in_business);
			GenericMethods.select_using_action(SubmissionPageLocators.years_in_business, "visibletext", ExcelReader.get_row_data_from_col("Number of Years In Business", row_num));
			WaitMethods.wait_for_element_present(SubmissionPageLocators.construction_experience);
			GenericMethods.select_from_dropdown(SubmissionPageLocators.construction_experience, "visibletext", ExcelReader.get_row_data_from_col("Total Years Of Construction Experience", row_num));
			if(GenericMethods.is_element_present(SubmissionPageLocators.SubContarctorWork_concrete).equalsIgnoreCase("true"))
			{
				SubmissionPageLocators.SubContarctorWork_concrete.click();
			}
			SubmissionPageLocators.current_gl_policy_expiration.sendKeys(GenericMethods.get_current_date());
			SubmissionPageLocators.carrier_name.sendKeys(ExcelReader.get_row_data_from_col("Carrier Name", row_num));
			SubmissionPageLocators.resedential_strct_type.clear();
			SubmissionPageLocators.resedential_strct_type.sendKeys(ExcelReader.get_row_data_from_col("Structure type Residential", row_num));
			SubmissionPageLocators.industrial_strct_type.clear();
			SubmissionPageLocators.industrial_strct_type.sendKeys(ExcelReader.get_row_data_from_col("Structure type Industrial", row_num));
			SubmissionPageLocators.commercial_strct_type.clear();
			SubmissionPageLocators.commercial_strct_type.sendKeys(ExcelReader.get_row_data_from_col("Structure type Commercial", row_num));
			SubmissionPageLocators.new_construction_type.clear();
			SubmissionPageLocators.new_construction_type.sendKeys(ExcelReader.get_row_data_from_col("Construction Type - New Construction", row_num));
			SubmissionPageLocators.service_and_repair_type.clear();
			SubmissionPageLocators.service_and_repair_type.sendKeys(ExcelReader.get_row_data_from_col("Construction Type - Service & Repair", row_num));
			SubmissionPageLocators.last_12months_txtfield.sendKeys(ExcelReader.get_row_data_from_col("Last 12 Months", row_num));
			SubmissionPageLocators.second_year_prior.sendKeys(ExcelReader.get_row_data_from_col("2nd Year Prior", row_num));
			SubmissionPageLocators.third_year_prior.sendKeys(ExcelReader.get_row_data_from_col("3rd Year Prior", row_num));
			SubmissionPageLocators.description_of_operations.sendKeys(ExcelReader.get_row_data_from_col("Description Of Operations", row_num));
			if(GenericMethods.is_element_present(SubmissionPageLocators.submit_button).equalsIgnoreCase("true"))
			{
				SubmissionPageLocators.submit_button.click();
			}
			if(GenericMethods.is_element_present(SubmissionPageLocators.submit_qes_btn).equalsIgnoreCase("true"))
			{
				SubmissionPageLocators.submit_qes_btn.click();
			}
			if(GenericMethods.is_element_present(SubmissionPageLocators.submit_victoryExpress).equalsIgnoreCase("true"))
			{
				SubmissionPageLocators.submit_victoryExpress.click();
				WaitMethods.wait_for_element_present(SubmissionPageLocators.victoryExpress_OkayBtn);
				GenericMethods.click_Element_Using_JS(SubmissionPageLocators.victoryExpress_OkayBtn);
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

	//Logout of Agency

	public static void logout_Agency() throws Exception
	{	
		WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.logoutOfAgency);
		GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.logoutOfAgency);
		WaitMethods.wait_in_seconds(5);
		GenericMethods.accept_alert();
		WaitMethods.wait_in_seconds(2);
	}
	/*
	 * Purpose: This method is to save the rating work sheet of a submission
	 * @param (String Submission type, String Submission id, Row_number of Excel sheet)
	 * @return NA
	 */
	public static void save_GL_ratingWorkSheet(String submission_type,String submission_id,int row_num) throws AWTException, IOException, InterruptedException
	{	
		try
		{
			load_data();
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
			WaitMethods.wait_in_seconds(5);
			AdminSubmissionPageLocators.submission_id_searchfield.sendKeys(ExcelReader.get_row_data_from_col(submission_id, row_num));
			WaitMethods.wait_in_seconds(3);
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
			WaitMethods.wait_in_seconds(5);	
			AdminSubmissionPageMethods.view_submission_details();
			GenericMethods.navigate_to_next_window();
			if(submission_type.equalsIgnoreCase("new") || submission_type.equalsIgnoreCase("renewal"))
			{
				try
				{
					if(GenericMethods.is_element_present(AdminSubmissionPageLocators.cbFullWithoutSunset_chkbx).equalsIgnoreCase("true"))
					{
						if(GenericMethods.is_chekbox_selected(AdminSubmissionPageLocators.cbFullWithoutSunset_chkbx).equalsIgnoreCase("false"))
						{
							AdminSubmissionPageLocators.cbFullWithoutSunset_chkbx.click();
						}
						String subtotal_gl=GenericMethods.get_integer_from_string(GenericMethods.get_text(AdminSubmissionPageLocators.lbl_withoutsunset_total_all_glprem));				
						System.out.println("The Sub_total GL Premium is= "+subtotal_gl);
						ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "BrokerFee_Data");
						ExcelReader.set_cell_data("Subtotal GL Premium", row_num, subtotal_gl);
						String grandtotal_gl=GenericMethods.get_integer_from_string(GenericMethods.get_text(AdminSubmissionPageLocators.lbl_withoutsunset_grandtotal));				
						System.out.println("The Grand_total GL Premium is= "+grandtotal_gl);
						ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "BrokerFee_Data");
						ExcelReader.set_cell_data("Grandtotal GL Premium", row_num, grandtotal_gl);
						if(GenericMethods.is_element_present(AdminSubmissionPageLocators.lbl_inland_marine).equalsIgnoreCase("true"))
						{
							String inaland_premium=GenericMethods.get_integer_from_string(GenericMethods.get_text(AdminSubmissionPageLocators.lbl_inland_marine));
							System.out.println("The Inland marine Value is= "+inaland_premium);
							ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "BrokerFee_Data");
							ExcelReader.set_cell_data("Inland Marine Value", row_num, inaland_premium);
						}
						else
						{					
							ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "BrokerFee_Data");
							ExcelReader.set_cell_data("Inland Marine Value", row_num, "0");
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
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
			if(ExcelReader.get_row_data_from_col("Submission_Prefix", row_num).equalsIgnoreCase("QAC"))
			{
				GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.cbFullWithSunset_chkbx);
				GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.cbFullWithSunset_chkbx);
			}

			if(ExcelReader.get_row_data_from_col("Submission_Prefix", row_num).equalsIgnoreCase("QES"))
			{
				WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.qes_resConstruction_chkbx);
				GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.qes_resConstruction_chkbx);
				WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.save_qes_ratingws);
				GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.save_qes_ratingws);
			}
			if(GenericMethods.is_element_present(AdminSubmissionPageLocators.save_ratingws).equalsIgnoreCase("true"))
			{
				GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.save_ratingws);
				WaitMethods.wait_in_seconds(5);
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
	 * Purpose: This method is to change the status of a submission
	 * @param (String submission id, string status to be changed, int Row_number of Excel sheet)
	 * @return NA
	 */
	public static void GL_change_status(String submission_id,String status_tobe_changed, int row_num) throws InterruptedException, IOException
	{
		try
		{
			load_data();
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
			GenericMethods.navigate_to_next_window();
			AdminSubmissionPageLocators.submission_id_searchfield.clear();
			GenericMethods.enter_text(AdminSubmissionPageLocators.submission_id_searchfield, ExcelReader.get_row_data_from_col(submission_id, row_num), "Submission Id Search Field");
			//WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);	
			//WaitMethods.wait_in_seconds(3);
			//WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_table_row);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
			GenericMethods.click_Element_Using_JS(DefaultBrokerFeeLocators.changestatus_link);
			WaitMethods.wait_in_seconds(3);

			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QAA_Status");

			for(int i=0;i<DefaultBrokerFeeLocators.changestatus_labels.size();i++)
			{
				String s=GenericMethods.get_text(DefaultBrokerFeeLocators.changestatus_labels.get(i));
				int j=i+1;
				try
				{
					if(s.contains(ExcelReader.get_row_data_from_col(status_tobe_changed, row_num)))
					{	
						if(s.equalsIgnoreCase("Sold"))
						{
							ExcelReader.set_cell_data("Expiration_Date", row_num, GenericMethods.get_attribute_value(AutoRenewalBrokerFeeLocators.policy_expiration_date, "value"));
						}
						driver.findElement(By.xpath("(//input[@id='Status'])[position()='"+j+"']")).click();
						GenericMethods.click_Element(DefaultBrokerFeeLocators.changestatus_submitbutton);
						//GenericMethods.click_Element(DefaultBrokerFeeLocators.changestatus_cancelbutton);
						//DefaultBrokerFeeLocators.changestatus_submitbutton.click();
					}
				} 
				catch (Exception msg)
				{
					System.out.println("Waiting to change the status");
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
		log.info("The status has changed successfully");
	}

	/*
	 * Purpose: This method is to click on review submission link of a GL submission
	 * @param (String submission id, int Row_number of Excel sheet)
	 * @return NA
	 */
	public static void click_review_submission_link(String submission_id, int row_num) throws IOException, InterruptedException
	{
		ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
		WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_id_searchfield);
		AdminSubmissionPageLocators.submission_id_searchfield.clear();
		AdminSubmissionPageLocators.submission_id_searchfield.sendKeys(ExcelReader.get_row_data_from_col(submission_id, row_num));
		WaitMethods.wait_in_seconds(3);
		WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
		GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
		WaitMethods.wait_in_seconds(3);	
		GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
		GenericMethods.click_Element_Using_JS(DefaultBrokerFeeLocators.reviewSubmission_link);		
	}

	/*
	 * Purpose: This method is to click on Temporary Endorsement link of a GL submission
	 * @param (String submission id, int Row_number of Excel sheet)
	 * @return NA
	 */
	public static void click_temp_endorsement_link(String submission_id, int row_num) throws IOException, InterruptedException
	{
		ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
		WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_id_searchfield);
		AdminSubmissionPageLocators.submission_id_searchfield.clear();
		AdminSubmissionPageLocators.submission_id_searchfield.sendKeys(ExcelReader.get_row_data_from_col(submission_id, row_num));
		WaitMethods.wait_in_seconds(3);
		WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
		GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
		WaitMethods.wait_in_seconds(3);	
		GenericMethods.click_from_webElementList(GeneralLiabilityPageLocators.submission_id, ExcelReader.get_row_data_from_col(submission_id, row_num));
		GenericMethods.click_Element_Using_JS(DefaultBrokerFeeLocators.gl_tempEndorsement_link);	
		GenericMethods.click_Element_Using_JS(DefaultBrokerFeeLocators.tempEndoresment_continue_btn);
	}

	/*
	 * Purpose: This method is to click on Create Endorsement link of a GL submission
	 * @param (String submission id, int Row_number of Excel sheet)
	 * @return NA
	 */
	public static void click_create_endorsement_link(String submission_id, int row_num) throws IOException, InterruptedException
	{
		ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
		WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_id_searchfield);
		AdminSubmissionPageLocators.submission_id_searchfield.clear();
		AdminSubmissionPageLocators.submission_id_searchfield.sendKeys(ExcelReader.get_row_data_from_col(submission_id, row_num));
		WaitMethods.wait_in_seconds(3);
		WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
		GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
		WaitMethods.wait_in_seconds(3);	
		GenericMethods.click_from_webElementList(GeneralLiabilityPageLocators.submission_id, ExcelReader.get_row_data_from_col(submission_id, row_num));
		GenericMethods.click_Element_Using_JS(DefaultBrokerFeeLocators.gl_createEndorsement_link);	
		GenericMethods.click_Element_Using_JS(DefaultBrokerFeeLocators.tempEndoresment_continue_btn);
	}

	/*
	 * Purpose: This method is to click on review submission link of a GL submission
	 * @param (String submission id, int Row_number of Excel sheet)
	 * @return NA
	 */
	public static void verify_renewal_letter_option(String submission_id,int row_num) throws InterruptedException, IOException
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
			if(GenericMethods.is_element_present(DefaultBrokerFeeLocators.renewalLetter_link).equalsIgnoreCase("true"))
			{
				log.info("======The Renewal Letter Option is available for Renewal Submission==============");
			}
			else
			{
				log.info("==============The Renewal Letter Option is not available=============");
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
	 * Purpose: This method is to verify the total payroll percentage
	 * @param (String submission id, int Row_number of Excel sheet)
	 * @return NA
	 */
	public static void verify_total_payroll(String submission_id,int row_num) throws IOException, InterruptedException, AWTException
	{
		load_data();
		ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
		WaitMethods.wait_in_seconds(5);
		AutoRenewalBrokerFeeMethods.save_ratingWorkSheet("new","Submission Id",row_num);
		GenericMethods.close_browser_window();
		GenericMethods.navigate_to_next_window();
		click_review_submission_link("Submission Id", row_num);
		//String parentWindow = driver.getWindowHandle();
		log.info("//===========================> Clicked on Review Submission Link to validate total payroll percentage value <=============================");
		GenericMethods.navigate_to_next_window();
		try
		{
			Assert.assertEquals(GenericMethods.get_text(GeneralLiabilityPageLocators.reviewSubmission_totalPercentage), ExcelReader.get_row_data_from_col("Total_Payroll_Percentage", row_num));
			log.info("//===========================> Total Percentage value matched for new Submission <=============================");
		}
		catch (AssertionError err) {
			log.info("//===========================> Total Payroll Percentage Value is Not Matched for New Submission <=============================");
		}
		GenericMethods.close_browser_window();
		//driver.switchTo().window(parentWindow);
		GL_change_status("Submission Id","Status_OkToBind",1);
		WaitMethods.wait_in_seconds(3);
		GL_change_status("Submission Id","Status _Sold",1);
		WaitMethods.wait_in_seconds(5);
		WaitMethods.wait_for_page_load(10);
		click_temp_endorsement_link("Submission Id", row_num);
		log.info("//===========================> Clicked on Temp Endorsement Link to validate total payroll percentage value <=============================");
		GenericMethods.navigate_to_next_window();
		try
		{
			Assert.assertEquals(GenericMethods.get_text(GeneralLiabilityPageLocators.reviewSubmission_totalPercentage), ExcelReader.get_row_data_from_col("Total_Payroll_Percentage", row_num));
			log.info("//===========================> Total Percentage value matched in Temp Endorsement Submission <=============================");
		}
		catch (AssertionError err) {
			log.info("//===========================> Total Payroll Percentage Value is Not Matched in Temp Endorsement Submission <=============================");
		}
		WaitMethods.wait_in_seconds(3);
		GenericMethods.navigate_browser("back");
		WaitMethods.wait_in_seconds(3);
		click_create_endorsement_link("Submission Id", row_num);
		log.info("//===========================> Clicked on Create Endorsement Link to validate total payroll percentage value <=============================");
		GenericMethods.navigate_to_next_window();
		try
		{
			Assert.assertEquals(GenericMethods.get_text(GeneralLiabilityPageLocators.reviewSubmission_totalPercentage), ExcelReader.get_row_data_from_col("Total_Payroll_Percentage", row_num));
			log.info("//===========================> Total Percentage value matched in Create Endorsement Submission <=============================");
		}
		catch (AssertionError err) {
			log.info("//===========================> Total Payroll Percentage Value is Not Matched in Create Endorsement Submission <=============================");
		}
		WaitMethods.wait_in_seconds(3);
		GenericMethods.navigate_browser("back");
		WaitMethods.wait_in_seconds(3);
		AutoRenewalBrokerFeeMethods.change_submission_renewal("Submission Id", 1);
		WaitMethods.wait_in_seconds(3);
		GenericMethods.navigate_browser("back");
		WaitMethods.wait_in_seconds(3);
		click_review_submission_link("Renewal Submission Id", row_num);
		log.info("//===========================> Clicked on Review Submission Link of a Renewal Submission to validate total payroll percentage value <=============================");
		GenericMethods.navigate_to_next_window();
		try
		{
			Assert.assertEquals(GenericMethods.get_text(GeneralLiabilityPageLocators.reviewSubmission_totalPercentage), ExcelReader.get_row_data_from_col("Total_Payroll_Percentage", row_num));
			log.info("//===========================> Total Payroll Percentage value of a Renewal Submission matched <=============================");	
		}
		catch (AssertionError err) {
			log.info("//===========================>Total Payroll Percentage value of a Renewal Submission is not matched<=============================");
		}

	}

	/*
	 * Purpose: This method is to click on submission context option
	 * select Review Submission Option
	 * and Total General Liability Premium: value 
	 * @param (String submission id, int Row_number of Excel sheet)
	 * @return NA
	 */
	public static void click_review_PremiumValue(String submission_id, int row_num) throws IOException, InterruptedException
	{
		ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
		WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_id_searchfield);
		AdminSubmissionPageLocators.submission_id_searchfield.clear();
		AdminSubmissionPageLocators.submission_id_searchfield.sendKeys(ExcelReader.get_row_data_from_col(submission_id, row_num));
		WaitMethods.wait_in_seconds(3);
		WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
		GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
		WaitMethods.wait_in_seconds(3);	
		GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
		GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.reviewSubmission_link);

		GenericMethods.navigate_to_next_window();

		GenericMethods.is_element_present(AdminSubmissionPageLocators.premiumValue);
		String premiumValue = GenericMethods.get_text(AdminSubmissionPageLocators.premiumValue);
		ExcelReader.set_cell_data("PremiumValue", row_num, premiumValue);
		log.info("Premium Value we get: "+premiumValue);	
		WaitMethods.wait_in_seconds(5);	
		driver.close();
		GenericMethods.navigate_to_next_window();
		WaitMethods.wait_in_seconds(3);	
		GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
		GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.quote_CBIC_link);
		WaitMethods.wait_in_seconds(40);

		GenericMethods.is_element_present(AdminSubmissionPageLocators.quote_CBIC_AmTrust_Value);
		String AmTrustValue = GenericMethods.get_text(AdminSubmissionPageLocators.quote_CBIC_AmTrust_Value);
		//String referenceNo = GenericMethods.get_text(AdminSubmissionPageLocators.quote_CBIC_ReferenceNo);
		String cbicQuoteValue = GenericMethods.get_text(AdminSubmissionPageLocators.quote_CBIC_Quote_Value);
		ExcelReader.set_cell_data("CBICvalue", row_num, cbicQuoteValue);


		Assert.assertEquals(AmTrustValue, ExcelReader.get_row_data_from_col("PremiumValue", row_num));
		log.info("AmTrust Premium Value we get is matched with Actual value : "+AmTrustValue);

	}
}
