package pages;

import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import tests.BaseTests;

public class pageObject 
{
	public pageObject(WebDriver wDriver) 
	{
		PageFactory.initElements(wDriver, this);
		try 
		{
			Field[] fields = this.getClass().asSubclass(this.getClass()).getDeclaredFields();
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

}
