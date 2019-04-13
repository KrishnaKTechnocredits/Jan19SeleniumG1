package seleniumPractise.ankush;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptConfirmationMessage {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\AnkushW\\Resources\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/index.html#");

		driver.findElement(By.linkText("Basic Elements")).click();
		System.out.println("Click on Basic Elements Link");

		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		System.out.println("Scrolled Successfully");

		element.click();
		System.out.println("Click on JavaScript Confirmation Button");

		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		String ActualOkMessage = driver.findElement(By.id("pgraphdemo")).getText();

		if (ActualOkMessage.equals("You pressed OK!")) {
			System.out.println("User Pressed on OK button");
		}

		element.click();
		System.out.println("Click on JavaScript Confirmation Button Again");
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		String ActualCancelMessage = driver.findElement(By.id("pgraphdemo")).getText();

		if (ActualCancelMessage.equals("You pressed Cancel!")) {
			System.out.println("User Pressed on Cancel button");
		}

	driver.close();	
	}
}
