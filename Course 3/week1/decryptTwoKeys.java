

import edu.duke.*;
import java.lang.String;

public class decryptTwoKeys {
    
    
    public String encrypt(String input,int key1,int key2)
    {
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       String shiftalpha1 = alphabet.substring(key1)+
        alphabet.substring(0,key1);
        String shiftalpha2 = alphabet.substring(key2)+
        alphabet.substring(0,key2);
      StringBuilder encrypted = new StringBuilder(input); 
      for(int i = 0; i < encrypted.length(); i++)
      {
           char currChar=encrypted.charAt(i);
            char lowchar=currChar;
             if(Character.isLowerCase(currChar))
             {
              currChar=Character.toUpperCase(currChar);
            }
           
           int idx = alphabet.indexOf(currChar);
            
            if(idx != -1){
                if(i%2==0)
                {
                char newChar1 = shiftalpha1.charAt(idx);
                if(Character.isLowerCase(lowchar))
                {
                    newChar1=Character.toLowerCase(newChar1);
                }
                encrypted.setCharAt(i,newChar1);
               }             
                else
                {
                char newChar2 = shiftalpha2.charAt(idx);
               if(Character.isLowerCase(lowchar))
                {
                    newChar2=Character.toLowerCase(newChar2);
                }
                encrypted.setCharAt(i, newChar2);
               }
            }
        
            }
         
       return encrypted.toString();
      
    }
    
    public int[] countLetters(String input)
    {
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
          for(int k=0; k < input.length(); k++)
          {
           char ch = Character.toLowerCase(input.charAt(k));
          int dex = alph.indexOf(ch);
         
           if (dex != -1)
           {
             counts[dex] += 1;
             //System.out.println(ch+ "  "+counts[dex]);
           }
            
        }
       
        return counts;
    }
    
    public int maxIndex(int[] vals)
    {
       int maxDex = 0;
      for(int k=0; k < vals.length; k++)
      {
       if (vals[k] > vals[maxDex])
       {
         maxDex = k;
       }
      }
     
      return maxDex;
    }
    
    public void decrypt()
    {
           //decryptTwoKeys cc = new decryptTwoKeys();
         FileResource fr = new FileResource();
          String  encrypted= fr.asString();
          
           int[] freqs = countLetters(encrypted);
          int maxDex = maxIndex(freqs);
         
         int dkey = maxDex - 4;
             if (maxDex < 4)
         {
           dkey = 26 - (4-maxDex);
          }
          String decrypt=encrypt(encrypted,26-maxDex,26-dkey);
          System.out.println(decrypt);
         
    }
}

   
    






