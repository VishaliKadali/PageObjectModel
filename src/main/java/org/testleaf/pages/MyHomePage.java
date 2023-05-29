package org.testleaf.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testleaf.base.ProjectSpecificMethods;

public class MyHomePage extends ProjectSpecificMethods{

	public MyHomePage(ChromeDriver driver) {
		this.driver=driver;
	}
	
	public LeadsPage clickLeads() throws IOException {
		
		
		//driver.findElement(By.linkText(prop1.getProperty("Leads_link"))).click();
		try {
			driver.findElement(By.xpath("//a[contains(text(),'"+prop1.getProperty("Leads_link")+"')]")).click();
			reportStep("Clicked on Leads link", "Pass");
		}
		catch(Exception e){
			reportStep("Unable to click on Leads Link", "Fail");
		}
		return new LeadsPage(driver);
		//driver.findElement(By.xpath("//a[contains(text(),'"+prop1.getProperty("Leads_link")+"')]")).click();
	}
		
}
