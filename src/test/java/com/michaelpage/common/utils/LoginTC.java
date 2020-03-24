package com.michaelpage.common.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Reporter;

import com.michaelpage.utils.LogFile;

public class LoginTC extends TestBase implements Cloneable {

	private static LoginTC object = null;
	String url = Dto.getURl();

	public static synchronized LoginTC getLoginTCObject() {
		if (object == null) {
			synchronized (LoginTC.class) {
				if (object == null) {
					object = new LoginTC();
				}
			}
		}
		return object;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	// Call browser
	public static void CallBrowser() {
		try {
			BrowserCallingTC bc = new BrowserCallingTC();
			bc.browserSelection();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void navigateToURL() {
		try {

			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Reporter.log("Launched Application");
			LogFile.APPLICATION_LOGS.info("Launched Application");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void LoginApplication() {

		try {
			driver.get(Dto.getURl());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.cssSelector("")).clear();
			driver.findElement(By.cssSelector("")).sendKeys(Dto.getUsername());
			driver.findElement(By.cssSelector("")).clear();
			driver.findElement(By.cssSelector("")).sendKeys(Dto.getPassword());
			driver.findElement(By.cssSelector("")).click();
			Reporter.log("Logged in to application with user name and Password");
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Logout() {
		driver.findElement(By.cssSelector("")).click();
		Reporter.log("Logged out from application");
	}

}
