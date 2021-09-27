import edu.duke.*;
import java.util.*;
import java.io.*;

public class wordsInFiles {

    private HashMap<String,ArrayList<String>> wordmap;
    public wordsInFiles()
    {
        wordmap = new HashMap<String,ArrayList<String>>();
    }
    
    private void addWordsFromFile(File f)
    {     
       FileResource fr=new FileResource(f);
       String fname=f.getName();
        for(String word:fr.words())
       {
        if(!wordmap.containsKey(word))
        {
            ArrayList<String> flist=new ArrayList<String>();
            flist.add(fname);
            wordmap.put(word,flist);
        }
        else
        {
            ArrayList<String> flist1=wordmap.get(word);
            if(!flist1.contains(fname))
            {
                flist1.add(fname);
            }
            wordmap.put(word,flist1);
        }
          
       
       } 
    }
      
    
    public void buildWordFileMap()
    {
        wordmap.clear();
        DirectoryResource dr=new DirectoryResource();
        for(File f:dr.selectedFiles())
        {
            addWordsFromFile(f);
        }
        
    }
    
    public int maxNumber()
    {
        int max=0;
        
        for(String s:wordmap.keySet())
        {
            int value=wordmap.get(s).size();
            if(value>max)
            {
                max=value;
               
            }
             
        }
     
      return max;
    }
    
    public ArrayList wordsInNumFiles(int num)
    {
        ArrayList<String> list=new ArrayList<String>();
        for(String s:wordmap.keySet())
        {
            
            if(wordmap.get(s).size()==num)
            {
               list.add(s);
            }
        }
        return list;
    }
    
    public void printFilesIn(String word)
    {
        for(String s:wordmap.keySet())
        {
         if(s.equals(word))
         {
             ArrayList<String> list=wordmap.get(s);
             System.out.println("word '"+s+"' appears in:");
             for(int k=0;k<list.size();k++)
             {
             System.out.println(list.get(k));
            }
            }
        }
           
   }
    
    
    public void tester()
    {
       buildWordFileMap();   
       
       for(String s:wordmap.keySet())
       {
          System.out.println(s+" \t:"+wordmap.get(s)); 
       }
       int max= maxNumber();
       int count=0;
       System.out.println("\nwords in maximum files:");
       for(String s:wordmap.keySet())
       {
          if(wordmap.get(s).size()==max)
          {
         // System.out.println(s+"\t"+max);
          count++;
        }
       }
       System.out.println("count: "+count);
       System.out.println("\nwords in file with given number:");
       ArrayList<String> list=wordsInNumFiles(4);
       System.out.println(list.size());
       System.out.println("\nFile names with given word:");
       printFilesIn("laid");
  }
}
