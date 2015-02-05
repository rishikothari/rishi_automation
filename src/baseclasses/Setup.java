package baseclasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Setup {

	public static WebDriver driver = null;
	
//	@BeforeSuite
//	@Parameters({"browserName"})
//	public void openBrowser( String browserName)
//	{
//		System.out.println(browserName);
//		
//		if (browserName.equals("Firefox"))
//		{
//			driver = new FirefoxDriver();
//		}
//		else
//			if (browserName.equals("chrome")) 
//			{
//				driver = new ChromeDriver();
//			}
//			else 
//				if (browserName == "safari")
//			{
//				driver = new SafariDriver();
//			}
//	}
	
	  public   void databaseInsert (HashMap<String, String> map)
	  {
//		 HashMap<String,String> map1 = new HashMap<String, String>();
	
		
		 
	    Connection c = null;
	    Statement stmt = null;
	  
	    String title = map.get("name");
	    String release = map.get("year");
	    String rating =map.get("rating");
	    
	    //static  int count =1;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test4.db");
	      //c.setAutoCommit(false);
	      System.out.println("Opened database successfully "+c.toString());
	      
	      stmt = c.createStatement();
	      String sql = "CREATE TABLE IF NOT EXISTS imdbRating "   +
	                   "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"  +
	                   " TITLE           TEXT    NOT NULL," + 
	                   " RELEASE         TEXT    NOT NULL," + 
	                   " RATING          TEXT    NOT NULL)" ; 

	      
	      
	      stmt.executeUpdate(sql);
	      
	      
	      System.out.println("INSERT INTO imdb (TITLE,RELEASE,RATING) " +
		    		 "VALUES ('" + title + "','" + release + "','" + rating + "');");
	      
	      sql = "INSERT INTO imdbRating (TITLE,RELEASE,RATING) " +
		    		 "VALUES ('" + title + "','" + release + "','" + rating + "');";  
	     
        stmt.executeUpdate(sql);
   
	      stmt.close();
	      c.close();
	      
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Table created successfully");
	  }

	
//	@AfterSuite
//	public void closeBrowser()
//	{
//		driver.quit();
//	}
}
