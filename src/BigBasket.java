import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BigBasket {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenum_Learn\\selenium-java-3.141.59\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
                 		
		List<WebElement> vegitabls = driver.findElements(By.cssSelector("[class='product-name']"));
		
		//driver.findElement(By.xpath("//h4[text()='Cucumber - 1 Kg']/parent::div/div[3]/button")).click();
		
String vegiNeed = "Mushroom - 1 Kg";	

		for (WebElement vegi : vegitabls) {
			System.out.println(vegi.getText());
			if (vegi.getText().contains(vegiNeed)) {
				driver.findElement(By.xpath("//h4[text()='"+vegiNeed+"']/parent::div/div[3]/button")).click();
				break;
			}
		}
	}

}
