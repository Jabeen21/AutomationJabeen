package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import dataprovider.ConfigDataProvider;

/*in this class we have 2 methods - 1 for opening browser as per the parameter passed
which gets its browser name from user and sets the path from configdataprovider class methods
and the 2 method is for closing the browser
*/
public class BrowerFactory {
	
	static WebDriver driver;
	
	public static WebDriver getBrowser(String browserName){
		if(browserName.equalsIgnoreCase("firefox")){
			
			
			System.setProperty("webdriver.gecko.driver", DataProviderFactory.getConfig().getFirefoxPath());
			driver= new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome")){
			
			
			System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getChromePath());
			driver= new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public static void closeBrowser(WebDriver idriver){
		driver.quit();
	}

}
