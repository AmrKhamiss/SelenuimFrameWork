package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegistrationpage;

public class AddProductReviewTest extends TestBase 
{
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	HomePage homeObject ;
	UserRegistrationpage registationObject;
	LoginPage loginObject;
	EmailPage emailObject;
	ProductReviewPage reviewObject;
	// 1- user registration
	@Test (priority =1)
	public void UserCanRegisterSucessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registationObject = new UserRegistrationpage(driver);
		registationObject.userRegistration("Amr", "khamis", "t19614rirdfyprg98h8892@yahoo.com", "amr1992");
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
	// 3- Add review
	@Test (priority=3)
	public void RegistrationUserCanAddReview() 
	{
		detailsObject.openAddReviewLink();
		reviewObject = new ProductReviewPage(driver);
		reviewObject.AddProductReview("Amr", "khamis");
		Assert.assertTrue(reviewObject.reviewNotification.getText().contains("Product review is successfully added."));
	}



	// 4- user log out
	@Test (priority =4)
	public void RegistedUserCanLogOut()
	{
		registationObject.userLogOut();
	}
}
