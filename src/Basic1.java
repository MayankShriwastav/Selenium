import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Basic1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenum_Learn\\selenium-java-3.141.59\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();

		Select curr = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		curr.selectByVisibleText("INR");
		System.out.println("Currancy Selected : " + curr.getFirstSelectedOption().getText());

		driver.findElement(By.id("divpaxinfo")).click();
		Select adult = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		adult.selectByValue("3");

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);

		/* driver.findElement(By.xpath("(//a[@value='PNQ'])[2]")).click(); */

		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='PNQ']"))
				.click();

	}

}
