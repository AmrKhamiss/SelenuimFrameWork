package steps;

import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegistrationpage;
import test.TestBase;


public class UserRegistration extends TestBase{
	HomePage homeObject;
	UserRegistrationpage registerObject;
	@Given("the user in the home page")
	public void the_user_in_the_home_page() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();

	}

	@When("I click on register link")
	public void i_click_on_register_link() {
		assertTrue(driver.getCurrentUrl().contains("register"));
	}

	/*
	 * @When("I entered the user data") public void i_entered_the_user_data() {
	 * registerObject = new UserRegistrationpage(driver);
	 * registerObject.userRegistration("amr", "amr", "y@w.com", "134679825"); }
	 */

	@Then("the registration page displayed successfully")
	public void the_registration_page_displayed_successfully() {
		registerObject.userLogOut();
	}
	@When("I entered {string} , {string} , {string} , {string}")
	public void i_entered(String firstname, String lastname, String email, String password) {
		 registerObject = new UserRegistrationpage(driver);
		  registerObject.userRegistration(firstname,lastname,email,password);
	}
}
