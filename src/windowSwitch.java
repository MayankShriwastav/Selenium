import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowSwitch {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenum_Learn\\selenium-java-3.141.59\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("tabButton")).click();
		Set <String> windows  =  driver.getWindowHandles();
		Iterator <String> itr  = windows.iterator();
		String parentID  = itr.next();
		String childID  = itr.next();
		driver.switchTo().window(childID);
		Thread.sleep(5000);
		String valueFromChildWindow = driver.findElement(By.id("sampleHeading")).getText();
		driver.switchTo().window(parentID);
		
		//driver.findElement(By.xpath("//div[@xpath='1']")).click();
		driver.findElement(By.xpath("//body/div[@id='app']/div[@class='body-height']/div[@class='container playgound-body']/div[@class='row']/div[1]/div[1]/div[1]/div[2]/span[1]/div[1]")).click();
		
		driver.findElement(By.xpath("//span[text()='Practice Form']")).click();
		driver.findElement(By.cssSelector("#currentAddress")).sendKeys(valueFromChildWindow);

	}

}
