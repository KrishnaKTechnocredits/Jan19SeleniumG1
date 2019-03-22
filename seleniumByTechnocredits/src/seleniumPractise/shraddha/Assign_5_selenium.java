package seleniumPractise.shraddha;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class Assign_5_selenium {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/index.html#");
		Assign_5_selenium a5 = new Assign_5_selenium();
		a5.Password_Cases(driver);
	}

	void Password_Cases(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//a[@href = '#']")).click();
		Thread.sleep(1000);

		WebElement button = driver.findElement(By.xpath("//node()[@node()='validatecredentials()']")); // loginbuttonxpath
		WebElement pwd = driver.findElement(By.xpath("//input[starts-with(@class,'form-control') and (@id = 'pwdSignin')]")); //passwordfieldxpath
																											
		String s1 = "Failed! please enter password", s2 = "Failed! please enter strong password", s3 = "Success!";
		String result = "";
		
		//Enter Username
		driver.findElement(By.xpath("//input[contains(@id, 'unameS')]")).sendKeys("shraddha"); // usernamexpath

		// TestCase-1: direct clicking on Login button
		button.click();
		Alert alert = driver.switchTo().alert();
		result = alert.getText().equals(s1) ? "TC_1: Verified Passed" : "TC_1: Verified Failed";
		System.out.println(result);
		alert.accept();

		// TestCase 2: less than 8 charachters
		pwd.clear();
		pwd.sendKeys("shr");
		button.click();
		alert = driver.switchTo().alert();
		result = alert.getText().equals(s2) ? "TC_2: Verified Passed" : "TC_2: Verified Failed";
		System.out.println(result);
		alert.accept();

		// TestCase 3: Equal to 8 charachters
		pwd.clear();
		pwd.sendKeys("shraddha");
		button.click();
		alert = driver.switchTo().alert();
		result = alert.getText().equals(s2) ? "TC_3: Verified Passed" : "TC_3: Verified Failed";
		System.out.println(result);
		alert.accept();
		
		// TestCase 4: greater than 8 charachters
		pwd.clear();
		pwd.sendKeys("shraddha1");
		button.click();
		alert = driver.switchTo().alert();
		result = alert.getText().equals(s3) ? "TC_4: Verified Passed" : "TC_4: Verified Failed";
		System.out.println(result);
		alert.accept();
	}
}
