package org.testleaf.testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LearnExtentReports {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Extent report generation");
		//Setup the physical report path
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("./reports/result.html");
		
		//Create an object for ExtentReports
		ExtentReports extent=new ExtentReports();
		
		//Attach the data with physical file
		extent.attachReporter(reporter);
		
		//Create a testcase
		ExtentTest test =extent.createTest("Create Lead", "Create Lead with mandatory information");
		test.assignAuthor("Vishali");
		test.assignCategory("Smoke");
		
		//Step level information
		test.pass("Username is entered successfully");
		
		//Flush Report
		extent.flush();
	}

}
