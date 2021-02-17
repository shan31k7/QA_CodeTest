package testNG_tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import driverFactory.BrowserDriverFactory;
import pageClasses.CardsPage;
import pageClasses.HomePage;
import utility.ExtentReportWrapper;

public class SmokeTest {
	WebDriver driver;

	@BeforeMethod
	public void invokeBrowser() {
		driver = BrowserDriverFactory.getDriver();
		BrowserDriverFactory.openApplication();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	@Test
	public void compare2CreditCards() {
		// ExtentReportWrapper.createExtentTest(null);
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isValid_PageTitle(), "Home Page title is not as expected");
		homePage.clickCards();

		CardsPage cardsPage = new CardsPage(driver);
		cardsPage.clickCreditCards();
		cardsPage.clickFirstCompareCheckBox();
		cardsPage.clickLastCompareCheckBox();
		cardsPage.clickCompare();

		// Assert Card 1 details
		Assert.assertTrue(cardsPage.verifyCard1details(), "First card details are missing");

		// Assert Card 2 details
		Assert.assertTrue(cardsPage.verifyCard2details(), "Last card details are missing");
	}

}
