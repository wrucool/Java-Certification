
import edu.duke.*;
import org.apache.commons.csv.*;
public class findcountry {
    public void listofcountry(CSVParser pr,String exportitem1)
    {
         int count=0;
      for(CSVRecord cvr :pr)
      {
          String export=cvr.get("Exports");
         
          if(export.contains(exportitem1))
          {
              String record = cvr.get("Country");
              System.out.println(record);
              count=count+1;
            }
            
        }
       System.out.println("export countries:"+ count); 
    }
    
    public void testing()
    {
        FileResource fr=new FileResource();
        CSVParser cr= fr.getCSVParser();
        listofcountry(cr,"sugar");
    }

}
