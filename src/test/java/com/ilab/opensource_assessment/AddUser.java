package com.ilab.opensource_assessment;

import org.apache.logging.log4j.LogManager;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

@Test
public class AddUser {
	@Test(priority=8)
	public void add() {
		Setup.log = LogManager.getLogger(AddUser.class.getName());
		
		if(Setup.driver.findElement(By.id(Locators.AddButton)) != null) {
			Setup.driver.findElement(By.id(Locators.AddButton)).click();
		}
	}

	@Test(priority = 9)
	public void validation1() {
		if(!Setup.driver.getCurrentUrl().contains("saveSystemUser")) {
			Setup.log.error("Url does not contain SaveSystemUser");
		}
	}

	@Test(priority = 10)
	public void validation2() {
		if(!Setup.driver.findElement(By.id(Locators.H1_AddUserheading)).getText().equalsIgnoreCase("Add User")) {
			Setup.log.error("H1 heading is not Add User");
		}
	}

	@Test(priority = 11)
	public void inputdata() {
		System.out.println(Setup.driver.findElement(By.id(Locators.Usertype_DropDownList)).getText());
		//NB verify status dropdown is Selected
		Select Statuslocation = new Select(Setup.driver.findElement(By.id(Locators.UserStatus_DropDownList)));

		if (Statuslocation.getFirstSelectedOption().getText().equalsIgnoreCase("Enabled")) {
			Select newLocation = new Select(Setup.driver.findElement(By.id(Locators.Usertype_DropDownList)));
			newLocation.selectByVisibleText("ESS");

			Setup.driver.findElement(By.id(Locators.EmployeeName_TextBox)).clear();
			Setup.driver.findElement(By.id(Locators.EmployeeName_TextBox)).sendKeys(UserInputValues.Employee_Name);

			Setup.driver.findElement(By.id(Locators.UserName_TextBox)).clear();
			Setup.driver.findElement(By.id(Locators.UserName_TextBox)).sendKeys(UserInputValues.UserName);

			Setup.driver.findElement(By.id(Locators.UserPassword_TextBox)).clear();
			Setup.driver.findElement(By.id(Locators.UserPassword_TextBox)).sendKeys(UserInputValues.UserPassword);

			Setup.driver.findElement(By.id(Locators.ConfirmPassword_TextBox)).clear();
			Setup.driver.findElement(By.id(Locators.ConfirmPassword_TextBox)).sendKeys(UserInputValues.UserPassword);


			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Setup.driver.findElement(By.name(Locators.SaveUser_Button)).click();
		}
	}
}
