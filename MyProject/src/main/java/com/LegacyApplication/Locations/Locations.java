package com.LegacyApplication.Locations;

public class Locations 
{
	//...........................>>Driver Locations<<.............................//
	
	public static String geckoDriverPath=System.getProperty("user.dir")+"/drivers/geckodriver.exe";
	public static String chromeDriverPath=System.getProperty("user.dir")+"/drivers/chromedriver.exe";
	public static String IEDriverPath=System.getProperty("user.dir")+"/drivers/IEDriverServer.exe";
	public static String edgeDriverPath=System.getProperty("user.dir")+"/drivers/MicrosoftWebDriver.exe";
	
	//...........................>>Configuration File Locations<<.............................//
	
	public static String configFilePath=System.getProperty("user.dir") + "//src//main//java//com//LegacyApplication//Config//config.properties";
	public static String submissionpageprop=System.getProperty("user.dir") + "//src//main//java//com//LegacyApplication//Config//submissionpage.properties";
	public static String brokerfeeconfig=System.getProperty("user.dir") + "//src//main//java//com//LegacyApplication//Config//brokerfeeinfo.properties";
	public static String databaseconfig=System.getProperty("user.dir") + "//src//main//java//com//LegacyApplication//Config//databaseinfo.properties";
	
	//...........................>>results and screenshot Locations<<.............................//

	public static String extentConfigPath=System.getProperty("user.dir")+"//extent-config.xml";
	public static String extentReportPath=System.getProperty("user.dir")+"//src//main//java//com//LegacyApplication//Reports//Test_Execution_Report-";
	public static String resultFile=System.getProperty("user.dir")+"//src//main//java//com//LegacyApplication//Reports//Test_Execution_Report-";
	public static String captureScreenShotPath="//src//main//java//com//LegacyApplication//ScreenShots//Screen_Shot_Of-";
	public static String screenshotlocation="//src//main//java//com//LegacyApplication//";
	
	//...........................>>Test Data Locations<<.............................//
	
	public static String testDataFilePath=System.getProperty("user.dir") +"//src//main//java//com//LegacyApplication//Data//BTIS_Legacy_TestData.xlsx";
	public static String BrokerFeeDataFilePath=System.getProperty("user.dir") +"//src//main//java//com//LegacyApplication//Data//BTIS_BrokerFee_Data.xlsx";
	public static String qaaChangesFilePath=System.getProperty("user.dir") +"//src//main//java//com//LegacyApplication//Data//QAA_Filing_Changes.xlsx";
	public static String regression_dataFilePath=System.getProperty("user.dir") +"//src//main//java//com//LegacyApplication//Data//Regression_Issues_TestData.xlsx";
	public static String tls_dataFilePath=System.getProperty("user.dir") +"//src//main//java//com//LegacyApplication//Data//TLS1.2_TestData.xlsx";
	public static String GlDirect_dataFilePath=System.getProperty("user.dir")+"//src//main//java//com//LegacyApplication//Data//GlDirect_TestData.xlsx";
	public static String GL_AR_TestData=System.getProperty("user.dir")+"//src//main//java//com//LegacyApplication//Data//GL_NewAR_TestData.xlsx";
	public static String StarUI_TestData=System.getProperty("user.dir")+"//src//main//java//com//LegacyApplication//Data//StarUIOLD_TestData.xlsx";
	public static String WC_UI_TestData=System.getProperty("user.dir")+"//src//main//java//com//LegacyApplication//Data//WCnewUI_TestData.xlsx";
	public static String CBIC_UI_TestData=System.getProperty("user.dir")+"//src//main//java//com//LegacyApplication//Data//CBIC_TestData.xlsx";
	public static String NEXT_UI_TestData=System.getProperty("user.dir")+"//src//main//java//com//LegacyApplication//Data//NEXT_TestData.xlsx";
	public static String registrationProcess_UI_TestData=System.getProperty("user.dir")+"//src//main//java//com//LegacyApplication//Data//RegistrationProcessData.xlsx";
	public static String ClearSpringGL_UI_TestData=System.getProperty("user.dir")+"//src//main//java//com//LegacyApplication//Data//ClearSpringGL_TestData.xlsx";
	
	//...........................>>Sikuli DocuSign Locations<<.............................//
	
	public static String iAgreeChkb=System.getProperty("user.dir")+"/Images_Sikuli/Iagree.PNG";
	public static String adoptSignPop_up=System.getProperty("user.dir")+"\\Images_Sikuli\\AdoptnSignPop.PNG";
	public static String agree_btn=System.getProperty("user.dir")+"\\Images_Sikuli\\agreebtn.PNG";
	public static String continue_page1=System.getProperty("user.dir")+"\\Images_Sikuli\\ContinueP1.PNG";
	public static String finish_last=System.getProperty("user.dir")+"/Images_Sikuli/FinishLast.PNG";
	public static String ok_page2=System.getProperty("user.dir")+"/Images_Sikuli/okP2.PNG";
	public static String sign_required_p2=System.getProperty("user.dir")+"/Images_Sikuli/SignRequiredP2.PNG";
	public static String start_p2=System.getProperty("user.dir")+"/Images_Sikuli/StartP2.PNG";
	public static String impInfo_RenewalCreated=System.getProperty("user.dir")+"/Images_Sikuli/RenewalCreated_DirectBill_NonCA.PNG";
	

}
