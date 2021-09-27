
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;


public class WeatherMin{
    public CSVRecord coldesthourTemp(CSVParser p1)
     {
       CSVRecord coldtemp = null;
       System.out.println("All the temperature on the coldest day were:");
       for(CSVRecord currentrow :p1)
       {
          coldtemp = coldestTemp(currentrow,coldtemp); 
          System.out.println (currentrow.get("DateUTC")+" "+coldtemp.get("TemperatureF"));
       }
      
      return coldtemp;
        
   }
  
   public void testing()
   { 
     FileResource fr=new FileResource();
    
     CSVParser cp=fr.getCSVParser();
     CSVRecord temp= coldesthourTemp(cp);
     System.out.println("coldest temp was "+temp.get("TemperatureF"));
    
   } 
   
   public CSVRecord coldestDayYear()
    { CSVRecord coldtemp=null;
     
      DirectoryResource dr=new DirectoryResource();
      for(File f:dr.selectedFiles())
      {
      FileResource fr=new FileResource(f);
       CSVParser cp=fr.getCSVParser();
       System.out.println("Coldest day was in file "+f.getName());
       CSVRecord currentrow = coldesthourTemp(cp);
       coldtemp=coldestTemp(currentrow,coldtemp);
      
       
      }
      
      return coldtemp;
     }
   
   public CSVRecord coldestTemp(CSVRecord currentrow,CSVRecord coldtemp)
   {    
       
       if(coldtemp == null)
        {
          coldtemp=currentrow;  
        }
        else
        {
        double currenttemp=Double.parseDouble(currentrow.get("TemperatureF"));
        double largesttemp=Double.parseDouble(coldtemp.get("TemperatureF"));
        if(currenttemp < largesttemp)
        {
              coldtemp=currentrow;
        }
         }
          return coldtemp;
    }
  
   
    public void testforyear()
    {
     CSVRecord yeartemp=coldestDayYear(); 
     System.out.println("coldest temp on that day was "+yeartemp.get("TemperatureF"));
    }
    
    
}
