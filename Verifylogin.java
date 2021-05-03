package com.project.automate;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Verifylogin {

	private WebDriver driver = null;
	static ExtentTest test;
	static ExtentReports report;

	@BeforeClass
	public static void startTest() throws IOException {
		report = new ExtentReports(System.getProperty("user.dir") + "\\reports\\ExtentReportResults.html", true);
		test = report.startTest("Verifylogin");

	}

	@Test(dataProvider = "loginCredentials")
	public void checkValidUser(String userName, String pwd) throws InterruptedException {
		driver = Browsers.setup("chrome", "https://www.netflix.com/in/");
		Loginpage loginPage = PageFactory.initElements(driver, Loginpage.class);
		loginPage.logInToFlipkart(userName, pwd);
		Thread.sleep(5000);
		String title = driver.getTitle();
		System.out.println(title);
		if (title.equals("Netflix India – Watch TV Shows Online, Watch Movies Online")) {
			test.log(LogStatus.PASS, "User successfully logged-in");
		} else {
			test.log(LogStatus.FAIL, "Invalid credentials");
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@DataProvider(name = "loginCredentials")
	public Object[][] getTestInputs() {
		ExcelFileUtility excel = new ExcelFileUtility("E:\\sele\\casestudy\\credentials.xlsx");
		int rowCount = excel.getRowCount(0);
		Object[][] testCases = new Object[rowCount][2];
		for (int i = 0; i < rowCount; i++) {
			testCases[i][0] = excel.getData(0, i, 0);
			testCases[i][1] = excel.getData(0, i, 1);
		}
		return testCases;
	}

	@AfterClass
	public static void endTest() {
		report.endTest(test);
		report.flush();
	}
}
