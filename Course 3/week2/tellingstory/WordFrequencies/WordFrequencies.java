
import edu.duke.*;
import java.util.*;

public class WordFrequencies
{
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void findUnique(){
        FileResource resource = new FileResource();
        myWords.clear();
        myFreqs.clear();
        for(String s : resource.words()){
            s = s.toLowerCase();
                      
            int index = myWords.indexOf(s);
            if (index == -1){
                if(!myWords.contains(s))
                {
                myWords.add(s);
                }
                myFreqs.add(1);
            }
            else {
                int freq = myFreqs.get(index);
                myFreqs.set(index,freq+1);
            }
        }
    }
    
    
    
    
    public void tester(){
        findUnique();
        System.out.println("# unique words: "+myWords.size());
        int index = findMax();
        System.out.println("max Index:"+myWords.get(index)+"  "+myFreqs.get(index));
       
      /*  for (int k=0;k<myWords.size();k++)
        {
        System.out.println(myWords.get(k)+" "+myFreqs.get(k));
       }*/
    }
    
    public int findMax(){
        int max = myFreqs.get(0);
        int maxIndex = 0;
        for(int k=0; k < myFreqs.size(); k++){
            if (myFreqs.get(k) > max){
                max = myFreqs.get(k);
                maxIndex = k;
            }
            System.out.println(myWords.get(k)+"  "+myFreqs.get(k));
        }
       
        return maxIndex;
    }
}
