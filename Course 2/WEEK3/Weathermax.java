import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class Weathermax {
    public CSVRecord hotesthourTemp(CSVParser p1)
     {
       CSVRecord hottemp = null;
       for(CSVRecord currentrow :p1)
       {
           String s=currentrow.get("TemperatureF");
           if(s.equals("-9999")==false)
           {
           hottemp = hotestTemp(currentrow,hottemp); 
          }
    }
      return hottemp;
   }
    public void testing()
   {   
     FileResource fr=new FileResource();
     CSVParser cp=fr.getCSVParser();
     CSVRecord temp= hotesthourTemp(cp);
     System.out.println("hotest temp was "+temp.get("TemperatureF")+" at "+temp.get("DateUTC"));
    
   }
   
   public CSVRecord hotestDayYear()
    { CSVRecord hottemp=null;
      DirectoryResource dr=new DirectoryResource();
      for(File f:dr.selectedFiles())
      {
       FileResource fr=new FileResource(f);
       CSVParser cp=fr.getCSVParser();
       CSVRecord currentrow = hotesthourTemp(cp);
       hottemp=hotestTemp(currentrow,hottemp);
       }
      return hottemp;
     }
   
   public CSVRecord hotestTemp(CSVRecord currentrow,CSVRecord hottemp)
   {    
       
       if(hottemp == null)
        {
          hottemp=currentrow;  
        }
        else
        {
        double currenttemp=Double.parseDouble(currentrow.get("TemperatureF"));
        double largesttemp=Double.parseDouble(hottemp.get("TemperatureF"));
        if(currenttemp < largesttemp)
        {
              hottemp=currentrow;
        }
         }
          return hottemp;
    }
  
   
    public void testforyear()
    {
     CSVRecord yeartemp=hotestDayYear(); 
     System.out.println("hotest temp was "+yeartemp.get("TemperatureF")+" at "+yeartemp.get("DateUTC"));
    }
}
