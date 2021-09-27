
import edu.duke.*;
import org.apache.commons.csv.*;
public class datarecord {
     public void showdata(){
         FileResource fr=new FileResource();
         CSVParser cp=fr.getCSVParser();
         for(CSVRecord cr:cp)
         {
             String record=cr.get("Country");
             String value=cr.get("Value (dollars)");
             int length=value.length();
             if(length>16)
             {
                 System.out.println("Country: "+ record+" value:"+ value);
                }
          /*   if(record.equals("Nauru"))
             {
                 System.out.println(record+" exportitem: "+export);
                }
          if(record.startsWith("A"))
          {
          System.out.println(record);   
         }*/

        }
   }
}
 