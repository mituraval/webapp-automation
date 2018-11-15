package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import PageObjects.HomePage;
import PageObjects.NewUserPage;


public class NewUserTest {
	private StringBuffer verificationErrors = new StringBuffer();
	public static WebDriver driver;
  @Test(priority=1)
  public void launchBrowser() {
	  String exePath = "C:/Users/Raval/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		 driver = new ChromeDriver();

  }
  @Test(priority=2)
  public void appUsers() {
	  driver.get("http://ec2-54-174-213-136.compute-1.amazonaws.com:8080/admin");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  Assert.assertEquals("Dashboard | Active Admin Depot", driver.getTitle());
	  HomePage.lnk_users(driver).click();
	  Assert.assertEquals("Users | Active Admin Depot", driver.getTitle());
	  HomePage.selectFilter(driver).selectByValue("username_contains");
	  HomePage.fitlername(driver).click();
	  HomePage.fitlername(driver).clear();
	  HomePage.fitlername(driver).sendKeys("test");
	  HomePage.submit(driver).click();

  }
  
  @Test(priority=3)
  public void newuserFlow() {
	 try {
	  assertEquals(driver.findElement(By.linkText("New User")).getText(), "New User");
	   } catch (Error e) {
	    verificationErrors.append(e.toString());
	   }
	  NewUserPage.lnkneuser(driver).click();
	  NewUserPage.userName(driver).clear();
	  NewUserPage.userName(driver).sendKeys("testmit");
	  NewUserPage.password(driver).click();
	  NewUserPage.password(driver).clear();
	  NewUserPage.password(driver).sendKeys("Password1");
	  NewUserPage.userEmail(driver).click();
	  NewUserPage.userEmail(driver).clear();
	  NewUserPage.userEmail(driver).sendKeys("yaddi@yopmail.com");
	  NewUserPage.submit(driver).click();
	  try {
	     assertEquals(driver.findElement(By.linkText("Edit User")).getText(), "Edit User");
	    } catch (Error e) {
	     verificationErrors.append(e.toString());
	    }
  }
  
  @Test(priority=4)
  public void finishBrowser() {
	  driver.close();
	  driver.quit();
  }
}
