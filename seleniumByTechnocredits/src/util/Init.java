package util;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Init {

	public static WebDriver start() {
		String path = "D:\\TC\\Jan19SeleniumRepo\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	// Method to open chrome browser
	public static WebDriver initChromeDriver() {
		WebDriver driver = null;
		// If block is for mac users 
		String osName = System.getProperty("os.name");
		if (osName.indexOf("Mac") > -1) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + File.separator + "resources" + File.separator + "chromedriver");
		} else {
			System.setProperty("webdriver.driver.chromedriver", ConstantPath.CHROME_EXE_PATH);
		}
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

}
