package seleniumPractise.saket;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class Assignment4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		Thread.sleep(1000);

		driver.manage().window().maximize();
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//button[@id='javascriptPromp']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

		element.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		System.out.println("I am in alert");
		String name = "saket";
		alert.sendKeys(name);
		System.out.println("I have send the key in alert");
		alert.accept();

		// String s = "Hello saket! How are you today?";
		String s = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println(s);
		if (s.contains(name)) {
			System.out.println("Text message with expected output is valid");

		} else {

			System.out.println("Text message with expected output is not valid");

		}

		element.click();
		Alert alert1 = driver.switchTo().alert();
		Thread.sleep(2000);
		System.out.println("I am in alert");
		String name1 = "saket";
		alert.sendKeys(name);
		System.out.println("I have send the key in alert");
		alert.dismiss();
		String s1 = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println(s1);
		if (s1.contains("User cancelled the prompt.")) {
			System.out.println("Text message with expected output is valid");

		} else {

			System.out.println("Text message with expected output is not valid");

		}
		driver.close();

	}

}
