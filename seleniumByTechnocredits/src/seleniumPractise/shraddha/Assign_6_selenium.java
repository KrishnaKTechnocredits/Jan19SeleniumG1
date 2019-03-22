package seleniumPractise.shraddha;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class Assign_6_selenium {
	
	void FullNameValidation(WebDriver driver, WebElement button, Alert alert)
	{
		String fname_alert_string = "Full name can't be blank", result = "";
		WebElement fname = driver.findElement(By.xpath("//div[@class = 'login-wrap']/following::input[1]"));
		fname.clear();
		button.click();
		alert = driver.switchTo().alert();
		result = alert.getText().equals(fname_alert_string)?"Fname case Verified Pass":"Fname Verified Fail";
		alert.accept();
		System.out.println(result);
		fname.sendKeys("ShraddhaS");
	}
	
	void Address_Validation(WebDriver driver, WebElement button, Alert alert)
	{
		String add_string = "address cannot be blank", result = ""	;
		WebElement add = driver.findElement(By.xpath("//div[@class = 'login-wrap']/following::input[1]/following-sibling::input[1]"));
		add.clear();
		button.click();
		alert = driver.switchTo().alert();
		result = alert.getText().equals(add_string)?"address case Verified Pass":"address Verified Fail";
		alert.accept();
		System.out.println(result);
		add.sendKeys("add_1");
	}
	
	void Email_Validation(WebDriver driver, WebElement button, Alert alert) throws InterruptedException
	{
		String email_1 = "Please enter email id", email_2 = "Please use correct email format", result="";
		WebElement email = driver.findElement(By.xpath("//div[@class = 'login-wrap']/child::input[@id='useremail']"));
		
		//TC_1: No Email entered
		email.clear();
		button.click();
		alert = driver.switchTo().alert();
		result = alert.getText().equals(email_1)?"Email TC_1 case Verified Pass":"Email TC_1 Verified Fail";
		alert.accept();
		System.out.println(result);
		
		//TC_2: Incorrect Email - No @ no .com
		email.clear();
		email.sendKeys("shr");
		Thread.sleep(1000);
		button.click();
		alert = driver.switchTo().alert();
		result = alert.getText().equals(email_2)?"Email TC_2 case Verified Pass":"Email TC_2 Verified Fail";
		alert.accept();
		System.out.println(result);
		
		//TC_3: Incorrect Email - no .com
		email.clear();
		email.sendKeys("shr@gmail");
		button.click();
		alert = driver.switchTo().alert();
		result = alert.getText().equals(email_2)?"Email TC_3 case Verified Pass":"Email TC_3 Verified Fail";
		alert.accept();
		System.out.println(result);
		
		email.clear();
		email.sendKeys("shr@gmail.com");
	}

	void City_Validation(WebDriver driver,WebElement button, Alert alert)
	{
		String city_string = "Please enter City", result="";
		
		WebElement city = driver.findElement(By.xpath("//div[@class = 'login-wrap']/child::input[@id='organization']/preceding-sibling::input[last()-3]"));
		city.clear();
		button.click();
		alert = driver.switchTo().alert();
		result = alert.getText().equals(city_string)?"City case Verified Pass":"City Verified Fail";
		alert.accept();
		System.out.println(result);
		city.sendKeys("city");
	}
	
	void Organisation_Validation(WebDriver driver,WebElement button, Alert alert)
	{
		String org_string = "Please enter your current organization", result = "";
		
		WebElement org = driver.findElement(By.xpath("//div[@class = 'login-wrap']/descendant::input[position()=5]"));
		org.clear();
		button.click();
		alert = driver.switchTo().alert();
		result = alert.getText().equals(org_string)?"Org case Verified Pass":"Org Verified Fail";
		alert.accept();
		System.out.println(result);
		org.sendKeys("org 1");
	}

	void Username_Validation(WebDriver driver,WebElement button, Alert alert)
	{
		String uname_str_1 = "Username is mandatory field.", uname_str_2 = "Username length should be greater then 5 characters.";
		String result = "";
		WebElement uname = driver.findElement(By.xpath("//input[@id='usernameReg']"));
		
		//Test Case 1: Do not enter username
		uname.clear();
		button.click();
		alert = driver.switchTo().alert();
		result = alert.getText().equals(uname_str_1)?"TC_1 case Verified Pass":"TC_1 Verified Fail";
		alert.accept();
		System.out.println(result);
		
		//Test Case 2: Username should be less than 5
		uname.sendKeys("user");
		uname.clear();
		uname.sendKeys("Shra");
		button.click();
		alert = driver.switchTo().alert();
		result = alert.getText().equals(uname_str_2)?"TC_2 case Verified Pass":"TC_2 Verified Fail";
		alert.accept();
		System.out.println(result);
		
		uname.clear();
		uname.sendKeys("Shraddha");	
	}
	
	void Password_Validation(WebDriver driver,WebElement button, Alert alert)
	{
		String pwd_str_1 = "password is mandatory field.", pwd_str_2 = "password length should be greater then 5 characters.";
		String result = "";
		WebElement pwd = driver.findElement(By.xpath("//input[@id='passwordReg']"));

		//Test Case 1: Do not enter pwd
		pwd.clear();
		button.click();
		alert = driver.switchTo().alert();
		result = alert.getText().equals(pwd_str_1)?"TC_1 case Verified Pass":"TC_1 Verified Fail";
		alert.accept();
		System.out.println(result);
		
		//Test Case 2: Pwd should be less than 5
		pwd.sendKeys("user");
		pwd.clear();
		pwd.sendKeys("Shra");
		button.click();
		alert = driver.switchTo().alert();
		result = alert.getText().equals(pwd_str_2) ? "TC_2 case Verified Pass" : "TC_2 Verified Fail";
		alert.accept();
		System.out.println(result);

		pwd.clear();
		pwd.sendKeys("Shraddha1");
	
	}
	
	void ReEnterPwd_Validation(WebDriver driver,WebElement button, Alert alert) throws InterruptedException
	{
		String renterpwd_str_1 = "please reenter password", renterpwd_str_2 = "retype password donot match.";
		String result = "";
		WebElement repwd = driver.findElement(By.xpath("//input[@id='repasswordReg']"));

		//Test Case 1: Do not enter repwd
		repwd.clear();
		button.click();
		alert = driver.switchTo().alert();
		result = alert.getText().equals(renterpwd_str_1)?"Repwd TC_1 case Verified Pass":"Repwd TC_1 Verified Fail";
		alert.accept();
		System.out.println(result);
		
		//Test Case 2: Incorrect repwd
		repwd.clear();
		repwd.sendKeys("123456789");
		button.click();
		result = alert.getText().equals(renterpwd_str_2) ? "Repwd TC_2 case Verified Pass" : "Repwd TC_2 Verified Fail";
		alert.accept();
		System.out.println(result);
		
		repwd.clear();
		repwd.sendKeys("Shraddha1");
	}
	
	void AgreeCheck_Validation(WebDriver driver,WebElement button, Alert alert)
	{
		String agree_str = "Please agree to terms of service and privacy policy", result="";
		
		WebElement agree = driver.findElement(By.xpath("//input[@value='agree this condition']"));

		//Test Case 1: Do check checkbox
		button.click();
		alert = driver.switchTo().alert();
		result = alert.getText().equals(agree_str)?"agree TC_1 case Verified Pass":"TC_1 Verified Fail";
		alert.accept();
		System.out.println(result);
		agree.click();		
	}
	
	void Register_Validation(WebDriver driver,WebElement button, Alert alert)
	{
		String success = "Success", result="";
		button.click();
		result = alert.getText().equals(success)?"success TC_1 case Verified Pass":"TC_1 Verified Fail";
		alert.accept();
		System.out.println(result);
		
	}

	WebElement TickButton(WebDriver driver)
	{
		WebElement button = driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", button);
		return button;
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/index.html#");
		driver.findElement(By.xpath("//a[@href = '#']")).click();
		Thread.sleep(2000);
		Assign_6_selenium a6 = new Assign_6_selenium();
		Alert alert = null;
		
		a6.FullNameValidation(driver, a6.TickButton(driver), alert);
		a6.Address_Validation(driver, a6.TickButton(driver), alert);
		a6.Email_Validation(driver, a6.TickButton(driver), alert);
		Thread.sleep(2000);
		a6.Organisation_Validation(driver, a6.TickButton(driver), alert);
		a6.City_Validation(driver, a6.TickButton(driver), alert);
		a6.Username_Validation(driver, a6.TickButton(driver), alert);
		a6.Password_Validation(driver, a6.TickButton(driver), alert);
		a6.ReEnterPwd_Validation(driver, a6.TickButton(driver), alert);
		a6.AgreeCheck_Validation(driver, a6.TickButton(driver), alert);
		a6.Register_Validation(driver, a6.TickButton(driver), alert);
	}
}
