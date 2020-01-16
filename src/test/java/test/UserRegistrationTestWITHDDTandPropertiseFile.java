package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadPropertise;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationpage;

public class UserRegistrationTestWITHDDTandPropertiseFile extends TestBase
{
	HomePage homeObject ;
	UserRegistrationpage registationObject;
	LoginPage loginObject;
	String firstname = LoadPropertise.userData.getProperty("firstname");
	String lastname = LoadPropertise.userData.getProperty("lastname");
	String email = LoadPropertise.userData.getProperty("email");
	String password = LoadPropertise.userData.getProperty("password");
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
