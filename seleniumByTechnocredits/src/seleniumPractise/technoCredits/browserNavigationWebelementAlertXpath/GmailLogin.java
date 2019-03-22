package seleniumPractise.technoCredits.browserNavigationWebelementAlertXpath;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.Init;
import util.PropFileOperation;

public class GmailLogin {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver = Init.initChromeDriver();
		Properties prop = PropFileOperation.loadProp();
		driver.get("https://www.gmail.com");
		System.out.println("Browser Open");
		driver.findElement(By.id("identifierId")).sendKeys(prop.getProperty("email"));
		System.out.println("email address entered");
		driver.findElement(By.id("identifierNext")).click();
		//Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='password']")));
		
		System.out.println("cliked on next");
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
		System.out.println("Entered password");
		driver.findElement(By.id("passwordNext")).click();
		System.out.println("logged in successfully");
		driver.close();
		System.out.println("browser closed");
	}

}
