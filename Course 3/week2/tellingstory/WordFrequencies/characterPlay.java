
/**
 * Write a description of characterPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

    import edu.duke.*;
import java.util.*;

public class characterPlay
{
    private ArrayList<String> myChar;
    private ArrayList<Integer> myCount;
    
    public characterPlay() {
        myChar = new ArrayList<String>();
        myCount = new ArrayList<Integer>();
    }
    
    public void findAllCharacter(){
        FileResource resource = new FileResource();
        myChar.clear();
        myCount.clear();
        for(String s : resource.lines())
        { 
             int wl=s.length();
             if(wl!=0)
             {
             int value=s.indexOf(".");
              if(value!=-1)
             {
               s=s.substring(0,value);
             }
            
               update(s);
            }
         }
        }
        
    public void update(String name)
    { 
        
        int index=myChar.indexOf(name);
              if(index==-1)
              {
              if(!myChar.contains(name))
              {
               myChar.add(name);
               }
               myCount.add(1);
              }
            else {
                int count = myCount.get(index);
                myCount.set(index,count+1);
            }
           
        }
    
    
    
    public void tester(){
        findAllCharacter();
        System.out.println("all lines are "+myChar.size());
        int index=findMax();
        for(int k=0;k<myCount.size();k++)
        {
          if(myCount.get(k)>10)
            {
            System.out.println(myChar.get(k)+" \t"+myCount.get(k));
            }   
        }
        System.out.println("Character within given Number of lines\n");
        characterWithNumPart(10,15);
        
        System.out.println("Main Charcter is: "+ myChar.get(index) +"    " +myCount.get(index)); 
    }
    
    public int findMax(){
        int max = myCount.get(0);
        int maxIndex = 0;
        for(int k=0; k < myCount.size(); k++)
        {
            
            if (myCount.get(k) > max){
                max = myCount.get(k);
                maxIndex = k;
            }
           
        }
       
        return maxIndex;
    }
    
   public void characterWithNumPart(int num1,int num2)
   {   
    for(int k=0;k<myCount.size();k++)
     {
       if(myCount.get(k)>=num1 && myCount.get(k)<num2)
       {
        System.out.println(myChar.get(k)+"   "+myCount.get(k));
        }
                   
    }
   }
}



