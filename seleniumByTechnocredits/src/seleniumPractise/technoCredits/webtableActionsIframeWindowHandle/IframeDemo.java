package seleniumPractise.technoCredits.webtableActionsIframeWindowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class IframeDemo {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		WebElement element = driver.findElement(By.cssSelector("a[id=iframes]"));
		element.click();
		Thread.sleep(3000);
//		driver.switchTo().frame("site1");
//		driver.switchTo().frame(0);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"indexBody\"]/iframe")));
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		System.out.println("clicked on project");
		
		driver.switchTo().defaultContent();
	    driver.switchTo().parentFrame();
		System.out.println("switched to main");
		driver.switchTo().frame(2);
		System.out.println("switched to 3rd window");
		driver.findElement(By.xpath("//a[text()='License']")).click();
		System.out.println("Clicked on licence");
	}

}
