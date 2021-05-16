import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptScroll {

	ChromeDriver driver;
	int amount=0;
	
	public void launchApp(){
		System.setProperty("webdriver.chrome.driver", "D:\\Selenum_Learn\\selenium-java-3.141.59\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void scrolling() throws InterruptedException{
		JavascriptExecutor js  = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=100");
	}
	
	public void addAmount(){		
		int count  = driver.findElements(By.xpath("//table[@id='product']//td[4]")).size();
		for (int i= 0 ; i<count ;i++){
			int num = Integer.parseInt(driver.findElements(By.xpath("//table[@id='product']//td[4]")).get(i).getText());
			amount = num+amount;
		}
		System.out.println("Sum of Amount is :"+amount);
	}
	
	public void validation() {
       String expectedResult = driver.findElement(By.cssSelector(".totalAmount")).getText();
       int expectedFormatRes = Integer.parseInt(expectedResult.split(":")[1].trim());
       Assert.assertEquals(amount, expectedFormatRes);
       System.out.println("Result matched..!");
	}
	public static void main(String[] args) throws InterruptedException {
		JavaScriptScroll js = new JavaScriptScroll();
		js.launchApp();
		js.scrolling();
		js.addAmount();
		js.validation();		
	}
	
	

}
