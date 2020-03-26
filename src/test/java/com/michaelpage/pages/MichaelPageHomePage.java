package com.michaelpage.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.michaelpage.common.utils.ExtentReportBaseUtil;
import com.michaelpage.common.utils.LoginTC;
import com.michaelpage.common.utils.MichaelpageConstants;
import com.michaelpage.common.utils.ReusableMethodTC;
import com.michaelpage.utils.LogFile;

public class MichaelPageHomePage extends ReusableMethodTC {

	static LoginTC login = new LoginTC();

	@FindBy(xpath = "//span[contains(text(),'Browse by industry')]")
	public static WebElement browsebyindustryWebElm;

	@FindBy(xpath = "//div[@class='browse_jobs_block_industry']//a[contains(text(),'Financial Services')]")
	public WebElement financialServicesWebElm;

	public MichaelPageHomePage() {
		PageFactory.initElements(driver, this);
	}

	public void launchApplication() {
		ReusableMethodTC.elementToBeInvisible(browsebyindustryWebElm);
		login.navigateToURL();

	}

	public void clickOnElement(String webElementTitle) throws IOException {

		switch (webElementTitle.toUpperCase()) {

		case "BROWSEBYINDUSTRY": {
			ReusableMethodTC.click(browsebyindustryWebElm);
    
			Reporter.log("Clicked on 'BROWSE BY INDUSTRY' ");
			LogFile.APPLICATION_LOGS.info("Clicked on 'BROWSE BY INDUSTRY'");
			break;
		}
		case "FINANCIAL SERVICES": {
			ReusableMethodTC.click(financialServicesWebElm);
			Reporter.log("Clicked on 'FINANCIAL SERVICES' ");
			LogFile.APPLICATION_LOGS.info("Clicked on 'FINANCIAL SERVICES' ");
			break;
		}

		}
	}

}
//test git push