package pageClasses;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.TestConfiguration;

/*
 * Page Class for DBS Home page
 * @author - Kesavan
 */
public class HomePage {
	WebDriver driver;
	Logger logger = Logger.getLogger(HomePage.class.getName());

	@FindBy(linkText = "Cards")
	WebElement cardsHyperlink;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isValid_PageTitle() {
		String expectedText = TestConfiguration.contentRepo.getProperty("HomePageTitle");
		logger.log(Level.INFO, driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase(expectedText))
			return true;
		else
			return false;
	}

	public void clickCards() {
		cardsHyperlink.click();
	}
}
