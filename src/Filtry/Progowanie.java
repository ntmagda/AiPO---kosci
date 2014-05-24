package Filtry;

import marvin.gui.MarvinAttributesPanel;
import marvin.image.MarvinImage;
import marvin.image.MarvinImageMask;
import marvin.plugin.MarvinAbstractImagePlugin;
import marvin.statistic.MarvinHistogram;
import marvin.util.MarvinAttributes;

/**
 * Invert the pixels color.
 *
 * @author Gabriel Ambrosio Archanjo
 * @version 1.0 02/28/2008
 */

public class Progowanie extends MarvinAbstractImagePlugin {
    static int T1;
    static int T2;

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
       int LP = imageIn.getWidth()*imageIn.getHeight();


        int l_arrGray[] = new int[256];

        for (int x = 0; x < imageOut.getWidth(); x++) {
            for (int y = 0; y < imageOut.getHeight(); y++) {
                l_arrGray[imageOut.getIntComponent0(x, y)]++;
            }
        }
        
        int SU=0;
        for ( int i =0 ; i <255; i++)
        {
            SU=SU+i*l_arrGray[i];
        }
        System.out.println(SU);
        
        int W=0;
        int MAX =0; 
        int SUP = 0;
        
        int WP;
        int SG;
        int SD;
        int R;
        int T1;
        int T2;
        
        for ( int i = 0; i < 255; i ++)
        {
            W = W+l_arrGray[i];
            WP = LP - W;
            if(W==0|| WP==0)
                break;
            SUP = SUP+i*l_arrGray[i];           
            SG = SUP/W;
            SD = (SU - SUP)/WP;
            R = (int) (W*WP*Math.pow((SG-SD),2));
            
        if(R>=MAX)
        {
            T1 = i;
        }
        if(R>MAX)
        {
            T2 = i;
         System.out.println(T2);
        }
            MAX = R;
        }

    }
    int przedzial = (T1-T2)/2; 
    
    void Thresholding(MarvinImage imageIn,
            MarvinImage imageOut)
    {
     System.out.println(przedzial);
        
        for (int y = 0; y < imageIn.getHeight(); y++) {
            for (int x = 0; x < imageIn.getWidth(); x++) {

                if (imageIn.getIntComponent0(x, y) < przedzial) 
                {
                    imageOut.setIntColor(x, y, imageIn.getAlphaComponent(x, y), 0, 0, 0);
                } 
                else if(imageIn.getIntComponent0(x, y) > przedzial) 
                {
                    imageOut.setIntColor(x, y, imageIn.getAlphaComponent(x, y), 255, 255, 255);
                }
            }
    }
    }
    
  
}