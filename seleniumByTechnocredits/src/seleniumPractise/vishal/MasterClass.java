package seleniumPractise.vishal;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class MasterClass 
{

	public void scrollToElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	public void click(WebDriver driver,String XpathValue)
	{
		driver.findElement(By.xpath(XpathValue)).click();
	}
}
