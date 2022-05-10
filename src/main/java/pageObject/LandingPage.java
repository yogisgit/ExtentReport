package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By login = By.cssSelector("a[href*='sign_in']");
	private By noThanks = By.xpath("//button[text()='NO THANKS']");
	private By coursesText = By.xpath("//div[@class='text-center']/h2");
	private By contact = By.linkText("Contact");
	
	public LoginPage login() {
		driver.findElement(login).click();
		return new LoginPage(driver);
		
	}
	public WebElement noThanks() {
		return driver.findElement(noThanks);
	}
	public WebElement coursesText() {
		return driver.findElement(coursesText);
	}
	public WebElement contact() {
		return driver.findElement(contact);
	}
	
}
