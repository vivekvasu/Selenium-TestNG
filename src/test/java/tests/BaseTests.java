package tests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.BrowserType;
import utilities.DriverFactory;
import utilities.ExtentManager;
import utilities.LogManager;
import utilities.WebDriverListener;

public class BaseTests 
{
	EventFiringWebDriver driver = null;
	WebDriverListener listener =  null;
	private static ExtentReports extent;
	public static ThreadLocal<ExtentTest> testSuite = new ThreadLocal<ExtentTest>();
	public static ThreadLocal <ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
	public static ThreadLocal <ExtentTest> testMethods = new ThreadLocal<ExtentTest>();
	public static HashMap<String, String> elementsMap = new HashMap<String, String>();

	@BeforeSuite
	public void initialSetUp(ITestContext context)
	{
		ExtentTest parentXmlSuite = null;
		String log4jConfigFile = "";
		log4jConfigFile = System.getProperty("user.dir") + File.separator + "src\\resources\\log4j.xml";
		System.setProperty("log4j.configurationFile", log4jConfigFile);
		LogManager.info("Running .." + context.getCurrentXmlTest().getSuite().getName());
		extent = ExtentManager.setExtentReports();
		parentXmlSuite = extent.createTest(context.getCurrentXmlTest().getSuite().getName());
		testSuite.set(parentXmlSuite);
		WebDriver wDriver = DriverFactory.getWebDriver(BrowserType.CHROME);
		driver = new EventFiringWebDriver(wDriver);
		listener = new WebDriverListener();
		driver.register(listener);
		driver.get("https://www.toolsqa.com/automation-practice-form/");
	}

	@BeforeMethod
	public void beforeMethod(Method method) 
	{
		ExtentTest methods = testSuite.get().createNode(method.getName());
		testMethods.set(methods);
		methods.log(Status.INFO, "Started running '" + method.getName());
	}

	@AfterMethod
	public void afterMethod (ITestResult result)
	{
		if (result.getStatus() == ITestResult.SUCCESS)
		{
			LogManager.info(result.getName() + " is Passed.");
			testMethods.get().pass("Test Passed");
		}
		else if (result.getStatus() == ITestResult.FAILURE)
		{
			LogManager.info(result.getName() + " is Failed.");
			testMethods.get().fail(result.getThrowable());
			File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String sFileName = "";
			sFileName = "C:\\Users\\Vivek\\workspace\\Selenium\\Screenshots\\" + result.getName() + System.currentTimeMillis() + ".png";
			try 
			{
				FileUtils.copyFile(image, new File(sFileName));
				LogManager.info("Failed screenshot saved in the location " + sFileName);
				testMethods.get().addScreenCaptureFromPath(sFileName);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else if (result.getStatus() == ITestResult.SKIP)
		{
			LogManager.info(result.getName() + "is Skipped.");
			testMethods.get().skip(result.getThrowable());
		}
	}

	@AfterSuite
	public void quitBrowser ()
	{
		extent.flush();
		driver.unregister(listener);
		driver.close();
		driver.quit();
	}
}
