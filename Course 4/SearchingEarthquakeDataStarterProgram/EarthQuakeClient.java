import java.util.*;
import edu.duke.*;

public class EarthQuakeClient {
    public EarthQuakeClient() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData,
    double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
       for (QuakeEntry qe : quakeData) {
            if (qe.getMagnitude() > magMin) {
                answer.add(qe);
            }
        }
        return answer;
    }

    public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData,
    double distMax,
    Location from) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
      for (QuakeEntry qe : quakeData) {
            if (qe.getLocation().distanceTo(from) < distMax) {
                answer.add(qe);
            }
        }
        return answer;
    }
    
     public ArrayList<QuakeEntry> filterByDepth(ArrayList<QuakeEntry> quakeData, double minDepth,double maxDepth)
       {
        ArrayList<QuakeEntry> myDepth = new ArrayList<QuakeEntry>();
        //TODO
        System.out.println("QuakeEntry between "+minDepth+" and "+maxDepth);
        for (QuakeEntry qe : quakeData) {
            double depth=qe.getDepth();
            if (minDepth < depth && depth < maxDepth)
            {
              myDepth.add(qe);  
            }
        }
        return myDepth;              
    }
    
    public void quakeOfDepth()
    {
      EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("read data for " + list.size() + " quakes");  
        
        ArrayList<QuakeEntry> myDepth=filterByDepth(list,-10000.0,-8000.0);
         for (QuakeEntry qe : myDepth) {
           System.out.println(qe); 
        }
        System.out.println("Found "+myDepth.size()+" quakes that match this criteria");
    }
    
     public ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry> quakeData, String where,String phrase)
     {
        ArrayList<QuakeEntry> myPhrase = new ArrayList<QuakeEntry>();
        //TODO
        
        for (QuakeEntry qe : quakeData) {
            String title=qe.getInfo();
            if(where.equals("Start"))
            {
              if(title.startsWith(phrase))
              {
              myPhrase.add(qe);  
             }
            }
            else if(where.equals("End"))
            {
              if(title.endsWith(phrase))
                {
                 myPhrase.add(qe);  
                }
            }
            else if(where.equals("any"))
            {
                if(title.contains(phrase))
                {
                    myPhrase.add(qe);
                }
            }
                    
    }
     return myPhrase; 
  }
    
  public void quakeByPhrase()
    {
      EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("read data for " + list.size() + " quakes");  
        
        ArrayList<QuakeEntry> myPhrase=filterByPhrase(list,"any","Creek");
         for (QuakeEntry qe : myPhrase) {
           System.out.println(qe); 
        }
       System.out.println("Found "+myPhrase.size()+" quakes that match this criteria");
    }
    
   public void dumpCSV(ArrayList<QuakeEntry> list)
   {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }

  }

  public void bigQuakes() 
  {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        ArrayList<QuakeEntry> listBig = filterByMagnitude(list, 5.0);
        for (QuakeEntry qe : listBig) {
           System.out.println(qe); 
        }
  }

  public void closeToMe()
  {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");

        // This location is Durham, NC
        //Location city = new Location(35.988, -78.907);

        // This location is Bridgeport, CA
         Location city =  new Location(38.17, -118.82);
         ArrayList<QuakeEntry> close = filterByDistanceFrom(list, 1000*1000, city);
        for (int k=0; k< close.size(); k++) {
            QuakeEntry entry = close.get(k);
            double distanceInMeters = city.distanceTo(entry.getLocation());
            System.out.println(distanceInMeters/1000 + " " + entry.getInfo());
        }
       System.out.println("Found "+ close.size()+" quakes that match that criteria");
        
    }

    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }
    }
    
}
