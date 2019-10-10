package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PatientRegistration {
	
	WebDriver driver;
	
	public PatientRegistration(WebDriver driver) {
		this.driver=driver;
	}

	
	By clientreg = By.xpath("//span[@class='reg_icon']");
	By Person = By.xpath("//input[@value='Person']");
	
	
	
	//Person Check Box
	//By checkPerson = By.xpath("//div[@id='divClientTitle']//span[text()='select']");
	
	//Organization Locators 

    By name = By.xpath("//input[@id='OrganizationName' and @name='OrganizationName']");
	By Dep	= By.xpath("//input[@id='Department']");
	By address = By.xpath("//input[@id='ShippingAddress_AddressLine1']");
	By city = By.xpath("//input[@name='ShippingAddress.City']");
	By zip = By.xpath("//input[@name='ShippingAddress.ZipCode']");
	By number = By.xpath("//input[@class='Phone fl']");
	
	
	
	public WebElement clientreg() {
		return driver.findElement(clientreg);
	}
	
	
	public WebElement Person() {
		return driver.findElement(Person);
	}
	
	
	//Organization methods
/*	public WebElement Organization() {
		return driver.findElement(Organization);
	}*/
	
	public WebElement Name() {
		return driver.findElement(name);
	}
	
	public WebElement Department() {
		return driver.findElement(Dep);
	}
	
	public WebElement Address() {
		return driver.findElement(address);
	}
	
	public WebElement City() {
		return driver.findElement(city);
	}
	
	public WebElement Zip() {
		return driver.findElement(zip);
	}
	
	public WebElement PhoneNumber() {
		return driver.findElement(number);
	}
	
	
	//Person Classes
	/*public WebElement PersonCheckBox() {
		return driver.findElement(checkPerson);
	}*/
	
	
}
