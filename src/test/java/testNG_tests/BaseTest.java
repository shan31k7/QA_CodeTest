package testNG_tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import driverFactory.BrowserDriverFactory;
import utility.TestConfiguration;

public class BaseTest {
	WebDriver driver;

	@BeforeMethod
	public void invokeBrowser() {
		driver = BrowserDriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		openApplication();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	private void openApplication() {
		driver.get(TestConfiguration.environmentProperties.getProperty("QA_App_URL"));

	}

}
