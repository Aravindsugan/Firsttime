
package BDD.com.packages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.*;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

/**
 * Unit test for simple App.
 */
public class HomeTest {
	public static Logger log = LogManager.getLogger(HomeTest.class.getName());
	WebDriver driver;

	base b = new base();

	@BeforeTest
	public void initialize() throws IOException {
		driver = b.initializeDriver();
		log.info("Driver initialized");

	}
@Test
	public void validateTitle() {

		driver.get(b.prop.getProperty("url"));
		log.info("Navigated to"+(b.prop.getProperty("url")).toString());
		String title = driver.getTitle();
		log.info("Title is "+title);
		Assert.assertEquals(title, "Book Domestic & International Flights at Lowest Airfare - IndiGo");
		log.info("Assertion is completed");
	}
@AfterTest
public void teardown() throws IOException {
	driver.close();

}
}
