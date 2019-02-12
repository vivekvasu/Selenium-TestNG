package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory extends DriverParameter {
	protected static WebDriver wDriver = null;

	public static WebDriver getWebDriver(BrowserType browser)
	{
		switch (browser) 
		{
		case CHROME:
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			wDriver = new ChromeDriver();
			wDriver.manage().window().maximize();
			break;
		case IE:
			break;

		case FIREFOX:
			System.setProperty("webdriver.firefox.bin", fireFoxBinLocation);
			System.setProperty("webdriver.gecko.driver", fireFoxDriverPath);
			wDriver = new FirefoxDriver();
			wDriver.manage().window().maximize();
		}
		return wDriver;
	}
}
