package com.michaelpage.common.utils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.util.PDFTextStripper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.michaelpage.utils.LogFile;
import com.opencsv.CSVReader;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class TestBase {

	// public static EventFiringWebDriver d = null;
	public static WebDriver driver = null;
	public static String path, output;
	public ValueDTO Dto = new ValueDTO();
	public static Date now = new Date();
	public static String currentDate = new SimpleDateFormat("ddMMyyyyhhmmss").format(now);
	double start, finish, totalTime, LoadTime_Seconds;
	public static JavascriptExecutor js;
	public static FluentWait<WebDriver> fluentWait;
	public static String fileLocation, logFilePath, FileName;



	@SuppressWarnings("deprecation")
	public static WebElement elementToBeVisible(WebElement webElement) {

		try {

			fluentWait = new FluentWait<>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(10, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class);

			fluentWait.until(ExpectedConditions.visibilityOf(webElement));
			fluentWait.until(ExpectedConditions.elementToBeClickable(webElement));

		} catch (Exception e) {
			LogFile.APPLICATION_LOGS.error("Cannot find element: " + e.getMessage());
		}
		return webElement;
	}

	@SuppressWarnings("deprecation")
	public static WebElement elementToBeInvisible(WebElement webElement) {
		try {
			fluentWait = new FluentWait<>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(10, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class);

			fluentWait.until(ExpectedConditions.invisibilityOf(webElement));

		} catch (Exception e) {
			LogFile.APPLICATION_LOGS.error("Cannot find element: " + e.getMessage());
		}
		return webElement;
	}


	public static WebElement getObject(WebElement webElement) {

		try {
			elementToBeVisible(webElement);
		} catch (Exception t) {
			webElement = null;
			ErrorUtil.addVerificationFailure(t);
			LogFile.APPLICATION_LOGS.error("Cannot find object with key -- " + t.getMessage());
		}
		return webElement;
	}

	public static void scrollIntoView(WebElement webElement) {

		js = (JavascriptExecutor) driver;
		try {
			js.executeScript("window.scrollTo(0,500)", "webElement");
		} catch (Exception e) {
			LogFile.APPLICATION_LOGS.error("Cannot find object with key -- " + e.getMessage());
		}
	}


	public String getBrowserName() {
		return Dto.getWebDriverObj().toLowerCase();
	}

	
	
	public static String returnShortMOnth() {
		String mon = "";
		try {
			Calendar c = Calendar.getInstance();
			mon = c.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.ENGLISH);
			// mon=c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mon;
	}

	public static void uploadFile(WebElement webElement, String FileName) throws Throwable {

		try {
			fileLocation = MichaelpageConstants.FilePath + FileName;
			// System.out.println(fileLocation);
			webElement.sendKeys(fileLocation);
			Thread.sleep(5000);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			LogFile.APPLICATION_LOGS.error("File not found");
			System.out.println("File not found");
		}

	}



}
