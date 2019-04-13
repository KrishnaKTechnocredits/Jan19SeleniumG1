package seleniumPractise.rahulV;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.Init;

public class EmployeeManager {

	public static void main(String[] args) {
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='demotable']")).click();

		System.out.println("on demo tables page");

		EmployeeManager employeemanager = new EmployeeManager();
		employeemanager.findNumberOfEmployeesinEachDept(driver);
		employeemanager.findNoOfEmployeesforEachManagers(driver);
		employeemanager.printTable(driver);
	}

	public void printTable(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		int totalCoulmns = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td")).size();

		System.out.println("total rows: " + totalRows + " & total columns: " + totalCoulmns);

		for (int i = 1; i <= totalRows; i++) {
			for (int j = 1; j <= totalCoulmns; j++) {
				WebElement e = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]"));
				System.out.print(e.getText() + " ");
			}
			System.out.println();
		}

	}

	public void findNoOfEmployeesforEachManagers(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HashMap<String, Integer> hm = new HashMap<String, Integer>();

		int totalRows = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr")).size();

		for (int i = 1; i <= totalRows; i++) {
			String managerId = driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[" + i + "]/td[4]"))
					.getText();

			if (hm.containsKey(managerId)) {
				hm.put(managerId, hm.get(managerId) + 1);
			} else {
				hm.put(managerId, 1);
			}
		}

		int maxEmp = 0;
		String Manager = "";
		Set<String> m = hm.keySet();
		for (String key : m) {
			System.out.println(key + " : " + hm.get(key));
			if (maxEmp < hm.get(key)) {
				maxEmp = hm.get(key);
				Manager = key;
			}
		}

		System.out.println("Manager with max employees: " + Manager + " & No of employees: " + maxEmp);

	}

	public void findNumberOfEmployeesinEachDept(WebDriver driver) {

		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		int totalRows = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr")).size();
		for (int i = 1; i <= totalRows; i++) {

			String dept = driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr[" + i + "]/td[5]")).getText();

			if (hm.containsKey(dept)) {
				hm.put(dept, hm.get(dept) + 1);
			} else {
				hm.put(dept, 1);
			}
		}

		int maxEmp = 0;
		String dept = "";
		Set<String> s = hm.keySet();
		for (String key : s) {
			System.out.println("Dept: " + key + " & employees: " + hm.get(key));

			if (maxEmp < hm.get(key)) {
				maxEmp = hm.get(key);
				dept = key;
			}
		}
		System.out.println("Dept having max employees :" + dept + " & No of employees: " + maxEmp);
	}

}
