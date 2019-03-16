package seleniumPractise.shraddha;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class Assign_3_selenium {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/index.html#");
		driver.findElement(By.xpath("//a[@id = 'basicelements']")).click();
		Thread.sleep(1000);

		WebElement e = driver.findElement(By.xpath("//button[text() = 'Javascript Confirmation']"));
		// Scroll code
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
		e.click();

		Alert alert = driver.switchTo().alert();
		alert.accept();
		if (driver.findElement(By.xpath("//*[@class='help-block' and @id='pgraphdemo']")).getText().equals("You pressed OK!")) {
			System.out.println("Verified Passed");
		} else {
			System.out.println("Verified Failed");
		}

	}

}
