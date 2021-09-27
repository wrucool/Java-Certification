
/**
 * Write a description of BabyNames here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
import org.apache.commons.csv.*;

public class BabyNames {
      public void totalBirths () {
        FileResource fr = new FileResource();
		int totalnames = 0;
		int Boysname = 0;
		int Girlsname = 0;
		for (CSVRecord rec :fr.getCSVParser(false)) {
			String s=rec.get(0);
			if(s!=null)
			{
			totalnames +=1;
			if (rec.get(1).equals("M")) {
				Boysname += 1;
			}
			else {
				Girlsname +=1;
			}
		}
       }
		System.out.println("total births = " + totalnames);
		System.out.println("female girls = " + Girlsname);
		System.out.println("male boys = " + Boysname);
	}

	public int getRank(int yr,String name,String gender)
	{  
	    int rank=0;
	    int myrank=0;
	    FileResource fr=new FileResource();
	     for(CSVRecord rec:fr.getCSVParser(false))
	    {
	     
	     
	       if(rec.get(1).equals(gender))
        {
           rank = rank+1;
        
        if(rec.get(0).equals(name))
	     {
	     System.out.println("Rank for given name in year is "+ rank);
	    }
       
       }
      else
      {
          rank=-1;
        }
    }
   // System.out.println("Rank for given name in year is "+ rank);
   return rank;
   }
   
   public void getName(int yr,int myrank,String gender)
	{  
	        
	     FileResource fr=new FileResource();
	     int rank=0;
	    
	     for(CSVRecord rec:fr.getCSVParser(false))
	    {
	     
	       if(rec.get(1).equals(gender))
         {
            rank = rank+1;
           if(rank == myrank)
	     {
	      System.out.println("Name for given rank in year is "+rec.get(0));   
	     
	      }
	   }
	    
      }
    }
    
   
   
   public void testTotalBirths () {
		//FileResource fr = new FileResource();
	    //totalBirths();
		int myrank=getRank(1971,"Frank","M");
		
		//getName(2014,24,"F");
		//getName(1982,450,"M");
	}
	
	public void whatIsNameInYear(String name,int yr,int newyr,String gender)
	{
	  String newname= "";
	  int value=0;
	 DirectoryResource dr=new DirectoryResource();
	 for(File f:dr.selectedFiles())
	 {
   
     int rank=0;
	 int myrank=0;
	 int myyr=0;
	 
	  String fname=f.getName();
       String yrname=fname.substring(3,7);
       myyr=Integer.parseInt(yrname);
	  FileResource fr=new FileResource(f);
	  //System.out.println(myyr);
	for(CSVRecord rec:fr.getCSVParser(false))
	{
	 if(myyr==yr)
	   {
	   if(rec.get(1).equals(gender))
	  {
	       rank=rank+1;
	    if(rec.get(0).equals(name))
	     {
	     value=rank;
	    
	      }
	    } 
	   }    
	 if(myyr==newyr)
	 {
	     if(rec.get(1).equals(gender))
	     {
	         myrank=myrank+1;
	         if(value==myrank)
	         {
	           newname=rec.get(0);
	             
	         }
	     }
	   }  
        
    }
  }
  System.out.println(name+" born in "+yr+" would be "+ newname+" if she is born in " +newyr);
}

  
   public void testingNameyr()
  {
   
   whatIsNameInYear("Owen",1974,2014,"M"); 
   }
  
  
  
  
   
 public void yearOfHighestRank(String name,String gender)
 {
     int myrank=0;
      int yr=0;
      int myyr=0;
     DirectoryResource dr=new DirectoryResource();
      
     for(File f:dr.selectedFiles())
     {
        int value=0;
         int rank=0;
       FileResource fr=new FileResource(f);
       CSVParser cp=fr.getCSVParser(false);
       String fname=f.getName();
       String yrname=fname.substring(3,7);
       yr=Integer.parseInt(yrname);
      
       for(CSVRecord rec:cp)
	    {
	        if(rec.get(1).equals(gender))
        {
           rank = rank+1;
          if(rec.get(0).equals(name))
	      {
	       value=rank;
	      }   
         }
        }
       // System.out.println(value);
         if(myrank==0)
         {
             myrank=value;
            }
         else if (myrank > value)
            {
                myrank=value;
            }
            if(myrank==value)
            {
                if(myrank!=0)
                {
            //System.out.println(name+" is ranked "+myrank+" in year "+yr);
            myyr=yr;
          }
            } 
        
      
    } 
     System.out.println(name+" is ranked "+myrank+" in year "+myyr);
  }
    
 public void testHighRank()
  {
      yearOfHighestRank("Mich","M"); 
  }
   
 public void getAverageRank(String name,String gender)
 {
    
      double myrank=0;
       double count=0;
       double average=0;
     DirectoryResource dr=new DirectoryResource();
      
     for(File f:dr.selectedFiles())
     {
       
        int value=0;
       int rank=0;
       FileResource fr=new FileResource(f);
       CSVParser cp=fr.getCSVParser(false);
            
       for(CSVRecord rec:cp)
	    {
	        if(rec.get(1).equals(gender))
        {
           rank = rank+1;
          if(rec.get(0).equals(name))
	      {
	       value=rank;
	      }   
         }
        }
         if(value!=0)
         {
            myrank=myrank+value;
            count=count+1;
        }
           
      }
    average=myrank/count;
    System.out.println("Average rank of "+name+" is "+average);
    }
   
 public void testAverageRank()
    {
    // getAverageRank("Robert","M"); 
      getTotalBirthRankHigher(1990,"Emily","F");
    }
  
 public void  getTotalBirthRankHigher(int yr,String name,String gender)
 {
     
	 int value=0;
	 int myvalue=0;
	FileResource fr=new FileResource();
	for(CSVRecord rec:fr.getCSVParser(false))
	  {
	      
	   	  if(rec.get(1).equals(gender))
	        {
	            if(rec.get(0).equals(name))
	        {
	            break;
	        }
	        value=Integer.parseInt(rec.get(2));
	        myvalue=myvalue+value;
	        	       
	       
	       }
      }
   
    System.out.println("average="+myvalue);
  }
}

 



