package com.ilab.opensource_assessment;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
@Test
public class DeleteUser {
  @Test(priority = 16)
  public void DeleteSelectedUser() {
	  //click on checkBox
	  Setup.driver.findElement(By.name(Locators.User_CheckBox)).click();
	  //click on Delete button
	  Setup.driver.findElement(By.id(Locators.DeleteButton)).click();
	  //click on popup confirm delete button
	  Setup.driver.findElement(By.id(Locators.ComfirmDelete_DialogButton)).click();
  }
}
