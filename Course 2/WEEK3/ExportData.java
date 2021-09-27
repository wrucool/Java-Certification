import edu.duke.*;
import org.apache.commons.csv.*;

public class ExportData {
    public void countryInfo(CSVParser p1,String c1)
    {
        for(CSVRecord r1:p1)
        {
        String country= r1.get("Country");
        String export=r1.get("Exports");
        String value=r1.get("Value (dollars)");
        if(country.equals(c1))
        {
         System.out.println(country+":"+export+":"+value);   
        } 
    }
    }
    public void listExportersTwoProducts(CSVParser p2,String ex1,String ex2)
    {
      for(CSVRecord r2 : p2)
      {
       String country1=r2.get("Country");   
       String export1=r2.get("Exports");  
       if((export1.contains(ex1))&&(export1.contains(ex2)))
       {
         System.out.println(country1);  
        }   
    }
    }
    public void numberOfExporters(CSVParser p3,String ex3)
    {
        int count=0;
     for( CSVRecord r3:p3)
    {
         String export2=r3.get("Exports");
         if(export2.contains(ex3))
         {
         count=count+1;
        }
    }
     System.out.println("Number of Exporters : "+count);   
    }
    public void bigExporters(CSVParser p4,String amount)
    {
      for(CSVRecord r4 :p4)
      {
        String country2=r4.get("Country");
        String value1=r4.get("Value (dollars)");
        if((value1.length())>(amount.length()))
        {
          System.out.println(country2+"  "+value1);  
        }
    }
    }
    public void testing()
    {
        FileResource fr=new FileResource();
        CSVParser pr1=fr.getCSVParser();
        System.out.println("1.COUNTRY INFORMATION");
        countryInfo(pr1,"India");
        CSVParser pr2=fr.getCSVParser();
        System.out.println("\n2.LIST OF EXPORTERS WITH TWO PRODUCTS");
        listExportersTwoProducts(pr2,"cotton","flowers");
         CSVParser pr3=fr.getCSVParser();
        System.out.println("\n3.LIST OFNUMBER OF EXPORTERS");
        numberOfExporters(pr3,"cocoa");  
        CSVParser pr4=fr.getCSVParser();
        System.out.println("\n4.LIST OF BIG EXPORTERS");
        bigExporters(pr4,"$999,999,999,999");
    }
}
