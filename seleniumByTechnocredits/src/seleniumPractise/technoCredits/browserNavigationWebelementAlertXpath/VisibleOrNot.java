package seleniumPractise.technoCredits.browserNavigationWebelementAlertXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class VisibleOrNot {
	public static void main(String[] args) {
		WebDriver driver = Init.initChromeDriver();
		driver.get("file:///D:/TC/seleniumexample/Hidden_&_Visible.html");
		System.out.println("entered url");
		// driver.findElement(By.xpath("//button[text()='Hide Text field1']")).click();

		driver.findElement(By.xpath("//button[text()='Hide Text field']")).click();
		System.out.println("clicked on hide button");

		WebElement element = driver.findElement(By.id("myP"));
		boolean flag = element.isDisplayed();
		System.out.println("flag: " + flag);

		if (flag) {
			System.out.println("text is visible");
		} else {
			driver.findElement(By.xpath("//button[text()='Visiable Text field']")).click();
			System.out.println("clicked on visible button");
			if (element.isDisplayed()) {
				System.out.println("Text is displyed from else block");
			}
		}

	}

}
