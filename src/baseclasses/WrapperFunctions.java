/*
 * Here we will be adding all the wrapper functions for our framework
 */

package baseclasses;

import functional_test.ImdbTop50Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ObjectRepository.ObjectRepository;
//
public class WrapperFunctions extends Setup{
//	private static WebDriver driver = null;
//	
	
	WebDriver driver = Setup.driver;
 private  WebElement element =null;
	
	public WebElement findWebElement(String locator, String by )
	
	{
		
	
	 if (by.equalsIgnoreCase("xpath"))
	 {
		  element = driver.findElement(By.xpath(locator));
	 }
	 return element;
	}
}
//	
//	
//	public void mouseOver(final String locator, String locatorName) {
//		try {
//			Actions actions = new Actions(driver);
//			WebElement element;
//			element = driver.findWebElement(String locator);
//			actions.moveToElement(element);
//		
//		} catch (Exception e) {
//			CommonUtilities.reportException("MouseOver", e.getMessage());
//		}
//	}
//		
//	}
//}


