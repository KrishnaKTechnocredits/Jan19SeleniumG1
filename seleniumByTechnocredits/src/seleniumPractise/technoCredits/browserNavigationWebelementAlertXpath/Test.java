package seleniumPractise.technoCredits.browserNavigationWebelementAlertXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class Test {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		Thread.sleep(1000);
		driver.findElement(By.id("registration2")).click();
		Thread.sleep(1000);
		// WebElement checkbox = driver.findElement(By.id("signupAgreement"));
		// JavascriptExecutor js = (JavascriptExecutor)driver;
		// js.executeScript("arguments[0].scrollIntoView(true)", checkbox);
		// Thread.sleep(1000);
		// WebElement element = driver.findElement(By.partialLinkText("Login"));
		// element.click();
		// Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='unameSignin']/ancestor::div")).click();
		String className = driver.findElement(By.xpath("//input[@id='unameSignin']/ancestor::div"))
				.getAttribute("class");
		System.out.println("className: " + className);
	}

}
