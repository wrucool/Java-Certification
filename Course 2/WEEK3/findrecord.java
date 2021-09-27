
import edu.duke.*;
import org.apache.commons.csv.*;
public class findrecord {
          public void myrecord()
          {
              FileResource fr=new FileResource();
              CSVParser p= fr.getCSVParser();
              for(CSVRecord r:p)
              {
               System.out.print(r.get("Name")+":");
               System.out.print(r.get("Birthdate")+":");
               System.out.println(r.get("Fav color"));
               }
           
          }
        
}
