package org.testleaf.testcases;

import java.io.IOException;

import org.testleaf.base.ProjectSpecificMethods;
import org.testleaf.pages.CreateLeadPage;
import org.testleaf.pages.LoginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC002_CreateLead extends ProjectSpecificMethods {
	@BeforeTest
	public void setData() {
		fileName = "CreateLead";
		testName = "CreateLead";
		testDescription = "Create Lead with mandotory details";
		testAuthor = "Vishali";
		testCategory = "Smoke";
	}

	@Test(dataProvider = "fetchData")
	public void createLead(String username, String password, String companyName, String FirstName, String LastName) throws IOException {
		new LoginPage(driver)
		.enterUsername(username)
		.enterPassword(password)
		.clickLogin()
		.clickCRMSFA()
		.clickLeads()
		.clickCreateLead()
		.enterMandatoryFields(companyName, FirstName, LastName)
		.clickCreateLeadbutton();
	}
}
