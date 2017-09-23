package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonMethods {
static WebDriver driver;

public static void OpenBrowser(){
	driver = new FirefoxDriver();
}

public static void getURL(String URL){
	driver.get(URL);
}

public static void typeAndEnter(String xpath, String value){
	driver.findElement(By.xpath(xpath)).sendKeys(value);
	
}

public static void click(String xpath){
	driver.findElement(By.xpath(xpath)).click();
	
}
public static String getProperty(String fileName, String key) throws IOException{
	//Step 1 File path
	File file = new File("C:\\Users\\deepak.kumar\\Workspace\\Selenium_Frame_Work_Demo\\"+fileName+".properties");
	
	//Step 2 Put file in Input Stream
	
	FileInputStream fileInput = new FileInputStream(file);
	
	//Step 2 Load File
	Properties prop = new Properties();
	prop.load(fileInput);
	String value= prop.getProperty(key);
	return value;
	
	
	
	
}
	
	

}
