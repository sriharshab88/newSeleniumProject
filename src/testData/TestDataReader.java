package testData;

import libraries.PropertiesReader;

/**
 * This file will read the test data from the file and input to the test scripts
 * @author Sri harsha
 */
public class TestDataReader {
	
	public static PropertiesReader propertiesReader = new PropertiesReader();
	
	public static String email = propertiesReader.getEmail();
	public static String password = propertiesReader.getPassword();
	public static String myAccountText = propertiesReader.getmyAccountText();
	public static String myAccountValidationMessage = propertiesReader.getmyAccountValidationMessage();
	public static String orderConfirmationText = propertiesReader.getorderConfirmationText();
	public static String orderConfirmationTextValidationMessage = propertiesReader.getorderConfirmationTextValidationMessage();

}
