@Smoke
Feature: Retail Account Page

  Background: 
    Given User is on retail website homepage
    When User click on Sign in option
    And User enter email 'johar@tekschool.us' and password 'Adieb@2016'
    And User click on login button
    Then User should be logged in into Account
    When User click on Account option

  @updatePI 
  Scenario: Verify User can update Profile Information
    When User click on Account option
    And User update Name 'Ahmad' and Phone '4215553333'
    And User click on Update button
    Then user profile information should be updated

  @addPaymentMethod 
  Scenario: Verify User can add a payment method
    And User click on Add a payment method link
    And User fill Debit or credit card information
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 1111222273335555 | Guardians  |              12 |           2024 |          561 |
    And User click on Add your card button
    Then a message should be displayed 'Payment Method added sucessfully'

  @userUpdatesTheCreditDebitCard 
  Scenario: Verify User can edit Debit or Credit card
    And User click on Edit option of card section
    And user edit information with below data
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 1230000344796310 | Musk       |               7 |           2029 |          354 |
    And user click on Update Your Card button
    Then a message should be displayed 'Payment Method updated Successfully'

  @removeCard 
  Scenario: Verify User can remove Debit or Credit card
    And User click on selected card
    And User click on remove option of card section

  @addAddress 
  Scenario: Verify User can add an Address
    When User click on Account option
    And User click on Add address option
    And user fill new address form with below information
      | country      | fullName      | phoneNumber | streetAddress | apt      | city      | state      | zipCode      |
      | countryValue | fullnameValue | PhoneValue  | stAddress     | aptValue | cityValue | stateValue | zipCodeValue |
    And User click Add Your Address button
    Then a message should be displayed 'Address Added Successfully'

  @userEditAddress 
  Scenario: Verify User can edit an Address added on account
    And User click on edit address option
    And User fill new address form with following information
      | country       | fullName    | phoneNumber | streetAddress   | apt | city | state      | zipCode |
      | United States | Hasib Johar |  2030232030 | 6130 BeverHills |  99 | LA   | California |   91000 |
    And User click update Your Address button
    Then a message should be displayed 'Address Updated Successfully'

  @removeAddress 
  Scenario: Verify User can remove Address from Account
    And User click on remove option of Address section
    Then Address details should be removed
