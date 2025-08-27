package com.LegacyApplication.Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.LegacyApplication.TestBase.TestBase;

public class GenericMethods extends TestBase {

	public static final Logger log=Logger.getLogger(GenericMethods.class.getName());
	
	 /*
		 * Purpose: This method is used to highlight an element using the Java Script Executor
		 * @param Webdriver, WebElement
		 * @return NA
		 */
		public static void highlight_element(WebDriver driver, WebElement element) throws InterruptedException {
			// Creating JavaScriptExecuter Interface
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// Execute javascript
			js.executeScript("arguments[0].style.border='4px solid yellow'", element);
			Thread.sleep(3000);
			js.executeScript("arguments[0].style.border=''", element);
		}

		/*
		 * Purpose: This Java Script Executor Method is used to Scroll down a page
		 * @param NA
		 * @return NA
		 */
		public static void scroll_down()
		{
			JavascriptExecutor js = ((JavascriptExecutor) driver);

			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		}

		/*
		 * Purpose: This Java Script Executor Method is used to Scroll down to a particular WebElement
		 * @param WebElement
		 * @return NA
		 */
		public static void scroll_down_to_element(WebElement ele)
		{
			JavascriptExecutor js = ((JavascriptExecutor) driver);

			js.executeScript("arguments[0].scrollIntoView();", ele);
		}

		/*
		 * Purpose: This Java Script Executor Method is used to click a particular WebElement
		 * @param WebElement
		 * @return NA
		 */
		public static void click_Element_Using_JS(WebElement ele) 
		{
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click()", ele);

		}

