
@smoke
  Feature: Testing the Login Functionality

    Background: Login with Correct and Incorrect Credentials
      Given User navigates to the AutomationExercise and validates the title 'Automation Exercise' is visible


    Scenario: Login with Correct Credentials
      When User clicks signUp Login button and validates the 'Login to your account' is visible
      And User provides email address 'alexeistrimbu115@gmail.com', password '7cepe' and clicks login button
      And User verify that Logged in as username is visible
      Then User clicks Delete Account button
      And User verifies that 'ACCOUNT DELETED!' is visible

      @testCase3
      Scenario: Login with Incorrect Credentials
        When User clicks signUp Login button and validates the 'Login to your account' is visible
        And User provides wrong email address 'alexeistrimbu11225@gmail.com', password '5cepe' and clicks login button
        Then User verifies error message 'Your email or password is incorrect!' is visible

    @testCase4
        Scenario: Verifying Log Out Functionality
      When User clicks signUp Login button and validates the 'Login to your account' is visible
          And User provides email address 'alexeistrimbu115@gmail.com', password '7cepe' and clicks login button
          And User verify that Logged in as username is visible
          Then User clicks Logout button
          And User verifies that is navigated to login page

    @testCase5
    Scenario: Register with an existing Email
      When User clicks signUp Login button and validates the 'Login to your account' is visible
      And User provides username 'alexei' and email address 'alexeistrimbu115@gmail.com' and click sign up button
      Then Verify error 'Email Address already exist!' is visible

    @testCase6
    Scenario: Contact Us Form
      Given User navigates to the AutomationExercise and validates title 'Automation Exercise' is visible
      When User clicks on Contact Us button and verifies 'GET IN TOUCH' is visible
      Then User enters name 'alexei', email 'alexeistrimbu115@gmail.com', subject 'Cautam Aur', and message 'Cumparam proba 485'
      And User uploads '/Users/dumitruprumann/Desktop/aur.jpeg' file and user clicks Submit button
      And User click OK button
      Then User verifies success message 'Success! Your details have been submitted successfully.' is visible
      And User clicks Home button and verify that landed to home page successfully

    @testCase7
    Scenario: Verify Test Cases Page
      Given User navigates to the AutomationExercise and validates title 'Automation Exercise' is visible
      When User clicks on Test Cases button
      Then User verifies is navigated to test cases page successfully

    @testCase8
    Scenario: Verify All Products and product detail page
      When click on Products button
      And Verify user is navigated to ALL PRODUCTS page successfully and The products list is visible, click on View Product of first product
      Then User is landed to product detail page
      And Verify that detail detail is visible: product name, category, price, availability, condition, brand

    @testCase9
    Scenario: Search Product
      When click on Products button
      And Verify user is navigated to ALL PRODUCTS page successfully
      Then User enters product name in search input and click search button
      And User verifies SEARCHED PRODUCTS is visible, user verifies all the products related to search are visible

    @testCase10
    Scenario: Verify Subscription in home page
      When User scrolls down to footer and verifies text 'SUBSCRIPTION'
      And User enters 'alexeistrimbu115@gmail.com' in input and clicks arrow button
      Then User verifies the message 'You have been successfully subscribed!' is visible

    @testCase11
    Scenario: Verify Subscription in Cart page
      When User clicks Cart button
      And User scrolls down to footer, verifies text 'SUBSCRIPTION'
      Then User enters email 'alexeistrimbu115@gmail.com' in input and click arrow button
      And User verify the message 'You have been successfully subscribed!' is visible

    @testCase12
    Scenario: Add Products in Cart
      When User clicks Products button and user hovers over first product and click Add to cart
      And User click Continue Shopping button, user hovers over second product and clicks Add to cart
      Then User clicks View Cart button and verifies both products are added to Cart
      And User verifies their prices, quantity and total price

    @testCase13
    Scenario: Verify Product quantity in Cart
     When Click 'View Product' for any product on home page, verify product detail is opened










