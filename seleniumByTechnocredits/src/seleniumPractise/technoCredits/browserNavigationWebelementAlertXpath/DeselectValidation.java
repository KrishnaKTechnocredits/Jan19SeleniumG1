package seleniumPractise.technoCredits.browserNavigationWebelementAlertXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import util.Init;

public class DeselectValidation {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		Thread.sleep(1000);
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//label[text()='Selects']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

		Select oselect = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		oselect.selectByVisibleText("1");
		oselect.selectByIndex(2);
		oselect.selectByIndex(4);
		System.out.println("selected");
		oselect.deselectByIndex(2);
		System.out.println("deselected 3");

		oselect.deselectAll();
		System.out.println("deselected all");
	}

}
