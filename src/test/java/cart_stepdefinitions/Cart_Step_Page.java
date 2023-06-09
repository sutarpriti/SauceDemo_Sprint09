package cart_stepdefinitions;

import static org.testng.Assert.assertEquals;
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

public class Cart_Step_Page extends Utility {

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
	

	// Launching chrome browser and open application
	@Given("Chrome is opened and SauceDemo app is opened")
	public void chrome_is_opened_and_sauce_demo_app_is_opened() throws IOException, InterruptedException {
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

		// Thread.sleep(2000);
		Utility.implicitWait();
	}
	

	// User can login with username and password
	@When("User enters correct Username {string} and Password {string}")
	public void user_enters_correct_username_and_password(String string, String string2)
			throws InterruptedException, IOException {
		objectMethod();
		lp.loginUserName(string);
		// Thread.sleep(2000);
		Utility.implicitWait();
		lp.loginPassword(string2);
		// Thread.sleep(2000);
		Utility.implicitWait();
		logger.log(Status.INFO, "User can login successfully");

	}

	
	// Login button
	@When("Click on login button")
	public void click_on_login_button() throws IOException, InterruptedException {
		lp.loginButton();
		// Thread.sleep(2000);
		Utility.implicitWait();

		logger.log(Status.INFO, "Step is executed");
	}
	

	@Then("It shows product page")
	public void it_shows_product_page() throws InterruptedException, IOException {
		objectMethod();
		// Thread.sleep(1000);
		Utility.implicitWait();
		// Title
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
	

	// Cart Button will add product to cart
	@When("User click on add to cart button")
	public void user_click_on_add_to_cart_button() throws IOException, InterruptedException {
		objectMethod();
		logger = report.createTest("test02");
		// Thread.sleep(1000);
		Utility.implicitWait();

		pp.AddToCart();
		// Thread.sleep(1000);
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

	
	// After click on basket button user navigate to cart page
	@When("User click on Basket button")
	public void user_click_on_basket_button1() throws IOException, InterruptedException {
		objectMethod();
		pp.basketButton();
		// Thread.sleep(2000);
		Utility.implicitWait();
		logger = report.createTest("test03");
		logger.log(Status.INFO, "Validating user can click on basket button and navigate to cart page");

	}

	
	@Then("User Navigate to cart page")
	public void user_navigate_to_cart_page1() throws IOException, InterruptedException {
		// Text

		String actualText = pp.textCapture();
		String expectedText = "Your Cart";
		try {
			Thread.sleep(1000);
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
		//Thread.sleep(1000);
        Utility.implicitWait();
	}
	
	

	// UI
	@Then("Cart page buttons are visible to user")
	public void cart_page_buttons_are_visible_to_user() throws IOException {
		logger = report.createTest("test04");
		cp.Continue_Shopping();
		cp.Remove();
		// cp.CheckOut();
		// System.out.println("Buttons are visible");
		logger.log(Status.INFO, "Buttons are visible");
	}

	// Continue shopping button
	@When("User click on continue shopping button")
	public void user_click_on_continue_shopping_button() throws IOException, InterruptedException {
		objectMethod();
		logger = report.createTest("test05");
		cp.Continue_Shopping();
		Thread.sleep(1000);
		// Utility.implicitWait();
	}

	
	@Then("User navigate to the product page")
	public void user_navigate_to_the_product_page() throws IOException, InterruptedException {

		objectMethod();
		Thread.sleep(1000);
		// Utility.implicitWait();
		String actualtitle = cp.validatePageTitle();
		String expectedtitle = "Swag Labs";
		try {
			assertEquals(expectedtitle, actualtitle);
			logger.log(Status.PASS, "Step is passed");
			System.out.println(actualtitle);
			assert true;
		} 
		catch (Exception e) {

			e.printStackTrace();
			logger.log(Status.FAIL, "Step is failed");
			captureScreenshotOnFailure();
			assert false;
		}
		System.out.println("User can see the product list");
	}

	
	// CheckOut button
	@When("User click on CheckOut button")
	public void user_click_on_check_out_button() throws IOException, InterruptedException {
		objectMethod();
		cp.CheckOut();
		Thread.sleep(1000);
		// Utility.implicitWait();
		logger = report.createTest("test06");
		captureScreenshotOnFailure();
		logger.log(Status.INFO, "Step  is executed");
	}

	@Then("User navigate to the Checkout information page")
	public void user_navigate_to_the_checkout_information_page() throws IOException, InterruptedException {

		objectMethod();
		// Thread.sleep(1000);
		
		//Text on a checkout page
		String actualText = cpp.textCapture();
		String expectedText = "Checkout: Your Information";
		
		assertEquals(expectedText, actualText);
		System.out.println(actualText);
		
		//Thread.sleep(1000);
		 Utility.implicitWait();
		logger.log(Status.INFO, "Step is executed");

		System.out.println("User can check the payment information and prize details");

	}
	

	// Remove button
	@When("User click on remove button")
	public void user_click_on_remove_button() throws IOException, InterruptedException {

		objectMethod();
		cp.Remove();
		logger = report.createTest("test07");
		//Thread.sleep(1000);
		Utility.implicitWait();
	}

	@Then("User delete product from cart page")
	public void user_delete_product_from_cart_page() throws IOException, InterruptedException {

		objectMethod();
		// Thread.sleep(1000);
		Utility.implicitWait();
		
		//Check the title of page
		String actualtitle = cp.validatePageTitle();
		String expectedtitle = "Swag Labs";
		
		assertEquals(expectedtitle, actualtitle);
		System.out.println(actualtitle);
		
		// Thread.sleep(500);
		Utility.implicitWait();
		
		captureScreenshotOnFailure();
		logger.log(Status.INFO, "User deleted product from cart list");
		
	}

	// Product Details
	@When("User click on product")
	public void user_click_on_product() throws IOException, InterruptedException {
		objectMethod();
		cp.product_item();
		// Thread.sleep(1000);
		Utility.implicitWait();
		logger = report.createTest("test08");
	}

	@Then("User navigate to product_details page")
	public void user_navigate_to_product_details_page() throws IOException, InterruptedException {
		objectMethod();
		// Thread.sleep(1000);
		// Utility.implicitWait();
		
		String actualtitle = pp.validatePageTitle();
		String expectedtitle = "Swag Labs";
		
		assertEquals(expectedtitle, actualtitle);
		System.out.println(actualtitle);
		
		//Thread.sleep(1000);
		 Utility.implicitWait();
		logger.log(Status.INFO, "Step is executed");
	
		captureScreenshotOnFailure();
		System.out.println("User can see the details of product before confirmation");

	}

}
