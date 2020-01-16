package test;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationpage;

public class MyAccountTest extends TestBase
{
	HomePage homeObject ;
	UserRegistrationpage registationObject;
	LoginPage loginObject;
	MyAccountPage myAccountObject;
	String oldPassword = "amr1992";
	String newPassword = "amr2011";
	String firstName ="Amr";
	String lastName = "khamis";
	String email = "amrrdy195s55593@yahoo.com";
	@Test (priority =1)
	public void UserCanRegisterSucessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registationObject = new UserRegistrationpage(driver);
		registationObject.userRegistration(firstName,lastName,email,oldPassword);
		Assert.assertTrue(registationObject.sucessMessage.getText().contains("Your registration completed"));
	}
	@Test (priority = 2)
	public void RegisteredUserChangePassword()
	{
		myAccountObject = new MyAccountPage(driver);
		registationObject.openMyaccountPage();
		myAccountObject.openChangePasswordPage();
		myAccountObject.ChangePassword(oldPassword, newPassword);
		assertTrue(myAccountObject.resultLbl.getText().contains("Password was changed"));

	}
	@Test (priority =3)
	public void RegistedUserCanLogOut()
	{
		registationObject.userLogOut();
	}
	@Test (priority = 4)
	public void RegistedUserCanLogIn()
	{		
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, newPassword);
		Assert.assertTrue(registationObject.logoutLink.getText().equals("Log out"));
	}
}
