package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase 
{
  HomePage homeObject;
  ProductDetailsPage detailsObject;
  String productName = "Apple MacBook Pro 13-inch";

	SearchPage searchObject;
  @Test (priority=1) 
  public void UserCanChangeCurrency()
  {
	  homeObject = new HomePage(driver);
	  homeObject.changeCurrency();
  }
  
  @Test (priority=2)
  public void UserCanSearchWithAuto()
	{
		
			searchObject = new SearchPage(driver);
			searchObject.ProductSearchAuto("Mac");
			detailsObject = new ProductDetailsPage(driver);
			Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
			Assert.assertTrue(detailsObject.productPriceLabel.getText().contains("Ђ"));
	}
}
