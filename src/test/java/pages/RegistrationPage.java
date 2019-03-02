package pages;

import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import tests.BaseTests;

public class RegistrationPage extends pageObject
{
	public RegistrationPage(WebDriver wDriver) 
	{
		super(wDriver);
		try 
		{
			Field[] fields = this.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) 
			{
				BaseTests.elementsMap.put(fields[i].get(this).toString(), fields[i].getName());
			}
		} catch (IllegalArgumentException e) 
		{
			e.printStackTrace();
		} catch (IllegalAccessException e) 
		{
			e.printStackTrace();
		}
	}

	@FindBy(name = "firstname")
	public WebElement firstName;

	@FindBy(name = "lastname")
	public WebElement lastName;

	@FindBy(id = "sex-0")
	public WebElement maleRadioButton;

	@FindBy(id = "profession-1")
	public WebElement automationTesterCheckBox;

	@FindBy(how = How.ID, using = "continents")
	public WebElement continentsDropdownBox;


	public void enterFirstName(String text)
	{
		firstName.clear();
		firstName.sendKeys(text);
	}

	public String getFirstNameAttribute()
	{
		String sText = firstName.getAttribute("value");
		return sText;
	}

	public void enterLastName()
	{
		lastName.sendKeys("firstname");
	}

	public String getLastNameAttribute()
	{
		String sText = lastName.getAttribute("value");
		return sText;
	}

	public void selectMaleRadioButton()
	{
		maleRadioButton.click();
	}

	public boolean getMaleRadioButtonStatus()
	{
		if (maleRadioButton.isSelected())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
