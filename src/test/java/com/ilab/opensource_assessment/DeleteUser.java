package com.ilab.opensource_assessment;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
@Test
public class DeleteUser {
  @Test(priority = 16)
  public void DeleteSelectedUser() {
	  Setup.driver.findElement(By.name(Locators.User_CheckBox)).click();
	  
	  Setup.driver.findElement(By.id(Locators.DeleteButton)).click();
	  
	  Setup.driver.findElement(By.id(Locators.ComfirmDelete_DialogButton)).click();
  }
}
