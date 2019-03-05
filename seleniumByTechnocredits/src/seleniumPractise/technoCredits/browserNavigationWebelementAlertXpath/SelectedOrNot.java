package seleniumPractise.technoCredits.browserNavigationWebelementAlertXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class SelectedOrNot {

	public static void main(String[] args) {
		WebDriver driver = Init.initChromeDriver();
		driver.get("file:///D:/TC/seleniumexample/Harsh_Trial_From.html");
		System.out.println("url opened");
		// WebElement element =
		// driver.findElement(By.xpath("//input[@value='female']"));
		// boolean flag = element.isSelected();
		// if(flag==false) {
		// element.click();
		// System.out.println("clicked on element");
		// if(element.isSelected()==true) {
		// System.out.println("female radio button is selected");
		// }
		// }

		// driver.findElement(By.xpath("//a[text()='Click to reset form in new
		// tab']")).submit();
		// System.out.println("submit on button");
		// driver.findElement(By.xpath("//a[text()='Click to reset form in new
		// tab']")).click();
		// System.out.println("cliked on a button ");

		String companyName = driver.findElement(By.xpath("//label[text()=' Year of Experience In Industry ']"))
				.getText();
		System.out.println("companyName: " + companyName);

		WebElement e1 = driver.findElement(By.xpath("//input[@type='text'][1]"));
		System.out.println(e1.getAttribute("id"));

		System.out.println(e1.getTagName());

		e1.sendKeys("Technocredits");
		System.out.println("text field value: " + e1.getAttribute("value"));
		System.out.println("get text: " + e1.getText());

		WebElement e2 = driver.findElement(By.id("first name"));

		if (e2.getAttribute("type").equals("text")) {
			e2.sendKeys("technoCredits");
			System.out.println("sended value");
		}

	}

}
