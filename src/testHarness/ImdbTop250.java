package testHarness;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import objectRepository.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.Wait;

import baseclasses.Setup;
import baseclasses.WrapperFunctions;

public class ImdbTop250 extends WrapperFunctions {

	protected WrapperFunctions wrap = new WrapperFunctions();

	// *********************************************************************************************************
	// * Function Name: navigateToHomePage 														   			   *
	// * Use : This function is used to navigate to Home Page 								  				   *
	// * Author : Rishikesh 																				   *
	// *********************************************************************************************************
	
	public void navigateToHomePage() {

		driver.get("http://www.imdb.com");
		waitForPageToLoad();
	}
	// *********************************************************************************************************
	// * Function Name: clickOnWatchlist 																	   *
	// * Use : This function is used to click on the watch list page		 								   *
	// * Author : Rishikesh 																				   *
	// *********************************************************************************************************
	
	public void clickOnWatchlist() {
		wrap.clickElement(ObjectRepository.ImdbElements.watchList, "xpath");
		waitForPageToLoad();
	}
	// *********************************************************************************************************
	// * Function Name: clickOnTop250Link 														  			   *
	// * Use : This function is used to navigate to click on movie listing page 							   *
	// * Author : Rishikesh 																				   *
	// *********************************************************************************************************
	
	public void clickOnTop250Link() {
		wrap.clickElement(ObjectRepository.ImdbElements.top250Link, "xpath");
		waitForPageToLoad();
	}
	// *********************************************************************************************************
	// * Function Name: getMovieTitle 														  				   *
	// * Use : This function is used to fetch the movie title 												   *
	// * Author : Rishikesh 																				   *
	// *********************************************************************************************************
	
	public void getMovieTitle() {

		for (int row = 1; row <= 250; row++) {
			System.out.println(wrap.findWebElement(
					ObjectRepository.ImdbElements.movieTitle.replace("rowNum",
							Integer.toString(row)), "xpath").getText());
		}
	}
	// *********************************************************************************************************
	// * Function Name: getReleaseYear 																		   *
	// * Use : This function is used to fetch the movie release year		 								   *
	// * Author : Rishikesh 																				   *
	// *********************************************************************************************************
	
	public void getReleaseYear() {

		for (int row = 1; row <= 250; row++) {
			System.out.println(wrap.findWebElement(
					ObjectRepository.ImdbElements.releaseYear.replace("rowNum",
							Integer.toString(row)), "xpath").getText());
		}
	}
	// *********************************************************************************************************
	// * Function Name: getMovieRating 														  				   *
	// * Use : This function is used to fetch the movie rating 				 								   *
	// * Author : Rishikesh 																				   *
	// *********************************************************************************************************
	
	public void getMovieRating() {

		for (int row = 1; row <= 250; row++) {
			System.out.println(wrap.findWebElement(
					ObjectRepository.ImdbElements.movieRating.replace("rowNum",
							Integer.toString(row)), "xpath").getText());
		}
	}
	// *********************************************************************************************************
	// * Function Name: storeValueinList 																	   *
	// * Use : This function is used to store values in the DataBase		 								   *
	// * Author : Rishikesh 																				   *
	// *********************************************************************************************************
	
	public void storeValueinList() {

		HashMap<String, String> map = new HashMap<String, String>();
		for (int row = 1; row <= 250; row++) {

			map.put("name",
					wrap.findWebElement(
							ObjectRepository.ImdbElements.movieTitle.replace(
									"rowNum", Integer.toString(row)), "xpath")
							.getText());
			map.put("year",
					wrap.findWebElement(
							ObjectRepository.ImdbElements.releaseYear.replace(
									"rowNum", Integer.toString(row)), "xpath")
							.getText());
			map.put("rating",
					wrap.findWebElement(
							ObjectRepository.ImdbElements.movieRating.replace(
									"rowNum", Integer.toString(row)), "xpath")
							.getText());

			databaseInsert(map);
		}
	}
	// *********************************************************************************************************
	// * Function Name: printFile 																			   *
	// * Use : This function is used to print the results of database in  a file							   *
	// * Author : Rishikesh 																				   *
	// *********************************************************************************************************
	
	public void printFile() {

		printFileFromDB();

	}

	// *********************************************************************************************************
	// * Function Name: printFileFromDB				 														   *
	// * Use : This function is used to print the results of database in  a file							   *
	// * Author : Rishikesh 																				   *
	// *********************************************************************************************************
	public void printFileFromDB() {

		Connection c = null;
		Statement stmt = null;
		BufferedWriter bw = null;
		FileWriter fw;

		try {
			File file = new File("imdbTop250.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			fw = new FileWriter(file.getAbsoluteFile());
			bw = new BufferedWriter(fw);
		} catch (Exception e) {

		}

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:imdbListing.db");
			System.out.println("Opened database successfully " + c.toString());

			stmt = c.createStatement();

			String sql = "Select * from imdbtop250;";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println("Printing values in file:    PLEASE WAIT!");

				String fileOutput = rs.getString(1) + "  " + rs.getString(2)
						+ "  " + "  " + rs.getString(3) + "  "
						+ rs.getString(4) + "\n";
				if (fileOutput != null) {
					bw.write(fileOutput);
				}

			}
			stmt.close();
			c.close();
			bw.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
	// *********************************************************************************************************
	// * Function Name: verifyHomePage 														 				   *
	// * Use : This function is used to verify the home page elements		 								   *
	// * Author : Rishikesh 																				   *
	// *********************************************************************************************************
	public void verifyHomePage() {
		WrapperFunctions.verifyTrue(
				wrap.findWebElement(
						ObjectRepository.ImdbElements.homePageIdentifier, "id")
						.isDisplayed(), "verify elements");
	}
	// *********************************************************************************************************
	// * Function Name: verifyWatchlistPage												   					   *
	// * Use : This function is used to verify the watch list page elements		 							   *
	// * Author : Rishikesh 																				   *
	// *********************************************************************************************************
	public void verifyWatchlistPage() {
		WrapperFunctions.verifyTrue(
				wrap.findWebElement(
						ObjectRepository.ImdbElements.watchlistPageidentier,
						"xpath").isDisplayed(), "verify elements");
	}
	// *********************************************************************************************************
	// * Function Name: verifyTop250ListPage 														           *
	// * Use : This function is used to verify the  movie listing page elements		 						   *
	// * Author : Rishikesh 																				   *
	// *********************************************************************************************************
	public void verifyTop250ListPage() {
		WrapperFunctions.verifyTrue(
				wrap.findWebElement(
						ObjectRepository.ImdbElements.top250PageIdentifier,
						"xpath").isDisplayed(), "verify elements");
	}
}
