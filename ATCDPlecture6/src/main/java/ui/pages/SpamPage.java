package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import patterns.WebDriverSingleton;

/**
 * @author Iryna_Rozhneva
 */

public class SpamPage implements IPage {
	@FindBy(xpath = "//span[text()='Iryna Test']/../../..//span[@class='mail-MessageSnippet-Item mail-MessageSnippet-Item_subject']/span")
	private WebElement spamSubject;
	
	public SpamPage() {
        PageFactory.initElements(WebDriverSingleton.getWebDriverInstance(), this);
    }

	public String getSpamSubject() {
		return spamSubject.getText();
	}
}
