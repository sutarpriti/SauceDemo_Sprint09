
package com.page;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utility.Utility;

public class LogIn_Page extends Utility{
	
	
	public LogIn_Page() {
		PageFactory.initElements(driver, this);
	}
    
	//UserName 
	@FindBy(xpath = "//*[@name='user-name']")
	private WebElement userName;

	public void loginUserName(String un) {
		userName.sendKeys(un);
	}

	//Password
	@FindBy(xpath = "//*[@name='password']")
	private WebElement passWord;

	public void loginPassword(String pw) {
		passWord.sendKeys(pw);
	}

	//LogIn Button
	@FindBy(xpath = "//*[@id='login-button']")
	private WebElement loginButton;

	public Product_Page loginButton() throws IOException {
		loginButton.click();
		return new Product_Page();

	}

}
	
	
	
	

