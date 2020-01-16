package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationpage;

public class UserRegistrationTestWITHDDTandDataProvider extends TestBase
{
	HomePage homeObject ;
	UserRegistrationpage registationObject;
	LoginPage loginObject;
	@DataProvider (name="testData")
	public static Object[][] userData()
	{
		return new Object[][]
				{
			{"Amr","Mohamed","Amrf8@e.com","amr123456"},
			{"Ahmed","Ali","tfes8t@www.com","amr45678"}
				};
	}
	@Test (priority =1,dataProvider = "testData")
	public void UserCanRegisterSucessfully(String fname, String lname, String email, String password)
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registationObject = new UserRegistrationpage(driver);
		registationObject.userRegistration(fname,lname,email,password);
		Assert.assertTrue(registationObject.sucessMessage.getText().contains("Your registration completed"));
		registationObject.userLogOut();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, password);
		Assert.assertTrue(registationObject.logoutLink.getText().equals("Log out"));
		registationObject.userLogOut();

	}
}
