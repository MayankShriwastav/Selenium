import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.apache.commons.io.FileUtils;

public class Miscelleneous {

	public static void main(String[] args) throws IOException {
	
		DesiredCapabilities dc =  DesiredCapabilities.chrome();
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true); //handle HTTP certification
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); //handle SSL certification
		
		ChromeOptions co  = new ChromeOptions();
		co.merge(dc);
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenum_Learn\\selenium-java-3.141.59\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(co);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Broken url(link) -  (Page not found)
		//step1 - get all url's with help of selenium
		//java method will call url's and get status code
		//if status code>400 then url is not working 
		SoftAssert a =  new SoftAssert(); //for soft assert
		List <WebElement> links  = driver.findElements(By.cssSelector("div[id=gf-BIG] a[href]"));
		for(WebElement link : links){
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCodeStatus = conn.getResponseCode();
			System.out.println(responseCodeStatus);
			
			/*if(responseCodeStatus>400){				 
				a.assertTrue(false,link.getText()+"-link is broken and response code is -"+responseCodeStatus);
			}*/
			
			//above 3 lines (if condition) replace with below lines
			a.assertFalse(responseCodeStatus>400,link.getText()+"-link is broken and response code is -"+responseCodeStatus);
		}
		
		a.assertAll(); //this is important to write after your code. it will print the report. (use with soft assert)
		
		//TakeScreenShot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D://screenshot.png"));
		
		
	}

}
