package com.ilab.opensource_assessment;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
@Test
public class SearchUserDeleted {
  @Test(priority = 17)
  public void SearchDeletedUser() {
	  Setup.log = LogManager.getLogger(SearchUserDeleted.class.getName());
	  //Search for the deleted user
	  Setup.driver.findElement(By.id(Locators.SearchUsername_TextBox)).clear();
	  Setup.driver.findElement(By.id(Locators.SearchUsername_TextBox)).sendKeys(UserInputValues.UserName);
	  
	  //click on search button
	  Setup.driver.findElement(By.id(Locators.SearchButton)).click();
	  
  }
  
  @Test(priority = 18)
  public void Validation1() {
	  if(!Setup.driver.findElement(By.tagName(Locators.td_Response)).getText().equalsIgnoreCase("No Records Found")) {
		  Setup.log.error("User Not added.");
	  }
  }
}
