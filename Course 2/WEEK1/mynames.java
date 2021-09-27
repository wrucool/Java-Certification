import edu.duke.*;
import java.io.*;

public class mynames {
           public void names(){
               FileResource nm = new FileResource("animals.txt");
               for (String line : nm.words())
               {
                   System.out.println(line);
               }
            }
}
