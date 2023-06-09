package com.page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utility.Utility;

public class Cart_Page extends Utility {

	 	 public Cart_Page() {
			PageFactory.initElements(driver, this);
		}
		
	 //Continue Shopping 
	 @FindBy(xpath = "//button[@name='continue-shopping']")
	    WebElement Continue_shopping;
	 
	 public Product_Page Continue_Shopping()throws IOException {
		 Continue_shopping.click();
		 
		// Continue_shopping.isDisplayed();
		 System.out.println("Continue_shopping is visible");
		return new Product_Page();
	 }

	
	 //Product item
	@FindBy(xpath = "//div[text()='Sauce Labs Bike Light']")
	 WebElement product;
	 
	 public Product_Page product_item()
	 {
		 product.click();
		
		 System.out.println("Continue_shopping is visible");
		 return new Product_Page();
	 }
	
    //Remove button
	 @FindBy(xpath = "//*[text()='Remove']")
	   WebElement Remove; 

	 public void Remove() {
		 Remove.click();
		 Remove.isDisplayed();
		 System.out.println("Continue_shopping is visible");		
	   }
	 
	 //CheckOut button
	// @FindBy(xpath = "//button[@id='checkout']")
	 @FindBy(xpath = "//button[@name='checkout']")
	    WebElement Checkout;
			
	 public CheckOut_Page CheckOut()throws IOException {
		 Checkout.click();
		// Checkout.isDisplayed();
		return new CheckOut_Page();
	 }
	 
	 //Product_Name 1
	 @FindBy(xpath = "//div[text()='Sauce Labs Bike Light']")
	   WebElement Product1; 

	/* public boolean Product_Name() {
		 return Product1.isDisplayed();
      }*/
	 
	 public void isProductNameVisible(String Product_Name1)
	 {
		 Product1.isDisplayed();
		 System.out.println("Product Name Sauce Labs Bike Light is visible");
	 }
	 
	 //Product_Name 2
	 @FindBy(xpath = "//div[text()='Sauce Labs Bolt T-Shirt']")
	   WebElement Product2; 

	 public boolean Product_Name2() {
		 return Product2.isDisplayed();
		
	   }
	/* public void isProductNameVisible2()
	 {
		 Product2.isDisplayed();
		 System.out.println("Sauce Labs Bolt T-Shirt is visible");
	 }*/
	
}
