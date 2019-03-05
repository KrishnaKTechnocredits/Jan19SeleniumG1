package seleniumPractise.technoCredits.browserNavigationWebelementAlertXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class EnableDisablePractise {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		driver.get("file:///D:/TC/seleniumexample/Enable_&_Disable.html");
		System.out.println("entered url");

		driver.findElement(By.xpath("//button[text()='Disable Text field']")).click();
		WebElement element = driver.findElement(By.id("myText"));
		boolean flag1 = element.isEnabled();
		System.out.println("flag1 :  " + flag1);
		if (!element.isEnabled()) {
			System.out.println("disabled");
		}
		// Thread.sleep(3000);

		boolean flag = element.isEnabled();
		if (flag == true) {
			element.sendKeys("TechnoCredits");
			System.out.println("entered value");
		} else {
			driver.findElement(By.xpath("//button[text()='Enable Text field']")).click();
			System.out.println("Clicked on enble button");
			if (element.isEnabled()) {
				element.sendKeys("TechnoCredits");
				System.out.println("entered value from else block");
			}

		}
		// driver.close();
	}

}
