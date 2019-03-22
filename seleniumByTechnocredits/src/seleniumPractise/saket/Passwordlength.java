package seleniumPractise.saket;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Init;

public class Passwordlength {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[contains(@id,'registration2')]")).click();
		Thread.sleep(1000);

		String password = "123456789";

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Saket");

		driver.findElement(By.xpath("//input[contains(@id,'pwdSignin')]")).sendKeys(password);

		String Password = driver.findElement(By.xpath("//input[contains(@id,'pwdSignin')]")).getAttribute("value");
		System.out.println(Password);

		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		if (Password.length() <= 8) {
			Alert alert = driver.switchTo().alert();
			String s = alert.getText();
			if (s.equals("Failed! please enter strong password")) {
				System.out.println("password validation message same as expected");
			} else {

				System.out.println("password validation message not same as expected");
			}
		}

		else {

			System.out.println("password was as expected no alert has been genrated ");

		}

	}

}