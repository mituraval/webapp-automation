package helper;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import utilities.Configs;

public class Helper {
	public WebDriver driver = null;
	@BeforeClass

	public void beforeclass() {
		  
		  
		System.setProperty("webdriver.chrome.driver", Configs.driverPath);	
		driver = new ChromeDriver();			
		 //driver.manage().window().maximize();		  
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		  
	     driver.get(utilities.Configs.baseUrl);
	}
	
	public void waitForLoad() {
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
	}
	
	public void enterText(String id, String text) {
		WebElement element_enter = driver.findElement(By.id(id));
		Actions actions = new Actions(driver);
		actions.moveToElement(element_enter);
		actions.click();
		actions.sendKeys(text);
		actions.build().perform();		
	}
	
	public void click(String id) {
			
		WebElement element = driver.findElement(By.id(id));
			element.click();					
	}
	
	public void clickLink(String linkText) {
		
		WebElement element = driver.findElement(By.linkText(linkText));			
			element.click();					
	}
	
	public void clickByName(String name) {
		
		WebElement element = driver.findElement(By.name(name));		
			element.click();		
		
	}

}
