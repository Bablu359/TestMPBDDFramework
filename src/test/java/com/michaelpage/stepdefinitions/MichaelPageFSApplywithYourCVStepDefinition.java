package com.michaelpage.stepdefinitions;

import com.aventstack.extentreports.GherkinKeyword;
import com.michaelpage.common.utils.ExtentReportBaseUtil;
import com.michaelpage.pages.MichaelPageFSApplywithYourCVPage;
import cucumber.api.java.en.And;


public class MichaelPageFSApplywithYourCVStepDefinition extends ExtentReportBaseUtil{

	protected MichaelPageFSApplywithYourCVPage mpFSApplywithYourCVPage;

	public MichaelPageFSApplywithYourCVStepDefinition() {

		mpFSApplywithYourCVPage = new MichaelPageFSApplywithYourCVPage();

	}

	@And("^I enter \"([^\"]*)\" field on ApplywithyourCV screen$")
	public void i_enter_field_on_ApplywithyourCV_screen(String webElementTitle) throws Throwable {
		mpFSApplywithYourCVPage.enterRandomText(webElementTitle);
		scenarioTest.createNode(new GherkinKeyword("And"), "i_enter_field_on_ApplywithyourCV_screen: "+ webElementTitle.toString() );

	}

	@And("^I click on \"([^\"]*)\" button on ApplywithyourCV screen$")
	public void i_click_on_button_on_ApplywithyourCV_screen(String webElementTitle) throws Throwable {
		mpFSApplywithYourCVPage.clickOnElement(webElementTitle);
		scenarioTest.createNode(new GherkinKeyword("And"), "i_click_on_button_on_ApplywithyourCV_screen: "+ webElementTitle.toString() );
	}

	@And("^We upload the File$")
	public void we_upload_the_File() throws Throwable {
		mpFSApplywithYourCVPage.fileUpload();
		scenarioTest.createNode(new GherkinKeyword("And"), "we_upload_the_File: File Uploaded" );


	}

}