		/*
		 * Purpose: This Java Script Executor Method is used to click a particular WebElement especially in Chrome
		 * @param WebElement
		 * @return NA
		 */
		public static void click_element(WebElement ele)
		{
			((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+ele.getLocation().y+")");
			ele.click();
		}

		/*
		 * Purpose: This method is used to scroll down a page using the Robot class
		 * @param NA
		 * @return NA
		 */
		public static void scroll_down_with_robot() throws AWTException
		{
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

		}
		
		/*
		 * Purpose: This method is used to accept an alert in a webpage
		 * @param NA
		 * @return NA
		 */
		public static void accept_alert()
		{
			WebDriverWait wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alt=driver.switchTo().alert();
			alt.accept();
		}

		/*
		 * Purpose: This method is used to cancel an alert in a webpage
		 * @param NA
		 * @return NA
		 */
		public static void cancel_alert()
		{
			WebDriverWait wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert=driver.switchTo().alert();
			alert.dismiss();
		}

		/*
		 * Purpose: This method is used to get the text from a alert in a WebPage
		 * @param NA
		 * @return String
		 */
		public static String get_alert_text()
		{
			WebDriverWait wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alt=driver.switchTo().alert();
			String text=alt.getText();
			return text;
		}

		/*
		 * Purpose: This method is used to switching to a frame using frame id
		 * @param String (id)
		 * @return NA
		 */
		public static void swith_to_frame_using_id(String id)
		{
			driver.switchTo().frame(id);
		}

		/*
		 * Purpose: This method is used to switching to a frame using frame name
		 * @param String (name)
		 * @return NA
		 */
		public static void swith_to_frame_using_name(String name)
		{
			driver.switchTo().frame(name);
		}

		/*
		 * Purpose: This method is used to switching to a frame using frame number
		 * @param String (number)
		 * @return NA
		 */
		public static void swith_to_frame_using_number(String number)
		{
			driver.switchTo().frame(number);
		}

		/*
		 * Purpose: This method is used to switching to a default content from a frame
		 * @param NA
		 * @return NA
		 */
		public static void swith_to_defaulat_content()
		{
			driver.switchTo().defaultContent();
		}

		/*
		 * Purpose: This method is used to navigate a browser to forward, backward, refreshing
		 * @param String (direction)
		 * @return NA
		 */
		public static void navigate_browser(String direction)
		{
			if(direction.equalsIgnoreCase("back"))
			{
			driver.navigate().back();
			}
			if(direction.equalsIgnoreCase("forward"))
			{
			driver.navigate().forward();
			}
			if(direction.equalsIgnoreCase("refresh"))
			{
			driver.navigate().refresh();
			}
		}

		/*
		 * Purpose: This method is used for navigating to all windows
		 * @param NA
		 * @return NA
		 */
		public static Iterator<String> getAllWindows() {
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> itr = windows.iterator();
			return itr;
		}
		
		/*
		 * Purpose: This method is used to select an element from dropdown based on your input (visibletext, value, index)
		 * @param WebElement, String (visibletext,value,index), String(your input)
		 * @return NA
		 */
		public static void select_from_dropdown(WebElement ele, String type, String textorint)
		{
			Select dropdown= new Select(ele);
			
			if(type.equalsIgnoreCase("visibletext"))
			{
			dropdown.selectByVisibleText(textorint);
			}
			else if(type.equalsIgnoreCase("value"))
			{
			dropdown.selectByValue(textorint);
			}
			else if(type.equalsIgnoreCase("index"))
			{
			dropdown.selectByIndex(Integer.parseInt(textorint));
			}
		}
		
		/*
		 * Purpose: This method is used to select an element from bootstrap dropdown
		 * @param WebElement, int (index)
		 * @return NA
		 */
		public static void bootstrap_dropdown(List <WebElement> ele, String text) throws InterruptedException
		{

			for(WebElement choice: ele)
			{
				if(choice.getText().contains(text))
				{
					choice.click();
					break;
				}
			}
		}

		/*
		 * Purpose: This Action class method is used to hover the mouse pointer to a webElement
		 * @param WebElement
		 * @return NA
		 */
		public static void mouse_hover(WebElement ele)
		{
			Actions a=new Actions(driver);
			a.moveToElement(ele).build().perform();

		}

		/*
		 * Purpose: This Action class method is used to drag and drop an WebElement
		 * @param WebElement, WebElement
		 * @return NA
		 */
		public static void drag_and_drop(WebElement e1, WebElement e2)
		{
			Actions a=new Actions(driver);
			a.dragAndDrop(e1, e2).build().perform();
		}

		/*
		 * Purpose: This Action class method is used to set position in webpage
		 * @param integer(point1), Integer(point 2)
		 * @return NA
		 */
		public static void set_position(int newpoint1, int newpoint2)
		{
			//int x=driver.manage().window().getPosition().getX();
			//int y=driver.manage().window().getPosition().getY();
			Point p=new Point(newpoint1,newpoint2);
			driver.manage().window().setPosition(p);
		}

		/*
		 * Purpose: This Action class method is used to set height and width of a webpage
		 * @param integer(height), Integer(width)
		 * @return NA
		 */
		public static void set_height_and_width(int height, int width)
		{
			//int x=driver.manage().window().getSize().getHeight();
			//int y=driver.manage().window().getSize().getWidth();
			Dimension d=new Dimension(height,width);
			driver.manage().window().setSize(d);
		}

		/*
		 * Purpose: This Action class method is used to hover the mouse pointer to a webElement
		 * @param WebElement, String(typeofclick)
		 * @return NA
		 */
		public static void action_click(WebElement ele, String typeofclick)
		{
			Actions a=new Actions(driver);
			if(typeofclick.equalsIgnoreCase("contextclick"))
			{
			a.contextClick(ele).build().perform();
			}
			else if(typeofclick.equalsIgnoreCase("doubleclick"))
			{
				a.doubleClick(ele).build().perform();
			}
		}

		/*
		 * Purpose: This Action class method is used to get the selected option from a webElement
		 * @param WebElement
		 * @return String
		 */
		public static String get_selected_optn_frm_ele(WebElement Element) {

			Select element = new Select(Element);

			String data=element.getFirstSelectedOption().getText().toString().trim();

			System.out.println("The actual value is " +data);

			return data;

		}
		
		/*
		 * Purpose: This Action class method is to retrieve the text from a webElement
		 * @param WebElement
		 * @return String
		 */
		public static String getTextfmElem(WebElement Element) {
			try {
				String data= Element.getAttribute("value").toString().trim();

				System.out.println("The actual value is "+data);;

				return data;
			}catch(NullPointerException e) {

				return " ";
			}

		}

		/*
		 * Purpose: This Action class method is to retrieve the text from a webElement
		 * @param WebElement
		 * @return String
		 */
		public static String get_text(WebElement Element) {
			try {
				String data= Element.getText();

				System.out.println("The actual value is "+data);

				return data;
			}catch(NullPointerException e) {

				return "  ";
			}

		}


		/*
		 * Purpose: This Action class method is used to retrieve the boolean value if the check box is selected
		 * @param WebElement
		 * @return String
		 */
		public static String is_chekbox_selected(WebElement Element) {
			try {
				boolean val= Element.isSelected();
				System.out.println("The actual Value is "  +val);

				String celldata=String.valueOf(val);
				return celldata;
			}
			catch(NullPointerException e) 
			{

				return "  ";
			}

		}

		/*
		 * Purpose: This Action class method is used to retrieve the boolean value if the element is displayed on the webpage
		 * @param WebElement
		 * @return String
		 */
		public static String is_displayed(WebElement element)
		{
			try
			{
				boolean result = element.isDisplayed();
				log.info("The actual result is "+result);
				String celldata=String.valueOf(result);
				return celldata;
			}
			catch(NullPointerException e)
			{
				return "  ";

			}

		}

		/*
		 * Purpose: This Action class method is used to retrieve the attribute value of a web element
		 * @param WebElement
		 * @return String
		 */
		public static String is_attribtue_present(WebElement element, String attribute) {

			try {
				String value = element.getAttribute(attribute);
				boolean isEmpty=value.trim().isEmpty();
				System.out.println("The actual Value is "  +isEmpty);
				String result=String.valueOf(isEmpty);
				return result;
			}catch(NullPointerException e) {

				return "  ";
			}

		}

		/*
		 * Purpose: This Action class method is used to click on a element
		 * @param WebElement, String (element name)
		 * @return String
		 */ 
		public static void click_on_element(WebElement element, String elementName)
		{
			element.click();
			log.info("Clicked on " + elementName); 
		}

		/*
		 * Purpose: This Action class method is used to retrieve the boolean value if the radio button is selected
		 * @param WebElement
		 * @return String
		 */
		public static String is_radio_button_selected(WebElement Element) {
			try {
				boolean val= Element.isSelected();
				System.out.println("The actual Value is "   +val);

				String celldata=String.valueOf(val);
				return celldata;
			}catch(NullPointerException e) {

				return "  ";
			}
		}

		/*
		 * Purpose: This method is used to check if the webelement is enabled
		 * @param WebElement
		 * @return String
		 */
		public static String is_element_enabled(WebElement Element) {
			try {
				boolean val= Element.isEnabled();
				System.out.println("The actual Value is "  +val);

				String celldata=String.valueOf(val);
				return celldata;
			}catch(NullPointerException e) {

				return "  ";
			}
		}

		/*
		 * Purpose: This method is used to switch to a new window
		 * @param NA
		 * @return NA
		 */
		public static void navigate_to_next_window()
		{

			for(String winhandle:driver.getWindowHandles())
			{
				driver.switchTo().window(winhandle);
			}

		}

		/*
		 * Purpose: This method is used to enter the text in a WebElement
		 * @param WebElement, String (text), String(element name)
		 * @return String
		 */
		public static void enter_text(WebElement element, String text, String elementName)
		{

			element.clear();
			element.sendKeys(text);
			log.info(text +" entered in the " + elementName + " field.");
		}


		/*
		 * Purpose: This method is used to upload a file using robot class
		 * @param String (path)
		 * @return NA
		 */
		public static void file_upload(String path) throws InterruptedException, AWTException
		{
			Robot r=new Robot();
			WaitMethods.wait_in_seconds(3);
			StringSelection s=new StringSelection(path);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
			WaitMethods.wait_in_seconds(4);
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_V);
			WaitMethods.wait_in_seconds(3);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			WaitMethods.wait_in_seconds(3);
		}

