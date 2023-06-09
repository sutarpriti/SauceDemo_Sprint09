package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Utility;

public class CheckOut_Page extends Utility{
	
	 public CheckOut_Page() {
			PageFactory.initElements(driver, this);
		}
		
//Checking text on page
	@FindBy(xpath = "//*[text()='Checkout: Your Information']")
	WebElement textElement;

	public String textCapture()
	  {
		return textElement.getText();
	  }
	
	
}
