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
import org.testng.Assert;

import ObjectRepository.ObjectRepository;

//
public class WrapperFunctions extends Setup {

	private WebElement element = null;

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

	public void clickElement(final String locator, final String by) {
		try {
			element = findWebElement(locator, by);
			element.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void waitForPageToLoad() {
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
	}

	public static void verifyTrue(boolean condition, String message) {
		try {
			assertTrue(condition, message);
			System.out.println("PASS");

		} catch (Throwable e) {
			System.out.println(e.getMessage());
			System.out.println("FAIL");
		}
	}

	public static void assertTrue(boolean condition, String message) {
		Assert.assertTrue(condition, message);

	}
}
