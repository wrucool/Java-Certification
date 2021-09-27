

import edu.duke.*;
import java.io.*;
public class Findgene {
    public String findProtein(String dna)
    {
             
		int start = dna.indexOf("atg");
		if (start == -1) {
		   return "";
		}
		int stop1= dna.indexOf("tag", start+3);
		int stop2= dna.indexOf("tga", start+3);
		int stop3= dna.indexOf("taa", start+3);
		if ((stop1- start) % 3 == 0) {
		    System.out.println("tag");
			return dna.substring(start, stop1+3);
			 
		}
		else if((stop2- start) % 3 == 0) {
		    System.out.println("tga");
			return dna.substring(start, stop2+3);
			
		}
		else if((stop3- start) % 3 == 0) {
		    System.out.println("taa");
			return dna.substring(start, stop3+3);
			
		}else
		{
			return "";
		}
   
    }
   public void testing()
   {
		//String ap = "AATGCTAGTTTAAATCTGA";
		//String a=ap.toLowerCase();
		//String a="ataaactatgttttaaatgt";
		String a="acatgataacctag";
		//String ap = "atggggtttaaataataatag";
		String result = findProtein(a);
		if(result != null)
		{
			System.out.println("success for " + result + " length " + result.length());
         }	
       else {
			System.out.println("mistake for input: " + a);
			System.out.println("got: " + result);
			//System.out.println("not: " + ap);
		}
	}
	
	
	}


