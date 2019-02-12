package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.RegistrationPage;
import utilities.LogManager;

public class RegistrationTests extends BaseTests
{
	@Test (description = "This test case is to verify that the firstname and lastname is entered.", groups= {"abc"})
	public void enterFirstNameAndLastNameTest()
	{
		RegistrationPage oRegistrationPage = null;
		oRegistrationPage = new RegistrationPage(driver);
		oRegistrationPage.enterFirstName("FirstName");
		LogManager.info("Entered firstname");
		Assert.assertEquals(oRegistrationPage.getFirstNameAttribute(), "firstname");
		oRegistrationPage.enterLastName();
		//Test case to fail
		Assert.assertEquals(oRegistrationPage.getLastNameAttribute(), "firsstname");
	}

	@Test (description = "This test case verifies whether the Male radio button is selected.")
	public void selectMaleRadioButtonTest()
	{
		RegistrationPage oRegistrationPage = null;
		oRegistrationPage = new RegistrationPage(driver);
		Assert.assertFalse(oRegistrationPage.getMaleRadioButtonStatus());
		oRegistrationPage.selectMaleRadioButton();
		LogManager.info("Selected Male Radio button");
		Assert.assertTrue(oRegistrationPage.getMaleRadioButtonStatus());
	}

	@Test (description = "This test case verifies whether the Automation Tester check box is selected.")
	public void selectAHobbyTest()
	{
		RegistrationPage oRegistrationPage = null;
		oRegistrationPage = new RegistrationPage(driver);
		oRegistrationPage.automationTesterCheckBox.click();
		LogManager.info("Clicked automationTesterCheckBox");
		Assert.assertTrue(oRegistrationPage.automationTesterCheckBox.isSelected());
	}

	@Test (description = "This test case verifies whether the country is selected.")
	public void selectCountryTest()
	{
		RegistrationPage oRegistrationPage = null;
		oRegistrationPage = new RegistrationPage(driver);
		Select select = new Select(oRegistrationPage.continentsDropdownBox);
		select.selectByIndex(1);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Europe");
	}

}