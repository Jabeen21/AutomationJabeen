package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import factory.BrowerFactory;
import factory.DataProviderFactory;

public class VerifyHomePage {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		driver=	BrowerFactory.getBrowser("chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
				
	}
	
	@Test
	public void testHomePage(){
		
	
	HomePage home= PageFactory.initElements(driver, HomePage.class);
		
	String title = home.getApplicationTitle();
	
	Assert.assertTrue(title.contains("Avactis Demo"), "Title Does Not Match");
	
	}
	
	@AfterMethod
	public void tearDown(){
		BrowerFactory.closeBrowser(driver);
	}

	// pavan's comment.

}
