package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	WebDriver driver;

	public HomePage(WebDriver idriver){
		this.driver=idriver;
		
	}
	
	@FindBy(xpath="//a[text()='Features']") WebElement featuresLink;
	
	@FindBy(xpath="//a[text()='Pricing']") WebElement pricingLink;
	
	@FindBy(xpath="//a[text()='Contact Us']") WebElement contactUsLink;
	
	@FindBy(xpath="//a[text()='View Demo']") WebElement viewDemoLink;
	
	public void clickOnFeatures(){
		featuresLink.click();
	}
	
	public void clickOnPricing(){
		pricingLink.click();
	}
	public void clickOnContact(){
		contactUsLink.click();
	}
	public void clickOnDemo(){
		viewDemoLink.click();
	}
	public String getApplicationTitle(){
		return driver.getTitle();
	}
}
