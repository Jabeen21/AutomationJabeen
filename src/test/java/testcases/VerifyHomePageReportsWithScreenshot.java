package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.HomePage;
import utility.Helper;
import factory.BrowerFactory;
import factory.DataProviderFactory;

public class VerifyHomePageReportsWithScreenshot {
	
	WebDriver driver;
	ExtentReports reports;
	ExtentTest logger;
	
	@BeforeMethod
	public void setUp(){
		
		reports=new ExtentReports("./Reports/HomePageReports.html",true);
		
		logger=reports.startTest("Verify Home page");
		//logger= new ExtentTest("Verify login page", "This page is about login verification");
		
		driver=	BrowerFactory.getBrowser("chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		
		logger.log(LogStatus.INFO, "Application is Up and running");
				
	}
	
	@Test
	public void testHomePage(){
		
		HomePage home= PageFactory.initElements(driver, HomePage.class);
		
		String title = home.getApplicationTitle();
		
		Assert.assertTrue(title.contains("Avactis Demo"), "Title Does Not Match");
			
	
	logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShot(driver, "HomePageTitle")));
	
	logger.log(LogStatus.PASS, "Home Page Title Verified");
	
	
	}
	
	@AfterMethod
	public void tearDown(ITestResult result){
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String path=Helper.captureScreenShot(driver, result.getName());
			
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
		}
		
		BrowerFactory.closeBrowser(driver);
		reports.endTest(logger);
		reports.flush();
		//driver.get("C:\\Users\\jtaus\\workspace\\New folder\\com.learnAutomation\\Reports\\LoginPageReports.html");
	}

}
