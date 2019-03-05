package seleniumPractise.technoCredits.browserNavigationWebelementAlertXpath;
//t.b.f.r

import org.openqa.selenium.WebDriver;

import util.Init;

public class NavigationCommand {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = Init.initChromeDriver();
		// driver.navigate().back();
		// System.out.println("title: "+driver.getTitle());

		driver.navigate().to("https://www.gmail.com");
		System.out.println(driver.getTitle());
		driver.navigate().to("https://www.yahoo.com");
		System.out.println(driver.getTitle());
		// driver.navigate().refresh();
		// System.out.println("page refreshed");
		driver.navigate().back();
		Thread.sleep(2000);
		System.out.println("title: " + driver.getTitle());
		driver.navigate().forward();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
	}

}
