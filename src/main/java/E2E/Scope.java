package E2E;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		System.out.println(driver.findElements(By.tagName("a")).size());

		//footer
		WebElement footer=driver.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size());

		//first table
		WebElement coloumndriver=footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(coloumndriver.findElements(By.tagName("a")).size());
		
		//click on each link in the coloumn
		for(int i=1;i<coloumndriver.findElements(By.tagName("a")).size();i++){
			coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(Keys.CONTROL,Keys.ENTER);
			Thread.sleep(5000L);
		}

		// opens all the tabs
		Set<String> abc=driver.getWindowHandles();
		Iterator<String> it=abc.iterator();
//		it.next();
		while(it.hasNext()){
		   driver.switchTo().window(it.next());
		   System.out.println(driver.getTitle());
		}
	}

}