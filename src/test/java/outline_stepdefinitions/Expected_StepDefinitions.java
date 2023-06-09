package outline_stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import com.aventstack.extentreports.Status;
import com.page.Cart_Page;
import com.page.CheckOut_Page;
import com.page.LogIn_Page;
import com.page.Product_Page;
import com.utility.Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Expected_StepDefinitions extends Utility{
	
	    
		public LogIn_Page lp;
		public Product_Page pp;
		public Cart_Page cp;
		public CheckOut_Page cpp;
		
		public void objectMethod() throws IOException {

			lp = new LogIn_Page();
			pp = new Product_Page();
			cp = new Cart_Page();
			cpp = new CheckOut_Page();
		}

		@Given("Chrome is opened and SauceDemo app is opened")
		public void chrome_is_opened_and_sauce_demo_app_is_opened() throws IOException {
	    
		objectMethod();
		// Thread.sleep(1000);
		Utility.implicitWait();

		logger = report.createTest("test01");
		logger.log(Status.INFO, "Validating landing page title");

		// Title
		String actualtitle = lp.validatePageTitle();
		String expectedtitle = "Swag Labs";
		try {
			assertEquals(expectedtitle, actualtitle);
			logger.log(Status.PASS, "Step1 is passed");
			System.out.println(actualtitle);
			assert true;
		} catch (Exception e) {
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
			// Thread.sleep(2000);
			Utility.implicitWait();
			lp.loginPassword(string2);
			Thread.sleep(2000);
			// Utility.implicitWait();
			logger.log(Status.INFO, "User can login successfully");
		
	}
		@When("Click on login button")
		public void click_on_login_button() throws IOException {
		lp.loginButton();
		// Thread.sleep(2000);
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
		//Thread.sleep(4000);
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
			Thread.sleep(4000);
			assertEquals(expectedText, actualText);
			logger.log(Status.PASS, "Step is passed");
			System.out.println(actualText);
			assert true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(Status.FAIL, "Step is failed");
			captureScreenshotOnFailure();
			assert false;
		}
		Thread.sleep(1000);
	}
		@Then("check name of product {string}")
		public void check_name_of_product(String string) throws IOException, InterruptedException {
	    objectMethod();
	  
	    //Product_Name()
	    cp.isProductNameVisible(string);
	    //assertTrue(product1visibility);
	   //	System.out.println(product1visibility);
		
	   //Product_Name2()
	    Thread.sleep(1000);
	   	
	    boolean product1visibility2=cp.Product_Name2();
	    assertTrue(product1visibility2);
	   	System.out.println(product1visibility2);
		
	   	logger.log(Status.FAIL, "Step is failed");
		Thread.sleep(1000);
		
	}

	
}
