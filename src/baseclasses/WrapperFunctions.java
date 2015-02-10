/*
 * Here we will be adding all the wrapper functions for our framework
 */

package baseclasses;

import java.util.concurrent.TimeUnit;

import functional_test.ImdbTop50Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ObjectRepository.ObjectRepository;

//
public class WrapperFunctions extends Setup {

	private WebElement element = null;

	public WebElement findWebElement(final String locator,final String by)

	{
		try {
			
		
		if (by.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(locator));
										} 
			} catch (Exception e)
				{
				System.out.println(e.getMessage());
				}
		
		return element;
	}


	public void clickElement(final String locator,final String by){
		try{
			element = findWebElement(locator , by);
			element.click();
		}catch (Exception e)
		{
		System.out.println(e.getMessage());
		}
		
	}
	
	public void waitForPageToLoad() {
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
	}
}	
