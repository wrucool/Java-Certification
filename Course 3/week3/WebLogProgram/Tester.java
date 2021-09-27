
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer la=new LogAnalyzer();
        System.out.println("All log entries are :");
        la.readFile("weblog2_log");
        la.printAll();
        int uniqueIP=la.countUniqueIPs();
        System.out.println("\nUnique IP's are "+uniqueIP);
        System.out.println("\nLog entries higher than given status code :");
        la.printHighStatusCode(400);
        LogAnalyzer le=new LogAnalyzer();
        le.readFile("weblog-short_log");
        System.out.println("\nLog Entries on given date :");
        la.uniqueIPvisitsOnDay("Sep 27");
        int count=la.uniqueIPsInRange(200,299);
         System.out.println("\nLog Entries between given status code range :"+count);
    }
}
