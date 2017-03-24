package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import patterns.WebDriverSingleton;
import ui.pages.StartPage;

public class BaseTest {

	public static final String BASE_URL = "https://yandex.ru";
	protected StartPage startPage;

	@BeforeClass(alwaysRun = true, description = "Launch Browser")
	public void launchBrowser() {
		startPage = new StartPage();
		startPage.open(BASE_URL);
	}

	@AfterClass(alwaysRun = true, description = "Stop Browser")
	public void closeBrowser() {
		WebDriverSingleton.stopBrowser();
	}

}
