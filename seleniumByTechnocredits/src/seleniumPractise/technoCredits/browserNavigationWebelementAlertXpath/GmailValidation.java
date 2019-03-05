package seleniumPractise.technoCredits.browserNavigationWebelementAlertXpath;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;
import util.PropFileOperation;

public class GmailValidation {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver = Init.initChromeDriver();
		Properties prop = PropFileOperation.loadProp();
		driver.get("https://www.gmail.com");
		System.out.println("Browser Open");
		// driver.manage().window().maximize();
		WebElement emailTextfield = driver.findElement(By.id("identifierId"));
		if (emailTextfield.isEnabled()) {
			emailTextfield.sendKeys(prop.getProperty("email"));
			System.out.println("email address entered");
		} else
			System.out.println("not able to see text field");

		// it will return two webelemnts
		// driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
		WebElement nextButton = driver.findElement(By.id("identifierNext"));
		if (nextButton.isEnabled()) {
			nextButton.click();
			System.out.println("cliked on next");
		}
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
		System.out.println("Entered password");
		driver.findElement(By.id("passwordNext")).click();
		System.out.println("logged in successfully");
		// driver.close();
		// System.out.println("browser closed");
	}
}
