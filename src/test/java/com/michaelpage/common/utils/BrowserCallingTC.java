package com.michaelpage.common.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import com.michaelpage.utils.LogFile;

public class BrowserCallingTC extends TestBase {

	protected void browserSelection() {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		if ("firefox".equalsIgnoreCase(Dto.getWebDriverObj())) {

			File profileDirectory = new File(Dto.getFirefoxProfilePath());
			// FirefoxProfile profile = new FirefoxProfile(profileDirectory);
			FirefoxProfile fxProfile = new FirefoxProfile(profileDirectory);
			fxProfile.setAcceptUntrustedCertificates(false);
			fxProfile.setAssumeUntrustedCertificateIssuer(true);
			fxProfile.setPreference("xpinstall.signatures.required", false);
			fxProfile.setPreference("network.cookie.cookieBehavior", 1);
			fxProfile.setPreference("browser.download.folderList", 2);
			fxProfile.setPreference("browser.download.manager.showWhenStarting", false);
			fxProfile.setPreference("browser.download.dir", MichaelpageConstants.DOWNLOAD_PATH + "\\");
			fxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
			fxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
					"application/pdf,application/ms-excel,text/csv,image/jpeg,image/svg+xml,image/png,application/csv,application/vnd.ms-excel,application/octet-stream");
			System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver/geckodriver.exe");
			capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability(FirefoxDriver.PROFILE, fxProfile);
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver();
			// d = new EventFiringWebDriver(wd);
			driver.manage().window().maximize();
			Reporter.log("Firefox Running");
			LogFile.APPLICATION_LOGS.info("Firefox Running");

		} else if ("ie".equalsIgnoreCase(Dto.getWebDriverObj())) {

			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability("ignoreZoomSetting", true);
			capabilities.setCapability("nativeEvents", true);
			capabilities.setCapability("unexpectedAlertBehaviour", "accept");
			capabilities.setCapability("ignoreProtectedModeSettings", true);
			capabilities.setCapability("disable-popup-blocking", true);
			capabilities.setCapability("enablePersistentHover", true);
			capabilities.setCapability("IntroduceInstabilityByIgnoringProtectedModeSettings", true);
			// caps.setCapability("requireWindowFocus", false);
			System.setProperty("webdriver.ie.driver", "./src/test/resources/WebDrivers/IE Driver/IEDriverServer.exe");
			// caps.setCapability("requireWindowFocus", false);
			driver = new InternetExplorerDriver();
			// d = new EventFiringWebDriver(wd);
			// maximiseWindow();
			Reporter.log("IE Running");
			LogFile.APPLICATION_LOGS.info("IE Running");

		} else if ("chrome".equalsIgnoreCase(Dto.getWebDriverObj())) {
			String chromeProfile = Dto.getChromeProfilePath();
			Map<String, Object> prefs = new HashMap<String, Object>();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			options.addArguments("test-type");
			options.addArguments("start-maximized");
			options.addArguments("--js-flags=--expose-gc");
			options.addArguments("--enable-precise-memory-info");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--disable-default-apps");
			options.addArguments("disable-infobars");
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("profile.default_content_settings.cookies", 2);
			options.setExperimentalOption("prefs", prefs);
			String[] switches = { "user-data-dir=" + chromeProfile };
			capabilities.setCapability("chrome.switches", "--disable-extensions");
			capabilities.setCapability("chrome.switches", switches);
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			capabilities.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS, true);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability("cssSelectorsEnabled", true);
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/WebDrivers/Chrome/chromedriver.exe");
			driver = new ChromeDriver();
			// d = new EventFiringWebDriver(wd);
			driver.manage().window().maximize();
			LogFile.APPLICATION_LOGS.info("Chrome Running");
			Reporter.log("Chrome Running");
		}
		/*
		 * } else if ("Edge".equalsIgnoreCase(Dto.getWebDriverObj())) {
		 * 
		 * DesiredCapabilities caps = new DesiredCapabilities(); EdgeOptions options =
		 * new EdgeOptions(); System.setProperty(
		 * "webdriver.edge.driver","./Microsoft WebDriver/MicrosoftWebDriver.exe");
		 * //Start Edge Session options.setPageLoadStrategy("eager");
		 * //caps.setCapability(EdgeOptions.CAPABILITY,options); wd = new EdgeDriver();
		 * d = new EventFiringWebDriver(wd); d.manage().window().maximize();
		 * Reporter.log("Edge Running");
		 * 
		 * }
		 */else {
			 Reporter.log("Enter Valid browser name");
			 LogFile.APPLICATION_LOGS.error("Enter Valid browser name");
		 }

	}

	/*
	 * protected void maximiseWindow() { Point targetPosition = new Point(0, 0);
	 * wd.manage().window().setPosition(targetPosition); String w =
	 * "return screen.availWidth"; String h = "return screen.availHeight"; int width
	 * = ((Long) ((Object) wd).executeScript(w)).intValue(); int height = ((Long)
	 * wd.executeScript(h)).intValue(); Dimension targetSize = new Dimension(width,
	 * height); wd.manage().window().setSize(targetSize); }
	 */

}