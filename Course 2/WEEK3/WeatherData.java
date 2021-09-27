
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class WeatherData {
    
    public CSVRecord coldestHourInFile(CSVParser p1)
    {
      CSVRecord coldtemp=null;
      for(CSVRecord currentrow:p1)
      {
          if(coldtemp == null)
          {
              coldtemp = currentrow;
          }
         
         else 
          {
           double currenttemp=Double.parseDouble(currentrow.get("TemperatureF"));
           double largesttemp=Double.parseDouble(coldtemp.get("TemperatureF"));
           if(currenttemp < largesttemp)
           {
              coldtemp=currentrow;
              
            }
            System.out.println (coldtemp.get("DateUTC")+" "+coldtemp.get("TemperatureF"));
         }
         
      }
       return coldtemp;
    } 
    
    public void testing()
    {
      DirectoryResource dr=new DirectoryResource();
      for(File f:dr.selectedFiles())
      {
         FileResource fr=new FileResource(f);  
         CSVParser cp=fr.getCSVParser();
         CSVRecord temp= coldestHourInFile(cp);
          System.out.println("Coldest day was in file "+f.getName());
         System.out.println("coldest temp was "+temp.get("TemperatureF"));
        
        }
         
    }
    
    public CSVRecord lowestHumidityinday(CSVParser p2)
    {
      CSVRecord lowhum=null;
      for(CSVRecord currentrow:p2)
      {
          String s=currentrow.get("Humidity");
         if(s.equals("N/A")==false)
         {
           lowhum=lowestHumidity(currentrow,lowhum); 
           
        }
      }
       return lowhum;
    }
    
    public CSVRecord lowestHumidity(CSVRecord currentrow,CSVRecord lowhum)
    {
         if(lowhum == null)
          {
              lowhum = currentrow;
          }
         
          
          else{
           double currenthum=Double.parseDouble(currentrow.get("Humidity"));
           double lowesthum=Double.parseDouble(lowhum.get("Humidity"));
           if(currenthum < lowesthum)
           {
              lowhum=currentrow;
              
            }
            
         }
         return lowhum;
    }
    
    public CSVRecord lowHumidityinYear()
    {
      CSVRecord lowhum=null;  
      DirectoryResource  dr=new DirectoryResource();
      for(File f:dr.selectedFiles())
      {
       FileResource fr=new FileResource(f);
       CSVParser cp=fr.getCSVParser();
       CSVRecord lowhumidity=lowestHumidityinday(cp);
       lowhum=lowestHumidity(lowhumidity,lowhum);
       //System.out.println("Lowest Humidity was "+lowhumidity.get("Humidity")+" at "+lowhumidity.get("DateUTC"));
                                                                                
     }
     return lowhum;
   }
   
   public void testlowHumidityYear()
   {
      CSVRecord yearlowhum= lowHumidityinYear();
      System.out.println("Lowest Humidity was "+yearlowhum.get("Humidity")+" at "+yearlowhum.get("DateUTC"));
  }
  
  public double averagetemp(CSVParser p3)
  { int count=0;
    double sum=0;
    
    for(CSVRecord currentrow:p3)
    {
       double currenttemp=Double.parseDouble(currentrow.get("TemperatureF"));  
       sum=currenttemp+sum;
       count=count+1;
    }
    double average=sum/count;
   
    return average;
   }
   
  public void testaverage()
   {
    FileResource fr=new FileResource();
    CSVParser cp=fr.getCSVParser();
    double average = averagetemp(cp); 
     System.out.println(average);
    CSVParser cp1=fr.getCSVParser(); 
   double highhumavg = averagehighHumidity(cp1,80);
    System.out.println("Average temp when high humidity "+ highhumavg);
  }

    public double averagehighHumidity(CSVParser p4,int value)
    {int count=0;
    double sum=0;
    
    for(CSVRecord currentrow:p4)
    {
      double currenttemp = Double.parseDouble(currentrow.get("TemperatureF"));
       int humidity=Integer.parseInt(currentrow.get("Humidity"));
       if(humidity >= value)
       {
          sum=currenttemp+sum;
          count=count+1;
       }
       else
       {
           System.out.println("no temp with that humidity");
        }
     }
    double average=sum/count;
    return average;
  }
  
  
}
