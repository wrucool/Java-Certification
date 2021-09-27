
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;
import java.io.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
    
     public LogAnalyzer() 
     {
         records=new ArrayList<LogEntry>();
      }
        
     public void readFile(String filename) {
         // complete method
         FileResource f=new FileResource(filename);
         for(String line:f.lines())
         {
             LogEntry log=WebLogParser.parseEntry(line);
             records.add(log);
            
         }
     }
     
     public int countUniqueIPs()
     {
         ArrayList<String> uniqueIps=new ArrayList<String>();
           for (LogEntry le : records) 
           {
              
                String ipAddr = le.getIpAddress();
                if (!uniqueIps.contains(ipAddr))
                {
                     uniqueIps.add(ipAddr);
                     
                }
           }
         return uniqueIps.size(); 
     }
        
     public void printHighStatusCode(int num)
     {
         for(LogEntry le:records)
         {
            int stCode=le.getStatusCode();
            if(stCode>num)
            {
                System.out.println(le);
            }
         }
            
       }
       
      public void uniqueIPvisitsOnDay(String someday)
      {
           ArrayList<String> myIps=new ArrayList<String>();
             for(LogEntry le:records)
            {
               Date d=le.getAccessTime();
               String sub=d.toString();
               if(sub.contains(someday))
                {
                    String s=le.getIpAddress();
                   if(!myIps.contains(s))
                  {
                        myIps.add(s);
                     System.out.println(le);
                  
                 }
                }        
        }
        System.out.println("number of unique ip of days: "+myIps.size());
    }
        
    
    public int uniqueIPsInRange(int low,int high)
    {
       int count=0;
       ArrayList<String> IpsRange=new ArrayList<String>();
       for(LogEntry le:records)
         {
            int stCode=le.getStatusCode();
            if(low<=stCode && stCode<=high)
            {
                String s=le.getIpAddress();
                if(!IpsRange.contains(s))
                {
                    IpsRange.add(s);
                    count++;
                }
              
            }
        } 
        return count;
    }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
         
     }
     
     
}
