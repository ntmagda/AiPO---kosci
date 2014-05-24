package KolorowanieKosci;

import marvin.gui.MarvinAttributesPanel;
import marvin.image.MarvinImage;
import marvin.image.MarvinImageMask;
import marvin.plugin.MarvinAbstractImagePlugin;
import marvin.util.MarvinAttributes;
import org.jblas.DoubleMatrix;

/**
 * Invert the pixels color.
 *
 * @author Gabriel Ambrosio Archanjo
 * @version 1.0 02/28/2008
 */
public class Dylacja extends MarvinAbstractImagePlugin {

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
      int [][] SE = 
         {{255,255,255},
          {255,255,255},
          {255,255,255}};
        
      DoubleMatrix tablica = new DoubleMatrix(imageIn.getWidth(),imageIn.getHeight());  
      
        for (int x = 2; x < imageIn.getWidth()-2; x++) {
            for (int y = 2; y < imageIn.getHeight()-2; y++) {
        
                for (int i = x-1, k =0; k<3; i++,k++)
                {
                    for ( int j =y-1, l =0; l <3; j++,l++ )
                    {
                        if(SE[k][l]==(int)imageIn.getIntComponent0(i, j))
                        {
                           // imageOut.setIntColor(x, y, 255,255,255);
                            tablica.put(x,y,1);
                            break;
                        }      
                    }
                }               
            }
        }
        
            for (int x = 2; x < imageIn.getWidth()-2; x++) {
                for (int y = 2; y < imageIn.getHeight()-2; y++) {
            
                    if(tablica.get(x,y)==1)
                    {
                        imageOut.setIntColor(x, y, 255,255,255);
                
                    }
                 }
            }
    }
}