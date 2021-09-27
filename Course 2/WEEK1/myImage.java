import edu.duke.*;
import java.io.*;

public class myImage {
    public ImageResource grayimage(ImageResource Inimage)
           {
             ImageResource outimage = new ImageResource(Inimage.getWidth(),Inimage.getHeight());
             for(Pixel p : outimage.pixels())
             {
                Pixel inp=Inimage.getPixel(p.getX(),p.getY());
                int avarage=(inp.getRed()+inp.getBlue()+inp.getGreen())/3;
                p.setRed(avarage);
                 p.setGreen(avarage);
                  p.setBlue(avarage);
            }
            return outimage;
        }
    public void testgray()
    {
        DirectoryResource dr=new DirectoryResource();
        for(File f:dr.selectedFiles())
        {
        ImageResource iname=new ImageResource(f);
        ImageResource gray=grayimage(iname);
        String fname=iname.getFileName();
        String nfname="copy-"+fname;
        iname.setFileName(nfname);
        gray.draw();
        iname.save();
        }
        
    }
    }