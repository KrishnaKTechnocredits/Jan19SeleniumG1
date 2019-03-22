package seleniumPractise.amarja;
/*Program to automated
3) javaScript Confirmation> Ok/Cancel > Message under the button
Validate the message with OK/Cancel.*/
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Init;

public class Homework3 {
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/index.html#");
		System.out.println("URL opened");
		Homework3 hw = new Homework3();
		driver = hw.findelements(driver);
		Alert alert = driver.switchTo().alert();
		String expected = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		String actual = alert.getText();
		if (expected.equals(actual))
			System.out.println("Alert text valdiation passed");
		else
			System.out.println("Alert text valdiation failed");
		hw.validateokalert(alert, driver);
		driver = hw.findelements(driver);
		hw.validatecancelalert(alert, driver);
		driver.close();
	}

	// Function to decide whether to accept the alert or dismiss the alert
	void validateokalert(Alert alert, WebDriver driver) 
	{
		alert.accept();
		String txtok = driver.findElement(By.xpath("//p[@class='help-block' and @id='pgraphdemo']")).getText();
		if (txtok.equals("You pressed OK!"))
		System.out.println("Students pressed ok as they are doing homework regularly");

	}

	void validatecancelalert(Alert alert, WebDriver driver)
	{
		alert.dismiss();
		String txtok = driver.findElement(By.xpath("//p[@class='help-block' and @id='pgraphdemo']")).getText();
		if (txtok.equals("You pressed Cancel!"))
		System.out.println("Student pressed cancelled as they are not doing homework");

	}
	// Function to find element and click the javascript pop up
		WebDriver findelements(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("Clicked on Basic elements");
		Thread.sleep(4000);
		WebElement e1 = driver.findElement(By.xpath("//button[@class='btn btn-warning' and @id='javascriptConfirmBox']"));
		System.out.println("Element found");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e1);
		e1.click();
		return driver;

	}

}
