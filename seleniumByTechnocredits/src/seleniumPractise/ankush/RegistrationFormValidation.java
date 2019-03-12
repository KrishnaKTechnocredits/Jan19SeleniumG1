package seleniumPractise.ankush;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class RegistrationFormValidation {

	static WebElement ScrollFunction(WebDriver driver, String path) {
		WebElement element = driver.findElement(By.xpath(path));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		System.out.println("Scrolled Successfully");
		return element;
	}

	static String alertHandling(WebDriver driver) {
		Alert al = driver.switchTo().alert();
		String alertMsg = al.getText();
		al.accept();
		return alertMsg;
	}

	static void registrationFormChecks(WebDriver driver) throws InterruptedException {
		driver.get("http://automationbykrishna.com/index.html#");
		System.out.println("Url Entered");

		WebElement e1 = driver.findElement(By.id("registration2"));
		e1.click();
		System.out.println("Clicked on Registration link");

		Thread.sleep(2000);

		// First Name Validation
		WebElement e2 = RegistrationFormValidation.ScrollFunction(driver, "//button[@id='btnsubmitsignUp']");
		e2.click();
		System.out.println("Scrolled successfully to submit button");

		if (RegistrationFormValidation.alertHandling(driver).equals("Full name can't be blank")) {
			System.out.println("Full Name Validation Successful");
			driver.findElement(By.id("fullName")).sendKeys("Ankush");
			System.out.println("Full Name Entered");
		} else
			System.out.println("Full Name Validation Failed");

		// Address Validation
		WebElement e3 = RegistrationFormValidation.ScrollFunction(driver, "//button[@id='btnsubmitsignUp']");
		e3.click();

		if (RegistrationFormValidation.alertHandling(driver).equals("address cannot be blank")) {
			System.out.println("Address Validation Successful");
			driver.findElement(By.id("address")).sendKeys("Pune");
			System.out.println("Address Entered");
		} else
			System.out.println("Address Validation Failed");

		// Other Email ID Validation Checks
		WebElement e4 = RegistrationFormValidation.ScrollFunction(driver, "//button[@id='btnsubmitsignUp']");
		e4.click();

		if (RegistrationFormValidation.alertHandling(driver).equals("Please enter email id")) {
			System.out.println("Email ID Validation Successful");
			driver.findElement(By.id("useremail")).sendKeys("test@test.com");
			System.out.println("Other Email ID Entered");
		} else
			System.out.println("Other Email ID Validation Failed");

		// City Field Validation
		WebElement e5 = RegistrationFormValidation.ScrollFunction(driver, "//button[@id='btnsubmitsignUp']");
		e5.click();

		if (RegistrationFormValidation.alertHandling(driver).equals("Please enter City")) {
			System.out.println("User City Validation Successful");
			driver.findElement(By.id("usercity")).sendKeys("1234");

			e5.click();
			if (RegistrationFormValidation.alertHandling(driver).equals("Numeric not allowed in city/town field")) {
				driver.findElement(By.id("usercity")).clear();
				driver.findElement(By.id("usercity")).sendKeys("Pune");
				System.out.println("Valid City Entered");
			} else
				System.out.println("Valid City Validation Failed");

		}

		// Company Name Field Validation
		WebElement e6 = RegistrationFormValidation.ScrollFunction(driver, "//button[@id='btnsubmitsignUp']");
		e6.click();

		if (RegistrationFormValidation.alertHandling(driver).equals("Please enter your current organization")) {
			System.out.println("Company Name Validation Successful");
			driver.findElement(By.id("organization")).sendKeys("Test Organization");
			System.out.println("Current Organization Entered");

		} else
			System.out.println("Current Organization Validation Failed");

		// User Name Name Field Validation
		e5.click();

		if (RegistrationFormValidation.alertHandling(driver).equals("Username is mandatory field.")) {
			System.out.println("User Name Validation Successful");
			driver.findElement(By.id("usernameReg")).sendKeys("12345");
			e5.click();
			if (RegistrationFormValidation.alertHandling(driver)
					.equals("Username length should be greater then 5 characters.")) {
				driver.findElement(By.id("usernameReg")).clear();
				driver.findElement(By.id("usernameReg")).sendKeys("TestUser");
				System.out.println("User Name Entered");

			} else
				System.out.println("User Name Validation Failed");

		}

		// Password Field Validation
		e5.click();

		if (RegistrationFormValidation.alertHandling(driver).equals("password is mandatory field.")) {
			driver.findElement(By.id("passwordReg")).sendKeys("1234");
			e5.click();
			if (RegistrationFormValidation.alertHandling(driver)
					.equals("password length should be greater then 5 characters.")) {
				driver.findElement(By.id("passwordReg")).clear();
				driver.findElement(By.id("passwordReg")).sendKeys("TestPassword");
				System.out.println("Password Entered");

			} else
				System.out.println("Password Validation Failed");

		}

		// Reenter Password Field Validation
		e5.click();

		if (RegistrationFormValidation.alertHandling(driver).equals("please reenter password")) {
			driver.findElement(By.id("repasswordReg")).sendKeys("1234");
			e5.click();
			if (RegistrationFormValidation.alertHandling(driver).equals("retype password donot match.")) {
				driver.findElement(By.id("repasswordReg")).clear();
				driver.findElement(By.id("repasswordReg")).sendKeys("TestPassword");
				System.out.println("ReEntered Password");

			} else
				System.out.println("Re Entered Validation Failed");

		}

		// Privacy Policy Field Validation

		e5.click();
		if (RegistrationFormValidation.alertHandling(driver)
				.equals("Please agree to terms of service and privacy policy")) {
			driver.findElement(By.id("signupAgreement")).click();
			e5.click();
		} else
			System.out.println("Privacy Policy Validation Failed");

		if (RegistrationFormValidation.alertHandling(driver).equals("Success")) {
			System.out.println("All Validation are passed Successfully");
		} else
			System.out.println("Validations Fails");

	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		RegistrationFormValidation.registrationFormChecks(driver);
	}

}
