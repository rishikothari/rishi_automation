package functional_test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testHarness.ImdbTop50;
import baseclasses.Setup;



public class ImdbTop50Test extends Setup{
	ImdbTop50 imdb = new ImdbTop50();
		
	  @Test
		public void genericFlow(){
			imdb.navigateToHomePage();
			imdb.clickOnWatchlist();
			imdb.clickOnTop250Link();
//			imdb.getMovieTitle();
//			imdb.getReleaseYear();
//			imdb.getMovieRating();
			imdb.storeValueinList();
			
		}
}
