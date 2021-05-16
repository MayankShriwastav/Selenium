import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SeleniumUsingStreamAndLambda {
	
	public void sortingVerification(WebDriver driver){
		driver.findElement(By.xpath("//span[contains(text(),'Veg/fruit name')]")).click();
		
		// capture all the webElement
		List<WebElement>vegiElement = driver.findElements(By.xpath("//td[1]"));
		
		// capture text of all the webElement into originalVegiList
		List<String> orignalVegiList = vegiElement.stream().map(s->s.getText()).collect(Collectors.toList());
		
		// sort originalVegiList and stored in other list
		List<String> sortedVegiList =orignalVegiList.stream().sorted().collect(Collectors.toList());
		
		//compare both list
		Assert.assertEquals(orignalVegiList, sortedVegiList);	
	}
	
	public  String getPriceVegi(WebElement s){
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;		
	}
	
	public void scanNameAndgetPriceValue(WebDriver driver){
		//Scan the name column with get text as 'Rice'  and print price for it		
		List<String> price;
			
		
		do{			
			List<WebElement>rows = driver.findElements(By.xpath("//td[1]"));
			price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s ->getPriceVegi(s)).collect(Collectors.toList());
			price.stream().forEach(s -> System.out.println(s));			
			if(price.size()<1){
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}			
		}while(price.size()<1);		
	}
	
	
	public void searchName(WebDriver driver){
		//driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");	
		driver.findElement(By.cssSelector("[aria-label='First']")).click();
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement>searchElementName = driver.findElements(By.xpath("//td[1]"));
		List<WebElement>searchFilteredName = searchElementName.stream().filter(s -> s.getText().contains("Rice")).collect(Collectors.toList());
		Assert.assertEquals(searchElementName.get(0).getText(), searchFilteredName.get(0).getText());
		System.out.println("Searched element Matched...!");
	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenum_Learn\\selenium-java-3.141.59\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		SeleniumUsingStreamAndLambda sl = new SeleniumUsingStreamAndLambda();
		sl.sortingVerification(driver);
		sl.scanNameAndgetPriceValue(driver);
		sl.searchName(driver);

		
	
	}
}
