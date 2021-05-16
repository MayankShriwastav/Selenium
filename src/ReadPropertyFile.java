import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\My_Projects\\UdemySelenium\\data.properties");
		prop.load(fis);
		
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("url"));
		
		// to write in properties file -->
		prop.setProperty("browser", "firefox");
		FileOutputStream fos = new FileOutputStream("D:\\My_Projects\\UdemySelenium\\data.properties");
		prop.store(fos, "writing file..");
		
		//After Editing
		System.out.println("******After Editing*****");
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("url"));

	}

}
