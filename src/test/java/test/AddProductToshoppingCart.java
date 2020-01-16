package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCardPage;

public class AddProductToshoppingCart extends TestBase 
{
	SearchPage searchPage;
	ProductDetailsPage productDetails;
	ShoppingCardPage cartPage ; 
	String productName = "Apple MacBook Pro 13-inch";

	@Test(priority=1)
	public void UserCanSearchForProductsWithAutoSuggest() throws InterruptedException {
		searchPage = new SearchPage(driver);
		searchPage.ProductSearchAuto("MacB");
		productDetails = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetails.productNamebreadCrumb.getText().contains(productName));
	}

	@Test(priority=2)
	public void UserCanAddProductToShoppingCart() throws InterruptedException {
		productDetails = new ProductDetailsPage(driver);
		productDetails.AddToCart();
		Thread.sleep(1000);
		driver.navigate().to("http://demo.nopcommerce.com" + "/cart");	
		cartPage = new ShoppingCardPage(driver);
		Assert.assertTrue(cartPage.totalLbl.getText().contains("3,600"));
	}

	@Test(priority=3)
	public void UserCanRemoveProductFromCart() {
		cartPage = new ShoppingCardPage(driver); 
		cartPage.RemoveProductFromCart();
	}
}
