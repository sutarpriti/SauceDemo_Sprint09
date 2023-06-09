Feature: SauceDemo Product_Name2

Scenario Outline: Validate products_Name
  Given Chrome is opened and SauceDemo app is opened
	When User enters correct Username "standard_user" and Password "secret_sauce"
	And Click on login button
	Then It shows product page
	When User click on add to cart button
	Then Product is added to cart page
  When User click on Basket button
  Then User Navigate to cart page
  Then check name of product "<Product_Name>"
  Examples:
  
  |     Product_Name            |
  |   Sauce Labs Bike Light     |
  |   Sauce Labs Bolt T-Shirt   |
  
  
