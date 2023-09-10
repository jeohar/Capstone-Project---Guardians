Feature: Retail Order Page

  Background: 
   Given User is on retail website
   When User click on Sign in option
   And User enter email 'johar@tekschool.us' and password 'Adieb@2016'
   And User click on login button
   And User should be logged in into Account
   
@AddItemToCart @Smoke
Scenario: Verify User can add an item to cart
   And User change the category to 'Smart Home'
   And User search for an item 'kasa outdoor smart plug'
   And User click on Search icon
   And User click on item
   And User select quantity '2'
   And User click add to Cart button
   Then the cart icon quantity should change to '2'
   And User cleans the cart before moving on
    
 @PlaceOrder @Smoke
 Scenario: Verify User can place an order with Shipping address and payment Method on file
    And User change the category to 'Electronics' Apex Legends
    And User search for an item 'Apex Legends' Apex Legends
    And User click on Search icon
    And User click on item Apex Legends
    And User select quantity '5' Apex Legends
    And User click add to Cart button
    Then the cart icon quantity should change to '5' Apex Legends
    And User click on Cart option
    And User click on Proceed to Checkout button
    And User click on Place Your Order
    Then A message should be displayed 'Order Placed, Thanks'
    
	@CancelTheOrder @Smoke
  Scenario: Verify User can cancel the order
    And User click on Orders section
    And User click on first order in list
    And User click on Cancel The Order button
    And User select the cancelation Reason 'Bought wrong item'
    And User click on Cancel Order button
    Then a cancelation message should be displayed 'Your OrderS Has Been Cancelled'
    
  @ReturnTheOrder @Smoke
  Scenario: Verify User can Return the order
    And User click on Orders section on page
    And User click on first order in list on page
    And User click on Return Items button
    And User select the Return Reason 'Item damaged'
    And User select the drop off service 'FedEx'
    And User click on Return Order button
    Then a cancelation message should be displayed 'Return was successfull'
    
  @WriteAReview @Smoke
  Scenario: Verify User can write a review on order placed
    And User click on Orders section on home
    And User click on first order in list on first page
    And User click on Review button
    And User write Review headline 'Good Video game' and 'sometext'
    And User click Add your Review button
    Then a review message should be displayed 'Your review was added successfully'