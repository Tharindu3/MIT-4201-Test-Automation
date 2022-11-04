package com.act.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.act.qa.util.TestUtil;
import com.act.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase() {
		
		try {
			prop = new Properties(); 
			FileInputStream ip = new FileInputStream("C:\\Users\\Tharindu\\eclipse-workspace\\actiTIMETest\\src\\main\\java\\com\\act\\qa\\config\\config.properties");
			prop.load(ip);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tharindu\\eclipse-workspace\\actiTIMETest\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Tharindu\\eclipse-workspace\\actiTIMETest\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));		
		
		driver.get(prop.getProperty("url"));
	}
	

}
