
/**
 * Write a description of wordplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class wordplay {

    public boolean isVowel(char ch) 
    {
        char c=Character.toLowerCase(ch);
        
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
          {
            return true;
          } 
        else
        {
           return false;
        }
        
    }
     
        public String replaceVowel(String s,char ch)
        {
        StringBuilder news=new StringBuilder(s);
            for(int k=0; k < news.length(); k++)
        {
            char c = news.charAt(k);
            if(isVowel(c)==true)
            {
              news.setCharAt(k,ch);
            }
        }
       return news.toString();
        
    }
    
    public String emphasize(String s,char ch)
    {
        char newch=Character.toLowerCase(ch);
        StringBuilder st=new StringBuilder(s);
        
        for(int i=0;i<st.length();i++)
        {
            
           char curchar=st.charAt(i);
           char newchar=Character.toLowerCase(curchar);
           if(newchar==newch)
           {
              
           
            if(i%2==0)
            {
               
               st.setCharAt(i,'*'); 
            }
            else 
            {
               
              st.setCharAt(i,'+');  
            }
          
        
    }
        
    }
    return st.toString();
}
     
    public void testing()
    {
       boolean ch=isVowel('O');
       if(ch==true)
       {
        System.out.println("yes it's vowel");
        }
        else
        {
          System.out.println("Sorry it's not vowel");   
        }
        String s=replaceVowel("ATHARVA",'*');
        System.out.println("new String is "+s );
        String mys=emphasize("Mary Bella Abracadabra", 'a');
        System.out.println("Emphasize string is "+mys);
    }
    
}
