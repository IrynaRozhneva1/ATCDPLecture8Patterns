package ui.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import patterns.WebDriverSingleton;

/**
 * @author Iryna_Rozhneva
 */

public class EmailPage implements IPage {
	@FindBy(xpath = "//div[contains(@class,'ns-view-toolbar-button-spam')]//span[contains(text(),'Это спам!')]")
	private WebElement buttonSpam;
	
	public EmailPage() {
        PageFactory.initElements(WebDriverSingleton.getWebDriverInstance(), this);
    }

	public InboxPage markAsSpam() {
		buttonSpam.click();
		WebDriverSingleton.getWebDriverInstance().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println(PageLogFactory.initializeLog(this) + "Mark mail as spam");
		return new InboxPage();
	}
}