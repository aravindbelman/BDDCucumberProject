package com.LegacyApplication.PageMethods;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.LegacyApplication.PageLocators.HomePageLocators;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.WaitMethods;

public class HomePageMethods extends TestBase {
	
	public static final Logger log=Logger.getLogger(HomePageMethods.class.getName());
	
	 public static void login_as_agency() 
     {
		
  	    HomePageLocators.homepagelogin.click();
		log.info("Clicked on Login tab and object is "+HomePageLocators.homepagelogin.toString());
		HomePageLocators.agencyCode.sendKeys("te026");
		log.info("Entered Agency Code and the object is "+HomePageLocators.agencyCode.toString());
		WaitMethods.wait_for_element_present(HomePageLocators.agencyPassword);
		HomePageLocators.agencyPassword.sendKeys("BCZ8105");
   	    log.info("Entered Agency Password and the object is "+HomePageLocators.agencyPassword.toString());
   	    WaitMethods.wait_for_page_load(10);
		HomePageLocators.loginButton.click();
		log.info("Clicked on Login button and object is "+HomePageLocators.loginButton.toString());
		log.debug("Login  successfully !!! ");
		
     }
	 
	 public static void login_as_admin() 
     {
		
		HomePageLocators.adminusername.sendKeys("abelman");
		log.info("Entered Admin Login and the object is "+HomePageLocators.adminusername.toString());
		HomePageLocators.adminpassword.sendKeys("Rocklin123");
   	    log.info("Entered Agency Password and the object is "+HomePageLocators.agencyPassword.toString());
		HomePageLocators.adminloginbutton.click();
		log.info("Clicked on Login button and object is "+HomePageLocators.loginButton.toString());
		WaitMethods.wait_for_page_load(10);
		log.debug("Login  successfully !!! ");
		
     }
	 
	// Method for selecting the agency contact
	 
		public static void select_agency_contact() {

			Select agyContact = new Select(HomePageLocators.contactinfo);
			List<WebElement> list = agyContact.getOptions();
			list.get(1).click();
			HomePageLocators.submitMobile.click();

		}



}
