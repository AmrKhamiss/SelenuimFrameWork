package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationpage;

public class UserRegistrationTestWithDDTAndExcel extends TestBase
{
	HomePage homeObject ;
	UserRegistrationpage registationObject;
	LoginPage loginObject;
	@DataProvider (name ="ExcelData")
	public Object[][] userRegisterData() throws IOException
	{
		ExcelReader ER = new ExcelReader();
			return ER.getExcelData();
	}
	@Test (priority =1,dataProvider = "ExcelData")
	public void UserCanRegisterSucessfully( String firstname, String lastname, String email, String password)
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registationObject = new UserRegistrationpage(driver);
		registationObject.userRegistration(firstname,lastname,email,password);
		Assert.assertTrue(registationObject.sucessMessage.getText().contains("Your registration completed"));
		registationObject.userLogOut();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email,password);
		Assert.assertTrue(registationObject.logoutLink.getText().equals("Log out"));
		registationObject.userLogOut();


	}
}
