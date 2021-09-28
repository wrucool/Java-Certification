
/**
 * Write a description of FirstRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;

public class FirstRatings {
    
    public ArrayList<Movie> loadMovies(String filename) {
        FileResource fr = new FileResource(filename);
        CSVParser parser = fr.getCSVParser();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        for(CSVRecord crec : parser) {
            String id = crec.get("id");
            String title = crec.get("title");
            String year = crec.get("year");
            String genres = crec.get("genre");
            String director = crec.get("director");
            String country = crec.get("country");
            String poster = crec.get("poster");
            int minutes = Integer.parseInt(crec.get("minutes").trim());
            
            Movie myMovie = new Movie(id,title,year,genres,director,country,poster,minutes);
            movies.add(myMovie);
        }
        return movies;
    }
    
    public ArrayList<Rater> loadRaters(String filename) {
        FileResource fr = new FileResource(filename);
        CSVParser parser = fr.getCSVParser();
        ArrayList<Rater> raters = new ArrayList<Rater>();
        HashSet<String> raterIdSet = new HashSet<String>();
        for(CSVRecord crec : parser) {
            String id = crec.get("rater_id");
            String item = crec.get("movie_id");
            double rating = Double.parseDouble(crec.get("rating"));
            if(!raterIdSet.contains(id)) {
                raterIdSet.add(id);
                Rater r = new EfficientRater(id);
                r.addRating(item, rating);
                raters.add(r);
               // System.out.println("raters"+ raters);
            }
            else {
                for(Rater currentRater : raters) {
                    if(currentRater.getID().equals(id)) {
                        currentRater.addRating(item, rating);
                    }
                }
            }
        }
        return raters;
    }
    
    public void testLoadMovies() {
        //String source = "data/ratedmoviesfull.csv";
        String source ="data/ratedmovies_short.csv";
        ArrayList<Movie> movies = loadMovies(source);
        
       for(Movie movie: movies) {
           //System.out.println(movie);
           // System.out.println("Poster URL is: "+movie.getPoster()+" Directors: "+movie.getDirector()+" Minutes: "+movie.getMinutes());
        }
        
       System.out.println("There are "+movies.size()+" movies in the movie list.");
       
       ArrayList<Movie> comedyMovies = new ArrayList<Movie>();
       for(Movie movie: movies) {
           String genres = movie.getGenres().toLowerCase();
           if(genres.indexOf("comedy") != -1) 
           {
               comedyMovies.add(movie);
           }           
       }
       System.out.println("The number of comdey film is "+comedyMovies.size()+".");
      
       ArrayList<Movie> moviesLargeLength = new ArrayList<Movie>();
       for(Movie movie: movies) {
           int length = 150;
           if(movie.getMinutes()>length) {
               moviesLargeLength.add(movie);
           }           
       }
       System.out.println("The number of the film whose length is greater than 150min is "+moviesLargeLength.size()+".");   
        
       HashMap<String, ArrayList<Movie>> directorsMap = new HashMap<String, ArrayList<Movie>>(); 
       for(Movie movie: movies) {
           String directors = movie.getDirector();
           //int index = directors.indexOf(",",0);
                     
           String[] directorArray = directors.split(",");
           for(String director: directorArray) {
                   director = director.trim();
                 if(!directorsMap.containsKey(director)) {
                   ArrayList<Movie> directorMovies = new ArrayList<Movie>();
                   directorMovies.add(movie);
                   directorsMap.put(director, directorMovies);
                }
                 else {
                   if(!directorsMap.get(director).contains(movie)) {
                       directorsMap.get(director).add(movie);
                   }
                }                   
           }
           
        }
        // System.out.println("directors are: "+ directorsMap);
       int max = 0;
       for(ArrayList<Movie> directorMovies : directorsMap.values()) {
           if(directorMovies.size() > max) {
               max= directorMovies.size();
             }
         //   System.out.println("directors are: "+ directorMovies);
       }
       System.out.println("The maximum number of movies by any director is "+max);
       //Find the maximum number of movies by any director.
      
       for(String director: directorsMap.keySet()) {
           if(directorsMap.get(director).size() == max) {
              System.out.println(" director is: "+ director);
           }
       }
           
    }
    
    public void testLoadRaters() {
        //String source = "data/ratings_short.csv";
        String source = "data/ratings.csv";
        ArrayList<Rater> raters = loadRaters(source);
        System.out.println("The total number of rater is: "+raters.size());
       // Print out all the raters and its ratings.
       String raterID = "193";
       int numRatings = 0;
       for(Rater rater: raters) {
           if(rater.getID().equals(raterID)) {
               numRatings = rater.numRatings();
           }
       }
       System.out.println("For rater ID "+raterID+": The number of ratings in this rater is " + numRatings);
       // Find the number of ratings for a particular rater.
       int max = 0;
       for(Rater rater: raters) {
           if(rater.numRatings() > max) {
              max = rater.numRatings();
           }
       }
        System.out.println("The maximum number of ratings is "+max);
       // Find the largest number of ratings a rater has.
       ArrayList<Rater> maxRatingsRaters = new ArrayList<Rater>();
       for(Rater rater: raters) {
           if(rater.numRatings() == max
           ) {
              System.out.println("Rater ID of max number of ratings:"+rater.getID());
           }
       }
      
       // Find raters which have the largest number of ratings.
       String movieID = "1798709";
       int numOfRater = 0;
       for(Rater rater: raters) {
           if(rater.hasRating(movieID)) {
               numOfRater++;
           }
       }
       System.out.println("Movie "+movieID+" is in "+numOfRater+" raters.");
       // Find the number of raters for a particular movie ID.
       HashSet<String> moviesSet = new HashSet<String>();
       for(Rater rater: raters) {
           ArrayList<String> raterMovieList = rater.getItemsRated();
           for(String movieId : raterMovieList) {
               if(!moviesSet.contains(movieId)) {
                   moviesSet.add(movieId);
               }
           }
       }
       System.out.println("There are "+moviesSet.size()+" movies rated.");
       
             
    }
}

