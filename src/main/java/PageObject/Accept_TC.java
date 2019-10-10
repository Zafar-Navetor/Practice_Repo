package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Accept_TC {
	
	WebDriver driver;
	
	
	public Accept_TC(WebDriver driver) {
		this.driver = driver;
	}
        
	By accept = By.xpath("//input[@class='button']");
	
	public WebElement accept() {
		return driver.findElement(accept);
	}
	
}
