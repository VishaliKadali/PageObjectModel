
package org.testleaf.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testleaf.utils.ReadExcelData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.internal.net.http.common.Log;

public class ProjectSpecificMethods {

	public ChromeDriver driver;
	public String fileName;
	public static Properties prop1;
	public static ExtentReports extent;
	public String testName, testDescription, testAuthor, testCategory;
	public static ExtentTest test,node;
	@BeforeMethod
	public void preCondition() throws IOException {
		
		node=test.createNode(testName);
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		//driver = new ChromeDriver();
		System.out.println(driver);
		driver.manage().window().maximize();

		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream(new File("src/main/resources/config.properties"));
		prop.load(fis);
		String url = prop.getProperty("url");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		/*
		 * String Username = prop.getProperty("username"); System.out.println(Username);
		 */

		String lang = prop.getProperty("lang");
		prop1 = new Properties();

		FileInputStream fis1 = new FileInputStream(new File("src/main/resources/" + lang + ".properties"));
		prop1.load(fis1);
	}

	@AfterMethod
	public void postCondition() {
		driver.close();
	}

	@BeforeTest
	public void setData() throws IOException {
		ReadExcelData.readSheetData(fileName);
	}

	// Indices=0 will only pick the 1st row from the excel data sheet, if you want to execute with multiple data remove indices
	@DataProvider(name = "fetchData")//, indices = 0)
	public String[][] Data() throws IOException {
		return ReadExcelData.readSheetData(fileName);
	
	}
	
	@BeforeSuite
	public void startReport() {
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("./reports/result.html");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	@BeforeClass
	public void testDetails() {
		test=extent.createTest(testName,testDescription);
		test.assignAuthor(testAuthor);
		test.assignCategory(testCategory);
	}
	
	@AfterSuite
	public void stopReport() {
		extent.flush();
	}
	
	public void reportStep(String message, String status) throws IOException {
		if(status.equalsIgnoreCase("pass")) {
			//replaced test.pass with node.pass so that you can see the each test information separately
			node.pass(message,MediaEntityBuilder.createScreenCaptureFromPath(".././images/img"+takeSnap()+".png").build());
		}
		else if(status.equalsIgnoreCase("fail")) {
			node.fail(message,MediaEntityBuilder.createScreenCaptureFromPath(".././images/img"+takeSnap()+".png").build());
			//RunTimeException stops the execution
			throw new RuntimeException("See the report for details");
		}
	}
	
	//Take Screenshot
	public int takeSnap() throws IOException {
		int random = (int) (Math.random() * 99999);
		File src=driver.getScreenshotAs(OutputType.FILE);
		File des=new File("./images/img" +random+".png");
		FileUtils.copyFile(src, des);
		return random;
	}

	/*
	 * @DataProvider(name="dataProvider") public String[][] fetchData() throws
	 * IOException{
	 * 
	 * String[][] data;
	 * 
	 * String[][] data=new String[2][3];
	 * 
	 * data[0][0]="TestLeaf"; data[0][1]="Hari"; data[0][2]="RadhaKrishna";
	 * 
	 * data[1][0]="Qeagle"; data[1][1]="Babu"; data[1][2]="Manickam";
	 * 
	 * return data;
	 * 
	 * 
	 * data=ReadExcelData.readSheetData(fileName);
	 * 
	 * return data;
	 * 
	 * 
	 * }
	 */

}
