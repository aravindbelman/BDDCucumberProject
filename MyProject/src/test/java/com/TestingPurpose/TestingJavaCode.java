package com.TestingPurpose;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.WaitMethods;

public class TestingJavaCode {	
	
	public static WebDriver driver;
	
	
	public static void main(String [] args) throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", Locations.chromeDriverPath);
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		 driver.get("https://claims.amtrustgroup.com/ANAClaims2/MainMenu.aspx");
		 driver.findElement(By.id("txtUsername")).sendKeys("Ahadrick");
		 driver.findElement(By.id("txtPassword")).sendKeys("Hadrick#60");
		 driver.findElement(By.id("btnLogin")).click();
		 driver.findElement(By.id("ucContent_TreeView1t2")).click();
		 driver.findElement(By.id("ClaimSearch3_txtQuickClaimNumber")).sendKeys("906757");
		 driver.findElement(By.id("ClaimSearch3_btnQuickClaim")).click(); 
		 driver.findElement(By.id("ucContent_TreeView1t5")).click();
		
		 
		List<WebElement> rowList = driver.findElements(By.xpath("//table[@id='ClaimNoteGrid1_dgResults']/tbody/tr/td/a"));
	        
	        //try {
	        	for (int i = 1; i < rowList.size(); i++)
		        {
		            //WaitMethods.wait_for_elements_present(rowList);
		        	//Thread.sleep(5000);
		            driver.findElement(By.xpath("(//table[@id='ClaimNoteGrid1_dgResults']/tbody/tr/td/a)[position()="+i+"]")).click();
		            //driver.findElement(By.id("ucContent_TreeView1t5")).click();
		            driver.navigate().back();
		        }
	        	//} 
	       /* catch (org.openqa.selenium.StaleElementReferenceException ex) 
	            {
	        	rowList.get(i).click();
	            driver.findElement(By.id("ucContent_TreeView1t5")).click();
	            }*/
	}
	        
}