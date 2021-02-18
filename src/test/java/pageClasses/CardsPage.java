package pageClasses;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * Page Object class for DBS cards page
 * @author - kesavan
 */
public class CardsPage {
	WebDriver driver;
	Logger logger = Logger.getLogger(CardsPage.class.getName());
	String storedFirstCardName, storedLastCardName;

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

	@FindBy(xpath = "(//img[@class='cardcontainer-img'])[1]/following-sibling::div/div")
	WebElement firstCardName;

	@FindBy(xpath = "(//img[@class='cardcontainer-img'])[last()]/following-sibling::div/div")
	WebElement lastCardName;

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
		storedFirstCardName = firstCardName.getText();
		firstCompareCheckBox.click();
	}

	public void clickLastCompareCheckBox() {
		Actions actions = new Actions(driver);
		actions.moveToElement(usefulLinks).build().perform();
		
		storedLastCardName = lastCardName.getText();
		lastCompareCheckBox.click();
	}

	public void clickCompare() {
		compareButton.click();
	}

	public boolean isCard1Exists() {
		return verifyCardExists(storedFirstCardName);
	}

	public boolean isCard2Exists() {
		return verifyCardExists(storedLastCardName);
	}

	public boolean verifyCardExists(String cardName) {
		// String searchText = TestConfiguration.contentRepo.getProperty(cardName);
		String dynamicXpath = "//*[contains(text(),\"" + cardName + "\")]";
		logger.log(Level.INFO, "Dynamic xpath: " + dynamicXpath);
		return driver.findElements(By.xpath(dynamicXpath)).size() > 0;
	}

}
