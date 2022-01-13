package pageObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DateParsing {

	public static String parseNextDate(String date) throws ParseException {
		DateFormat format = new SimpleDateFormat("MMMM d yyyy");
		Calendar c=Calendar.getInstance();
		c.setTime(format.parse(date));
		c.add(Calendar.DAY_OF_MONTH, 1);

		return format.format(c.getTime());



		}
}
