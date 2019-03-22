package seleniumPractise.ankush;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class RegistrationPasswordValidation {

	static void passwordValidation(WebDriver driver) throws InterruptedException {
		driver.get("http://automationbykrishna.com/index.html#");
		System.out.println("Url Entered");

		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);

		if (actualTitle.equals("Login Signup Demo")) {
			WebElement e1 = driver.findElement(By.id("registration2"));
			if (e1.isDisplayed()) {
				e1.click();
				System.out.println("Registration link is available");
				Thread.sleep(2000);

				if (driver.findElement(By.id("fullName")).isEnabled()) {
					driver.findElement(By.id("fullName")).sendKeys("Monali");
					System.out.println("Full Name Entered");
				}

				driver.findElement(By.id("address")).sendKeys("Baner Pune");
				System.out.println("Address Entered");
				Thread.sleep(1000);

				driver.findElement(By.id("useremail")).sendKeys("test@test.com");
				System.out.println("User Email Entered");
				Thread.sleep(1000);

				driver.findElement(By.id("usercity")).sendKeys("Pune");
				System.out.println("Enter City");

				driver.findElement(By.id("organization")).sendKeys("TechnoCredits");
				System.out.println("Enter Organization");

				WebElement element = driver.findElement(By.id("radio-02"));

				boolean flag = element.isSelected();

				if (!flag) {
					element.click();
					System.out.println("Clicked on Element");
					Thread.sleep(1000);
					if (element.isSelected()) {
						System.out.println("Female Radio button is selected");
					}
				}

				driver.findElement(By.id("usernameReg")).sendKeys("Test123");
				System.out.println("User Name Entered");
				Thread.sleep(1000);

				driver.findElement(By.id("passwordReg")).sendKeys("1234");
				System.out.println("Wrong Password Entered");

				driver.findElement(By.id("btnsubmitsignUp")).click();
				System.out.println("Click on Submit Button");

				Alert alert = driver.switchTo().alert();

				if (alert.getText().equals("password length should be greater then 5 characters.")) {
					System.out.println("User Entered Wrong Password");
					alert.accept();
				} else
					System.out.println("Password Entered Correctly");

			}
		}

	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		passwordValidation(driver);
	}
}
