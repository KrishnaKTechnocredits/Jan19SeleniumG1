package seleniumPractise.mayur;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Init;

public class JavaScriptConfirmationH3 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = Init.initChromeDriver();
		JavaScriptConfirmationH3 jsAlert = new JavaScriptConfirmationH3();
		driver.get("http://automationbykrishna.com/#");
		System.out.println("Browser Opened");

		driver.findElement(By.id("basicelements")).click();
		System.out.println("Clicked on Basic Element Tab");
		Thread.sleep(2000);

		String expectedMsg = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		String expectedAccept = "You pressed OK!";
		String expectedCancel = "You pressed Cancel!";

		Scroll.scroll(driver, driver.findElement(By.xpath("//button[starts-with(@id,'javascriptAle')]")));

		driver.findElement(By.id("javascriptConfirmBox")).click();

		jsAlert.validateAlertAccept(driver, expectedMsg, expectedAccept);
		Thread.sleep(2000);
		driver.findElement(By.id("javascriptConfirmBox")).click();
		jsAlert.validateAlertCancel(driver, expectedMsg, expectedCancel);
		Thread.sleep(2000);
		driver.close();
	}

	void validateAlertAccept(WebDriver driver, String expectedMsg, String expectedAccept) 
	{
		if (expectedMsg.equals(driver.switchTo().alert().getText())) 
		{
			driver.switchTo().alert().accept();
			if (expectedAccept.equals(driver.findElement(By.id("pgraphdemo")).getText())) 
			{
				System.out.println("Accept Alert Test case Passed");
			}
		}
	}

	void validateAlertCancel(WebDriver driver, String expectedMsg, String expectedCancel) 
	{
		driver.switchTo().alert().dismiss();
		if (expectedCancel.equals(driver.findElement(By.id("pgraphdemo")).getText())) 
		{
			System.out.println("Cancel Alert Test case: Passed");
		}
	}
}
