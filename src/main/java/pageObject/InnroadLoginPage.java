package pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InnroadLoginPage {
public WebDriver driver;

public InnroadLoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}

     @FindBy(id="txtclientCode")
     WebElement client;
     
     @FindBy(id="txtLoginID")
     WebElement username;
     
     @FindBy(id="txtUserPassword")
     WebElement  password;
     
     @FindBy(id="btnLogon")
     WebElement login;
   
   public WebElement getClientcode()
   {
	 return  (client);
   }
   
   public WebElement getUserName()
   {
	   return (username);
   }
   
   public WebElement getPassword()
   {
	   return (password);
   }
   
   public WebElement getLogin()
   {
	   WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnLogon")));
		
	   return (login);
	  
	   
   }
   
   

   

}
