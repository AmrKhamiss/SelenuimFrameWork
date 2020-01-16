package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAuto extends TestBase
{
	String productName = "Apple MacBook Pro 13-inch";

	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	@Test
	public void UserCanSearchWithAuto()
	{
		
			searchObject = new SearchPage(driver);
			searchObject.ProductSearchAuto("Mac");
			detailsObject = new ProductDetailsPage(driver);
			Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
	}
}
