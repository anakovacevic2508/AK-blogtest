package cubes.helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class MyWebDriver {

	
	
	public static WebDriver getDriver(String browser) {
		
		WebDriver webDriver = null;
		
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\kicak\\OneDrive\\Desktop\\Drivers\\geckodriver.exe");
			webDriver = new FirefoxDriver(); 
		}
		else if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\kicak\\OneDrive\\Desktop\\Drivers\\chromedriver.exe");
			webDriver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\kicak\\OneDrive\\Desktop\\Drivers\\msedgedriver.exe");
			webDriver = new EdgeDriver();
		}
		else {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\kicak\\OneDrive\\Desktop\\Drivers\\chromedriver.exe");
			webDriver = new ChromeDriver();
		}
		
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		return webDriver;
		
	}
	
	public static void scrollToWebElement(WebDriver driver,WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
	
	
	
}
