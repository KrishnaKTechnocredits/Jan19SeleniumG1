package seleniumPractise.shraddha;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class Assign_4_selenium {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/index.html#");
		driver.findElement(By.xpath("//a[@id = 'basicelements']")).click();
		Thread.sleep(1000);

		WebElement e = driver.findElement(By.xpath("//button[@id ='javascriptPromp']"));

		// Scroll view
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
		e.click();

		Alert alert = driver.switchTo().alert();
		String name = "Shraddha";
		alert.sendKeys(name);
		alert.accept();

		if (driver.findElement(By.xpath("//*[@class = 'help-block' and @id = 'pgraphdemo']")).getText()
				.equals("Hello" + name + "! How are you today?"));
		{
			System.out.println("Verified Passed");
		}
	}

}
