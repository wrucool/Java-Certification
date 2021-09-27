import edu.duke.*;
import java.util.*;
import java.io.*;

public class countwords {
    public void uniqueword()
    {
      HashMap<String,Integer> map=new HashMap<String,Integer>();
        DirectoryResource dr=new DirectoryResource();
        for(File f:dr.selectedFiles())
        {
        FileResource fr=new FileResource(f);
       
   
          for(String w:fr.words())
         {
        w=w.toLowerCase();
        if(map.keySet().contains(w))
        {
            map.put(w,map.get(w)+1);
        }
        else
        {
            map.put(w,1);
        }
       }
   }
       
    
    for(String w:map.keySet())
    {
        int occur=map.get(w);
        if(occur>200)
        {
            System.out.println(occur+"\t"+w);
        }
        
    }

  
 }
}