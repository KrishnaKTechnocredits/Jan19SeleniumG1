// Program to Validate Alert Message.
/* Question--
 * Alert Demo > Submit > Alert
 * Validation of the values of Alert Demo with of the Alert.*/
package seleniumPractise.mayur;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.Init;
import util.PropFileOperation;

public class ValidateAlertDemoH1 {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		Properties prop = PropFileOperation.loadProp();

		String resultExpected = "" + prop.getProperty("Name") + " and " + prop.getProperty("LName") + " and "
				+ prop.getProperty("CName");

		driver.get("http://automationbykrishna.com/#");
		System.out.println("Browser Opened");

		driver.findElement(By.xpath("//*[@id='basicelements']")).click();
		System.out.println("clicked on -Basic Elements");

		ValidateAlertDemoH1 validateAlert = new ValidateAlertDemoH1();
		validateAlert.alertValidationValid(driver, prop, resultExpected);
		validateAlert.alertValidationInvalid(driver, prop, resultExpected);
		driver.close();
	}

	void clearPreviousData(WebDriver driver)

	{
		driver.findElement(By.xpath("//input[@name='ufname']")).clear();
		driver.findElement(By.xpath("//input[@id='UserLastName']")).clear();
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).clear();
	}

	// Method to validate Alert- Happy Path case
	// Pass object Of driver class, object of Properties class and expected result
	// in string format

	void alertValidationValid(WebDriver driver, Properties prop, String resultExpected) throws InterruptedException {
		Thread.sleep(2000);
		clearPreviousData(driver);
		// read Name From properties file and send values as First name
		driver.findElement(By.xpath("//input[@name='ufname']")).sendKeys(prop.getProperty("Name"));
		System.out.println("First Name entered");

		// read Name From properties file and send values as Last name
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys(prop.getProperty("LName"));
		System.out.println("Last Name entered");

		// read Name From properties file and send values as Company name
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys(prop.getProperty("CName"));
		System.out.println("Company Name entered");

		driver.findElement(By.xpath("//div[@name='secondSegment'][1]//button[text()='Submit']")).click();
		System.out.println("Clicked on Submit Button");

		// Comparing result
		if (resultExpected.equals(driver.switchTo().alert().getText())) {
			driver.switchTo().alert().accept();
			System.out.println("Test case Passed");
		}

	}

	// Method to validate Alert Invalid- Failure Case- Company Name missing-
	// Pass object Of driver class, object of Properties class and expected result
	// in string format
	void alertValidationInvalid(WebDriver driver, Properties prop, String resultExpected) throws InterruptedException {
		Thread.sleep(2000);
		clearPreviousData(driver);

		// read Name From properties file and send values as First name
		driver.findElement(By.xpath("//input[@name='ufname']")).sendKeys(prop.getProperty("Name"));
		System.out.println("First Name entered");

		// read Name From properties file and send values as Last name
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys(prop.getProperty("LName"));
		System.out.println("Last Name entered");

		driver.findElement(By.xpath("//div[@name='secondSegment'][1]//button[text()='Submit']")).click();
		System.out.println("Clicked on Submit Button");

		// Comparing result
		if (!resultExpected.equals(driver.switchTo().alert().getText())) {
			driver.switchTo().alert().accept();
			System.out.println("User not filled all textboxes :Test case Failed");
		}

	}

}
