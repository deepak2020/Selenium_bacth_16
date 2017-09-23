package TestMethods;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CommonMethods.CommonMethods;
import PageMethods.registration;

public class test {

	@BeforeTest
	public void setup() throws IOException {
		CommonMethods.openBrowser("chrome", CommonMethods.getConfigProperty("URL"));
	}

	@Test
	public void testRegistration() throws IOException {
		registration.regisrationFunctionality();

	}
}
