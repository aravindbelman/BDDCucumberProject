package com.LegacyApplication.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import com.LegacyApplication.CustomListner.ExecutionListner;
import com.LegacyApplication.CustomListner.Listner;
import com.LegacyApplication.ExcelReader.ExcelReader;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.Utilities.WaitMethods;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {
	public static final Logger log=Logger.getLogger(TestBase.class.getName());
	public static WebDriver driver;
	Listner lis;
	ExecutionListner el;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static Properties OR=new Properties();

	public WebDriver getDriver() {
		return driver;
	}

	/*@BeforeSuite
	 public void setup(Method result) throws IOException
	  {
		  test = extent.startTest(result.getName());
		  test.log(LogStatus.INFO, result.getName() + " test Started");
		  init();
	  }

	@AfterSuite
	public void afterMethod(ITestResult result) 
	{
	    get_result(result);
	    closeBrowser();

	}*/


	/*...................> Static Block to generate Reports <..........................*/

	static
	{
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat formater= new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent=new ExtentReports(Locations.extentReportPath+formater.format(calendar.getTime())+".html",false, DisplayOrder.NEWEST_FIRST);
		extent
		.addSystemInfo("Host Name", "Lenovo Desktop")
		.addSystemInfo("Role", "Automation Engineer")
		.addSystemInfo("User Name", "Ashish Maske");
		extent.loadConfig(new File(Locations.extentConfigPath));

	}

	/*
	 * This method is used to load data from config.properfies file
	 * @param NA
	 * @return NA
	 */
	public static void load_data() throws IOException 
	{
		File config = new File(Locations.configFilePath);
		File submission_config = new File(Locations.submissionpageprop);
		File brokerfee_config = new File(Locations.brokerfeeconfig);
		File database_config = new File(Locations.databaseconfig);
		FileInputStream f1 = new FileInputStream(config);
		FileInputStream f2 = new FileInputStream(submission_config);
		FileInputStream f3=  new FileInputStream(brokerfee_config);
		FileInputStream f4=  new FileInputStream(database_config);
		OR.load(f1);
		OR.load(f2);
		OR.load(f3);
		OR.load(f4);
	}

	/*
	 * This method is used to initialize chrome browser and to get Test Agency URL of the page
	 * @param NA
	 * @return NA
	 */
	public static void initialize_chrome(String url) throws IOException
	{
		load_data();
		String log4jConfPath="log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		select_browser(OR.getProperty("chrome_browser"));
		get_url(OR.getProperty(url));
			
	}
	
	/*
	 * This method is used to initialize firefox browser and to get Test Agency URL of the page
	 * @param NA
	 * @return NA
	 */
	public static void initialize_firefox(String url) throws IOException
	{
		load_data();
		String log4jConfPath="log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		select_browser(OR.getProperty("firefox_browser"));
		get_url(OR.getProperty(url));
			
	}
	
	/*
	 * This method is used to initialize Internet Explorer browser and to get Test Agency URL of the page
	 * @param NA
	 * @return NA
	 */
	public static void initialize_IE(String url) throws IOException
	{
		load_data();
		String log4jConfPath="log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		select_browser(OR.getProperty("ie_browser"));
		get_url(OR.getProperty(url));
			
	}
	
	/*
	 * This method is used to initialize browser and to get Test Agency URL of the page
	 * @param NA
	 * @return NA
	 */
	public static void initialize_agency_environment(String env, String browser) throws IOException
	{
		load_data();
		//ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "Url_Info");
		String log4jConfPath="log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		select_browser(OR.getProperty(browser));
		//get_url(OR.getProperty(url));
		//get_agency_environment(ExcelReader.get_row_data_from_col("Environment", 1));
		get_agency_environment(OR.getProperty(env));
	}

	/*
	 * This method is used to initialize browser and to get Test Admin URL of the page
	 * @param NA
	 * @return NA
	 */
    public static void init_admin(String url) throws IOException
	{
		load_data();
		String log4jConfPath="log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		select_browser(OR.getProperty("browser"));
		get_url(OR.getProperty(url));

	}
       
    /*
	 * This method is used to initialize browser and to get Test Agency URL of the page
	 * @param NA
	 * @return NA
	 */
	public static void initialize_admin_environment(String env, String browser) throws IOException
	{
		load_data();
		ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "Url_Info");
		String log4jConfPath="log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		select_browser(OR.getProperty(browser));
		//get_url(OR.getProperty(url));
		//get_admin_environment(ExcelReader.get_row_data_from_col("Environment", 1));
		get_admin_environment(OR.getProperty(env));
	}

	/*
	 * This method is used to initialize browser and to get Dev Agency URL of the page
	 * @param NA
	 * @return NA
	 */
	public static void init_agency_dev() throws IOException
	{
		load_data();
		String log4jConfPath="log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		select_browser(OR.getProperty("browser"));
		get_url(OR.getProperty("Dev_Url_Agency"));
	}

	/*
	 * This method is used to initialize browser and to get Dev Admin URL of the page
	 * @param NA
	 * @return NA
	 */
	public static void init_admin_dev() throws IOException
	{
		load_data();
		String log4jConfPath="log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		select_browser(OR.getProperty("browser"));
		get_url(OR.getProperty("Dev_Url_Admin"));

	}
	
	/*
	 * Purpose: This method is used to select a browser
	 * @param String
	 * @return NA
	 */
	public static void select_browser(String browser)
	{
		if(browser.equalsIgnoreCase("firefox"))
		{
			log.info("creating object of "+browser);
			System.setProperty("webdriver.gecko.driver",Locations.geckoDriverPath);
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
			//capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
			/*FirefoxProfile ffprofile = new FirefoxProfile();
			ffprofile.setPreference("dom.webnotifications.enabled", false);
			driver = new FirefoxDriver(ffprofile);*/
			driver = new FirefoxDriver(capabilities);
			log.info("Firefox is Working Fine");
			driver.manage().window().maximize();
			log.info("Firefox initialized successfully");
		}
		if(browser.equalsIgnoreCase("chrome"))
		{
			log.info("creating object of "+browser);
			log.info("Chrome is Working Fine");
			System.setProperty("webdriver.chrome.driver", Locations.chromeDriverPath);
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
			//capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
			/*ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			capabilities.merge((Capabilities) options);*/
			driver= new ChromeDriver(capabilities);
			log.info("Chrome initialized successfully");
			driver.manage().window().maximize();
		}
		if(browser.equalsIgnoreCase("ie"))
		{
			log.info("creating object of "+browser);
			log.info("Internet Explorer is Working Fine");
			System.setProperty("webdriver.ie.driver",Locations.IEDriverPath);
			driver = new InternetExplorerDriver();
			log.info("Internet Explorer initialized successfully");
			driver.manage().window().maximize();
		}
		if(browser.equalsIgnoreCase("headless"))
		{
			log.info("creating object of "+browser);
			log.info("Headless browser is Working Fine");
		  //Declaring and initializing the HtmlUnitWebDriver
			driver = new HtmlUnitDriver(true);
			log.info("Browser initialized successfully");
		}
		if(browser.equalsIgnoreCase("edge"))
		{
			log.info("creating object of "+browser);
			log.info("Edge is Working Fine");
			System.setProperty("webdriver.edge.driver",Locations.edgeDriverPath);
			driver=new EdgeDriver();
			log.info("Edge Browser initialized successfully");
			driver.manage().window().maximize();
		}
			

	}

	/*
	 * Purpose: This method is used to get URL of the Page
	 * @param String
	 * @return NA
	 */
	public static void get_url(String url)
	{
		log.info(" =====>Navigating to url<======= "+url);
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	/*
	 * Purpose: This method is used to get URL on the basis of the environment the Page
	 * @param String
	 * @return NA
	 */
	public static void get_agency_environment(String env) throws IOException
	{
		load_data();
		//ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "Url_Info");
		log.info(" =====>Navigating to enviroment<======= "+env+" Agency");
		if(env.equalsIgnoreCase("test")||env.equalsIgnoreCase("dev")||env.equalsIgnoreCase("staging"))
		{
		driver.get("https://my"+env+".btisinc.com");
		}
		else if(env.equalsIgnoreCase("production"))
		{
		driver.get("https://my.btisinc.com");	
		}
		driver.manage().window().maximize();
	}
	
	/*
	 * Purpose: This method is used to get URL on the basis ofthe environmentthe Page
	 * @param String
	 * @return NA
	 */
	public static void get_admin_environment(String env) throws IOException
	{
		load_data();
		ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "Url_Info");
		log.info(" =====>Navigating to enviroment<======= "+env+ " Admin");
		if(env.equalsIgnoreCase("test")||env.equalsIgnoreCase("dev")||env.equalsIgnoreCase("staging"))
		{
		driver.get("https://"+env+"-admin.btisinc.com");
		}
		else if(env.equalsIgnoreCase("production"))
		{
		driver.get("https://admin.btisinc.com");	
		}
		driver.manage().window().maximize();
	}

	/*
	 * Purpose: This method is used to Capture Screenshot
	 * @param String
	 * @return String
	 */
	public String capture_screen(String fileName) 
	{
		if (fileName == "") 
		{
			fileName = "blank";
		}
		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + Locations.captureScreenShotPath;
			destFile = new File((String) reportDirectory + fileName + "_" + formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(scrFile, destFile);
			// This will help us to link the screen shot in testNG report
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");

		} catch (IOException e) {
			e.printStackTrace();	
		}
		return destFile.toString();
	}

	/*
	 * Purpose: This method is used to close the browser
	 * @param NA
	 * @return NA
	 */
	public static void closeBrowser() {
		WaitMethods.wait_for_page_load(15);
		try
		{
			driver.quit();
			log.info("browser closed");
		}
		catch(NoSuchSessionException e)
		{
			log.info("The browser was already closed (or) there is no active browser to close"); 
		}
		catch(NoSuchWindowException e)
		{
			log.info("The window was already closed (or) there is no window to close"); 
		}
	}

	/*
	 * Purpose: This method is used to get the result to generate extent report
	 * @param ITestResult
	 * @return NA
	 */
	public void get_result(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, result.getName() + " test is pass");
			String screen = capture_screen(result.getName());
			test.log(LogStatus.PASS, test.addScreenCapture(screen));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
			String screen = capture_screen(result.getName());
			test.log(LogStatus.PASS, test.addScreenCapture(screen));
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.ERROR, result.getName() + " test is failed" + result.getThrowable());
			String screen = capture_screen(result.getName());
			test.log(LogStatus.FAIL, test.addScreenCapture(screen));
		} else if (result.getStatus() == ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getName() + " test is started");
		}
	}

	/*...................> Method to read data from Excel Sheet <..........................*/

	/*public String[][] getData(String excelName, String sheetName) throws BiffException, IOException
	{
		//System.out.println(System.getProperty("user.dir"));
		String excellocation = System.getProperty("user.dir")+"//src//main//java//com//Servcorp//data//"+excelName;
		System.out.println(excellocation);
		excelreader = new ExcelReader();
		return excelreader.readExcel(excellocation, sheetName);
	}
	 */

	@BeforeMethod
	public void setup(Method result) throws IOException
	{
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test Started");
		//init_agency();
	}

	@AfterMethod
	public void afterMethod(ITestResult result)
	{
		try
		{
			get_result(result);
			extent.endTest(test);
			extent.flush();
			closeBrowser();
		}
		catch(NoSuchSessionException e)
		{
			log.info("There is no session exists");
		}
		catch(NoSuchWindowException e)
		{
			log.info("No Window exists to close"); 
		}
		catch(NullPointerException e)
		{
			log.info("Exception Handled");
		}

	}

	@AfterTest
	public void teardown() 
	{
		try{
			driver.quit();
		}catch(NoSuchSessionException e)
		{
			log.info("The browser was already closed (or) there is no active browser to close"); 
		}
		catch(NoSuchWindowException e)
		{
			log.info("No Window exists to close"); 
		}
		catch(NullPointerException e)
		{
			log.info("Exception Handled");
		}

	}


	public void log(String data) {
		log.info(data);
		Reporter.log(data);
		test.log(LogStatus.INFO, data);
	}



}
