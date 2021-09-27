import edu.duke.*;
import java.util.*;
import java.io.*;

public class countCodon {
   
     HashMap<String,Integer>DnaMap=new HashMap<String,Integer>();
   
   public void buildCodonMap(int start,String dna1)
   {
       String dna=dna1.toUpperCase();
       dna=dna.trim();
       int count=0;
       while(true)
       {
          int loc=start+3;
         
          if (loc > dna.length()) 
          {
            break;
          }
          String codon=dna.substring(start,loc);
          
          if(DnaMap.containsKey(codon))
          {
            DnaMap.put(codon,DnaMap.get(codon)+1);  
          }
          else
          {
              DnaMap.put(codon,1);
               count++;
          }
          start=start+3;
                 
        }
       System.out.println("\nUniqe Codons: "+count);
    }
    
    public String getMostCommonCodon()
    {
        int max=0;
        
        for(String s:DnaMap.keySet())
        {
            int maxindex=DnaMap.get(s);
            if(maxindex > max)
            {
                max=maxindex;
            }
          
        }
          for(String s:DnaMap.keySet())
        {
           if(DnaMap.get(s)==max)
          {
            return s;
          }
         }
         return "worng";
    }
    
    public void  printCodonCounts(int start,int end)
    {
        System.out.println("Codon between : "+start+" and "+end);
        for(String s:DnaMap.keySet())
        {
            int value=DnaMap.get(s);
            if(value>=start && value<=end)
            {
                System.out.println(s+"\t"+value);
            }
        }
    }
    
    public void testing()
    {
      FileResource fr=new FileResource();
      String fs=fr.asString();
     
     int start=0;
     for(start=0;start<=2;start++)
      {
        
         buildCodonMap(start,fs); 
      
         System.out.println("Result with start:= "+start); 
        for(String s:DnaMap.keySet())
         {
          System.out.println(s+"\t"+DnaMap.get(s));
         }
        String s=getMostCommonCodon();
        System.out.println("largest number codon is: "+s+"\t"+DnaMap.get(s));
      
       printCodonCounts(2,4);
       DnaMap.clear();
      }
    
    }
 
}
