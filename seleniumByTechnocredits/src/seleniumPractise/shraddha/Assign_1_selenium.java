package seleniumPractise.shraddha;

import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.Init;

public class Assign_1_selenium {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/index.html#");
		driver.findElement(By.xpath("//a[@id = 'basicelements']")).click();
		Thread.sleep(1000);
		String fname = "Shraddha", lname = "Sonawane", companyname = "Sungard";

		driver.findElement(By.xpath("//input[@id = 'UserFirstName']")).sendKeys(fname);
		driver.findElement(By.xpath("//input[@name = 'ulname']")).sendKeys(lname);
		driver.findElement(By.xpath("//input[@name = 'cmpname']")).sendKeys(companyname);
		driver.findElement(By.xpath("//button[@class = 'btn btn-primary']")).click();

		Alert alert = driver.switchTo().alert();
		String alertDemoText = alert.getText();
		alert.accept();

		if (alertDemoText.equals(fname + " and " + lname + " and " + companyname)) {
			System.out.println("String match");
		} else {
			System.out.println("Strings do not match");
		}

	}

}
