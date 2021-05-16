import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumQues {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenum_Learn\\selenium-java-3.141.59\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Que1 - count of number of links available on webpage
		System.out.println("Number of Links on web Page	: "+driver.findElements(By.tagName("a")).size());
		
		//Que2 - count of number of links available on footer section
		WebElement footerSection = driver.findElement(By.id("gf-BIG"));
		System.out.println("Number of Links available on foother section	: "+footerSection.findElements(By.tagName("a")).size());
		
		//Que3 - 
		WebElement footerColumnSection =footerSection.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println("Number of Links available on foother Column section	: "+footerColumnSection.findElements(By.tagName("a")).size());
		
		//Que4  - Click all the link which is available in column 1 only on footer section 
		// if link are increasing in future, no warry it will click all the links and verify
		//here we are click on link without there x path if  
		
		int linkCount =footerColumnSection.findElements(By.tagName("a")).size() ;
		for(int i=2 ;  i<=linkCount ; i++ ){
			WebElement row  = footerColumnSection.findElement(By.xpath("//li["+i+"]/a"));
			//WebElement row  =  footerColumnSection.findElements(By.tagName("a")).get(i);  //other way to click it
			Actions act = new Actions (driver);
			act.moveToElement(row).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
			Thread.sleep(5000);
		}
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr =  windows.iterator();
		while(itr.hasNext()){
			driver.switchTo().window(itr.next());
			System.out.println(driver.getTitle());
		}
		
	}

}
