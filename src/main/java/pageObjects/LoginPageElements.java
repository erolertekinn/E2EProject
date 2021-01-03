package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageElements {
	public WebDriver driver;

	public LoginPageElements(WebDriver driver) {

		this.driver = driver;
	}

	private By email = By.xpath("//*[@id=\"user_email\"]");
	private By password = By.xpath("//*[@id='user_password']");
	private By loginSubmit = By.xpath("//input[@type='submit']");
	private By forgotPassword = By.cssSelector("[href*='password/new']");

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getLoginSubmit() {
		return driver.findElement(loginSubmit);
	}
	
	public ForgotPasswordElements forgotPassword() {
		driver.findElement(forgotPassword).click();
		return new ForgotPasswordElements(driver);
		
	}
}
