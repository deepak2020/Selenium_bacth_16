package common;

import java.io.IOException;


public class LoginPageMethods extends CommonMethods {
	
	public  static void loginFunctionality(String Username, String Password) throws IOException{
		typeAndEnter(getProperty("config", "usernameXpath"), Username);
		click(getProperty("config", "nextButton"));
		typeAndEnter(getProperty("config", "passwordXpath"), Password);
	}
	

}
