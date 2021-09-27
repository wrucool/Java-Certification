import edu.duke.*;

public class wordLength {

    public void countWordLengths(FileResource fr,int []counts)
    {
        for(String word : fr.words())
        {
          int wordlength = word.length(); 
        if(Character.isLetter(word.charAt(wordlength-1))==false)
        {
            wordlength--;
        }
        if (wordlength >= counts.length) 
        {  	    	   
          wordlength = counts.length - 1;  	  	
        }  	
        if (wordlength > 0 )
        {  	   	   
          counts[wordlength] ++;  	
          System.out.println(word+ "\t"+wordlength);
        }
       
      }
      
    }
   public int indexOfMax(int[] counts)
   {
       int max=0;
       for(int k=0;k<counts.length;k++)
      {
          
          if(counts[k]!=0)
          {
             
             if(counts[k]>max)
             {
                max=counts[k];
             }
             
              System.out.println(k+" words length "+counts[k]);
           }
        
      } 
        return max;
    }
   

       
    public void testCountWordLength()
    {
     FileResource fr = new FileResource("manywords.txt");
     int[] counts=new int[31];
     countWordLengths(fr,counts);
    int max=indexOfMax(counts);
    System.out.println("Most common word length in file is "+max);
    }
        
    }

