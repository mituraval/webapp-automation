package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewUserPage {
	
	WebDriver driver;
	private static WebElement element = null;
	
	public static WebElement lnkneuser(WebDriver driver){ 

		element =  driver.findElement(By.linkText("New User"));		 
		   return element;		 
		   }
	
	public static WebElement userName(WebDriver driver){ 

		element =  driver.findElement(By.id("user_username")); 
		   return element;		 
		   }
	
	public static WebElement password(WebDriver driver){ 

		element =   driver.findElement(By.id("user_password")); 
		   return element;		 
		   }

	public static WebElement userEmail(WebDriver driver){ 

		element =   driver.findElement(By.id("user_email")); 
		   return element;		 
		   }
	public static WebElement submit(WebDriver driver){ 

		element =   driver.findElement(By.id("commit")); 
		   return element;		 
		   }

}
