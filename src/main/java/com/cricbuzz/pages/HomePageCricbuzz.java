package com.cricbuzz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageCricbuzz {
	WebDriver driver;
	
	public HomePageCricbuzz(WebDriver driver) {
		this.driver = driver;
	}
	
	By schedule = By.xpath("//a[@title='Live Cricket Score']");
	By link = By.xpath("//div[@class='cb-lv-grn-strip text-bold']/"
			+ "following-sibling::div[@class='cb-col-100 cb-col']/"
			+ "div/div/span[@content='Sri Lanka vs Australia, 2nd T20I']");
	
	public WebElement schedule() {
		return driver.findElement(schedule);
	}
	public WebElement link() {
		return driver.findElement(link);
	}
}
