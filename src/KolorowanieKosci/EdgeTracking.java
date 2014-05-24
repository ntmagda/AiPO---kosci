package KolorowanieKosci;

import marvin.gui.MarvinAttributesPanel;
import marvin.image.MarvinImage;
import marvin.image.MarvinImageMask;
import marvin.plugin.MarvinAbstractImagePlugin;
import marvin.util.MarvinAttributes;

/**
 * Invert the pixels color.
 *
 * @author Gabriel Ambrosio Archanjo
 * @version 1.0 02/28/2008
 */
public class EdgeTracking extends MarvinAbstractImagePlugin {

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
        int r, g, b;
        for (int x = 2; x < imageIn.getWidth()-2; x++) {
            for (int y = 2; y < imageIn.getHeight()-2; y++) {
                
                    if(imageIn.getIntComponent0(x, y)!=0 && // rozne niz czarny
                       imageIn.getIntComponent0(x, y)!=255) // rozne niz bialy
                    {
                        
                        check1:
                        for( int i = x-1, k = 0; k <3;k++,i++)
                        {
                            for ( int j = y-1,l=0; l <3; l++,j++)
                            {
                            
                                if(imageIn.getIntComponent0(i, j)==255)
                                {
                                    imageOut.setIntColor(x, y, 255,255,255);
                                    break check1;
                                }
                                                                
                                else
                                {
                                    for( int ii = x-2,m=0; m <5;m++,ii++)
                                     {
                                        for ( int jj = y-2,n=0; n <5; n++,jj++)
                                        {
                                            if(imageIn.getIntComponent0(i, j)==255)// czy znajdzie bialy?
                                                
                                                 {
                                                    imageOut.setIntColor(x, y, 255,255,255);
                                                    break check1;
                                                 }
                                                 else
                                            {
                                                imageOut.setIntColor(x,y,0,0,0);
                                            }
                                         }
                                    
                                    
                                      }
                                }
                         }
                  }
             }
        }
     }

     
            }
        }