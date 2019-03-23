package seleniumPractise.amarja;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

/*6) Registration> Registration > Tick button > alert
	Validate the alert   Registration> Registration > First Name > Tick button > alert
	Validate the alert and so on for every element --Error messages covered
		
 */
public class Homework6 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/index.html#");
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Registration")).click();
		Thread.sleep(4000);
		WebElement e1 = driver.findElement(By.xpath("//h1[@class='sign-title' and text()='Registration']"));
		Homework6 h6 = new Homework6();
		if (e1.isDisplayed()) {
			ArrayList<String> a2 = new ArrayList<String>();
			ArrayList<String> a3 = new ArrayList<String>();
			a3 = h6.storeinput(a3);
			a2 = h6.storeerrmsg(a2);
			ArrayList<WebElement> a1 = new ArrayList<WebElement>();
			a1 = h6.storexpath(a1, driver);
			// TC1 to TC9 -Verifying error message for all mandatory fields
			for (int i = 0; i < 8; i++) {
				h6.scroll(a1, driver);
				a1.get(a1.size() - 1).click();
				Alert alert = driver.switchTo().alert();
				h6.valdiatemandatoryfields(alert, a2.get(i), a1.get(i));
				a1.get(i).sendKeys(a3.get(i));
			}
			// TC 10 - Signupagreement madnatory field valdaition

			h6.scroll(a1, driver);
			a1.get(a1.size() - 1).click();
			Alert alert1 = driver.switchTo().alert();
			System.out.println("Expected." + a2.get(12));
			h6.valdiatemandatoryfields(alert1, a2.get(12), a1.get(8));
			// TC11-Verifying error message for Incorrect email address entered
			h6.validatedemailformat(a2.get(8), a1, driver);
			// TC12-Verify error message for password not same as retype
			// password
			h6.validatepwdmismatch(a2.get(11), a1, driver);
			a1.get(6).sendKeys("test@123.com");
			a1.get(7).clear();
			a1.get(7).sendKeys("test@123.com");
			// TC13-Verify error message for Username less than 5 character
			h6.validatelength(a2.get(9), a1.get(5), driver, a1);
			a1.get(5).clear();
			a1.get(5).sendKeys("amarjab");
			// TC14-Verify error message for Password less than 5 character
			h6.validatelength(a2.get(10), a1.get(6), driver, a1);
			// TC15 -Verify success message for all field valdiation passed
			a1.get(6).clear();
			a1.get(6).sendKeys("test@123.com");
			a1.get(8).click();
			h6.scroll(a1, driver);
			a1.get(a1.size() - 1).click();
			Alert alert = driver.switchTo().alert();
			if (alert.getText().equals(a2.get(13))) {
				alert.accept();
				System.out.println("All field validatioN passed");
			} else {
				alert.accept();
				System.out.println("All field valdiation failed");
			}
		}
		else
		{
			System.out.println("Testvaldiation failed as Element not found");
		}
		driver.close();
	}

	void validatelength(String string, WebElement webElement, WebDriver driver, ArrayList<WebElement> a1) {

		webElement.clear();
		webElement.sendKeys("tes");
		String s2 = webElement.getAttribute("value");
		scroll(a1, driver);
		a1.get(a1.size() - 1).click();
		Alert alert = driver.switchTo().alert();
		if (s2.length() < 5) {

			if (alert.getText().equals(string)) {
				System.out.println("Error message valdiated: " + alert.getText());
				alert.accept();
				System.out.println("Field valdiaton passed for :" + webElement.getAttribute("id"));
			} else {
				System.out.println(alert.getText());
				alert.accept();
			}
		}
	}

	void validatepwdmismatch(String string, ArrayList<WebElement> a1, WebDriver driver) {

		a1.get(6).sendKeys("test@123.com");
		String password = a1.get(7).getAttribute("value");
		a1.get(7).sendKeys("test@1234.com");
		String repassword = a1.get(8).getAttribute("value");
		scroll(a1, driver);
		a1.get(a1.size() - 1).click();
		Alert alert = driver.switchTo().alert();
		if (!password.equals(repassword)) {
			if (alert.getText().equals(string)) {

				System.out.println("Error message valdiated:" + alert.getText());
				alert.accept();
				System.out.println("field valdiaton passed for :" + a1.get(7).getAttribute("id"));
			} else {
				alert.accept();
				System.out.println(alert.getText());
			}
		}
	}

	void validatedemailformat(String string, ArrayList<WebElement> a1, WebDriver driver) {

		a1.get(2).clear();
		a1.get(2).sendKeys("amarjm");
		System.out.println("Email entered incorrect");
		scroll(a1, driver);
		a1.get(a1.size() - 1).click();
		Alert alert = driver.switchTo().alert();
		if (alert.getText().equals(string)) {

			System.out.println("Error message valdiated: " + alert.getText());
			alert.accept();
			System.out.println("Field valdiaton passed for :" + a1.get(2).getAttribute("id"));

		} else {
			alert.accept();
			System.out.println("Mandatory field validation failed");
		}

		a1.get(2).clear();
		a1.get(2).sendKeys("amarjm@gmail.com");
	}

	void scroll(ArrayList<WebElement> a1, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", a1.get(9));
		a1.add(driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")));
	}

	void valdiatemandatoryfields(Alert alert, String string, WebElement webElement) {

		if (alert.getText().equals(string)) {
			System.out.println("Error message valdiated :" + alert.getText());
			alert.accept();
			System.out.println("Mandatory field valdiaton passed for :" + webElement.getAttribute("id"));

		} else {
			System.out.println("Mandatory field validation failed");
			alert.accept();
		}

	}

	ArrayList<WebElement> storexpath(ArrayList<WebElement> a1, WebDriver driver) {
		a1.add(driver.findElement(By.xpath("//input[@id='fullName']")));
		a1.add(driver.findElement(By.xpath("//input[contains (@class,'form-control') and @placeholder='Address']")));
		a1.add(driver.findElement(By.xpath("//input[contains (@class,'form-control') and @name='useremail']")));
		a1.add(driver.findElement(By.xpath("//input[@id='usercity']")));
		a1.add(driver.findElement(By.id("organization")));
		a1.add(driver.findElement(By.xpath("//input[contains (@class,'form-control') and @id='usernameReg']")));
		a1.add(driver.findElement(By.xpath("//input[contains (@class,'form-control') and @id='passwordReg']")));
		a1.add(driver.findElement(By.xpath("//input[contains (@class,'form-control') and @id='repasswordReg']")));
		a1.add(driver.findElement(By.xpath("//input[@id='signupAgreement']")));
		a1.add(driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")));
		a1.add(driver.findElement(By.id("radio-02")));

		return a1;
	}

	ArrayList<String> storeerrmsg(ArrayList<String> a2) {
		a2.add("Full name can't be blank");
		a2.add("address cannot be blank");
		a2.add("Please enter email id");
		a2.add("Please enter City");
		a2.add("Please enter your current organization");
		a2.add("Username is mandatory field.");
		a2.add("password is mandatory field.");
		a2.add("please reenter password");
		a2.add("Please use correct email format");
		a2.add("Username length should be greater then 5 characters.");
		a2.add("password length should be greater then 5 characters.");
		a2.add("retype password donot match.");
		a2.add("Please agree to terms of service and privacy policy");
		a2.add("Success");
		return a2;

	}

	ArrayList<String> storeinput(ArrayList<String> a3) {
		a3.add("Amarja");
		a3.add("VIshal nagar pune");
		a3.add("amarja.beloakr@gmail.com");
		a3.add("Pune");
		a3.add("Deutshcebank");
		a3.add("amarja.belorkar");
		a3.add("amarja@123");
		a3.add("amarja@123");
		return a3;

	}
}
