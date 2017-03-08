package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import factory.BrowerFactory;
import factory.DataProviderFactory;

public class VerifyLoginPage {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		driver=	BrowerFactory.getBrowser("chrome");
		driver.get("http://www.demo.guru99.com/V4/");
				
	}
	
	@Test
	public void testLoginPage(){
		
	LoginPage login=PageFactory.initElements(driver, LoginPage.class);
	login.loginApplication(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
	
	login.verifySignOutLink();
	}
	
	@AfterMethod
	public void tearDown(){
		BrowerFactory.closeBrowser(driver);
	}

}
