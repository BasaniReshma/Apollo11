package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarObj {
	
	WebDriver driver;
	
	public CalendarObj(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	
	 @FindBy(xpath="//div[@class='rateplan-arrow open']")
     WebElement dropdown;
	 

	 @FindBy(xpath="//span[@class='rate-plan-picker-label'][text()='Test Rate']")
     WebElement rateplan;
	 
	
	
	public WebElement getDropDown()
	{
		
		WebDriverWait wait= new WebDriverWait(driver,30);
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='rateplan-arrow open']")));
		return (dropdown);
	}

	public WebElement getRatePlan()
	{
		
		WebDriverWait wait= new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='rate-plan-picker-label'][text()='Test Rate']")));
		return (rateplan);
	}
       
}
