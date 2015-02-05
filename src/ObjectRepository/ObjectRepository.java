package ObjectRepository;

import functional_test.ImdbTop50Test;

public class ObjectRepository {
	
	public static class Objects{
//		ImdbTop50Test imdbObj = new ImdbTop50Test();
		 
		
	}
	
	public static class ImdbElements {
	public static final String watchList = "//li[@id='navWatchlistMenu']//a[text()='Watchlist']"; //xpath
	public static final String top250Link = "//a[text()='IMDb Top 250']"; //xpath
	public static final String movieTitle =	"//tbody[@class='lister-list']//tr[rowNum]/td[2]//a"; //xpath
	public static final String releaseYear = "//tbody[@class='lister-list']//tr[rowNum]/td[2]//span[@class='secondaryInfo']"; //xpath
	public static final String movieRating = "//tbody[@class='lister-list']//tr[rowNum]/td[3]//strong"; //xpath	
			}

}
