package com.michaelpage.common.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.michaelpage.utils.LogFile;

public class ReusableMethodTC extends TestBase {

	public static void click(WebElement webElement) {
		try {
			elementToBeVisible(webElement);
			webElement.click();

		} catch (Exception e) {

			for (int i = 0; i <= 10; ++i) {
				try {
					scrollIntoView(webElement);
					elementToBeVisible(webElement);
					webElement.click();
					break;
				} catch (Exception e1) {
					e1.printStackTrace();
					continue;
				}
			}

			LogFile.APPLICATION_LOGS.error("Unable to click: " + webElement.getAttribute("class").toString());
		}
	}

	public static void clickByJS(WebElement webElement) {
		try {
			elementToBeVisible(webElement);
			js.executeScript("arguments[0].click();", webElement);
		} catch (Exception e) {
			LogFile.APPLICATION_LOGS
					.error("Cannot find object with key -- " + webElement.getAttribute("class").toString());
		}
	}

	public static void sendKeys(WebElement webElement, String text) {
		try {
			elementToBeVisible(webElement);
			webElement.clear();
			webElement.sendKeys(text);
		} catch (Exception e) {
			LogFile.APPLICATION_LOGS.error("Unable to enter text in: " + webElement.getAttribute("class").toString());
		}
	}

	public static void selectByValue(WebElement webElement, String value) {
		try {
			elementToBeVisible(webElement);
			Select listBox = new Select(webElement);
			listBox.selectByValue(value);
		} catch (Exception e) {
			LogFile.APPLICATION_LOGS
					.error("Unable to select the value : " + webElement.getAttribute("class").toString());
		}
	}

	public static void selectByVisibleText(WebElement webElement, String value) {
		try {
			elementToBeVisible(webElement);
			Select listBox = new Select(webElement);
			listBox.selectByVisibleText(value);
		} catch (Exception e) {
			LogFile.APPLICATION_LOGS
					.error("Unable to select the value : " + webElement.getAttribute("class").toString());
		}
	}

	public static void mouseOver(WebElement webElement) {
		try {

			Actions act = new Actions(driver);
			elementToBeInvisible(webElement);
			act.moveToElement(webElement).build().perform();
		} catch (Exception e) {
			LogFile.APPLICATION_LOGS.error("Unable to move to element: " + webElement.getAttribute("class").toString());

		}
	}

	public static void dragAndDrop(WebElement source, WebElement target) {
		try {

			Actions act = new Actions(driver);
			act.dragAndDrop(source, target);
		} catch (Exception e) {
			LogFile.APPLICATION_LOGS.error("Unable to drag and Drop");
		}
	}

	public static void selectByIndex(WebElement webElement, int index) {

		try {
			elementToBeVisible(webElement);
			Select listBox = new Select(webElement);
			listBox.selectByIndex(index);
		} catch (Exception e) {
			LogFile.APPLICATION_LOGS
					.error("Unable to select the value : " + webElement.getAttribute("class").toString());
		}
	}

	public static void clear(WebElement webElement) {
		try {
			elementToBeVisible(webElement);
			webElement.clear();
		} catch (Exception e) {
			LogFile.APPLICATION_LOGS.error("Unable to clear text : " + webElement.getAttribute("class").toString());
		}
	}

	public static boolean isElementPresent(WebElement webElement) {
		boolean status = false;
		try {
			elementToBeVisible(webElement);
			status = webElement.isDisplayed();
		} catch (Exception e) {
			LogFile.APPLICATION_LOGS.error("Webelement is not present: " + webElement.getAttribute("class").toString());
		}

		return status;

	}

	public static boolean isEnabled(WebElement webElement) {
		boolean status = false;
		elementToBeVisible(webElement);
		try {
			status = webElement.isEnabled();
		} catch (Exception e) {
			LogFile.APPLICATION_LOGS.error("Webelement is disabled: " + webElement.getAttribute("class").toString());
		}

		return status;
	}

	public static void verifyText(String expected, String actual) throws Exception {
		try {
			Assert.assertEquals(expected, actual);
		} catch (Exception t) {
			throw t;
		}
	}

	public static void verifyTextDirect(String text) throws Exception {
		try {
			Assert.assertTrue(driver.getPageSource().contains(text));
		} catch (Exception t) {
			throw t;
		}
	}

	public static void getExtentreportScreenShot() {

//		TakesScreenshot  = (TakesScreenshot) driver;

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

	public static String getScreenShot() {

//		TakesScreenshot  = (TakesScreenshot) driver;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		File destFile = null;
		try {

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String filePath = System.getProperty("user.dir") + "/screenshots/" + "_"
					+ formater.format(calendar.getTime()) + ".png";
			destFile = new File(filePath);
			FileUtils.copyFile(scrFile, destFile);

//			Date d = new Date();
//			String Dest = "target/ScreenShots/";
//
//			File file = new File(".");
//
//			file.getAbsoluteFile();
//
//			Dest = file.getAbsoluteFile().toString().replace(".", "").replace("\\", "/") + Dest;
//			String s1 = d.toString();
//			String s2 = s1.replaceAll(":", "_");
//			TakesScreenshot scr = (TakesScreenshot) driver;
//			File SourceFile = scr.getScreenshotAs(OutputType.FILE);
//			File DestFile = new File(Dest + s2 + ".png");
//			FileUtils.copyFile(SourceFile, DestFile);
//			System.out.println(DestFile.getAbsolutePath().toString());
//			return DestFile.getAbsolutePath().toString()

		} catch (Exception t) {
			ErrorUtil.addVerificationFailure(t);
			LogFile.APPLICATION_LOGS.error("Error in taking screenshot" + t.getMessage());
		}
		return destFile.getAbsolutePath().toString();

	}

}
