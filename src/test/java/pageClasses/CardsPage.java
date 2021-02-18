package pageClasses;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.TestConfiguration;

/*
 * Page Object class for DBS cards page
 * @author - kesavan
 */
public class CardsPage {
	WebDriver driver;
	Logger logger = Logger.getLogger(CardsPage.class.getName());

	@FindBy(linkText = "Credit Cards")
	WebElement creditCardsHyperlink;

	@FindBy(xpath = "(//label[@class='compare-label'])[1]")
	WebElement firstCompareCheckBox;

	@FindBy(xpath = "(//label[@class='compare-label'])[last()]")
	WebElement lastCompareCheckBox;

	@FindBy(id = "cardCompareBtn")
	WebElement compareButton;

	@FindBy(xpath = "//h4[text()='Useful Links']")
	WebElement usefulLinks;

	public CardsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public boolean isValid_PageTitle(String expectedText) {
		logger.log(Level.INFO, driver.getTitle());
		if (driver.getTitle().equalsIgnoreCase(expectedText))
			return true;
		else
			return false;
	}

	public void clickCreditCards() {
		creditCardsHyperlink.click();
	}

	public void clickFirstCompareCheckBox() {
		firstCompareCheckBox.click();
	}

	public void clickLastCompareCheckBox() {
		Actions actions = new Actions(driver);
		actions.moveToElement(usefulLinks).build().perform();
		lastCompareCheckBox.click();
	}

	public void clickCompare() {
		compareButton.click();
	}

	public boolean verifyCard1details() {
		String searchText = TestConfiguration.contentRepo.getProperty("FirstCardName");
		String dynamicXpath = "//*[contains(text(),\"" + searchText + "\")]";
		logger.log(Level.INFO, "Dynamic xpath: " + dynamicXpath);
		return driver.findElements(By.xpath(dynamicXpath)).size() > 0;
	}

	public boolean verifyCard2details() {
		String searchText = TestConfiguration.contentRepo.getProperty("LastCardName");
		String dynamicXpath = "//*[contains(text(),\"" + searchText + "\")]";
		logger.log(Level.INFO, "Dynamic xpath: " + dynamicXpath);
		return driver.findElements(By.xpath(dynamicXpath)).size() > 0;
	}
}
