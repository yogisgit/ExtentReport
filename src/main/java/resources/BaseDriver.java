package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseDriver {
	
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/data.properties");
		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		String url = prop.getProperty("urlcricbuzz");
		//String browserName = System.getProperty("browser");
		
		//creating object of chrome options for usage of headless mode
		ChromeOptions options = new ChromeOptions();
		
		if(browserName.contains("chrome")) {
			System.setProperty("WebDriver.ChromeDriver", System.getProperty("user.dir")+"/chromedriver");
			
			//checking for the user input whether to run in head or headless mode
			if(browserName.contains("headless")) {
				//only if we provide the argument for chrome options as headless then only we can run in headless mode
				options.addArguments("headless");
			}
			//passing the chrome options as parameter to driver
			driver = new ChromeDriver(options);
		}else if(browserName.equals("firefox")) {
			System.setProperty("WebDriver.ChromeDriver", System.getProperty("user.dir")+"/chromedriver");
			driver = new ChromeDriver();
		}else if(browserName.equals("IE")){
			System.setProperty("WebDriver.ChromeDriver", System.getProperty("user.dir")+"/chromedriver");
			driver = new ChromeDriver();
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	public String takeScreenshot(String testcaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/reports/"+testcaseName+".png";
		FileUtils.copyFile(src, new File(path));
		return path;
		 
	}

}
