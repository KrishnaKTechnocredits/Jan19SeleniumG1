package seleniumPractise.vishal;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;
import util.PropFileOperation;

public class AlertHandling extends MasterClass {
	WebDriver driver = Init.initChromeDriver();

	public void verifyAlertDemo() throws IOException, InterruptedException {

		Properties prop = PropFileOperation.loadProp();

		String firstName = prop.getProperty("firstname");
		String lastName = prop.getProperty("lastname");
		String company = prop.getProperty("company");
		String url = prop.getProperty("url");
		// WebDriver driver = Init.initChromeDriver();

		driver.get(url);
		driver.findElement(By.linkText("Basic Elements")).click();
		System.out.println("On Basic Element Page");
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("firstnameXpath"))).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@name='ulname']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@name='cmpname']")).sendKeys(company);
		// driver.findElement(By.xpath("//div[@name='secondSegment'][1]//button[text()='Submit']")).click();
		click(driver, "//div[@name='secondSegment'][1]//button[text()='Submit']");
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();

		String expectedText = firstName + " and " + lastName + " and " + company;
		System.out.println("Expected Text " + expectedText);
		String actualText = alert.getText();
		System.out.println("Actual Text is: " + actualText);

		if (expectedText.equals(actualText)) {
			System.out.println("Alert is displaying correct data");
			alert.accept();
		}

		else {
			System.out.println("Alert is showing wrong data");
			alert.accept();

		}

	}

	public void verifyAlertString() {

		WebElement Alertelement = driver.findElement(By.xpath("//div[@class='col-lg-12']//button[text()='Alert']"));
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].scrollIntoView(true)", Alertelement);
		scrollToElement(driver, Alertelement);

		Alertelement.click();
		System.out.println("Clicked on Alert after scrolling");
		String ExpectedText = "You must be TechnoCredits student!!";
		System.out.println("Expected Text is: " + ExpectedText);
		Alert alert = driver.switchTo().alert();

		String ActualText = alert.getText();
		System.out.println("Actual Text " + ActualText);

		if (ExpectedText.equals(ActualText)) {
			System.out.println("Alert message is correct");
			alert.accept();
			System.out.println("Alert Accepted");
		} else {
			System.out.println("Alert message is not correct");
			alert.accept();

		}
	}

	public void javaScriptConfirmation() {
		// driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		click(driver, "//button[@id='javascriptConfirmBox']");
		String expectedTextAfterCancel = "You pressed Cancel!";
		String expectedTextAfterOk = "You pressed OK!";
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		String actualTextAfterCancel = driver.findElement(By.xpath("//p[text()='You pressed Cancel!']")).getText();
		if (expectedTextAfterCancel.equals(actualTextAfterCancel)) {
			System.out.println("Text is correct after cancle");
		} else {
			System.out.println("Text is not correct after cancel");

		}

		// driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		click(driver, "//button[@id='javascriptConfirmBox']");
		driver.switchTo().alert();
		alert.accept();
		String actualTextAfterOk = driver.findElement(By.xpath("//p[text()='You pressed OK!']")).getText();
		if (expectedTextAfterOk.equals(actualTextAfterOk)) {
			System.out.println("Text is correct after Ok");
		} else {
			System.out.println("Text is not correct after Ok");

		}

	}

	public void javaScriptPrompt() throws IOException {
		Properties prop = PropFileOperation.loadProp();

		// driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		click(driver, "//button[@id='javascriptPromp']");
		Alert alert = driver.switchTo().alert();
		String input = prop.getProperty("firstname");
		alert.sendKeys(input);
		alert.accept();

		String expectedText = "Hello " + input + "!" + " How are you today?";
		System.out.println("Expected Text " + expectedText);
		String actualText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();

		if (expectedText.equals(actualText)) {
			System.out.println("Message is correct");
		} else {
			System.out.println("Message is not correct");
		}
		driver.close();
	}

}