package academy;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePageElements;
import resources.Base;

public class ValidateNavigationBarTest extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		String url = prop.getProperty("url");
		driver.get(url);
		log.info("Navigated to HomePage");
	}

	@Test
	public void basePageNavigation() throws IOException {

		HomePageElements hp = new HomePageElements(driver);
		assertTrue(hp.getNavigationBar().isDisplayed());
		log.info("Navigation Bar is displayed");
	}

	@AfterTest
	public void teardown() {
		driver.close();
		log.info("Teardown driver");
	}

}
