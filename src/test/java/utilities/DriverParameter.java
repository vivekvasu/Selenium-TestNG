package utilities;

/**
 * DriverParameters class is used to set up the driver parameters
 * 
 * @version 0.0.1.0 Date: Mar 1, 2018 10:29:56 AM
 * @see DriverParameters#isHeadless
 * @see DriverParameters#driverType
 * @see DriverParameters#browserType
 * @see DriverParameters#browserVersion
 * @see DriverParameters#applicationPath
 * @see DriverParameters#mobileOS
 * @see DriverParameters#host
 * @see DriverParameters#port
 **/
public class DriverParameter {
	/**
	 * boolean object for identifying whether the execution should be headless or not. <b>NOTE:</b>
	 * Only valid for desktop chrome browser
	 **/
	public static boolean isHeadless = false;
	/**
	 * String object for Desktop OS
	 **/
	public static String platform;
	/**
	 * String object for specifying driver type
	 **/
	public static String driverType;
	/**
	 * String object for browser type. Ex: Chrome, Firefox, IE, Safari, etc.
	 **/
	/**
	 * String object for the browser version for the corresponding type
	 **/
	final public static String chromeDriverPath = "F:/Automation/Selenium/Chrome Driver/chromedriver.exe";

	final public static String fireFoxDriverPath = "F:/Automation/Selenium/FireFox Driver/geckodriver.exe";

	final public static String ieDriverPath = "F:/Automation/Selenium/Chrome Driver/chromedriver.exe";

	public static String fireFoxBinLocation = "C:/Program Files (x86)/Mozilla Firefox/firefox.exe";
	/**
	 * String object for windows desktop application path
	 **/
	public String browserVersion;
	/**
	 * String object for windows desktop application path
	 **/
	public String applicationPath;
	/**
	 * String object for mobile OS, if the driver type is mobile
	 **/
	public String mobileOS;
	/**
	 * String object for the host url
	 **/
	public String host;
	/**
	 * String object for port
	 **/
	public String port;
}

