package pageObjects.com;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy (css="#memberId") WebElement mobile;
	@FindBy (css="#mobilePass") WebElement password;
	@FindBy (css="button[type='submit'] span[class='buttonText']") WebElement login;
	public WebElement getUserId() {
		
		return mobile;
	}
	public WebElement getPassword() {
		
		return password;
	}
	public WebElement getLogin() {
		
		return login;
	}
}
