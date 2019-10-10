package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


	
public class Login {

	 WebDriver driver;
	
	public Login(WebDriver driver) {
		this.driver= driver;
	}
	
	
		
		By UserName = By.xpath("//input[@id='UserName']");
		By Password = By.xpath("//input[@name='Password']");
		By Loginbutton = By.xpath("//input[@class='btn center-block']");
		By accept = By.xpath("//input[@class='button']");
		
		
     //Username Method
		public  WebElement username() {
			return driver.findElement(UserName);
				
			}
		
		//Password Method
			
		public WebElement password() {
			return driver.findElement(Password);
		}
		
		//Login button Method
		
		public WebElement Loginbutton() {
			return driver.findElement(Loginbutton);
		}
		
		public WebElement Accept() {
			return driver.findElement(accept);
		}
	  
		
		
		
	}
	
