package seleniumPractise.technoCredits.webtableActionsIframeWindowHandle;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Init;

public class RobotClassDemo {
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver = Init.initChromeDriver();
		robotClassDemo(driver);
	}
	

	public static void robotClassDemo(WebDriver driver) throws InterruptedException, AWTException {
		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.id("basicelements")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.id("exampleInputFile")).click();
		Thread.sleep(1000);
		StringSelection filePath = new StringSelection("D:\\TC\\TC_doc\\API_Autoamtion_HttpClient_Methods.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
		Robot robot  = new Robot();
		robot.setAutoDelay(1000);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		System.out.println("paste");
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		System.out.println("entered");
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}


}
