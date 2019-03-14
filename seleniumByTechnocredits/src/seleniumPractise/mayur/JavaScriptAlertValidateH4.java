package seleniumPractise.mayur;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.Init;
import util.PropFileOperation;

public class JavaScriptAlertValidateH4 {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		Properties prop = PropFileOperation.loadProp();
		JavaScriptAlertValidateH4 jsAlert = new JavaScriptAlertValidateH4();
		driver.get("http://automationbykrishna.com/#");
		System.out.println("Browser Opened");

		driver.findElement(By.id("basicelements")).click();
		System.out.println("Clicked on Basic Element Tab");
		Thread.sleep(2000);

		Scroll.scroll(driver, driver.findElement(By.xpath("//button[starts-with(@id,'javascriptAle')]")));

		String expectedAccept = "Hello " + prop.getProperty("Name") + "! How are you today?";
		String expectedCancel = "User cancelled the prompt.";
		jsAlert.validateAlertAceept(driver, prop, expectedAccept);
		jsAlert.validateAlertCance(driver, prop, expectedCancel);
		driver.close();
	}

	void validateAlertAceept(WebDriver driver, Properties prop, String expectedAccept) {
		driver.findElement(By.id("javascriptPromp")).click();
		driver.switchTo().alert().sendKeys(prop.getProperty("Name"));
		driver.switchTo().alert().accept();
		String actual = driver.findElement(By.xpath("//p[@class='help-block'][@id='pgraphdemo']")).getText();
		if (actual.equals(expectedAccept)) {
			System.out.println("Test Case for Validate Enter Name : Passed");
		}
	}

	void validateAlertCance(WebDriver driver, Properties prop, String expectedCancel) {
		driver.findElement(By.id("javascriptPromp")).click();
		driver.switchTo().alert().sendKeys(prop.getProperty("Name"));
		driver.switchTo().alert().dismiss();
		if (driver.findElement(By.xpath("//p[@class='help-block'][@id='pgraphdemo']")).getText()
				.equals(expectedCancel)) {
			System.out.println("Test Case for Validate Cancel : Passed");
		}
	}
}
