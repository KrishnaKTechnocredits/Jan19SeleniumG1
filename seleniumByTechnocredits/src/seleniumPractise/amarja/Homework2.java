package seleniumPractise.amarja;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

/*Program to automated the Alert and 2) Alert > Ok
Validate the string of Alert with hardcoded value.*/
public class Homework2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/index.html#");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("Clicked on Basic elements");
		Thread.sleep(2000);
		WebElement e1 = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e1);
		e1.click();
		Alert alert = driver.switchTo().alert();
		String actual = alert.getText();
		String expected = "You must be TechnoCredits student!!";
		if (actual.equals(expected)) {
			alert.accept();
			System.out.println("Alert Validated : Testcase passed");
		} else
			System.out.println("Alert validation failed: Testcase Failed");
		driver.close();
	}

}
