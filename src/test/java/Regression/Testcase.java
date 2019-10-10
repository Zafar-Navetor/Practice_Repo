package Regression;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


//import PageObject.Accept_TC;
import PageObject.Login;
import PageObject.PatientRegistration;

public class Testcase extends Base {
	
	
	
	//Verify Page Title
	@Test
	public void PageTitle() {
		try {
			String Actual = driver.getTitle();
			System.out.println("This is Actual Page Title Result!" + " "+ Actual);
			String Expected = "Navetor";
		
			Assert.assertEquals(Actual, Expected);
			System.out.println("This is Expected Page Title Result!" + " " + Expected);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	

	@Test
	public void loginpage() {
		String Name = pro.getProperty("Username");
		String Password = pro.getProperty("Password"); 
		
		//Login 
		Login ln = new Login(driver);
		ln.username().sendKeys(Name);
		System.out.println("This is login user name = "+""+ Name);
		
		ln.password().sendKeys(Password);
		System.out.println("This is password = "+""+ Password);
	    ln.Loginbutton().click();
		
		
	    //Patient Registration Information
	    
		PatientRegistration PR = new PatientRegistration(driver);
		
		PR.clientreg().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String CheckBoxtype = pro.getProperty("CheckBoxtype");
		
		System.out.println("Selected checkbox type is ="+" " + CheckBoxtype);
		
		try {
		if(CheckBoxtype.equals("Person")) {
			PR.Person().click();
			
			
		}else if(CheckBoxtype.equals("Organization")) {
			//PR.Organization().click();
			
			WebDriverWait d = new WebDriverWait(driver, 20);
			WebElement eletime = d.until(ExpectedConditions.elementToBeClickable(By.xpath(pro.getProperty("Organization"))));
			eletime.click();
		
			
			PR.Name().sendKeys(fake.name().firstName());
			PR.Department().sendKeys(fake.company().industry());
			PR.Address().sendKeys(fake.address().fullAddress());
			PR.City().sendKeys(fake.address().cityName());
			
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement elestate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(pro.getProperty("State"))));
			elestate.clear();
			elestate.sendKeys(pro.getProperty("statevalue"));
			
			
			
			PR.Zip().sendKeys(fake.address().zipCode());
			
		
		WebDriverWait cd = new WebDriverWait(driver, 10);
		WebElement elecounty = cd.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select_county']//span[text()='select']")));
		elecounty.click();
		//elecounty.sendKeys("Bay");
		
		Select cell= new Select(driver.findElement(By.xpath(pro.getProperty("Phone"))));
		cell.selectByIndex(2);
		PR.PhoneNumber().sendKeys(pro.getProperty("PhoneValue"));
		
		//WebDriverWait prefer = new WebDriverWait(driver, 30);
		//WebElement eleprefer = prefer.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='form_CreateClient']/div[1]/ul[4]/li[2]/span/span/span/span")));
		//eleprefer.click();
		//eleprefer.sendKeys("Email");
		Thread.sleep(5000);
		Select Pre = new Select(driver.findElement(By.xpath("//*[@id='form_CreateClient']/div[1]/ul[4]/li[2]/span/span/span/span")));
		Pre.selectByIndex(1);
		
		//Thread.sleep(8000);
	//driver.findElement(By.xpath("//*[@id=\"form_CreateClient\"]/div[1]/ul[4]/li[2]/span/span/span/span")).click();
	
		
		//Person Properties
		
		//PR.PersonCheckBox().click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='divClientTitle']/span/span/input")).click();
		
	
		}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
			
		}
		
		
		
		
		}





	



		
	
	}
	

	
