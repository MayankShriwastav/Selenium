import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class e2eFlightBooking {
	
	public void autoSuggest(WebDriver driver) {
		driver.findElement(By.id("autosuggest")).sendKeys("Ind");
		List<WebElement> options = driver.findElements(By.cssSelector("[class='ui-menu-item'] a"));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}
	}

	public void Currency(WebDriver driver) {
		Select curr = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		curr.selectByVisibleText("USD");
		Assert.assertEquals(curr.getFirstSelectedOption().getText(), "USD");
		System.out.println("Currancy Selected : " + curr.getFirstSelectedOption().getText());
	}

	public void passengers(WebDriver driver, int numOfPassengers) {
		driver.findElement(By.id("divpaxinfo")).click();
		int i=1;
		while(i<numOfPassengers){
			i++;
			driver.findElement(By.cssSelector("span#hrefIncAdt")).click();
		}		
		driver.findElement(By.cssSelector("input#btnclosepaxoption")).click();		
	}

	public void sourceAndDestinationCity(WebDriver driver) {
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		//driver.findElement(By.xpath("(//a[@value='PNQ'])[2]")).click();
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='PNQ']")).click();
	}

	public void SeniorCitizenDiscount(WebDriver driver) {
		driver.findElement(By.cssSelector("[id*=SeniorCitizenDiscount]")).click();
	}
	
	public void serchFlight(WebDriver driver) {
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}
	
	public void validation(WebDriver driver) {
		List<WebElement> chkBox = driver.findElements(By.cssSelector("[type='checkbox']"));
		System.out.println("number of check boxs	: " + chkBox.size());
		Assert.assertEquals(chkBox.size(), 6);

		Assert.assertTrue(driver.findElement(By.cssSelector("[id*=SeniorCitizenDiscount]")).isSelected());
		System.out.println("Senior Citizen Discount checkbox is clicked");	
	}
	
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenum_Learn\\selenium-java-3.141.59\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		e2eFlightBooking booking = new e2eFlightBooking();
		booking.autoSuggest(driver);
		booking.Currency(driver);
		booking.passengers(driver,8);
		booking.sourceAndDestinationCity(driver);
		booking.SeniorCitizenDiscount(driver);
		booking.validation(driver);
		booking.serchFlight(driver);		
	}
}
