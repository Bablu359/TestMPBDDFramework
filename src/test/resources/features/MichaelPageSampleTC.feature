@UploadCVandVerify 
Feature: Verify CV is uploaded successfully 

@UploadandSignIn 
Scenario Outline: Upload And Sign In 

	Given I am on MichaelPageHomePage 
	When I click on "BrowsebyIndustry" button on Home screen 
	When I click on "Financial Services" button on Home screen
	
	
	#Then I click on "View Job" button on Financial Services screen
	#Then I click on "Apply" button on Financial Services screen
	#Then I click on "Apply with your CV" button on Financial Services screen
	#Then I click on "Next" button on Financial Services screen
	#
	#And I enter "Enter your email address" field on ApplywithyourCV screen
	#And I enter "First Name" field on ApplywithyourCV screen
	#And I enter "Last Name" field on ApplywithyourCV screen
	#And I enter "Phone Number" field on ApplywithyourCV screen
	#And I click on "Upload CV" button on ApplywithyourCV screen
	#And I click on "Upload CV Browse" button on ApplywithyourCV screen
	#And We upload the File
	#And I click on "Apply Now" button on ApplywithyourCV screen
	#
	#Then I verify "Thank you" Message on Financial Services screen
	#And I verify "Sign up" on Financial Services screen
	#Then I enter "<Password>" in "Password" field on Financial Services screen
	#Then I click on "Sign up" button on Financial Services screen
	#And I verify "You are now logged in" Message on Financial Services screen
	#And I verify "Setup one click apply" Message on Financial Services screen
	#
	#Then I Mouse Over on "User Menu" button on Financial Services screen
	#Then I click on "MyPage your account" button on Financial Services screen
	#Then I click on "My CV" button on Financial Services screen
	#
	#And I verify "Uploaded CV" on Financial Services screen
	#Then I verify "Default" Message on Financial Services screen
	
	#
	#When I enter "<Password>" in "Password" field on Login screen
	#And I click on "Login" button on Login screen
	#Then I click on "Add Employee" button on Employee List screen
	#Then I Enter "<First Name>" in "First Name" field on Employee Details screen
	#Then I Enter "<Last Name>" in "Last Name" field on Employee Details screen
	#Then I Enter "<Age>" in "Age" field on Employee Details screen
	#Then I Enter "<Address>" in "Address" field on Employee Details screen
	#Then I Enter "<Designation>" in "Designation" field on Employee Details screen
	#Then I click on "Save" button on Employee Details screen
	#Then I verify the "Employee Name" on Employee List screen
	#Then I click on "Sign Out" button on Employee List screen
	
	Examples: 
		|UserName|Password|First Name|Last Name|Age|Address|Designation|
		|admin	 |CapGemini01*|Savita	 |Tambe	   |34 |Panvel |Manager    |