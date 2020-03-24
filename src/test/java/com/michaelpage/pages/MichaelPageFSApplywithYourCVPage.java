package com.michaelpage.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.michaelpage.common.utils.MichaelpageConstants;
import com.michaelpage.common.utils.RandomDataUtil;
import com.michaelpage.common.utils.ReusableMethodTC;
import com.michaelpage.utils.LogFile;

public class MichaelPageFSApplywithYourCVPage extends ReusableMethodTC {

	// Financial Services - Apply with Your CV Page - Enter your email address
	@FindBy(xpath = "//input[@id='edit-email']")
	public WebElement fsAppyWithYourCVEmailAddressTxb;

	// Financial Services - Apply with Your CV Page - First Name
	@FindBy(xpath = "//input[@id='edit-firstname']")
	public WebElement fsAppyWithYourCVFirstNameTxb;

	// Financial Services - Apply with Your CV Page - Last Name
	@FindBy(xpath = "//input[@id='edit-lastname']")
	public WebElement fsAppyWithYourCVLastNameTxb;

	// Financial Services - Apply with Your CV Page - Phone Number
	@FindBy(xpath = "//input[@id='edit-user-telephone']")
	public WebElement fsAppyWithYourCVPhoneNumberTxb;

	// Financial Services - Apply with Your CV Page - Upload CV
	@FindBy(xpath = "//a[contains(.,'Upload CV')]")
	public WebElement fsAppyWithYourCVUploadCVBtn;

	// Financial Services - Apply with Your CV Page - Upload CV - Browse
	@FindBy(css = ".browse > span")
	public WebElement fsAppyWithYourCVUploadCVBrowseBtn;

	// Financial Services - Apply with Your CV Page - Upload CV - Browse
	@FindBy(css = "#edit-field-3rd-party-file-upload-und-0")
	public WebElement fsFileUploadwindow;

	// Financial Services - Apply with Your CV Page - Apply Now
	@FindBy(id = "edit-submit")
	public WebElement fsAppyWithYourCVApplyNowBtn;

	public MichaelPageFSApplywithYourCVPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterRandomText(String webElementTitle) {

		switch (webElementTitle.toUpperCase()) {
		case "FIRST NAME": {
			ReusableMethodTC.sendKeys(fsAppyWithYourCVFirstNameTxb, RandomDataUtil.randomStringGenerator());
			Reporter.log("Entered First Name");
			LogFile.APPLICATION_LOGS.info("Entered First Name");
			break;
		}
		case "LAST NAME": {
			ReusableMethodTC.sendKeys(fsAppyWithYourCVLastNameTxb, RandomDataUtil.randomStringGenerator());
			Reporter.log("Entered Last Name");
			LogFile.APPLICATION_LOGS.info("Entered Last Name");
			break;
		}
		case "ENTER YOUR EMAIL ADDRESS": {
			ReusableMethodTC.sendKeys(fsAppyWithYourCVEmailAddressTxb,
					RandomDataUtil.randomStringGenerator() + "!12@gmail.com");
			Reporter.log("Entered Email Address");
			LogFile.APPLICATION_LOGS.info("Entered Email Address");
			break;
		}
		case "PHONE NUMBER": {
			ReusableMethodTC.sendKeys(fsAppyWithYourCVPhoneNumberTxb, RandomDataUtil.randomIntegerGenerator());
			Reporter.log("Entered Phone Number");
			LogFile.APPLICATION_LOGS.info("Entered Phone Number");
			break;
		}
		}

	}

	public void clickOnElement(String webElementTitle) {

		switch (webElementTitle.toUpperCase()) {
		case "APPLY NOW": {
			ReusableMethodTC.click(fsAppyWithYourCVApplyNowBtn);
			Reporter.log("Clicked on 'APPLY NOW'");
			LogFile.APPLICATION_LOGS.info("Clicked on 'APPLY NOW'");
			break;
		}
		case "UPLOAD CV": {
			ReusableMethodTC.click(fsAppyWithYourCVUploadCVBtn);
			Reporter.log("Clicked on 'UPLOAD CV'");
			LogFile.APPLICATION_LOGS.info("Clicked on 'UPLOAD CV'");
			break;
		}
		case "UPLOAD CV BROWSE": {
			ReusableMethodTC.click(fsAppyWithYourCVUploadCVBrowseBtn);
			Reporter.log("Clicked on 'UPLOAD CV BROWSE'");
			LogFile.APPLICATION_LOGS.info("Clicked on 'UPLOAD CV BROWSE'");
			break;
		}
		}

	}

	public void fileUpload() throws Throwable {
		ReusableMethodTC.uploadFile(fsFileUploadwindow, "UFT Automation Coding Standards in XLC.doc");
		Reporter.log("Uploaded file");
	}

}
