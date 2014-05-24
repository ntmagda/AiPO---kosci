package Histogramy;

import marvin.gui.MarvinAttributesPanel;
import marvin.image.MarvinImage;
import marvin.image.MarvinImageMask;
import marvin.plugin.MarvinAbstractImagePlugin;
import marvin.util.MarvinAttributes;
import java.math.*;

/**
 * Invert the pixels color.
 *
 * @author Gabriel Ambrosio Archanjo
 * @version 1.0 02/28/2008
 */
public class Contrast extends MarvinAbstractImagePlugin {

    
    @Override
    public void load() {
    }

    @Override
    public MarvinAttributesPanel getAttributesPanel() {
        return null;
    }

    /**
     * Ta funkcja przetwarza zdjęcie jej kod należy zmieniać
     *
     * @param imageIn
     * @param imageOut
     * @param attributesOut
     * @param mask
     * @param previewMode
     */
    @Override
    public void process(
            MarvinImage imageIn,
            MarvinImage imageOut,
            MarvinAttributes attributesOut,
            MarvinImageMask mask,
            boolean previewMode) {
       double wsp = (double) getAttribute("wspolczynnik");
       for (int x = 0; x < imageIn.getWidth(); x++) {
            for (int y = 0; y < imageIn.getHeight(); y++) {
                double r = imageIn.getIntComponent0(x, y);
                double g = imageIn.getIntComponent1(x, y);
                double b = imageIn.getIntComponent2(x, y);
                
                if((wsp*(r-255/2)+255/2)<0){ r=0; }
                if((wsp*(g-255/2)+255/2)<0){ g=0; }
                if((wsp*(b-255/2)+255/2)<0) { b=0;}
                if((wsp*(r-255/2)+255/2)<255 &&  (wsp*(r-255/2)+255/2) >0)
                { r=wsp*(r-255/2)+255/2;}
                if((wsp*(g-255/2)+255/2)<255 &&  (wsp*(g-255/2)+255/2) >0)
                { g = wsp*(g-255/2)+255/2;}
                if((wsp*(b-255/2)+255/2)<255 &&  (wsp*(b-255/2)+255/2) >0)
                { b = wsp*(b-255/2)+255/2;}
                if((wsp*(r-255/2)+255/2)>255)
                { r = 255;}
                if((wsp*(g-255/2)+255/2)>255)
                { g = 255;}
                if((wsp*(b-255/2)+255/2)>255)
                { b=255;}
               
                boolean[][] maska = mask.getMaskArray();
               // if(maska[x][y]==true)
                {imageOut.setIntColor(x, y, (int)r, (int)g, (int)b);}          
          }
     }       
}         
}
            
        
    
