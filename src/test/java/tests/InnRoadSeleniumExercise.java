package tests;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObject.CalendarObj;
import pageObject.DateParsing;
import pageObject.InnroadHomePage;
import pageObject.InnroadLoginPage;

import resources.BaseReusable;

public class InnRoadSeleniumExercise extends BaseReusable {

	

		@Test
		
		public void BaseReusableNavigation() throws IOException, InterruptedException, ParseException{
		
		
			driver = intializeDriver();
			driver.get("https://app.qainnroad.com/");
			
			InnroadLoginPage lp=new InnroadLoginPage(driver);
			lp.getClientcode().sendKeys("autorates");	
			lp.getUserName().sendKeys("autouser");
			lp.getPassword().sendKeys("Auto@123!");
			lp.getLogin().click();
			
			
			
			
			InnroadHomePage hp=new InnroadHomePage(driver);
			hp.NavigatetoInventory().click();
			hp.NavigatetoRatesGrid().click();
			
			//driver.findElement(By.xpath("//div[@id='daterange-calendar']")).click();

			
			
			for (int j = 0; j < 3; j++) {
				driver.findElement(By.xpath("//button[@class='arrowButton btn-link btn btn-secondary']/span[@class='right-arrow']")).click();
			}

		    Calendar c1 = Calendar.getInstance();
			c1.add(Calendar.MONTH, 2);
			c1.add(Calendar.DAY_OF_MONTH, 2);
			DateFormat df = new SimpleDateFormat("MMMM d yyyy");
			String date1 = df.format(c1.getTime());
			int dayOFMonth = c1.get(Calendar.DAY_OF_MONTH);
			driver.findElement(By.xpath("//div[@id='daterange-calendar']")).click();
			
			driver.findElement(By.xpath("//div[@class='DayPicker-Day'][text()='"+ dayOFMonth +"']")).click();
			
			
			
			
			CalendarObj co= new CalendarObj(driver);
			co.getDropDown().click();	
			//co.getRatePlan().sendKeys("Test Rate");
			co.getDropDown().click();
			
			//String date = "March 14 2022";
			String date = df.format(c1.getTime());

			List<String> listOfRoomClass= new ArrayList<String>();
			listOfRoomClass.add("King Suite");
			listOfRoomClass.add("Double Bed Room");
			for (String roomclass : listOfRoomClass) {

			getRoomClassSpecificRates(driver, roomclass, "Test Rate", date);
			System.out.println("---------------------------------------------------------");
			}
			
		}



		public static ArrayList<String> getRoomClassSpecificRates(WebDriver driver, String roomClassName,
		String ratePlanName, String date) throws ParseException {



		// March 11 2022



		List<WebElement> list = driver.findElements(By.xpath("//div[@class='roomClassName'][text()='" + roomClassName
		+ "']/..//following-sibling::div//div[contains(@class,'RegularRate')]"));

		HashMap<String, HashMap<String, HashMap<String, String>>> ratePlanWiseRates = new HashMap<>();
		HashMap<String, HashMap<String, String>> roomClassWiseRates = new HashMap<>();



		HashMap<String, String> dateWiseRates = new HashMap<String, String>();



		for (WebElement ele : list) {
		String nextDate = DateParsing.parseNextDate(date);
		dateWiseRates.put(nextDate, ele.getText());
		date = nextDate;
		}



		roomClassWiseRates.put(roomClassName, dateWiseRates);
		ratePlanWiseRates.put(ratePlanName, roomClassWiseRates);
		for (String dates : dateWiseRates.keySet()) {
		System.out.println(dates + ": " + dateWiseRates.get(dates));
		}



		return null;
		}
		}



