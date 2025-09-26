package com.utils;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import java.nio.file.Paths;


public class PlaywrightUtils {

    private Page page;

    public PlaywrightUtils(Page page) {
        this.page = page;
    }

    // ====== Basic Actions ======
    public void click(Locator element) {
        element.click();
    }

    public void type(Locator element, String text) {
        element.fill(text);  // clear
    }

    public String getText(Locator element) {
        return element.innerText();
    }

    public String getTextContent(Locator element) {
        return element.textContent();
    }

    public boolean isDisplayed(Locator element) {
        return element.isVisible();
    }

    public void hover(Locator element) {
        element.hover();
    }

    public void scrollToElement(Locator element) {
        element.scrollIntoViewIfNeeded();
    }

    // ====== Dropdown Handling ======
    public void selectByValue(Locator dropdown, String value) {
        dropdown.selectOption(value);
    }

    public void selectByIndex(Locator dropdown, int index) {
        dropdown.selectOption(new SelectOption().setIndex(index));
    }

    public void selectByVisibleText(Locator dropdown, String text) {
        dropdown.selectOption(new SelectOption().setLabel(text));
    }
    public void clickWithLog(Locator element, String elementName) {
        System.out.println("Clicking on: " + elementName);
        element.click();
    }

    // ====== Frames ======
    public Frame switchToFrameByName(String name) {
        return page.frame(name);
    }

    public Frame switchToFrameByUrl(String urlPart) {
        for (Frame f : page.frames()) {
            if (f.url().contains(urlPart)) {
                return f;
            }
        }
        throw new RuntimeException("No frame found with URL containing: " + urlPart);
    }

    public void switchBackToMainFrame() {
        page.mainFrame();
    }

    // ====== Window/Tab Handling ======
    public Page switchToNewTab() {
        Page newPage = page.context().waitForPage(() -> {
            // Some action that opens a new tab
        });
        return newPage;
    }

    public void switchToPageByUrl(String urlPart) {
        for (Page p : page.context().pages()) {
            if (p.url().contains(urlPart)) {
                this.page = p;
                p.bringToFront();
                break;
            }
        }
    }

    // ====== Alerts/Dialogs ======
    public void handleAlert(String action, String textToEnter) {
        page.onceDialog(dialog -> {
            if ("accept".equalsIgnoreCase(action)) {
                dialog.accept(textToEnter != null ? textToEnter : "");
            } else {
                dialog.dismiss();
            }
        });
    }
    public void dragAndDrop(Locator source, Locator target) {
        source.dragTo(target);
    }
    public void retryClick(Locator element, int maxRetries) {
        int attempts = 0;
        while (attempts < maxRetries) {
            try {
                element.click();
                break;
            } catch (PlaywrightException e) {
                attempts++;
                if (attempts == maxRetries) throw e;
            }
        }
    }

    public void downloadFile(Locator downloadButton, String savePath) {
        Download download = page.waitForDownload(() -> downloadButton.click());
        download.saveAs(Paths.get(savePath));
    }

    // ====== Keyboard & Mouse ======
    public void pressKey(String key) {
        page.keyboard().press(key);
    }

    public void mouseHover(int x, int y) {
        page.mouse().move(x, y);
    }

    public void mouseClick(int x, int y) {
        page.mouse().click(x, y);
    }

    // ====== File Upload ======
    public void uploadFile(Locator element, String filePath) {
        element.setInputFiles(Paths.get(filePath));
    }

    // ====== Screenshots ======
    public void takeScreenshot(String fileName) {
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("target/screenshots/" + fileName + ".png"))
                .setFullPage(true));
    }

    // ====== Page Utils ======
    public String getCurrentUrl() {
        return page.url();
    }

    public String getTitle() {
        return page.title();
    }

    public void navigateTo(String url) {
        page.navigate(url);
    }

    public Object evaluateJS(String script) {
        return page.evaluate(script);
    }
    public boolean verifyTextEquals(Locator element, String expected) {
        return element.innerText().equals(expected);
    }

    public void highlightElement(Locator element) {
        page.evaluate("element => element.style.border='3px solid red'", element);
    }

    public void clearCookies() {
        page.context().clearCookies();
    }
}
