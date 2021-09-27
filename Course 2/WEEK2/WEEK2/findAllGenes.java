
import edu.duke.*;
import java.io.*;

public class findAllGenes {
     public StorageResource findProtein(String dna)
     { 
         StorageResource store=new StorageResource();
         int start=0;
         int stop=0;
         int loc=0;
         String mysub="";
         while(true)
         {
		   loc= dna.indexOf("atg",start);
		   //System.out.println(start);
		  if (loc == -1) {
			break;
		  }
		    start=loc+3;
		  
		  
            stop=findStopIndex(dna,start);
          
            //stop=stop+3;
            if(stop < dna.length())
          {
             if((stop-start)%3==0)
             {
               mysub=dna.substring(loc,stop+3);
			   //System.out.println("gene found are : "+ mysub);
			   store.add(mysub); 
			   start=stop+3;         
             }
             
           }   
           
        }
        
        //System.out.println("gene found are : "+ mysub);
        return store;
    }
     
     public int findStopIndex(String dna, int index){
    
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
    
    }
    
    public void testingAllGene()
    {
      
       // String s="ATGAAATGAAAA";
    
     /*  String s="CATGTAATAGATGAATGACTGATAGATATGCTTGTATGCTATGAAAATGTGAAATGACCCA";
         String sub=s.toLowerCase();
       System.out.println(sub.length());*/
        int count1 =0;
         int count2 =0;
      double cgratio=0;
     int fcount=0;
     int c=0;
     DirectoryResource dr=new DirectoryResource();
   for(File f:dr.selectedFiles())
       {
       
       FileResource fr=new FileResource(f);
       String mysub = fr.asString();
      // System.out.println(sub.length());
      String sub=mysub.toLowerCase();
      StorageResource s1=findProtein(sub);
     
    System.out.println(" \nDna Strings found are:");
       for(String s2:s1.data())
     {
         //System.out.println("Strings are : "+s2);
        c=countCTG(s2);
       
       fcount= fcount+c;
      
      if(s2.length() > 60)
      {
        System.out.println(s2+" length is : "+ s2.length());
        count1=count1+1;   
      }
    
    
    
      cgratio=findCGRatio(s2);
    
       if(cgratio > 0.35)
       {
          System.out.println(s2+"   " +cgratio);
          count2=count2+1;
       }
       
       }
      System.out.println ("\n Total ctg count: " +fcount);
      System.out.println("\nTotal Strings are : "+s1.size());
     System.out.println("\nTotal gene more than 60 nucleotides := "+count1);
   // System.out.println("\nCGRatio higher than 0.35 Strings are ");
     System.out.println(" \nTotal strings with cgratio higher than 0.35 are : "+ count2);
    
        // System.out.println("ctg count: " +fcount);
       }
  }
  
   public double findCGRatio(String dna)
  {
      int length=dna.length();
     int cstart=0;
     int gstart=0;
     int count=0;
     
     
     while(true)
     {
       int cloc=dna.indexOf("c",cstart);
             
       if(cloc == -1)
       {
           break;
       }
        count=count+1;
       cstart=cloc+1;
      }
      while(true)
      {
        int gloc=dna.indexOf("g",gstart); 
                
       if(gloc == -1)
        {
           break;
        }
        count=count+1;
        gstart=gloc+1;
     }
     
     
       double average=(double)count/length;
      // System.out.println(average);
        return average;
    
     }
    
   
   public int countCTG(String dna)
   {   int start=0;
      int count=0;
        while(true)
        {
        int st=dna.indexOf("ctg",start);
        
          if(st == -1)
          {
              break;
        }else
        {
         count=count+1;
        }
        start=st+3; 
       }
       return count;
    }
   
}

