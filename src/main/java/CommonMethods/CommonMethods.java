package CommonMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {
	
	static WebDriver driver;
	static WebElement element;
	static WebDriverWait wait;

	public static WebDriver openBrowser(String browserName, String url) {
		
		if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.get(url);
		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium_Driver\\chromedriver2.31.exe");
			driver = new ChromeDriver();
			driver.get(url);
		} else if (browserName.equalsIgnoreCase("safari")){
			driver = new SafariDriver();
		}
		return driver;
	}

	public static WebElement getElement	(String locator, String path) {
		
		if (locator.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(path));
		} else if (locator.equalsIgnoreCase("name")) {
			element = driver.findElement(By.name(path));
		} if (locator.equalsIgnoreCase("xpath")){
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			element = driver.findElement(By.xpath(path));
			System.out.println("********"+ element);
		}
		return element;
	}

	public void click() {
		element.click();
	}

	public static void typeAndEnter(String text) {
		element.click();
		element.sendKeys(text);
	}

	public static String getConfigProperty(String element)
			throws IOException {

		File file = new File(
				"C:\\Users\\deepak.kumar\\Workspace\\SeleniumDemo_Framework\\config.properties");
		FileInputStream fileInput = new FileInputStream(file);

		Properties prop = new Properties();
		prop.load(fileInput);
		 return (String) prop.get(element);
		

	}
	public static String getTestProperty(String element)
			throws IOException {

		File file = new File(
				"C:\\Users\\deepak.kumar\\Workspace\\SeleniumDemo_Framework\\test.properties");
		FileInputStream fileInput = new FileInputStream(file);

		Properties prop = new Properties();
		prop.load(fileInput);
		return (String) prop.get(element);
		

	}
	
	public static void setup() throws IOException{
		CommonMethods.openBrowser("chrome", CommonMethods.getConfigProperty("URL"));
	}
	
	public static void waitForElement(long unit){
//		wait = new WebDriverWait(driver, unit);
//		WebElement test = driver.findElement(By.xpath(element1));
//		wait.until(ExpectedConditions.visibilityOf(test));
		try {
			Thread.sleep(unit);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
