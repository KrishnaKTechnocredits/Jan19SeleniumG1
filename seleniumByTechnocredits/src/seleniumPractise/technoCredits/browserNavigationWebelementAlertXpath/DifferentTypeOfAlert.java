package seleniumPractise.technoCredits.browserNavigationWebelementAlertXpath;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class DifferentTypeOfAlert {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.linkText("Basic Elements")).click();
		System.out.println("on basic element");
		Thread.sleep(2000);
		// WebElement element =
		// driver.findElement(By.xpath("//button[starts-with(@id,'javascriptAle')]"));
		// System.out.println("clicked on alert");
		// JavascriptExecutor js = (JavascriptExecutor)driver;
		// js.executeScript("arguments[0].scrollIntoView(true)", element);
		// System.out.println("scrolled successfully");
		// element.click();
		// driver.switchTo().alert().accept();
		// System.out.println("done");

		// Confirmation alert
		// WebElement element =
		// driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']"));
		// JavascriptExecutor js = (JavascriptExecutor)driver;
		// js.executeScript("arguments[0].scrollIntoView(true)", element);
		// element.click();
		// Alert alert = driver.switchTo().alert();
		// alert.dismiss();
		// System.out.println("alert handled");

		// prompt alert
		WebElement element = driver.findElement(By.xpath("//button[@id='javascriptPromp']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("krishna");
		Thread.sleep(5000);
		System.out.println("send my name in alert");
		alert.accept();
		System.out.println("accepted alert");

	}

}
