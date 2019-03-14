//program to validate password length- Password should be greater than 8 characters
package seleniumPractise.mayur;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;
import util.PropFileOperation;

public class PasswordLengthValidationH5 {

	public static void main(String[] args) throws IOException, InterruptedException {

		PasswordLengthValidationH5 passValidate = new PasswordLengthValidationH5();
		WebDriver driver = Init.initChromeDriver();
		Properties prop = PropFileOperation.loadProp();
		
		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.id("registration2")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("unameSignin")).sendKeys(prop.getProperty("Name"));
		WebElement element = driver.findElement(By.id("pwdSignin"));
		element.sendKeys(prop.getProperty("Password"));
		String passwordLength = element.getAttribute("value");
		
		//checking if remember checkbox already checked or not
		if (true == driver.findElement(By.id("rememberme")).isSelected()) {
			System.out.println("Remember Me checkbox already checked");
		} else {
			driver.findElement(By.id("rememberme")).click();
		}

		driver.findElement(By.id("btnsubmitdetails")).click();
		Alert alert = driver.switchTo().alert();

		Thread.sleep(2000);
		passValidate.validatePasswordLength(alert, prop, passwordLength);
		driver.close();
	}

	//Method to validate Password length
	void validatePasswordLength(Alert alert, Properties prop, String passwordLength) {

		if (passwordLength.length() <= 8 || alert.getText().equals("Failed! please enter strong password")) 
		{
			System.out.println("User entered Password should be greater than 8 character/digit: character length Test case passed");
			alert.accept();
		} 
		else 
		{
			System.out.println("User entered More than 8 Character: Password Length validation case :Passed");
			alert.accept();
		}
	}
}
