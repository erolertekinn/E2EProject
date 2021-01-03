package academy;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import pageObjects.ForgotPasswordElements;
import pageObjects.HomePageElements;
import pageObjects.LoginPageElements;
import resources.Base;

public class HomePageTest extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String email, String password, String text) throws IOException {
		String url = prop.getProperty("url");
		driver.get(url);
		HomePageElements hp = new HomePageElements(driver);
		LoginPageElements lp = hp.getLogin();

		
		// lp.getEmail().sendKeys("erolertekin.66@gmail.com");
		// lp.getPassword().sendKeys("123456");
		// lp.getLoginSubmit().click();

		// ---providing data using DataProvider
		lp.getEmail().sendKeys(email);
		lp.getPassword().sendKeys(password);
		System.out.println(text);
		log.info(text);

		lp.getLoginSubmit().click();
		
		ForgotPasswordElements fp= lp.forgotPassword();
		fp.getEmail().sendKeys("XXX");
		fp.getInstructionsButton().click();

	}

	@DataProvider
	public Object[][] getData() {
		// 0,1
		Object[][] data = new Object[2][3];
		// 0th row
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "123456";
		data[0][2] = "Restrcited User";
		// 1st row
		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "456788";
		data[1][2] = "Non restricted user";
		return data;
	}

	@AfterTest
	public void teardown() {
		driver.close();
		log.info("Driver is closed successfully");
	}

}
