Feature: SauceDemo Cart_Page
 
Scenario: Validate user navigates onto Product page
	Given Chrome is opened and SauceDemo app is opened
	When User enters correct Username "standard_user" and Password "secret_sauce"
	And Click on login button
	Then It shows product page
	When User click on add to cart button
	Then Product is added to cart page
  When User click on Basket button
  Then User Navigate to cart page
 
  
Scenario: Validate add to cart page UI
	Given Chrome is opened and SauceDemo app is opened
	When User enters correct Username "standard_user" and Password "secret_sauce"
	And Click on login button
	Then It shows product page
	When User click on add to cart button
	Then Product is added to cart page
  When User click on Basket button
  Then Cart page buttons are visible to user 
  
Scenario: Validate Continue Shopping button
  Given Chrome is opened and SauceDemo app is opened
	When User enters correct Username "standard_user" and Password "secret_sauce"
	And Click on login button
	Then It shows product page
	When User click on add to cart button
	Then Product is added to cart page
  When User click on Basket button
  Then User Navigate to cart page  
  When User click on continue shopping button
  Then User navigate to the product page
  
Scenario: Validate CheckOut button
  Given Chrome is opened and SauceDemo app is opened
	When User enters correct Username "standard_user" and Password "secret_sauce"
	And Click on login button
	Then It shows product page
	When User click on add to cart button
	Then Product is added to cart page
  When User click on Basket button
  Then User Navigate to cart page  
  When User click on CheckOut button
  Then User navigate to the Checkout information page

Scenario: Validate product details 
  Given Chrome is opened and SauceDemo app is opened
	When User enters correct Username "standard_user" and Password "secret_sauce"
	And Click on login button
	Then It shows product page
	When User click on add to cart button
	Then Product is added to cart page
  When User click on Basket button
  Then User Navigate to cart page 
  When User click on product 
  Then User navigate to product_details page
  
Scenario: Validate Remove button 
	Given Chrome is opened and SauceDemo app is opened
	When User enters correct Username "standard_user" and Password "secret_sauce"
	And Click on login button
	Then It shows product page
	When User click on add to cart button
	Then Product is added to cart page
  When User click on Basket button
  Then User Navigate to cart page
  When User click on remove button 
  Then User delete product from cart page
  
  
  