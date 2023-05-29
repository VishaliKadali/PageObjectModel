package org.testleaf.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testleaf.base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods{
	
	//Created the below constructor becoz, in parallel execution static chrome is not possible, since it generates different session ID (reference need to set it back to the global variable, so create a parameterized constructor)
	public LoginPage(ChromeDriver driver) {
		this.driver=driver;
		
	}
	
	public LoginPage enterUsername(String username) throws IOException {
		try {
			driver.findElement(By.id("username")).sendKeys(username);
			reportStep("Entered the username","Pass");
		}
		catch (Exception e) {
			reportStep("Entered Incorrect username","Fail");
			// TODO: handle exception
		}
		return this;
	}
	
	public LoginPage enterPassword(String password) throws IOException {
		try {
			driver.findElement(By.id("password")).sendKeys(password);
			reportStep("Entered the Password","Pass");
		}
		catch (Exception e) {
			reportStep("Entered Incorrect password","Fail");
			// TODO: handle exception
		}
		return this;
		
	}
	
	public HomePage clickLogin() throws IOException {
		try {
			driver.findElement(By.className("decorativeSubmit")).click();
			reportStep("Clicked on Submit button","Pass");
		}
		catch (Exception e) {
			reportStep("Unable to click on submit button","Fail");
			// TODO: handle exception
		}
		return new HomePage(driver);
	}
}
