package seleniumPractise.shraddha;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class Assign_2_selenium {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/index.html#");
		driver.findElement(By.xpath("//a[@id = 'basicelements']")).click();
		Thread.sleep(1000);
		String hardcoded = "You must be TechnoCredits student!!";

		WebElement e = driver.findElement(By.xpath("//button[@id='javascriptAlert']"));

		// Scroll Code
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
		e.click();

		// Alert code
		Alert alert = driver.switchTo().alert();
		String alerttext = alert.getText();
		alert.accept();

		if (alerttext.equals(hardcoded)) {
			System.out.println("PASS: matching");
		} else {
			System.out.println("FAIL: matching");
		}
	}

}
