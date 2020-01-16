package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationpage extends PageBase 
{
	public UserRegistrationpage(WebDriver driver) 
	{
		super(driver);

	}
	@FindBy(id = "gender-male")
	WebElement genderRadioBtn;

	@FindBy (id = "FirstName")
	WebElement fnTxtBox;

	@FindBy (id = "LastName")
	WebElement lnTxtBox;

	@FindBy (id = "Email")
	WebElement emailTxtBox;

	@FindBy (id = "Password")
	WebElement passwordTxtBox;

	@FindBy (id = "ConfirmPassword")
	WebElement confirmPasswordTxtBox;

	@FindBy (id= "register-button")
	WebElement registerBtn;
	
	@FindBy (css = "div.result")
	public WebElement sucessMessage;
	
	@FindBy(linkText="Log out")
	public WebElement logoutLink;
	@FindBy (linkText = "My account")
	WebElement myAccountLink;

	public void userRegistration(String firstName, String lastName ,String  email, String password) 
	{
		clickButton(genderRadioBtn);
		setTextElementText(fnTxtBox, firstName);
		setTextElementText(lnTxtBox, lastName);
		setTextElementText(emailTxtBox, email);
		setTextElementText(passwordTxtBox, password);
		setTextElementText(confirmPasswordTxtBox, password);
		clickButton(registerBtn);
	}
	public void userLogOut() 
	{
		clickButton(logoutLink);
	}
	public void openMyaccountPage() {
		clickButton(myAccountLink);
	}

}
