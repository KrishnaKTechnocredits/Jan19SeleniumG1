package seleniumPractise.vishal;

import java.io.IOException;
import java.util.Properties;

import javax.lang.model.element.Element;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;
import util.PropFileOperation;

public class LoginRegistration extends MasterClass {

	WebDriver driver = Init.initChromeDriver();

	public void verifyPasswordLength() throws InterruptedException, IOException {
		Properties prop = PropFileOperation.loadProp();

		driver.get(prop.getProperty("url"));
		driver.findElement(By.linkText("Registration")).click();
		System.out.println("On Registration Page");
		Thread.sleep(2000);
		String expectedText = "Failed! please enter strong password";
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(prop.getProperty("password"));
		// driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		click(driver, "//button[@id='btnsubmitdetails']");

		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();

		if (expectedText.equals(actualText)) {
			System.out.println("Alert text is correct");
			alert.accept();
		}

		else {
			System.out.println("Alert text is not correct");
			alert.accept();

		}

	}

	public void tickClick() {
		WebElement tickElement = driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", tickElement);
		tickElement.click();
	}

	public void verifyRegistrationFormAlerts() throws IOException {
		Properties prop = PropFileOperation.loadProp();

		String fullNameExpectedText = "Full name can't be blank";
		String addressExpectedText = "address cannot be blank";
		String otherEmailIdExpectedText = "Please enter email id";
		String correctEmailExpectedText = "Please use correct email format";
		String cityTownExpectedText = "Please enter City";
		String companyNameExpectedText = "Please enter your current organization";
		String userNameExpectedText = "Username is mandatory field.";
		String userNameValidationExpected = "Username length should be greater then 5 characters.";
		String passwordExpectedText = "password is mandatory field.";
		String ReTypePasswordExpectedText = "please reenter password";
		String passwordDontMatchExpectedText = "retype password donot match.";

		WebElement tickElement = driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']"));

		tickClick();
		Alert alert = driver.switchTo().alert();
		String ActualText = alert.getText();

		if (fullNameExpectedText.equals(ActualText)) {
			System.out.println("Alert full name is correct");
			alert.accept();
		} else {
			System.out.println("Alert is not correct");
			alert.accept();

		}

		driver.findElement(By.xpath("//input[@id='fullName']")).sendKeys(prop.getProperty("firstname"));
		tickClick();
		ActualText = alert.getText();

		if (addressExpectedText.equals(ActualText)) {
			System.out.println("Alert text address is correct");
			alert.accept();
		}

		else {
			System.out.println("Alert text is not correct");
			alert.accept();

		}

		driver.findElement(By.xpath("//input[@id='address']")).sendKeys(prop.getProperty("location"));
		tickClick();
		ActualText = alert.getText();

		if (otherEmailIdExpectedText.equals(ActualText)) {
			System.out.println("Alert text other email is correct");
			alert.accept();
		}

		else {
			System.out.println("Alert text is not correct");
			alert.accept();

		}

		driver.findElement(By.xpath("//input[@id='useremail']")).sendKeys(prop.getProperty("email"));
		tickClick();

		ActualText = alert.getText();

		if (cityTownExpectedText.equals(ActualText)) {
			System.out.println("Alert text city town is correct");
			alert.accept();
		}

		else {
			System.out.println("Alert text is not correct");
			alert.accept();

		}

		driver.findElement(By.xpath("//input[@id='usercity']")).sendKeys(prop.getProperty("city"));
		tickClick();

		ActualText = alert.getText();

		if (companyNameExpectedText.equals(ActualText)) {
			System.out.println("Alert text organization is correct");
			alert.accept();
		}

		else {
			System.out.println("Alert text is not correct");
			alert.accept();

		}

		driver.findElement(By.xpath("//input[@id='organization']")).sendKeys(prop.getProperty("company"));
		tickClick();

		ActualText = alert.getText();

		if (userNameExpectedText.equals(ActualText)) {
			System.out.println("Alert text user name is correct");
			alert.accept();
			driver.close();
		}

		else {
			System.out.println("Alert text is not correct");
			alert.accept();

		}

	}
}
