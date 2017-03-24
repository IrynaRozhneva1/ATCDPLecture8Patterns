package ui.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import patterns.WebDriverSingleton;

/**
 * @author Iryna_Rozhneva
 */

public class NewEmailPage implements IPage {
	@FindBy(xpath = "//div[@name='to']")
	private WebElement inputEmailRecipient;

	@FindBy(xpath = "//input[@name='subj']")
	private WebElement inputSubject;

	@FindBy(xpath = "//div[contains(@id,'cke_editor')]//div[contains(@class,'cke_wysiwyg_div') and @role='textbox']")
	private WebElement inputMessage;

	@FindBy(xpath = "//span[contains(@class,'ns-view-compose-send-link')]//button[contains(@class,'nb-button')]")
	private WebElement buttonSend;

	@FindBy(xpath = "//div[contains(@class,'ns-view-head-user')]//div[contains(@class,'mail-User-Picture')]")
	private WebElement userNameClick;

	@FindBy(xpath = "//a[contains(@class,'b-mail-dropdown') and text()='Выход']")
	private WebElement exitClick;
	
	public NewEmailPage() {
        PageFactory.initElements(WebDriverSingleton.getWebDriverInstance(), this);
    }

	public void sendEmail(String recipientEmail, String subject, String messageText) {
		inputEmailRecipient.sendKeys(recipientEmail);
		System.out.println(PageLogFactory.initializeLog(this) + "Set Recipient field: " + recipientEmail);
		inputSubject.sendKeys(subject);
		System.out.println(PageLogFactory.initializeLog(this) + "Set Subject field: " + subject);
		inputMessage.sendKeys(messageText);
		System.out.println(PageLogFactory.initializeLog(this) + "Set Message field: " + messageText);
		buttonSend.click();
		System.out.println(PageLogFactory.initializeLog(this) + "Send mail");
	}

	public StartPage exitFromAccount() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		userNameClick.click();
		System.out.println(PageLogFactory.initializeLog(this) + "Open user submenu");
		exitClick.click();
		WebDriverSingleton.getWebDriverInstance().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println(PageLogFactory.initializeLog(this) + "Click on exit");
		return new StartPage();
	}
}
