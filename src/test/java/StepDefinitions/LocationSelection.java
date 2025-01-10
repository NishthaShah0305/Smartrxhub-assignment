package StepDefinitions;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.tools.javac.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LocationSelection {

	private WebDriver driver;

	WebElement DropDown;

	public LocationSelection() {
		driver = WebDriverManager.getDriver();
	}

	@Given("click on select location dropdown")
	public void click_on_select_location_dropdown() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		DropDown = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mat-select-value-1\"]/span")));
		DropDown.click();
	}

	@When("choose location from dropdown")
	public void choose_location_from_dropdown() throws InterruptedException {
		Utils.addDelay();
		driver.findElement(By.xpath("//*[@id=\"mat-option-1\"]")).click();
	}

	@And("click confirm")
	public void click_confirm() throws InterruptedException {
		WebElement confirmButton = driver
				.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/fuse-confirm-location/div/div/div/button/span[1]"));
		Utils.addDelay();
		confirmButton.click();
	}

	@Then("land on trillium smartrx homepage")
	public void land_on_trillium_smartrx_homepage() {
		String expectedUrl = "https://trillium.smartrxhub.com/stg/panel/v9/#/management/dashboard?index=1";
		String actualUrl = driver.getCurrentUrl();
		assertEquals(expectedUrl, actualUrl);
	}
}
