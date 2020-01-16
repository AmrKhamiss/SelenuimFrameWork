package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationpage;

public class EmailFriendTest extends TestBase 
{
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	HomePage homeObject ;
	UserRegistrationpage registationObject;
	LoginPage loginObject;
	EmailPage emailObject;
	// 1- user registration
	@Test (priority =1)
	public void UserCanRegisterSucessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registationObject = new UserRegistrationpage(driver);
		registationObject.userRegistration("Amr", "khamis", "t114g986s8rirdyh89p2@yahoo.com", "amr1992");
		Assert.assertTrue(registationObject.sucessMessage.getText().contains("Your registration completed"));
	}
	
	
	//2- search
	@Test (priority=2)
	public void UserCanSearchWithAuto()
	{
		
			searchObject = new SearchPage(driver);
			searchObject.ProductSearchAuto("Mac");
			detailsObject = new ProductDetailsPage(driver);
			Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
	}
	// 3- Email to send friend
	@Test (priority=3)
	public void RegistrationUserCanSendProductToFreind() 
	{
		detailsObject.openSendEmail();
		emailObject = new EmailPage(driver);
		emailObject.SendEmailToFriend("aaa@yahoo.com", "amr");
		Assert.assertTrue(emailObject.messageNotification.getText().contains("Your message has been sent."));
	}
	
	
	
	// 4- user log out
	@Test (priority =4)
	public void RegistedUserCanLogOut()
	{
		registationObject.userLogOut();
	}
}
