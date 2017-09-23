package common;

import java.io.IOException;

import org.testng.annotations.Test;



public class testFunctionality extends LoginPageMethods {

	@Test
		public void testLoginFunctionality(String Userna, String Passwrod) throws IOException{
			OpenBrowser();
			getURL(getProperty("config", "URL"));
			loginFunctionality(getProperty("test", Userna), getProperty("test", Passwrod"));
			
		}
}
