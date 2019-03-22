package seleniumPractise.saket;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class Assignment6 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[contains(@id,'registration2')]")).click();
		Thread.sleep(1000);

		WebElement element = driver.findElement(By.id("btnsubmitsignUp"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

		element.click();

		Alert alert = driver.switchTo().alert();

		String a1 = alert.getText();
		alert.accept();

		if (a1.equals("Full name can't be blank")) {
			System.out.println("FN alert validated");

		}

		driver.findElement(By.id("fullName")).sendKeys("Saket");

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

		element.click();

		String sec = alert.getText();
		alert.dismiss();

		if (sec.equals("address cannot be blank")) {
			System.out.println("Second alert validated");

			driver.findElement(By.xpath("//input[@id='address']")).sendKeys("bane pune");
			JavascriptExecutor js3 = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", element);

			element.click();

			String third = alert.getText();
			alert.dismiss();

			if (third.equals("Please enter email id")) {

				System.out.println("Third alert validated ");
			}

			driver.findElement(By.xpath("//input[@id='useremail']")).sendKeys("saketnagmote");
			JavascriptExecutor js4 = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", element);

			element.click();
			String forth = alert.getText();
			alert.dismiss();

			if (forth.equals("Please use correct email format")) {
				System.out.println("fourth alert validated ");

			}
			driver.findElement(By.xpath("//input[@id='useremail']")).sendKeys("saketnagmote@gmail.com");

			JavascriptExecutor js5 = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", element);

			element.click();
			String fifth = alert.getText();
			alert.dismiss();

			if (fifth.equals("Please enter City")) {
				System.out.println("fifth alert validated ");

			}

			driver.findElement(By.xpath("//input[@placeholder='City/Town']")).sendKeys("pune");

			JavascriptExecutor js6 = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", element);

			element.click();
			String sixth = alert.getText();
			alert.dismiss();

			if (sixth.equals("Please enter your current organization")) {

				System.out.println("sixth alert is validated");
			}

			driver.findElement(By.id("organization")).sendKeys("capgemini");
			JavascriptExecutor js7 = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", element);

			element.click();
			String seventh = alert.getText();
			alert.dismiss();
			if (seventh.equals("Username is mandatory field.")) {

				System.out.println("Seventh alert is validated");
			}

			driver.findElement(By.xpath("//input[@id='usernameReg']")).sendKeys("234");
			element.click();

			String eight = alert.getText();
			alert.dismiss();

			if (eight.equals("Username length should be greater then 5 characters.")) {

				System.out.println("eight alert validated");

			}

			driver.findElement(By.xpath("//input[@id='usernameReg']")).sendKeys("2343r3435345");
			element.click();

			String nineth = alert.getText();
			alert.dismiss();

			if (nineth.equals("password is mandatory field.")) {

				System.out.println("nineth alert validated");

			}

			driver.findElement(By.id("passwordReg")).sendKeys("123");
			element.click();

			String tenth = alert.getText();
			alert.dismiss();

			if (tenth.equals("password length should be greater then 5 characters.")) {

				System.out.println("tenth alert validated");

			}
			driver.findElement(By.id("passwordReg")).clear();
			driver.findElement(By.id("passwordReg")).sendKeys("saket123");
			System.out.println(driver.findElement(By.id("passwordReg")).getAttribute("value"));

			element.click();

			String eleventh = alert.getText();
			alert.dismiss();
			if (eleventh.equals("please reenter password")) {

				System.out.println("eleventh alert validated");

			}

			driver.findElement(By.id("repasswordReg")).sendKeys("12");
			element.click();
			String twelve = alert.getText();
			alert.dismiss();
			if (twelve.equals("retype password donot match.")) {

				System.out.println("twelth alert validated");

			}

			driver.findElement(By.id("repasswordReg")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("repasswordReg")).sendKeys("saket123");
			element.click();

			//System.out.println(driver.findElement(By.id("repasswordReg")).getAttribute("value"));

			String thirteen = alert.getText();
			System.out.println(thirteen);
			alert.dismiss();
			if (thirteen.equals("Please agree to terms of service and privacy policy")) {

				System.out.println("thirteen alert validated");

			}

			driver.findElement(By.xpath("//input[@value='agree this condition']")).click();
			element.click();

			String fourteen = alert.getText();
			alert.dismiss();
			if (fourteen.equals("Success")) {

				System.out.println("fourteenthFf alert validated");

			}

		}
	}

}
