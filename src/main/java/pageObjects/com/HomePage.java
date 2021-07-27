package pageObjects.com;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy (xpath="//a[@class='login-header-modal-links anonymous-cls check-cls'][text()='Login']") WebElement login;
	@FindBy (css="a[data-login-type='loginModal']") WebElement signin;
	@FindBy (xpath="//*[@id=\"sme-profile-login-container\"]/a/span/span/span") WebElement profile;
	public WebElement getLogin() {
		int k;/
		return login;
	}
	public WebElement getSignin() {
		
		return signin;
	}
public WebElement getProfile() {
		
		return profile;
	}
}
