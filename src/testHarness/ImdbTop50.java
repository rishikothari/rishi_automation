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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.Wait;

import baseclasses.Setup;
import baseclasses.WrapperFunctions;
import ObjectRepository.ObjectRepository;

public class ImdbTop50 extends Setup{

	//WebDriver driver = new FirefoxDriver();
	WrapperFunctions wrap;
	WebDriver driver;
	
	public ImdbTop50() {
		super();
		this.driver = Setup.driver;;
	}

	public void waitForPageToLoad() {
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
	}

	public void navigateToHomePage() {

		driver.get("http://www.imdb.com");
		waitForPageToLoad();
	}

	public void clickOnWatchlist() {
		driver.findElement(By.xpath((ObjectRepository.ImdbElements.watchList)))
				.click();
		waitForPageToLoad();
	}

	public void clickOnTop250Link() {
		driver.findElement(By.xpath((ObjectRepository.ImdbElements.top250Link)))
				.click();
		// waitForPageToLoad();
	}

	public void getMovieTitle() {
		// driver.findElement(By.xpath(ObjectRepository.ImdbElements.movieTitle)).getText();
		for (int i = 1; i <= 4; i++) {
			System.out.println(driver.findElement(
					By.xpath(ObjectRepository.ImdbElements.movieTitle.replace(
							"rowNum", Integer.toString(i)))).getText());
		}
	}

	public void getReleaseYear() {

		for (int i = 1; i <= 4; i++) {
			System.out.println(driver.findElement(
					By.xpath(ObjectRepository.ImdbElements.releaseYear.replace(
							"rowNum", Integer.toString(i)))).getText());
		}
	}

	public void getMovieRating() {

		for (int i = 1; i <= 4; i++) {
			System.out.println(driver.findElement(
					By.xpath(ObjectRepository.ImdbElements.movieRating.replace(
							"rowNum", Integer.toString(i)))).getText());
		}
	}

	public void storeValueinList() {
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 1; i < 250; i++) {
//			map.put("name",
//					driver.findElement(
//							By.xpath(ObjectRepository.ImdbElements.movieTitle
//									.replace("rowNum", Integer.toString(i))))
//							.getText());
		map.put("name", wrap.findWebElement(ObjectRepository.ImdbElements.movieTitle
				.replace("rowNum", Integer.toString(i)), "xpath").getText()); 
		
		
			map.put("year",
					driver.findElement(
							By.xpath(ObjectRepository.ImdbElements.releaseYear
									.replace("rowNum", Integer.toString(i))))
							.getText());
			map.put("rating",
					driver.findElement(
							By.xpath(ObjectRepository.ImdbElements.movieRating
									.replace("rowNum", Integer.toString(i))))
							.getText());
			databaseInsert(map);
		}
	}

	public void printFile() {
		// TODO Auto-generated method stub

		printFileFromDB();

	}

	public void printFileFromDB() {
		
		Connection c = null;
		Statement stmt = null;
		BufferedWriter bw = null;
		FileWriter fw;

		try {
			File file = new File("filename3.txt");

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
			c = DriverManager.getConnection("jdbc:sqlite:test4.db");
			// c.setAutoCommit(false);
			System.out.println("Opened database successfully " + c.toString());

			stmt = c.createStatement();

			String sql = "Select * from imdbrating5;";

			ResultSet rs = stmt.executeQuery(sql);
		
			while (rs.next()) {

				System.out.println("Name= " + rs.getString(1));
				System.out.println("Name2= " + rs.getString(2));
				System.out.println("Name3= " + rs.getString(3));
				System.out.println("Name3= " + rs.getString(4));

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

		// return outputMap;

	}
}
