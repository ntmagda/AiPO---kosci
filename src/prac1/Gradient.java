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

public class Gradient extends MarvinAbstractImagePlugin {
     static public Grad[][] tablicaGrad;

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
        

        tablicaGrad=(Grad[][]) getAttribute("tablicaGrad");
       /* for ( int x = 0; x <50; x++)
          for (int y =0 ; y <50 ;y++)
          {
        System.out.println(tablicaGrad[x][y].kier);
          }*/
        
        for (int x = 3; x < imageIn.getWidth()-3; x++) {
            for (int y = 3; y < imageIn.getHeight()-3; y++) {
                           
              if(imageIn.getIntComponent0(x, y)>20){
                double a = (Math.PI)/8;
                // kolor żółty dla pikseli o kierunku [0,22.5] i dla pikseli od [157.5,180]
                if((tablicaGrad[x][y].kier>=-8*a && tablicaGrad[x][y].kier<-7*a )||(tablicaGrad[x][y].kier>=-a && tablicaGrad[x][y].kier<a ) ||(tablicaGrad[x][y].kier>=7*a && tablicaGrad[x][y].kier<=8*a))
                {
                    imageOut.setIntColor(x,y,255, 255, 0);
                    tablicaGrad[x][y].kier=0;
                }
                else if((tablicaGrad[x][y].kier>=-7*a && tablicaGrad[x][y].kier<-5*a )|| (tablicaGrad[x][y].kier>=a && tablicaGrad[x][y].kier<3*a))
                {
                    imageOut.setIntColor(x,y,0, 255, 0);
                    tablicaGrad[x][y].kier=45;
                }
                else if((tablicaGrad[x][y].kier>=-5*a && tablicaGrad[x][y].kier<-3*a )||( tablicaGrad[x][y].kier>=3*a && tablicaGrad[x][y].kier<5*a))
                {
                   imageOut.setIntColor(x,y,0, 0, 255);
                    tablicaGrad[x][y].kier=90;
                }
                else if((tablicaGrad[x][y].kier>=-3*a && tablicaGrad[x][y].kier<-a )||( tablicaGrad[x][y].kier>=5*a && tablicaGrad[x][y].kier<7*a))
                {
                    imageOut.setIntColor(x,y,255, 0, 0);
                    tablicaGrad[x][y].kier=135;
                }
                          
              }
           }
        }
    }
}