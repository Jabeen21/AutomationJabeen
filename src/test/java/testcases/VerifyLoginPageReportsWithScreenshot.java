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
import pages.LoginPage;
import utility.Helper;
import factory.BrowerFactory;
import factory.DataProviderFactory;

public class VerifyLoginPageReportsWithScreenshot {
	
	WebDriver driver;
	ExtentReports reports;
	ExtentTest logger;
	
	@BeforeMethod
	public void setUp(){
		
		reports=new ExtentReports("./Reports/LoginPageReports.html",true);
		
		logger=reports.startTest("Verify login page");
		//logger= new ExtentTest("Verify login page", "This page is about login verification");
		
		driver=	BrowerFactory.getBrowser("chrome");
		driver.get("http://www.demo.guru99.com/V4/");
		
		logger.log(LogStatus.INFO, "Application is Up and running");
				
	}
	
	@Test
	public void testLoginPage(){
		
	LoginPage login=PageFactory.initElements(driver, LoginPage.class);
	login.loginApplication(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
	logger.log(LogStatus.INFO, "Logged In");
		
	login.verifySignOutLink();
	
	logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShot(driver, "Sign Out Link Verification")));
	
	logger.log(LogStatus.PASS, "Logging Verified");
	
	
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
