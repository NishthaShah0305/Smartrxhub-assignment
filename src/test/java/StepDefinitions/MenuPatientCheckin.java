package StepDefinitions;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MenuPatientCheckin {
	WebDriver driver = WebDriverManager.getDriver();

	@Given("Expand main menu")
	public void expand_main_menu() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/app-root/app-main-layout/app-header/nav/div/div[2]/ul[1]/li/button")).click();
		Utils.addDelay();
	}

	@When("click on Administration")
	public void click_on_administration() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"leftsidebar\"]/div/ul/li[1]/a")).click();
		Utils.addDelay();
	}

	@And("click on patient check in")
	public void click_on_patient_check_in() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"leftsidebar\"]/div/ul/li[1]/ul/li[1]"))).click();
		Utils.addDelay();
	}

	@Then("patient check in module opens")
	public void patient_check_in_module_opens() {
	}
}
