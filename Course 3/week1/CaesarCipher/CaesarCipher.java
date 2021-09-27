package CaesarCipher;

import edu.duke.*;

public class CaesarCipher {
     private String alphabet;
    private String shiftalpha;
    private int theKey;
     public CaesarCipher(int key) {
         theKey=key;
         alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
         shiftalpha = alphabet.substring(key)+
                           alphabet.substring(0,key);
    }
    public String encrypt(String input, int key) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            char currChar=encrypted.charAt(i);
            char lowchar=currChar;
             if(Character.isLowerCase(currChar))
             {
              currChar=Character.toUpperCase(currChar);
            }
           
            int idx = alphabet.indexOf(currChar);
            
            if(idx != -1){
                
               
                char newChar1 = shiftalpha.charAt(idx);
                if(Character.isLowerCase(lowchar))
                {
                    newChar1=Character.toLowerCase(newChar1);
                }
                encrypted.setCharAt(i,newChar1);
                               
            }
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    
    public void testCaesar() {
        int key = 15;
       // FileResource fr = new FileResource();
        //String message = fr.asString();
        String encrypted = encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?", key);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);
    }
}

