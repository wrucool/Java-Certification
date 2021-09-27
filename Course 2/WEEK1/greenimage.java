
import edu.duke.*;
import java.io.*;

public class greenimage {
     public ImageResource makegreen(ImageResource ir)
     {
       ImageResource or=new ImageResource(ir.getWidth(),ir.getHeight());
       for(Pixel p:or.pixels())
       {
           Pixel pr= ir.getPixel(p.getX(),p.getY());
          int g= pr.getGreen();
           p.setRed(g);
           p.setBlue(g);
       }
        return or; 
     }

     public void testred()
     {
         ImageResource ired=new ImageResource();
        ImageResource red=makegreen(ired);
        red.draw();
     }
    }     
