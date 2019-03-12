package seleniumPractise.rahulV;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.Init;
import util.PropFileOperation;

//validate text present in alert with values entered during submitting form on alert demo page
public class Assignment1 {

	public static void main(String[] args) throws InterruptedException, IOException  {
		validateAlertOnSubmittingForm ();
		
	}
		
		public static void validateAlertOnSubmittingForm () throws InterruptedException, IOException {
		
			WebDriver driver = Init.initChromeDriver();
			Properties prop = PropFileOperation.loadProp();
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Basic Elements")).click();

		// driver.findElement(By.partialLinkText("Basic El"));

		System.out.println("on  basic elements page");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@name='ufname' and @id='UserFirstName']")).sendKeys(prop.getProperty("FirstName"));

		driver.findElement(By.xpath("//input[@name='ulname']|//input[contains(@id,'LastName')]")).sendKeys(prop.getProperty("LastName"));

		driver.findElement(By.xpath("//input[@name='cmpname' and @id='UserCompanyName']")).sendKeys(prop.getProperty("CompnyName"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@name='secondSegment'][1]//button[text()='Submit']")).click();
		Thread.sleep(4000);

		//String s1 = "Rahul and Varma and Tech";
		
		String s1= prop.getProperty("FirstName")+" and "+prop.getProperty("LastName")+" and "+prop.getProperty("CompnyName");

		Alert alert = driver.switchTo().alert();

		String s2 = alert.getText();

		if (s1.equals(s2)) {
			System.out.println("text on alert after submitting form is validated");
			alert.accept();
		}

		driver.quit();

	}

}
