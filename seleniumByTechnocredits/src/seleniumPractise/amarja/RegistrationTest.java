package seleniumPractise.amarja;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.Init;

public class RegistrationTest {
	@Test(dataProvider = "Regdataprovider")
	void Registrationmandatoryvaldiation(String fullname, String address, String emailid, String city,
			String companyname, String username, String password, String retypepassword, String agreeflag,
			String expectedresult) {
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/index.html#");
		System.out.println("Brower opened");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("registration2")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement e1 = driver.findElement(By.xpath("//h1[@class='sign-title' and text()='Registration']"));
		if (e1.isDisplayed()) {
			driver.findElement(By.xpath("//input[@id='fullName']")).sendKeys(fullname);
			driver.findElement(By.xpath("//input[contains (@class,'form-control') and @placeholder='Address']")).sendKeys(address);
			driver.findElement(By.xpath("//input[contains (@class,'form-control') and @name='useremail']")).sendKeys(emailid);
			driver.findElement(By.id("organization")).sendKeys(companyname);
			driver.findElement(By.xpath("//input[@id='usercity']")).sendKeys(city);
			driver.findElement(By.xpath("//input[contains (@class,'form-control') and @id='usernameReg']")).sendKeys(username);
			driver.findElement(By.xpath("//input[contains (@class,'form-control') and @id='passwordReg']")).sendKeys(password);
			driver.findElement(By.xpath("//input[contains (@class,'form-control') and @id='repasswordReg']")).sendKeys(retypepassword);
			if (agreeflag.equals("yes"))
				driver.findElement(By.xpath("//input[@id='signupAgreement']")).click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")));
			driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
			Alert alert = driver.switchTo().alert();
			Assert.assertEquals(alert.getText(), expectedresult);
			System.out.println("end");
			alert.accept();
			driver.close();
		}
	}
	@DataProvider(name = "Regdataprovider")
	public Object[][] provideRegisrationData() throws IOException {
		ExcelsheetModular esm = new ExcelsheetModular("C://Users//Rutuja//Downloads//testdata2.xlsx");
		Object[][] data = esm.getAllrows("data", true);
		return data;

}
}
