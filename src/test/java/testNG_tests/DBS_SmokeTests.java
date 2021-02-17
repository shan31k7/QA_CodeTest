package testNG_tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import driverFactory.BrowserDriverFactory;
import pageClasses.DBS_CardsPage;
import pageClasses.DBS_HomePage;

public class DBS_SmokeTests {
	WebDriver driver;
	Properties envprop, contentRepo;

	@BeforeTest
	public void invokeBrowser() throws FileNotFoundException, IOException {
		envprop = new Properties();
		envprop.load(new FileReader(
				new File(System.getProperty("user.dir") + "/src/test/resources/EnvironmentVariables.properties")));

		contentRepo = new Properties();
		contentRepo.load(new FileReader(
				new File(System.getProperty("user.dir") + "/src/test/resources/ContentRepository.properties")));

		driver = BrowserDriverFactory.getDriver(envprop.getProperty("browser"));
		driver.get(envprop.getProperty("QA_App_URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

	@Test
	public void compare2CreditCards() throws InterruptedException {

		DBS_HomePage homePage = new DBS_HomePage(driver);
		Assert.assertTrue(homePage.isValid_PageTitle(contentRepo.getProperty("HomePageTitle")),
				"Home Page title is not as expected");
		homePage.clickCards();

		DBS_CardsPage cardsPage = new DBS_CardsPage(driver);
		cardsPage.clickCreditCards();
		cardsPage.clickFirstCompareCheckBox();
		cardsPage.clickLastCompareCheckBox();
		cardsPage.clickCompare();

		// Assert Card 1 details
		Assert.assertTrue(cardsPage.verifyTextPresent(contentRepo.getProperty("FirstCardName")),
				"First card details are missing");

		// Assert Card 2 details
		Assert.assertTrue(cardsPage.verifyTextPresent(contentRepo.getProperty("LastCardName")),
				"Last card details are missing");

	}

}
