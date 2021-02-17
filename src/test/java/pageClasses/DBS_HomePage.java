package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DBS_HomePage {
	WebDriver driver;

	@FindBy(linkText = "Cards")
	WebElement cardsHyperlink;

	public DBS_HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isValid_PageTitle(String expectedText) {
		System.out.println(driver.getTitle());
		if (driver.getTitle().equalsIgnoreCase(expectedText))
			return true;
		else
			return false;
	}

	public void clickCards() {
		cardsHyperlink.click();
	}
}
