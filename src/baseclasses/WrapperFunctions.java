//package baseclasses;
//
//import functional_test.ImdbTop50Test;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//
//import ObjectRepository.ObjectRepository;
//
//public class WrapperFunctions  extends ImdbTop50Test{
//	private static WebDriver driver = null;
//	
//	publi
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
//	public void findWebElement(final String locator){
//		try{
//			if (locator.startsWith("@id")) {
//				// e.g @id='elementID'
//				// Find the text input element by its id
//				webElement = driver.findElement(By.id(removeStart(
//						locator, "@id=")));
//		}
//		
//	}
//}
