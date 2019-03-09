package seleniumPractise.saket;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import util.Init;

public class Assignment_1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/#");

		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("UserFirstName")).sendKeys("Saket");

		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys("Nagmote");

		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys("Capgemini");

		String b = driver.findElement(By.id("UserFirstName")).getAttribute("value");
		String c = driver.findElement(By.xpath("//input[@id='UserLastName']")).getAttribute("value");
		String d = driver.findElement(By.xpath("//input[@id='UserCompanyName']")).getAttribute("value");

		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()' ]")).click();

		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();

		String a = alert.getText();
		String expected = b + " and " + c + " and " + d;
		System.out.println(a);
		System.out.println(expected);

		/*
		 * System.out.println(a);
		 * 
		 * String[] words = a.split("and");
		 * 
		 * 
		 * 
		 * String input = (b.concat(c).concat(d)); System.out.println("Input" +
		 * input); String expected = "";
		 * 
		 * for (int i = 0; i <= words.length - 1; i++) {
		 * 
		 * expected = expected + words[i];
		 * 
		 * } System.out.print(expected);
		 * 
		 * a = expected.replaceAll("\\s", "");
		 * 
		 * System.out.println(a);
		 */

		if (a.equals(expected)) {
			System.out.println("Succesfully compared the input with the alert and it is matching");
		} else {
			System.out.println("comparison of the input with the alert and is not matching ");

		}

		alert.accept();
		driver.close();

	}
}
