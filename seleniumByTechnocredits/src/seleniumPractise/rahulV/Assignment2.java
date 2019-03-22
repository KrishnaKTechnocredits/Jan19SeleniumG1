package seleniumPractise.rahulV;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class Assignment2 {

	public static void main(String[] args) {
		validateAlertButton();

	}

	static void validateAlertButton() {

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

		// click on Alert button

		driver.findElement(By.xpath("//button[@type='submit' and @id='javascriptAlert']")).click();

		Alert alert = driver.switchTo().alert();

		if (alert.getText().equals("You must be TechnoCredits student!!")) {
			System.out.println("text present in alert is validated");
			alert.accept();
		}else {
			System.out.println("text present in alert is NOT validated");
		}

		driver.quit();

	}

}
