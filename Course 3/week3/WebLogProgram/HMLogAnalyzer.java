 import java.util.*;
import edu.duke.*;
import java.io.*;

public class HMLogAnalyzer {
 
    private ArrayList<LogEntry> records;
    
     public HMLogAnalyzer() 
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
     public HashMap<String,Integer> countsVisitsPerIp()
     {
         HashMap<String,Integer> counts=new HashMap<String,Integer>();
         for(LogEntry le:records)
         {
             String ip=le.getIpAddress();
             if(!counts.containsKey(ip))
             {
                 counts.put(ip,1);
             }
             else
             {
               counts.put(ip,counts.get(ip)+1);  
             }
            }
          return counts;
        }
        
     public int mostNumberVisitsByIp(HashMap<String,Integer> counts)
      {
            int max=0;
            for(String s:counts.keySet())
            {
            if(max < counts.get(s))
            {
                max=counts.get(s);
            }
           }
            return max;
      }
     
     public ArrayList<String> ipMostVisits(HashMap<String,Integer> counts)
      {
          int max=mostNumberVisitsByIp(counts);
          ArrayList<String> myIps=new ArrayList<String>();
          for(String s:counts.keySet())
          {
              if(counts.get(s)==max)
              {
                myIps.add(s);  
              }
            }
            return myIps;
        }
        
     public HashMap<String,ArrayList<String>> iPsForDays()
     {
         HashMap<String,ArrayList<String>> data=new HashMap<String,ArrayList<String>>();
            
         for(LogEntry le:records)
         {
           Date d=le.getAccessTime();
           String mydate=d.toString();
           String ndate=mydate.substring(4,10);
          // System.out.println(ndate);
          String ip=le.getIpAddress();
          if(!data.containsKey(ndate))
        {
          ArrayList<String> dayIp=new ArrayList<String>();    
          dayIp.add(ip);
          data.put(ndate,dayIp);
        }
        else
        {
          ArrayList<String> newIp=data.get(ndate);
          newIp.add(ip);
          data.put(ndate,newIp);
        }
       
      }
        return data;
    }
    
    public String dayWithMostIpVisits(HashMap<String,ArrayList<String>> data)
    {
      int max=0;
      
      for(String s:data.keySet())
      {
          int newmax=data.get(s).size();
          if(newmax>max)
          {
            max=newmax; 
          }
      }
      for(String s:data.keySet())
      {
          if(data.get(s).size()==max)
          {
              return s;
            }
        }
      
      return "";
    }
    
    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String,ArrayList<String>> data,String date)
    {
      HashMap<String,Integer> myIps=new HashMap<String,Integer>();  
      ArrayList<String> allIps=new ArrayList<String>();
        for(String s:data.keySet())
       {
         if(s.equals(date))
         {
            allIps=data.get(s);
         }
        }
        for(String ip:allIps)
        {
           if(!myIps.containsKey(ip))
          {
            myIps.put(ip,1);
          }
          else
          {
              myIps.put(ip,myIps.get(ip)+1);
           }
        }
        ArrayList<String> ipVisits=ipMostVisits(myIps);
        return ipVisits;
      }
 }
     
    




    
    
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
