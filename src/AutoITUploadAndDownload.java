import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AutoITUploadAndDownload {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenum_Learn\\selenium-java-3.141.59\\chromedriver.exe");
		
		String downloadPath = System.getProperty("user.dir");				
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();		
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://altoconvertpdftojpg.com/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("dropzoneInput-label")).click();	
		Thread.sleep(3000);
		Runtime.getRuntime().exec("D:\\My_Projects\\UdemySelenium\\AutoIT\\UploadFileThroughAutoIT.exe");
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(driver,10);			
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='button']")));		
		driver.findElement(By.cssSelector("button[class='button']")).click();		
		Thread.sleep(3000);		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class*='medium']")));		
		driver.findElement(By.cssSelector("button[class*='medium']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='g-btn-auto-width']")));
		driver.findElement(By.cssSelector("[class*='g-btn-auto-width']")).click();
		Thread.sleep(5000);
		
		File file = new File (downloadPath+"\\Result.zip");
		Assert.assertTrue(file.exists());
		System.out.println("File Downloaded Sucessfully..!");
		Assert.assertTrue(file.delete());
		System.out.println("File deleted.....!");		
	}
}
