package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class LoginTest  extends Base {
	
	WebDriver driver;
	
	@Test
	public void login() throws IOException {
		
		driver = intializeDriver();
		driver.get(prop.getProperty("url"));
	}

}
