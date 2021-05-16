import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {
	
	ChromeDriver driver;
	
	public void launchApp(){
		System.setProperty("webdriver.chrome.driver", "D:\\Selenum_Learn\\selenium-java-3.141.59\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void selectTravelDate(String travelMonth, String trvelDate){
		driver.findElement(By.id("travel_date")).click();
		
	
 //while loop checks-->  travelMonth which user has provided is same as calanderMonth or not (which is open on browser), 
// if not then insert into while loop and click on 'forward arrow' and again check the same while loop condition. 
//this loop will iterate while travelMonth same as open calendar month 
		while(! driver.findElement(By.cssSelector("[class ='datepicker-days'] [class='datepicker-switch']")).getText().contains(travelMonth)){
			driver.findElement(By.cssSelector("[class ='datepicker-days'] [class='next']")).click();
		}
		
		int count = driver.findElements(By.cssSelector(".day")).size();		
		for(int i =1 ; i<count ; i++){
			String date = driver.findElements(By.cssSelector(".day")).get(i).getText();
			if (date.equalsIgnoreCase(trvelDate)){
				driver.findElements(By.cssSelector(".day")).get(i).click();
				break;
			}
		}
	}

	
	public static void main(String[] args) {		
		Calender cal = new Calender ();
		cal.launchApp();
		cal.selectTravelDate("August","10");		
	}
}
