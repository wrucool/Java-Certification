
import java.util.*;

public class MovieRunnerAverage {
	public void printAverageRatings() {
		//SecondRatings sr = new SecondRatings("data/ratedmovies_short.csv", "data/ratings_short.csv");
		SecondRatings sr = new SecondRatings("data/ratedmoviesfull.csv", "data/ratings.csv");
		System.out.println("The number of movies: " + sr.getMovieSize());
	    System.out.println("The number of raters: " + sr.getRaterSize());
        //System.out.println(sr.getAverageByID("0068646", 4));
	    int minimalRaters =12;
	    ArrayList<Rating> ratings = sr.getAverageRatings(minimalRaters);
	    System.out.println(ratings.size());
	    Collections.sort(ratings);
	    
	    for(int i=0;i<10;i++) 
	    {
	       	System.out.println(ratings.get(i).getValue() + " " + sr.getTitle(ratings.get(i).getItem()));
	    }
	    System.out.println(sr.getID("THE LIFE"));
	}
	
	public void getAverageRatingOneMovie() {
	    SecondRatings sr = new SecondRatings("data/ratedmoviesfull.csv", "data/ratings.csv");
		//SecondRatings sr = new SecondRatings("data/ratedmovies_short.csv", "data/ratings_short.csv");
		String movieTitle = "Vacation";
		String movieID = sr.getID(movieTitle);
		int minimalRaters = 0;
		ArrayList<Rating> ratings = sr.getAverageRatings(minimalRaters);
		for(Rating r: ratings) {
			if(r.getItem().equals(movieID))
			{
				System.out.println("The average rating for the movie \"" + movieTitle + "\" is " + r.getValue());
		    }
        }
	}
}