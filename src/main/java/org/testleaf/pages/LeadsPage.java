package org.testleaf.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testleaf.base.ProjectSpecificMethods;

public class LeadsPage extends ProjectSpecificMethods {
	
	public LeadsPage(ChromeDriver driver) {
		this.driver=driver;
		
	}

	public CreateLeadPage clickCreateLead() throws IOException {
		try {
			driver.findElement(By.linkText(prop1.getProperty("Create_Lead_Link"))).click();
			reportStep("Clicked on Leads link", "Pass");
		}
		catch(Exception e){
			reportStep("Unable to click on Leads link", "Fail");
		}
		
		return new CreateLeadPage(driver);
	}
	
	public FindLeadsPage clickFindLeads() throws IOException {
		try {
			driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
			reportStep("Clicked on Find Leads ", "Pass");
		}
		catch(Exception e){
			reportStep("Unable to click on on Find Leads", "Fail");
		}
		
		return new FindLeadsPage(driver);
	}
	
	
}
