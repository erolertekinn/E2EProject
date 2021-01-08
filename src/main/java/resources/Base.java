package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class Base {
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				 System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");
		//System.out.println(browserName);

		if (browserName.equals("chrome")) {
			String path = System.getProperty("user.dir") + "\\driver\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", path);
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			String path = System.getProperty("user.dir") + "\\driver\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", path);
			driver = new FirefoxDriver();

		}

		else if (browserName.equals("IE")) {
			String path = System.getProperty("user.dir") + "\\driver\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", path);
			driver = new InternetExplorerDriver();
		}

		long waitTime = Integer.parseInt(prop.getProperty("waitTime"));
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
		
		return driver;

	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		//Calendar calendar = Calendar.getInstance();
		//SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		//String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+formater.format(calendar.getTime())+".png";
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		
		
	}
}
