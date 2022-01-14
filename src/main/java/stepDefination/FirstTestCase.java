package stepDefination;

import org.openqa.selenium.WebDriver;

import com.akamai.base.BasePage;
import com.akamai.pageObject.JobSerachPageObjects;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FirstTestCase {

	WebDriver driver;
	JobSerachPageObjects jobSerachPageObjects;

	@Given("Customer is on {string}")
	public void customer_is_on(String string) {
		driver = BasePage.getDriver();
		driver.manage().window().maximize();
		driver.get(string);
		jobSerachPageObjects = new JobSerachPageObjects(driver);
	}

	@When("Customer specifies Find Your Career: {string}")
	public void customer_specifies_find_your_career_senior_software_development_engineer_in_test(String string) {
		jobSerachPageObjects.sendJobKeyword(string);
	}

	@When("Filter by country: {string}")
	public void filter_by_country_poland(String string) throws InterruptedException {
		jobSerachPageObjects.filterbycountry(string);
	}

	@Then("Any job offers are found")
	public void any_job_offers_are_found() throws InterruptedException {
		jobSerachPageObjects.jobOffers();
	}

	@When("Customer specifies Find Your Career {string}")
	public void customer_specifies_find_your_career(String string) throws InterruptedException {
		jobSerachPageObjects.findYourCareer(string);
	}

	@Then("Notification about no offers found is displayed: {string}")
	public void notification_about_no_offers_found_is_displayed_we_found_jobs_based_on_your_search_criteria(
		String string) throws InterruptedException {
		jobSerachPageObjects.noJobOffers(string);
	}

}
