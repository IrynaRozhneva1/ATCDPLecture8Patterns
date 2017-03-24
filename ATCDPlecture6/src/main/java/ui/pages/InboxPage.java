package ui.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import patterns.WebDriverSingleton;

/**
 * @author Iryna_Rozhneva
 */

public class InboxPage implements IPage {
	@FindBy(xpath = "//span[contains(@class,'mail-Toolbar-Item-Text') and text()='Написать']")
	private WebElement buttonNewEmail;
	
	@FindBy(xpath = "//span[text()='Iryna Test']")
	private WebElement tapOnEmail;
	
	@FindBy(xpath = "//span[contains(@class,'mail-NestedList-Item-Name') and text()='Спам']")
	private WebElement tapOnSpam;
	
	public InboxPage() {
        PageFactory.initElements(WebDriverSingleton.getWebDriverInstance(), this);
    }

	public NewEmailPage invokeNewMessage() {
		buttonNewEmail.click();
		WebDriverSingleton.getWebDriverInstance().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println(PageLogFactory.initializeLog(this) + "Open new mail wizard");
		return new NewEmailPage();
	}
	
	public EmailPage openEmail() {
		tapOnEmail.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(PageLogFactory.initializeLog(this) + "Open mail");
		return new EmailPage();
	}
	
	public SpamPage openSpam() {
		tapOnSpam.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(PageLogFactory.initializeLog(this) + "Open mail in spam");
		return new SpamPage();
	}
}