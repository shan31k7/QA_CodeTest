package driverFactory;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.TestConfiguration;

public class BrowserDriverFactory {

	public static WebDriver driver;
	public static Logger logger;

	public static WebDriver getDriver() {
		logger = Logger.getLogger(BrowserDriverFactory.class.getName());

		TestConfiguration.setConfiguration();
		String browser = TestConfiguration.environmentProperties.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup(); // chrome
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) { // edge
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			logger.log(Level.WARNING, "Kindly provide a valid Browser name. Acceptable values are chrome/firefox/ie");
		}
		return driver;
	}
}
