package seleniumPractise.vishal;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class Runnable  {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		AlertHandling ah = new AlertHandling();
		ah.verifyAlertDemo();
	    ah.verifyAlertString();
		ah.javaScriptConfirmation();
		ah.javaScriptPrompt();
		
		LoginRegistration lr = new LoginRegistration();
		lr.verifyPasswordLength();
		lr.verifyRegistrationFormAlerts();
	}

}
