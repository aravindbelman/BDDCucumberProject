package com.LegacyApplication.CustomListner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.TestBase.TestBase;

public class Listner extends TestBase implements ITestListener {

	public static final Logger log=Logger.getLogger(Listner.class.getName());
	
	public void onFinish(ITestContext result) {
		//log.info("<====Test Skipped=====>"+((ITestResult) result).getMethod().getMethodName());
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		
		System.out.println("The name of the testcase failed is :"+result.getName());
		
		 Calendar calendar=Calendar.getInstance();
		 SimpleDateFormat formater= new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		 String methodName=result.getName();
		 if(!result.isSuccess())
		 {
		 File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 try
		 {
			String reportDirectory=new File(System.getProperty("user.dir")).getAbsolutePath()+Locations.screenshotlocation;
		    File destFile=new File((String)reportDirectory+"//Failure_Screenshots//"+methodName+"_"+formater.format(calendar.getTime())+".png");
		    FileUtils.copyFile(scrFile, destFile);
		    //This will help you to link the screenshot in TestNg Report
		    Reporter.log("<a href='"+destFile.getAbsolutePath()+"'><img src='"+destFile.getAbsolutePath()+"'height='100'width='100'/></a>");
		 }catch(IOException e)
		 {
			 e.printStackTrace();
		 }
		 }
	}

	public void onTestSkipped(ITestResult result) {
		
		System.out.println("The name of the testcase Skipped is :"+result.getName());
		log.info("<====Test Skipped=====>"+result.getMethod().getMethodName());
		
	}

	public void onTestStart(ITestResult result) {
		log.info("<====Test Started Running=====>"+result.getName());
		log.info("<====Test started=====>"+result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("The name of the testcase passed is :"+result.getName());
		Calendar calendar=Calendar.getInstance();
		 SimpleDateFormat formater= new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		 String methodName=result.getName();
		 if(result.isSuccess())
		 {
		 File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 try
		 {
			String reportDirectory=new File(System.getProperty("user.dir")).getAbsolutePath()+Locations.screenshotlocation;
		    File destFile=new File((String)reportDirectory+"//Success_Screenshots//"+methodName+"_"+formater.format(calendar.getTime())+".png");
		    FileUtils.copyFile(scrFile, destFile);
		    //This will help you to link the screenshot in TestNg Report
		    Reporter.log("<a href='"+destFile.getAbsolutePath()+"'><img src='"+destFile.getAbsolutePath()+"'height='100'width='100'/></a>");
		 }catch(IOException e)
		 {
			 e.printStackTrace();
		 }
		 }
		
	}
}
