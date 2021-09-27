
/**
 * Write a description of findLink here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class findLink {
    public StorageResource findURLs(String url) {
		URLResource page = new URLResource(url);
		String ms= page.asString();
		String source=ms.toLowerCase();
		StorageResource store = new StorageResource();
		int start = 0;
		
		
		while (true) {
			int index = source.indexOf("href=", start);
	
			if (index == -1) {
				break;
			}
			int firstQuote = index+6; // after href="
			int endQuote = source.indexOf("\"", firstQuote);
			String sub = source.substring(firstQuote,endQuote);
			if(sub.startsWith("http")||sub.startsWith("https"))
			{
             store.add(sub);
            }
			start = endQuote + 1;
        }  //if(sub.startsWith("http:"))
			   
			        
				
			return store;
		}
		
		public int countdot(String web)
		{
		    int st=0;
		    int count=0;
		  while(true){
			int loc=web.indexOf(".",st);
			 
			if(loc == -1)
			  {
			   break;
			 }
			 count=count+1;
			  st=loc+1;
             }
			return count;   
               
          }
           
		  
	

	public void testURL() {
		StorageResource s1 = findURLs("http://www.dukelearntoprogram.com/course2/data/newyorktimes.html");
		//StorageResource s2 = findURLs("http://www.doctorswithoutborders.org");
		 int count=0;
		  int fcount=0;
		   for (String link : s1.data()) {
		        System.out.println(link); 
		 
		 
		 count=countdot(link);
		 fcount=fcount+count;
		 
        }
        System.out.println("size = " + s1.size());
		System.out.println(" count :"+fcount);
    }
}
