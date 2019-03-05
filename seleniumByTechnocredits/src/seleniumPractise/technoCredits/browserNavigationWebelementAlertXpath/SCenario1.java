package seleniumPractise.technoCredits.browserNavigationWebelementAlertXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

// textfield available ?
// enabled
//type= text
// send technocredits
// if sent value is >10 then set your name
// First name label - font-size and
//font-weight (bold)
// if font is bold, remove your name and enter 'Krishna' else 
//enter "Maulik"
public class SCenario1 {

	public static void main(String[] args) {
		WebDriver driver = Init.initChromeDriver();
		driver.get("file:///D:/TC/seleniumexample/Harsh_Trial_From.html");
		WebElement e1 = driver.findElement(By.id("first name"));
		if (e1.isDisplayed()) {
			if (e1.isEnabled()) {
				if (e1.getAttribute("type").equals("text")) {
					e1.sendKeys("Technocredits");
					String value = e1.getAttribute("value");
					System.out.println("TExt field value: " + value);
					if (value.length() > 10) {
						e1.clear();
						System.out.println("cleared field");
						e1.sendKeys("krishna");
						WebElement link = driver.findElement(By.xpath("//a[1]"));
						String hrefValue = link.getAttribute("href");
						if (hrefValue.length() == 0) {
							System.out.println("invalid link");
						}
						WebElement e3 = driver.findElement(By.xpath("//label[text()=' First Name ']"));
						String fontSize = e3.getCssValue("font-size");
						System.out.println("font-size: " + fontSize);
						// driver.get("file:///D:/TC/seleniumexample/Hidden_&_Visible.html");
						// String fontweight =
						// driver.findElement(By.id("myP")).getCssValue("font-weight");
						// if(fontweight.equals("700")) {
						// System.out.println("Fonts is Bold");
						// }
						System.out.println(e3.getLocation().getX());
						System.out.println("X point: " + e3.getLocation().x + " Y point: " + e3.getLocation().y);
						e3.getSize().getHeight();
						System.out.println("Height: " + e3.getSize().height + " width: " + e3.getSize().width);
					}
				}
			}
		}
	}

}
