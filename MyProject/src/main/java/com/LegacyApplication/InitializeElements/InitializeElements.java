package com.LegacyApplication.InitializeElements;

import org.openqa.selenium.support.PageFactory;

import com.LegacyApplication.PageLocators.GeneralLiabilityPageLocators;
import com.LegacyApplication.PageLocators.HomePageLocators;
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
		}

	}

