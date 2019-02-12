package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager 
{
	private static ExtentHtmlReporter htmlReporter = null;
	private static ExtentReports extent = null;
	
	public static ExtentReports  setExtentReports ()
	{
		htmlReporter = new ExtentHtmlReporter("extent.html");
		htmlReporter.config().setReportName("My Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("mm/dd/yyyy hh:mm:ss a");
		extent = new ExtentReports();
		extent.setSystemInfo("Platform", "Windows");
		extent.attachReporter(htmlReporter);
		return extent;
	}
}
