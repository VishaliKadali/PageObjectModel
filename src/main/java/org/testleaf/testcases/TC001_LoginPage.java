package org.testleaf.testcases;

import java.io.IOException;

import org.testleaf.base.ProjectSpecificMethods;
import org.testleaf.pages.LoginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC001_LoginPage extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setData() {
		//Login is the name of the file, this filename, testDescription, category, author comes from ProjectSpecifics declared as global variable
		fileName="Login";
		testName="Login";
		testDescription="Login with username and password";
		testAuthor="Vishali";
		testCategory="Sanity";
		
	}
	@Test(dataProvider="fetchData")
	public void runLogin(String username, String password) throws IOException {
		
		new LoginPage(driver)
		.enterUsername(username)
		.enterPassword(password)
		.clickLogin();
		
	}

}
