package CaesarCipher;
import edu.duke.*;


public class CaesarCracker {
     char mostCommon;
    
    public CaesarCracker() {
        mostCommon = 'e';
    }
    
    public CaesarCracker(char c) {
        mostCommon = c;
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
    
    public int getKey(String encrypted)
    {
          int[] freqs = countLetters(encrypted);
          int maxDex = maxIndex(freqs);
          int mostCpos=mostCommon-'a';
          int dkey = maxDex - mostCpos;
             if (maxDex < mostCpos)
         {
           dkey = 26 - (mostCpos-maxDex);
          }
          CaesarCipher cc=new CaesarCipher(dkey);
      return cc.encrypt(encrypted,dkey);
    }
    
    public void testDecrypt()
    {
       FileResource fr=new FileResource();
       String s=fr.asString();
       String encrypt=get
       System.out.println(et);
    }
 
}
