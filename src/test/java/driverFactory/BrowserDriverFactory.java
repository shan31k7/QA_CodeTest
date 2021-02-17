package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserDriverFactory {

	public static WebDriver driver;

	public static WebDriver getDriver(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();	// chrome
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {	// edge
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Kindly provide a valid Browser name. Acceptable values are chrome/firefox/ie");
		}
		return driver;
	}
}
