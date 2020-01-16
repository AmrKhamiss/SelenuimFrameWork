package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationpage;

public class UserRegistrationTest extends TestBase
{
	HomePage homeObject ;
	UserRegistrationpage registationObject;
	LoginPage loginObject;
	@Test (priority =1)
	public void UserCanRegisterSucessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registationObject = new UserRegistrationpage(driver);
		registationObject.userRegistration("Amr", "khamis", "t1p1rirdysh2@yahoo.com", "amr1992");
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
		loginObject.UserLogin("t112@yahoo.com", "amr1992");
		Assert.assertTrue(registationObject.logoutLink.getText().equals("Log out"));
	}
}
