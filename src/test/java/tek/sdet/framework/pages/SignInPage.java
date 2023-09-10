package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class SignInPage extends BaseSetup{
	public SignInPage() {
		PageFactory.initElements(getDriver(), this);
	}
	@FindBy(id = "signinLink")
	public WebElement signInFeild;
	
	@FindBy(id = "email")
	public WebElement emailField;
	
	@FindBy(id = "password")
	public WebElement passwordField;
	
	@FindBy(id = "loginBtn")
	public WebElement logginBtfField;
	
	@FindBy(xpath = "//button[@id='logoutBtn']")
	public WebElement loggoutBtn;
	
	@FindBy(id = "newAccountBtn")
	public WebElement newAccountField; 
	
	@FindBy(xpath = "//input[@id='nameInput']")
	public WebElement nameInputField;
	
	@FindBy(xpath = "//input[@id='emailInput']")
	public WebElement emailInputField;
	
	@FindBy(xpath = "//input[@id='passwordInput']")
	public WebElement passwordInputField;
	
	@FindBy(xpath = "//input[@id='confirmPasswordInput']")
	public WebElement confPasswordInputField;
	
	@FindBy(xpath = "//button[@id='signupBtn']")
	public WebElement signUpInputField;
	
	

}
