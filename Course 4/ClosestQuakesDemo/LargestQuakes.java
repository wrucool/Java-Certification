
/**
 * Write a description of LargestQuakes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


    import java.util.*;

public class LargestQuakes
{
  public int indexOfLargest(ArrayList<QuakeEntry> quakeData)
  {
      double maxMag=0;
          int count=0;
      for(QuakeEntry qe:quakeData)
      {
      
        double Mag= qe.getMagnitude();
        if(Mag>maxMag)
        {
            count++;
            maxMag=Mag;
            
        }
      }
      return count;
    }
    
   public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData,int howMany){
        ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(quakeData);
        ArrayList<QuakeEntry> ret = new ArrayList<QuakeEntry>();
        for(int j=0; j < howMany; j++) {
            int minIndex = 0;
            for(int k=1; k < copy.size(); k++)
            {
             QuakeEntry quake=copy.get(k);
             Double magmax=quake.getMagnitude();
             if(magmax> copy.get(minIndex).getMagnitude())
             {
                 minIndex=k;
             }
                            
            }
          
            ret.add(copy.get(minIndex));
            copy.remove(minIndex);
        }
        return ret;
   }
    
   public void findLargestQuakes(){
       EarthQuakeParser parser = new EarthQuakeParser();
		String source = "data/nov20quakedata.atom";
		//String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
		ArrayList<QuakeEntry> list  = parser.read(source);
		System.out.println("read data for " + list.size());
		
		Location jakarta  = new Location(-6.211, 106.845);
        
		ArrayList<QuakeEntry> close = getLargest(list,15);
		for(int k=0; k < close.size(); k++)
		{
			QuakeEntry entry = close.get(k);
			System.out.println(entry);
        }
		
		//System.out.println("number found: " + close.size());
   }
}


