package patterns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSingleton {
	private static WebDriver driver;

	private WebDriverSingleton() {
	}

	public static WebDriver getWebDriverInstance() {
		if (driver == null) {
			driver = new FirefoxDriver();
		}
		return driver;
	}
	public static void stopBrowser() {
		driver.quit();
		System.out.println("Browser is closing");
	}
}
