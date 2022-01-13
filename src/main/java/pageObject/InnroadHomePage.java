package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InnroadHomePage  {
 
	public WebDriver driver;
	
	public InnroadHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
}
	
	 @FindBy(xpath="//i[@class='nav-sprite nav-inventory nav_icon']")
     WebElement inv;
	 
	 @FindBy(xpath="//a[@id='ucNavSecondary_rptrNavMain_lbtnNavMainItem_0']")
     WebElement rates;
	
	public WebElement NavigatetoInventory()
	{ 
	    WebDriverWait w= new WebDriverWait(driver,60);
	    w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='nav-sprite nav-inventory nav_icon']")));
		
		return (inv);
	}
	public WebElement NavigatetoRatesGrid()
	{
		WebDriverWait w1= new WebDriverWait(driver,10);
	    w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='ucNavSecondary_rptrNavMain_lbtnNavMainItem_0']")));
	   return (rates);
	}
	
}