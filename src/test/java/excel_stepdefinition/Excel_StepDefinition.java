package excel_stepdefinition;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import com.aventstack.extentreports.Status;
import com.page.Cart_Page;
import com.page.CheckOut_Page;
import com.page.LogIn_Page;
import com.page.Product_Page;
import com.utility.Config;
import com.utility.ExcelReader;
import com.utility.Utility;
import java.util.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Excel_StepDefinition extends Utility{
	
	public LogIn_Page lp;
	public Product_Page pp;
	public Cart_Page cp;
	public CheckOut_Page cpp;
	ExcelReader reader;
	
	public void objectMethod() throws IOException {

		lp = new LogIn_Page();
		pp = new Product_Page();
		cp = new Cart_Page();
		cpp = new CheckOut_Page();
	}
	
	//Launching chrome browser and saucedemo application
	@Given("Chrome is opened and SauceDemo app is opened")
	public void chrome_is_opened_and_sauce_demo_app_is_opened() throws IOException {
		objectMethod();
		// Thread.sleep(1000);
		Utility.implicitWait();

		logger = report.createTest("test01");
		logger.log(Status.INFO, "Validating landing page title");

		// To check the title of page
		String actualtitle = lp.validatePageTitle();
		String expectedtitle = "Swag Labs";
		
		try {
			assertEquals(expectedtitle, actualtitle);
			logger.log(Status.PASS, "Step1 is passed");
			System.out.println(actualtitle);
			assert true;
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(Status.FAIL, "Step1 is failed");
			captureScreenshotOnFailure();
			assert false;
		}
        
		//Thread.sleep(2000);
         Utility.implicitWait();
	}
	@When("User enters correct Username {string} and Password {string}")
	public void user_enters_correct_username_and_password(String string, String string2) throws IOException, InterruptedException {
	   
		objectMethod();
		lp.loginUserName(string);
		
		lp.loginPassword(string2);
		//Thread.sleep(2000);
		
		Utility.implicitWait();
		logger.log(Status.INFO, "User can login successfully");
	}
	
	
	@When("Click on login button")
	public void click_on_login_button() throws IOException {
	   
		lp.loginButton();
		// Thread.sleep(1000);
		Utility.implicitWait();

		logger.log(Status.INFO, "Step is executed");
	}
	
	
	@Then("It shows product page")
	public void it_shows_product_page() throws IOException {
	   
		objectMethod();
		//Thread.sleep(1000);
		 Utility.implicitWait();
		
		 //Title
		String actualtitle = lp.validatePageTitle();
		String expectedtitle = "Swag Labs";

		try {
			assertEquals(expectedtitle, actualtitle);
			logger.log(Status.PASS, "Step is passed");
			System.out.println(actualtitle);
			assert true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(Status.FAIL, "Step is failed");
			captureScreenshotOnFailure();
			assert false;
		}
		 
		 Utility.implicitWait();
	}
	
	
	@When("User click on add to cart button")
	public void user_click_on_add_to_cart_button() throws IOException {
		objectMethod();
		logger = report.createTest("test02");
		//Thread.sleep(2000);
		 Utility.implicitWait();

		pp.AddToCart();
		//Thread.sleep(1000);
		 Utility.implicitWait();

		 logger.log(Status.INFO, "Step is executed");
	}
	
	
	@Then("Product is added to cart page")
	public void product_is_added_to_cart_page() throws IOException, InterruptedException {
	  
		objectMethod();
		Thread.sleep(1000);
		String actualtitle = pp.validatePageTitle();
		String expectedtitle = "Swag Labs";
		try {
			assertEquals(expectedtitle, actualtitle);
			logger.log(Status.PASS, "Step is passed");
			System.out.println(actualtitle);
			assert true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(Status.FAIL, "Step is failed");
			captureScreenshotOnFailure();
			assert false;
		}
	}
	
	//Basket button
	@When("User click on Basket button")
	public void user_click_on_basket_button() throws IOException {
		objectMethod();
		pp.basketButton();
		//Thread.sleep(2000);
        Utility.implicitWait();
        logger = report.createTest("test03");
        logger.log(Status.INFO, "Validating user can click on basket button and navigate to cart page");
        
	}
	
	@Then("User Navigate to cart page")
	public void user_navigate_to_cart_page() throws IOException, InterruptedException {
		String actualText = pp.textCapture();
		String expectedText = "Your Cart";
		try {
			assertEquals(expectedText, actualText);
			logger.log(Status.PASS, "Step is passed");
			System.out.println(actualText);
			assert true;
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(Status.FAIL, "Step is failed");
			
			captureScreenshotOnFailure();
			assert false;
		}
		//Thread.sleep(1000);
		Utility.implicitWait();
	}
	
	
	@Then("check name of product from given sheetname {string} and {int}")
	public void check_name_of_product_from_given_sheetname_and(String sheetName, Integer rowNumber) throws IOException, InterruptedException, InvalidFormatException {
	    objectMethod();
	    reader=new ExcelReader();
		Thread.sleep(1000);
	   
        // give the data from excel sheet
		List<Map<String,String>> testData = reader.getData(Config.excelPath, sheetName);
        String Product_Name1 = testData.get(rowNumber).get("Product_Name");
       // System.out.println(Product_Name1);
        cp.isProductNameVisible(Product_Name1);
        //assertTrue(product1visibility);
       // Thread.sleep(1000);
	   Utility.implicitWait();
	}

}
