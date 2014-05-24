package Szum;

import marvin.gui.MarvinAttributesPanel;
import marvin.image.MarvinImage;
import marvin.image.MarvinImageMask;
import marvin.plugin.MarvinAbstractImagePlugin;
import marvin.util.MarvinAttributes;
import org.jblas.DoubleMatrix;
import java.math.*;
import java.util.Arrays;
/**
 * Invert the pixels color.
 *
 * @author Gabriel Ambrosio Archanjo
 * @version 1.0 02/28/2008
 */
public class Odszumianie extends MarvinAbstractImagePlugin {

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
    
    int mediana(int[] sasiedzi)
    {
        Arrays.sort(sasiedzi);
        return (sasiedzi[3]+sasiedzi[4])/2;
    }

    
    @Override
    public void process(
            MarvinImage imageIn,
            MarvinImage imageOut,
            MarvinAttributes attributesOut,
            MarvinImageMask mask,
            boolean previewMode) {
        
        

            int marginx = 2;
            int marginy = 2;

            for (int x = marginx; x < imageIn.getWidth()-marginx; x++) {
                for (int y = marginy; y < imageIn.getHeight()-marginy; y++) {                
                            int[] Red = new int[9];
                            int[] Green = new int[9];
                            int[] Blue = new int[9];
                            int l=0;
                  if((imageIn.getIntComponent0(x, y)==0 &&
                          imageIn.getIntComponent1(x, y)==0&& 
                          imageIn.getIntComponent2(x, y)==0)||(imageIn.getIntComponent0(x, y)==255 &&
                          imageIn.getIntComponent1(x, y)==255 &&
                          imageIn.getIntComponent2(x, y)==255)){
                            
                       for ( int i = x-1,k=0;i<x+2 ;i++,k++)
                       { 
                           for ( int j = y-1,m=0; j<y+2;j++,m++)        
                                {
                                         Red[l]=imageIn.getIntComponent0(i,j);
                                         Green[l]=imageIn.getIntComponent1(i,j);
                                         Blue[l]=imageIn.getIntComponent2(i,j);
                                         l++;
                                 
                                }
                       }                          
                      
                        imageOut.setIntColor(x,y, mediana(Red), mediana(Green), mediana(Blue));
                }
                }
            }
       
    }
    

}