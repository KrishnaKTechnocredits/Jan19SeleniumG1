/*Program to find
 * 1) Total Number of Managers.
2) Unique Managers.
3) Employees under each Manager
4) Manager with maximum employees
5) Find dulicate entry in Employee ID and Name

 * 
 * 
 * 
 * 
 */
package seleniumPractise.amarja;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.Init;

public class EmployeeManager {

	public static void main(String[] args) {

		HashMap<String, Integer> hn = new HashMap<String, Integer>();
		LinkedList<String> empid = new LinkedList<String>();
		LinkedList<String> empmanager = new LinkedList<String>();
		WebDriver driver = Init.initChromeDriver();
		driver.get("http://automationbykrishna.com/index.html#");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		System.out.println("Able to click on demo");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		EmployeeManager emp = new EmployeeManager();
		hn = emp.Findmanagerdetails(driver);
		emp.displaymanagerdetails(hn);
		emp.findmaxemployee(hn);
		empid = emp.storeemployeeid(driver);
		empmanager = emp.storeemployeename(driver);
		emp.findduplicate(empid, empmanager);
		driver.close();

	}

	HashMap<String, Integer> Findmanagerdetails(WebDriver driver) {
		HashMap<String, Integer> hn = new HashMap<String, Integer>();
		int rowcount = driver.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr")).size();
		for (int i = 1; i < rowcount; i++) {
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			String managerid = driver
					.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr[" + i + "]/td[4]"))
					.getText();
			if (hn.containsKey(managerid))
				hn.put(managerid, hn.get(managerid) + 1);
			else
				hn.put(managerid, 1);
		}
		return hn;

	}

	void displaymanagerdetails(HashMap<String, Integer> hn) {
		Set<String> keys = hn.keySet();//
		System.out.println("1) Total number of Managers:" + keys.size());
		System.out.println("2) Unqiue Managers with theit IDs are :");
		for (String s : keys)
			System.out.println("Manager ID =" + s);
		System.out.println("3) Employees under each Manager :");
		for (String s : keys)
			System.out.println("No of employees under mangager id = " + s + " = " + hn.get(s));
	}

	void findmaxemployee(HashMap<String, Integer> hn) {
		String manager = "";
		Set<String> keys = hn.keySet();
		int maxemp = 0;
		for (String s : keys) {
			if (maxemp < hn.get(s)) {
				maxemp = hn.get(s);
				manager = s;
			}
		}
		System.out.println("4) Manager with maximum Employees is :" + manager + " and no of employees are :" + maxemp);
	}

	void findduplicate(LinkedList<String> empid, LinkedList<String> empmanager) {
		HashSet<String> hs1 = new HashSet<String>();
		for (int index = 0; index < empid.size(); index++) {
			if (hs1.add((empid.get(index))) == false)
				System.out.println("Duplicate employee id is " + empid.get(index));
			if (hs1.add((empmanager.get(index))) == false)
				System.out.println("Duplicate employee name is " + empmanager.get(index));

		}
	}

	LinkedList<String> storeemployeeid(WebDriver driver) {
		LinkedList<String> empid = new LinkedList<String>();
		int rowcount = driver.findElements(By.xpath("//table[@class='table table-striped']//tr")).size();
		for (int i = 1; i < rowcount; i++) {
			empid.add(driver.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr[" + i + "]/td[2]"))
					.getText());
		}
		return empid;
	}

	LinkedList<String> storeemployeename(WebDriver driver) {
		LinkedList<String> empmanager = new LinkedList<String>();
		int rowcount = driver.findElements(By.xpath("//table[@class='table table-striped']//tr")).size();
		for (int i = 1; i < rowcount; i++) {
			empmanager.add(driver.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr[" + i + "]/td[3]"))
					.getText());
		}
		return empmanager;
	}
}
