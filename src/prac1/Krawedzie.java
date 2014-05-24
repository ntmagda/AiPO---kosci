package prac1;

import marvin.gui.MarvinAttributesPanel;
import marvin.image.MarvinImage;
import marvin.image.MarvinImageMask;
import marvin.plugin.MarvinAbstractImagePlugin;
import marvin.util.MarvinAttributes;
import java.math.*;
import marvin.io.MarvinImageIO;
import org.jblas.DoubleMatrix;
import tools.BaseFrame1;
import Podstawowe.Grad;

public class Krawedzie extends MarvinAbstractImagePlugin {
    
     //Grad[][] tablicaGrad1;

    @Override
    public void load() {
    }

    @Override
    public MarvinAttributesPanel getAttributesPanel() {
        return null;
    }
    @Override
    public void process(
            MarvinImage imageIn,
            MarvinImage imageOut,
            MarvinAttributes attributesOut,
            MarvinImageMask mask,
            boolean previewMode) {
        
    Grad[][] tablicaGrad1 = new Grad[imageIn.getWidth()][imageIn.getHeight()];
       tablicaGrad1=(Grad[][]) getAttribute("tablicaGrad1");
        
        DoubleMatrix kasowanie = new DoubleMatrix(imageIn.getWidth(), imageIn.getHeight());
        
        
        for (int x = 3; x < imageIn.getWidth()-3; x++) {
            for (int y = 3; y < imageIn.getHeight()-3; y++) {
                 
                //kolor zołty 0 stopni
                if(tablicaGrad1[x][y].kier==0)
                {
                    if(tablicaGrad1[x][y].wart<tablicaGrad1[x-1][y].wart ||
                       tablicaGrad1[x][y].wart<tablicaGrad1[x+1][y].wart)
                    {
                        kasowanie.put(x,y,1);
                    }
                    else
                    {
                        kasowanie.put(x,y,0);
                    }        
                }
                
                // kolor zielony 45 stopni
                if(tablicaGrad1[x][y].kier==45)
                {
                    if(tablicaGrad1[x][y].wart<tablicaGrad1[x+1][y-1].wart||
                            tablicaGrad1[x][y].wart<tablicaGrad1[x-1][y+1].wart)
                    {
                        kasowanie.put(x,y,1);
                    }
                    else
                    {
                        kasowanie.put(x,y,0);
                    }        
                }
                
                // kolor niebieski 90 stopni
                if(tablicaGrad1[x][y].kier==90)
                {
                    if(tablicaGrad1[x][y].wart<tablicaGrad1[x][y-1].wart||
                            tablicaGrad1[x][y].wart<tablicaGrad1[x][y+1].wart)
                    {
                        kasowanie.put(x,y,1);
                    }
                    
                    else
                    {
                        kasowanie.put(x,y,0);
                    }        
                }
                
                if(tablicaGrad1[x][y].kier==135)
                {
                    if(tablicaGrad1[x][y].wart<tablicaGrad1[x-1][y-1].wart||
                            tablicaGrad1[x][y].wart<tablicaGrad1[x+1][y+1].wart)
                    {
                        kasowanie.put(x,y,1);
                    }
                    else
                    {
                        kasowanie.put(x,y,0);
                    }        
                }
            }
        }
   
        for (int x = 3; x < imageIn.getWidth()-3; x++) {
            for (int y = 3; y < imageIn.getHeight()-3; y++) {
         
                if(!(kasowanie.get(x,y)==1))
                {
                    imageOut.setIntColor(x,y,0,0,0);
                }
                else
                {
                    if(tablicaGrad1[x][y].wart<40)
                    {
                        imageOut.setIntColor(x,y,0,0,0);
                    }
                    else if(tablicaGrad1[x][y].wart>80)
                    {
                        imageOut.setIntColor(x, y,255,255,255);
                    }
                }
            }
        }
        
    }
}