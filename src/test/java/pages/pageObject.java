package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class pageObject 
{
	public pageObject(WebDriver wDriver) 
	{
		PageFactory.initElements(wDriver, this);
	}

}
