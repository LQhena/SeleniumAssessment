package com.ilab.opensource_assessment;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
@Test
public class UserLogout {
  @Test(priority = 19)
  public void Logout() {
	  Setup.log = LogManager.getLogger(UserLogout.class.getName());
	  
	  Setup.driver.findElement(By.id(Locators.Welcome_TAG)).click();
	  Setup.driver.findElement(By.xpath(Locators.logout_TAG)).click();
  }
  
  @Test(priority = 20)
  public void Validation1() {
	  if (!Setup.driver.findElement(By.id(Locators.LoginButton)).getDomProperty("value").equalsIgnoreCase("LOGIN")) {
		  Setup.log.error("LOGIN not found.");
	  }
  }
  
  @Test(priority = 21)
  public void Validation2() {
	  if(!Setup.driver.getTitle().equalsIgnoreCase("OrangeHRM")) {
		  Setup.log.error("Invalid Title is not OrangeHRM");
	  }
  }
}
