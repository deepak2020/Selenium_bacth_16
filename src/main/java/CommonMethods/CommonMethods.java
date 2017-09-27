package CommonMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {
	
	public static WebDriver driver;
	public static WebElement element;
	public static WebDriverWait wait;
	
	public static Object maximize (){
		driver.manage().window().maximize();
		return null;
	}

	public static WebDriver openBrowser(String browserName, String url) throws MalformedURLException {
		String node1= "http://ankita172:418681cd-6434-49c5-a620-2568e43917c5@ondemand.saucelabs.com:80/wd/hub";
		// String Node = "http://192.168.0.4:5555/wd/hub";
			
		
		if (browserName.equalsIgnoreCase("firefox")) {
			DesiredCapabilities cap =  DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setVersion("40.0");
			driver = new RemoteWebDriver(new URL(node1), cap);
//			driver = new FirefoxDriver();
			driver.get(url);
		} else if (browserName.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
//			driver = new ChromeDriver();
			DesiredCapabilities cap =  DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setVersion("60.0");
			driver = new RemoteWebDriver(new URL(node1), cap);
			driver.get(url);

		} else if (browserName.equalsIgnoreCase("safari")){
			driver = new SafariDriver();
		}
		return driver;
		
	}
	public static void scrolldown(){
		
		((JavascriptExecutor) driver)
		.executeScript("javascript:window.scrollBy(0,600)");
	}

	public static WebElement getElement	(String locator, String path) {
		
		if (locator.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(path));
		} else if (locator.equalsIgnoreCase("name")) {
			try {
				Thread.sleep(30);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			element = driver.findElement(By.name(path));
		} else if (locator.equalsIgnoreCase("xpath")){
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

	public static void click() {
		element.click();
	}

	public static void typeAndEnter(String text) {
		element.click();
		element.sendKeys(text);
	}

	public static String getConfigProperty(String element)
			throws IOException {

		File file = new File(
				"config.properties");
		FileInputStream fileInput = new FileInputStream(file);

		Properties prop = new Properties();
		prop.load(fileInput);
		 return (String) prop.get(element);
		

	}
	public static String getTestProperty(String element)
			throws IOException {

		File file = new File(
				"test.properties");
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
