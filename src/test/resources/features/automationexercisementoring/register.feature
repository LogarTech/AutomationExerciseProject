@regression
Feature: Testing the Registration of New User

  Scenario: Happy Path Of Registration

    Given User navigates to the AutomationExercise and validates the title 'Automation Exercise'
    When User clicks signUp Login button and validates the 'New User Signup!' visible
    And User provides username 'alexei' and email address 'alexeistrimbu117@gmail.com' and click sign up button
    And User verify 'ENTER ACCOUNT INFORMATION' message is visible
    And User provides TITLE, Name 'Alexei', Email , Password '7cepe', Date of Birth
    And User selects Sign Up for our newsletter! and receives special offers from our partners!
    And User provides 'Alexei', 'Strimbu', 'Argus, LLC', 'Alexandri 45', 'Eminescu 12', Country, 'Kingdom Of Maldovia', 'Cagul ','73152', '+1800877877'
    Then User clicks Create Account button and validates 'ACCOUNT CREATED!'
    And User clicks Continue Button and validate Logged in as username
    Then User clicks Delete Account button and validates 'ACCOUNT DELETED!' is visible
    And User clicks continue button






