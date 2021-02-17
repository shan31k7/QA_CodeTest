package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DBS_CardsPage {
	WebDriver driver;

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

	public DBS_CardsPage(WebDriver driver) {
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

	public boolean verifyTextPresent(String searchText) {
		String dynamicXpath = "//*[contains(text(),\"" + searchText + "\")]";
		System.out.println("Dynamic xpath: " + dynamicXpath);
		return driver.findElements(By.xpath(dynamicXpath)).size() > 0;
	}
}