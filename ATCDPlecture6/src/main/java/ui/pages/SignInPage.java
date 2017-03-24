package ui.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import patterns.WebDriverSingleton;

/**
 * @author Iryna_Rozhneva
 */
public class SignInPage implements IPage {

    @FindBy(xpath = "//input[@name='login']")
    private WebElement inputLogin;

    @FindBy(xpath = "//input[@name='passwd']")
    private WebElement inputPassword;

    @FindBy(xpath = "//span[contains(@class,'new-auth-submit')]//button[@type='submit']")
    private WebElement buttonSignIn;
    
    public SignInPage() {
        PageFactory.initElements(WebDriverSingleton.getWebDriverInstance(), this);
    }

    public InboxPage signIn(String username, String password){
    	inputLogin.clear();
        inputLogin.sendKeys(username);
        System.out.println(PageLogFactory.initializeLog(this) + "Set Username field: " + username);
        inputPassword.sendKeys(password);
        System.out.println(PageLogFactory.initializeLog(this) + "Set Password field: " + password);
        buttonSignIn.click();
        WebDriverSingleton.getWebDriverInstance().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println(PageLogFactory.initializeLog(this) + "Login");
        return new InboxPage();
    }
}
