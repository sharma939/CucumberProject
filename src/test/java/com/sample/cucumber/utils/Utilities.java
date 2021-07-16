package com.sample.cucumber.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Utilities {

	public static WebDriver driver;
	public static Properties prop;

	public void readPropertiesData() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/UAT/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String testURL = prop.getProperty("testURL");

}
