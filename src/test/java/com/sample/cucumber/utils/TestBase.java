package com.sample.cucumber.utils;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class TestBase extends Utilities {

	public WebDriver driver;

	@Before
	public void initialization() throws IOException {
		System.out.println("Calling Before Method");
		Utilities.setUp();
	}

	@After
	public void closeBrowser() {
		System.out.println("Calling After Method");
		Utilities.tearDown();
	}

}
