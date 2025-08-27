package com.LegacyApplication.InitializeElements;

import org.openqa.selenium.support.PageFactory;

import com.BtisNewUI.Locators.CBICLocators;
import com.BtisNewUI.Locators.CBIC_NewLocators;
import com.BtisNewUI.Locators.ClearSpringLocators;
import com.BtisNewUI.Locators.GlDirectLocators;
import com.BtisNewUI.Locators.NEXT_UI_locators;
import com.BtisNewUI.Locators.RegistrationProcessLocators;
import com.BtisNewUI.Locators.StarrUILocators;
import com.BtisNewUI.Locators.WCnewUILocators;
import com.LegacyApplication.PageLocators.AdminPageLocators;
import com.LegacyApplication.PageLocators.AdminSubmissionPageLocators;
import com.LegacyApplication.PageLocators.AgencyMainMenuLocators;
import com.LegacyApplication.PageLocators.AutoRenewalBrokerFeeLocators;
import com.LegacyApplication.PageLocators.BondsLocators;
import com.LegacyApplication.PageLocators.BuildersRiskLocators;
import com.LegacyApplication.PageLocators.CommercialAutoLocators;
import com.LegacyApplication.PageLocators.DefaultBrokerFeeLocators;
import com.LegacyApplication.PageLocators.ExcessProgramRaterLocators;
import com.LegacyApplication.PageLocators.GeneralLiabilityPageLocators;
import com.LegacyApplication.PageLocators.HomePageLocators;
import com.LegacyApplication.PageLocators.InlandMarineLocators;
import com.LegacyApplication.PageLocators.KraftLakeWholesalerLocators;
import com.LegacyApplication.PageLocators.SubmissionPageLocators;
import com.LegacyApplication.PageLocators.WorkersCompLocators;
import com.LegacyApplication.TestBase.TestBase;

public class InitializeElements extends TestBase {
	
		
		public static void initialize_elements()
		{
			PageFactory.initElements(driver, HomePageLocators.class);
			PageFactory.initElements(driver, SubmissionPageLocators.class);
			PageFactory.initElements(driver, GeneralLiabilityPageLocators.class);
			PageFactory.initElements(driver, WorkersCompLocators.class);
			PageFactory.initElements(driver, AdminSubmissionPageLocators.class);
			PageFactory.initElements(driver, AdminPageLocators.class);
			PageFactory.initElements(driver, DefaultBrokerFeeLocators.class);
			PageFactory.initElements(driver, AutoRenewalBrokerFeeLocators.class);
			PageFactory.initElements(driver, BondsLocators.class);
			PageFactory.initElements(driver, InlandMarineLocators.class);
			PageFactory.initElements(driver, BuildersRiskLocators.class);
			PageFactory.initElements(driver, KraftLakeWholesalerLocators.class);
			PageFactory.initElements(driver, CommercialAutoLocators.class);
			PageFactory.initElements(driver, AgencyMainMenuLocators.class);
			PageFactory.initElements(driver, ExcessProgramRaterLocators.class);
			PageFactory.initElements(driver, GlDirectLocators.class);
			PageFactory.initElements(driver, StarrUILocators.class);
			PageFactory.initElements(driver,WCnewUILocators.class);
			PageFactory.initElements(driver,CBICLocators.class);
			PageFactory.initElements(driver,CBIC_NewLocators.class);
			PageFactory.initElements(driver,NEXT_UI_locators.class);
			PageFactory.initElements(driver,RegistrationProcessLocators.class);
			PageFactory.initElements(driver,ClearSpringLocators.class);
			
		}

	}

