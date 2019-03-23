package seleniumPractise.technoCredits.webtableActionsIframeWindowHandle;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Init;

public class WebTablePractice {

	public static void main(String[] args) throws InterruptedException, AWTException {

		WebDriver driver = Init.initChromeDriver();
		// printTableFirstName(driver);
		// printLastNameOfGivenName(driver, "Dhara");
		 robotClassDemo(driver);
		//demoTableUsingCollection(driver);
	}

	public static void demoTableUsingCollection(WebDriver driver) throws InterruptedException {
		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.cssSelector("a[id=demotable]")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		int rowSize = driver.findElements(By.cssSelector("div[id='empmanager'] table tbody tr")).size();

		HashMap<String, Integer> hm = new HashMap<String, Integer>();

		for (int i = 1; i <= rowSize; i++) {

			String deptName = driver
					.findElement(
							By.cssSelector("div[id='empmanager'] table tbody tr:nth-child(" + i + ") td:nth-child(5)"))
					.getText();
			if (hm.containsKey(deptName)) {
				hm.put(deptName, hm.get(deptName) + 1);
			} else {
				hm.put(deptName, 1);
			}
		}
		//System.out.println("hm: " + hm);
		Set<String> keys = hm.keySet();
		System.out.println("totle dept : "+keys.size());
		int max =0;
		String maxEmpDept = "" ;
		for( String s : keys ) {
			if(max<hm.get(s)) {
				max = hm.get(s);
				maxEmpDept = s;
			}
			System.out.println("Depatment Name: " +s+ " and No of Emp: " +hm.get(s) );
		}
		System.out.println("Department Name is " +maxEmpDept+"  and no of employee is  "+max);

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

	public static void printLastNameOfGivenName(WebDriver driver, String name) throws InterruptedException {
		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.cssSelector("a[id=demotable]")).click();
		Thread.sleep(1000);
		int rawSize = driver.findElements(By.cssSelector("#table1 tbody tr")).size();

		for (int raw = 1; raw <= rawSize; raw++) {
			String uiName = driver
					.findElement(By.cssSelector("#table1 tbody tr:nth-child(" + raw + ")>td:nth-child(2)")).getText();
			if (uiName.equals(name)) {
				System.out.println(
						driver.findElement(By.cssSelector("#table1 tbody tr:nth-child(" + raw + ")>td:nth-child(3)"))
								.getText());
			}

		}
	}

	public static void printTableFirstName(WebDriver driver) throws InterruptedException {
		driver.get("http://automationbykrishna.com/#");
		driver.findElement(By.cssSelector("a[id=demotable]")).click();
		Thread.sleep(1000);
		int rawSize = driver.findElements(By.cssSelector("#table1 tbody tr")).size();
		System.out.println(driver.findElement(By.cssSelector("#table1 ")).getText());
		// for (int raw = 1; raw <= rawSize; raw++) {
		// System.out.println(driver
		// .findElement(By.cssSelector("#table1 tbody tr:nth-child(" + raw +
		// ")>td:nth-child(2)")).getText());
		// }
	}
}
