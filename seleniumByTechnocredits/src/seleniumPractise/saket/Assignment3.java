package seleniumPractise.saket;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		Thread.sleep(1000);

		driver.manage().window().maximize();
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("	//button[contains(@id,'javascriptConfirmBox')]"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

		element.click();

		Alert alert = driver.switchTo().alert();

		alert.accept();
		Thread.sleep(3000);

		/*
		 * JavascriptExecutor js1 = (JavascriptExecutor) driver;
		 * js1.executeScript("arguments[0].scrollIntoView(true)", element);
		 */

		String actualvalue = driver.findElement(By.xpath("//p[text()='You pressed OK!' and @id='pgraphdemo']"))
				.getText();

		String Expectedvalue = "You pressed OK!";

		//System.out.println(actualvalue);
	//	System.out.println(Expectedvalue);

		if (actualvalue.equals(Expectedvalue))

		{
			System.out.println("Ok Alert message Expected and actual value is same ");
		} else {
			System.out.println("ok Alert message retrived is not per the expectations");
		}

		element.click();
		alert.dismiss();

		String actual = driver.findElement(By.xpath("//p[text()='You pressed Cancel!']")).getText();
		String Expected2 = "You pressed Cancel!";
		
		
		//System.out.println(actual);
			//System.out.println(Expected2);

		if (actual.equals(Expected2)) {
			System.out.println("Cancel Alert message retrived is as per the expectations");

		} else {
			System.out.println("Cancel Alert message retrived is not per the expectations");
		}
	}

}
