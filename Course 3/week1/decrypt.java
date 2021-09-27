


import edu.duke.*;
import java.lang.String;

public class decrypt {
    public String encrypt(String input,int key)
    {
        String alphabet= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       
        StringBuilder encrypted = new StringBuilder(input); 
        
       String shiftalpha = alphabet.substring(key)+
        alphabet.substring(0,key);
        
        for(int i = 0; i < encrypted.length(); i++) {
            
            char currChar=encrypted.charAt(i);
            char lowchar=currChar;
             if(Character.isLowerCase(currChar))
             {
              currChar=Character.toUpperCase(currChar);
            }
           
            int idx = alphabet.indexOf(currChar);
            
            if(idx != -1)
           {
             char newChar = shiftalpha.charAt(idx);
                if(Character.isLowerCase(lowchar))
                {
                    newChar=Character.toLowerCase(newChar);
                }
                encrypted.setCharAt(i,newChar);
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
      System.out.println("max "+maxDex);
      return maxDex;
    }
    
    public String decrypted(String encrypted)
    {
           decrypt cc=new decrypt();
           int[] freqs = countLetters(encrypted);
          int maxDex = maxIndex(freqs);
         /* int dkey = maxDex - 4;
             if (maxDex < 4)
         {
           dkey = 26 - (4-maxDex);
          }*/
      return cc.encrypt(encrypted,maxDex);
    }
    public void testDecrypt()
    {
        String decrypt=decrypted("Wzijk Cvxzfe");
        System.out.println(decrypt);
    }
 
}




    
