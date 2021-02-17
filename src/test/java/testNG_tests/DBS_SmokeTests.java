package testNG_tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import driverFactory.BrowserDriverFactory;
import pageClasses.DBS_HomePage;

public class DBS_SmokeTests {
	WebDriver driver;
	Properties envprop, contentRepo, objectRepo;

	@BeforeTest
	public void invokeBrowser() throws FileNotFoundException, IOException {
		envprop = new Properties();
		envprop.load(new FileReader(
				new File(System.getProperty("user.dir") + "/src/test/resources/EnvironmentVariables.properties")));

		contentRepo = new Properties();
		contentRepo.load(new FileReader(
				new File(System.getProperty("user.dir") + "/src/test/resources/ContentRepository.properties")));

		objectRepo = new Properties();
		objectRepo.load(new FileReader(
				new File(System.getProperty("user.dir") + "/src/test/resources/ObjectRepository.properties")));

		driver = BrowserDriverFactory.getDriver(envprop.getProperty("browser"));
		driver.get(envprop.getProperty("QA_App_URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void verifyPageTitle() {
		DBS_HomePage dbs_homePage = new DBS_HomePage(driver);
		Assert.assertTrue(dbs_homePage.isValid_PageTitle(contentRepo.getProperty("PageTitle")),
				"Page title is not same as expected text");
	}

}
