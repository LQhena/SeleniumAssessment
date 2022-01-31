package com.ilab.opensource_assessment;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
@Test
public class AdminNavigation {
	@Test(priority = 5)
	  public void NavigateToAdmin() {
		Setup.log = LogManager.getLogger(AdminNavigation.class.getName());
		//Click on admin tab 
		Setup.driver.findElement(By.id(Locators.AdminTab)).click();
	  }
	  
	  @Test(priority = 6)
	  public void validation1() {
		  if(!Setup.driver.getCurrentUrl().contains("admin/viewSystemUsers")) {
			  Setup.log.error("url does not contain admin/viewSystemUsers");
		  }
	  }
	  
	  @Test(priority = 7)
	  public void validation2() {
		  if(Setup.driver.findElement(By.id(Locators.SearchButton))!= null) {
			  System.out.println("Search Button Exists");
		  }
		  if(Setup.driver.findElement(By.id(Locators.ResetButton)) != null) {
			  System.out.println("reset Button Exists");
		  }
		  if(Setup.driver.findElement(By.id(Locators.AddButton)) != null) {
			  System.out.println("add Button Exists");
		  }
		  if(Setup.driver.findElement(By.id(Locators.DeleteButton)) != null) {
			  System.out.println("Delete Button Exists");
		  }
	  }
}
