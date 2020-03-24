package com.michaelpage.stepdefinitions;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.michaelpage.common.utils.ExtentReportListener;
import com.michaelpage.pages.MichaelPageHomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;




public class MichaelPageHomeStepDefinition extends ExtentReportListener {

	protected MichaelPageHomePage mpHomePage;

	WebDriver driver;

	ExtentTest logInfo = null;

	public MichaelPageHomeStepDefinition() {
		mpHomePage = new MichaelPageHomePage();
	}

	@Given("^I am on MichaelPageHomePage$")
	public void i_am_on_the_MichaelPageHomePage() throws Throwable {

		try {
			mpHomePage.launchApplication();
			test = extent.createTest(Feature.class, "Verify CV is uploaded successfully");
			test = test.createNode(Scenario.class, "Upload And Sign In");
			logInfo = test.createNode(new GherkinKeyword("Given"),
					"i_am_on_the_MichaelPageHomePage:Launched Application");

		} catch (AssertionError | Exception e) {

			testStepHandle("FAIL", driver, logInfo, e);

		}

	}

	@When("^I click on \"([^\"]*)\" button on Home screen$")
	public void i_click_on_button_on_Home_screen(String webElementTitle) throws Throwable {

		try {
			mpHomePage.clickOnElement(webElementTitle);
			logInfo = test.createNode(new GherkinKeyword("When"),
					"i_click_on_button_on_Home_screen:Clicked on: " + webElementTitle.toString());

		} catch (AssertionError | Exception e) {

			testStepHandle("FAIL", driver, logInfo, e);

		}

	}

}