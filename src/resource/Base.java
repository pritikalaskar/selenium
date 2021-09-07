package resource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
		public WebDriver driver;
		public Properties prop;
		public String seturl;

		public WebDriver initializeBrowser() throws IOException {
			 prop = new Properties();
				FileInputStream fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\resource\\data.properties");
				prop.load(fis);
				String browsername = prop.getProperty("browser");
				seturl = prop.getProperty("url");

				if (browsername.equals("chrome")) {
					System.setProperty("webdriver.chrome.driver",
							System.getProperty("user.dir") + "\\src\\resource\\chromedriver.exe");
					 driver = new ChromeDriver();
					 driver.manage().window().maximize();
				}
				
				
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				return driver;

			}
			
			
}
