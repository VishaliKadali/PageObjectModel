package org.testleaf.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testleaf.base.ProjectSpecificMethods;
import org.testng.Assert;

public class HomePage extends ProjectSpecificMethods {


	public HomePage(ChromeDriver driver) {
		this.driver=driver;
		
	}
	public MyHomePage clickCRMSFA() throws IOException {
		
		try {
			driver.findElement(By.linkText("CRM/SFA")).click();
			reportStep("Clicked on CRMSFA", "Pass");
		}
		catch(Exception e) {
			reportStep("Unable to click on CRMSFA", "Fail");
		}
		return new MyHomePage(driver);
	}
	
	public LoginPage clickLogout() throws IOException {
		try {
			driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
			reportStep("Clicked on Logout button", "Pass");
		}
		catch(Exception e) {
			reportStep("Unable to click on Logout button", "Fail");
		}
		
		return new LoginPage(driver);
	}
	
	public  HomePage verifyLoginSuccessful() {
		String actual="";
		String expected="";
		Assert.assertTrue(actual.contains(expected));
		return this;
	}
	
}
