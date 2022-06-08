package com.cricbuzz.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cricbuzz.pages.HomePageCricbuzz;

import resources.BaseDriver;

public class HomePageTest extends BaseDriver{
	WebDriver driver;
	
	@BeforeTest
	public void setUp() throws IOException {
		driver = initializeDriver();
	}
	
	@Test
	public void schedule() {
		HomePageCricbuzz hp = new HomePageCricbuzz(driver);
		hp.schedule().click();
		hp.link().click();
	}
	
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
}
