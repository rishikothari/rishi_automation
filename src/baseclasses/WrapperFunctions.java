/*
 * Here we will be adding all the wrapper functions for our framework
 */

package baseclasses;

import java.util.concurrent.TimeUnit;
import functional_test.ImdbTop250Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import ObjectRepository.ObjectRepository;

public class WrapperFunctions extends Setup {

	private WebElement element = null;
	
	// *********************************************************************************************************
	// * Function Name: findWebElement 														   			  	   *
	// * Use : This function is the wrapper function to find the web element				  				   *
	// * Author : Rishikesh 																				   *
	// *********************************************************************************************************
	public WebElement findWebElement(final String locator, final String by)

	{
		try {

			if (by.equalsIgnoreCase("xpath")) {
				element = driver.findElement(By.xpath(locator));
			} else if (by.equalsIgnoreCase("id")) {
				element = driver.findElement(By.id(locator));
			} else if (by.equalsIgnoreCase("name")) {
				element = driver.findElement(By.name(locator));
			} else if (by.equalsIgnoreCase("name")) {
				element = driver.findElement(By.className(locator));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return element;
	}
	// *********************************************************************************************************
	// * Function Name: clickElement 														   			  	   *
	// * Use : This function is the wrapper function to click the web element				  				   *
	// * Author : Rishikesh 																				   *
	// *********************************************************************************************************
	public void clickElement(final String locator, final String by) {
		try {
			element = findWebElement(locator, by);
			element.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	// *********************************************************************************************************
	// * Function Name: waitForPageToLoad 														   			   *
	// * Use : This function is used to wait for all elements of page to load 				  				   *
	// * Author : Rishikesh 																				   *
	// *********************************************************************************************************
	public void waitForPageToLoad() {
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
	}
	
	// *********************************************************************************************************
	// * Function Name: verifyTrue 														   			   		   *
	// * Use : This function is used to verify web elements on the page 				  				       *
	// * Author : Rishikesh 																				   *
	// *********************************************************************************************************
	public static void verifyTrue(boolean condition, String message) {
		try {
			assertTrue(condition, message);
			System.out.println("PASS");

		} catch (Throwable e) {
			System.out.println(e.getMessage());
			System.out.println("FAIL");
		}
	}
	
	// *********************************************************************************************************
	// * Function Name: assertTrue 														   			   		   *
	// * Use : This function is used to verify web elements on the page 				  				       *
	// * Author : Rishikesh 																				   *
	// *********************************************************************************************************
	public static void assertTrue(boolean condition, String message) {
		Assert.assertTrue(condition, message);

	}
}
