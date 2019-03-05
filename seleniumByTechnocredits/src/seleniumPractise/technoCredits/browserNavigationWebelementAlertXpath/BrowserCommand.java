package seleniumPractise.technoCredits.browserNavigationWebelementAlertXpath;
// g.gt.gcu.gps.c.q

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Init;
import util.PropFileOperation;

public class BrowserCommand {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		Properties prop = PropFileOperation.loadProp();

		// driver.get("https://www.gmail.com");
		// System.out.println("Browser Open");
		// String currentUrl = driver.getCurrentUrl();
		// System.out.println("currentUrl: "+currentUrl );
		// String title = driver.getTitle();
		// System.out.println("title: "+title);
		// String pageSource = driver.getPageSource();
		// System.out.println("pageSource: "+pageSource);
		// browser open path
		driver.get("file:///D:/TC/seleniumexample/New%20Window%20Open.html");
		// file explorer path
		driver.get("D:\\TC\\seleniumexample\\New Window Open.html");
		driver.findElement(By.xpath("//button[text()='Third Window']")).click();
		System.out.println("clicked on third button");
		Thread.sleep(2000);
		// driver.close();
		driver.quit();
		System.out.println("Browser closed");
	}

}
