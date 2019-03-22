package seleniumPractise.technoCredits.webtableActionsIframeWindowHandle;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.Init;

public class WindowHandleEx {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = Init.initChromeDriver();
		driver.get("file:///D:/TC/TC_doc/seleniumexample/New%20Window%20Open.html");
		driver.findElement(By.xpath("//button[text()='First Window']")).click();
		System.out.println("cliked on first window");
	    String mainW = driver.getWindowHandle();
	    System.out.println("mainW "+mainW);
	    Set<String> allW = driver.getWindowHandles();
	    System.out.println("allW : " +allW);
	    Thread.sleep(2000);
	    for(String cw : allW) {
	    	if(!cw.equals(mainW)) {
	    		System.out.println("CW: "+cw);
	    		driver.switchTo().window(cw).close();
	    		System.out.println("closed extra window");
	    	}
	    }
	    driver.switchTo().window(mainW);
	    System.out.println("on main window");
	    driver.findElement(By.xpath("//button[text()='Second Window']")).click();
		System.out.println("cliked on Second window");
	    
	}

}
