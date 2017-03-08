package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver idriver){
		this.driver=idriver;
		
	}
	
	@FindBy(name="uid") WebElement userId;
	@FindBy(name="password") WebElement password;
	@FindBy(name="btnLogin") WebElement loginButton;
	By signOut=By.xpath("//a[text()='Log out']");
	
	public void loginApplication(String user, String pswd){
		userId.sendKeys(user);
		password.sendKeys(pswd);
		loginButton.click();
		
	}
	
	public void verifySignOutLink(){
		
		WebDriverWait wait  =new WebDriverWait(driver, 10);
		WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(signOut));
		String text= ele.getText();
		
		Assert.assertEquals(text, "Log out", "Logout link not available");
		
	}

}
