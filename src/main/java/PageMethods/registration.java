package PageMethods;

import java.io.IOException;



import CommonMethods.CommonMethods;

public class registration extends CommonMethods {
	
	public static void regisrationFunctionality() throws IOException{
		registration reg = new registration ();
		
		waitForElement(10);
		
		getElement("xpath", CommonMethods.getTestProperty("firstNameElement"));
		typeAndEnter(CommonMethods.getTestProperty("firstName"));
		getElement("xpath", CommonMethods.getTestProperty("lastNameElement"));
		typeAndEnter(CommonMethods.getTestProperty("lastName"));
		
		getElement("xpath", getTestProperty("GenderIdFemale"));
		click();
		getElement("xpath", getTestProperty("YearOfExp"));
		click();
		scrolldown();
		getElement("xpath", getTestProperty("DatePicker"));
		typeAndEnter(getTestProperty("ValueOfDate"));
		getElement("xpath", getTestProperty("ProfessionCheckbox"));
		click();
		getElement("xpath", getTestProperty("AutomationToolCheckbox"));
		click();
		getElement("xpath", getTestProperty("Continents"));
		typeAndEnter(getTestProperty("SelectContinents"));
		click();
		getElement("id", getTestProperty("CommandsControl"));
		typeAndEnter(getTestProperty("ByVisibleText"));
		click();
		getElement("xpath", getTestProperty("SubmitButton"));
		click();
		

		
		
		
		

	}
}
