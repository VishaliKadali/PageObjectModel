package org.testleaf.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testleaf.base.ProjectSpecificMethods;

public class CreateLeadPage extends ProjectSpecificMethods{

	public CreateLeadPage(ChromeDriver driver) {
		this.driver=driver;
		
	}
	
	/*
	 * public CreateLeadPage clickCreateLeadbutton() {
	 * driver.findElement(By.xpath("//a[contains(text(),'Create Lead')]")).click();
	 * return this; }
	 */
	
	public CreateLeadPage enterMandatoryFields(String companyName,String FirstName, String LastName)
	{
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(FirstName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(LastName);
		return this;
	}
	
	public ViewLeadPage clickCreateLeadbutton() {
		
		
		/*
		 * driver.findElement(By.xpath("//input[@name='departmentName']")).sendKeys("IT"
		 * ); driver.findElement(By.xpath("//textarea[@name='description']")).
		 * sendKeys("I am a software Engineer");
		 * driver.findElement(By.xpath("//input[@id='createLeadForm_primaryEmail']")).
		 * sendKeys("info@testleaf.com"); Select stateProvince_dropdown=new Select(
		 * driver.findElement(By.xpath(
		 * "//select[@id='createLeadForm_generalStateProvinceGeoId']")));
		 * //List<WebElement> stateOptions=stateProvince_dropdown.getOptions();
		 * stateProvince_dropdown.selectByVisibleText("New York"); String
		 * stateProvince=stateProvince_dropdown.getFirstSelectedOption().getText();
		 * System.out.println(stateProvince);
		 */
		driver.findElement(By.name("submitButton")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		String title=driver.getTitle();
		System.out.println(title);
		wait.until(ExpectedConditions.titleIs(title));
		return new ViewLeadPage(driver);
	
		//String title=driver.findElement(By.xpath("//img[@src='/opentaps_images/opentaps_logo.png']")).getText();
		
	}
}
