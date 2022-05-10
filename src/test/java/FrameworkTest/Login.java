package FrameworkTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgotPassword;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.BaseDriver;

public class Login extends BaseDriver {
	WebDriver driver;
	public static Logger log = LogManager.getLogger(Login.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
	}
	
	@Test(dataProvider="loginData")
	public void login(String email, String password, String text) throws IOException {
		
		//getting the url from properties file (global variable)
		//we are having this get url in our test because we are 
		//passing parameters and we want many instance to be run on this browser
		//if we keep this in setup then only one browser opens and tests will fail for isntances
		driver.get(prop.getProperty("url"));
		
		LandingPage lp = new LandingPage(driver);
		lp.noThanks().click();
		
		//getting the login page object from landing page special object
		LoginPage lo = lp.login();
		lo.email().sendKeys(email);
		lo.password().sendKeys(password);
		System.out.println(text);
		lo.submit().click();
		
		//getting the forgot password page object from login page special object
		ForgotPassword fp = lo.forgotPassword();
		fp.email().sendKeys("abc@gmal.com");
		fp.submit().click();
		
	}
	
	@DataProvider
	public Object[][] loginData() {
		Object[][] ob = new Object[2][3];
		
		ob[0][0] = "restricted@gmail.com";
		ob[0][1] = "12345";
		ob[0][2] = "Restricted user";
		
		ob[1][0] = "nonrestricted@gmail.com";
		ob[1][1] = "12345";
		ob[1][2] = "Non Restricted user";
		
		return ob;
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}



















