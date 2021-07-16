package com.sample.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SamplePage {

	public WebDriver driver;
	public String valueOfTextBox;

	// Getting all the locators
	By valueField1 = By.id("lbl_Val_1");

	By valueField2 = By.id("lbl_Val_2");

	By valueField3 = By.id("lbl_Val_3");

	By valueField4 = By.id("lbl_Val_4");

	By valueField5 = By.id("lbl_Val_5");

	By totalBalanceField = By.id("lbl_ttl_Val");

	By valueText1 = By.id("txt_Val_1");

	By valueText2 = By.id("txt_Val_2");

	By valueText3 = By.id("txt_Val_4");

	By valueText4 = By.id("txt_Val_5");

	By valueText5 = By.id("txt_Val_6");

	By totalBalanceValue = By.id("txt_ttl_val");

	// Initializing the Page Objects:
	public SamplePage(WebDriver driver) {
		this.driver = driver;
	}

	// To check page loaded successfully
	public boolean validatePageLoaded() {
		return driver.findElement(totalBalanceValue).isDisplayed();
	}

	// Method to get the value from text box
	public String getValueOfTextBox(By value) {
		valueOfTextBox = driver.findElement(value).getAttribute("value");
		return valueOfTextBox;
	}

	// Get list of all Value fields
	public List<String> getValueFields() {
		List<String> values = new ArrayList<String>();
		values.add(getValueOfTextBox(valueField1));
		values.add(getValueOfTextBox(valueField2));
		values.add(getValueOfTextBox(valueField3));
		values.add(getValueOfTextBox(valueField4));
		values.add(getValueOfTextBox(valueField5));
		return values;
	}

	// Get list of all Text Values
	public List<String> getTextValues() {
		List<String> textValues = new ArrayList<String>();
		textValues.add(getValueOfTextBox(valueText1));
		textValues.add(getValueOfTextBox(valueText2));
		textValues.add(getValueOfTextBox(valueText3));
		textValues.add(getValueOfTextBox(valueText4));
		textValues.add(getValueOfTextBox(valueText5));
		return textValues;
	}

	// Validate Values Count
	public boolean validateCount() {
		// To check if the count are same
		if (getValueFields().size() == getTextValues().size())
			return true;
		return false;
	}

	// Check whether the value in a text box is greater than zero.
	public Boolean isValueGreaterThanZero(By value) {
		Double valueInDouble = this.getValueOfTextBoxInDouble(value);
		if (valueInDouble > 0)
			return true;
		return false;
	}

	public boolean areValuesGreatedThanZero() {
		if (isValueGreaterThanZero(valueText1) && isValueGreaterThanZero(valueText2)
				&& isValueGreaterThanZero(valueText3) && isValueGreaterThanZero(valueText4)
				&& isValueGreaterThanZero(valueText5))
			return true;
		return false;

	}

	// Check whether the expected value matches the actual value of a text box
	public Boolean checkBalance(Double expectedValue) {
		Double actualValueInDouble = this.getValueOfTextBoxInDouble(totalBalanceValue);
		if (actualValueInDouble == expectedValue)
			return true;
		return false;

	}

	// Get the value of the text box in double.
	public Double getValueOfTextBoxInDouble(By value) {
		String amount = this.getValueOfTextBox(value);
		String amountValue = amount.replace("$", "").replace(",", "");
		Double actualValueInDouble = Double.parseDouble(amountValue);
		return actualValueInDouble;
	}

	// Validate Total Balance with sum of individual values
	public Boolean validateTotalBalance() {
		double totalBalance = getValueOfTextBoxInDouble(totalBalanceValue);
		double sum = 0;
		for (String i : getValueFields()) {
			sum = sum + Double.parseDouble(i);
			System.out.println("Sum of all values are: " + sum);
		}
		if (totalBalance == sum)
			return true;
		return false;
	}

	// Validate all the values are formatted as currency
	public boolean isFormattedAsCurrency() {
		Boolean flag = false;
		for (String i : getTextValues()) {
			if (i.substring(0, 1).equals("$")) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}

}