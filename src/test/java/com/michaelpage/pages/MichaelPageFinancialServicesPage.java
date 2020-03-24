package com.michaelpage.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.michaelpage.common.utils.ReusableMethodTC;
import com.michaelpage.utils.LogFile;

public class MichaelPageFinancialServicesPage extends ReusableMethodTC {

	// Financial Services Page - View Job Button 1
	@FindBy(xpath = "(//*[@class='job-list']//div[contains(@class,'view-node')]//span[contains(@class,'view-job')])[1]")
	public WebElement fsViewJobBtn;

	// Financial Services Page - Results Page - Apply
	@FindBy(xpath = "//span[@class='apply-job redirect-url-span-tag']")
	public WebElement fsSearchApplyBtn;

	// Financial Services Page - Apply with your CV Radio Button
	@FindBy(xpath = "//li[@class='cv-form-apply active']")
	public WebElement fsApplyWithYourCVBtn;

	// Financial Services Page - Next Button
	@FindBy(xpath = "//a[@class='form-submit next-btn']")
	public WebElement fsNextBtn;

	// Financial Services Page - Thank you Heading 1
	@FindBy(xpath = "//h1[contains(text(),'Thank you')]")
	public WebElement fsThankYouwebElm;

	// Financial Services Page - Sign Up Button
	@FindBy(xpath = "//input[@id='edit-submit']")
	public WebElement fsSignUpBtn;

	// Financial Services Page - Password Text Box
	@FindBy(xpath = "//input[@id='edit-pass']")
	public WebElement fspasswordTxb;

	// Financial Services Page - Success Message
	@FindBy(xpath = "//div[@class='success-message'][text()='You are now logged in.']")
	public WebElement fsSuccessMsgwebElm;

	// Financial Services Page - Setup one click apply
	@FindBy(xpath = "//a[contains(text(),'Setup one click apply')]")
	public WebElement fsSetuponeclickapplywebElm;

	// Financial Services Page - User Menu
	@FindBy(xpath = "//div[@id='header-region']//div[@class='name']//a")
	public WebElement fsUserMenuLnk;

	// Financial Services Page - MyPage (your account) Link
	@FindBy(xpath = "//div[@id='header-region']//a[contains(text(),'MyPage (your account)')]")
	public WebElement fsUserMyPageyourAccountLnk;

	// Financial Services Page - My Page - My CV
	@FindBy(xpath = "//a[contains(text(),'My CV')]")
	public WebElement fsUserMyPageMyCVLnk;

	// Financial Services Page - My Page - My CV - Displayed CV
	@FindBy(xpath = "//a[@class='cvDisplayedTitle']")
	public WebElement fsUserMyPageMyCVDisplayedCVwebElm;

	// Financial Services Page - My Page - My CV - Default Text
	@FindBy(xpath = "//span[@class='cv-default show']")
	public WebElement fsUserMyPageMyCVDefaultwebElm;

	public MichaelPageFinancialServicesPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterText(String webElementTitle, String text) {

		switch (webElementTitle.toUpperCase()) {

		case "PASSWORD": {
			ReusableMethodTC.sendKeys(fspasswordTxb, text);
			Reporter.log("Entered Password");
			LogFile.APPLICATION_LOGS.debug("Entered Password");
			break;
		}

		}
	}

