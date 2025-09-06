package saucedemowithplaywright;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class PageLocators {

    private Page page;
    public Locator username;
    public Locator password;
    public Locator loginbutton;

    public PageLocators(Page page)
    {
        this.page=page;
        this.username=page.locator("#user-name");
        this.password=page.locator("#password");
        this.loginbutton=page.locator("#login-button");
    }
}
