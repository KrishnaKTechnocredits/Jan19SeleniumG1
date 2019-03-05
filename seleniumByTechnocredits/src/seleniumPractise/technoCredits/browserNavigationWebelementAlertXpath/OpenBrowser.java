package seleniumPractise.technoCredits.browserNavigationWebelementAlertXpath;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Init;
import util.PropFileOperation;

public class OpenBrowser {

	public static void main(String[] args) throws IOException {
		WebDriver driver = Init.start();
		Properties prop = PropFileOperation.loadProp();
		driver.get("file://D:/TC/seleniumexample/Enable_&_Disable.html");
		System.out.println("browser opened");

	}
}
