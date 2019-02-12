package utilities;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.TestNG;
import org.testng.collections.Lists;
import org.xml.sax.SAXException;

public class TestNGRunner {

	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException
	{
		String xmlFileName = System.getProperty("user.dir") + File.separator + "suites\\RegressionSuite.xml";
		List<String> suites;
		TestNG testng = null;
		suites = Lists.newArrayList();
		suites.add(xmlFileName);
		testng = new TestNG();
		testng.setTestSuites(suites);
		testng.run();
	}

}
