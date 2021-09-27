import edu.duke.*;
import java.lang.String;

public class CaesarCipher {
    public String encrypt(String input,int key1,int key2)
    {
        String alphabet= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       
        StringBuilder encrypted = new StringBuilder(input); 
        
       String shiftalpha1 = alphabet.substring(key1)+
        alphabet.substring(0,key1);
        String shiftalpha2 = alphabet.substring(key2)+
        alphabet.substring(0,key2);
        
        for(int i = 0; i < encrypted.length(); i++) {
            
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
   
    
    public void testCaesar() {
        
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message,9,22);
        System.out.println(encrypted);
       String decrypted = encrypt(encrypted,17,4);
        System.out.println(decrypted);
    }
}


