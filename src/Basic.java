import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Basic {
	public void chromeLaunch() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenum_Learn\\selenium-java-3.141.59\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		// driver.get("https://www.facebook.com/");
		driver.get("http://www.rediff.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("[title*='Sign in']")).click();
		// Thread.sleep(4000);
		driver.findElement(By.xpath("//input[contains(@id,'login')]")).sendKeys("****");
		driver.findElement(By.cssSelector("#password")).sendKeys("****");
		driver.findElement(By.cssSelector("input.signinbtn")).click();

		// driver.close();
	}

	public void firefoxLaunch() {
		System.setProperty("webdriver.gecko.driver", "D:\\Selenum_Learn\\selenium-java-3.141.59\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.close();
	}

	public static void main(String[] args) {

		Basic b = new Basic();
		b.chromeLaunch();
		// b.firefoxLaunch();
	}

}
