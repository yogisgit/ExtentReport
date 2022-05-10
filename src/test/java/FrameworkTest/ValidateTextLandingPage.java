package FrameworkTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.BaseDriver;

public class ValidateTextLandingPage extends BaseDriver {
	WebDriver driver;
	public static Logger log = LogManager.getLogger(Login.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		//getting the url from properties file (global variable)
		driver.get(prop.getProperty("url"));
		log.info("invoked url");
	}
	
	@Test
	public void validate() throws IOException {
		
		LandingPage lp = new LandingPage(driver);
		lp.noThanks().click();
		log.info("Clicked no thanks");
		Assert.assertEquals(lp.coursesText().getText(), "FEATURED COURSES");
		log.error("Validation failed");
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
