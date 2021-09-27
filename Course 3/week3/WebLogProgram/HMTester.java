
/**
 * Write a description of HMTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class HMTester {
    public void testHMLogAnalyzer()
    {
    HMLogAnalyzer hml=new HMLogAnalyzer();
    hml.readFile("weblog2_log");
    HashMap<String,Integer> counts=hml.countsVisitsPerIp();
    System.out.println("countsVisitsPerIp:"+counts);
   int max= hml.mostNumberVisitsByIp(counts);
    System.out.println("\nMax number of Ip Address is(mostNumberVisitsByIp) :"+max);
    ArrayList<String> myIps=hml.ipMostVisits(counts);
    System.out.println("\nAll most visits Ips are(ipMostVisits) :"+myIps);
    HashMap<String,ArrayList<String>> data=hml.iPsForDays();
    System.out.println("\nmy data(iPsForDays) :"+data);
    String myIp=hml.dayWithMostIpVisits(data);
    System.out.println("\n A day with most Ip visits is(dayWithMostIpVisits) :"+myIp);
    ArrayList<String> ipVisits= hml.iPsWithMostVisitsOnDay(data,"Sep 29");
    System.out.println("\nMost Visit Ip's on given date(iPsWithMostVisitsOnDay) :"+ipVisits);
   }
}
