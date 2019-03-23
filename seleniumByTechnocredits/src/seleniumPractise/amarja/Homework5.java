package seleniumPractise.amarja;

/*5) Registration > Login> password less than/equal to 8 letters > alert
	Validate the alert text
  */
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class Homework5 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/index.html#");
		System.out.println("Brower opened");
		driver.manage().window().maximize();
		// Find element username to enter username
		driver.findElement(By.id("registration2")).click();
		Thread.sleep(4000);
		// driver.findElement(By.id("unameSignin")).sendKeys("amarja.belorkar");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("amarja.belorkar");
		System.out.println("Username entered");
		WebElement e1 = driver.findElement(By.id("pwdSignin"));
		e1.sendKeys("amarj%");
		String s1 = e1.getAttribute("value");
		System.out.println("Passowrd entered");
		driver.findElement(By.id("rememberme")).click();
		System.out.println("Remember me Entered");
		driver.findElement(By.id("btnsubmitdetails")).click();
		System.out.println("Submit button clicked");
		Alert alert = driver.switchTo().alert();
		Homework5 h5 = new Homework5();
		h5.passwordvalidation(alert, s1, driver);
		driver.close();
	}

	void passwordvalidation(Alert alert, String s1, WebDriver driver) {
		// Valdiating less than 8 character valdiation
		if (s1.length() <= 8) {
			System.out.println("Password validation failed+Length of password is : " + s1.length());

			if (alert.getText().equals("Failed! please enter strong password")) {
				System.out.println("Less than 8 charcter Password valdiation -Passed");
				alert.accept();
				driver.findElement(By.id("pwdSignin")).clear();
			}
		}
		// Valdiating more than 8 char password validation
		driver.findElement(By.id("pwdSignin")).sendKeys("amarja343@");
		driver.findElement(By.id("btnsubmitdetails")).click();
		if (alert.getText().equals("Success!")) {
			alert.accept();
			System.out.println("More than 8 character password valiation passed.TC passed");
		}
	}

}
