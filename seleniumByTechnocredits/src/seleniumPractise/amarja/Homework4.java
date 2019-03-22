package seleniumPractise.amarja;
/*4) JavaScript Prompt > Name Entered > Message under the button
	Validate message with name.
 */
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class Homework4 {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		Homework4 h4=new Homework4();
		driver.get("http://automationbykrishna.com/index.html#");
		driver.findElement(By.partialLinkText("Elements")).click();
		Thread.sleep(5000);
		driver=h4.findelements(driver);
		Alert alert=driver.switchTo().alert();//switching to alert
		System.out.println("Alert text is:"+alert.getText());
		alert.sendKeys("Amarja");
		alert.getText();
		Thread.sleep(2000);
		h4.validateokalert(alert, driver);
		driver=h4.findelements(driver);
		Alert alert1=driver.switchTo().alert();
		h4.validatecancelalert(alert1, driver);
		driver.close();
		}	
	void validateokalert(Alert alert, WebDriver driver) 
	{
		alert.accept();
		String txtok = driver.findElement(By.xpath("//p[@class='help-block' and @id='pgraphdemo']")).getText();
		if (txtok.contains("Amarja"))
		{
		System.out.println("User pressed ok Name valdiated Testcase passed");
		System.out.println("Alert closed");
		}
	}
	void validatecancelalert(Alert alert, WebDriver driver)
	{
		alert.dismiss();
		String txtok = driver.findElement(By.xpath("//p[@class='help-block' and @id='pgraphdemo']")).getText();
		if (txtok.equals("User cancelled the prompt."))
		{
		System.out.println("User cancelled the prompt");
		System.out.println("Alert closed");
		}

	}
	WebDriver findelements(WebDriver driver) throws InterruptedException {
		
		WebElement e1= driver.findElement(By.xpath("//button[@id='javascriptPromp']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",e1);
		e1.click();
		System.out.println("Able to click java script prompt");
		return driver;
			}
		
}

