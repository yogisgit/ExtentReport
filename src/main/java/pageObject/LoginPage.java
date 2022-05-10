package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@type='email']")
	private WebElement email;
	
	@FindBy(css="input[type='password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submit;
	
	private By forgotPassword = By.linkText("Forgot Password?");
	
	public WebElement email() {
		return email;
	}
	public WebElement password() {
		return password;
	}
	public WebElement submit() {
		return submit;
	}
	public ForgotPassword forgotPassword() {
		driver.findElement(forgotPassword).click();
		return new ForgotPassword(driver);
	}
}
