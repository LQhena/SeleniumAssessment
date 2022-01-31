package com.ilab.opensource_assessment;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
@Test
public class SearchUser {
  @Test(priority = 12)
  public void Search() {
	  Setup.log = LogManager.getLogger(SearchUser.class.getName());
	  //enter the username to Search for 
	  Setup.driver.findElement(By.id(Locators.SearchUsername_TextBox)).clear();
	  Setup.driver.findElement(By.id(Locators.SearchUsername_TextBox)).sendKeys(UserInputValues.UserName);
	  //click on search button
	  Setup.driver.findElement(By.id(Locators.SearchButton)).click();
  }
  
  @Test(priority = 13)
  public void Validation1() {
	  if(!Setup.driver.findElement(By.xpath(Locators.UserName_TableColumn)).getText().equalsIgnoreCase(UserInputValues.UserName)) {
		  Setup.log.error("UserName is incorrect");
	  }
  }
  
  @Test(priority = 14)
  public void Validation2() {
	  if(!Setup.driver.findElement(By.xpath(Locators.EmployeeName_TableColumn)).getText().equalsIgnoreCase(UserInputValues.Employee_Name)) {
		  Setup.log.error("Employee Name is incorrect");
	  }
  }
  @Test(priority = 15)
  public void Validation3() {
	  if(Setup.driver.findElement(By.xpath(Locators.Status_TableColumn)).getText().equalsIgnoreCase("Enabled")) {
		  Setup.log.error("Status is not Enabled");
	  }
  }
}
