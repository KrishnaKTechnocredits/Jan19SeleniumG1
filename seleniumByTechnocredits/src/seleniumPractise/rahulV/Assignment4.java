package seleniumPractise.rahulV;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;
import util.PropFileOperation;

public class Assignment4 {

	public static void main(String[] args) throws IOException {
		validateJavaScriptPromtButton();

	}

	static void validateJavaScriptPromtButton() throws IOException {
		WebDriver driver = Init.initChromeDriver();
		Properties prop = PropFileOperation.loadProp();
		driver.get("http://automationbykrishna.com/#");

		driver.findElement(By.linkText("Basic Elements")).click();

		// driver.findElement(By.partialLinkText("Basic El"));

		System.out.println("on  basic elements page");

		WebElement e1 = driver.findElement(By.xpath("//header[text()=' Different Examples of Alerts ']"));
		// scrolling till text "DifferentExamples" before clicking on alert button

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e1);

		driver.findElement(By.xpath("//button[@type='submit' and @id='javascriptPromp']")).click();

		// String name = "Rahul";

		String name = prop.getProperty("FirstName");
		Alert alert = driver.switchTo().alert();

		alert.sendKeys(name);

		alert.accept();

		WebElement e2 = driver.findElement(By.id("pgraphdemo"));

		boolean flag1 = e2.getText().equals("Hello " + name + "! How are you today?");

		if (flag1) {
			System.out.println("text verified on pressing ok");
		} else {
			System.out.println("text not verified on pressing ok");
		}

		driver.findElement(By.xpath("//button[@type='submit' and @id='javascriptPromp']")).click();

		alert.dismiss();

		boolean flag2 = e2.getText().equals("User cancelled the prompt.");

		if (flag2) {
			System.out.println("text verified on pressing Cancel");
		} else {
			System.out.println("text not verified on Cancel");
		}

	}

}