	public void clickOnElement(String webElementTitle) {

		switch (webElementTitle.toUpperCase()) {
		case "VIEW JOB": {
			ReusableMethodTC.click(fsViewJobBtn);
			Reporter.log("Clicked on 'VIEW JOB' button ");
			LogFile.APPLICATION_LOGS.debug("Clicked on 'VIEW JOB' button ");
			break;
		}
		case "APPLY": {
			ReusableMethodTC.click(fsSearchApplyBtn);
			Reporter.log("Clicked on 'APPLY' button ");
			LogFile.APPLICATION_LOGS.debug("Clicked on 'APPLY' button ");
			break;
		}
		case "APPLY WITH YOUR CV": {
			ReusableMethodTC.click(fsApplyWithYourCVBtn);
			Reporter.log("Clicked on 'APPLY WITH YOUR CV' ");
			LogFile.APPLICATION_LOGS.debug("Clicked on 'APPLY WITH YOUR CV' ");
			break;
		}
		case "NEXT": {
			ReusableMethodTC.click(fsNextBtn);
			Reporter.log("Clicked on 'NEXT' button ");
			LogFile.APPLICATION_LOGS.debug("Clicked on 'NEXT' button ");
			break;
		}
		case "SIGN UP": {
			ReusableMethodTC.click(fsSignUpBtn);
			Reporter.log("Clicked on 'SIGN UP' button ");
			LogFile.APPLICATION_LOGS.debug("Clicked on 'SIGN UP' button ");
			break;
		}

		case "MYPAGE YOUR ACCOUNT": {
			ReusableMethodTC.click(fsUserMyPageyourAccountLnk);
			Reporter.log("Clicked on 'MYPAGE YOUR ACCOUNT' ");
			LogFile.APPLICATION_LOGS.debug("Clicked on 'MYPAGE YOUR ACCOUNT' ");
			break;
		}
		case "MY CV": {
			ReusableMethodTC.click(fsUserMyPageMyCVLnk);
			Reporter.log("Clicked on 'MY CV' ");
			LogFile.APPLICATION_LOGS.debug("Clicked on 'MY CV' ");
			break;
		}
		}

	}

	public void verifyTextMessage(String webElementTitle) throws Exception {

		switch (webElementTitle.toUpperCase()) {
		case "THANK YOU": {
			ReusableMethodTC.elementToBeInvisible(fsThankYouwebElm);
			ReusableMethodTC.verifyText("THANK YOU", fsThankYouwebElm.getText().toUpperCase());
			Reporter.log("Verified 'Thank You' Message on screen ");
			LogFile.APPLICATION_LOGS.debug("Verified 'Thank You' Message on screen ");
			break;
		}
		case "YOU ARE NOW LOGGED IN": {
			ReusableMethodTC.elementToBeInvisible(fsSuccessMsgwebElm);
			ReusableMethodTC.verifyText("YOU ARE NOW LOGGED IN.", fsSuccessMsgwebElm.getText().toUpperCase());
			Reporter.log("Verified 'YOU ARE NOW LOGGED IN' Message on screen ");
			LogFile.APPLICATION_LOGS.debug("Verified 'YOU ARE NOW LOGGED IN' Message on screen ");
			break;
		}
		case "SETUP ONE CLICK APPLY": {
			ReusableMethodTC.elementToBeInvisible(fsSetuponeclickapplywebElm);
			ReusableMethodTC.verifyText("SETUP ONE CLICK APPLY", fsSetuponeclickapplywebElm.getText().toUpperCase());
			Reporter.log("Verified 'SETUP ONE CLICK APPLY' Message on screen ");
			LogFile.APPLICATION_LOGS.debug("Verified 'SETUP ONE CLICK APPLY' Message on screen ");
			break;
		}
		case "DEFAULT": {
			ReusableMethodTC.elementToBeInvisible(fsUserMyPageMyCVDefaultwebElm);
			ReusableMethodTC.verifyText("DEFAULT", fsUserMyPageMyCVDefaultwebElm.getText().toUpperCase());
			Reporter.log("Verified 'DEFAULT' Message on screen ");
			LogFile.APPLICATION_LOGS.debug("Verified 'DEFAULT' Message on screen ");
			break;
		}

		}
	}

	public void moveToElement(String webElementTitle) {
		ReusableMethodTC.mouseOver(fsUserMenuLnk);
		Reporter.log("Mouse over On 'User Menu'");
		LogFile.APPLICATION_LOGS.debug("Mouse over On 'User Menu'");
	}

	public void verifyUploadedCV(String webElementTitle) {

		try {
			ReusableMethodTC.elementToBeInvisible(fsUserMyPageMyCVDisplayedCVwebElm);
			String verifyCV = fsUserMyPageMyCVDisplayedCVwebElm.getText();
			System.out.println("Uploaded File is: " + verifyCV);
			Reporter.log("Uploaded File is: " + verifyCV);
			LogFile.APPLICATION_LOGS.debug("Uploaded File is: " + verifyCV);
		} catch (Exception e) {
			Reporter.log("Verified the Uploaded CV  is not matching the Visible CV on screen");
			LogFile.APPLICATION_LOGS.error("Verified the Uploaded CV  is not matching the Visible CV on screen");
			e.printStackTrace();
		}

	}

}