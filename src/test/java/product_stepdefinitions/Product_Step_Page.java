package product_stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.Status;
import com.page.Cart_Page;
import com.page.LogIn_Page;
import com.page.Product_Page;
import com.utility.Utility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class Product_Step_Page {
	public LogIn_Page lp;
	public Product_Page pp;
	public Cart_Page cp;
	
	
	public void objectMethod() throws IOException {

		lp = new LogIn_Page();
		pp = new Product_Page();
		cp = new Cart_Page();
	}
	
	@Given("Chrome is opened and SauceDemo app is opened")
	public void chrome_is_opened_and_sauce_demo_app_is_opened() throws InterruptedException, IOException {
		objectMethod();
		//Thread.sleep(2000);
		String actualtitle = lp.validatePageTitle();
		String expectedtitle = "Swag Labs";
		assertEquals(expectedtitle, actualtitle);
		System.out.println(actualtitle);
		//Thread.sleep(2000);
		Utility.implicitWait();
		//logger.log(Status.PASS,"step is passed");
	}
	
	@When("User enters correct Username and Password")
	public void user_enters_correct_username_and_password() throws IOException, InterruptedException {

		objectMethod();
		lp.loginUserName("standard_user");
		//Thread.sleep(2000);
		Utility.implicitWait();
		lp.loginPassword("secret_sauce");
		//Thread.sleep(2000);
        Utility.implicitWait();
	}

	@When("Click on login button")
	public void click_on_login_button() throws IOException, InterruptedException {

		lp.loginButton();
		//Thread.sleep(2000);
		Utility.implicitWait();
		  
	}

	@Then("It shows product page")
	public void it_shows_product_page() throws IOException, InterruptedException {
		
		objectMethod();
		//Thread.sleep(1000);
		Utility.implicitWait();
		String actualtitle = lp.validatePageTitle();
		String expectedtitle = "Swag Labs";
		assertEquals(expectedtitle, actualtitle);
		System.out.println(actualtitle);
		//Thread.sleep(2000);
		Utility.implicitWait();
		System.out.println("SauceDemo is opened successfully");
	}

	@When("User click on add to cart button")
	public void user_click_on_add_to_cart_button() throws InterruptedException, IOException {
		objectMethod();
		//Thread.sleep(2000);
		pp.AddToCart();
		//Thread.sleep(4000);
		Utility.implicitWait();
	}

	@Then("Product is added to cart page")
	public void product_is_added_to_cart_page() {
      System.out.println("Product is added to cart");
	}

	@When("User click on Basket button")
	public void user_click_on_basket_button() throws IOException, InterruptedException {
		objectMethod();
		pp.basketButton();
		Thread.sleep(2000);
		//Utility.implicitWait();
		
			}

	@Then("User Navigate to cart page")
	public void user_navigate_to_cart_page() {
		String actualText = pp.textCapture();
		String expectedText = "Your Cart";
		assertEquals(expectedText, actualText);
		System.out.println("Actual Text is " + actualText);
	}

}







