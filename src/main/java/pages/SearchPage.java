package pages;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (id = "small-searchterms")
	WebElement searchTextBox;
	@FindBy (css = "input.button-1.search-box-button")
	WebElement searchBtn;
	@FindBy (id = "ui-id-1")
	List<WebElement> productList;
	@FindBy(linkText="Apple MacBook Pro 13-inch")
	WebElement productTitle; 
	public void ProductSearch(String productName) 
	{
		setTextElementText(searchTextBox, productName);
		clickButton(searchBtn);
	}
	public void OpenProductDetailsPage() 
	{
		clickButton(productTitle);
		
	}
	public void ProductSearchAuto(String searchTxt)
	{
		setTextElementText(searchTextBox, searchTxt);
		try {
Thread.sleep(1000);		
}
		catch (InterruptedException e) {
				e.printStackTrace();
			}
		productList.get(0).click();
	}

}