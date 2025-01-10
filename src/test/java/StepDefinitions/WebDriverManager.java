package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
	private static WebDriver driver;
	
	private WebDriverManager() {

	}

	public static WebDriver getDriver() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver","F:/nishtha/automation/Smartrxhub/src/test/resources/Drivers/chromedriver.exe");
	   		
		   	driver = new ChromeDriver();
		   	
		   	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		   	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		   	
			driver.manage().window().maximize();
		}
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
