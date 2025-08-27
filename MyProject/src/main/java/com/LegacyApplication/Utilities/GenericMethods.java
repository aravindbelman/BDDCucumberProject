package com.LegacyApplication.Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.util.PDFTextStripper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.LegacyApplication.TestBase.TestBase;

public class GenericMethods extends TestBase {

	public static final Logger log=Logger.getLogger(GenericMethods.class.getName());
	public static DateFormat dateFormat;

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

		//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	
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
	 * Purpose: This Java Script Executor Method is used display an alert on the web page
	 * @param String (alert message)
	 * @return NA
	 */
	public static void display_slert_Using_JS(String alert_msg) 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("alert(alert_msg);");  
	}

	/*
	 * Purpose: This Java Script Executor Method is used to find number of frames in a web page
	 * @param String NA
	 * @return int
	 */
	public static int no_of_frames_using_js() 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int frame_size=(int) js.executeScript("document.frames.length;");
		return frame_size;
	}
	
	/*
	 * Purpose: This Java Script Executor Method is used to click a particular WebElement
	 * @param WebElement
	 * @return NA
	 */
	public static void click_Element(WebElement ele) 
	{
		WaitMethods.wait_for_element_to_be_clickable(ele);
		String ele_text=ele.toString();
		ele.click();
		log.info("Clicked on the element "+ele_text);
	}
	
	public static void click_from_webElementList(List <WebElement> ele, String text) throws InterruptedException
	{
        WaitMethods.wait_in_seconds(5);
		for(WebElement choice: ele)
		{
			if(choice.getText().trim().equals(text))
			{
				choice.click();
				break;
			}
		}
	}

	/*
	 * Purpose: This Java Script Executor Method is used to click a particular WebElement
	 * @param WebElement
	 * @return NA
	 */
	public static void click_Element_Using_JS(WebElement ele) 
	{
		WaitMethods.wait_for_element_present(ele);
		String ele_text=ele.toString();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", ele);
		log.info("Clicked on the element "+ele_text);
	}

	/*
	 * Purpose: This Java Script Executor Method is used to click a particular WebElement especially in Chrome
	 * @param WebElement
	 * @return NA
	 */
	public static void click_element_JS(WebElement ele)
	{
		WaitMethods.wait_for_element_to_be_clickable(ele);
		String ele_text=ele.toString();
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+ele.getLocation().y+")");
		ele.click();
		log.info("Clicked on the element "+ele_text);
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
	 * Purpose: This method is used to accept an alert using JavascriptExecutor
	 * @param NA
	 * @return NA
	 */
	public static void accept_alert_using_js()
	{
		((JavascriptExecutor) driver).executeScript("window.confirm = function(msg) { return true; }");
	}

	/*
	 * Purpose: This method is used to accept an alert in a webpage
	 * @param NA
	 * @return NA
	 */
	public static void accept_alert()
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		if(isAlertPresent()==true)
		{
			if(wait.until(ExpectedConditions.alertIsPresent())!=null)
			{
				Alert alt=driver.switchTo().alert();
				alt.accept();

			} 
		}
		else
		{ 
			System.out.println("No alert present");
		}

	}

	/*
	 * Purpose: This method is used to check if alert exists
	 * @param NA
	 * @return boolean value(true or false)
	 */
	public static boolean isAlertPresent(){
		boolean foundAlert = false;
		WebDriverWait wait = new WebDriverWait(driver, 0 /*timeout in seconds*/);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			foundAlert = true;
		} catch (TimeoutException eTO) {
			foundAlert = false;
		}
		return foundAlert;
	}

	/*
	 * Purpose: This method is used to cancel an alert in a webpage
	 * @param NA
	 * @return NA
	 */
	public static void cancel_alert()
	{
		/*try 
		{ 
			WebDriverWait wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alt=driver.switchTo().alert();
			alt.dismiss();
		}  
		catch (NoAlertPresentException e) 
		{ 
			System.out.println("No Alert Present");
		}*/

		if(isAlertPresent()==true)
		{
			Alert alt=driver.switchTo().alert();
			alt.dismiss();
		}
		else
		{ 
			System.out.println("No alert present");
		}


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
	 * Purpose: This method is used to switching to a frame using frame index
	 * @param String (index)
	 * @return NA
	 */
	public static void swith_to_frame_using_index(int index)
	{
		driver.switchTo().frame(index);
	}

	/*
	 * Purpose: This method is used to switching to a default content from a frame
	 * @param NA
	 * @return NA
	 */
	public static void swith_to_default_content()
	{
		driver.switchTo().defaultContent();
	}

	/*
	 * Purpose: This method is used to navigate to a different url
	 * @param NA
	 * @return NA
	 */
	public static void navigate_to_url(String url)
	{
		WaitMethods.wait_for_page_load(10);
		driver.navigate().to(url);
		driver.manage().window().maximize();
		((JavascriptExecutor) driver).executeScript("window.focus();");
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
	 * Purpose: This method is used to select a value from dropdown
	 * @param WebElement
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
	 * Purpose: This method is used to select a value from dropdown using action class
	 * @param WebElement
	 * @return NA
	 */
	public static void select_using_action(WebElement ele, String type, String textorint)
	{
		WaitMethods.wait_for_element_present(ele);
		Actions mouse = new Actions(driver);
		mouse.moveToElement(ele);
		ele.click();
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
	 * Purpose: This method is used to select an element from dropdown based on your input (visibletext, value, index)
	 * @param WebElement, String (visibletext,value,index), String(your input)
	 * @return NA
	 */
	public static void select_random_value_from_dropdown(WebElement ele)
	{
		WaitMethods.wait_for_element_present(ele);
		Select select=new Select(ele);
		List<WebElement> eleList=select.getOptions();
		int eleCount=eleList.size();
		Random spk= new Random();
		int eleSelect = spk.nextInt(eleCount);
		select.selectByIndex(eleSelect+1);
	}

	/*
	 * Purpose: This method is used to select an element from bootstrap dropdown
	 * @param WebElement, int (index)
	 * @return NA
	 */
	public static void bootstrap_dropdown(List <WebElement> ele, String text) throws InterruptedException
	{
        WaitMethods.wait_for_elements_present(ele);
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
	 * Purpose: This method is used to compare a text present in dropdown
	 * @param WebElement, String(your input)
	 * @return NA
	 */
	public static boolean compare_value_from_dropdown(WebElement ele, String your_text)
	{
		boolean element_found = false;
		Select select=new Select(ele);
		List<WebElement> eleList=select.getOptions();
		for(int i=0; i<eleList.size(); i++) {
			if(eleList.get(i).getText().trim().equals(your_text)) {
				System.out.println("The value exists in the dropdown");
				element_found=true;
			}  
		}
		return element_found;
	}

	/*
	 * Purpose: This Action class method is used to hover the mouse pointer to a webElement
	 * @param WebElement
	 * @return NA
	 */
	public static void mouse_hover(WebElement ele)
	{
		WaitMethods.wait_for_element_present(ele);
		Actions a=new Actions(driver);
		a.moveToElement(ele).build().perform();

	}

	/*
	 * Purpose: This Action class method is used to hover the mouse pointer to a webElement
	 * @param WebElement
	 * @return NA
	 */
	public static void mouse_hover_and_click_using_actions(WebElement ele, WebElement ele1)
	{
		WaitMethods.wait_for_element_present(ele);
		Actions builder = new Actions(driver);
		builder.moveToElement(ele).build().perform();
		builder.moveToElement(ele1).click().perform();
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
	public static void context_or_double_click_using_action(WebElement ele, String typeofclick)
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

		WaitMethods.wait_for_element_present(Element);
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
			WaitMethods.wait_for_element_present(Element);
			String data= Element.getAttribute("value").toString().trim();

			System.out.println("The actual value is "+data);

			return data;
		}catch(NullPointerException e) {

			return " ";
		}

	}
	
	public static String getTextfmElems(List<WebElement>Element) {
		try {
			WaitMethods.wait_for_elements_present(Element);
			String data= ((WebElement) Element).getAttribute("value").toString().trim();

			System.out.println("The actual value is "+data);

			return data;
		}catch(NullPointerException e) {

			return " ";
		}

	}

	/*
	 * Purpose: This Action class method is to retrieve only digits from a string
	 * @param String
	 * @return String
	 */
	public static String getOnlyDigits(String s) {
		Pattern pattern = Pattern.compile("[^0-9]");
		Matcher matcher = pattern.matcher(s);
		String number = matcher.replaceAll("");
		return number;
	}

	/*
	 * Purpose: This Action class method is to retrieve only alphabets from a string
	 * @param String
	 * @return String
	 */
	public static String getOnlyStrings(String s) {
		Pattern pattern = Pattern.compile("[^a-z A-Z]");
		Matcher matcher = pattern.matcher(s);
		String number = matcher.replaceAll("");
		return number;
	}

	/*
	 * Purpose: This Action class method is to retrieve the text from a webElement
	 * @param WebElement
	 * @return String
	 */
	public static String get_text(WebElement Element) {
		try {
			WaitMethods.wait_for_element_present(Element);
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
	 * Purpose: This Action class method is used to verify if an attribute is present
	 * @param WebElement
	 * @return String
	 */
	public static String isAttribtuePresent(WebElement element, String attribute) {
	    Boolean result = false;
	    try {
	        String value = element.getAttribute(attribute);
	        if (value != null){
	            result = true;
	        }
	    } catch (Exception e) {}

	    return String.valueOf(result);
	}

	/*
	 * Purpose: This Action class method is used to retrieve the boolean value if the element is displayed on the webpage
	 * @param WebElement
	 * @return String
	 */
	public static boolean boolean_is_element_present(WebElement element)
	{
		try
		{
			boolean result=true;	
			if(element.isDisplayed())
			{
				log.info("The actual result is "+result);		
			}
			return result;
		}
		catch(Exception e)     
		{       
			log.info("Element not visible");  
		}
		return false;
	}

	/*
	 * Purpose: This Action class method is used to retrieve the boolean value if the element is displayed on the webpage
	 * @param WebElement
	 * @return String
	 */
	public static String is_element_displayed(WebElement element)
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
			log.info("The element is not displayed");  
			return "  ";

		}

	}

	/*
	 * Purpose: This Action class method is used to check if the element is present on the webpage
	 * @param WebElement
	 * @return String
	 */
	public static String is_element_present(WebElement element)
	{ 
		try   
		{ 

			if(element.isDisplayed() )     
			{      
				log.info("The actual result is true");
			}   

			return "true";
		}      
		catch(Exception e)     
		{       
			log.info("Element not visible");  

		}
		return "false";
	}

	/*
	 * Purpose: This Action class method is used to check whether attribute is present
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
	 * Purpose: This Action class method is used to retrieve the attribute value of a web element
	 * @param WebElement
	 * @return String
	 */
	public static String get_attribute_value(WebElement element, String attribute) {

		try {
			String value = element.getAttribute(attribute);
			System.out.println("The actual Value is "  +value);
			String result=String.valueOf(value);
			return result;
		}catch(NullPointerException e) {

			return "  ";
		}

	}

	/*
	 * Purpose: This Action class method is used to click on a element
	 * @param WebElement, String (element name)
	 * @return NA
	 */ 
	public static void click_on_element_using_actions(WebElement element, String elementName)
	{
		WaitMethods.wait_for_element_present(element);
		Actions act = new Actions(driver);
		act.moveToElement(element);
		act.click(element);
		Action action  = act.build();
		action.perform();
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
	 * Purpose: This method is used to perform action if element is displayed
	 * @param WebElement
	 * @return NA
	 */
	public static void perform_action_ifelementexists(WebElement element, String action) {

		Boolean iselementpresent=element.isDisplayed();
		if(iselementpresent==true && action.equalsIgnoreCase("click"))
		{
			System.out.println("The element exists");
			element.click();
		}
		else
		{
			System.out.println("There is no element exists");
		}
	}

	/*
	 * Purpose: This method is used to maximize window
	 * @param NA
	 * @return NA
	 */
	public static void maximize_window()
	{
		driver.manage().window().maximize();
		((JavascriptExecutor) driver).executeScript("window.focus();");
	}

	/*
	 * Purpose: This method is used to minimize window
	 * @param NA
	 * @return NA
	 */
	public static void minimize_window()
	{
		driver.manage().window().maximize();
		((JavascriptExecutor) driver).executeScript("window.focus();");
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
			driver.manage().window().maximize();
			((JavascriptExecutor) driver).executeScript("window.focus();");
		}

	}

	/*
	 * Purpose: This method is used to enter the text in a WebElement
	 * @param WebElement, String (text), String(element name)
	 * @return String
	 */
	public static void enter_text(WebElement element, String text, String fieldName)
	{
		WaitMethods.wait_for_element_present(element);
		element.clear();
		element.sendKeys(text);
		log.info(text +" entered in the " + fieldName + " field.");
	}

	/*
	 * Purpose: This method is used to click a list of web elements
	 * @param WebElement List
	 * @return NA
	 */
	public static void click_list_of_webelements(List <WebElement> els) throws AWTException
	{ 
		WaitMethods.wait_for_elements_present(els);
		for ( WebElement el : els ) {
			if ( !el.isSelected() ) {
				el.click();
			}
		}
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

	/*
	 * Purpose: This method is used to clicking an element using robot class
	 * @param String (path)
	 * @return NA
	 */
	public static void click_enter_using_robot() throws AWTException
	{ 
		Robot rb=new Robot();
		if(isAlertPresent()==true)
		{
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		}
		else
		{
			System.out.println("There is no Alert Present");
		}
	}

	/*
	 * Purpose: This method is used to open a new tab using robot class
	 * @param String (path)
	 * @return NA
	 */
	public static void open_newtab_using_robot() throws AWTException
	{ 
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL); 
		rb.keyPress(KeyEvent.VK_T); 
		rb.keyRelease(KeyEvent.VK_CONTROL); 
		rb.keyRelease(KeyEvent.VK_T);  
	}

	/*
	 * Purpose: This method is used to switch to next tab using robot class
	 * @param String (path)
	 * @return NA
	 */
	public static void switch_tab_using_robot() throws AWTException
	{ 
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL); 
		rb.keyPress(KeyEvent.VK_TAB); 
		rb.keyRelease(KeyEvent.VK_CONTROL); 
		rb.keyRelease(KeyEvent.VK_TAB);  
	}
	
	/*
	 * Purpose: This method is used to CLOSE tab using robot class
	 * @param String (path)
	 * @return NA
	 */
	public static void close_tab_using_robot() throws AWTException
	{ 
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL); 
		rb.keyPress(KeyEvent.VK_W); 
		rb.keyRelease(KeyEvent.VK_CONTROL); 
		rb.keyRelease(KeyEvent.VK_W);  
	}
	

	/*
	 * Purpose: This method is used to close using robot class
	 * @param String (path)
	 * @return NA
	 */
	public static void close_window_using_robot() throws AWTException
	{ 
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_ALT); 
		rb.keyPress(KeyEvent.VK_F4); 
		rb.keyRelease(KeyEvent.VK_ALT); 
		rb.keyRelease(KeyEvent.VK_F);  
	}
	
	/*
	 * Purpose: This method is used to switch using robot class
	 * @param String (path)
	 * @return NA
	 */
	public static void switch_window_using_robot() throws AWTException
	{ 
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_ALT); 
		rb.keyPress(KeyEvent.VK_TAB); 
		rb.keyRelease(KeyEvent.VK_ALT); 
		rb.keyRelease(KeyEvent.VK_TAB);  
	}
	/*
	 * Purpose: This method is used to click escape using robot class
	 * @param String (path)
	 * @return NA
	 */
	public static void press_key_using_robot(String key_to_be_pressed) throws AWTException
	{ 
		Robot rb=new Robot();
		if(key_to_be_pressed.equalsIgnoreCase("escape"))
		{
			rb.keyPress(KeyEvent.VK_ESCAPE);  
			rb.keyRelease(KeyEvent.VK_ESCAPE);  
		}
		if(key_to_be_pressed.equalsIgnoreCase("enter"))
		{
			rb.keyPress(KeyEvent.VK_ENTER);  
			rb.keyRelease(KeyEvent.VK_ENTER);  
		}
		if(key_to_be_pressed.equalsIgnoreCase("tab"))
		{
			rb.keyPress(KeyEvent.VK_TAB);  
			rb.keyRelease(KeyEvent.VK_TAB);  
		}
		if(key_to_be_pressed.equalsIgnoreCase("end"))
		{
			rb.keyPress(KeyEvent.VK_END);  
			rb.keyRelease(KeyEvent.VK_END);  
		}
		if(key_to_be_pressed.equalsIgnoreCase("downArrow"))
		{
			rb.keyPress(KeyEvent.VK_DOWN);  
			rb.keyRelease(KeyEvent.VK_DOWN);  
		}
		if(key_to_be_pressed.equalsIgnoreCase("f5"))
		{
			rb.keyPress(KeyEvent.VK_F5);  
			rb.keyRelease(KeyEvent.VK_F5);  
		}
		
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
		System.out.println("The current Date is:  " +s);
		return s;

	}
	
	/*
	 * Purpose: This method is select the date, month and year from a date picker
	 * @param NA
	 * @return String
	 */
	public static void select_date_from_datePicker(List <WebElement> year_list, List <WebElement> month_list, List <WebElement> day_list, String select_year, String select_month, String select_day )
	{
		for(WebElement choice: year_list)
		{
			if(choice.getText().contains(select_year))
			{
				choice.click();
				break;
			}
		}
		
		for(WebElement choice: month_list)
		{
			if(choice.getText().contains(select_month))
			{
				choice.click();
				break;
			}
		}
		
		for(WebElement choice: month_list)
		{
			if(choice.getText().contains(select_day))
			{
				choice.click();
				break;
			}
		}
	}
	
	/*
	 * Purpose: This method is to update the custom date
	 * @param format, custom_date, days
	 * @return String
	 */
	public static String update_custom_date(String format, String your_date, int days)
	{
		//Given Date in String format
		String oldDate = your_date;  
		System.out.println("Date before Addition: "+oldDate);
		//Specifying date format that matches the given date
		SimpleDateFormat sdf = new SimpleDateFormat(format);

		Calendar c = Calendar.getInstance();

		try{
			//Setting the date to the given date
			c.setTime(sdf.parse(oldDate));
		}catch(ParseException e){
			e.printStackTrace();
		}

		//Number of Days to add
		c.add(Calendar.DAY_OF_MONTH, days);  
		//Date after adding the days to the given date
		String newDate = sdf.format(c.getTime());
		System.out.println("Date after Addition: "+newDate);

		return newDate;

	}

	/*
	 * Purpose: This method is to update the custom date
	 * @param format, custom_date, days
	 * @return String
	 */
	public static String update_current_date(String format, int year_value, int month_value, int days_value, int hour, int minute, int seconds)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date currentDate = new Date();
		// convert date to calendar
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);     
		//Number of Days to add
		c.add(Calendar.YEAR, year_value);
		c.add(Calendar.MONTH, month_value);
		c.add(Calendar.DAY_OF_MONTH, days_value);  
		c.add(Calendar.HOUR, hour);
		c.add(Calendar.MINUTE, minute);
		c.add(Calendar.SECOND, seconds);
		//Date after adding the days to the given date
		String newDate = sdf.format(c.getTime());
		System.out.println("Date after Addition: "+newDate);
		return newDate;
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
	public static String  get_integer_from_string(String sData)
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

	/*
	 * This method is used to convert an string to integer
	 * @param String Value
	 * @return int
	 */
	public static int convert_stingto_integer(String string_value)
	{
		try
		{
			int my_int=Integer.parseInt(string_value);
			System.out.println("The expected value is " +my_int);
			return my_int;
		} catch(Exception e)
		{
			System.out.println("Pass String Value as Parameter");
			return 0;
		}

	}

	/*
	 * This method is used to convert an string to integer
	 * @param String Value
	 * +
	 * @return float
	 */
	public static float convert_stingto_float(String string_value)
	{
		try
		{
			float my_float=Float.parseFloat(string_value);
			System.out.println("The expected value is " +my_float);
			return my_float;
		} catch(Exception e)
		{
			System.out.println("Pass String Value as Parameter");
			return 0;
		}
	}

	/*
	 * This method is used to convert an string to integer
	 * @param String Value
	 * @return double
	 */
	public static double convert_stingto_double(String string_value)
	{
		try
		{
			double my_double=Double.parseDouble(string_value);
			System.out.println("The expected value is " +my_double);
			return my_double;
		} catch(Exception e)
		{
			System.out.println("Pass String Value as Parameter");
			return 0;
		}	
	}

	/*
	 * This method is used to convert an integer to string
	 * @param int Value
	 * @return string
	 */
	public static String convert_integerto_string(int int_value)
	{
		try
		{
			String s= String.valueOf(int_value);
			System.out.println("The expected value is " +s);
			return s;
		} catch(Exception e)
		{
			System.out.println("Pass integer Value as Parameter");
			return " ";
		}	
	}

	/*
	 * This method is used to convert an float to string
	 * @param float Value
	 * @return string
	 */
	public static String convert_floatto_string(float float_value)
	{
		try
		{
			String s= String.valueOf(float_value);
			System.out.println("The expected value is " +s);
			return s;
		} catch(Exception e)
		{
			System.out.println("Pass integer Value as Parameter");
			return " ";
		}	
	}

	/*
	 * This method is used to convert string decimal type to integer
	 * @param String Value
	 * @return int
	 */
	public static int convert_decimal_stringto_integer(String string_value)
	{
		try
		{
			int i = Float.valueOf(string_value).intValue();
			System.out.println("The expected value is " +i);
			return i;
		} catch(Exception e)
		{
			System.out.println("Pass String Value as Parameter");
			return 0;
		}

	}
	
	/*
	 * This method is used to round up a float value to near decimal
	 * @param float Value
	 * @return int
	 */
	public static String generate_random_integer(int range_a, int range_b)
	{
		int aNumber = 0; 
		//aNumber = (int)((Math.random() * 900000000)+100000000); 
		aNumber = (int)((Math.random() * range_a)+range_b); 
		System.out.print((aNumber));
		String converted_number=convert_integerto_string(aNumber);
		return converted_number;
	}

	/*
	 * This method is used to round up a float value to near decimal
	 * @param float Value
	 * @return int
	 */
	public static int round_up(float float_value)
	{
		try
		{
			int round_up_value= (int)Math.rint(float_value);
			return round_up_value;
		} catch(Exception e)
		{
			System.out.println("Pass float value as Parameter");
			return 0;
		}	
	}

	/*
	 * This method is used to concat two strings
	 * @param String Values
	 * @return string
	 */
	public static String concat_two_strings(String s1, String s2)
	{
		try
		{
			String s3= s1.concat(s2);
			return s3;
		} catch(Exception e)
		{
			System.out.println("Pass two strings as Parameter");
			return " ";
		}	
	}

	/*
	 * This method is used to retrieve substring from a string
	 * @param String Values
	 * @return string
	 */
	public static String retrive_substring(String after_symbol, String actual_string)
	{
		String s = actual_string;
		String output_string=s.substring(s.lastIndexOf(after_symbol) + 1);	
		return output_string;
	}

	/*
	 * This method is used to trim a string
	 * @param String Values
	 * @return string
	 */
	public static String trim_string(String s)
	{
		String output_string=s.trim();
		return output_string;
	}

	/*
	 * This method is used to validate a text from PDF
	 * @param String Value(text)
	 * @return string
	 */
	public static void validate_text_in_pdf(String text) throws IOException, InterruptedException
	{
		URL url = new URL(driver.getCurrentUrl());

		//create buffer reader object
		//BufferedInputStream fileToParse = new BufferedInputStream(url.openStream());
		BufferedInputStream fileToParse = new BufferedInputStream(url.openStream());
		PDFParser pdfParser = new PDFParser(fileToParse);
		pdfParser.parse();

		//save pdf text into string variable
		String pdftxt = new PDFTextStripper().getText(pdfParser.getPDDocument());
		//System.out.println("The Pdf Text is :" +pdftxt);

		//close PDFParser object
		pdfParser.getPDDocument().close();
		Assert.assertTrue(pdftxt.contains(text));
		log.info("Successfully validated the "+text+" in PDF");
	}

	/*
	 * This method is used to close the focused browser tab
	 * @param NA
	 * @return NA
	 */
	public static void close_browser_window()
	{
		driver.close();
	}

	/*
	 * This method is used to close all the focused browser tabs
	 * @param NA
	 * @return NA
	 */
	public static void close_all_browser_windows()
	{
		driver.quit();
	}
}
