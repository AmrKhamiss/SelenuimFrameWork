package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationpage;

public class UserRegistrationTestWithDDTAndCSV extends TestBase
{
	HomePage homeObject ;
	UserRegistrationpage registationObject;
	LoginPage loginObject;
	CSVReader reader;
	@Test (priority =1)
	public void UserCanRegisterSucessfully() throws CsvValidationException, IOException
	{
		String CSV_File = System.getProperty("user.dir")+ "\\src\\test\\java\\data\\UserData.csv";
		reader = new CSVReader(new FileReader(CSV_File));
		String [] csvCell;
		while ((csvCell = reader.readNext()) != null)
		{
			String firstname = csvCell[0];
			String lastname = csvCell[1];
			String email = csvCell[2];
			String password = csvCell[3];
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
}
