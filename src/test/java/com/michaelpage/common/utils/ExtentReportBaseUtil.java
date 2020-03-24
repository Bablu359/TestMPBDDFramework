package com.michaelpage.common.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.michaelpage.utils.LogFile;

public class ExtentReportBaseUtil extends ValueDTO {

	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest scenarioTest;
	public static ExtentTest featureTest;
	static ValueDTO Dto = new ValueDTO();

	public static void getExtentreport() {

		try {

			extent = new ExtentReports();

			// String filename = "MPD8ExtentReport.html";
			String filePath = System.getProperty("user.dir") + "/target/BDD_Extent_Report/MPD8ExtentReport.html";
			htmlReporter = new ExtentHtmlReporter(filePath);
			htmlReporter.config().setTheme(Theme.STANDARD);
			htmlReporter.config().setDocumentTitle("D8 Automation Report");
			htmlReporter.config().setEncoding("utf-8");
			htmlReporter.config().setJS(
					"$(document).ready(function(){$('#test-view').find('.text-small').css('font-size', '18px');$('#test-view').find('.panel-name').css('font-size', '18px');$('.brand-logo').text('Michaelpage');$('#child-analysis').parent().parent().parent().hide(); $('#child-analysis').parent().parent().parent().prev().removeClass('m6 l6');});");
			htmlReporter.config().setReportName("Automation Report : Michaelpage D8");

			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("OS", System.getProperty("os.name"));
			extent.setSystemInfo("Environment: ", Dto.getURl());
			extent.setSystemInfo("Browser: ", Dto.getWebDriverObj());
			extent.setSystemInfo("Language: ", Dto.getLanguageSelection());

			/* Extent report block */
		} catch (Throwable t) {
			t.printStackTrace();
			LogFile.APPLICATION_LOGS.debug("Error in initialize of Extent report");
		}
	}

	/*
	 * public void initializeScenario(Scenario scenario) { scenarioTest =
	 * featureTest.createNode(Scenario.getGherkinName());
	 * 
	 * }
	 */

//	public static void getExtentreportScreenShot() {
//		Calendar calendar = Calendar.getInstance();
//		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
//		try {
//
//			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			String filePath = System.getProperty("user.dir") + "/screenshots/" + "_"
//					+ formater.format(calendar.getTime()) + ".png";
//			File destFile = new File(filePath);
//			FileUtils.copyFile(scrFile, destFile);
//			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
//					+ "' height='100' width='100'/> </a>");
//
//			scenarioTest.fail("details").addScreenCaptureFromPath(filePath);
//
//			/*
//			 * File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			 * BufferedImage img = ImageIO.read(screen); File filetest =
//			 * Paths.get(".").toAbsolutePath().normalize().toFile(); ImageIO.write(img,
//			 * "png", new File(filetest + "\\Screenshots\\" + "Test01.png"));
//			 * MediaEntityModelProvider
//			 * pic=MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty(
//			 * "user.dir") + "\\Screenshots\\" + "Test01.png").build();
//			 * LogFile.APPLICATION_LOGS.info("Details of " + "Test screenshot " + pic);
//			 */
//
//		} catch (Exception t) {
//			ErrorUtil.addVerificationFailure(t);
//			LogFile.APPLICATION_LOGS.error("Error in taking screenshot" + t.getMessage());
//		}
//	}

	public static void getExtentreportScreenShot() {

		try {
			Date d = new Date();
			String Dest = "C:\\Users\\aspradha\\Test1\\";

			File file = new File(".");

			file.getAbsoluteFile();

			Dest = file.getAbsoluteFile().toString().replace(".", "").replace("\\", "/") + Dest;
			String s1 = d.toString();
			String s2 = s1.replaceAll(":", "_");
			TakesScreenshot scr = (TakesScreenshot) driver;
			File SourceFile = scr.getScreenshotAs(OutputType.FILE);
			File DestFile = new File(Dest + s2 + ".png");
			FileUtils.copyFile(SourceFile, DestFile);
			System.out.println(DestFile.getAbsolutePath().toString());

		} catch (Exception t) {
			ErrorUtil.addVerificationFailure(t);
			LogFile.APPLICATION_LOGS.error("Error in taking screenshot" + t.getMessage());
		}

	}

	public void flushReport() {
		extent.flush();
	}
}
