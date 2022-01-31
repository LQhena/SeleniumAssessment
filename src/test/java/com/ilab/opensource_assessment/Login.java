package com.ilab.opensource_assessment;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
@Test
public class Login {
  
	@Test(dataProvider = "loginData", priority=1)
	  public void login(String name, String password) {
		Setup.log = LogManager.getLogger(Login.class.getName());
		
		//entering login details
		Setup.driver.findElement(By.id(Locators.UsernameTextBox)).clear();
		Setup.driver.findElement(By.id(Locators.UsernameTextBox)).sendKeys(name);
		Setup.driver.findElement(By.id(Locators.PasswordTextBox)).clear();
		Setup.driver.findElement(By.id(Locators.PasswordTextBox)).sendKeys(password);
		//click on login button
		Setup.driver.findElement(By.id(Locators.LoginButton)).click();
	  }
	
	@Test(priority = 2)
	public void validation1() {
		if(!Setup.driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/index.php/dashboard")) {
			Setup.log.error("Url Does not contain dashboard");
		}
	}
	
	@Test(priority = 3)
	public void validation2() {
		if(Setup.driver.findElement(By.xpath(Locators.AdminTab_Innertext)) != null) {
			if(!Setup.driver.findElement(By.xpath(Locators.AdminTab_Innertext)).getText().equalsIgnoreCase("Admin")) {
				Setup.log.error("Admin Tab does not display.");
			}
		}
	}
	
	@Test(priority = 4)
	public void validation3() {
		if(!Setup.driver.findElement(By.id(Locators.Welcome_TAG)).getText().equalsIgnoreCase("Welcome Admin")) {
			Setup.log.error("Welcome Admin not displayed on right panel");
		}
	}
	
	@DataProvider(name="loginData")
	  public Object[][] getData(){
		  Object[][] loginData = new Object[2][2];
		  
		  loginData[0][0] = "Admin";
		  loginData[0][1] = "Admin123";
		  
		  loginData[1][0] = "Admin";
		  loginData[1][1] = "admin123";
		  
		  return loginData;
	  }
}
