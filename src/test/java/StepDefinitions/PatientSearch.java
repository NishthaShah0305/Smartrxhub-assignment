package StepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PatientSearch {

	WebDriver driver = WebDriverManager.getDriver();
	WebElement suggestions;
	WebElement DropDown;
	WebElement card_num;
	WebElement ph_num;
	WebElement first_name;
	WebElement last_name;

	// Health card field test
	@Given("click on health card select field")
	public void click_on_health_card_select_field() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		DropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/app-main-layout/app-patient-check-in/section/div/app-case-info/div[1]/div/div[2]/div[1]/div[2]/mat-form-field")));
		DropDown.click();
	}

	@When("select one option from dropdown")
	public void select_one_option_from_dropdown() throws InterruptedException {
		WebElement location = driver.findElement(By.xpath("//*[@id=\"mat-option-2\"]"));
		Utils.addDelay();
		location.click();
	}

	@Then("check the dropdown option is selected")
	public void check_the_dropdown_option_is_selected() {

	}
	

	// check card number field and add new patient button
	@Given("check record not found is displayed")
	public void check_record_not_found_is_displayed() throws InterruptedException {
		card_num = driver.findElement(By.id("mat-input-2"));
		card_num.sendKeys("1235467813");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/app-main-layout/app-patient-check-in/section/div/app-case-info/div[1]/div/div[3]/div[1]/p")));
		Utils.addDelay();
	}

	@When("click on Add New Patient button")
	public void click_on_add_new_patient_button() throws InterruptedException {
		WebElement add_new_patient = driver.findElement(By.xpath(
				"/html/body/app-root/app-main-layout/app-patient-check-in/section/div/app-case-info/div[1]/div/div[3]/div[2]/div/div/div/button/span[1]"));
		add_new_patient.click();

		Utils.addDelay();

		WebElement cancel = driver.findElement(By.xpath(
				"/html/body/app-root/app-main-layout/app-patient-check-in/section/div/app-case-info/div[2]/div/form/div[2]/button[2]"));
		cancel.click();
	}

	@Then("click on card number and search with text")
	public void click_on_card_number_and_search_with_text() {
		card_num.sendKeys("123");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/app-main-layout/app-patient-check-in/section/div/app-case-info/div[1]/div/div[3]/div[1]/div[1]/div[2]/p")));
	}

	// check for phone number field
	@Given("Enter new number not in the system")
	public void enter_new_number_not_in_the_system() {
		ph_num = driver.findElement(By.id("phone-number"));
		ph_num.sendKeys("3434238241");
		driver.findElement(By.xpath(
				"/html/body/app-root/app-main-layout/app-patient-check-in/section/div/app-case-info/div[1]/div/div[3]/div[1]/p"));
	}

	@When("record not found is displayed for phone number")
	public void record_not_found_is_displayed_for_phone_number() {
		System.out.println("Record not found");
	}

	@Then("show suggestions related to phone number")
	public void show_suggestions_related_to_phone_number() {
		ph_num.clear();
		ph_num.sendKeys("4444444444");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/app-main-layout/app-patient-check-in/section/div/app-case-info/div[1]/div/div[3]/div[1]/div[1]/div[3]/div[1]/p")));

	}

	// check for first name field
	@Given("Enter new first name not in the system")
	public void enter_new_first_name_not_in_the_system() throws InterruptedException {
		first_name = driver.findElement(By.id("mat-input-5"));
		first_name.sendKeys("Joe");
		driver.findElement(By.xpath(
				"/html/body/app-root/app-main-layout/app-patient-check-in/section/div/app-case-info/div[1]/div/div[3]/div[1]/p"));
		Utils.addDelay();
	}

	@When("record not found is displayed for first name")
	public void record_not_found_is_displayed_for_first_name() {

		System.out.println("Record not found");
	}

	@Then("show suggestions related to first name")
	public void show_suggestions_related_to_first_name() {
		first_name.clear();
		first_name.sendKeys("Alankrit");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/app-main-layout/app-patient-check-in/section/div/app-case-info/div[1]/div/div[3]/div[1]/div[1]/div[2]/p")));
	}

	// check for last name field
	@Given("Enter new last name not in the system")
	public void enter_new_last_name_not_in_the_system() {
		last_name = driver.findElement(By.id("mat-input-6"));
		last_name.sendKeys("john");
		driver.findElement(By.xpath(
				"/html/body/app-root/app-main-layout/app-patient-check-in/section/div/app-case-info/div[1]/div/div[3]/div[1]/p"));
	}

	@When("record not found is displayed for last name")
	public void record_not_found_is_displayed_for_last_name() {
		System.out.println("Record not found");
	}

	@Then("show suggestions related to last name")
	public void show_suggestions_related_to_last_name() {
		last_name.clear();
		last_name.sendKeys("Test");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/app-main-layout/app-patient-check-in/section/div/app-case-info/div[1]/div/div[3]/div[1]/div/div[3]/div[1]/p")));
	}

}
