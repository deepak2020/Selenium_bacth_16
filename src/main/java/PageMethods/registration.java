package PageMethods;

import java.io.IOException;

import CommonMethods.CommonMethods;

public class registration {

	public static void regisrationFunctionality() throws IOException{
		
		CommonMethods.waitForElement(10);
		CommonMethods.getElement("xpath", CommonMethods.getTestProperty("firstNameElement"));
		CommonMethods.typeAndEnter(CommonMethods.getTestProperty("firstName"));
		CommonMethods.getElement("xpath", CommonMethods.getTestProperty("lastNameElement"));
		CommonMethods.typeAndEnter(CommonMethods.getTestProperty("lastName"));
	}
}
