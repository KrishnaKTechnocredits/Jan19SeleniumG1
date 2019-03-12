package seleniumPractise.ankush;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import util.Init;

public class JavaScriptPrompt {

	WebElement ScrollFunction(WebDriver driver, String path) {
		WebElement element = driver.findElement(By.xpath(path));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		System.out.println("Scrolled Successfully");
		return element;
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=Init.initChromeDriver();

		driver.get("http://automationbykrishna.com/index.html#");

		driver.findElement(By.linkText("Basic Elements")).click();
		System.out.println("Click on Basic Elements Link");

		Thread.sleep(2000);

		JavaScriptPrompt jScriptP = new JavaScriptPrompt();
		WebElement e1 = jScriptP.ScrollFunction(driver, "//button[@id='javascriptPromp']");

		e1.click();
		System.out.println("Click on JavaScript Prompt Button");

		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Ankush");
		alert.accept();
		System.out.println("Passed value to alert box and accepted the alert");

		String textMsg = driver.findElement(By.id("pgraphdemo")).getText();

		if (textMsg.substring(6, 12).equals("Ankush")) {
			System.out.println("Validation Passed");
		}

		e1.click();
		System.out.println("Click on JavaScript Prompt Button Again");

		driver.switchTo().alert().dismiss();

		String cancelTextMsg = driver.findElement(By.id("pgraphdemo")).getText();

		if (cancelTextMsg.equals("User cancelled the prompt.")) {
			System.out.println("User clickec on Cancelled Prompt Button");
		}

	}
}
