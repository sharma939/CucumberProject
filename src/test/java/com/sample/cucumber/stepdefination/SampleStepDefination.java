package com.sample.cucumber.stepdefination;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.sample.cucumber.utils.TestBase;
import com.sample.cucumber.webpages.SamplePage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SampleStepDefination extends TestBase {

	WebDriver driver;
	SamplePage samplePage = new SamplePage(driver);
	Logger log = Logger.getLogger(this.getClass());

	@Given("^User navigates to test Url$")
	public void user_navigates_to_test_Url() throws Throwable {
		try {
			// To check page loaded successfully
			samplePage.validatePageLoaded();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Application did not launch successfully, Please check the URL and try again!!");
		}
	}

	@Then("^Ensure correct count of values appears on the screen$")
	public void ensure_correct_count_of_values_appears_on_the_screen() throws Throwable {
		try {
			// Validate the count
			if (samplePage.validateCount()) {
				log.info("Correct count of values are present on the screen");
			} else {
				log.error("Correct count of values are NOT present on the screen");
				Assert.fail("Some values are either extra/missing on the screen, Please check and try again!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error in getting the values count, Please check and try again!!");
		}
	}

	@Then("^Check the values on the screen are greater than Zero")
	public void check_the_values_on_the_screen_are_greater_than_zero() throws Throwable {
		try {
			if (samplePage.areValuesGreatedThanZero()) {
				log.info("All the amount values on the screen are greated than zero");
			} else {
				log.error("All the amount values on the screen are NOT greated than zero");
				Assert.fail("Value/Values are not greater than zero, Please check and try again!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error in getting the amount values, Please check and try again!!");
		}
	}

	@Then("^Verify Total balance is correct based on the values listed on the screen$")
	public void verify_Total_balance_is_correct_based_on_the_values_listed_on_the_screen(DataTable arg1)
			throws Throwable {
		try {
			List<List<String>> data = arg1.raw();
			if (samplePage.checkBalance(Double.parseDouble(data.get(0).get(0)))) {
				log.info("Total balance is showing correct based on the values listed on the screen");
			} else {
				log.error("Total balance is NOT correct based on the values listed on the screen");
				Assert.fail("Total balance is showing incorrect value, Please check and try again!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error in getting the amount values, Please check and try again!!");
		}
	}

	@Then("^Ensure values are formatted as currencies$")
	public void ensure_values_are_formatted_as_currencies() throws Throwable {
		try {
			if (samplePage.isFormattedAsCurrency()) {
				log.info("All the amount values are formatted correctly in currencies");
			} else {
				log.error("All the amount values are NOT formatted correctly in currencies");
				Assert.fail("Amount vlaues are not formatted correctly, Please check and try again!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error in getting the amount values, Please check and try again!!");
		}
	}

	@Then("^Verify Total balance matches the sum of the values$")
	public void verify_Total_balance_matches_the_sum_of_the_values() throws Throwable {
		try {
			if (samplePage.validateTotalBalance()) {
				log.info("Total balance is matching with the sum of values listed on the screen");
			} else {
				log.error("Total balance is NOT matching with the sum of values listed on the screen");
				Assert.fail("Sum of all values is not equal to Total Balance, Please check and try again!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error in getting the amount values, Please check and try again!!");
		}
	}

}
