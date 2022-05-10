package FrameworkTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.BaseDriver;
import resources.ExtentReportNG;

public class Listener extends BaseDriver implements ITestListener {

	ExtentTest test;
	ExtentReports extent = ExtentReportNG.generateReport();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed!!!");
	}

	public void onTestFailure(ITestResult result) {
		
		extentTest.get().fail(result.getThrowable());
		WebDriver driver=null;
		String methodName = result.getMethod().getMethodName();
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e) {
			System.out.println(e);
		}
		
		try {
			extentTest.get().addScreenCaptureFromPath(takeScreenshot(methodName, driver), result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
