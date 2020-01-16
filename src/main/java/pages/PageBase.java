package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase 
{
	protected  WebDriver driver;
	protected WebDriverWait wait; 
	public JavascriptExecutor jse;
	public Select select;
	public Actions action;

	// create constructor
	public PageBase(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);

	}
	protected static void clickButton (WebElement button)
	{
		button.click();
	}
	protected static void setTextElementText (WebElement textElement, String value)
	{
		textElement.sendKeys(value);
	}

	public void scrollToButton(String valueOfScrollDown)
	{
		jse.executeScript(valueOfScrollDown);	
	}
	public void clearText(WebElement element)
	{
		element.clear();
	}
	protected  void waitForVisibility(WebElement element) throws Error, InterruptedException{
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(element));
		Thread.sleep(60);
	}
}
