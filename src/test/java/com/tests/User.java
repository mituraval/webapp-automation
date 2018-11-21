package com.tests;
import utilities.Configs;
import helper.Helper;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;


public class User extends Helper {
	@Test(priority = 10)
	  public void verifyHomepageTitle() {	  		 
		  String actualTitle = driver.getTitle();
	      Assert.assertEquals(actualTitle, Configs.homeTitle);
	      
	  }
	 @Test(priority = 20)
	  public void NewCustomerScreen() {
		  click("users"); 
		  String actualTitle = driver.getTitle();
		  Assert.assertEquals(actualTitle, Configs.userTitle);
		  clickLink("New User");
	      
		  String Title = driver.getTitle();
		  Assert.assertEquals(Title, Configs.newUserTitle);
		  
		  //create a new user
		  enterText("user_username_input","Testmit");
		  enterText("user_password","Password1");
		  enterText("user_email","yaddi@yopmail.com");
		  click("user_submit_action");
		  
		  //verify user created success message displayed
		  String successMessage = driver.findElement(By.className("flash")).getText();
		  Assert.assertEquals(successMessage, Configs.expSuccessMessage);
		 
		  // enter comments and verify comment 
		 enterText("active_admin_comment_resource_type_input","Mit test comment");
		 click("active_admin_comment_submit_action");
		  checkcomments();
		  
		  //TO ACTUALLY MAKE THIS SCRIPT REUSABLE AN API DELTE TEST WILL BE CALLING USER ENDPOINT AND DELTE THIS USER
	  }
	private void checkcomments() {
		String successMessage = driver.findElement(By.className("flash")).getText();
		  Assert.assertEquals(successMessage, Configs.expCommentMessage);
		  Assert.assertTrue(driver.getPageSource().contains("Mit test comment"));
		
	}
	@AfterClass()
	public void browserClean() {
		driver.close();
		driver.quit();
	}
	
}
