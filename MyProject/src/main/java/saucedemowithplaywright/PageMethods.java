package saucedemowithplaywright;

import com.microsoft.playwright.Page;

public class PageMethods {

    private Page page;
    private PageLocators loc;

    public PageMethods(Page page)
    {
        this.page=page;
        loc=new PageLocators(page);
    }

    public void enterUsername(String username)
    {
        loc.username.fill(username);
    }
    public void enterPassword(String password)
    {
        loc.password.fill(password);
    }
    public void clicklogin()
    {
        loc.loginbutton.click();
    }
}
