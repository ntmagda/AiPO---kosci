/* R = Color.red(pixelColor)-Color.green(pixelColor);
                G = Color.red(pixelColor)-Color.green(pixelColor);
                B = Color.red(pixelColor)-Color.green(pixelColor);
                // set newly-inverted pixel to output image
                if(R<0)
                {
                    R=B=G=0;
                }
                else if(R>255)
                {
                    R=B=G=255;
                }


                if(R>30 && G>30 && B>30)
                {
                    R=G=B=255;
                }
                if(R<30 && G<30 && B<30)
                {
                    R=G=B=0;
                }
                bmOut.setPixel(x, y, Color.argb(A, R, G, B));
            }
        }*/


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Skora;

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
public class WykrywanieSkory1 extends MarvinAbstractImagePlugin {

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
        for (int x = 0; x < imageIn.getWidth(); x++) {
            for (int y = 0; y < imageIn.getHeight(); y++) {
                r = ((int) imageIn.getIntComponent0(x, y));
                g = ((int) imageIn.getIntComponent1(x, y));
                b = ((int) imageIn.getIntComponent2(x, y));
                int R=r-g;
                int G =R;
                int B = R;
                
                
                if(R<0)
                {
                    R=B=G=0;
                }
                else if(R>255)
                {
                    R=B=G=255;
                }
                imageOut.setIntColor(x, y, R, G, B);
            }
        }
    }
}