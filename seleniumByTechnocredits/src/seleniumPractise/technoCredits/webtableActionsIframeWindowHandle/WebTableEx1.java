package seleniumPractise.technoCredits.webtableActionsIframeWindowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import util.Init;

public class WebTableEx1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = Init.initChromeDriver();
		// printFirstNameOfAll(driver);
		// printLastNameOfGivenName(driver, "Dhara");
		// printNextRowUsernameeOfGivenName(driver, "Dhara");
		printWholeTable(driver);
	}

	public static void printWholeTable(WebDriver driver) throws InterruptedException {

		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[id=demotable]")).click();
		Thread.sleep(2000);

		// System.out.println(driver.findElement(By.cssSelector("#table1")).getText());
	//	System.out.println(driver.findElements(By.cssSelector("#table1 tr:nth-child(2) td")).size());
	//	System.out.println(driver.findElement(By.cssSelector("#table1")).getText());
		for (int row = 1; row <= driver.findElements(By.cssSelector("#table1 tr")).size(); row++) {
			
			System.out.println(driver.findElement(By.cssSelector("#table1 tr:nth-child(1)")).getText());
			System.out.println(driver.findElement(By.cssSelector("#table1 tr:nth-child(2)")).getText());
			System.out.println(driver.findElement(By.cssSelector("#table1 tr:nth-child(3)")).getText());
			System.out.println(driver.findElement(By.cssSelector("#table1 tr:nth-child(4)")).getText());
			System.out.println(driver.findElement(By.cssSelector("#table1 tr:nth-child(5)")).getText());
			System.out.println(driver.findElement(By.cssSelector("#table1 tr:nth-child(6)")).getText());
			System.out.println(driver.findElement(By.cssSelector("#table1 tr:nth-child("+row+")")).getText());

			//for (int col = 1; col <= driver.findElements(By.cssSelector("#table1 tr:nth-child(2) td")).size(); col++) {
//
//				if (row == 1) {
//					System.out.print(driver
//							.findElement(By.cssSelector("#table1 tr:nth-child(" + row + ") th:nth-child(" + col + ")"))
//							.getText());
//
//				} else {
//					System.out.print(driver
//							.findElement(By.cssSelector("#table1 tr:nth-child(" + row + ") td:nth-child(" + col + ")"))
//							.getText());
//				}
			//}
			System.out.println("");

		}

	}

}
