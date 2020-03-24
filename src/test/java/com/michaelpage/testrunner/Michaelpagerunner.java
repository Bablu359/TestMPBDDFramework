package com.michaelpage.testrunner;

import java.io.IOException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.michaelpage.common.utils.LoginTC;
import com.michaelpage.utils.LogFile;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features = { "src/test/resources/features/MichaelPageSampleTC.feature" }, glue = {
		"com.michaelpage.stepdefinitions" }, monochrome = true, dryRun = false, tags = { "@UploadandSignIn" })

public class Michaelpagerunner {
	private TestNGCucumberRunner testNGCucumberRunner;
	// public static ExtentTest test;
	ExtentTest testlog;
	WebDriver driver;

	@BeforeSuite
	public void initialize() {

		try {

			PropertyConfigurator
					.configure(System.getProperty("user.dir") + "//src//main//resources//Logs/log4j.properties");
			Logger.getRootLogger().setLevel(Level.ALL);

			LogFile.APPLICATION_LOGS.debug("Starting the Michael Page Regression suite");
		} catch (Throwable t) {
			t.printStackTrace();
			System.out.println("Unable to initialize the log file");
			LogFile.APPLICATION_LOGS.error("Error in initialize the Log file");
		}
	}

	@BeforeTest
	public void testSetUp() {
		LoginTC.getLoginTCObject();

	}

//	@BeforeMethod
//	public void extentSetUp() {
////		ExtentReportBaseUtil.scenarioTest = ExtentReportBaseUtil.featureTest.createNode(Scenario.getGherkinName());
//
//	}

	@BeforeClass(alwaysRun = true)
	public void classSetUp() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());

	}

	@Test(groups = "cucumber", description = "Run Feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		LoginTC.CallBrowser();
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	@DataProvider
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}

//	@AfterMethod
//	public void getResult(ITestResult result) throws IOException {
//
//		if (result.getStatus() == ITestResult.FAILURE) {
//			testlog.log(Status.FAIL,
//					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
//			testlog.log(Status.FAIL,
//					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
//			ReusableMethodTC.getScreenShot();
//		} else if (result.getStatus() == ITestResult.SKIP) {
//			testlog.log(Status.SKIP, "Test Case Skipped is " + result.getName());
//			testlog.log(Status.SKIP,
//					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
//
//		} else if (result.getStatus() == ITestResult.SUCCESS) {
//			testlog.log(Status.PASS, "Test Case SUCCESS is " + result.getName());
//			testlog.log(Status.PASS,
//					MarkupHelper.createLabel(result.getName() + " - Test Case SUCCESS", ExtentColor.GREEN));
//
//		}
//	}

	@AfterClass(alwaysRun = true)
	public void classTearDown() throws Exception {
		testNGCucumberRunner.finish();
	}

	@AfterSuite
	public void closeAll() {
		try {
			Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
			Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

		} catch (IOException e) {

			LogFile.APPLICATION_LOGS.error("Error in closing the Browser");
			e.printStackTrace();
		}
	}

}