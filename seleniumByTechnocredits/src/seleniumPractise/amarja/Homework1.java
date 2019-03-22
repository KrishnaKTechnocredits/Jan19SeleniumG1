package seleniumPractise.amarja;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;

/*Program to automated Alert demo and accept the alert psot valdiation
1) Alert Demo > Submit > Alert
Validation of the values of Alert Demo with of the Alert.*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;
import util.PropFileOperation;

public class Homework1 {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = Init.initChromeDriver();
		Properties prop = PropFileOperation.loadProp();
		driver.get("http://automationbykrishna.com/index.html#");
		driver.findElement(By.partialLinkText("Elements")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[contains(@id,'UserFirst')]")).sendKeys(prop.getProperty("userfirstname"));
		System.out.println("First Name entered");
		String s1 = driver.findElement(By.xpath("//input[contains(@id,'UserFirst')]")).getAttribute("value");
		driver.findElement(By.xpath("//input[contains(@id,'UserLast') and @name='ulname']")).sendKeys(prop.getProperty("userlastname"));
		System.out.println("Last Name entered");
		String s2 = driver.findElement(By.xpath("//input[contains(@id,'UserLast') and @name='ulname']"))
				.getAttribute("value");
		System.out.println("Company name entered");
		driver.findElement(By.xpath("//input[contains(@class,'form-control') and @id='UserCompanyName']"))
				.sendKeys(prop.getProperty("companyname"));
		String s3 = driver.findElement(By.xpath("//input[contains(@class,'form-control') and @id='UserCompanyName']"))
				.getAttribute("value");
		driver.findElement(By.xpath("//div[@name='secondSegment'][1]//button[text()='Submit']")).click();
		String expectedtext = s1 + " and " + s2 + " and " + s3;
		Alert alert = driver.switchTo().alert();// To switch to alert
		Thread.sleep(1000);
		System.out.println("AlertOpen");
		String actualtext = alert.getText();
		if (actualtext.equals(expectedtext)) {
			alert.accept();
			System.out.println("Alert acceptd :Testcase passes");
		} else
			System.out.println("Testcase fails");
		driver.close();
	}
}
