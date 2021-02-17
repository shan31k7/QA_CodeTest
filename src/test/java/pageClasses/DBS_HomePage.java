package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DBS_HomePage {
	WebDriver driver;
		
	public DBS_HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public boolean isValid_PageTitle(String expectedText)
	{
		if(driver.getTitle().equalsIgnoreCase(expectedText))
			return true;
		else
			return false;
	}
	
	public void clickCards()
	{
		//driver.findElement()
	}
}
