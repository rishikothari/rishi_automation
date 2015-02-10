package functional_test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testHarness.ImdbTop50;
import baseclasses.Setup;



public class ImdbTop50Test extends Setup {
	ImdbTop50 imdb = new ImdbTop50();

	//*********************************************************************************************************
	//* Function Name: getMovieListing																		  *	
	//* Use          : This function is used to get top 250 movie listing stored in db and print in a file 	  *									 
	//* Author       : Rishikesh																			  *	
	//*********************************************************************************************************	 	
		@Test(priority =4)
		public void getMovieListing(){
			imdb.navigateToHomePage();
			imdb.clickOnWatchlist();
			imdb.clickOnTop250Link();
			imdb.storeValueinList();
			imdb.printFile();			
		}
		
		@Test (priority =1)
		public void verifyHomePageElements(){
			imdb.navigateToHomePage();
			imdb.verifyHomePage();
		}
		
		@Test (priority =2)
		public void verifyWatchlistPageElements(){
			imdb.navigateToHomePage();
			imdb.clickOnWatchlist();
			imdb.verifyWatchlistPage();
		}
		
		@Test(priority =3)
		public void verifytop250ListPageElements(){
			imdb.navigateToHomePage();
			imdb.clickOnWatchlist();
			imdb.clickOnTop250Link();
			imdb.verifyTop250ListPage();
		}
}
