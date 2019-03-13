package seleniumPractise.rahulV;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class Assignment3 {

	public static void main(String[] args) {
		validateJavascriptConfirmationButton();

	}

	static void validateJavascriptConfirmationButton() {
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/#");

		driver.findElement(By.linkText("Basic Elements")).click();

		// driver.findElement(By.partialLinkText("Basic El"));

		System.out.println("on  basic elements page");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement e1 = driver.findElement(By.xpath("//header[text()=' Different Examples of Alerts ']"));
		// scrolling till text "DifferentExamples" before clicking on alert button

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e1);

		// click on javascript Confirmation button
		driver.findElement(By.id("javascriptConfirmBox")).click();

		Alert alert = driver.switchTo().alert();

		// press ok
		alert.accept();

		// verify text
		if (driver.findElement(By.id("pgraphdemo")).getText().equals("You pressed OK!")) {
			System.out.println("text verified on pressing ok");
		} else {
			System.out.println("text NOT verified on presseing ok");
		}
		// press cancel and verify text
		driver.findElement(By.id("javascriptConfirmBox")).click();

		// press Cancel
		alert.dismiss();

		// verify text on cancelling
		if (driver.findElement(By.id("pgraphdemo")).getText().equals("You pressed Cancel!")) {
			System.out.println("text verified on pressing Cancel");
		} else {
			System.out.println("text NOT verified on presseing Cancel");
		}
		driver.quit();
	}

}