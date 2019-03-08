package seleniumPractise.saket;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import util.Init;

public class Assignment2 {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		Thread.sleep(1000);

		driver.manage().window().maximize();
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//button[contains(@id,'javascriptAlert')]"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

		element.click();

		Alert alert = driver.switchTo().alert();

		String alerttext = alert.getText();

		String expectedtext = "You must be TechnoCredits student!!";

		if (alerttext.equals(expectedtext)) {
			System.out.println("both strings are equal");

		} else {

			System.out.println("not equal");

		}

	}

}
