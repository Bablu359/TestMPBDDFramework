package com.michaelpage.common.Listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.michaelpage.common.utils.ExtentReportListener;
import com.michaelpage.utils.LogFile;

public class NGTestListner extends ExtentReportListener implements ITestListener, IRetryAnalyzer {

	ExtentReportListener extentReport = new ExtentReportListener();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		/*
		 * System.out.println("On Test Failure"); try {
		 * extentReport.getExtentreportScreenShot(); } catch (Throwable t) {
		 * t.printStackTrace();
		 * LogFile.APPLICATION_LOGS.error("Error in initialize() of Extent report"); }
		 */
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Started Execution..");
		LogFile.APPLICATION_LOGS.info("Started Execution..");
//		ExtentReportBaseUtil.getExtentreport();
		//
//		featureTest=extentReport.extent.createTest(Feature.class,"MichaelPageSampleTC.feature");
		extentReport.setUp();

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Completed Execution..");
		LogFile.APPLICATION_LOGS.info("Completed Execution..");
		extent.flush();

	}

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		return false;
	}

}
