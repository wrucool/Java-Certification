
/**
 * Write a description of findDNA here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

    import edu.duke.*;
import java.io.*;

public class findDNA {
     public StorageResource findProtein(String dna)
     { 
         StorageResource store=new StorageResource();
         int start=0;
         int stop=0;
         String mysub="";
         while(true)
         {
		   int loc= dna.indexOf("atg",start);
		   //System.out.println(start);
		  if (loc == -1) {
			break;
		  }
		  start=loc+3;
		  stop=dna.indexOf("tag",loc+3);
		   //System.out.println("my value="+(stop-start));
		     if ((stop - loc) % 3 == 0) {
		     
			   mysub=dna.substring(loc,stop+3);
			   //System.out.println("gene found are : "+ mysub);
			    store.add(mysub);         
            }
           
          
        }
        //System.out.println("gene found are : "+ mysub);
        return store;
    }
     
    /* public int findStopIndex(String dna, int index){
    
         int stop1 = dna.indexOf("tga", index);
           if (stop1 == -1 || (stop1-index) % 3 != 0){
              stop1 = dna.length();
           }
         int stop2 = dna.indexOf("taa", index);
         if (stop2 == -1 || (stop2-index) % 3 != 0){
               stop2 = dna.length();
           }
         int stop3 = dna.indexOf("tag", index);
         if (stop3 == -1 || (stop3-index) % 3 != 0){
            stop3 = dna.length();
          }
         int stop=Math.min(stop1, Math.min(stop2,stop3));
         //System.out.println(stop);
         return stop;
    
    }*/
    
    public void testingAllGene()
     {
      // String s="atgccctaataaatgtctgtaatgtaga";
       // String s="ATGAAATGAAAA";
    
     /*  String s="CATGTAATAGATGAATGACTGATAGATATGCTTGTATGCTATGAAAATGTGAAATGACCCA";
         String sub=s.toLowerCase();
       System.out.println(sub.length());*/
        int count1 =0;
         int count2 =0;
      float cgratio=0;
      
      DirectoryResource dr=new DirectoryResource();
       for(File f:dr.selectedFiles())
       {
       FileResource fr=new FileResource(f);
       String mysub = fr.asString();
      // System.out.println(sub.length());
      String sub=mysub.toLowerCase();
      StorageResource s1=findProtein(sub);
       System.out.println(s1.size());
     System.out.println(" Dna Strings found are:");
       for(String s2:s1.data())
     {
    
      if(s2.length() > 60)
      {
        System.out.println(s2+" length is : "+ s2.length());
        count1=count1+1;   
      }
    }
     System.out.println("Total gene more than 60 nucleotides := "+count1);
    System.out.println("CGRatio higher than 0.35 Strings are ");
     for(String s2:s1.data())
     {
      cgratio=findCGRatio(s2);
    
       if(cgratio > 0.35)
       {
          System.out.println(s2+"   " +cgratio);
          count2=count2+1;
       }
     }
     System.out.println(" Total strings with cgratio higher than 0.35 are : "+ count2);
    
   }
 }
 public float findCGRatio(String dna)
{
   int length=dna.length();
     int cstart=0;
     int gstart=0;
     int count=0;
     while(true)
     {
       int cloc=dna.indexOf("c",cstart);
        count=count+1;
       
       if(cloc== -1)
       {
           break;
       }
       cstart=cloc+1;
      
        int gloc=dna.indexOf("g",gstart); 
        count=count+1;
        
       if(gloc == -1)
        {
           break;
        }
        gstart=gloc+1;
        
     }
     
   float average=(float)count/(float)length;
  // System.out.println(average);
     return average;
   }
   
}




