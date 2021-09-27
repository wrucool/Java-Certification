import java.util.*;
import edu.duke.*;
import java.io.*;

public class VigenereBreaker {
     
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        StringBuilder sb=new StringBuilder();
        for(int k=whichSlice;k<message.length();k+=totalSlices)
        {
            char ch=message.charAt(k);
            sb.append(ch);
        }
        
        return sb.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) 
    {
       int key[]=new int[klength];
       for(int i=0;i<klength;i++)
       {
        String slice=sliceString(encrypted,i,klength);
        
        CaesarCracker cc=new CaesarCracker(mostCommon);
         key[i]=cc.getKey(slice);
          //System.out.print(key[i]+"\t"); 
       }
          
       return key;
    }
    
    public HashSet<String> readDictionary(FileResource fr)
    {
        HashSet<String> dic=new HashSet<String>();
        for(String word:fr.lines())
        {
           dic.add(word.toLowerCase());  
        }
        return dic;
    }
    
    public char mostCommonCharIn(HashSet<String> dic)
    {
        HashMap<Character,Integer> myChar=new HashMap<Character,Integer>();
         int max=0;
         char mostCommon='\0';
        for(String word:dic)
        {
           //StringBuilder sb=new StringBuilder(word);
            for(int i=0;i<word.length();i++)
            {
               char c=word.charAt(i);
                if(!myChar.containsKey(c))
               {
                   myChar.put(c,1);
                }
                else
                {
                    myChar.put(c,myChar.get(c)+1);
                }
            }
        }
              
        for(char c:myChar.keySet())
        {
            int count=myChar.get(c);
            if(count>max)
            {
                max=count;
                mostCommon=c;
            }
        }
        return mostCommon;
    }
    
    public int countWords(String msg,HashSet<String> dic)
    {
        int count=0;
         
        for(String msgWord : msg.split("\\W"))
        {
           if(dic.contains(msgWord.toLowerCase()))
           {
               count++;
           }
        }
        return count;
    }
    
    public String breakForLanguage(String encrypted,HashSet<String> dic)
    {
       int max=0;
       int mykey=0;
       String newdecrypt="";
       for(int i=1;i<=100;i++)
       {
           char common=mostCommonCharIn(dic);
           
          int[] key = tryKeyLength(encrypted, i, common);
        
           VigenereCipher cc = new VigenereCipher(key);

           String decrypt= cc.decrypt(encrypted);
           int count=countWords(decrypt,dic);
           
          if(count>max)
          {
             max=count;
             newdecrypt=decrypt;
             mykey=i;
          }
        
       }
       System.out.println("File contain :"+max+" valid words with key "+mykey);
      
      return newdecrypt;
    }
    
    public String breakForAllLanguage(String encrypted,HashMap<String,HashSet<String>> mydata)
    {
        String decryptMsg="";
        for(String language:mydata.keySet())
        {
            HashSet<String> dic=mydata.get(language);
            System.out.println(language);
            decryptMsg=breakForLanguage(encrypted,dic);
            
        }
        
        return decryptMsg;
    }
    
    public void breakVigenere ()
    {
        //WRITE YOUR CODE HERE
        FileResource fr = new FileResource();
       String msg = fr.asString();
       HashMap<String,HashSet<String>> mydata=new HashMap<String,HashSet<String>>();
        DirectoryResource dr=new DirectoryResource();
        for(File f:dr.selectedFiles())
        {
            String fname=f.getName();
           FileResource fd=new FileResource(f);
          HashSet<String> set= readDictionary(fd);
          mydata.put(fname,set);
        }
          //String decrypt= breakForLanguage(msg,set);
        
     // System.out.println("most common char is: "+common);
       
          String decryptMsg=breakForAllLanguage(msg,mydata);
       
       System.out.println(decryptMsg);
        
    }
    
}
