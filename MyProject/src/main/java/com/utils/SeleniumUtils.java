package com.MyProject.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class SeleniumUtils {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public SeleniumUtils(WebDriver driver, int timeout) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        this.actions = new Actions(driver);
    }

    // ====== Basic Actions ======
    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void type(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    public String getText(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public boolean isDisplayed(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void hover(WebElement element) {
        actions.moveToElement(element).perform();
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // ====== Dropdown Handling ======
    public void selectByValue(WebElement dropdown, String value) {
        new Select(dropdown).selectByValue(value);
    }

    public void selectByIndex(WebElement dropdown, int index) {
        new Select(dropdown).selectByIndex(index);
    }

    public void selectByVisibleText(WebElement dropdown, String text) {
        new Select(dropdown).selectByVisibleText(text);
    }

    public List<WebElement> getAllDropdownOptions(WebElement dropdown) {
        return new Select(dropdown).getOptions();
    }

    // ====== Frames ======
    public void switchToFrameByNameOrId(String nameOrId) {
        driver.switchTo().frame(nameOrId);
    }

    public void switchToFrameByIndex(int index) {
        driver.switchTo().frame(index);
    }

    public void switchToFrame(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void switchBackToDefault() {
        driver.switchTo().defaultContent();
    }

    // ====== Window/Tab Handling ======
    public void switchToWindowByTitle(String title) {
        String current = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(title)) {
                return;
            }
        }
        driver.switchTo().window(current);
    }

    public void switchToWindowByUrl(String urlPart) {
        String current = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getCurrentUrl().contains(urlPart)) {
                return;
            }
        }
        driver.switchTo().window(current);
    }

    public Set<String> getAllWindows() {
        return driver.getWindowHandles();
    }

    // ====== Alerts ======
    public void handleAlert(String action, String textToEnter) {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            if ("accept".equalsIgnoreCase(action)) {
                if (textToEnter != null) alert.sendKeys(textToEnter);
                alert.accept();
            } else {
                alert.dismiss();
            }
        } catch (TimeoutException e) {
            System.out.println("No alert found.");
        }
    }

    // ====== Keyboard & Mouse ======
    public void pressKey(WebElement element, Keys key) {
        element.sendKeys(key);
    }

    public void doubleClick(WebElement element) {
        actions.doubleClick(element).perform();
    }

    public void rightClick(WebElement element) {
        actions.contextClick(element).perform();
    }

    public void dragAndDrop(WebElement source, WebElement target) {
        actions.dragAndDrop(source, target).perform();
    }

    // ====== File Upload ======
    public void uploadFile(WebElement element, String filePath) {
        element.sendKeys(filePath);
    }

    // ====== Screenshots ======
    public void takeScreenshot(String fileName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("target/screenshots/" + fileName + ".png");
        dest.getParentFile().mkdirs();
        try {
            Files.copy(src.toPath(), dest.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Screenshot could not be saved: " + e.getMessage());
        }
    }

    // ====== Page Utils ======
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void back() {
        driver.navigate().back();
    }

    public void forward() {
        driver.navigate().forward();
    }
}
