package testHarness;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.Wait;

import baseclasses.Setup;
import ObjectRepository.ObjectRepository;

public class ImdbTop50 extends Setup {

	WebDriver driver = new FirefoxDriver();
	
//		 WebDriver driver = Setup.driver;
	 
	 public void waitForPageToLoad(){
		 driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
	 }
	 public void navigateToHomePage(){
	
		 driver.get("http://www.imdb.com");
		 waitForPageToLoad();
	 }
	 
	 public void clickOnWatchlist(){
		 driver.findElement(By.xpath((ObjectRepository.ImdbElements.watchList))).click();
		 waitForPageToLoad();	 
	 }
	 
	 public void clickOnTop250Link(){
		 driver.findElement(By.xpath((ObjectRepository.ImdbElements.top250Link))).click();		
//		 waitForPageToLoad();	 
	 }
	 public void getMovieTitle(){
		 //driver.findElement(By.xpath(ObjectRepository.ImdbElements.movieTitle)).getText();
		 for (int i=1; i<=4 ; i++)
		 {
		 System.out.println(driver.findElement(By.xpath(ObjectRepository.ImdbElements.movieTitle.replace("rowNum", Integer.toString(i)))).getText());
		 }
	 }

	 public void getReleaseYear(){
		 //driver.findElement(By.xpath(ObjectRepository.ImdbElements.movieTitle)).getText();
		 for (int i=1; i<=4 ; i++)
		 {
		 System.out.println(driver.findElement(By.xpath(ObjectRepository.ImdbElements.releaseYear.replace("rowNum", Integer.toString(i)))).getText());
		 }
	 }
	 
	 public void getMovieRating(){
		 //driver.findElement(By.xpath(ObjectRepository.ImdbElements.movieTitle)).getText();
		 for (int i=1; i<=4 ; i++)
		 {
		 System.out.println(driver.findElement(By.xpath(ObjectRepository.ImdbElements.movieRating.replace("rowNum", Integer.toString(i)))).getText());
		 }
	 }
	 
	 public void storeValueinList(){
		HashMap<String, String>  map = new HashMap<String, String>(); 
		for ( int i=1; i<4; i++){
		 map.put("name",driver.findElement(By.xpath(ObjectRepository.ImdbElements.movieTitle.replace("rowNum", Integer.toString(i)))).getText());
		map.put("year",	driver.findElement(By.xpath(ObjectRepository.ImdbElements.releaseYear.replace("rowNum", Integer.toString(i)))).getText());
		map.put("rating",driver.findElement(By.xpath(ObjectRepository.ImdbElements.movieRating.replace("rowNum", Integer.toString(i)))).getText());
		databaseInsert(map);
		}
		//		System.out.println(map.);
	 }
}
