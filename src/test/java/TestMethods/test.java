package TestMethods;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CommonMethods.CommonMethods;
import PageMethods.registration;

public class test extends registration {

	@BeforeTest
	public static void setup() throws IOException {
		openBrowser("chrome", CommonMethods.getConfigProperty("URL"));
		maximize();
	}

	@Test
	public void testRegistration() throws IOException {
		regisrationFunctionality();

	}
	
	public void sum(){
	
	}
}
