
import edu.duke.*;
import java.util.*;

public class GladLibHashMap {
	private HashMap<String,ArrayList<String>> myMap=new HashMap<String,ArrayList<String>>();
	//private HashMap<String,String> myLabelSource=new HashMap<String,String>();
	private Random myRandom;
	private HashMap<String,Integer>Map=new HashMap<String,Integer>();
	private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
	private static String dataSourceDirectory = "data";
	
	 int nsize=0;
	 
	public GladLibHashMap(){
		initializeFromSource(dataSourceDirectory);
		myRandom = new Random();
	}
	
	public GladLibHashMap(String source){
		initializeFromSource(source);
		myRandom = new Random();
	}
	
	private void initializeFromSource(String source) 
	{   
         String[] labels = {"country","noun", "animal",
                              "adjective","name","color",
                              "timeframe","verb","fruit"};
             for(String s : labels)
             {
                   ArrayList<String> list = readIt(source+"/"+s+".txt");
                   myMap.put(s, list);
             }
            
        }

	private String randomFrom(ArrayList<String> source)
	{
	    if(source!=null)
	    {
		int index = myRandom.nextInt(source.size());
		return source.get(index);
       }
       return "wrong";
	}
	
		private String getSubstitute(String label) 
		{
              if (label.equals("number"))
              {
                 return ""+myRandom.nextInt(50)+5;
              }
              
              return randomFrom(myMap.get(label));
       }
	
	private String processWord(String w){
		int first = w.indexOf("<");
		int last = w.indexOf(">",first);
		if (first == -1 || last == -1){
			return w;
		}
		String prefix = w.substring(0,first);
		String suffix = w.substring(last+1);
		String s=w.substring(first+1,last);
		String sub = getSubstitute(s);
		while(true)
		{ 
		    sub=sub.toLowerCase();
           if(Map.keySet().contains(sub))
           {
            Map.put(sub,Map.get(sub)+1);
            }
           else
            {
            Map.put(sub,1);
            nsize++;
            }
          
           break;
        }
         
       return prefix+sub+suffix;
	}
	
	private void printOut(String s, int lineWidth){
		int charsWritten = 0;
		for(String w : s.split("\\s+")){
			if (charsWritten + w.length() > lineWidth){
				System.out.println();
				charsWritten = 0;
			}
			System.out.print(w+" ");
			charsWritten += w.length() + 1;
		}
	}
	
	private String fromTemplate(String source){
		String story = "";
		if (source.startsWith("http")) {
			URLResource resource = new URLResource(source);
			for(String word : resource.words()){
				story = story + processWord(word) + " ";
			}
		}
		else {
			FileResource resource = new FileResource(source);
			for(String word : resource.words()){
				story = story + processWord(word) + " ";
			}
		}
		return story;
	}
	
	private ArrayList<String> readIt(String source){
		ArrayList<String> list = new ArrayList<String>();
		if (source.startsWith("http")) {
			URLResource resource = new URLResource(source);
			for(String line : resource.lines()){
				list.add(line);
			}
		}
		else {
			FileResource resource = new FileResource(source);
			for(String line : resource.lines()){
				list.add(line);
			}
		}
		return list;
	}
	
	public void totalWordsInMap()
	{ 
	    int sum=0;
	    HashMap <String,Integer>allWords=new HashMap<String,Integer>();
	     for(String s:Map.keySet())
	   {
	       if(!allWords.keySet().contains(s))
	       {
	          allWords.put(s,1);
	       }
	      sum=sum+allWords.size();
	   }
	   
	   System.out.println("total number of words are used: "+sum);
	   
    }
		
	public void makeStory(){
	    System.out.println("\n");
	     Map.clear();
	   
	    System.out.println("Number of words Replaced: "+nsize);
	    nsize=0;
	    String story = fromTemplate("data/madtemplate3.txt");
		
		printOut(story, 60);
		System.out.println("\n");
		totalWordsInMap();
		
	}
	


}
