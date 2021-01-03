package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordElements {

	public WebDriver driver;

	public ForgotPasswordElements(WebDriver driver) {
		this.driver = driver;
	}
	private By email = By.cssSelector("[id='user_email']");
	private By sendMeInstructions = By.cssSelector("[type*='submit']");
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getInstructionsButton() {
		return driver.findElement(sendMeInstructions);
	}
}
