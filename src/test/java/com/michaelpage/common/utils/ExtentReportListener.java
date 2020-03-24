package com.michaelpage.common.utils;

/**
 * Class for Extent report Listener for Configuration of report
 * 
 * @author Ashutosh Pradhan
 */

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.michaelpage.common.utils.ReusableMethodTC;

public class ExtentReportListener {
	public static ExtentHtmlReporter htmlReporter = null;
	public static ExtentReports extent = null;
	public static ExtentTest test = null;

	public static ExtentReports setUp() {

		ValueDTO dto = new ValueDTO();
		String reportLocation = "./ExtentReport/Extent_Report.html";

		htmlReporter = new ExtentHtmlReporter(reportLocation);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("D8 Automation Report");
//		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setJS(
				"$(document).ready(function(){$('#test-view').find('.text-small').css('font-size', '18px');$('#test-view').find('.panel-name').css('font-size', '18px');$('.brand-logo').text('Michaelpage');$('#child-analysis').parent().parent().parent().hide(); $('#child-analysis').parent().parent().parent().prev().removeClass('m6 l6');});");
		htmlReporter.config().setReportName("Automation Report : Michaelpage D8");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Environment: ", dto.getURl());
		extent.setSystemInfo("Browser: ", dto.getWebDriverObj());
		extent.setSystemInfo("Language: ", dto.getLanguageSelection());
		System.out.println("Extent report location initialized");
		htmlReporter.start();
		System.out.println("System info set in Extent Report");

		return extent;

	}

	public static void testStepHandle(String teststatus, WebDriver driver, ExtentTest extenttest, Throwable throwable) {

		switch (teststatus) {

		case "FAIL":
			extenttest.fail(MarkupHelper.createLabel("Test Case Failed :", ExtentColor.RED));

			extenttest.error(throwable.fillInStackTrace());

			try {

				extenttest.addScreenCaptureFromPath(ReusableMethodTC.getScreenShot());

			} catch (Exception e) {
				e.printStackTrace();

			}

			if (driver != null) {
				driver.quit();

			}
			break;
		case "PASS":
			extenttest.pass(MarkupHelper.createLabel("Test Case Passed :", ExtentColor.GREEN));
			break;
		}
	}

}
