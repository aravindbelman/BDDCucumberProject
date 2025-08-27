package com.LegacyApplication.PageLocators;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.LegacyApplication.TestBase.TestBase;

public class AdminPageLocators extends TestBase {
	
	public static WebDriver driver;
	public static final Logger log=Logger.getLogger(AdminPageLocators.class.getName());
	
	//===========================> Admin Landing Page Locators<========================
	
	@FindBy(xpath="//ul[@id='mainMenu']/li[3]/a[contains(text(), 'Admin Tasks')]")
	public static WebElement adminTasks_tab;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']/following::li/a[contains(text(), 'Agency Information - Edit')]")
	public static WebElement agencyInfoEdit_link;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']/following::li/a[contains(text(), 'Agency Information - View')]")
	public static WebElement agencyInfoView_link;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']/following::li/a[contains(text(), 'Add Zip Code')]")
	public static WebElement addZipCode_lin;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']/following::li/a[contains(text(), 'Configuration Settings')]")
	public static WebElement configurationSettings_link;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']/following::li/a[contains(text(), 'Download Contacts')]")
	public static WebElement downloadContacts_link;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']/following::li/a[contains(text(), 'Inspections Maintenance')]")
	public static WebElement inspectionsMaintenance_link;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']/following::li/a[contains(text(), 'Make a Payment')]")
	public static WebElement makeaPayment_link;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']/following::li/a[contains(text(), 'Manage Eligibility Questions')]")
	public static WebElement manageEligibilityQuestions_link;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']/following::li/a[contains(text(), 'Manage Forms List')]")
	public static WebElement manageFormsList_link;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']/following::li/a[contains(text(), 'Marketing Initiative Requests')]")
	public static WebElement marketingInitiativeRequests_link;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']/following::li/a[contains(text(), 'Master Agencies')]")
	public static WebElement masterAgencies_link;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']/following::li/a[contains(text(), 'PWBB Text Manager')]")
	public static WebElement pwbb_textManager_link;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']/following::li/a[contains(text(), 'Referral Counties')]")
	public static WebElement referralCounties_link;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']/following::li/a[contains(text(), 'UW Admin')]")
	public static WebElement UW_admin_Link;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']/li/a[contains(text(), 'AI Request')]")
	public static WebElement AI_request_link;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']/li/a[contains(text(), 'AI Maintenance')]")
	public static WebElement AI_maintenance_link;
	
	@FindBy(xpath="//li[@class='dropdown']/a[contains(text(), 'Additional Insureds')]")
	public static WebElement additionalInsureds_tab;
	
	//=============================================> Agency Information Edit Locators<============================================
	
	@FindBy(xpath="//select[@id='SearchField' and @name='SearchField']")
	public static WebElement searchBy_drpdwm;
	
	@FindBy(xpath="//input[@id='SearchValue' and @name='SearchValue']")
	public static WebElement search_field;
	
	@FindBy(xpath="//button[@id='searchBtn']")
	public static WebElement search_btn;
	
	@FindBy(xpath="//table[@id='grid']/tbody/tr/td[3]")
	public static WebElement agencyCode_row;
	
	@FindBy(xpath="//ul[@id='contextMenu']/li/a[@id='editLink']")
	public static WebElement editAgency_link;
	
	@FindBy(xpath="//div[@id='AppointmentDate']/input")
	public static WebElement agency_appointmentDate_field;
	
	@FindBy(xpath="//div[@id='LicenseExpirationDate']/input")
	public static WebElement agency_licenceExpiration_field;
	
	@FindBy(xpath="//div[@id='LicenseExpirationDate']/div")
	public static WebElement licenceExpiration_datePicker;
	
	@FindBy(xpath="//div[@id='Eopolicydate']/div[1]")
	public static WebElement EoPloicydate_datePicker;
	
	@FindBy(xpath="(//div[@id='LicenseExpirationDate']//th[@class='datepicker-switch'])[position()=1]")
	public static WebElement licenceExpiration_daySwitch;
	
	@FindBy(xpath="(//div[@id='LicenseExpirationDate']//th[@class='datepicker-switch'])[position()=2]")
	public static WebElement licenceExpiration_monthSwitch;

	@FindBy(xpath="(//div[@id='LicenseExpirationDate']//th[@class='datepicker-switch'])[position()=3]")
	public static WebElement licenceExpiration_yearSwitch;	
	
	@FindBy(xpath="//div[@id='LicenseExpirationDate']//span[@class='year']")
	public static List <WebElement> licenseExpiration_year;
	
	@FindBy(xpath="//div[@id='LicenseExpirationDate']//span[@class='month']")
	public static List <WebElement> LicenseExpiration_month;
	
