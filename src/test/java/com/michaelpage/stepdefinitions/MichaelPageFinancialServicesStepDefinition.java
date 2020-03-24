package com.michaelpage.stepdefinitions;

import com.aventstack.extentreports.GherkinKeyword;
import com.michaelpage.common.utils.ExtentReportBaseUtil;
import com.michaelpage.pages.MichaelPageFinancialServicesPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class MichaelPageFinancialServicesStepDefinition extends ExtentReportBaseUtil {

	MichaelPageFinancialServicesPage mpFinancialServicesPage;

	public MichaelPageFinancialServicesStepDefinition() {
		mpFinancialServicesPage = new MichaelPageFinancialServicesPage();
	}

	@Then("^I click on \"([^\"]*)\" button on Financial Services screen$")
	public void i_click_on_button_on_financial_services_screen(String webElementTitle) throws Throwable {
		mpFinancialServicesPage.clickOnElement(webElementTitle);
		scenarioTest.createNode(new GherkinKeyword("Then"), "i_click_on_button_on_financial_services_screen: "+ webElementTitle.toString() );

	}

	@Then("^I verify \"([^\"]*)\" Message on Financial Services screen$")
	public void i_verify_message_on_financial_services_screen(String webElementTitle) throws Throwable {
		mpFinancialServicesPage.verifyTextMessage(webElementTitle);
		scenarioTest.createNode(new GherkinKeyword("Then"), "i_verify_message_on_financial_services_screen: "+ webElementTitle.toString() );

	}

	@Then("^I enter \"([^\"]*)\" in \"([^\"]*)\" field on Financial Services screen$")
	public void i_enter_in_field_on_financial_services_screen(String text, String webElementTitle) throws Throwable {
		mpFinancialServicesPage.enterText(webElementTitle, text);
		scenarioTest.createNode(new GherkinKeyword("Then"), "i_enter_in_field_on_financial_services_screen: "+ webElementTitle.toString() );

	}

	@Then("^I Mouse Over on \"([^\"]*)\" button on Financial Services screen$")
	public void i_mouse_over_on_button_on_financial_services_screen(String webElementTitle) throws Throwable {
		mpFinancialServicesPage.moveToElement(webElementTitle);
		scenarioTest.createNode(new GherkinKeyword("Then"), "i_mouse_over_on_button_on_financial_services_screen: "+ webElementTitle.toString() );

	}

	@And("^I verify \"([^\"]*)\" on Financial Services screen$")
	public void i_verify_on_financial_services_screen(String webElementTitle) throws Throwable {
		mpFinancialServicesPage.verifyUploadedCV(webElementTitle);
		scenarioTest.createNode(new GherkinKeyword("And"), "i_verify_on_financial_services_screen: "+ webElementTitle.toString() );

	}

}