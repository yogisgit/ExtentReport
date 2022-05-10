package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPassword {
	WebDriver driver;
	
	public ForgotPassword(WebDriver driver) {
		this.driver = driver;
	}
	
	private By email = By.id("user_email");
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submit;
	
	public WebElement email() {
		return driver.findElement(email);
	}
	public WebElement submit() {
		return submit;
	}
}
