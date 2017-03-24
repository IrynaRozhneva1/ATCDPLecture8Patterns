package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import patterns.WebDriverSingleton;

/**
 * @author Iryna_Rozhneva
 */
public class StartPage implements IPage {

    @FindBy(xpath = "//a[contains(@class,'link') and text()='Почта']")
    private WebElement buttonEmailToOpenSignInPage;

    public StartPage() {
        PageFactory.initElements(WebDriverSingleton.getWebDriverInstance(), this);
    }

    public void open(String url) {
    	WebDriverSingleton.getWebDriverInstance().get(url);
        System.out.println(PageLogFactory.initializeLog(this) + "Yandex is opened");
    }

    public SignInPage invokeSignIn() {
    	buttonEmailToOpenSignInPage.click();
    	System.out.println(PageLogFactory.initializeLog(this) + "Open login form");
        return new SignInPage();
    }
}
