package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReporterDemo {
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("BeforeTest");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("BeforeMethod");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("AfterMethod");
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("AfterTest");
	}
	
	@Test
	public void testReport()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Automation\\Selenium\\Chrome Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Reporter.log("Browser Opened");
		driver.manage().window().maximize();
		Reporter.log("Browser Maximized");
		driver.get("http://www.google.com");
		Reporter.log("Application started");
		driver.quit();
		Reporter.log("Application closed");

	}
	
	@Test
	public void testReport1()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Automation\\Selenium\\Chrome Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Reporter.log("Browser Opened");
		driver.manage().window().maximize();
		Reporter.log("Browser Maximized");
		driver.get("http://www.google.com");
		Reporter.log("Application started");
		driver.quit();
		Reporter.log("Application closed");

	}

}