	@FindBy(xpath="//div[@id='LicenseExpirationDate']//td[@class='day']")
	public static List <WebElement> LicenseExpiration_day;
	
	@FindBy(xpath="(//div[@id='Eopolicydate']//th[@class='datepicker-switch'])[position()=1]")
	public static WebElement EoPolicyExpiration_daySwitch;
	
	@FindBy(xpath="(//div[@id='Eopolicydate']//th[@class='datepicker-switch'])[position()=2]")
	public static WebElement EoPolicyExpiration_monthSwitch;

	@FindBy(xpath="(//div[@id='Eopolicydate']//th[@class='datepicker-switch'])[position()=3]")
	public static WebElement EoPolicyExpiration_yearSwitch;	
	
	@FindBy(xpath="//div[@id='Eopolicydate']//span[@class='year']")
	public static List <WebElement> EoPolicyExpiration_year;
	
	@FindBy(xpath="//div[@id='Eopolicydate']//span[@class='month']")
	public static List <WebElement> EoPolicyExpiration_month;
	
	@FindBy(xpath="//div[@id='Eopolicydate']//td[@class='day']")
	public static List <WebElement> EoPolicyExpiration_day;
	
	@FindBy(xpath="//div[@id='Eopolicydate']/input")
	public static WebElement EoPolicy_Expiration_field;
	
	@FindBy(xpath="//button[@id='saveButton']")
	public static WebElement save_button;
	
	//=============================================> Add Master Agency Page Locators<============================================
	
	@FindBy(xpath="//button[@id='resetBtn']/following-sibling::a")
    public static WebElement addNew_masterAgency_btn;
	
	//=============================================> Manage FOrm List Locators<============================================
	
	@FindBy(xpath="//select[@id='ddlProgramName']")
	public static WebElement selectProgramName_dropdwn;
	
	@FindBy(xpath="//input[@id='btnToggleSelection']")
	public static WebElement showAllForms_btn;
	
	@FindBy(xpath="//input[@id='btnAddNewForm']")
	public static WebElement addNewForm_btn;
	
	//=============================================> List of Programs <============================================
	
	@FindBy(xpath="//div[@program='QCR']/img[@alt='Victory General Liability']")
	public static WebElement victoryGlProgram_link;
	
	
	
	//======================================>DNN Black strip Menus <====================================//
	
	//================ admin option
	
	@FindBy(xpath="//ul[@id='ControlNav']//a[contains(text(),'Admin')]")
	public static WebElement Admin_menuLink;
		
	//====================Tools Option
	@FindBy(xpath="//ul[@id='ControlNav']//a[contains(text(), 'Tools')]")
	public static WebElement Tools_menuLink;
			
	//====================Help Option
	
	@FindBy(xpath="//ul[@id='ControlNav']//a[@href='javascript:void(0)' and contains(text(), 'Help')]")
	public static WebElement Help_menuLink;
		
	
	//==================== Modules Option
	@FindBy(xpath="//a[@id='ControlBar_Action_Menu'][contains(text(),' Modules')]")
	public static WebElement Modules_menuLink;
	
	
	//====================Pages Option
	
	@FindBy(xpath="//ul[@id='ControlActionMenu']/li[2]/a[contains(text(),'Pages')]")
	public static WebElement Pages_menuLink;
		
	//====================== Users option
	
	@FindBy(xpath="//ul[@id='ControlActionMenu']/li[3]/a[contains(text(),'Users')]")
	public static WebElement Users_menuLink;
	
	@FindBy(xpath="//ul[@id='ControlActionMenu']//a[contains(text(),'Add New User')]")
	public static WebElement AddNewUser_SubmenuLink;
	
	@FindBy(xpath="//ul[@id='ControlActionMenu']//a[contains(text(),' Manage Users')]")
	public static WebElement ManageUser_SubmenuLink;
	
	@FindBy(xpath="//ul[@id='ControlActionMenu']//a[contains(text(),' Manage Roles')]")
	public static WebElement ManageRoles_SubmenuLink;
	
	
	//========================= Edit Page
	
	@FindBy(xpath="//ul[@id='ControlEditPageMenu']/li/a/span[contains(text(),'Edit Page')]")
	public static WebElement EditPage_menuLink;
	
	//===========================User Account Table
	
	@FindBy(xpath="//tr[@id='dnn_ctr518_Users_grdUsers_ctl00__0']//img[@title='Edit']")
	public static WebElement userlist_EditLogo;
	
	@FindBy(xpath="//span[contains(text(),'BTIS Admin > User Accounts > Edit User Accounts')]")
	public static WebElement userInfo_popUp_TitleText;
	
}
