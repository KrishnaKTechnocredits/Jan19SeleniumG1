package seleniumPractise.technoCredits.browserNavigationWebelementAlertXpath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import util.Init;

public class FacebookSIgnup {

	public static void main(String[] args) {

		WebDriver driver = Init.initChromeDriver();
		driver.get("https://www.facebook.com/");
		// System.out.println("on facebok");
		// driver.findElement(By.id("u_0_j")).sendKeys("krishna");
		// System.out.println("ENtered first name");
		// driver.findElement(By.id("u_0_l")).sendKeys("kanani");
		// System.out.println("ENtered last name");
		// driver.findElement(By.id("u_0_o")).sendKeys("9561689098");
		// System.out.println("ENtered mobile number");
		// driver.findElement(By.id("u_0_v")).sendKeys("gyjgjhgjhgjhk");
		// System.out.println("ENtered password");

		// WebElement e1 = driver.findElement(By.id("day"));
		// Select oselect = new Select(e1);
		// oselect.selectByIndex(4);
		// System.out.println(e1.getAttribute("value"));

		Select oselect2 = new Select(driver.findElement(By.id("month")));
		oselect2.selectByVisibleText("Sept");
		System.out.println(driver.findElement(By.id("month")).getAttribute("value"));
		List<WebElement> months = oselect2.getOptions();
		System.out.println("MONths: " + months);
		int count = 0;
		for (WebElement m : months) {
			// System.out.println("month name: "+m.getText());
			if (m.getText().equals("Sept")) {
				System.out.println("index od sept is " + count);
				break;
			}
			count++;
		}

		// oselect2.deselectByValue("9");
		// System.out.println("deselcted");

		// List<WebElement> opt = oselect2.getOptions();
		// System.out.println(opt);
		// for(WebElement element : opt) {
		// System.out.println(element.getText());
		// if(element.isSelected())
		// System.out.println("**********"+element.getText());
		// }
		// oselect2.deselectAll();
		// System.out.println("deselected");
		//
		// WebElement e3 = driver.findElement(By.id("year"));
		// Select oselect3 = new Select(e3);
		// oselect3.selectByValue("2019");
		// System.out.println(e3.getAttribute("value"));
		//
		//
		// driver.findElement(By.id("u_0_9")).click();
		// System.out.println("selected");
	}
}