		public static Object getMapValue(Map<String, String> map, String value) {
			/* 
		  Multimap<String, String> multiMap = HashMultimap.create();
		  for (Entry<String, String> entry : map.entrySet()) {
		    multiMap.put(entry.getValue(), entry.getKey());
		  }*/

			for (Object o : map.keySet()) {
				while (map.get(o).equals(value)) {
					return o;
				}
			}
			return null;
		}

		/*
		 * Purpose: This method is retrieve the current date
		 * @param NA
		 * @return String
		 */
		public static String get_current_date()
		{
			Date my_date = new Date(System.currentTimeMillis());
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
			String s = formatter.format(my_date);
			System.out.println("The current Date is" +s);
			return s;

		}

		/*
		 * Purpose: Get unique name by appending date and time
		 * @param sName
		 * @return String
		 */
		public static String get_unique_name(String sName) {
			Calendar rightNow = Calendar.getInstance();
			if (sName == "") {
				return sName;
			} else {
				String sNewName = sName + rightNow.get(Calendar.YEAR)
				+ rightNow.get(Calendar.MONTH)
				+ rightNow.get(Calendar.DAY_OF_MONTH)
				+ rightNow.get(Calendar.HOUR)
				+ rightNow.get(Calendar.MINUTE)
				+ rightNow.get(Calendar.SECOND);
				return sNewName;
			}
		}
		
		/*
		 * This method is used to get the number from the given String
		 * @param sData
		 * @return String
		 */
		public static String  get_integer_value(String sData)
		{
			String sNumber = "";
			for(int i = 0; i < sData.length() ; i++)
			{
				Character character = sData.charAt(i);
				if (Character.isDigit(character)) {
					sNumber += character;

				}
			}
			
			return sNumber;
		}
}
