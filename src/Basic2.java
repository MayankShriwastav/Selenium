import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Basic2 {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "D:\\Selenum_Learn\\selenium-java-3.141.59\\geckodriver.exe");
		 * WebDriver driver = new FirefoxDriver();
		 */

		System.setProperty("webdriver.chrome.driver", "D:\\Selenum_Learn\\selenium-java-3.141.59\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();

		driver.findElement(By.id("autosuggest")).sendKeys("Ind");
		Thread.sleep(2000);

		List<WebElement> options = driver.findElements(By.cssSelector("[class='ui-menu-item'] a"));

		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}

		// find number of checkboxes present on screen
		List<WebElement> chkBox = driver.findElements(By.cssSelector("[type='checkbox']"));
		System.out.println("number of check boxs	: " + chkBox.size());
		Assert.assertEquals(chkBox.size(), 6);

		driver.findElement(By.cssSelector("[id*=SeniorCitizenDiscount]")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("[id*=SeniorCitizenDiscount]")).isSelected());
		System.out.println("SeniorCitizenDiscount checkbox is clicked");

	}
}
