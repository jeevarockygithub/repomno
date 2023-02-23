 package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	WebDriver driver;
	
	public Properties prop;
	
	public WebDriver intializeDriver() throws IOException {
		
		prop = new Properties();
		
		String projectPath = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
		
		FileInputStream fis = new FileInputStream(projectPath);
		prop.load(fis);
		
		
		String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}
			else if (browserName.equalsIgnoreCase("chrome")) {
			
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}
		
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 return driver;
		
		
		
	}

}
