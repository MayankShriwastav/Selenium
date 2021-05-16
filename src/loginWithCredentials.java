

import org.openqa.selenium.chrome.ChromeDriver;

public class loginWithCredentials {

// some of the URL's asking for credentials to enter home page. no locators are available to handle it
//	it is basically window authentication popup which can't handle by locators
//	so selenium have given a way - where we have pass url with credential (rether then using auto IT)
//syntex for sending credential from URL   -->  https://UserName:password@siteURL
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenum_Learn\\selenium-java-3.141.59\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//driver.get("https://the-internet.herokuapp.com/basic_auth");
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth"); // pass credential with URL.(admin:admin@)
	}

}
