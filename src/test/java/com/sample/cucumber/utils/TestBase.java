package com.sample.cucumber.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase extends Utilities {

	public static WebDriver driver;

	public void initialization() {
		// To Launch Chrome driver instance
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "src/test/java/Drivers/chromedriver");
		driver = new ChromeDriver();

		// Maximize Window
		driver.manage().window().maximize();

		// Default Page loading timeout
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

	public void closeBrowser() {
		// Close the browser sessions
		driver.close();
		driver.quit();
	}

}
