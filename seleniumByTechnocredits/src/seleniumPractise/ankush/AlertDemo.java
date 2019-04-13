package seleniumPractise.ankush;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\AnkushW\\Resources\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://automationbykrishna.com/index.html#");

		driver.findElement(By.linkText("Basic Elements")).click();
		System.out.println("Clicked on Basic Elements");

		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("//button[starts-with(@id,'javascriptAl')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		System.out.println("Scrolled Successfully");

		element.click();
		System.out.println("Click on Alert Button");

		String ActualMsg = driver.switchTo().alert().getText();
		System.out.println(ActualMsg);

		if (ActualMsg.equals("You must be TechnoCredits student!!")) {
			driver.switchTo().alert().accept();
			System.out.println("Alert accepted");
		} else {
			driver.switchTo().alert().accept();
			System.out.println("Wrong Message Displayed");
		}
	driver.close();
	}
}