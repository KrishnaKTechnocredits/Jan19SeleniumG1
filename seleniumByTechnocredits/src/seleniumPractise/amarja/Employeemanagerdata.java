package seleniumPractise.amarja;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.Init;

public class Employeemanagerdata {

	public static void main(String[] args) {
		// HashMap<String, Integer> hn = new HashMap<String, Integer>();
		TreeMap<String, Integer> hn = new TreeMap<String, Integer>();
		TreeMap<String, String> hn1 = new TreeMap<String, String>();
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/index.html#");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		System.out.println("Able to click on demo");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Employeemanagerdata emp = new Employeemanagerdata();
		hn = emp.finddepartmentdetails(driver);
		hn1 = emp.findempdetails(driver);
		emp.displaydeptdetails(hn, hn1);
		driver.close();
	}

	TreeMap<String, Integer> finddepartmentdetails(WebDriver driver) {
		TreeMap<String, Integer> hn = new TreeMap<String, Integer>();
		int rowcount = driver.findElements(By.xpath("//table[@class='table table-striped']//tr")).size();
		for (int i = 1; i < rowcount; i++) {
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			String deptid = driver.findElement(By.xpath("//table[@class='table table-striped']//tr[" + i + "]/td[5]"))
					.getText();
		//	String empname = driver.findElement(By.xpath("//table[@class='table table-striped']//tr[" + i + "]/td[3]"))
				//	.getText();
			if (hn.containsKey(deptid))
				hn.put(deptid, hn.get(deptid) + 1);
			else
				hn.put(deptid, 1);
		}
		System.out.println(hn);
		
		return hn;

	}

	TreeMap<String, String> findempdetails(WebDriver driver) {
		TreeMap<String, String> empname = new TreeMap<String, String>();
		int rowcount = driver.findElements(By.xpath("//table[@class='table table-striped']//tr")).size();
		for (int i = 1; i < rowcount; i++) {
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			String deptid = driver.findElement(By.xpath("//table[@class='table table-striped']//tr[" + i + "]/td[5]"))
					.getText();
			String empnames = driver.findElement(By.xpath("//table[@class='table table-striped']//tr[" + i + "]/td[3]"))
					.getText();
			empname.put(empnames, deptid);
		}
		return empname;
	}

	void displaydeptdetails(TreeMap<String, Integer> hn, TreeMap<String, String> hn1) {
		int count = 1;
		Set<String> keys1 = hn.keySet();//
		Set<String> keys2 = hn1.keySet();//
		System.out.println(" Total Dept:" + keys1.size());
		for (String s : keys1) {
			System.out.println(count + ")" + s + " : " + hn.get(s));
			count++;
			int counter = 1;
			for (String s1 : keys2) {
				if (s.equals(hn1.get(s1))) {
					System.out.println(counter + "." + s1);
					counter++;
				}
			}
			System.out.println("------------------------------------");
		}
				}

	}


