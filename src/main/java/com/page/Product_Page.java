package com.page;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utility.Utility;

public class Product_Page extends Utility {
	
	
	public Product_Page() 
	 {
		PageFactory.initElements(driver, this);
   	}

	//Add a products to the cart
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
	WebElement AddToCart;
	
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
	WebElement AddToCart2;
	
	@FindBy(xpath ="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
	WebElement AddToCart3;
	
	public void AddToCart()
	 {
		AddToCart.click();
		AddToCart2.click();
		AddToCart3.click();
   	}

	// Check Text on page
	@FindBy(xpath = "//*[text()='Your Cart']")
	WebElement textElement;

	public String textCapture()
	  {
		return textElement.getText();
	  }

	//Click on basket button and navigate to cart_page
	@FindBy(xpath = "//div[@id='shopping_cart_container']")
	WebElement basketButton;

	public Cart_Page basketButton() throws IOException {
		basketButton.click();
		return new Cart_Page();

	}
}

	
