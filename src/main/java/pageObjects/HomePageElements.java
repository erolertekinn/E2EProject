package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageElements {
	public WebDriver driver;

	public HomePageElements(WebDriver driver) {
		this.driver = driver;
	}

	// ".text-center>h2"
	private By login = By.xpath("//*[@id=\"homepage\"]/header/div[1]/div/nav/ul/li[4]/a");
	//private By titel = By.xpath("//h2[text()='Featured Courses']");
	private By titel = By.cssSelector(".text-center>h2");
	private By navigationBar = By.cssSelector("#homepage > header > div.navbar.navbar-default.navbar-static-top > div > nav > ul > li");
	 
	public LoginPageElements getLogin() {
		driver.findElement(login).click();
		
		LoginPageElements lp = new LoginPageElements(driver);
		
		return lp;

	}

	public WebElement getTitle() {
		return driver.findElement(titel);
	}
	
	public WebElement getNavigationBar() {
		return driver.findElement(navigationBar);

	}
}
