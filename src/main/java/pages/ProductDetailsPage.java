package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
	}
	@FindBy (css = "strong.current-item")
	public WebElement productNamebreadCrumb;
	@FindBy (css = "input.button-2.email-a-friend-button")
	WebElement emailFriendBtn;
	@FindBy (css = "span.price-value-4")
	public WebElement productPriceLabel;
	@FindBy (linkText="Add your review")
	WebElement addReviewLink;
	@FindBy (id="add-to-wishlist-button-4")
	WebElement addToWishBtn;
	@FindBy (css = "input.button-2.add-to-compare-list-button")
	WebElement addToCompareBtn;
	@FindBy (css = "input.button-1.add-to-cart-button")
	WebElement addToCartBtn;
	public void openSendEmail()
	{
		clickButton(emailFriendBtn);
	}
	public void scrollDownInDetailsPage()
	{
		scrollToButton("scrollTo(0,500)");
	}
	public void openAddReviewLink()
	{
		clickButton(addReviewLink);
	}
	public void AddProductToWishList ()
	{
		clickButton(addToWishBtn);
	}
	public void AddProductToComapre() {
		scrollToButton("scrollTo(0,800)");
		clickButton(addToCompareBtn);
	}
	public void AddToCart ()
	{
		scrollToButton("scrollTo(0,800)");
		clickButton(addToCartBtn);
	}
}
