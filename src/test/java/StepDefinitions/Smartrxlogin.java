package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Smartrxlogin {

	WebDriver driver = WebDriverManager.getDriver();

	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("Browser is now open");
	}

	@When("user is on login page")
	public void user_is_on_login_page() {

		driver.navigate().to("https://trillium.smartrxhub.com/stg/panel/");
	}

	@And("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys(username);
		Utils.addDelay();

		driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).sendKeys(password);
		Utils.addDelay();

	}

	@Then("clicks on login button")
	public void clicks_on_login_button() throws InterruptedException {
		WebElement loginButton = driver.findElement(By.xpath(
				"/html/body/app-root/app-auth-layout/app-signin/div/div/div/div/div/div[2]/div/form/div[4]/div/button/span[1]"));

		loginButton.click();
		Utils.addDelay();
	}

	@Then("^the result should be (.*)$")
	public void the_result_should_be_message(String message) {
		if (message.equals("success")) {
			driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/fuse-confirm-location/div/div/div/span"));
		} else if (message.equals("incorrect")) {
			driver.findElement(By.xpath(
					"/html/body/app-root/app-auth-layout/app-signin/div/div/div/div/div/div[2]/div/form/div[1]"));

		}
	}

}
