package Regression;

import java.io.FileInputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.github.javafaker.Faker;

public class Base {
	
	public Properties pro = new Properties();
	public WebDriver driver;
	public Locale locale = new Locale("en-US");
	public Faker fake = new Faker(locale);
	
	@BeforeSuite
	public WebDriver Configuration() {
		try {
			FileInputStream fis = new FileInputStream("D:\\Project_Navetor\\Navetor\\Locator.properties");
			pro.load(fis);
			
			String Browser = pro.getProperty("Browser");
			System.out.println("This is:" + " "+ Browser);
			
			if(Browser.equals("chrome")) {
				driver= new ChromeDriver();
				driver.manage().window().maximize();
			}
			else if(Browser.equals("firefox")) {
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		driver.get(pro.getProperty("URLQA"));
		
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
 
	
	@AfterSuite
	public void Teardown() throws InterruptedException {
		driver.manage().deleteAllCookies();
		Thread.sleep(5000);
		driver.quit();
	}
	
}
