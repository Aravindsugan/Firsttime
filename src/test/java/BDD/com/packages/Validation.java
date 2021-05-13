package BDD.com.packages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.com.HomePage;
import pageObjects.com.LoginPage;
import resources.base;

public class Validation {
	public static Logger log = LogManager.getLogger(Validation.class.getName());

	WebDriver driver;

	base b = new base();
	
	@BeforeTest
public void initialize() throws IOException {
	driver =b.initializeDriver();
	log.info("Driver initialized");
}
	@Test(dataProvider="getCredentials")
	public void validateLogin(String user, String pass) throws InterruptedException  {
	
		driver.get(b.prop.getProperty("url"));
		log.info("Navigated to"+(b.prop.getProperty("url")).toString());
		String title = driver.getTitle();
		log.info("actual" +title);
		Assert.assertEquals(title, "Book Domestic & International Flights at Lowest Airfare - IndiGo");
		log.info("expected Book Domestic & International Flights at Lowest Airfare - IndiGo");
		
		HomePage h = new HomePage(driver);
		h.getSignin().click();
		log.info("signin successfull");
		LoginPage l = new LoginPage(driver);
		Thread.sleep(2000);
		l.getUserId().sendKeys(user);
		l.getPassword().sendKeys(pass);
		l.getLogin().click();
		log.info("Login clicked");
		String p = h.getProfile().getText();
		Assert.assertTrue(p.equalsIgnoreCase("A"));
		log.info("Validation successfull");
		
	}
	@AfterTest
	public void tearDown() {
		driver.close();
		
		
	}

@DataProvider
public Object[][] getCredentials() {
	
	Object[][]data= new Object[1][2];
	//data[0][0]="Test";
	//data[0][1]="Pass";
	
	data[0][0]="7373252303";
	data[0][1]="Suagn@3006";
	return data;
}

}

