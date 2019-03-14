//Program to Validate 
package seleniumPractise.mayur;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Init;

public class ValidateAlertFirstH2 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = Init.initChromeDriver();
		ValidateAlertFirstH2 validateAlert = new ValidateAlertFirstH2();
		driver.get("http://automationbykrishna.com/#");
		System.out.println("Browser Opened");

		driver.findElement(By.partialLinkText("Element")).click();
		System.out.println("clicked on -Basic Elements");

		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//button[starts-with(@id,'javascriptAle')]"));
		Scroll.scroll(driver, element);// used to scroll 

		validateAlert.validateAlert(driver, element);//calling validateAlert Method by passing Driver and element
		driver.close();
	}

	//Method to validate Alert Text- Requires Driver and Element
	void validateAlert(WebDriver driver, WebElement element) 
	{
		element.click();
		System.out.println("clicked on -Alert button");
		String expectedResult = "You must be TechnoCredits student!!";
		if (expectedResult.equals(driver.switchTo().alert().getText())) 
		{
			driver.switchTo().alert().accept();
			System.out.println("Expected Message matched with actual message: Test case Passed");
		} 
		else 
		{
			driver.switchTo().alert().accept();
			System.out.println("Expected Message is different than actual message: Test case Failed");
		}
	}

}
