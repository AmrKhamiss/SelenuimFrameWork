package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationpage;

public class UserRegistrationTestWithJavaFaker extends TestBase
{
	HomePage homeObject ;
	UserRegistrationpage registationObject;
	LoginPage loginObject;
	Faker fakeData = new Faker();
	String firstname = fakeData.name().firstName();
	String lastname = fakeData.name().lastName();
	String email = fakeData.internet().emailAddress();
	String password = fakeData.number().digits(8).toString();
	@Test (priority =1)
	public void UserCanRegisterSucessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registationObject = new UserRegistrationpage(driver);
		registationObject.userRegistration(firstname,lastname,email,password);
		Assert.assertTrue(registationObject.sucessMessage.getText().contains("Your registration completed"));
	}
	@Test (dependsOnMethods= {"UserCanRegisterSucessfully"})
	public void RegistedUserCanLogOut()
	{
		registationObject.userLogOut();
	}
	@Test (dependsOnMethods= {"RegistedUserCanLogOut"})
	public void RegistedUserCanLogIn()
	{		
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email,password);
		Assert.assertTrue(registationObject.logoutLink.getText().equals("Log out"));
	}
}
